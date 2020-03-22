package DesignModule.FactoryModule.Order;

import DesignModule.FactoryModule.pizza.CheesePizza;
import DesignModule.FactoryModule.pizza.GreekPizza;
import DesignModule.FactoryModule.pizza.Pizza;

public class OrderPizza {
//    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType;
//        do {
//            orderType = "greek";
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();       //问题在于我们添加pizza与这个类过多的耦合违反了ocp原则：对扩展开放，对修改关闭
//                pizza.setName(orderType);
//            } else if (orderType.equals("Cheese")) {
//                pizza = new CheesePizza();
//                pizza.setName(orderType);
//            }
//        }while (false);
//        pizza.prepare();
//        pizza.bake();
//        pizza.cut();
//        pizza.box();
//
//    }

    SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory){
        String OrderType = "Cheese";//用户输入
        this.simpleFactory=simpleFactory;
    }

}
