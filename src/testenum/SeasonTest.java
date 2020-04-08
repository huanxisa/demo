package testenum;

import org.junit.Test;

public class SeasonTest {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        System.out.println(season);
    }
    @Test
    public void test(){
        for (SeasonEnum s:SeasonEnum.values()){
            System.out.println(s+" "+s.ordinal());
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());

        }

        for (String s:"SPRING SUMMER AUTUMN".split(" ")){
            SeasonEnum s2 = Enum.valueOf(SeasonEnum.class,s);
            System.out.println(s2);
        }
    }
}
