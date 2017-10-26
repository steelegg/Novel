package com.fanchen.crawler;

/**
 * Created by Administrator on 2017/10/18.
 * 正则表达式类
 */
public class Regex {
    //书名
    public String get_book_name="<a href=\"http://www.qb5200.org/xiaoshuo/(\\d*)/(\\d*)/\" target=\"_blank\">(.*)</a>";
    //作者
    public String get_author="<td class=\"odd\">([\\u4e00-\\u9fa5]*)</td>";
    //更新时间
    public String last_get_update_time="<td class=\"odd\" align=\"center\">(.*)</td>";
    //章节
    public String getchapter="<a href=\"(\\d*.html)\"\\s?>(.*)</a>";
    //获取正文
    public String getcontent="((<div id=\"content\">)?(&nbsp;){4}[\\s\\S]*)?";
}
