<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Twoje Zamowienia</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Twoje Zamowienia:</h2>

        <div>
            <table>
                            <tr>
                                <th style="padding-left: 25px">Ksiazki</th>
                                <th style="padding-left: 25px">Cena</th>
                                <th style="padding-left: 25px">Status</th>
                                <th style="padding-left: 25px">Data</th>
                            </tr>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td style="padding-left: 25px">
                                <c:forEach var="book" items="${order.ksiazki}">
                                    ${book.nazwa}<br />
                                </c:forEach></td>

                            <td style="padding-left: 25px"><c:out value="${order.price}"/></td>
                            <td style="padding-left: 25px"><c:out value="${order.status}"/></td>
                            <td style="padding-left: 25px"><c:out value="${order.date_time}"/></td>


                        </tr>
                    </c:forEach>
                </tbody>
                </table>
        </div>
</body>
</html>