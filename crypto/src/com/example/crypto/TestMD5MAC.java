package com.example.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 测试MD5消息验证码
 * User: guorui
 * Date: 13-7-17
 * Time: 下午2:59
 *
 */
public class TestMD5MAC {
    private static String message = "Hello World !";

    public static void main(String[] args) {
        try {
            byte[] bytes = message.getBytes("utf-8");
            KeyGenerator ken = KeyGenerator.getInstance("DESede");
            ken.init(168);
            SecretKey key = ken.generateKey();
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(key);
            mac.update(bytes);
            byte[] encryCodes = mac.doFinal();
            System.out.println("=========消息摘要验证码=========");
            StringBuffer res = new StringBuffer();
            for (int j = 0; j < encryCodes.length;j++){
                res.append(res);
                res.append(Integer.toHexString((0x000000ff & encryCodes[j]) | 0xffffff00).substring(6));
            }
            System.out.println(res.toString());
            System.out.println();
            //保存到文件中，以便验证消息摘要
            FileOutputStream fos = new FileOutputStream("mac.dat");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(encryCodes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
