package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/10/31.
 */
@Controller
public class RecommendedController {
    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;

    @RequestMapping(value = "/upr",method= RequestMethod.GET)
    public void updateRecommend(String id){
        if (id!=null){
            bookMapper.updateRecommended(Integer.parseInt(id));
        }
    }
}
