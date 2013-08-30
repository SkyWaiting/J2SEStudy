package com.example.juc;

/**
 * User: guorui
 * Date: 13-8-30
 * Time: 下午2:09
 */
public class Author {

    private final String name;

    public Author(String name_){
        name = name_;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author [name="+name+"]";
    }
}
