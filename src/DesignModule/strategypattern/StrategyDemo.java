package DesignModule.strategypattern;

import java.math.BigDecimal;

/**
 * @author DELL
 * 策略模式只适合管理一组同类型的算法，并且这些算法是完全相斥
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Buyer strategy = new VipBuyer();
        Cashier cashier = new Cashier(strategy);
        System.out.println("最终价格："+cashier.quote(new BigDecimal(45)).doubleValue());
    }
}
/**
 * 抽象策略类
 * */
interface Buyer{
    public BigDecimal calPrice ( BigDecimal orderPrice );
}

/**
 * 具体策略类
 * */
class ParticularlyVipBuyer implements Buyer{

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        if ( orderPrice.compareTo(new BigDecimal(30)) > 0){
            return orderPrice.multiply( new BigDecimal(0.7));
        }
        return orderPrice;
    }
}

class SuperVipBuyer implements Buyer{

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        if ( orderPrice.compareTo(new BigDecimal(30)) > 0){
            return orderPrice.multiply( new BigDecimal(0.8));
        }
        return orderPrice;
    }
}
class VipBuyer implements Buyer{

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        if ( orderPrice.compareTo(new BigDecimal(30)) > 0){
            return orderPrice.multiply( new BigDecimal(0.9));
        }
        return orderPrice;
    }
}
/**
 * 上下文类
 *
 * */
class Cashier{
    private Buyer buyer;

    public Cashier(Buyer buyer) {
        this.buyer = buyer;
    }

    public BigDecimal quote(BigDecimal orderPrice){
        return this.buyer.calPrice(orderPrice);
    }
}