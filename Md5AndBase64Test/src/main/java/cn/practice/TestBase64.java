package cn.practice;

import org.apache.shiro.codec.Base64;

public class TestBase64 {

    /**
     * Base64 编码
     * @param str
     * @return
     */
    public static String encBase64(String str) {
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * Base64 解码
     * @param str
     * @return
     */
    public static String decBase64(String str) {
        return Base64.decodeToString(str);
    }
}
