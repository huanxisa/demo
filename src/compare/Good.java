package compare;

public class Good implements Comparable{
    private String name;

    private Double price;

    public Good(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                '}';
    }

    //按照价格比较大小
    @Override
    public int compareTo(Object o) {
        if( o instanceof Good){
            Good good = (Good) o;
            return Double.compare(this.price,good.price);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
