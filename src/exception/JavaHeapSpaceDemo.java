package exception;

import java.nio.ByteBuffer;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        System.out.println("程序进来了");
        byte[] bytes = new byte[80 * 1024 * 1024];
    }
}
