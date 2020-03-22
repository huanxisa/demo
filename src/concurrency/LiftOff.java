package concurrency;

/**
 * @author DELL
 *
 * 定义任务，实现Runnable接口，并实现run（）方法
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int testCount = 0;
    private final int id = testCount++;

    public LiftOff() {
    }

    public String status() {
        return "#"+ id + "("+(countDown > 0 ? countDown : "Liftoff")+")\n";
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
//            对线程调度器的一种建议，可以切换给其他任务执行
            Thread.yield();
        }
    }
}
