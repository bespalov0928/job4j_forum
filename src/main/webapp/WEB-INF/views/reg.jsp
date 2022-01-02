<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<c:if test="${not empty errorMessage}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">
            ${errorMessage}
    </div>
</c:if>


<%--<form:form action="<c:url value='/reg'/>" method='POST' modelAttribute="user">--%>
    <%--User Name: <form:input type="text" path="username" />--%>
    <%--&lt;%&ndash;<br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;Email: <form:input type="email" path="email" style="margin-left:34px;" />&ndash;%&gt;--%>
    <%--&lt;%&ndash;<br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;Password: <form:input type="password" path="password"  style="margin-left:10px;" />&ndash;%&gt;--%>
    <%--<br>--%>
    <%--<br>--%>
    <%--Confirm Password: <form:input type="password" path="password" />--%>
    <%--<br>--%>
    <%--<br>--%>
    <%--<input type="submit" value="Register">--%>
<%--</form:form>--%>



<form action="<c:url value='/reg'/>" method='POST' modelAttribute="user">
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Зарегистрироваться" /></td>
        </tr>
    </table>
</form>
</body>
</html>
