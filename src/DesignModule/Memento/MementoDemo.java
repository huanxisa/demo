package DesignModule.Memento;


/**
 * @author DELL
 * 备忘录模式，不破坏封装性的前提下，捕获一个对象内部状态，并在对象之外保存改状态
 */
public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setOState("123");
        Caretaker caretaker =new Caretaker();
        caretaker.setMemento( originator.createMemtento() );

        originator.setOState("456");
        System.out.println(originator.getOState());
        originator.restoreMemento( caretaker.getMemento() );
        System.out.println( originator.getOState() );

    }
}
/**
 * 这是需要保存的对象
 * */
class Originator{
    private String OState ="";

    public String getOState() {
        return OState;
    }

    public void setOState(String OState) {
        this.OState = OState;
    }

    public Memento createMemtento(){
        return new Memento(this.OState);
    }

    public void restoreMemento(Memento memento){
        this.setOState(memento.getMState());
    }
}
/**
 * 这是备忘录对象
 *
 * */
class Memento{
    private String MState;

    public Memento(String MState) {
        this.MState = MState;
    }

    public String getMState() {
        return MState;
    }
}
/**
 * 守护者对象，负责保存多个备忘录对象
 * */
class Caretaker{

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}