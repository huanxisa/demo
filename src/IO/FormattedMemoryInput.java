package IO;

import java.io.*;

/**
 * @author DELL
 * 读取格式化的DataInputStream，这个面向字节的
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
           DataInputStream in = new DataInputStream( new ByteArrayInputStream(BufferedInputFile.read("F:\\ThinkOfJava\\src\\IO\\FormattedMemoryInput.java").getBytes()));
//          我认为这是正确读完的方法
           while (in.available() != 0) {
                 System.out.print((char) in.readByte());
           }
           in.close();
    }
}
