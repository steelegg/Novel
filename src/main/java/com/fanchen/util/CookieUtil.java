package com.fanchen.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 此类实现了cookie的添加、删除、查找功能
 */
public class CookieUtil {
    /**
     * 添加cookie方法
     *
     * @param name     --cookie的名字
     * @param value    --cookie的值
     * @param response --响应对象
     */
    public static void addCookie(HttpServletResponse response, String name, String value) {
        try {
            Cookie cookie = new Cookie(name, value);
            cookie.setMaxAge(1000 * 60); //设置cookie的生存时间
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据cookie的名字查找cookie的值
     *
     * @param name    --cookie的名字
     * @param request --请求对象
     * @return 返回对应的value，没有返回null
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals(name)) {
                    try {
                        //URLDecoder.decode --解码 将ascii码转换成相应的中文
                        value=cookie.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return value;
    }


    /**
     * 根据cookie的名字删除cookie
     *
     * @param name     --要删除的cookie的名字
     * @param response --响应对象
     */

    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie c1 = new Cookie(name, "");
        c1.setMaxAge(0);
        response.addCookie(c1);
    }


}