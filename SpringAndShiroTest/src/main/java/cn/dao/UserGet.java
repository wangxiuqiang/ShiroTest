package cn.dao;

import cn.entity.User;

public interface UserGet {
    public User query(String name) throws Exception;
}
