package com.orcas.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/10/3 16:39
 */
public class MD5Utils {

    /**
     * 对字符串进行md5加密
     * @param strValue
     * @return
     * @throws Exception
     */
    public static String getMD5Str(String strValue) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        return newstr;
    }

/*    public static void main(String[] args) {
        try {
            String md5 = getMD5Str("orcas");
            System.out.println(md5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
