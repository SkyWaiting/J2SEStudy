package com.example.enumerated;

import net.mindview.util.Enums;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-9
 * Time: 上午8:30
 * To change this template use File | Settings | File Templates.
 */

enum Activity{
    SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING
}

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
