package com.example.crypto;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 非对称加密算法RSA
 * User: guorui
 * Date: 13-7-15
 * Time: 下午3:19
 *
 */
public class TestRSAEncryDecry {

    private static String str = "I have a friend !";

    public static void main(String[] args) {

        System.out.println("==========明文==========");
        System.out.println(str);
        System.out.println();
        try {
            byte[] bytes = str.getBytes("utf-8");
            //非对称秘钥生成器
            KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
            key.initialize(1024);
            KeyPair pair = key.genKeyPair();
            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();
            //保存公钥

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
