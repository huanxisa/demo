package concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author DELL
 * 展示了Executor如何管理Thread对象
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        //CachedThreadPool将会为每个任务创建一个线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //使用了有限的线程集来执行所提交的任务，可以一次性预先执行代价高昂的线程分配。
        //此外还有SingleThreadPool特点：线程数量为1，对于长期存活的任务是很有用的。若提交多个任务，这些任务将会排队
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5 ; i++) {
            executorService.execute(new LiftOff());
        }
        //可以防止新的任务提交给这个Executor
        executorService.shutdown();
    }
}
