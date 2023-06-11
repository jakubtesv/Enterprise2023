<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <title>HEADER</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Ksiegarnia</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home <span class="sr-only">(current)</span></a>
      </li>
      <sec:authorize access="isAuthenticated()">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/books/list">Ksiazki</a>
          </li>
          <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/authors/list">Autorzy</a>
          </li>
      </sec:authorize>
      <sec:authorize access="hasAuthority('ROLE_ADMIN')">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/categories/list">Kategorie</a>
          </li>
      </sec:authorize>

    </ul>
    <form class="form-inline my-2 my-lg-0">

        <sec:authorize access="isAnonymous()">
            <a href="${pageContext.request.contextPath}/login" class="btn btn-primary" style="margin-left: 10px">Logowanie</a>
            <a href="${pageContext.request.contextPath}/register" class="btn btn-primary" style="margin-left: 10px">Rejestracja</a>
        </sec:authorize>

        <sec:authorize access="hasAuthority('ROLE_USER')">
           <a href="${pageContext.request.contextPath}/cart" class="btn btn-success" style="margin-left: 10px">Koszyk</a>
        </sec:authorize>


        <sec:authorize access="isAuthenticated()">
           <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary" style="margin-left: 10px">Wyloguj</a>
        </sec:authorize>


    </form>
  </div>
</nav>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>