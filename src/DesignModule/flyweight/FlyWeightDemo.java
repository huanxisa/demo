package DesignModule.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightDemo {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight flyWeight = factory.factory(new Character('a'));
        flyWeight.operation("first call");

        flyWeight = factory .factory(new Character('b'));
        flyWeight.operation("second call");

        flyWeight = factory.factory(new Character('a'));
        flyWeight.operation("Third call");
    }
}
/**
* 抽象享元角色类
* */
interface FlyWeight {
    public void operation(String state);
}


/**
 * 具体享元角色类
 *
 * */
class ConcreteFlyWeight implements FlyWeight{
    private Character intrinsicState = null;
/**
 * 构造函数，内蕴状态作为参数传入
 *
* */
    public ConcreteFlyWeight(Character state) {
        this.intrinsicState = state;
    }

    /*
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
 * 享元工厂类
 *
 * */
class FlyWeightFactory{
    private Map<Character,FlyWeight> files = new HashMap<Character, FlyWeight>();

    public  FlyWeight factory(Character state){
        FlyWeight flyWeight = files.get(state);
        if(flyWeight == null){
            //对象存在创建一个新的Flyweight
            flyWeight = new ConcreteFlyWeight(state);
            files.put(state,flyWeight);
        }
        return flyWeight;
    }
}