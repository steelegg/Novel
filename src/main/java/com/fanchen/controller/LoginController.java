package com.fanchen.controller;

import com.fanchen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/10/26.
 */
@Controller
public class LoginController {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    @RequestMapping("/l")
    public String goLogin() {
        return "login";
    }

    @RequestMapping("/l/login")
    public String login(String mob, String pwd, Model model) {
        if (mob!=null&&pwd!=null){
            System.out.println("手机号:"+mob+"密码"+pwd);
            

        }

        return "info";
    }

}
