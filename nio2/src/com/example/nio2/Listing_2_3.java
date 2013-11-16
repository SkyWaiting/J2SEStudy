package com.example.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 遍历文件夹，找出特定格式的文件
 * User: guorui
 * Date: 13-8-25
 * Time: 下午4:07
 */
public class Listing_2_3 {

    public static void main(String[] args) {
        Path startingDir = Paths.get("E:\\GitHubProject\\java7developer");
        try {
            Files.walkFileTree(startingDir,new FindJavaVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {

        /**
         * Invoked for a file in a directory.
         * <p/>
         * <p> Unless overridden, this method returns {@link java.nio.file.FileVisitResult#CONTINUE
         * CONTINUE}.
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
