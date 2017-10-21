package com.fanchen.test;


import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ChapterMapper chapterMapper;

    @Test
    public void testList() {
        Book b=new Book();
        b.setBook_name("斗罗大陆");
        b.setAuthor("唐家三少");
        b.setChapter_number(2100);
        b.setCollection(10000);
        b.setLast_update_time("2016-10-6");
        int cs = bookMapper.insert(b);
        System.out.println(b.getId());
    }
    @Test
    public void insertChapter(){
        Chapter chapter=new Chapter();
//        chapter.setBook_id(1);
//        chapter.setChapter_name("aaa");
//        chapter.setContent("dasdafaosuhdadoahsdiahdiahih");
        chapterMapper.insert(chapter);
    }
}
