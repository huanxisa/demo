package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * synchronized(object) 对象同步时，这个对象所有的synchronized方法和synchronized区都不能同步
 * */
abstract class PairManager {
    /**首先这个元素是书写是原子性的*/
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair pair= new Pair();

}
