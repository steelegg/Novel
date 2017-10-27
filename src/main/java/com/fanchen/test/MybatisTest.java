package com.fanchen.test;


import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.RankingType;
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

}
