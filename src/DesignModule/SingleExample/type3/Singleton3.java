package DesignModule.SingleExample.type3;

public class Singleton3 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();//线程不安全，单线程下使用 懒加载。
    }
}

class Singleton{
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            instance =new Singleton();
        }
        return instance;
    }
}
