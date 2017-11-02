<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${book.book_name}|凡尘小说网</title>
    <link href="../static/css/directory/header.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/directory/content.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/footer/footer.css" rel="stylesheet" type="text/css">

    <!--bootstrap-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script>
        function loadXMLDoc(bid) {
            if(getCookie("id")!==null){
                var xmlhttp;
                if (window.XMLHttpRequest) {
                    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                    xmlhttp=new XMLHttpRequest();
                }
                else {
                    // IE6, IE5 浏览器执行代码
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function() {
                    if (xmlhttp.readyState===4 && xmlhttp.status===200) {
                        alert("收藏成功");
                        document.getElementById("info").innerHTML=xmlhttp.responseText;
                    }
                }
                xmlhttp.open("GET","/add?bid="+bid+"&uid="+getCookie("id"),true);
                xmlhttp.send();
            }else{
                alert("请先登录...")
            }
        }
    </script>
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

<div class="content">
    <!--背景图-->
    <div class="content-background"></div>
    <!--内容-->
    <div class="content-body">
        <!--简介和封面-->
        <div class="book-info">
            <div class="book-info-left">
                <%--封面--%>
                <img src="${book.cover}">
            </div>
            <div class="book-info-right">
                <h1><em>${book.book_name}</em><span>${book.author}  著</span></h1>
                <p>
                    <span class="blue">${book.type}</span>
                    <span class="red">
                        <c:if test="${book.status==1}">完本</c:if>
                        <c:if test="${book.status==0}">连载</c:if>
                    </span>
                </p>
                <p class="intro">在破败中崛起，在寂灭中复苏。沧海成尘，雷电枯竭……</p>
                <p>
                    <em>${book.chapter_number}</em><cite>章节</cite>
                    <em>${book.click}</em><cite>点击</cite>
                    <em>${book.recommended}</em><cite>推荐</cite>
                </p>

                <a class="red-button" href="/text?id=${book.start_id}"><div>点击阅读</div></a>
                <a class="blue-button"  href="#" onclick="loadXMLDoc(${book.id})"><div>加入书架</div></a>
                <a class="blue-button" href="#"><div>投票互动</div></a>

            </div>
        </div>
        <div class="book-date">
            <h4>作品简介:</h4>
            <p>
               ${book.introduction}
            </p>
            <h4 class="list-title">目录:</h4>
            <div class="book-list" width="960">
                <ul>
                    <c:forEach items="${chapter}" var="c" varStatus="st">
                        <li><a href="/text?id=${c.id}">${c.chapter_name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>

    <div class="footer">
        <div class="footer-block">
            <h4>声明:本站一切资源均来源于网络,仅供交流学习使用,如有侵权!请联系站长</h4>
            <p>站长邮箱897254488@qq.com</p>
        </div>
    </div>
</div>

</body>
</html>