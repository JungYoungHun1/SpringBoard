<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트</title>
    <style>
        table, td, th {
            border-collapse: collapse;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>리스트</h1>
<c:if test="${sessionScope.loginUser !=null}">
    <div><a href="/board/write">글쓰기</a></div>
    <div><a href="/user/logout">로그아웃</a></div>
</c:if>
<div><a href="/user/login"><button>로그인</button></a></div>
<div><a href="/user/join"><button>회원가입</button></a></div>


<div>
    <c:choose>
        <c:when test="${fn:length(requestScope.list) == 0}">
            <div>글이 없습니다.</div>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일시</th>
                </tr>
                <c:forEach items="${requestScope.list}" var="item">
                    <tr class="record" data-iboard="${item.iboard}<%-- onClick: moveToDetail(item.iboard)--%>">
                        <td>${item.iboard}</td>
                        <td>${item.title}</td>
                        <td>${item.writerNm}</td>
                        <td>${item.hit}</td>
                        <td>${item.rdt eq item.mdt? item.rdt : item.mdt}${item.rdt eq item.mdt? "" : "(수정됨)"}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>

<script src="/res/js/board/list.js"></script>
</body>
</html>