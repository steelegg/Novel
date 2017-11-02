<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录|凡尘小说网</title>
    <link href="../static/css/directory/header.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/login/login.css" rel="stylesheet" type="text/css">
    <!--bootstrap-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script>
        function judge() {
            var mobile = document.getElementById("mobile").value;
            var password = document.getElementById("password").value;
            try {
                if (mobile == "") {
                    throw "请输入账号";
                }
                if (password==""){
                    throw "请输入密码";
                }
            } catch (err) {
                alert(err);
            }
        }
    </script>
</head>
<body>
<div class="header">
    <div class="menu">
        <div class="menu-a">
            <form class="header-input">
                <input class="header-input-text" type="text" placeholder="请输入书名或作者名...">
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
    <div class="content-block">
        <div class="login">
            <form action="/l/login" method="post">
                <input id="mobile" type="text" name="mob" placeholder="请输入账号" /><br />
                <input id="password" type="password" name="pwd" placeholder="请输入密码"/>
                <div class="but-block">
                    <button class="left-but" type="submit" onclick="judge()">登录</button>
                    <button class="right-but" type="button" onclick="window.location.href='/r'">注册</button>
                </div>
            </form>
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