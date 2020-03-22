package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author DELL
 * 如果希望线程有返回值，应该实现callable
 */
class TaskWithResult implements Callable{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult "+ id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
//            submit(）方法会产生Future对象，他用callable返回结果进行参数化，我可以用isDone方法来查询future是否完成，get()获取结果。
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs :results){
            try {
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}
