package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 * 小说目录页
 */
@Controller
public class ListController {
    @Autowired
    @SuppressWarnings("all")
    private ChapterMapper chapterMapper;
    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String list(String id, Model model) {
        Book book = new Book();
        if (id != null) {
            //发送目录
            List<Chapter> list = chapterMapper.getChapters(Integer.parseInt(id));
            //更新点击数
            bookMapper.updateClick(Integer.parseInt(id));
            model.addAttribute("chapter", list);
            //发送book信息和简介
            book = bookMapper.selectId(Integer.parseInt(id));
            model.addAttribute("book", book);
        }else{
            model.addAttribute("对不起找不到这本书");
            return "info";
        }
        return "directory";
    }

}
