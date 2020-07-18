package IO.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInputOutputStreamTest {

    @Test
    public void test(){
       FileInputStream fr = null;
        try {
            File file = new File("hello.txt");
            //1.提供具体的流
            fr = new FileInputStream(file);
            int len;
            byte[] reads = new byte[5];
            //读入
            while ((len = fr.read(reads)) != -1) {
                for (int i =0 ; i < len; i++) {
                    System.out.print((char) reads[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
