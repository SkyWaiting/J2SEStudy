package net.mindview.util;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-8
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
