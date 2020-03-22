package concurrency;

import java.util.concurrent.BlockingQueue;

class LiftRunner implements Runnable{
    private BlockingQueue<LiftOff> rocket;

    public LiftRunner(BlockingQueue<LiftOff> rocket) {
        this.rocket = rocket;
    }

    public void add(LiftOff liftOff){
        rocket.add(liftOff);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                LiftOff liftOff = rocket.take();
                liftOff.run();
            }
        }catch (InterruptedException e){
            System.out.println("等待执行take()方法执行");
        }
        System.out.println("退出Lift的run()方法");
    }
}
public class TestBlockingQueues {
    }
