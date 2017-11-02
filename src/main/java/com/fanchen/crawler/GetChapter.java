package com.fanchen.crawler;

import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;
import org.apache.log4j.Logger;

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

    public static Logger log = Logger.getLogger(GetChapter.class);

    Book getChapter(Book book, int book_num, int old_book_id, BufferedReader in, URLConnection connection, Regex regex, ChapterMapper chapterMapper) {
        URL realUrl = null;
        String line = null;
        String content_url = null;
        String link = "http://www.qb5200.org/xiaoshuo/" + book_num + "/" + old_book_id;
        String sss = null;
        log.info("\n目录链接为:" + link);
//        System.out.println("\n目录链接为:" + link);
        int chapter_number = 0;
        Chapter chapter = new Chapter();
        GetContent getcontent = new GetContent();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        try {
            realUrl = new URL(link);
            connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));
            while ((line = in.readLine()) != null) {
                line = line.replaceAll("</div></div>$", "<br />");
                String[] array = line.split("</td>|<td>");
                for (String s : array
                        ) {
                    //获取book简介
                    Pattern p1 = Pattern.compile("(^<div class=\"intror\">)?([\\s\\S]*)<br />");
                    Matcher m1 = p1.matcher(s);

                    if (m1.find()) {
                        if (m1.group(1)!=null){
                            sss=m1.group(1)+m1.group(2);
                            sss=sss.replaceAll("<div class=\"intror\">.*<br />","");
                            sb.append(sss);
                        }else{
                            sb.append(m1.group(2));
                        }
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
                        content_url = "http://www.qb5200.org/xiaoshuo/" + book_num + "/" + old_book_id + "/" + m2.group(1);
//                        log.info("正在抓取:" + content_url + "\t章节名:" + m2.group(2) + "..");
//                        System.out.println("正在抓取:" + content_url + "\t章节名:" + m2.group(2) + "..");
                        getcontent.getContent(chapter, book, chapter_number, content_url, in, connection, regex, chapterMapper);
                    }
                }
            }
            in.close();
            try {
                //等待1秒
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("简介为:" + sb.toString());
//        System.out.println("简介为:" + sb.toString());
        book.setIntroduction(sb.toString());
        book.setChapter_number(chapter_number);
        //章节结束的位置等于开始位置加上总章节数
        book.setEnd_id(book.getStart_id() + chapter_number - 1);
        log.info("开始位置为:" + book.getStart_id() + "结束位置为:" + book.getEnd_id());
//        System.out.println("开始位置为:" + book.getStart_id() + "结束位置为:" + book.getEnd_id());
        return book;
    }
}
