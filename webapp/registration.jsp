<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/register">
    <label>Name</label>
    <input type="text" name="name">
    <br>
    <br>
    <label>Surname</label>
    <input type="text" name="surname">
    <br>
    <br>
    <label>Email</label>
    <input type="text" name="email">
    <br>
    <br>
    <label>Password</label>
    <input type="password" name="password">
    <br>
    <br>
    <input type="submit" value="Registr">
    <a href="login.jsp">Login</a>
</form>
</body>
</html>
