package com.example.security;

import java.security.MessageDigest;

/**
 *  Java 实现MD5摘要
 *
 * User: guorui
 * Date: 13-5-30
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
public class MD5Util {
    public final static String MD5(byte[] b){
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        try{
            byte[] btInput = b;
            //获得MD5摘要算法的MessageDigest对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md = mdInst.digest();
            //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for(int i = 0; i < j; i++){
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
