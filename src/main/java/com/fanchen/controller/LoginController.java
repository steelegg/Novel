package com.fanchen.controller;

import com.fanchen.mapper.UserMapper;
import com.fanchen.pojo.User;
import com.fanchen.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "/l/login",method= RequestMethod.POST)
    public String login(String mob, String pwd, Model model, HttpServletResponse response, HttpServletRequest request) {
        User user = new User();
        model.addAttribute("s", "0");
        if (mob != null && pwd != null) {
            try {
                System.out.println("手机号:" + mob + "密码" + pwd);
                user.setMobile(Long.parseLong(mob));
                user = userMapper.selectUser(user);
                if (user.getPassword().equals(pwd)) {
                    CookieUtil.addCookie(response, "username", user.getName());
                    CookieUtil.addCookie(response, "id", String.valueOf(user.getId()));
                    model.addAttribute("info", "你成功登录了");
                    return "info";
                } else {
                    model.addAttribute("info", "你登录失败了,原因是密码或账号不正确...");
                    return "info";
                }
            } catch (Exception e) {
                model.addAttribute("info", "你登录失败了");
                return "info";
            }
        }else{
            model.addAttribute("info","错误,用户名或密码为空");
            return "info";
        }
    }

}
