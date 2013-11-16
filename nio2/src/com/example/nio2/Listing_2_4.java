package com.example.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 访问文件基本属性
 * User: guorui
 * Date: 13-8-25
 * Time: 下午5:07
 *
 */
public class Listing_2_4 {

    public static void main(String[] args) {
        Path zip = Paths.get("D:\\Program Files\\WinRAR\\WinRAR.exe");
        System.out.println(zip.toAbsolutePath().toString());
        try {
            System.out.println(Files.getLastModifiedTime(zip));
            System.out.println(Files.size(zip));
            System.out.println(Files.isSymbolicLink(zip));
            System.out.println(Files.isDirectory(zip));
            System.out.println(Files.readAttributes(zip,"*"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
