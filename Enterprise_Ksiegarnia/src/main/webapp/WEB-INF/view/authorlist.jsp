<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista Autorow</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Autorzy:</h2>

        <div>
            <table>
                <tr>
                    <th style="padding-left: 25px">Imie</th>
                    <th style="padding-left: 25px">Nazwisko</th>
                </tr>
                <c:forEach var="autor" items="${autorzy}" >
                    <tr>
                        <td style="padding-left: 25px">${autor.imie}</td>
                        <td style="padding-left: 25px">${autor.nazwisko}</td>
                        <td style="padding-left: 25px">

                        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                                  <c:url var="update" value="/authors/updateAuthor">
                                      <c:param name="authorId" value="${autor.id}"/>
                                  </c:url>
                                  <a href="${update}" class="btn btn-outline-primary" style="padding-left: 5px">Edytuj</a>
                              </td>
                              <td>
                                  <c:url var="delete" value="/authors/deleteAuthor">
                                       <c:param name="authorId" value="${autor.id}"/>
                                  </c:url>
                                  <a href="${delete}" class="btn btn-outline-danger" style="padding-left: 5px">Usun</a>
                              </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <div>
                <input type="button" class="btn btn-secondary" value="Dodaj Autora"
                       onclick="window.location.href='authorformadd';return false;" />
            </div>
        </sec:authorize>
</body>
</html>
