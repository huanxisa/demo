package IO.file;

import org.junit.Test;

import java.io.*;


/**
 * @author DELL
 *
 * 视频，图片不是字符流，
 */
public class FileWriterReaderTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");
        //注意这个是指在工程路径下 F:\git_repository\ThinkOfJava\hello.txt
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            //1.提供具体的流
            fr = new FileReader(file);
            //读完后返回-1
            int read;
            while ((read = fr.read()) != -1) {
                System.out.print((char) read);
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

    @Test
    public void test1(){
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            //1.提供具体的流
            fr = new FileReader(file);
            int len;
            char[] reads = new char[5];
            //读入
            while ((len = fr.read(reads)) != -1) {
                for (int i =0 ; i < len; i++) {
                    System.out.print(reads[i]);
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

    /**
     * 文件创建会自动进行
     *
     * */
    @Test
    public void test3() {
        //1,提供File类对象
        FileWriter fileWriter = null;
        try {
            File file = new File("hello.txt");
            //2提供流对象。
            fileWriter = new FileWriter(file,true);
            //3,执行写入操作
            //这个会覆盖文件
            fileWriter.write("I have a dream//n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //4,关闭流

    }
}
