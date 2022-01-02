<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<c:if test="${not empty errorMessage}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">
            ${errorMessage}
    </div>
</c:if>
<a href="<c:url value='/reg'/>">Регистрация</a>
<form name='login' action="/login" method='POST'>
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username' placeholder="Username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' placeholder="Password"/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Авторизоваться"/></td>
        </tr>
    </table>
</form>

</body>
</html>
