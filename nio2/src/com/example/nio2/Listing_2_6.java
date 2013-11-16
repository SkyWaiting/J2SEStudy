package com.example.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 符号链接,nio2 API默认会跟随符号链接。
 * User: guorui
 * Date: 13-8-26
 * Time: 下午3:29
 *
 */
public class Listing_2_6 {
    public static void main(String[] args) {
        Path file = Paths.get("/opt/platform/java");
        try {
            //检查符号链接
            if (Files.isSymbolicLink(file)){
                //读取符号链接，获得目标的真实path
                file = Files.readSymbolicLink(file);
            }
            //读取文件属性
            Files.readAttributes(file, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
