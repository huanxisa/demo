package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {

//      注意学习这一部分的时候要理清楚这些类（1）作用，（2）明白他们如何初始化，（3）常用方法
        BufferedReader in = new BufferedReader(new FileReader(filename));

        String s;
        StringBuilder stringBuilder = new StringBuilder();
        while ((s = in.readLine()) != null){
            stringBuilder.append( s+"\n" );
        }

        in.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("F:\\ThinkOfJava\\src\\IO\\BufferedInputFile\\BufferedInputFile.java"));
    }
}
