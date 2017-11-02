package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.UserDateMapper;
import com.fanchen.pojo.UserDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
public class AddBookController {

    @Autowired
    @SuppressWarnings("all")
    private UserDateMapper userDateMapper;
    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;

    @RequestMapping(value = "/add",method= RequestMethod.GET)
    public void addBook(String bid, String uid){
        if (uid!=null&&bid!=null){
            UserDate u=new UserDate();
            u.setUid(Integer.parseInt(uid));
            u.setBook_id(Integer.parseInt(bid));
            if (userDateMapper.select(u)==null){
                userDateMapper.insert(u);
                //更新收藏数
                bookMapper.updateCollection(Integer.parseInt(bid));
            }
        }
    }
}
