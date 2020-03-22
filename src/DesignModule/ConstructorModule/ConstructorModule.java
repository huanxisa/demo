package DesignModule.ConstructorModule;

public class ConstructorModule {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder1();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product.toString());

    }

}

//产品类：包含多个部件的复杂对象
class Product{
    private String partA;
    private String partB;
    private String partC;

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

}
//抽象建造者类
abstract class Builder{

    protected Product product = new Product();

    protected abstract void buildPartA();
    protected abstract void buildPartB();
    protected abstract void buildPartC();

    public Product getResult(){
        return product;
    }
}
class ConcreteBuilder1 extends Builder{

    @Override
    protected void buildPartA() {
        System.out.println("ConcreteBuilder1 的A部分装配好了");
        super.product.setPartA("A");
    }

    @Override
    protected void buildPartB() {
        System.out.println("ConcreteBuilder1 的B部分装配好了");
        super.product.setPartB("B");

    }

    @Override
    protected void buildPartC() {
        super.product.setPartC("C");
        System.out.println("ConcreteBuilder1 的C部分装配好了");
    }
}

class Director{
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }
    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}