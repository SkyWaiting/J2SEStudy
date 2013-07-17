package com.example.enumerated;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-8
 * Time: 下午9:17
 * To change this template use File | Settings | File Templates.
 */
enum Search { HITHER, YON }

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; //Upcast
        //e.values(); //No values() in Enum
        for (Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}
