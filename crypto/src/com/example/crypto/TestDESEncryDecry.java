package com.example.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;

/**
 * 对称加密算法DES
 * User: guorui
 * Date: 13-7-14
 * Time: 下午8:25
 *
 */
public class TestDESEncryDecry {

    private static String str = "1234567812345678";

    public static void main(String[] args) {
        System.out.println("==========明文=========");
        System.out.println(str);
        System.out.println();
        try {
            byte[] bytes = str.getBytes("utf-8");
            //对称秘钥生成器
            KeyGenerator ken = KeyGenerator.getInstance("DESEDE");
            //初始化秘钥生成器，使其具有确定秘钥大小
            ken.init(168);
            //生成一个秘钥
            SecretKey key = ken.generateKey();
            //返回基本编码格式的密钥，如果此密钥不支持编码，则返回 null
            byte[] codes = key.getEncoded();
            //打印秘钥
            if (null != codes){
                System.out.println("======显示秘钥=====");
                for (int j=0;j<codes.length;j++){
                    System.out.println(codes[j] + ", ");
                    if ((j % 8) == 7){
                        System.out.println();
                    }
                }
                System.out.println();
                //使用DESede获得Cipher对象
                Cipher cipher = Cipher.getInstance("DESede");
                //用加密模式和秘钥初始化cipher对象
                cipher.init(Cipher.ENCRYPT_MODE, key);
                //加密数据，获得密文
                byte[] encryBytest = cipher.doFinal(bytes);
                //打印密文
                System.out.println("======密文======");
                for (int j = 0;j < encryBytest.length; j++){
                    System.out.println(encryBytest[j] + ", ");
                    if ((j % 8) == 7){
                        System.out.println();
                    }
                }
                System.out.println();
                //用解密模式和秘钥初始化cipher对象
                cipher.init(Cipher.DECRYPT_MODE,key);
                byte[] decryBytes = cipher.doFinal(encryBytest);
                String str = new String(decryBytes);
                System.out.println("========解密后原文========");
                System.out.println(str);

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
