package com.oysen.internalcommon.util;

public class SsePrefixUtils {

    public static  final String sperator = "$";

    public  static String generatorSseKey(Long userId , String identity){
        return userId+sperator+identity;
    }
}
