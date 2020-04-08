package testenum;

/**
 * @author DELL
 * 继承接口
 * 枚举类的对象可以自定义方法
 */
interface info{
    void show();
}

public enum SeasonEnum implements info{
    /**四季*/
    SPRING("13546")
            {
               @Override
               public void show(){
                   System.out.println("春天在哪里？");
               }
            },
    SUMMER("12456"),AUTUMN("164654163"),WINTER("5646512");


    private String name;

    private SeasonEnum(String name) {
        this.name= name;
    };

    public String getName() {
        return name;
    }

    @Override
    public void show(){
        System.out.println("季节枚举");
    }
}
