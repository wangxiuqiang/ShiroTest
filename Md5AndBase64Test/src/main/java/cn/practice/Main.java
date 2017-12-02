package cn.practice;

public class Main {
    public static void main(String[] args) {
        System.out.println("进行Base64编码:" );
        System.out.println( TestBase64.encBase64("123456"));
        System.out.println("进行Base64解码:" );

        System.out.println(TestBase64.decBase64(TestBase64.encBase64("123456")));
        System.out.println("进行Md5编码:" );

        System.out.println(TestMD5.md5("123456","java"));
    }
}
