package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author DELL
 * 演示优先级
 */
public class SimplePriorities implements Runnable{
    private int countDown = 5;
    //不会进行任何编译优化
    private volatile double d;

    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        //
        return Thread.currentThread()+ ":" + countDown;
    }

    @Override
    public void run() {
//        关键句
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 1; i <10000 ; i++) {
                d +=(Math.PI+Math.E) / (double) i;
                if(i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown==0)
                return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
            exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
            exec.shutdown();
    }
}
