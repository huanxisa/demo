package compare;

import org.junit.Test;

import java.util.Arrays;

public class CompareTest {

    @Test
    public void test(){
        Good[] goods = new Good[] {
            new Good("大", 3D),
            new Good("小", 1D),
            new Good("中", 2D)
        };


        Arrays.sort(goods);

        System.out.println(Arrays.toString(goods));

    }
}

