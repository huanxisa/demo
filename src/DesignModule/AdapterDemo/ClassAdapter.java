package DesignModule.AdapterDemo;
/*
* 这种方式通过继承方式，所以适配器可以重写适配器中的方法，使得灵活性更强，但是适配类只能有一个
* */
public class ClassAdapter {
    public static void main(String[] args) {
        AbstractTarget abstractTarget = new Adapter();
        abstractTarget.target();
    }
}


interface AbstractTarget{//抽象的目标角色，他要求完成这个动作必须实现以下方法。
    public void target();
}

class Target implements AbstractTarget{//具体类中需要有具体动作

    @Override
    public void target() {
        System.out.println("具体类中的具体动作。");
    }
}

class Adaptee{//初始角色，他本没有目的角色之中的方法。但是他需要通过适配器来转换为目标角色。
    public void adaptee(){
        System.out.println("具体的逻辑");
    }
}
class Adapter extends Adaptee implements AbstractTarget{//适配器通过继承得到初始角色的一份拷贝，又实现了目标角色的接口。完成了初始角色到目标类的转换。

    @Override
    public void target() {
        adaptee();
    }
}