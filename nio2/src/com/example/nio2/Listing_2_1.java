package com.example.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-8-10
 * Time: 下午7:08
 *
 */
public class Listing_2_1 {

    public static void main(String[] args) {
        Path listing = Paths.get("C:\\Program Files\\Java\\jdk1.7.0_25\\bin\\jar.exe");
        System.out.println("File Name [" + listing.getFileName() + "]");
        System.out.println("Number of Name Elements in the Path [" + listing.getNameCount() + "]");
        System.out.println("Parent Path [" + listing.getParent() + "]");
        System.out.println("Root of Path [" + listing.getRoot() + "]");
        System.out.println("Subpath from Root,2 elements deep [" + listing.subpath(0,2) + "]");
    }
}
