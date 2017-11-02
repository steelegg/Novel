package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.RankingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
@Controller
public class RankingController {
    @Autowired
    @SuppressWarnings("all")
    BookMapper bookMapper;

    @RequestMapping(value = "/ranking",method= RequestMethod.GET)
    public ModelAndView ranking(String s){
        ModelAndView mv=new ModelAndView();
        RankingType rankingType=new RankingType();
        if (s!=null){
            rankingType.setRanking(Integer.parseInt(s));
        }
        //点击最多
        rankingType.setMethod(0);
        List<Book> click= bookMapper.getAll(rankingType);
        mv.addObject("click",click);
        //推荐最多
        rankingType.setMethod(2);
        List<Book> recommended= bookMapper.getAll(rankingType);
        mv.addObject("recommended",recommended);
        //收藏最多
        rankingType.setMethod(1);
        List<Book> collection= bookMapper.getAll(rankingType);
        mv.addObject("collection",collection);
        //最新的
        rankingType.setMethod(3);
        List<Book> last_update_time=bookMapper.getAll(rankingType);
        mv.addObject("last_update_time",last_update_time);
        mv.setViewName("ranking");
        return mv;
    }
}
