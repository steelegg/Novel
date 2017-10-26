package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.RankingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
public class getAllController {

    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;

    @RequestMapping("/all")
    public String getAll(String t, String m, String s, Model model) {
        RankingType rankingType = new RankingType();

        if (t != null && m != null && s != null) {
            System.out.println("得到了三个参数");
            rankingType.setType(Integer.parseInt(t));
            rankingType.setMethod(Integer.parseInt(m));
            rankingType.setSort(Integer.parseInt(s));
            List<Book> book = bookMapper.getAll(rankingType);
            model.addAttribute("book", book);
            model.addAttribute("type",t);
            model.addAttribute("method",m);
            model.addAttribute("sort",s);
            return "result";
        }

        if (t != null && m != null) {
            System.out.println("得到了两个参数");
            rankingType.setType(Integer.parseInt(t));
            rankingType.setSort(Integer.parseInt(m));
            List<Book> book = bookMapper.getAll(rankingType);
            model.addAttribute("book", book);
            model.addAttribute("type",t);
            return "result";
        }

        if (t != null) {
            System.out.println("得到了一个参数");
            rankingType.setType(Integer.parseInt(t));
            List<Book> book = bookMapper.getAll(rankingType);
            model.addAttribute("book", book);
            model.addAttribute("type",t);
            return "result";
        }

        return "result";
    }
}
