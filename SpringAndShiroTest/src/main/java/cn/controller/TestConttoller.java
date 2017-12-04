package cn.controller;

import cn.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class TestConttoller {

    @RequestMapping("/loginBefore")
    public String loginBefore() throws Exception{
        return "index";
    }
    @RequestMapping(value="/login")
    public String login(User user,Model model) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
        try{
            subject.login(token);
            return "redirect:/success";
        }catch (Exception e){
            model.addAttribute("no","失败");
            return "index";
        }
    }
    @RequestMapping(value="/success")
    public String success() {
        return "success" ;
    }
}
