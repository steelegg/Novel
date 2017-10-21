package com.fanchen.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/20.
 */
public class Split {
    @Test
    public void split() {
        String line = "sdadasigduisaisagkudhsagdiashildhauasi<br /> oaishdapsdasdjad;amsda,l;dkas<br />sadahdakjsldasdhahd<br />";
        String[] array = line.split("<br />");
        for (String s : array
                ) {
            System.out.println(s);
        }
    }

    @Test
    public void getImg() {
        String url = "http://www.qb5200.org/xiaoshuo/76/76174/";
        BufferedReader in = null;
        String line = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));
            connection.connect();
            while ((line = in.readLine()) != null) {


                Pattern p2 = Pattern.compile("<table cellpadding=\"3\"\\t?");
                Matcher m2 =p2.matcher(line);
                if (m2.find()){
                    System.out.println("退出");
                    break;
                }else{
                    line = line.replaceAll("</div></div>$", "<br />");
                    Pattern p1 = Pattern.compile("(^<div class=\"intror\">)?([\\s\\S]*)<br />");
                    Matcher m1 = p1.matcher(line);

                    if (m1.find()) {
                        System.out.println(m1.group(2));
                    }
                }




            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
