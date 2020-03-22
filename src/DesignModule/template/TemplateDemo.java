package DesignModule.template;

public class TemplateDemo {
    public static void main(String[] args) {
        Template contreteClass1 =new ContreteClass1();
        contreteClass1.templateMethod();
    }
}
abstract class Template{
    /**
     * 负责设计算法过程，对于具体的细节交给子类来做
     */
    public void templateMethod(){
        this.doSomething();
        this.doAnything();
    }

    protected abstract void doAnything();

    protected abstract void doSomething();

}

class ContreteClass1 extends Template{

    @Override
    protected void doAnything() {
        System.out.println("子类1的doAnything");
    }

    @Override
    protected void doSomething() {
        System.out.println("子类1的doSomething");
    }
}