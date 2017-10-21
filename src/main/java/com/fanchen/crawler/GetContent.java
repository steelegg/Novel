package com.fanchen.crawler;

import com.fanchen.mapper.ChapterMapper;
import com.fanchen.pojo.Chapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/19.
 * 获取正文
 */

class GetContent {
    void getContent(Chapter chapter, String url, BufferedReader in, URLConnection connection, Regex regex, ChapterMapper chapterMapper) {
        URL realUrl = null;
        String line = null;
        StringBuilder sb = new StringBuilder();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}