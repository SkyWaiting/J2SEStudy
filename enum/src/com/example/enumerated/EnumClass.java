package com.example.enumerated;

import static com.example.io.util.Print.print;
import static com.example.io.util.Print.printnb;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-4
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values()){
            print(s + " ordinal: " + s.ordinal());
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("--------------------------------");
        }

        //Produce an enum value from a string name:
        for(String s : "HANGING CRAWLING GROUND".split(" ")){
            Shrubbery shrub = Enum.valueOf(Shrubbery.class,s);
            print(shrub);
        }
    }
}
