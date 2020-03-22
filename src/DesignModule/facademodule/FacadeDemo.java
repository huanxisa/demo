package DesignModule.facademodule;

public class FacadeDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.FacadeMethod();
    }
}

class Facade{
    public void FacadeMethod(){
        Subclass1 subclass1 = new Subclass1();
        subclass1.method1();
        Subclass2 subclass2 = new Subclass2();
        subclass2.method1();
        Subclass3 subclass3 = new Subclass3();
        subclass3.method1();
    }
}
class Subclass1{
    public void method1(){
        System.out.println("这是子系统类1方法1");
    }

    public void method2(){
        System.out.println("这是子系统类1方法2");
    }

}
class Subclass2{
    public void method1(){
        System.out.println("这是子系统类2方法1");
    }

    public void method2(){
        System.out.println("这是子系统类2方法2");
    }

}
class Subclass3{
    public void method1(){
        System.out.println("这是子系统类3方法1");
    }

    public void method2(){
        System.out.println("这是子系统类3方法2");
    }

}