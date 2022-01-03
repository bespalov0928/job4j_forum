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
    <title>Создание темы</title>
</head>
<body>
<form name="create" action="/save" method="post">
    <table>
        <table>
            <tr>
                <td>Название:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>Обсуждения:</td>
                <td>
                <textarea name="discussion"
                          style="padding-bottom:250px;
                            font-size:16px;
                            height: 300px;
                            width: 500px;">

                </textarea>
                </td>
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
