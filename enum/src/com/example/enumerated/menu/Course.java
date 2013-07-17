package com.example.enumerated.menu;

import net.mindview.util.Enums;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-9
 * Time: 下午11:00
 * To change this template use File | Settings | File Templates.
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return Enums.random(values);
    }
}
