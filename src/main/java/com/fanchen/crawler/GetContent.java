package com.fanchen.crawler;

import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/19.
 * 获取正文
 */

class GetContent {
    public static Logger log = Logger.getLogger(GetContent.class);

    void getContent(Chapter chapter, Book book, int chapter_number, String url, BufferedReader in, URLConnection connection, Regex regex, ChapterMapper chapterMapper) {
        URL realUrl = null;
        String line = null;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            realUrl = new URL(url);
            connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));
            while ((line = in.readLine()) != null) {
                String[] array = line.split("^<br />");
                for (String s : array
                        ) {
                    Pattern p = Pattern.compile(regex.getcontent);
                    Matcher m = p.matcher(s);
                    if (m.find() && m.group(1) != null) {
                        sb.append("<br />\n").append(m.group(1));
                    }
                }
            }
            chapter.setContent(sb.toString());
            chapterMapper.insert(chapter);
            if (chapter_number == 1) {
                book.setStart_id(chapter.getId());
            }
        } catch (IOException e) {
            log.error("获取正文错误..." + e);
            e.printStackTrace();
        }
    }
}
