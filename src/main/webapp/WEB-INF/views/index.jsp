<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Форум job4j</title>
</head>
<body>
<%--<div>--%>
    <%--Login as ${user.username}--%>
<%--</div>--%>
<br>
<a href="<c:url value='/login'/>">Авторизация</a>
<br>
<a href="<c:url value='/create'/>">Добавить тему</a>
<%--<br>--%>
<%--<a href="<c:url value='/edit'/>">Редактировать тему</a>--%>

<div class="container mt-3">
    <div class="row">
        <h4>Форум job4j</h4>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>
                    <span>
                       <a href="<c:url value='/edit?id=${post.id}'/>">Редактировать</a>
                    </span>
                    </td>
                    <td><c:out value="${post.name}"/></td>
                    <td><c:out value="${post.id}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>