package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @author DELL
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return  t;
    }
}
