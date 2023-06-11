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
                            <td style="padding-left: 25px"><c:out value="${book.nazwa}"/></td>
                            <td style="padding-left: 25px"><c:out value="${book.wydawnictwo}"/></td>
                            <td style="padding-left: 25px"><c:out value="${book.cena}"/></td>
                            <td style="padding-left: 25px"><c:out value="${book.kategoria.nazwa}"/></td>

                            <td style="padding-left: 25px">
                                <c:forEach var="author" items="${book.autorzy}">
                                    ${author.imie} ${author.nazwisko} <br />
                                </c:forEach></td>
                            <td>

                            <td>
                                <form action="${pageContext.request.contextPath}/cart/delete" method="post">
                                    <input type="hidden" name="bookId" value="${book.id}"/>
                                    <button type="submit" class="btn btn-secondary">Usun</button>
                                </form>
                            </td>


                        </tr>
                    </c:forEach>
                </tbody>
                </table>
        </div>
<div>
    <a href="${pageContext.request.contextPath}/books/list" class="btn btn-secondary"> Powrot </a>
 </div>


</body>
</html>