package com.example.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import static java.nio.file.attribute.PosixFilePermission.*;

/**
 *
 * User: guorui
 * Date: 13-8-26
 * Time: 上午11:20
 *
 */
public class Listing_2_5 {
    public static void main(String[] args) {
        Path profile = Paths.get("/home/guorui/.profile");
        try {
            PosixFileAttributes attrs = Files.readAttributes(profile,PosixFileAttributes.class);
            Set<PosixFilePermission> posixFilePermissions = attrs.permissions();
            posixFilePermissions.clear();

            String owner = attrs.owner().getName();
            String perms = PosixFilePermissions.toString(posixFilePermissions);
            System.out.format("%s %s%n",owner,perms);

            posixFilePermissions.add(OWNER_READ);
            posixFilePermissions.add(GROUP_READ);
            posixFilePermissions.add(OTHERS_READ);
            posixFilePermissions.add(OWNER_WRITE);
            Files.setPosixFilePermissions(profile,posixFilePermissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
