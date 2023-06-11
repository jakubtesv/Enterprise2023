<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Usun Ksiazke</title>
</head>
<body>
<%@ include file="header.jsp" %>

<form:form action="deleteBook" modelAttribute="book" method="POST">
    <td><form:hidden path="id"/></td>
    <tr>
                <td>Czy chcesz usunac ksiazke "${book.nazwa} ${book.wydawnictwo} ${book.cena} ${book.kategoria.nazwa}"?</td>
    </tr>


    <table>
        <tr>
            <td><label></label></td>
            <td><input type="submit" class="btn btn-danger" value="USUN"/></td>
        </tr>
    </table>
</form:form>


<p>
    <a href="${pageContext.request.contextPath}/books/list " class="btn btn-primary"> Powrot  </a>
</p>
</body>
</html>