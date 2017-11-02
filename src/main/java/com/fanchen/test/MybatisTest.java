package com.fanchen.test;


import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.mapper.UserDateMapper;
import com.fanchen.mapper.UserMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.RankingType;
import com.fanchen.pojo.User;
import com.fanchen.pojo.UserDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDateMapper userDateMapper;

    @Test
    public void getMax() {
        RankingType rankingType=new RankingType();
        rankingType.setType(0);
        int i = bookMapper.sum(rankingType);
        System.out.println(i);
    }

    @Test
    public void test() {
        int sum = 31;
        if ((sum % 10) != 0) {
            sum = (sum - sum % 10) + 10;
        }
        System.out.println(sum);
    }

    @Test
    public void selectUser(){
        User user=new User();
        user.setMobile(Long.parseLong("123456"));
        user.setPassword("123456");
        user=userMapper.selectUser(user);
        System.out.println(user.toString());

    }

    @Test
    public void date(){
        long dt = new Date().getTime();
        System.out.println(dt);
    }

    @Test
    public void insert(){
        UserDate userDate=new UserDate();
        userDate.setId(1003);
        userDate.setUid(1);
        userDateMapper.insert(userDate);
    }

    @Test
    public void selectUserDate(){
        UserDate u=new UserDate();
        u.setUid(1);
        u.setBook_id(1028);
        UserDate us=userDateMapper.select(u);
        if(us!=null){
            System.out.println(us.toString());
        }else{
            System.out.println("没有");
        }
    }

    @Test
    public void getId(){
        List<Book> list=userDateMapper.getId(1);
        for (Book b:list
             ) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void getEndChapter(){
        String b=bookMapper.getEndChapter(10003);
        System.out.println(b);
    }

    @Test
    public void Threed(){
        for(int x=3;x<339;x+=3){
            System.out.println(x);
        }
    }


    public class DoSomething implements Runnable {
        private String name;

        public DoSomething(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                for (long k = 0; k < 100000000; k++) ;
                System.out.println(name + ": " + i);
            }
        }
    }
    @Test
    public void getBook_name(){
        System.out.println(bookMapper.getName("旷世神医"));
    }

}
