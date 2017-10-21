package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/8/29.
 * index控制器类
 */

@Controller
public class IndexController {

    @Autowired
    @SuppressWarnings("all")
    BookMapper bookMapper;

    @RequestMapping("/")
    public String index(Model model){
//        Book t=bookMapper.get(1);
//        model.addAttribute("teacher",t);
        return "index";
    }
}
