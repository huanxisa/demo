package container;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author DELL
 *
 * 主要展示Collection的接口的作用。
 */
public class CollectionTest {
    @Test
    public void Test1(){
        Collection collection = new ArrayList();

        collection.add(123);
        collection.add(456);
        collection.add(new String("method"));
        collection.add(false);
        collection.add(new Person("name",36));

        //contains包含
        System.out.println(collection.contains(123));
        System.out.println(collection.contains("method"));
        System.out.println(collection.contains(new Person("name", 36)));

        Collection collection1 = Arrays.asList(456, 123);
        //判断集合的包含
        collection.containsAll(collection1);
    }


    @Test
    public void test2(){
        Collection collection = new ArrayList();

        collection.add(123);
        collection.add(456);
        collection.add(new String("method"));
        collection.add(false);
        collection.add(new Person("name",36));

        //remove:存在返回值，移除成功true，一处失败false
        collection.remove(123);
        System.out.println(collection);

        //removeAll(Collection)
//        System.out.println(collection.removeAll(Arrays.asList(123, 456)));
//        System.out.println(collection);

        //equal()
        System.out.println(collection.equals(Arrays.asList(456, "method", false)));

    }

    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("method"));
        collection.add(false);
        collection.add(new Person("name",36));

        System.out.println(collection.hashCode());

        //转化为数组 数组转化为List要小心：asList使用包装类对象
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));

        //iterator 返回iterator实例
    }

}
