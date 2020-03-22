package DesignModule.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        subject.setState( 15 );
        subject.setState( 11 );

    }
}
/**
 * 被观察者
 *
 * */
class Subject{
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }
}
/**
 *抽象观察者
 *
 * */
abstract class Observer{
    protected Subject subject;
    public abstract void update();
}

/**
 *实际观察者
 */

class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String:"+ Integer.toBinaryString( subject.getState() ) );
    }
}

class OctalObserver extends Observer{

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String:"+ Integer.toOctalString( subject.getState() ) );
    }
}

class HexObserver extends Observer{
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Binary String:"+ Integer.toHexString( subject.getState() ) );
    }
}