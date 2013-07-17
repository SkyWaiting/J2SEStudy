package com.example.enumerated;

import static com.example.io.util.Print.print;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-8
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
public enum OzWitch {
    //Instances must be defined first,before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;
    //Constructor must be package or private access:
    private OzWitch(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()){
            print(witch + ": " + witch.getDescription());
        }
    }

}
