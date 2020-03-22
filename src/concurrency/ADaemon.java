package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author DELL
 */
public class ADaemon{



    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonsDontRunFinally());
//        由于后台进程的原因，进程会因为主进程的终止而终止，所以可能finally子句不会执行
        t.setDaemon(true);
        t.start();

    }
}
class DaemonsDontRunFinally implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("Start ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println("Exiting via InterruptException");
        }finally {
            System.out.println("This should always run?");
        }
    }
}