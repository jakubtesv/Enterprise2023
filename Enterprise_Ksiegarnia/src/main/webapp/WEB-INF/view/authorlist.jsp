<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Authors</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Autorzy:</h2>

        <div>
            <table>
                <tr>
                    <th>Imie</th>
                    <th>Nazwisko</th>
                </tr>
                <c:forEach var="autor" items="${autorzy}" >
                    <tr>
                        <td>${autor.imie}</td>
                        <td>${autor.nazwisko}</td>
                        <td>
                                  <c:url var="update" value="/authors/updateAuthor">
                                      <c:param name="authorId" value="${autor.id}"/>
                                  </c:url>
                                  <a href="${update}">edytuj</a>
                              </td>
                              <td>
                                  <c:url var="delete" value="/authors/deleteAuthor">
                                       <c:param name="authorId" value="${autor.id}"/>
                                  </c:url>
                                  <a href="${delete}">usun</a>
                              </td>
                    </tr>
                </c:forEach>
            </table>
        </div>


        <div>
            <input type="button" class="btn btn-secondary" value="Dodaj Autora"
                   onclick="window.location.href='authorformadd';return false;" />
        </div>

</body>
</html>
