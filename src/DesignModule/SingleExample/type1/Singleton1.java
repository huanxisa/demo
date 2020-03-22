package DesignModule.SingleExample.type1;

public class Singleton1 {

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();//未实现懒加载的效果，有可能造成内存浪费。避免多线程的同步问题
    }
}
class SingleTon{
    private SingleTon() {
    }
    private final static SingleTon instance = new SingleTon();

    public static SingleTon getInstance(){
        return instance;
    }
}