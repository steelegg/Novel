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
 *
 */
@Controller
public class getAllController {

    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;

    @RequestMapping("/all")
    public String getAll(String t, String m, String s, String p, Model model) {
        RankingType rankingType = new RankingType();

        if (t != null && m != null && s != null && p != null) {
            System.out.println("得到了四个参数");
            rankingType.setType(Integer.parseInt(t));
            rankingType.setMethod(Integer.parseInt(m));
            rankingType.setSort(Integer.parseInt(s));
            rankingType.setPage(Integer.parseInt(p));
            List<Book> book = bookMapper.getAll(rankingType);
            int max = bookMapper.sum(rankingType);
            if (max % 10 != 0) {
                max = (max - (max % 10)) + 10;
            }
            model.addAttribute("book", book);
            model.addAttribute("type", t);
            model.addAttribute("method", m);
            model.addAttribute("sort", s);
            model.addAttribute("page", p);
            model.addAttribute("max", max);
            model.addAttribute("num", book.size());

            return "result";
        }

        if (t != null && p != null) {
            System.out.println("得到了两个参数");
            rankingType.setType(Integer.parseInt(t));
            rankingType.setPage(Integer.parseInt(p));
            List<Book> book = bookMapper.getAll(rankingType);
            int max = bookMapper.sum(rankingType);
            if (max % 10 != 0) {
                max = (max - (max % 10)) + 10;
            }
            model.addAttribute("book", book);
            model.addAttribute("type", t);
            model.addAttribute("page", p);
            model.addAttribute("max", max);
            model.addAttribute("num", book.size());
            return "result";
        }
        return "result";
    }
}
