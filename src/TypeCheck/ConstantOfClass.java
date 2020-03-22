package TypeCheck;

class Initable{
    static {
        System.out.println("Initable类被加载");
    }
}
public class ConstantOfClass {
    public static void main(String[] args) {
        Class initable = Initable.class;
        System.out.println("Innitable加载了吗");
        try {
            initable.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
