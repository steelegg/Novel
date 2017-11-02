package com.fanchen.controller;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.UserDateMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.UserDate;
import com.fanchen.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
@Controller
public class UserController {

    @Autowired
    @SuppressWarnings("all")
    private UserDateMapper userDateMapper;
    @Autowired
    @SuppressWarnings("all")
    private BookMapper bookMapper;

    @RequestMapping(value = "/u/collection",method= RequestMethod.GET)
    public String collection(String id, Model model, HttpServletRequest request){
        if (id != null){
            List<Book> list=userDateMapper.getId(Integer.parseInt(id));
            for (Book b:list
                 ) {
                b.setEnd_chapter(bookMapper.getEndChapter(b.getEnd_id()));
            }
            model.addAttribute("book",list);
        }
        String cid=CookieUtil.getCookieByName(request,"id");
        if (cid.equals(id)){
            model.addAttribute("mec","我的收藏");
        }else{
            model.addAttribute("mec","他的收藏");
        }
        return "collection";
    }

    @RequestMapping("/u/history")
    public String history(String id,Model model,HttpServletRequest request){
        model.addAttribute("id",id);



        String cid=CookieUtil.getCookieByName(request,"id");
        if (cid.equals(id)){
            model.addAttribute("mec","我的收藏");
        }else{
            model.addAttribute("mec","他的收藏");
        }
        return "history";
    }

    @RequestMapping("/u/comment")
    public String comment(String id,Model model,HttpServletRequest request){
        model.addAttribute("id",id);

        String cid=CookieUtil.getCookieByName(request,"id");
        if (cid.equals(id)){
            model.addAttribute("mec","我的收藏");
        }else{
            model.addAttribute("mec","他的收藏");
        }
        return "comment";
    }

}
