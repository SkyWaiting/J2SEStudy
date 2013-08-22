package com.example.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 遍历文件夹下.properties文件
 * User: guorui
 * Date: 13-8-11
 * Time: 上午10:55
 *
 */
public class Listing_2_2 {

    public static void main(String[] args) {

        Path dir = Paths.get("E:\\GitHubProject\\java7developer");

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"*.properties")){
            for (Path entry : stream){
                System.out.println(entry.getFileName());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
