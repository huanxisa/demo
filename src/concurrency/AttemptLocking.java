package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DELL
 * 给出了一个例子，解决特殊问题时显式的调用Lock对象更有效。
 */
public class AttemptLocking {
    //声明锁
    private ReentrantLock lock = new ReentrantLock();

    /**
     * 功能函数，无输出输入。
     * 作用为尝试获取锁，并且打印是否获取到锁。最后如果获得锁则将锁释放。
     * */
    public void untimed(){
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():" + captured);
        }finally {
            if( captured ) {
                lock.unlock();
            }
        }
    }
    /**
     * 这个函数我没看懂，jdk文档的翻译真的一言难尽。
     * */
    public void timed(){
        boolean captured = false;
        try{
            captured= lock.tryLock(2, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        try{
            System.out.println("tryLock(2, TimeUnit.SECONDS):"+captured);
        }finally {
            if(captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            { setDaemon(true);}
            @Override
            public void run(){
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }

}
