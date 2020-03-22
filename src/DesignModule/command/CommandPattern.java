package DesignModule.command;


/**
 * @author DELL
 */
public class CommandPattern {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
/**
 *调用者
 * */
class Invoker{
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call(){
        System.out.println("调用命令的执行方法");
        command.execute();
    }
}

/**
 * 命令的抽象
 * */
interface Command{
    void execute();
}

class ConcreteCommand implements Command{
    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.action();
    }

}
/**
 * 命令的实际执行者
 *
 * */
class Receiver{
    public void action(){
        System.out.println("接收到命令准备执行");
    }
}