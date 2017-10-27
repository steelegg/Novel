<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>凡尘小说网</title>
    <link href="../static/css/directory/header.css" rel="stylesheet" type="text/css">
    <link href="../static/css/directory/result.css" rel="stylesheet" type="text/css">
    <link href="../static/css/footer/footer.css" rel="stylesheet" type="text/css">
    <link href="../static/fonts/icon.css" rel="stylesheet" type="text/css">

    <!--bootstrap-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<div class="header">
    <div class="login">
        <div class="login-block">
            <a class="header-login" href="/l">
                <li>登录</li>
            </a>
            <a class="header-register" href="/r">
                <li>注册</li>
            </a>
        </div>
    </div>
    <div class="menu">
        <div class="menu-a">
            <form class="header-input" action="/search" method="GET">
                <input class="header-input-text" type="text" name="search" placeholder="请输入书名或作者名...">
                <input class="header-input-submit" value="搜索" type="submit">
            </form>
            <ol>
                <li><a href="/">首页</a></li>
                <c:if test="${type==1}"><li><a class="menu-a-black" href="/all?t=1&p=0">玄幻</a></li></c:if>
                <c:if test="${type!=1}"><li><a href="/all?t=1&p=0">玄幻</a></li></c:if>

                <c:if test="${type==2}"><li><a class="menu-a-black" href="/all?t=2&p=0">都市</a></li></c:if>
                <c:if test="${type!=2}"><li><a href="/all?t=2&p=0">都市</a></li></c:if>

                <c:if test="${type==3}"><li><a class="menu-a-black" href="/all?t=3&p=0">历史</a></li></c:if>
                <c:if test="${type!=3}"><li><a href="/all?t=3&p=0">历史</a></li></c:if>

                <c:if test="${type==4}"><li><a class="menu-a-black" href="/all?t=4&p=0">武侠</a></li></c:if>
                <c:if test="${type!=4}"><li><a href="/all?t=4&p=0">武侠</a></li></c:if>

                <c:if test="${type==5}"><li><a class="menu-a-black" href="/all?t=5&p=0">科幻</a></li></c:if>
                <c:if test="${type!=5}"><li><a href="/all?t=5&p=0">科幻</a></li></c:if>

                <c:if test="${type==7}"><li><a class="menu-a-black" href="/all?t=7&p=0">灵异</a></li></c:if>
                <c:if test="${type!=7}"><li><a href="/all?t=7&p=0">灵异</a></li></c:if>

                <c:if test="${type==0}"><li><a class="menu-a-black" href="/all?t=0&p=0">全部</a></li></c:if>
                <c:if test="${type!=0}"><li><a href="/all?t=0&p=0">全部</a></li></c:if>
            </ol>
        </div>
    </div>
</div>
<div class="content">
    <div class="content-block">
        <div class="result-menu">
            <ul>
                <li>排序方式:</li>
                <c:if test="${sort!=1}">
                    <li><a href="/all?t=${type}&m=0&s=1&p=0">人气排序
                        <c:if test="${method==0}"><i class="iconfont">&#xe67d;</i></c:if></a></li>
                    <li><a href="/all?t=${type}&m=3&s=1&p=0">更新时间
                        <c:if test="${method==3}"><i class="iconfont">&#xe67d;</i></c:if></a></li>
                    <li><a href="/all?t=${type}&m=1&s=1&p=0">总收藏
                        <c:if test="${method==1}"><i class="iconfont">&#xe67d;</i></c:if></a></li>
                    <li><a href="/all?t=${type}&m=2&s=1&p=0">推荐数
                        <c:if test="${method==2}"><i class="iconfont">&#xe67d;</i></c:if></a></li>
                </c:if>

                <c:if test="${sort==1}">
                    <li><a href="/all?t=${type}&m=0&s=0&p=0">人气排序
                        <c:if test="${method==0}"><i class="iconfont">&#xe62d;</i></c:if></a></li>
                    <li><a href="/all?t=${type}&m=3&s=0&p=0">更新时间
                        <c:if test="${method==3}"><i class="iconfont">&#xe62d;</i></c:if></a></li>
                    <li><a href="/all?t=${type}&m=1&s=0&p=0">总收藏
                        <c:if test="${method==1}"><i class="iconfont">&#xe62d;</i></c:if></a></li>
                    <li><a href="/all?t=${type}&m=2&s=0&p=0">推荐数
                        <c:if test="${method==2}"><i class="iconfont">&#xe62d;</i></c:if></a></li>
                </c:if>
            </ul>
        </div>
        <div class="result-content">
            <ul>
                <c:forEach items="${book}" var="b">
                    <li class="result-content-li">
                        <a>
                            <img src="${b.cover}">
                        </a>
                        <div class="introduction">
                            <h4>${b.book_name}</h4>
                            <p>
                                <span>${b.author}</span>
                                <span>${b.type}</span>
                                <span>
                                    <c:if test="${b.status==1}">完本</c:if>
                                    <c:if test="${b.status==0}">连载</c:if>
                                </span>
                            </p>
                            <p class="introduction-block">${b.introduction}</p>
                            <p><a href="#">最后更新时间${b.last_update_time}</a></p>
                        </div>
                        <div class="result-content-right">
                            <ul>
                                <li>${b.chapter_number}<span>总章节</span>
                                <li>
                                <li>${b.recommended}<span>总推荐</span>
                                <li>
                                <li>${b.click}<span>总点击</span>
                                <li>
                            </ul>
                            <p>
                                <a class="red-but" href="/book?id=${b.id}">书籍详情</a>
                                <a class="blue-but" href="#">加入书架</a>
                            </p>
                        </div>
                    </li>
                </c:forEach>
            </ul>

            <c:if test="${sort==null}">
                <c:if test="${page==0 && max <=10}">
                </c:if>
                <c:if test="${page==0 && max>=11}">
                    <a href="/all?t=${type}&p=${page+10}">下一页</a>
                </c:if>
                <c:if test="${page>=10 && max >= page+20}">
                    <a href="/all?t=${type}&p=${page-10}">上一页</a>
                    <a href="/all?t=${type}&p=${page+10}">下一页</a>
                </c:if>
                <c:if test="${page>=10 && page+10 == max}">
                    <a href="/all?t=${type}&p=${page-10}">上一页</a>
                </c:if>
            </c:if>

            <c:if test="${sort!=null}">
                <c:if test="${page==0 && max <=10}">
                </c:if>
                <c:if test="${page==0 && max>=11}">
                    <a href="/all?t=${type}&m=${method}&s=${sort}&p=${page+10}">下一页</a>
                </c:if>
                <c:if test="${page>=10 && max >= page+20}">
                    <a href="/all?t=${type}&m=${method}&s=${sort}&p=${page-10}">上一页</a>
                    <a href="/all?t=${type}&m=${method}&s=${sort}&p=${page+10}">下一页</a>
                </c:if>
                <c:if test="${page>=10 && page+10 == max}">
                    <a href="/all?t=${type}&m=${method}&s=${sort}&p=${page-10}">上一页</a>
                </c:if>
            </c:if>

        </div>
    </div>
</div>
<div class="footer">
    <div class="footer-block">
        <h4>声明:本站一切资源均来源于网络,仅供交流学习使用,如有侵权!请联系站长</h4>
        <p>站长邮箱897254488@qq.com</p>
    </div>
</div>
</body>
</html>