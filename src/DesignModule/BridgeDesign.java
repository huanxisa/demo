package DesignModule;
//通过组合关系来代替继承关系，避免继承层次的指数爆炸。拓展能力强，细节对客户透明。
/*
* 聚合关系建立在抽象层，要求开发者针对于抽象化进行设计与编程，增加了系统理解的难度。
* */

public class BridgeDesign {
    public static void main(String[] args) {
        Implementor implementor =new ConcreteImplementorA();
        Abstraction abstraction = new ExtendAbstraction(implementor);
        abstraction.operation();
    }
}
//抽象化角色
abstract class Abstraction{
    protected Implementor iImplementor;
    protected Abstraction (Implementor iImplementor){
        this.iImplementor = iImplementor;
    }

    public abstract void operation();
}
//拓展抽象角色

class ExtendAbstraction extends Abstraction{

    protected ExtendAbstraction(Implementor implementor){
        super(implementor);
    }
    @Override
    public void operation() {
        System.out.println("扩展抽象角色");
        iImplementor.operationImpl();
    }
}



//抽象实现角色,举个例子就是如何设计不同的包类，比如包按照用途来分。
interface Implementor{
    void operationImpl();
}


//具体实现角色
class ConcreteImplementorA implements Implementor{

    @Override
    public void operationImpl() {
        System.out.println("具体实现");
    }
}