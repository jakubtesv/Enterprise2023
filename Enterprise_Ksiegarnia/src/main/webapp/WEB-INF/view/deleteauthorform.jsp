<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Usun Autora</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h2>Usun autora:</h2>
<form:form action="deleteAuthor" modelAttribute="author" method="POST">

    <td><form:hidden path="id"/></td>
    <table>
        <tbody>
        <tr>
            <td>Czy chcesz usunac autora "${author.imie} ${author.nazwisko}"?</td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" class="btn btn-danger" value="USUN"/></td>
        </tr>


        </tbody>
    </table>


</form:form>

<p>
    <a href="${pageContext.request.contextPath}/authors/list " class="btn btn-primary"> Powrot  </a>
</p>
</body>
</html>
