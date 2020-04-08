package StringTest;

import org.junit.Test;

public class StringTest {
    @Test
    public void test1(){
        String s1 = "helloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0)+s1.charAt(9));

//        s1 = "";
        System.out.println(s1.isEmpty());
        String s2 = s1.toLowerCase();
        System.out.println(s2);

        //去除首尾空格
        String s3 = "   hello   world".trim();
        System.out.println(s3);

        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(s1.concat(s2));

        System.out.println(s1.compareTo(s2));
        //左闭右开。
        System.out.println(s1.substring(4, 6));
    }

    @Test
    public void test2(){
        String s1 = "helloWorld";
        System.out.println(s1.endsWith("ld"));

        System.out.println(s1.startsWith("He"));

        System.out.println(s1.startsWith("ll", 2));

        System.out.println(s1.contains("or"));

        System.out.println(s1.indexOf("lo",5));

        System.out.println(s1.lastIndexOf("l"));
    }
    @Test
    public void test3(){
        String str1 = "helloWorld";

        System.out.println(str1.replace('l', 'a'));

        String str2 = "123456";

        for (String s:str2.split("3")){
            System.out.println(s);
        }
    }
}
