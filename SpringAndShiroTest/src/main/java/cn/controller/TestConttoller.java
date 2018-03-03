package cn.controller;

import cn.entity.User;
import cn.service.Impl.loginTestImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class TestConttoller {

    @Autowired
    loginTestImpl loginTest;

    @RequestMapping("/loginBefore")
    public String loginBefore() throws Exception{
        return "index";
    }
    @RequestMapping(value="/login")
    public String login(User user,Model model) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
        System.out.println("表单传过来的"+user.getName()  +"\n"  +  user.getPassword());
        try{
            subject.login(token);
            return "redirect:/success";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("no","失败");
            return "index";
        }
//          User user1 = loginTest.getUser(user.getName());
//          if (user1!=null){
//              System.out.println(user.getName()  +"\n"  +  user.getPassword());
//              System.out.println(user1.getName()  +"\n"  +  user1.getPassword());
//              return "redirect:/success";
//          }else{
//              return "index";
//          }
    }
    @RequestMapping(value="/success")
    public String success() {
        return "success" ;
    }
}
