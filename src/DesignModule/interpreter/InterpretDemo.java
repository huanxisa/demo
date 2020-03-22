package DesignModule.interpreter;

import java.util.*;

/**
 * @author DELL
 * 解释器模式
 *
 */
public class InterpretDemo {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("南京的老人");
    }
}

/**
 * 抽象表达式
 * */
interface Expression{
    public boolean interpret(String info);
}
/**
 * 终结符表达式
 * */
class TerminalExpression implements Expression{
    private Set<String> strings = new HashSet<String>();

    public TerminalExpression(String[] data){
        for (String string:data) {
            this.strings.add(string);
        }
    }
    @Override
    public boolean interpret(String info) {
        if(strings.contains(info)){
            return true;
        }
        return false;
    }
}

/**
 * 非终结表达式
 *
 * */
class NormalExpression implements Expression{
    private Expression city;
    private Expression person;

    public NormalExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String[] s = info.split("的");
        return city.interpret( s[0] ) && person.interpret( s[1] );
    }
}

/**
 * 上下文模式
 * */
class Context{
    private String[] citys = {"南京","苏州"};
    private String[] persons = {"老人","小孩"};

    private Expression cityPerson;

    public Context(){
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new NormalExpression(city,person);
    }
    public void freeRide(String info){
        boolean ok = cityPerson.interpret(info);
        if(ok) {
            System.out.println("您是" + info + ",本次乘车免费");
        }
        else {
            System.out.println(info + ",您不是免费人员，本次乘车不免费");
        }
    }
}