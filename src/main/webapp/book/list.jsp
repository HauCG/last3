<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/11/2024
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Danh Sách Sách</h2>

    <c:if test="${empty books}">
        <div role="alert">
            Hiện tại không có sách nào!
        </div>
    </c:if>

    <c:if test="${not empty books}">
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>ID Sách</th>
                    <th>Tên Sách</th>
                    <th>Tác Giả</th>
                    <th>Mô Tả</th>
                    <th>Số Lượng</th>
                    <th>Hành Động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.description}</td>
                        <td>${book.quantity}</td>
                        <td>
                            <a href="Library?S=borrowBook&bookID=${book.bookID}" class="btn btn-primary">Mượn</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <div class="text-end mt-4">
        <a href="Library?S=bookList" class="btn btn-secondary">Quay lại danh sách sách</a>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
