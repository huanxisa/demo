package TypeCheck;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GenericClassReferences {
    public static void main(String[] args) {
        try {
            Class c=Class.forName("TypeCheck.GenericClassReferences");
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            for (Method method:methods)
                System.out.println(method.toString());
            System.out.println();
            for (Constructor constructor: constructors) {
                System.out.println(constructor.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
