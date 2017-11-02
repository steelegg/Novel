<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${user.name}资料</title>
    <link href="../static/css/userdoc/comment.css" rel="stylesheet" type="text/css">

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
    <div class="content-center">
        <div class="top-block">
            <div class="top-block-left">
                <img  src="../static/css/userdoc/header.jpg" >
            </div>
            <div class="top-block-right">
                <h2>无名者<a>VIP</a><a>赞数</a></h2>
                <p>100<em>月票</em></p>
                <p>简介:</p>
                <span>
                        <i></i>这是一个有故事但是不想说的人...
                    </span>
            </div>
        </div>
        <div class="bottom-block">
            <ul class="menu-center">
                <li><a href="/u/collection?id=${id}">${mec}</a></li>
                <li><a href="/u/history?id=${id}">我的历史</a></li>
                <li class="current"><a href="/u/comment?id=${id}">我的评论</a></li>
            </ul>
            <div class="bottom-block-content">
                <ul>
                    <li>
                        <h4>#标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                    <li>
                        <h4>标题标题标题标题标题标题</h4>
                        <p>评论评论评论评论评论评论评论评论评论评论评论<em>点赞数量</em></p>
                    </li>
                </ul>
            </div>
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