<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Usuń ksiazke</title>
</head>
<body>
<%@ include file="header.jsp" %>

<form:form action="deleteBook" modelAttribute="book" method="POST">
    <td>${book.nazwa}</td>
    <td>${book.cena}</td>
    <td>${book.wydawnictwo}</td>
    <td>${book.kategoria.nazwa}</td>
    <td><form:hidden path="id"/></td>
    <table>
        <tr>
            <td><label></label></td>
            <td><input type="submit" class="btn btn-danger" value="USUN"  /></td>
        </tr>
    </table>
</form:form>


<p>
    <a href="${pageContext.request.contextPath}/books/list " class="btn btn-primary"> Powrot  </a>
</p>
</body>
</html>