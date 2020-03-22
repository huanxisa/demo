package DesignModule.SingleExample.type4;

public class Singleton4 {
    public static void main(String[] args) {
        
    }
}

class Singleton{
    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){//解决了线程不安全的问题，但是后面的想取出实例需要排队。
        if(instance == null){
            instance =new Singleton();
        }
        return instance;
    }
}

