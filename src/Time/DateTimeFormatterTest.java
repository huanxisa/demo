package Time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author DELL
 */
public class DateTimeFormatterTest {

    @Test
    public void test(){
        //方式一：
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime now = LocalDateTime.now();
        String str = formatter.format(now);
        System.out.println(now);
        System.out.println(str);

        //解析：字符串-->时间
        TemporalAccessor parse = formatter.parse("2020-04-07T08:59:36.825");
        //私有类，我觉得好像没有用。
        System.out.println(parse);

        //本地化相关的格式：如：ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        //格式化
        String string = formatter1.format(now);
        System.out.println(string);


        //自定义
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter2.format(LocalDateTime.now()));
        //解析
        TemporalAccessor parse1 = formatter2.parse("2020-04-07");
        System.out.println(parse);
    }
}
