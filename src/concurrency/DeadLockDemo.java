package concurrency;

import java.util.concurrent.TimeUnit;

class ShareData {
    private String lockA;
    private String lockB;

    ShareData(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void theardA() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "获得A的资源");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获得B的资源");
            }
        }
    }

    public void theardB()  {
        synchronized (lockB) {
            System.out.println(Thread.currentThread().getName() + "获得B的资源");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "获得A的资源");
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String a = "LOCKA";
        String b = "LOCKB";
        new Thread(() -> {
            new ShareData(a, b).theardA();
        }, "AAA").start();
        new Thread(() -> {
            new ShareData(a, b).theardB();
        }, "BBB").start();
    }
}
//jps 查看所有java线程，jstack-进程号。