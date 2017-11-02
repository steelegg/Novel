package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.mapper.UserDateMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;
import com.fanchen.pojo.User;
import com.fanchen.pojo.UserDate;
import com.fanchen.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/24.
 */
@Controller
public class TextController {
    @Autowired
    @SuppressWarnings("all")
    private ChapterMapper chapterMapper;
    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;
    @Autowired
    @SuppressWarnings("all")
    private UserDateMapper userDateMapper;

    @RequestMapping(value = "/text",method= RequestMethod.GET)
    public ModelAndView getText(String id, ModelAndView modelAndView,HttpServletRequest r) {
        if (id != null) {
            Chapter chapter = chapterMapper.getChapter(Integer.parseInt(id));
            Book book = bookMapper.getEnd(chapter.getBook_id());
            String s=CookieUtil.getCookieByName(r,"userid");

            modelAndView.addObject("chapter", chapter);
            modelAndView.addObject("book", book);
        }
        modelAndView.setViewName("text");
        return modelAndView;
    }
}
