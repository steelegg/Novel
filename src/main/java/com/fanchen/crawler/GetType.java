package com.fanchen.crawler;

import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Book;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/25.
 */
public class GetType {

    public static Logger log = Logger.getLogger(GetType.class);

    static String getType(int book_id, BufferedReader in, URLConnection connection, Regex regex) {
        String get_type = "http://www.qb5200.org/book/" + book_id + ".html";
        String line = null;
        String type = null;
        URL realUrl = null;
        try {
            realUrl = new URL(get_type);
            connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));
            while ((line = in.readLine()) != null) {
                Pattern p = Pattern.compile("<td width=\"34%\">类别：([\\u4e00-\\u9fa5]*)小说</td>");
                Matcher m = p.matcher(line);
                if (m.find() && m.group(1) != null) {
                    type = m.group(1);
                    break;
                }
            }
        } catch (IOException e) {
            log.info("GetType获取类型出错...."+e);
//            System.out.println("获取书类型出错");
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return type;
    }
}
