<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>凡尘小说网</title>
    <link href="../static/css/index/header.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/index/content.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/index/footer.css" rel="stylesheet" type="text/css"/>
    <link href="../static/fonts/icon.css" rel="stylesheet" type="text/css">
    <!--bootstrap-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="../static/bootstrap/jquery.min.js"></script>
    <script src="../static/bootstrap/bootstrap.min.js"></script>

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
        <div class="menu-block">
            <div class="menu-left">
                <a class="header-book-type"><p>作品分类</p></a>
            </div>
            <div class="menu-right">
                <form class="header-input" action="/search" method="GET">
                    <input class="header-input-text" type="text" name="search" placeholder="请输入书名或作者名...">
                    <input class="header-input-submit" value="搜索" type="submit">
                </form>
                <ol>
                    <li><a href="/all?t=0&p=0">免费</a></li>
                    <li><a href="/all?t=9&p=0">完本</a></li>
                    <li><a href="/ranking?s=1">排行</a></li>
                    <li><a href="/all?t=0&p=0">全部作品</a></li>
                </ol>

            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="content-book-type">
        <table class="book-type-table" width="200" cellspacing="0" cellpadding="0">
            <tr>
                <td><a href="/all?t=1&p=0"><em class="icon iconfont">&#xe600;</em><i>玄幻</i></a></td>
                <td><a href="/all?t=4&p=0"><em class="icon iconfont">&#xe605;</em><i>武侠</i></a></td>
            </tr>
            <tr>
                <td><a href="/all?t=2&p=0"><em class="icon iconfont">&#xe649;</em><i>都市</i></a></td>
                <td><a href="directory.html"><em class="icon iconfont">&#xe654;</em><i>言情</i></a></td>
            </tr>
            <tr>
                <td><a href="/all?t=3&p=0"><em class="icon iconfont">&#xe67c;</em><i>历史</i></a></td>
                <td><a href="/all?t=5&p=0"><em class="icon iconfont">&#xe638;</em><i>科幻</i></a></td>
            </tr>
            <tr>
                <td><a href="/all?t=6&p=0"><em class="icon iconfont">&#xe603;</em><i>游戏</i></a></td>
                <td><a href="directory.html"><em class="icon iconfont">&#xe601;</em><i>动漫</i></a></td>
            </tr>
            <tr>
                <td><a href="/all?t=8&p=0"><em class="icon iconfont">&#xe60d;</em><i>军事</i></a></td>
                <td><a href="/all?t=7&p=0"><em class="icon iconfont">&#xe602;</em><i>灵异</i></a></td>
            </tr>
        </table>
    </div>
    <div class="run-img">
        <!--轮播图-->
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="../static/image/1.jpg" alt="First slide">
                </div>
                <div class="item">
                    <img src="../static/image/2.jpg" alt="Second slide">
                </div>
                <div class="item">
                    <img src="../static/image/1.jpg" alt="Third slide">
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="content-list-box">
        <table class="content-list-table" width="1000">
            <tr>
                <td class="content-list-title" colspan="4">本周热榜</td>
            </tr>
            <tr>
                <%--推荐榜--%>
                <td class="content-list">
                    <div class="content-list-block">
                        <table class="list-table" width="250">
                            <tr>
                                <td colspan="2"><h4>推荐榜<a href="#">更多 ></a></h4></td>
                            </tr>
                            <c:forEach items="${recommended}" var="c" varStatus="vs" end="0">
                                <tr>
                                    <td width="147"><span class="no-1-1">NO.1</span></td>
                                    <td class="td-img" rowspan="4"><img src="${c.cover}" width="100px" height="140px"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><a href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                                <tr>
                                    <td class="no-1-3">推荐最多</td>
                                </tr>
                                <tr>
                                    <td class="no-1-4">${c.type} ${c.author}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <table class="list-table" width="250">
                            <c:set var="index" value="1"/>
                            <c:forEach items="${recommended}" var="c" varStatus="vs" begin="1">
                                <c:set var="index" value="${index+1}"/>
                                <tr>
                                    <td class="list-number"><span><c:out value="${index}"/></span></td>
                                    <td class="content-list-col" height="35" colspan="2"><a
                                            href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </td>
                <%--点击榜--%>
                <td class="content-list">
                    <div class="content-list-block">
                        <table class="list-table" width="250">
                            <tr>
                                <td colspan="2"><h4>点击榜<a href="#">更多 ></a></h4></td>
                            </tr>
                            <c:forEach items="${click}" var="c" varStatus="vs" end="0">
                                <tr>
                                    <td width="147"><span class="no-1-1">NO.1</span></td>
                                    <td class="td-img" rowspan="4"><img src="${c.cover}" width="100px" height="140px"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><a href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                                <tr>
                                    <td class="no-1-3">点击最多</td>
                                </tr>
                                <tr>
                                    <td class="no-1-4">${c.type} ${c.author}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <table class="list-table" width="250">
                            <c:set var="index" value="1"/>
                            <c:forEach items="${click}" var="c" varStatus="vs" begin="1">
                                <c:set var="index" value="${index+1}"/>
                                <tr>
                                    <td class="list-number"><span><c:out value="${index}"/></span></td>
                                    <td class="content-list-col" height="35" colspan="2"><a
                                            href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </td>
                <%--收藏--%>
                <td class="content-list">
                    <div class="content-list-block">
                        <table class="list-table" width="250">
                            <tr>
                                <td colspan="2"><h4>收藏榜<a href="#">更多 ></a></h4></td>
                            </tr>
                            <c:forEach items="${collection}" var="c" varStatus="vs" end="0">
                                <tr>
                                    <td width="147"><span class="no-1-1">NO.1</span></td>
                                    <td class="td-img" rowspan="4"><img src="${c.cover}" width="100px" height="140px"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><a href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                                <tr>
                                    <td class="no-1-3">收藏最多</td>
                                </tr>
                                <tr>
                                    <td class="no-1-4">${c.type} ${c.author}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <table class="list-table" width="250">
                            <c:set var="index" value="1"/>
                            <c:forEach items="${collection}" var="c" varStatus="vs" begin="1">
                                <c:set var="index" value="${index+1}"/>
                                <tr>
                                    <td class="list-number"><span><c:out value="${index}"/></span></td>
                                    <td class="content-list-col" height="35" colspan="2"><a
                                            href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </td>
                <%--时间--%>
                <td class="content-list">
                    <div class="content-list-block">
                        <table class="list-table" width="250">
                            <tr>
                                <td colspan="2"><h4>最新榜<a href="#">更多 ></a></h4></td>
                            </tr>
                            <c:forEach items="${last_update_time}" var="c" varStatus="vs" end="0">
                                <tr>
                                    <td width="147"><span class="no-1-1">NO.1</span></td>
                                    <td class="td-img" rowspan="4"><img src="${c.cover}" width="100px" height="140px"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><a href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                                <tr>
                                    <td class="no-1-3">本站最新</td>
                                </tr>
                                <tr>
                                    <td class="no-1-4">${c.type} ${c.author}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <table class="list-table" width="250">
                            <c:set var="index" value="1"/>
                            <c:forEach items="${last_update_time}" var="c" varStatus="vs" begin="1">
                                <c:set var="index" value="${index+1}"/>
                                <tr>
                                    <td class="list-number"><span><c:out value="${index}"/></span></td>
                                    <td class="content-list-col" height="35" colspan="2"><a
                                            href="/book?id=${c.id}">${c.book_name}</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
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
