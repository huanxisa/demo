package StringTest;


import testenum.SeasonEnum;

import static testenum.SeasonEnum.*;

public class SeasonEnumTest {
    SeasonEnum seasonEnum;

    public SeasonEnumTest(SeasonEnum seasonEnum) {
        this.seasonEnum = seasonEnum;
    }

    @Override
    public String toString() {
        return  seasonEnum.name() ;
    }

    public static void main(String[] args) {
        new SeasonEnumTest(SPRING).seasonEnum.show();
    }
}
