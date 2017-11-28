package cn.shiro.PermissionTest;

import cn.shiro.RolesTest.ShiroStaticMain;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    @Test
    public void permissionTest() {
       Subject subject = ShiroStaticMain.login("classpath:ShiroIni/Permission.ini","shiro","shiro123");
      //  Subject subject = ShiroStaticMain.login("classpath:ShiroIni/Permission.ini","shiro12","shiro123456");
        /**
         * 进行权限测试,标准化的权限测试方法使用的参数是permission类型的,实际开发一般用String
         *不能用list,.只能是多个字符串
         */




        System.out.println(subject.isPermitted("user:select")?"该用户有user:select这个权限":"该用户没有user:select这个权限");
        System.out.println();


        boolean[] TorF = subject.isPermitted("user:select","user:delete","user:add");
        System.out.println(TorF[0]?"该用户有user:select这个权限":"该用户没有user:select这个权限");
        System.out.println(TorF[1]?"该用户有user:delete这个权限":"该用户没有user:delete这个权限");
        System.out.println(TorF[2]?"该用户有user:add这个权限":"该用户没有user:add这个权限");
        System.out.println();
        System.out.println(subject.isPermittedAll("user:select","user:delete","user:add")?"该用户全有这三个权限":"该用户不全有这三个权限");
       subject.logout();
    }
    /**
     * 同样和角色一样也有check*方法    ,没返回值  ,没有直接报错 ,
     */
    @Test
    public void checkPermissionTest() {
       // Subject subject = ShiroStaticMain.login("classpath:ShiroIni/Permission.ini", "shiro", "shiro123");
         Subject subject = ShiroStaticMain.login("classpath:ShiroIni/Permission.ini","shiro12","shiro123456");
//        subject.checkPermission("user:add");
        subject.checkPermissions("user:add","user:select");
        subject.logout();
    }
}
