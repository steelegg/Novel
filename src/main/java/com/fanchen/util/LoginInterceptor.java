package com.fanchen.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 拦截处理程序的执行，在HandlerMapping调用之后，但在HandlerAdapter调用之前
     */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**直接获取cookie，有就判断是否匹配，没有就跳转到登陆页面*/
        String username = CookieUtil.getCookieByName(request, "username");
        String id = CookieUtil.getCookieByName(request, "id");

        /**如果Cookie不为空*/
        if (username != null && id != null) {
            /**如果不为null说明解密成功是cookie*/
            return true;
        }  // 获取不到浏览器cookie则跳转到登陆页面
        else {
            response.sendRedirect("/l");
            return false;
        }
    }

    /**
     * 拦截处理程序的执行，在HandlerAdaoter调用之后，但在DispatcherServlet呈现视图之前
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 请求处理完成后的回调，即在视图渲染之后，可用于清理资源
     */
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    }
}