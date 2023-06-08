<%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 15.05.2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>books</title>
</head>
<body>
<%@ include file="header.jsp" %>
ADD BOOK
<form:form action="saveBook" modelAttribute="book" method="POST">

    <table>
        <tbody>
        <tr>
            <td><label>nazwa:</label></td>
            <td><form:input path="nazwa" /></td>
        </tr>

        <tr>
            <td><label>wydawnictwo:</label></td>
            <td><form:input path="wydawnictwo" /></td>
        </tr>

        <tr>
            <td><label>cena:</label></td>
            <td><form:input path="cena" /></td>
        </tr>
        <tr>
            <td><label for="categories">kategoria:</label></td>
            <td><form:select path="kategoria" id="categories"> <form:options items="${categories}" itemValue="id" itemLabel="nazwa"/></form:select></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save" /></td>
        </tr>


        </tbody>
    </table>


</form:form>


<p>
    <a href="${pageContext.request.contextPath}/books/list "> return  </a>
</p>



</body>
</html>
