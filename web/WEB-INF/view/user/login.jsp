<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
<form id="loginBtn" action="/user/login" method="post" data-msg="${requestScope.msg}">
    <div><input type="text" name="uid" placeholder="아이디"></div>
    <div><input type="text" name="upw" placeholder="비밀번호"></div>
    <div><input type="submit" value="로그인"></div>
</form>

<div>
    <a href="/user/join">회원가입</a>
</div>
<script src="/res/js/user/login.js?ver=1"></script>

</body>
</html>
