package cn.practice;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMD5 {
    /**
     * md5编码 ,md5的编码方式不可逆,加一个salt表示作料,理论上让
     * md5在不知道salt的前提下不能破解  ,salt一般在配置文件中配置,在
     * 需要的时候加载
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str, String salt){
        return new Md5Hash(str,salt).toString();
    }
}
