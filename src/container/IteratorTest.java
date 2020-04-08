package container;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author DELL
 *
 * 遍历集合元素
 * hasNext()方法没有指针下移,next()包含两部操作，指针下移和返回值
 * 迭代器并非容器
 */
public class IteratorTest {

    @Test
    public void test(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("method"));
        collection.add(false);
        collection.add(new Person("name",36));

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //错误
//        while( (iterator.next()) != null){
//            iterator.next();
//        }
    }

    @Test
    public void test1(){
    //iterator可以删除集合中的元素。调用next()之前调用remove()会出现异常，连续调用两次remove()也会出现异常。
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("method"));
        collection.add(new String("method"));
        collection.add(false);
        collection.add(new Person("name",36));

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            if("method".equals(iterator.next())){
                iterator.remove();
            }
        }

        System.out.println(collection);

    }
}
