package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author DELL
 */
public class DaemonFromFactory implements Runnable{
    @Override
    public void run() {
        try{
            while ( true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch( InterruptedException e){
            System.out.println("Interrupt");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //用来被重载为一个接受ThreadFactory对象
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
            System.out.println("All daemons started");
            TimeUnit.MILLISECONDS.sleep(500);
    }
}