<!DOCTYPE html>
<html lang="pl">
<head>
 <meta charset="utf-8">
 <title>Home</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1> Ksiegarnia </h1>

<sec:authorize access="isAnonymous()">
<div>
Aby przegladac baze naszych ksiazek zaloguj sie! Nie masz jeszcze konta? <a href="${pageContext.request.contextPath}/register">Zaloz je teraz :)</a>
</div>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<div>
Uzywaj nav bar'a aby przemieszczac sie po stronie!
</div>
</sec:authorize>



</body>
</html>