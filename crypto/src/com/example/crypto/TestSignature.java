package com.example.crypto;

import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPublicKey;

/**
 * 测试数字签名
 * User: guorui
 * Date: 13-7-17
 * Time: 下午3:45
 *
 */
public class TestSignature {
    private static String str = "I'm live in china !";

    public static void main(String[] args) {
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("utf-8");
            String str = new String(bytes);
            System.out.println("==========要签名的原文===========");
            System.out.println(str);
            KeyPairGenerator ken = KeyPairGenerator.getInstance("RSA");
            ken.initialize(1024);
            KeyPair pair = ken.genKeyPair();
            PrivateKey pri = pair.getPrivate();
            Signature signer = Signature.getInstance("MD5withRSA");
            //初始化私钥，若为公钥则使用initVeriry
            signer.initSign(pri);
            signer.update(bytes);
            byte[] signs = signer.sign();
            System.out.println("============签名=============");
            for (int j = 0 ; j < signs.length ; j++) {
                System.out.print(signs[j]);
                if ((j % 8) == 7 ) {
                    System.out.println();
                }
            }
            //保存签名到rsasign.sig
            FileOutputStream fos = new FileOutputStream("rsasign.sig");
            for (int j = 0 ; j < signs.length ; j++) {
                fos.write(signs[j]);
            }
            fos.flush();
            fos.close();
            PublicKey pub = pair.getPublic();
            RSAPublicKey rpub = (RSAPublicKey)pub;
            byte [] kb = rpub.getEncoded();
            //保存公钥
            FileOutputStream fos2 = new FileOutputStream("rsapub.dat");
            fos2.write(kb);
            fos2.close();
            signer.initVerify(rpub);
            signer.update(bytes);
            boolean ok = false;
            FileInputStream fis = new FileInputStream("rsasign.sig");
            int num = fis.available();
            byte [] bytes2 = new byte[num];
            fis.read(bytes2);
            ok = signer.verify(bytes2);
            System.out.println("签名验证结果　："+ok);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
