package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.RankingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 * 首页排行榜
 */

@Controller
public class IndexController {

    @Autowired
    @SuppressWarnings("all")
    BookMapper bookMapper;

    @RequestMapping(value = "/",method= RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView();
        RankingType rankingType=new RankingType();
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
        mv.setViewName("index");
        return mv;
    }


}
