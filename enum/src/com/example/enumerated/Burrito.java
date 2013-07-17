package com.example.enumerated;

import static com.example.enumerated.Spiciness.*;
/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-4
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree){
        this.degree = degree;
    }

    public String toString(){
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
