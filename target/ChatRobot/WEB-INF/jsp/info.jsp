<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/26
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果页</title>
    <script type="text/javascript">
        function countDown(secs,surl){
            //alert(surl);
            var jumpTo = document.getElementById('jumpTo');
            jumpTo.innerHTML=secs;
            if(--secs>0){
                setTimeout("countDown("+secs+",'"+surl+"')",1000);
            }
            else
            {
                location.href=surl;
            }
        }
    </script>
</head>
<body>
    <h1>${info}</h1>
    <a href="/" >回到首页</a>
</body>
</html>
