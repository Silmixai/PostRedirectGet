<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcom file</title>
</head>
<body>
<form action="/FirstServlet" method="GET">
    <input type="text" name="login" size=50 placeholder="Ваш логин?"><br>
    <p class="text-reg">
        <select name="item">
            <option value="0">Выберите товар:</option>
            <option value="MacBook Pro">MacBook Pro</option>
            <option value="Apple iPhone 7s">Apple iPhone 7s</option>
        </select>
    </p>
    <input type="text" name="count" size=50 placeholder="Сколько вам запаковать?"><br><br>

    <input type="radio" name="prg" value="prg">PRG
    <input type="radio" name="prg" value="noprg">Без PRG
    <br>
    <input type="submit" value="OK">
</form>
</body>
</html>