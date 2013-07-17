package com.example.enumerated.menu;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-9
 * Time: 下午11:18
 * To change this template use File | Settings | File Templates.
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            for (Course course : Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("----------");
        }
    }
}
