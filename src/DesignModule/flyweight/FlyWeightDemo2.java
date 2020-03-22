package DesignModule.flyweight;
/**
 * 享元模式大幅度降低内存中对象的数量
 * 使系统更复杂，需要读取外部外部状态，使得运行时间变长
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyWeightDemo2 {
    public static void main(String[] args) {
        List<Character> compositeState = new ArrayList<Character>();
        compositeState.add('a');
        compositeState.add('b');
        compositeState.add('c');
        compositeState.add('a');
        System.out.println(compositeState);


        FlyweightFactory2 flyWeightFactory = new FlyweightFactory2();
        FlyWeight2 compositeFly1 = flyWeightFactory.factory(compositeState);
        compositeFly1.operation("state");

    }
}

//抽象享元角色
interface FlyWeight2 {
    void operation(String state);
}


/**
 * 具体享元角色类
 *
 * */
class ConcreteFlyWeight2 implements FlyWeight2{
    private Character intrinsicState = null;
    /**
     * 构造函数，内蕴状态作为参数传入
     *
     * */
    public ConcreteFlyWeight2(Character state) {
        this.intrinsicState = state;
    }

    /**
     * 外蕴状态作为参数传入方法中，改变方法的行为
     * 但是不改变对象的内蕴状态
     * */
    @Override

    public void operation(String state) {
        System.out.println("Intrinsic State ="+this.intrinsicState);
        System.out.println("Extrinsic State ="+state);
    }
}


/**
 * 复合享元角色
 */

class ConcreteCompositeFlyweight implements FlyWeight2{
    private Map<Character,FlyWeight2> files = new HashMap<Character, FlyWeight2>();

    public void add(Character key , FlyWeight2 flyWeight2){
        files.put(key,flyWeight2);
    }
    @Override
    public void operation(String state) {
        FlyWeight2 flyWeight2 = null;
        for (Object o : files.keySet()){
            flyWeight2 = files.get(o);
            flyWeight2.operation(state);

        }
    }
}

class FlyweightFactory2{
    private Map<Character,FlyWeight2> files = new HashMap<Character,FlyWeight2>();

    public FlyWeight2 factory(List<Character> compositeState){
        ConcreteCompositeFlyweight concreteCompositeFlyweight = new ConcreteCompositeFlyweight();
        for (Character state:compositeState){
            concreteCompositeFlyweight.add(state,this.factory(state));
        }
        return concreteCompositeFlyweight;
    }

    public  FlyWeight2 factory(Character state){
        FlyWeight2 flyWeight2 = files.get(state);
        if(flyWeight2 == null){
            //对象存在创建一个新的Flyweight
            flyWeight2 = new ConcreteFlyWeight2(state);
            files.put(state,flyWeight2);
        }
        return flyWeight2;
    }
}