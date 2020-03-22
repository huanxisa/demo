package DesignModule.FactoryModule;

public class FactoryAndMethodModule {

}

abstract class Phone{//抽象产品类
    public void call(){}

    public abstract void PhoneBrand();

}

class HuaWei extends Phone{
    @Override
    public void PhoneBrand() {
        System.out.println("我的品牌是华为");
    }//具体产品1


}

class XiaoMi extends Phone{//具体产品2

    @Override
    public void PhoneBrand() {
        System.out.println("我的品牌是小米");
    }
}

abstract class PhoneFactory{
    public abstract <T extends Phone> T createPhone(Class<T> c);
}

class HuaWeiFactory extends PhoneFactory{

    @Override
    public <T extends Phone> T createPhone(Class<T> c) {
        Phone phone = null;
        try {
            phone= (Phone) Class.forName(c.getName()).newInstance();
            System.out.println("生产了华为手机");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) phone;
    }
}

class XiaoMiFactory extends PhoneFactory{

    @Override
    public <T extends Phone> T createPhone(Class<T> c) {
        return null;
    }
}