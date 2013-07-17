package com.example.enumerated;

import net.mindview.util.Enums;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-9
 * Time: 下午11:38
 * To change this template use File | Settings | File Templates.
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);
    Security[] values;
    SecurityCategory(Class<? extends Security> kind){
        values = kind.getEnumConstants();
    }

    interface Security{
        enum Stock implements Security{
            SHORT, LONG, MARGIN;
        }
        enum Bond implements Security{
            MUNICIPAL, JUNK;
        }
    }

    public Security randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0;i < 10; i++){
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}
