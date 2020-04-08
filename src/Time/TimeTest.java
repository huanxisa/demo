package Time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author DELL
 * localDate,localTime,localDateTime的使用
 */
public class TimeTest {
    @Test
    public void test(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：设置指定的年月日
        System.out.println(LocalDateTime.of(2020, 10, 1, 0, 0, 0));

        //getXXX()
        System.out.println(localDate.getDayOfMonth());

        //体现不可变性withXX();设置相关项
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //plusXX():加;minus():减。

    }
}
