package Time;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 *
 * @author DELL
 * 类似于Date
 */
public class InstantTest {
    @Test
    public void test(){
        Instant instant = Instant.now();
        //获取本初子午线时间，需要加上偏移量。
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取intant-->毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //毫秒数-->intant
        System.out.println(Instant.ofEpochMilli(milli));
    }
}
