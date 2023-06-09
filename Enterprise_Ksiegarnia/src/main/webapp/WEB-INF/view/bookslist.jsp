    <%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 15.05.2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Ksiazki:</h2>

        <div>
            <table>
                <tr>
                    <th>Nazwa</th>
                    <th>Wydawnictwo</th>
                    <th>Cena</th>
                    <th>Kategoria</th>
                </tr>
                <c:forEach var="book" items="${books}" >
                        <c:url var="update" value="/books/updateBookForm2">
                        <c:param name="bookId" value="${book.id}"/>
                        </c:url>
                    <tr>
                        <td>${book.nazwa}</td>
                        <td>${book.wydawnictwo}</td>
                        <td>${book.cena}</td>
                        <td>${book.kategoria.nazwa}</td>

                        <td>
                        <c:forEach var="author" items="${book.autorzy}">
                             ${author.imie} ${author.nazwisko} <br />
                             </c:forEach></td>
                        <td>

                        <td><a href="${update}" >Edytuj</a> </td>

                        <c:url var="delete" value="/books/deleteBook">
                        <c:param name="bookId" value="${book.id}"/>
                        </c:url>
                        <td><a href="${delete}">Usun</a></td>
                    </tr>

                </c:forEach>
            </table>
        </div>

        <div>
            <input type="button" class="btn btn-secondary" value="Dodaj Ksiazke"
                   onclick="window.location.href='formadd2';return false;" />
        </div>


</body>
</html>
