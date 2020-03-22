package DesignModule.FactoryModule.Order;

import DesignModule.FactoryModule.pizza.CheesePizza;
import DesignModule.FactoryModule.pizza.GreekPizza;
import DesignModule.FactoryModule.pizza.Pizza;
//根据orderType返回对应的实例
public class SimpleFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(orderType);
        } else if (orderType.equals("Cheese")) {
            pizza = new CheesePizza();
            pizza.setName(orderType);
        }

        return pizza;
    }
}