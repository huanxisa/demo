package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author DELL
 * 调用sleep()是任务终止执行给定的时间。
 */
public class SleepTask extends LiftOff {
    @Override
    public void run(){
        try {
          while (countDown-- >0){
               System.out.println(status());
//              程序的重点就是这一句
               TimeUnit.MILLISECONDS.sleep(100);

          }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            exec.execute(new SleepTask());
        }
        exec.shutdown();
    }
}
