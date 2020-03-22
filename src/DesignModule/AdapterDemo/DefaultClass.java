package DesignModule.AdapterDemo;

public class DefaultClass {
    public static void main(String[] args) {

    }
}
interface Target3{
    void operation1();
    void operation2();
    void operation3();
}

abstract class Adapter3 implements Target3{
    //通过抽象类直接与目标接口产生联系
}

class adaptee extends Adapter3{

    @Override
    public void operation1() {

    }

    @Override
    public void operation2() {

    }

    @Override
    public void operation3() {

    }
}