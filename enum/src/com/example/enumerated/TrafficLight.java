package com.example.enumerated;

import static com.example.io.util.Print.print;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-8
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */

//Define an enum type:
enum Signal { GREEN, YELLOW, RED}

public class TrafficLight {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            //Note that you don't have to say Signal.RED in the case statement:
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    public String toString(){
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i<7; i++){
            print(t);
            t.change();
        }
    }
}
