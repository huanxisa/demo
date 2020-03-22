package DesignModule.DecoratorPattern;

public class DecoratorDemo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.sampleOperation();
    }
}
//四个角色：抽象构件角色，具体构件角色。装饰角色，具体装饰角色

//抽象构件角色：给出一个抽象接口，以规范准备接受附加责任的对象

interface Component{

    public void sampleOperation();
}

/**
*具体构件角色：定义一个具体接受附加责任的对象。
*/
class ConcreteComponent implements Component{

    @Override
    public void sampleOperation() {
        System.out.println("具体构件角色的方法");
    }
}
/**
*抽象装饰角色，聚合一个抽象构件类，使得对扩展开放
*
*/
class Decorator implements Component{

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        component.sampleOperation();
    }
}

/**
*具体装饰模式，定义具体的装饰方案
*/
class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("装饰器的sampleOperation");
    }
}
