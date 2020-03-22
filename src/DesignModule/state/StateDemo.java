package DesignModule.AbstractState;

/**
 * @author DELL
 * 状态模式
 */
public class StateDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }
}
/**
 * 环境类
 * */
class Context{
    private AbstractState AbstractState;
    
    public Context() {
        //设置初始状态
        this.AbstractState = new ConcreteStateA();
    }

    public AbstractState getAbstractState() {
        return AbstractState;
    }

    public void setAbstractState(AbstractState AbstractState) {
        this.AbstractState = AbstractState;
    }
    
    public void handle(){
        AbstractState.handle(this);
    }
}

/*
*抽象状态类
* */

abstract class AbstractState{
    public abstract void handle(Context context);
}

class ConcreteStateA extends AbstractState{

    @Override
    public void handle(Context context) {
        System.out.println("当前是A状态");
        context.setAbstractState(new ConcreteStateB());
    }
}

class ConcreteStateB extends AbstractState{

    @Override
    public void handle(Context context) {
        System.out.println("当前是B状态");
        context.setAbstractState(new ConcreteStateA());
    }
}