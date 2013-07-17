package com.example.enumerated;

import com.example.io.standard.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static com.example.io.util.Print.print;
import static com.example.io.util.Print.printnb;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-8
 * Time: 下午5:46
 * To change this template use File | Settings | File Templates.
 */
enum Explore { HERE, THERE }

public class Refletion {

    public static Set<String> analyze(Class<?> enumClass){
        print("--------Analyzing " + enumClass +"  ----------------");
        print("Interfaces: ");
        for (Type t : enumClass.getGenericInterfaces())
            print(t);
        print("Base: " + enumClass.getSuperclass());
        print("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods())
            methods.add(m.getName());
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        //Decompile the code for the enum:
        OSExecute.command("javap Explore");
    }
}
