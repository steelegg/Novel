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
            <a class="header-login" href="#">
                <li>登录</li>
            </a>
            <a class="header-register" href="#">
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
            <a href="/">
                <li>首页</li>
            </a>
            <a href="/all?t=1">
                <li>玄幻</li>
            </a>
            <a href="/all?t=2">
                <li>都市</li>
            </a>
            <a href="/all?t=4">
                <li>武侠</li>
            </a>
            <a href="/all?t=5">
                <li>科幻</li>
            </a>
            <a href="/all?t=3">
                <li>历史</li>
            </a>
            <a href="/all?t=7">
                <li>灵异</li>
            </a>
            <a href="/all?t=0">
                <li>全部</li>
            </a>
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