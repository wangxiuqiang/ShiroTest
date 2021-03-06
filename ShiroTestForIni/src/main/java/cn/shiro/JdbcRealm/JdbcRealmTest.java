package cn.shiro.JdbcRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * jdbc的链接从数据库中取值进行身份认证
 */
public class JdbcRealmTest  {

    public static void  main(String[] args){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:ShiroIni/JdbcRealms.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
       //成功情况
        UsernamePasswordToken token = new UsernamePasswordToken("java","java123");
// 失败情况
//   UsernamePasswordToken token = new UsernamePasswordToken("java","java13");
        try{
            currentUser.login(token);
            System.out.println("身份认证登录成功");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("身份认证登录失败");
        }
        currentUser.logout();
    }
}
