package DesignModule.AdapterDemo;
/*
* 由于是采用的聚合的方式，所以适配器的子类及本身都可以采用同一个适配器类。但是不能重写父类方法，灵活性很差。
* */
public class ObjectAdapter {
    public static void main(String[] args) {
        AbstractTarget abstractTarget = new Adapter2();
        abstractTarget.target();
    }
}
class Target2 {//具体类中需要有具体动作
    public void target() {
        System.out.println("具体类中的具体动作。");
    }
}

class Adaptee2{//初始角色，他本没有目的角色之中的方法。但是他需要通过适配器来转换为目标角色。
    public void adaptee(){
        System.out.println("具体的逻辑");
    }
}
class Adapter2 implements AbstractTarget{//适配器通过聚合初始角色，又实现了目标角色的接口。完成了初始角色到目标类的转换。
    Adaptee2 adaptee2 = new Adaptee2();
    @Override
    public void target() {
        adaptee2.adaptee();
    }
}