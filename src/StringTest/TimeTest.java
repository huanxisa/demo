package StringTest;

import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 主要展示java.sql.Date类
 * 另外一个由于过时所以不再使用。
 * system.currentTimeMillis();
 * java.util.date
 *  |--java.sql.date
 * */
public class TimeTest {
    @Test
    public void test1(){
        Date date1 = new Date(89461691984L);
        System.out.println(date1.getTime());
    }

/*
* SimepleDateFormate
* 格式化
* 解析
* */
    @Test
    public void test2() throws ParseException {
        //实例化，构造器可以规定格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        //格式化
        java.util.Date date = new java.util.Date();
        System.out.println(sdf.format(date));

        //解析
        String str = "2020-04-09 12:52:96";
        System.out.println(sdf.parse(str));;
    }
}
