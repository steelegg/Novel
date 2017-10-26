package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/text")
    public ModelAndView getText(String id, ModelAndView modelAndView) {
        if (id != null) {
            Chapter chapter = chapterMapper.getChapter(Integer.parseInt(id));
            Book book = bookMapper.getEnd(chapter.getBook_id());
            modelAndView.addObject("chapter", chapter);
            modelAndView.addObject("book", book);
        }
        modelAndView.setViewName("text");
        return modelAndView;
    }
}
