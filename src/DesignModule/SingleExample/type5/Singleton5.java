package DesignModule.SingleExample.type5;

public class Singleton5 {
}
class Singleton{
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){//解决了线程不安全的问题，但是后面的想取出实例需要排队。
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null)       //双重检查
                instance = new Singleton();
            }
        }
        return instance;
    }
}