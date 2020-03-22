package TypeCheck;
//一些class对象的方法调用
class Gum{
    static {
        System.out.println("loading Gum" );
    }
}
public class ObjectOfJava {
    public static void main(String[] args){
        Class cc=null;
        try {
            cc=Class.forName("TypeCheck.Gum");
        }catch (ClassNotFoundException e){
            System.out.println("Couldn't find Gum");
        }

        System.out.println( cc.getName() );
        System.out.println( cc.isInterface() );
        System.out.println( cc.getSimpleName() );
        System.out.println( cc.getCanonicalName() );
        System.out.println( cc.getSuperclass() );
        try {
            Object up = cc.newInstance();
            System.out.println( up );
            System.out.println(up.getClass());
        } catch (Exception e) {
            System.out.println("创建失败");
        }
        for( Class face : cc.getInterfaces())
            System.out.println("["+face+"]");

    }
}
