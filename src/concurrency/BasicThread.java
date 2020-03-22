package concurrency;

/**
 * @author DELL
 * 将runable对象转变为工作任务的传统方式是将它提交给Thread对象
 */
public class BasicThread {
    public static void main(String[] args) {
        //将Runnable对象传给Thread类
        Thread t = new Thread(new LiftOff());
        t.start();
        //这个方法完成之后，线程依旧存在。
        System.out.println("Waiting for LiftOff");
    }
}
