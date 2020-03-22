package DesignModule.SingleExample.type2;

public class Sington1 {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();//效果和1一样。
    }
}
class SingleTon{
    //构造器私有化
    private SingleTon() {
    }
    //本类内部创建对象实例
    private final static SingleTon instance;
    //静态代码块创建
    static {
        instance=new SingleTon();
    }

    public static SingleTon getInstance(){
        return instance;
    }
}