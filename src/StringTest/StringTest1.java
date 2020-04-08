package StringTest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * string与其他的包装类的转化
 * @author DELL
 */
public class StringTest1 {

    /*
    调用包装类的静态方法，包装类的parseXXX();
    */
    @Test
    public void test1(){
        String string = "123.0";
        System.out.println(Float.parseFloat(string));

        int a = 123;
        System.out.println(String.valueOf(a).equals("123"));
    }

/*
* 与char[]数组转换。
* */
    @Test
    public void test2(){
        String string = "123abc";
        char[] chars = string.toCharArray();
        for ( char c: chars){
            System.out.println(c);
        }

        String s = new String(chars);
        System.out.println(s);

    }

    /*
    * 与byte[]数组的转化
    * */
    @Test
    public void test3(){
        String string = "abc123中国";
        //使用默认的字符集。utf-8；
        byte[] bytes = string.getBytes();
        System.out.println(Arrays.toString(bytes));

        try {
            byte[] gbks = string.getBytes("GBK");
            System.out.println(Arrays.toString(gbks));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



    }
}
