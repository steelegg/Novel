package com.fanchen.test;


import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
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


}
