package com.douyu.douyulogin;

import android.util.Base64;

import java.security.MessageDigest;

public class Algorithm {

    // MD5算法
    public static String MD5encrypt(String arg) throws Exception {
        String input = arg;
        // 算法
        String algorithm = "MD5";
        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 消息数字摘要
        byte[] digest = messageDigest.digest(input.getBytes());

        // 创建对象用来拼接
        String result = "";

        for (byte b : digest) {
            // 转成 16进制
            String temp = Integer.toHexString(b & 0xff);
            if (temp.length() == 1) {
                temp = "0" + temp;
            }
            result += temp;
        }
        return result;
    }

    // RC4  加密和解密都用这一个方法
    public static String HloveyRC4(String aInput) {
        String aKey = "7TkbRSEWvVWebXbr";
        int[] iS = new int[256];
        byte[] iK = new byte[256];
        for (int i = 0; i < 256; i++)
            iS[i] = i;
        int j = 1;
        for (short i = 0; i < 256; i++) {
            iK[i] = (byte) aKey.charAt((i % aKey.length()));
        }
        j = 0;
        for (int i = 0; i < 255; i++) {
            j = (j + iS[i] + iK[i]) % 256;
            int temp = iS[i];
            iS[i] = iS[j];
            iS[j] = temp;
        }
        int i = 0;
        j = 0;
        char[] iInputChar = aInput.toCharArray();
        byte[] iOutputChar = new byte[iInputChar.length];
        for (short x = 0; x < iInputChar.length; x++) {
            i = (i + 1) % 256;
            j = (j + iS[i]) % 256;
            int temp = iS[i];
            iS[i] = iS[j];
            iS[j] = temp;
            int t = (iS[i] + (iS[j] % 256)) % 256;
            int iY = iS[t];
            char iCY = (char) iY;
            iOutputChar[x] = (byte) (iInputChar[x] ^ iCY);
        }
        String result =Base64.encodeToString(iOutputChar, 0);
        return result;
    }

}
