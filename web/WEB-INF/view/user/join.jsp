<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
<form action="/user/join" method="post">
    <div><input type="text" name="uid" placeholder="아이디"></div>
    <div><input type="text" name="upw" placeholder="비밀번호"></div>
    <div><input type="text" name="nm" placeholder="이름"></div>
    <div>
        gender : <label>woman <input type="radio" name="gender" value="0" checked></label>
        <label>man <input type="radio" name="gender" value="1"></label>
    </div>
    <div><input type="submit" value="회원가입"></div>
</form>
</body>
</html>
