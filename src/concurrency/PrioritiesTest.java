package concurrency;

public class PrioritiesTest {
    public static void main(String[] args) {
        MyTheard1 theard1 = new MyTheard1();
        Thread thread = new Thread(theard1);
        thread.setPriority(7);
        thread.start();
    }
}

class MyTheard1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
    }
}
