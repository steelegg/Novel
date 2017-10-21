package com.fanchen.crawler;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/19.
 * 获取章节
 */

class GetChapter {
    Book getChapter(Book book, int old_book_id, BufferedReader in, URLConnection connection, Regex regex, ChapterMapper chapterMapper) {
        URL realUrl = null;
        String line = null;
        String content_url = null;
        String link = "http://www.qb5200.org/xiaoshuo/" + book.getType() + "/" + old_book_id;
        System.out.println("\n目录链接为:" + link);
        int chapter_number = 0;
        Chapter chapter = new Chapter();
        GetContent getcontent = new GetContent();
        StringBuilder sb=new StringBuilder();
        try {
            realUrl = new URL(link);
            connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));
            while ((line = in.readLine()) != null) {
                line = line.replaceAll("</div></div>$", "<br />");
                String[] array = line.split("<td>");
                for (String s : array
                        ) {
                    //获取book简介
                    Pattern p1 = Pattern.compile("(^<div class=\"intror\">)?([\\s\\S]*)<br />");
                    Matcher m1 = p1.matcher(s);
                    if (m1.find()) {
                        sb.append(m1.group(2));
                        System.out.println("这是book的简介"+m1.group(2));
                    }

                    //获取章节地址
                    Pattern p2 = Pattern.compile(regex.getchapter);
                    Matcher m2 = p2.matcher(s);
                    if (m2.find()) {
                        chapter_number++;
                        /**
                         * m.group(1)是章节数
                         * m.group(2)是章节名
                         */
                        chapter.setBook_id(book.getId());
                        chapter.setChapter_name(m2.group(2));

                        content_url = "http://www.qb5200.org/xiaoshuo/" + book.getType() + "/" + old_book_id + "/" + m2.group(1);
                        System.out.println("正在抓取:" + content_url);
                        getcontent.getContent(chapter, content_url, in, connection, regex, chapterMapper);
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        book.setIntroduction(sb.toString());
        book.setChapter_number(chapter_number);
        return book;
    }
}
