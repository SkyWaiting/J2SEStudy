package com.example.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-17
 * Time: 下午1:48
 *
 */
public class MyMessageDigestTest {

    public static void main(String[] args) {
        MyMessageDigestTest my = new MyMessageDigestTest();
        my.testDigest();
    }


    public void testDigest(){
        String myinfo = "我的测试信息";
//        MessageDigest alg = MessageDigest.getInstance("MD5");
        try {
            MessageDigest alga = MessageDigest.getInstance("SHA-1");
            alga.update(myinfo.getBytes());
            byte[] digesta = alga.digest();
            System.out.println("本消息摘要是：" + byte2hex(digesta));
            //通过某种方式传给其他人你的消息和摘要对方可以判断是否更改或传输正常
            MessageDigest algb = MessageDigest.getInstance("SHA-1");
            algb.update(myinfo.getBytes());
            if (algb.isEqual(digesta,algb.digest())){
                System.out.println("信息检查正常");
            }else {
                System.out.println("摘要不相同");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("非法摘要算法");
            e.printStackTrace();
        }
    }
    /**
     * 二进制转字符串
     * @param b
     * @return
     */
    public String byte2hex(byte[] b){
        String hs = "";
        String stmp = "";
        for(int n = 0; n < b.length; n++){
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length()==1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n<b.length-1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }
}
