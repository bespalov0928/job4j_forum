<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Редактирование темы</title>
</head>
<body>
<form action="<c:url value='/save?id=${post.id}'/>" method="post">
    <%--<form action="<c:url value='/save?id=${post.id}'/>" method='POST'>--%>
    <%--<table>--%>
    <table>
        <tr>
            <td>Название:</td>
            <td>
                <input type="text" name="name" value="${post.name}">
            </td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td>
                <input type="text" name="description" value="${post.description}">
            </td>
        </tr>
        <tr>
            <td>Обсуждения:</td>
            <td>
                <textarea name="discussion" value="${post.discussion}"
                          style="padding-bottom:250px;
                            font-size:16px;
                            height: 300px;
                            width: 500px;">

                </textarea>
            </td>
        </tr>
        <tr hidden="true">
            <td><input type="text" name="idString" value="${post.id}"></td>
        </tr>
        <tr>
            <td>
                <input name="submit" type="submit" value="Сохранить">
            </td>
        </tr>
    </table>
    </table>
</form>
</body>
</html>
