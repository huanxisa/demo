package IO;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {


    public static void main(String[] args) throws IOException {
//        这个称为从内存中输入，重点关注StringReader这个类
//      可以看到它的构造器是调用了其他类的运行后的输出的String。
//        所以是从内存中输入
        StringReader in = new StringReader(BufferedInputFile.read("F:\\ThinkOfJava\\src\\IO\\MemoryInput.java"));
        int c;
//        -1为read方法所设计。意味者读到流的结尾。
        while ((c = in.read()) != -1){
            System.out.print((char)c);
        }
    }
}
