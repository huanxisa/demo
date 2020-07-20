package exception;

import java.util.concurrent.TimeUnit;

public class StackOverFlowError {
    public static void main(String[] args) {
        stackOverFlow();
    }
    private static void stackOverFlow() {
        System.out.println("方法进来了");
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
