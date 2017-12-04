package cn.service.Impl;

import cn.entity.User;
import cn.dao.UserGet;
import cn.service.loginTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginTestImpl implements loginTest {
    @Autowired
    UserGet userGet;

    public User getUser(String name) throws Exception {
       User user  =   userGet.query(name);
       if(user == null ) {
           return null;
       }
       else {
       System.out.println(user.getName() + "\n" + user.getPassword());
       return user;}
    }
}
