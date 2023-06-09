<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kategorie</title>
</head>
<body>
<%@ include file="header.jsp" %>
        <h2>Kategorie:</h2>

        <div>
            <table>
                <tr>
                    <th>Name</th>
                </tr>
                <c:forEach var="category" items="${categories}" >
                    <tr>
                        <td>${category.nazwa}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div>
            <input type="button" value="Add Category"
                   onclick="window.location.href='addCategory';return false;" />
        </div>
</body>
</html>
