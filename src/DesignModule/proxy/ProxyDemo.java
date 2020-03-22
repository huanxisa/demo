package DesignModule.proxy;

/**
 * @author DELL
 *
 * 进阶玩法见动态代理
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}
/**
 * 抽象主题：通过接口或抽象类声明真实主题，和代理对象实现业务的方法。
 *
 * */
interface Subject{
    /**
     *
     */
    void Request();
}
/**
 * 真实主题：实现抽象主题中的具体业务，最终应用的对象
 *
 * */
class RealSubject implements Subject{

    @Override
    public void Request() {
        System.out.println("访问真实主题方法。");
    }
}
/**
 * 代理
 *
 * */
class Proxy implements Subject{
    private RealSubject realSubject;

    @Override
    public void Request() {
        if(realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    private void postRequest() {
    }

    private void preRequest() {
    }
}