package DesignModule.SingleExample.type6;

public class SingleTon6 {
    public static void main(String[] args) {

    }
}
//静态内部类特点：1.当外部类装载时，内部类不会被装载(懒加载) 2.当静态内部类装载时只会装再一次。是线程安全的
class Singleton{

    private static volatile Singleton singleton;

    private Singleton(){}

    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static  Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }

}