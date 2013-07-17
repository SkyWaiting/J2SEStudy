package com.example.crypto;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

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
            FileOutputStream fos = new FileOutputStream("pub.dat");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(publicKey);
            //保存私钥
            FileOutputStream fos2 = new FileOutputStream("pri.dat");
            ObjectOutputStream os2 = new ObjectOutputStream(fos2);
            os2.writeObject(privateKey);

            RSAPublicKey rpub = (RSAPublicKey)pair.getPublic();
            //返回该公用指数
            BigInteger e = rpub.getPublicExponent();
            //返回该系数
            BigInteger n = rpub.getModulus();
            System.out.println("e = " + e + "\r\nn = "+n);
            BigInteger m = new BigInteger(bytes);
            BigInteger bi = m.modPow(e,n);
            System.out.println("===========密文===========");
            System.out.println(bi);

            RSAPrivateKey rpri = (RSAPrivateKey)pair.getPrivate();
            BigInteger e2 = rpri.getPrivateExponent();
            BigInteger n2 = rpri.getModulus();
            BigInteger bi2 = bi.modPow(e2,n2);
            System.out.println("===========解密后原文==========");
            byte[] chars = bi2.toByteArray();
            for (int j = 0; j < chars.length; j++){
                System.out.println((char)chars[j]);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
