package cn.shiroTest.Realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * 自定义的Realm数据是自己设的
 */
public class MyRealm1 implements Realm {
    //用来返回自己的名字,以确保能够找到该类的存在
    public String getName() {
        return "MyRealm1";
    }

    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal(); //得到用户名
        String password =  new String((char[]) token.getCredentials()); //得到密码

        //自己的的zhang的名字

        if(!"zhang".equals(username)){
            throw new UnknownAccountException();//如果用户名错误
        }
        if(!"123".equals(password) ){
            throw new IncorrectCredentialsException();//如果密码错误

        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
