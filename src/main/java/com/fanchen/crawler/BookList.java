package com.fanchen.crawler;

import com.fanchen.mapper.BookMapper;
import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/19.
 * 获取书目录
 */
public class BookList {

    public static Logger log = Logger.getLogger(BookList.class);

    public static void getList(ChapterMapper chapterMapper, BookMapper bookMapper) {
        int book_id;
        int book_num;
        String line = null;
        String cover = null;
        String book_name;
        String type;

        BufferedReader in = null;
        Regex regex = new Regex();
        Book book = new Book();
        Book new_book = new Book();
        GetChapter getchapter = new GetChapter();
        try {
            for (int x = 337; x >1; x--) {
                long startMili = System.currentTimeMillis();
                String url = "http://www.qb5200.org/top/allvisit_" + x + ".html";
                URL realUrl = new URL(url);
                URLConnection connection = realUrl.openConnection();
                connection.connect();
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));

                while ((line = in.readLine()) != null) {

                    /**获取书名*/
                    Pattern p1 = Pattern.compile(regex.get_book_name);
                    /**作者*/
                    Pattern p2 = Pattern.compile(regex.get_author);
                    /**最后更新时间*/
                    Pattern p3 = Pattern.compile(regex.last_get_update_time);

                    Matcher m1 = p1.matcher(line);
                    Matcher m2 = p2.matcher(line);
                    Matcher m3 = p3.matcher(line);

                    if (m1.find() && m1.group(3) != null) {
                        //m1.group(1) 是书类型
                        //m1.group(2) 是书id
                        //m1.group(3) 是书名
                        book_name = m1.group(3);
                        if (bookMapper.getName(book_name)!=null){
                            //如果书存在跳出循环
                            continue;
                        }
                        book_id = Integer.parseInt(m1.group(2));
                        book_num = Integer.parseInt(m1.group(1));

                        cover = "http://www.qb5200.org/files/article/image/" + book_num + "/" + book_id + "/" + book_id + "s.jpg";
                        //输出类型
                        type = GetType.getType(book_id, in, connection, regex);
//                        System.out.println("类型:" + type);
                        log.info("类型:" + type);
                        if (type == null) {
                            book.setType("未知");
                        } else {
                            book.setType(type);
                        }
                        book.setBook_name(book_name);
                        book.setCover(cover);

                        //这里先插入数据获得返回的id
                        bookMapper.insert(book);
                        log.info("正在爬取id为" + book.getId() + "的书");
//                        System.out.println("正在爬取id为" + book.getId() + "的书");
                        new_book = getchapter.getChapter(book, book_num, book_id, in, connection, regex, chapterMapper);

                    }

                    if (m2.find() && m2.group(1) != null) {
                        //作者
                        book.setAuthor(m2.group(1));
                    }
                    if (m3.find() && m3.group(1) != null && book.getBook_name() != null && book.getAuthor() != null) {
                        //最后更新时间
                        book.setLast_update_time(m3.group(1));
                        bookMapper.update(new_book);
                    }
                }

                long endMili = System.currentTimeMillis();
                log.info("第" + x + "页" + "本页耗时为:" + (endMili - startMili) + "毫秒");
//                System.out.println("第" + x + "页" + "本页耗时为:" + (endMili - startMili) + "毫秒");
            }
        } catch (Exception e) {
            log.error("错误位置为BookList" + e);
//            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
