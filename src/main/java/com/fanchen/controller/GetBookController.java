package com.fanchen.controller;

import com.fanchen.crawler.BookList;
import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/10/30.
 *
 */
@Controller
public class GetBookController {

    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;
    @Autowired

    @SuppressWarnings("all")
    private ChapterMapper chapterMapper;

    public static Logger log = Logger.getLogger(GetBookController.class);

    @RequestMapping(value = "/getBook",method= RequestMethod.GET)
    public void getBook(String id){
        try{
            BookList.getList(chapterMapper,bookMapper);
        }catch (Exception e){
            log.error("爬虫出错..."+e);
        }
    }

}
