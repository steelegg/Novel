function getCookie(name) {
    var start;
    var end;
    if (document.cookie.length > 0) {
        start = document.cookie.indexOf(name + "=");
        if (start !== -1) {
            start = start + name.length + 1;
            end = document.cookie.indexOf(";", start);
            if (end === -1) {
                end = document.cookie.length;
            }
            return unescape(document.cookie.substring(start, end))
        }
    }
    return ""
}

function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!==null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}

function logout() {
    delCookie("username");
    delCookie("id");
    window.location.reload();
}

if (getCookie("username") !== '' && getCookie("id") !== '') {
    document.getElementById("header-login").innerHTML = '<a href="/u/collection?id='+getCookie("id")+'">'+getCookie("username") + '</a>';
    document.getElementById("header-register").innerHTML = '<a href="#" onclick="logout()">注销</a>';
}
