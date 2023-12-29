<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.12.2023
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update/${key.id}" method="post">
    <label for="name">Name</label><br>
    <input type="text" name="name" id="name" value="${key.name}"><br>
    <label for="age">Age</label><br>
    <input type="number" name="age" id="age" value="${key.age}"><br>
    <input type="submit" value="Update"><br>
</form>
</body>
</html>
