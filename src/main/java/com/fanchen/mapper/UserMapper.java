package com.fanchen.mapper;

import com.fanchen.pojo.User;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface UserMapper {
    int insert(User user);
    User selectUser(User user);
}
