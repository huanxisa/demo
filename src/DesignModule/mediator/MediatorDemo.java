package DesignModule.mediator;

/**
 * @author DELL
 */
public class MediatorDemo {
    public static void main(String[] args) {
        AbstractColleague collA = new ColleagueA();
        AbstractColleague collB = new ColleagueB();

        AbstractMediator am=new Mediator(collA,collB);

        collA.setNumber(100 , am);
        System.out.println( collA.getNumber() );
        System.out.println( collB.getNumber() );
    }
}
abstract class AbstractColleague{
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 具体同事类需要影响相关的中介者
     * */
    public abstract void setNumber(int number,AbstractMediator abstractmediator);
}

/**
 * 具体同事类
 * */
class ColleagueA extends AbstractColleague{

    @Override
    public void setNumber(int number, AbstractMediator abstractMediator) {
        this.number = number;
        abstractMediator.AaffectB();
    }
}
class ColleagueB  extends AbstractColleague{

    @Override
    public void setNumber(int number, AbstractMediator abstractMediator) {
        this.number = number;
        abstractMediator.BaffectA();
    }
}

/**
 * 抽象中介者
 * */
abstract class AbstractMediator{
    protected AbstractColleague A;
    protected AbstractColleague B;

    public AbstractMediator(AbstractColleague a, AbstractColleague b) {
        A = a;
        B = b;
    }
    public abstract void  AaffectB();
    public abstract void  BaffectA();

}

/**
 * 具体中介者
 * */
class Mediator extends AbstractMediator{

    public Mediator(AbstractColleague a, AbstractColleague b) {
        super(a, b);
    }

    @Override
    public void AaffectB() {
        B.setNumber(A.getNumber()*10);
    }

    @Override
    public void BaffectA() {
        A.setNumber(B.getNumber()/10);
    }
}