<!DOCTYPE html>
<html lang="pl">
<head>
 <meta charset="utf-8">
 <title>Ops!</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1> Dzialanie niemozliwe! </h1>

<div>
<h4>Ops, nie mozna usunac ksiazki bo ktos juz zlozyl na nia zamowienie!</h4>
</div>

<p>
    <a href="${pageContext.request.contextPath}/books/list " class="btn btn-primary"> Powrot  </a>
</p>

</body>
</html>