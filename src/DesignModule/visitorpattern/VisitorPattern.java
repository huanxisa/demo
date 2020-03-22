package DesignModule.visitorpattern;


import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * 就是帮助主程序完成一些它完不成的东西而不需要修改层次结构
 * 复合单一职责原则，扩展性好，不修改对象结构中的元素下，添加了新功能。
 * 违反了迪米特法则，具体元素对访问者公布了细节
 * 违反了依赖倒置原则，依赖具体类，没有依赖抽象类
 */
public class VisitorPattern {
    public static void main(String[] args) {

    }
}
/**
 * 访问者
 * */
abstract class Vistor{
    abstract void visit(Engineer engineer);
    abstract void visit(Manager manager);
}

class ConcreteVisitor extends Vistor{

    @Override
    void visit(Engineer engineer) {
    }

    @Override
    void visit(Manager manager) {
    }
}

/**
 * 被访问者
 *
 * */
abstract class Staff{
    public abstract void accept(Vistor vistor);
}

class Engineer extends Staff{

    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }
}

class Manager extends Staff{

    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }
}

class ObjectStructures {
    private List<Staff> list = new ArrayList<Staff>();
    public void action(Vistor vistor){
        for (Staff staff:list){
            staff.accept(vistor);
        }
    }

    public void add (Staff staff){
        list.add(staff);
    }
    public void delete (Staff staff){
        list.remove(staff);
    }
}