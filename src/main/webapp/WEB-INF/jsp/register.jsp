<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册|凡尘小说网</title>
    <link href="../static/css/directory/header.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/register/register.css" rel="stylesheet" type="text/css">
    <!--bootstrap-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script>
        function judge() {
            var number = document.getElementById("number").value;
            var password1 = document.getElementById("password1").value;
            var password2 = document.getElementById("password2").value;
            var code = document.getElementById("code").value;
            try {
                if (number == "") {
                    throw "请输入账号";
                }
                if (password1==""){
                    throw "请输入密码";
                }
                if (password2==""){
                    throw "请再次输入密码";
                }
                if (code==""){
                    throw "请输入答案";
                }
                if(password1!=password2){
                    throw "密码两次输入不一致"
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
        <a class="go-login" href="/l">登录</a>
        <div class="login">
            <form action="/r/register" method="get">
                <input id="number" type="text" name="mobile" placeholder="请输入手机号" />
                <input id="password1" type="password" placeholder="请输入密码"/>
                <input id="password2" type="password" name="password" placeholder="请再输入一次密码"/>
                <p>${n1}+${n2}=?</p><input id="code" type="text" name="n3" placeholder="请输入答案"/>
                <div class="but-block">
                    <button class="left-but" type="submit" onclick="judge()">同意协议并注册</button>
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