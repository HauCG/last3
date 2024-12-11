<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/11/2024
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mượn Sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Mượn Sách</h2>

    <c:if test="${not empty message}">
        <div class="alert alert-danger">
                ${message}
        </div>
        <a href="Library?S=bookList" class="btn btn-secondary">Quay lại danh sách sách</a>
    </c:if>

    <c:if test="${empty message}">
        <form action="Library?S=addBorrowCard" method="POST">
            <input type="hidden" name="bookID" value="${book.bookID}">

            <div class="mb-3">
                <label for="studentName" class="form-label">Tên Sinh Viên</label>
                <select class="form-control" id="studentName" name="studentID" required>
                    <option value="" disabled selected>Chọn sinh viên</option>
                    <c:forEach var="student" items="${students}">
                        <option value="${student.studentId}">${student.studentName}</option>
                    </c:forEach>
                </select>
                <a href="Library?S=showAddStudent" class="btn btn-success mt-3">Thêm Mới Sinh Viên</a>
            </div>

            <div class="mb-3">
                <label for="borrowDate" class="form-label">Ngày Mượn</label>
                <input type="date" class="form-control" id="borrowDate" name="borrowDate" required>
            </div>

            <div class="mb-3">
                <label for="returnDate" class="form-label">Ngày Trả Dự Kiến</label>
                <input type="date" class="form-control" id="returnDate" name="returnDate" required>
            </div>

            <button type="submit" class="btn btn-primary">Mượn Sách</button>
        </form>
    </c:if>
</div>
</body>
</html>
