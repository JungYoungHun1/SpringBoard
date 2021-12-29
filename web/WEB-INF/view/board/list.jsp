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

<div>
    <a href="/board/write">
        <button>글쓰기</button>
    </a>
</div>

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
                    <th>조회수</th>
                    <th>작성일시</th>
                </tr>
                <c:forEach items="${requestScope.list}" var="item">
                    <tr class="record" data-iboard="${item.iboard}<%-- onClick: moveToDetail(item.iboard)--%>">
                        <td>${item.iboard}</td>
                        <td>${item.title}</td>
                        <td>${item.hits}</td>
                        <td>${item.rdt}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>
<script src="/res/js/board/list.js"></script>
</body>
</html>