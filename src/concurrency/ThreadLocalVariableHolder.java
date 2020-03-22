package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author DELL
 * 防止冲突的第二种方式对于每一个线程都创建不同的存储
 */
public class ThreadLocalVariableHolder {
    /**这个初始化我实在是没看懂*/
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random rand = new Random(47);
        @Override
        protected synchronized Integer initialValue(){
            return rand.nextInt(10000);
        }
    };



    public static void increment() {
        value.set(value.get()+1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute( new Accessor(i));
            TimeUnit.SECONDS.sleep(3);
            exec.shutdown();
        }
    }
}

class Accessor implements Runnable{

    private final int id;

    Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#"+id+":"+ThreadLocalVariableHolder.get();
    }
}
