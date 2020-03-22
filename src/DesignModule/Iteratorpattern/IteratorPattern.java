package DesignModule.Iteratorpattern;

public class IteratorPattern {
    public static void main(String[] args) {

    }
}
/**
 * 抽象迭代器角色类
 * */
interface Iterator{
    void first();

    void next();

    boolean isDone();

    Object currentItem();
}
class ConcreteIteror implements Iterator{
    private ConcreteAggregate concreteAggregate;

    private int index = 0;

    private int size = 0;

    public ConcreteIteror(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
        this.size =concreteAggregate.size();
        index= 0;
    }

    @Override
    public void first() {
        index = 0;
        return;
    }

    @Override
    public void next() {
        if(!isDone()) {
            index++;
        }
        return;
    }

    @Override
    public boolean isDone() {
        return index >= size;
    }

    @Override
    public Object currentItem() {
        return concreteAggregate.getElement( index );
    }
}

/**
 * 聚集角色
 * */
abstract class Aggregate{
    public abstract Iterator createIterator();
}

/**
 *具体聚集角色类
 * */
class ConcreteAggregate extends Aggregate{
    private Object[] objArray = null;

    public ConcreteAggregate(Object[] objArray) {
        this.objArray = objArray;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIteror(this);
    }

    public Object getElement(int index){
        if(index < objArray.length){
            return objArray[index];
        }else {
            return null;
        }
    }

    public int size(){
        return objArray.length;
    }
}