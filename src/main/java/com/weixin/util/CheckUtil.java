package com.weixin.util;

import java.util.Arrays;

public class CheckUtil {
    private static  final String token = "lichaogeToken";
    public static boolean checkSignature (String signature,String timestamp,String nonce) {

        String[] arr = new String[]{token,timestamp,nonce};
        //排序
        Arrays.sort(arr);
        //生成字符串
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        EncryptionAndDecryption decryption = new EncryptionAndDecryption();
        String encryptContent = decryption.encryptToSHA(content.toString());
        return encryptContent.equals(signature);
    }
}
