<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="${pageContext.servletContext.contextPath}">Users</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/create">Add new user<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <div class="navbar-text mr-3">${registeredUser.name}</div>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.servletContext.contextPath}/singout">
            <button class="btn my-2 my-sm-0" type="submit">Sing out</button>
        </form>
    </div>
</nav>
<h1 class="text-center mt-5">Table users</h1>
<div class="row">
    <div class="col-10 offset-md-1">
        <table class="table table-hover table-bordered my-5" id="table">
            <thead>
            <tr>
                <th scope="col" class="text-center align-middle">Name</th>
                <th scope="col" class="text-center align-middle">Login</th>
                <th scope="col" class="text-center align-middle">Email</th>
                <th scope="col" class="text-center align-middle">Country</th>
                <th scope="col" class="text-center align-middle">City</th>
                <c:if test="${registeredUser.role.name == 'admin'}">
                    <th scope="col" class="text-center align-middle">Role</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr scope="row">
                    <td scope="col" class="text-center align-middle"> <c:out value="${user.name}"></c:out></td>
                    <td scope="col" class="text-center align-middle"> <c:out value="${user.login}"></c:out></td>
                    <td scope="col" class="text-center align-middle"> <c:out value="${user.email}"></c:out></td>
                    <td scope="col" class="text-center align-middle"> <c:out value="${user.country}"></c:out></td>
                    <td scope="col" class="text-center align-middle"> <c:out value="${user.city}"></c:out></td>
                    <c:if test="${registeredUser.role.name == 'admin'}">
                        <td scope="col" class="text-center align-middle"> <c:out value="${user.role}"></c:out></td>
                    </c:if>
                    <td>
                        <form action = "${pageContext.servletContext.contextPath}/edit" method = "get">
                            <div class="row justify-content-center">
                                <button type="submit" class="btn btn-primary" name = "id" value = "<c:out value="${user.id}"></c:out>">Edit</button>
                            </div>
                        </form>
                    </td>
                    <td>
                        <form action = "${pageContext.servletContext.contextPath}/" method = "post">
                            <input type = "hidden" name = "id" value = "<c:out value="${user.id}"></c:out>">
                            <div class="row justify-content-center">
                                <button type="submit" class="btn btn-primary" name = "action" value = "delete">Delete</button>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>