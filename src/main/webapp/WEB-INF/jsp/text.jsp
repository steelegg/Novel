<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${chapter.chapter_name}</title>
    <link href="../static/css/text/content.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/text/header.css" rel="stylesheet" type="text/css"/>
    <link href="../static/fonts/icon.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/footer/footer.css" rel="stylesheet" type="text/css">

</head>

<body>
<div class="header">
    <div class="login">
        <div class="login-block">
            <ol>
                <li id="header-login"><a href="/l">登录</a></li>
                <li id="header-register"><a href="/r">注册</a></li>
                <script src="../static/js/getcookie.js" type="text/javascript"></script>
            </ol>
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
               <li><a href="/all?t=1&p=0">玄幻</a></li>
               <li><a href="/all?t=2&p=0">都市</a></li>
               <li><a href="/all?t=3&p=0">历史</a></li>
               <li><a href="/all?t=4&p=0">武侠</a></li>
               <li><a href="/all?t=5&p=0">科幻</a></li>
               <li><a href="/all?t=7&p=0">灵异</a></li>
               <li><a href="/all?t=0&p=0">全部</a></li>
           </ol>
        </div>
    </div>
</div>
<div class="content-doc"></div>
<div class="right-menu">
    <ul>
        <li>
            <a href="/book?id=${chapter.book_id}"><em class="icon iconfont">目录</em></a>
        </li>
        <li>
            <%--<a>${book.start_id}</a>--%>
            <c:if test="${chapter.id-1<book.start_id}">
                <a href="/text?id=<c:out value="${chapter.id}"/>"><em class="icon iconfont">&#xe604;</em></a>
            </c:if>
            <c:if test="${chapter.id-1>=book.start_id}">
                <a href="/text?id=<c:out value="${chapter.id-1}"/>"><em class="icon iconfont">&#xe604;</em></a>
            </c:if>
        </li>
        <li>
            <%--<a>${book.end_id}</a>--%>
            <c:if test="${chapter.id+1<=book.end_id}">
                <a href="/text?id=${chapter.id+1}"><em class="icon iconfont">&#xe61d;</em></a>
            </c:if>
            <c:if test="${chapter.id+1>book.end_id}">
                <a href="/text?id=${chapter.id}"><em class="icon iconfont">&#xe61d;</em></a>
            </c:if>
        </li>
    </ul>
</div>
<div class="content-text">
    <h1>${chapter.chapter_name}</h1>
    ${chapter.content}
</div>
<div class="footer">
    <div class="footer-block">
        <h4>声明:本站一切资源均来源于网络,仅供交流学习使用,如有侵权!请联系站长</h4>
        <p>站长邮箱897254488@qq.com</p>
    </div>
</div>
</body>
</html>