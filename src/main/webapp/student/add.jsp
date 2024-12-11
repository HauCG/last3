<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/11/2024
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Student</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional, for styling -->
</head>
<body>
<h2>Add New Student</h2>

<c:if test="${not empty message}">
    <div style="color: red;">
        <strong>${message}</strong>
    </div>
</c:if>


<form action="Library?A=addStudent" method="post">
    <div>
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" required />
    </div>
    <div>
        <label for="studentClass">Student Class:</label>
        <input type="text" id="studentClass" name="studentClass" required />
    </div>
    <button type="submit">Add Student</button>
</form>

<br>
<a href="Library?S=studentList">Back to Student List</a>
</body>
</html>
