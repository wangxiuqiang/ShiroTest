package cn.shiro.RolesTest;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用来测试该用户是否有权限,有哪些权限
 */

public class RolesTest {
    @Test
    public void RolesTestWhoHave(){
        ShiroStaticMain shiroStaticMain = new ShiroStaticMain();
//两个不同的subject
        Subject subject = shiroStaticMain.login("classpath:ShiroIni/Roles.ini","shiro","shiro123");

       // Subject subject = shiroStaticMain.login("classpath:ShiroIni/Roles.ini","shiro12","shiro123456");



       //hasRole()方法
        System.out.println(subject.hasRole("role1")?"该用户有role1权限":"该用户没有role1权限");
//   hasAllRoles()方法,在里面添加一个list即可
        List<String>  listRoles =  new ArrayList<String>();
        listRoles.add("role1");
        listRoles.add("role2");

        System.out.println(subject.hasAllRoles(listRoles)?"该用户有role1,role2权限":"该用户role1,role2权限不全有");
//hasRoles()方法 可以用Arrays.asList("","","") 方法,很方便,
        listRoles.add("role3");
   // boolean[] TorF = subject.hasRoles(listRoles);

        boolean[] TorF = subject.hasRoles(Arrays.asList("role1","role2","role3"));
        System.out.println(TorF[0]?"1该用户有role1权限":"1该用户没有role1权限");
        System.out.println(TorF[1]?"1该用户有role2权限":"1该用户没有role2权限");
        System.out.println(TorF[2]?"1该用户有role3权限":"1该用户没有role3权限");
    }
}
