<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Zamowienia</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Zamowienia:</h2>

<c:set var="count" value="0" scope="page" />
        <div>
            <table>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td style="padding-left: 25px"><c:out value="${order.price}"/></td>
                            <td style="padding-left: 25px"><c:out value="${order.status}"/></td>
                            <td style="padding-left: 25px"><c:out value="${order.date_time}"/></td>

                            <td style="padding-left: 25px">
                                <c:forEach var="book" items="${order.ksiazki}">
                                    ${book.nazwa}<br />
                                </c:forEach></td>
                            <td>

                        </tr>
                    </c:forEach>
                </tbody>
                </table>
        </div>
</body>
</html>