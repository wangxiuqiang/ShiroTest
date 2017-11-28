package cn.shiro.HelloWorld;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloWorld {
     public static void  main(String[] args){
         Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:ShiroIni/HelloWorld.ini");

         SecurityManager securityManager = factory.getInstance();
         SecurityUtils.setSecurityManager(securityManager);
         Subject currentUser = SecurityUtils.getSubject();
         UsernamePasswordToken token = new UsernamePasswordToken("password","123");
         try{
             currentUser.login(token);
             System.out.println("登录成功");
         }catch (Exception e) {
             e.printStackTrace();
             System.out.println("登录失败");
         }
         currentUser.logout();
     }

}
