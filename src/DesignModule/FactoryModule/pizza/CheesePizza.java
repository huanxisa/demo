package DesignModule.FactoryModule.pizza;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备制作奶酪Pizza");
    }
}
