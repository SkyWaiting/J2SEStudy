package com.example.security;

import java.io.*;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 14-1-3
 * Time: 下午4:02
 */
public class DSATest {

    public static void main(String[] args) {
        DSATest test = new DSATest();
        test.testDSA();
    }

    public void testDSA(){

        //第一步，生成秘钥对，如果已经生成过，本过程可以跳过
        //对用户来讲，myprikey.dat要保存在本地，而mypubkey.dat要发布给其他用户
        if ((new File("myprikey.dat")).exists() == false){
            if (generateKeyPair() == false){
                System.out.println("生成秘钥对失败");
                return;
            }
        }

        //第二步，此用户从文件中读入私钥，对一个字符串进行签名后保存在一个文件中（myinfo.dat）
        //并且再把myinfo.dat发送出去，为了方便，数字签名也放进了myinfo.dat中，当然，也可以分别发送。
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("myprikey.dat"));
            PrivateKey myprikey = (PrivateKey)in.readObject();
            in.close();

            //要签名的信息
            String myinfo = "这是我的信息";
            //用私钥对信息生成数字签名
            Signature signature = Signature.getInstance("DSA");
            //用私钥初始化数字签名对象
            signature.initSign(myprikey);
            //更新要由字节签名或验证的数据
            signature.update(myinfo.getBytes());
            //完成签名操作，返回已签名数组，并重置签名对象状态到调用 initSign(PrivateKey) 对其初始化时的状态
            byte[] signed = signature.sign();

            //把信息和数字签名保存在一个文件中
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myinfo.dat"));
            out.writeObject(myinfo);
            out.writeObject(signed);
            out.close();
            System.out.println("签名并生成文件成功");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("签名并生成文件失败");
        }

        //第三步，其他人通过公共方式得到此用户的公钥和文件
        //其他人用此用户的公钥对文件进行检查，如果成功说明是此用户发布的消息
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("mypubkey.dat"));
            PublicKey pubkey = (PublicKey)in.readObject();
            in.close();
            System.out.println(pubkey.getFormat());
            in = new ObjectInputStream(new FileInputStream("myinfo.dat"));
            String info = (String)in.readObject();
            byte[] signed = (byte[])in.readObject();
            in.close();

            Signature signetcheck = Signature.getInstance("DSA");
            signetcheck.initVerify(pubkey);
            signetcheck.update(info.getBytes());
            if (signetcheck.verify(signed)){
                System.out.println("info = " + info);
                System.out.println("签名正常");
            }else {
                System.out.println("签名异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成一对文件 myprikey.dat 和 mypubkey.dat--- 私钥和公钥,
     * 公钥要用户发送 ( 文件 , 网络等方法 ) 给其它用户 , 私钥保存在本地.
     * @return
     */
    public boolean generateKeyPair() {
        try {
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
            //如果设定随机产生器，就用如下代码初始化
            //SecureRandom secrand = new SecureRandom();
            //secrand.setSeed("guorui".getBytes());//初始化随机生成器
            //keygen.initialize(512,secrand);//初始化秘钥生成器
            //否则
            keygen.initialize(512);

            //生成秘钥公钥pubkey和私钥prikey
            KeyPair keys = keygen.genKeyPair();
            //KeyPair keyPair = keygen.generateKeyPair();//生成秘钥组
            PublicKey pubKey = keys.getPublic();
            PrivateKey priKey = keys.getPrivate();

            //分别保存在myprikey.dat和mypubkey.dat中，以便下次不再生成
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myprikey.dat"));
            out.writeObject(priKey);
            out.close();
            System.out.println("写入对象 prikeys ok");
            out = new ObjectOutputStream(new FileOutputStream("mypubkey.dat"));
            out.writeObject(pubKey);
            out.close();
            System.out.println("写入对象 pubkeys ok");
            System.out.println("生成密钥对成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成密钥对失败");
            return false;
        }
    }

    public String byte2hex(byte[] b){
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++){
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length()==1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }
}
