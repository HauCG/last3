<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/11/2024
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional, for styling -->
</head>
<body>

<h2>List of Students</h2>

<c:if test="${not empty message}">
    <div style="color: red;">
        <strong>${message}</strong>
    </div>
</c:if>

<table border="1">
    <thead>
    <tr>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Class</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.studentClass}</td>
            <td>
                <a href="Library?S=editStudent&id=${student.studentId}">Edit</a> |
                <a href="Library?S=deleteStudent&id=${student.studentId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="Library?S=showAddStudent">Add New Student</a>

</body>
</html>

