<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/11/2024
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Borrow Cards</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Danh Sách Thẻ Mượn Sách</h2>

    <c:if test="${not empty message}">
        <div class="alert alert-danger">
            <div role="alert">
                Hiện tại không có thẻ mượn sách nào!
            </div>
        </div>
    </c:if>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID Thẻ Mượn</th>
            <th scope="col">Tên Sinh Viên</th>
            <th scope="col">Tên Sách</th>
            <th scope="col">Ngày Mượn</th>
            <th scope="col">Ngày Trả Dự Kiến</th>
        </tr>
        </thead>
        <tbody>
        <!-- Duyệt qua danh sách thẻ mượn và hiển thị -->
        <c:forEach var="borrowCard" items="${borrowCards}">
            <tr>
                <td>${borrowCard.cardId}</td>
                <td>${borrowCard.studentName}</td>
                <td>${borrowCard.bookTitle}</td>
                <td>${borrowCard.borrowDate}</td>
                <td>${borrowCard.returnDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
