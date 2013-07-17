package com.example.enumerated;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-8
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    public String toString(){
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : values()){
            System.out.println(s);
        }
    }

}
