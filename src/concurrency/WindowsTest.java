package concurrency;

public class WindowsTest {
    public static void main(String[] args) {
        Windows3 windows3 = new Windows3();
        Thread t1 = new Thread(windows3);
        Thread t2 = new Thread(windows3);
        Thread t3 = new Thread(windows3);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Windows3 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
//            show();

            synchronized(this){
                if(ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖出票，票号：" + ticket);
                    ticket--;
                }
            }
        }
    }

    private synchronized void show() {

        if (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖出票，票号：" + ticket);
            ticket--;
        }
    }
}