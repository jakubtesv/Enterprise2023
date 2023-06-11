<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista ksiazek</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Ksiazki:</h2>

        <div>
            <table>
                <tr>
                    <th style="padding-left: 25px">Nazwa</th>
                    <th style="padding-left: 25px">Wydawnictwo</th>
                    <th style="padding-left: 25px">Cena</th>
                    <th style="padding-left: 25px">Kategoria</th>
                    <th style="padding-left: 25px">Autorzy</th>
                </tr>
                <c:forEach var="book" items="${books}" >
                        <c:url var="update" value="/books/updateBookForm2">
                        <c:param name="bookId" value="${book.id}"/>
                        </c:url>
                    <tr>
                        <td style="padding-left: 25px">${book.nazwa}</td>
                        <td style="padding-left: 25px">${book.wydawnictwo}</td>
                        <td style="padding-left: 25px">${book.cena}</td>
                        <td style="padding-left: 25px">${book.kategoria.nazwa}</td>

                        <td style="padding-left: 25px">
                        <c:forEach var="author" items="${book.autorzy}">
                             ${author.imie} ${author.nazwisko} <br />
                             </c:forEach></td>
                        <td>

                        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                            <td><a href="${update}" style="padding-left: 5px">Edytuj</a> </td>
                            <c:url var="delete" value="/books/deleteBook">
                            <c:param name="bookId" value="${book.id}"/>
                            </c:url>
                            <td><a href="${delete}" style="padding-left: 5px">Usun</a></td>
                        </sec:authorize>

                        <sec:authorize access="hasRole('USER')">
                            <td>
                                <form action="${pageContext.request.contextPath}/cart/add" method="post">
                                    <input type="hidden" name="bookId" value="${book.id}"/>
                                    <button type="submit" class="btn btn-secondary">Do koszyka</button>
                                </form>
                            </td
                        </sec:authorize>


                    </tr>

                </c:forEach>
            </table>
        </div>

        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <div>
                <input type="button" class="btn btn-secondary" value="Dodaj Ksiazke"
                       onclick="window.location.href='formadd2';return false;" />
            </div>
        </sec:authorize>


</body>
</html>
