package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 * 这是搜索控制器
 */
@Controller
public class ResultController {
    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;
    @Autowired
    @SuppressWarnings("all")
    private ChapterMapper chapterMapper;

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String select(String search, Model model) {
        Book b = new Book();
        if (search != null) {
            b.setBook_name("%" + search + "%");
            b.setAuthor("%" + search + "%");
            List<Book> list = bookMapper.search(b);
            model.addAttribute("book", list);
        }
        return "result";
    }
}
