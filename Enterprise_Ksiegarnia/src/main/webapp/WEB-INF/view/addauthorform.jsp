<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj Autora</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h2>Dodaj autora:</h2>
<form:form action="saveAuthor" modelAttribute="author" method="POST">

<td><form:hidden path="id"/></td>
    <table>
        <tbody>
        <tr>
            <td><label>Imie:</label></td>
            <td><form:input path="imie" /></td>
        </tr>

        <tr>
            <td><label>Nazwisko:</label></td>
            <td><form:input path="nazwisko" /></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" class="btn btn-success" value="Zapisz" class="save" /></td>
        </tr>

        </tbody>
    </table>


</form:form>


<p>
    <a href="${pageContext.request.contextPath}/authors/list" class="btn btn-primary"> Powrot  </a>
</p>

</body>
</html>