package TypeCheck;

import java.lang.reflect.Method;

public class HiddenImplementation {

    public static void main(String[] args) {
        A a = HiddenC.makeA();
        a.f();

        System.out.println(a.getClass().getName());

        try {
            callHiddenMethod(a,"g");
            callHiddenMethod(a,"u");
            callHiddenMethod(a,"v");
            callHiddenMethod(a,"w");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void callHiddenMethod(Object a,String methodName) throws Exception {
        Method g =a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
