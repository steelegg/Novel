package com.fanchen.controller;

import com.fanchen.mapper.UserMapper;
import com.fanchen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/10/26.
 */
@Controller
public class RegisterController {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    @RequestMapping(value = "/r",method= RequestMethod.GET)
    public String goLogin() {
        return "register";
    }

    @RequestMapping("/r/register")
    public String register(String mobile, String password, Model model){
        User user=new User();
        if (mobile != null && password != null) {
            System.out.println(mobile+password);
            user.setMobile(Long.parseLong(mobile));
            user.setPassword(password);
            userMapper.insert(user);
        }
        model.addAttribute("info","你已经成功注册");
        model.addAttribute("id",user.getId());

        return "info";
    }
}
