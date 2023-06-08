<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<%@ include file="header.jsp" %>
ADD BOOK
<form:form action="saveAuthor" modelAttribute="autor" method="POST">

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