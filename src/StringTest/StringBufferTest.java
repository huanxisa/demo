package StringTest;

import org.junit.Test;

/*
* string:不可变，使用char[]数组存储
* StringBuffer：可变，效率低，线程安全。使用char[]数组存储
* StringBuilder：可变，效率高，线程不安全，使用char[]数组存储,容纳长度为字符串+16，后面每次扩容为前一次的*2+16。
* 有一个以容量为参数的构造器，使得后面扩容不频繁。
* 效率StringBuilder>StringBuffer>String
* */
public class StringBufferTest {


    @Test
    public void test1(){
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.setCharAt(1,'d');
        System.out.println(stringBuffer);
    }
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
//        s1.delete(2,4);
//        s1.replace(3,5,"hello");
//        s1.insert(2,"dafda");
        System.out.println(s1);
//        System.out.println(s1.reverse());
        System.out.println(s1.charAt(4));
    }
}
