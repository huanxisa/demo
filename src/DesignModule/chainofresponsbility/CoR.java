package DesignModule.chainofresponsbility;


/**
 * @author DELL
 */
public class CoR {
    public static void main(String[] args) {
        AbstractHandler departmentManager = new DepartmentManager(5);
        AbstractHandler generalmentManager = new GeneralManager(10);

        departmentManager.setNextHandler(generalmentManager);

        departmentManager.handleRequest(6);
    }
}
/**
 * 抽象处理者角色
 * */
abstract class AbstractHandler{
    int maxDay;
    private AbstractHandler nextHandler;

    protected AbstractHandler( int maxDay){
        this.maxDay= maxDay;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    protected void handleRequest(int day){
        if (day <= maxDay){
            reply(day);
        }else {
            if (nextHandler != null){
                nextHandler.handleRequest(day);
            }else {
                System.out.println("没有更高的领导批准了。");
            }
        }
    }

    protected abstract void reply(int day);
}

/**
 * 具体处理角色
 * */
class DepartmentManager extends AbstractHandler {

    protected DepartmentManager(int maxDay) {
        super(maxDay);
    }

    @Override
    protected void reply(int day) {
        System.out.println("部门经理同意请假"+day+"天");
    }
}

class GeneralManager extends AbstractHandler {

    protected GeneralManager(int maxDay) {
        super(maxDay);
    }

    @Override
    protected void reply(int day) {
        System.out.println("总经理同意请假"+day+"天");
    }
}
