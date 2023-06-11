<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Koszyk</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Koszyk:</h2>

        <div>
            <table>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td><c:out value="${book.nazwa}"/></td>
                            <td><c:out value="${book.wydawnictwo}"/></td>
                            <td><c:out value="${book.cena}"/></td>
                            <td><c:out value="${book.kategoria.nazwa}"/></td>

                            <td>
                                <form action="${pageContext.request.contextPath}/cart/delete" method="post">
                                    <input type="hidden" name="bookId" value="${book.id}"/>
                                    <button type="submit">Usun</button>
                                </form>
                            </td>


                        </tr>
                    </c:forEach>
                </tbody>
                </table>
        </div>

<p>
    <a href="${pageContext.request.contextPath}/books/list "> Powrot </a>
</p>

</body>
</html>