package com.example.pdmsebasa.parcial3.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pdmsebasa.parcial3.R;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    public static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String sha1(String txt) {
        return getHash(txt, "SHA1");
    }

    public static String getToken(Context context){
        SharedPreferences preferences=context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        //return preferences.getString
        return null;
    }
}
