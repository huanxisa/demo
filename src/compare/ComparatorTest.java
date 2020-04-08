package compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author DELL
 *
 * 当元素类型没有实现Comparable接口，又不方便修改代码
 * 或者实现了Comparable接口，但规则不适合
 */
public class ComparatorTest {

    @Test
    public void Test(){
        String[] arr = new String[]{"aa","cc","ee","ff","ss"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
