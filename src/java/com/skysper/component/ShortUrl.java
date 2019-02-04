package com.skysper.component;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * 短网址
 */
public class ShortUrl {

    private ShortUrl() {
    }

    //hash碰撞的情况，需要其他的方式来结合处理
    //如数据库或者字典
    private static int getHashCode(String code) {
        HashCode result = Hashing.murmur3_32().hashString(code, Charset.forName("UTF-8"));
        // 移除负数情况
        return result.asInt() & 0x7fffffff;
    }

    private static final String CHARS = "0123456789abcdefghijqlmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXWZ";
    private static final char[] ARRAY = CHARS.toCharArray();
    private static final int CHARS_LENGTH = 62;

    /**
     * 针对返回的hash code进行62进制转化
     * @param url
     * @return
     */
    public static String hash(String url) {
        int code = getHashCode(url);
        StringBuilder stringBuilder = new StringBuilder();
        while(code > 0) {
            int index = code % CHARS_LENGTH;
            code = code / CHARS_LENGTH;
            stringBuilder.insert(0,ARRAY[index]);
        }
        return stringBuilder.toString();
    }

}
