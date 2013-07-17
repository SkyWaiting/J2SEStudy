package com.example.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 测试MD5消息摘要
 * User: guorui
 * Date: 13-7-17
 * Time: 下午2:11
 *
 */
public class TestMD5MessageDigest {
    private static String str = "Hello,I sent to you 80 yuan.";

    public static void main(String[] args) {
        try {
            //返回实现指定摘要算法的消息摘要对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            md.update(str.getBytes("utf-8"));
            //完成哈希计算
            byte[] re = md.digest();
            System.out.println(re);
            String result = "";
            System.out.println("哈希结果长度：" + re.length);
            for (int i = 0;i < re.length; i++){
                System.out.println("哈希结果：" + re[i]);
                System.out.println("first step:" + Integer.toHexString(0x000000ff & re[i]));
                System.out.println("second step:" + Integer.toHexString((0x000000ff & re[i]) | 0xffffff00));
                result += Integer.toHexString((0x000000ff & re[i]) | 0xffffff00).substring(6);
            }
            System.out.println(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
