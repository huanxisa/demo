package StringTest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author DELL
 *
 * 缺点：
 * 日期类应该是不可变的，像日期类
 * Date查看构造器发现年份和日期都有偏移量
 * 格式化只有Date有
 * 非线程安全，不能处理闰秒。
 */
public class CalendarTest {

    @Test
    public void test1() {
        Calendar calendar = Calendar.getInstance();

        //常用方法。
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set();
        calendar.set(Calendar.DAY_OF_MONTH,22);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //getTime();转换为日历类
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime:Date转化为Calender
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

    }
}
