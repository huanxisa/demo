package concurrency;

public class ThreadTest extends Thread{
    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程1");
        //一个对象线程只能启动一次。
        myThread.start();
        System.out.println(myThread.isAlive());

        //join() 方法，阻塞自己，调用者先执行
//        try {
//            myThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程调用完毕");
        System.out.println(myThread.isAlive());


    }
}
class MyThread extends Thread{
    @Override
    public void run (){
        System.out.println("线程");
        //测试常用方法。
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("666");
        System.out.println(Thread.currentThread().getName());

    }

    public MyThread(String name) {
        super(name);
    }
}