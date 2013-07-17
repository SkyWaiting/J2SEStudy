package com.example.enumerated.cartoons;

import net.mindview.util.Generator;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-8
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */

enum CartoonCharacter implements Generator{
    SLAPPY, SPANKY, PUNCHY, SLILY, BOUNCY, NUTTY, BOB;

    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg){
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++){
            printNext(cc);
        }
    }
}
