<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SingIn</title>
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
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.servletContext.contextPath}/create">
            <button class="btn my-2 my-sm-0" type="submit">Sing up</button>
        </form>
    </div>
</nav>
<div class="container">
    <h1 class="text-center m-5">Sign in with existing account</h1>
    <div class="row justify-content-center">
        <c:if test="${error != null}">
            <div class="alert alert-danger col-md-7" role="alert">
                <c:out value="${error}"/>
            </div>
        </c:if>
    </div>
    <div class="row justify-content-md-center">
        <div class="col-md-7">
            <form class="form-horizontal" action = "${pageContext.servletContext.contextPath}/singin" method = "post">
                <div class="row form-group">
                    <label class="control-label col-md-2 col-form-label" for="login">Login:</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" name="login" id="login" placeholder="Enter login" title="Login cannot be empty!">
                    </div>
                </div>
                <div class="row form-group">
                    <label class="control-label col-md-2 col-form-label" for="password">Password:</label>
                    <div class="col-md-10">
                        <input type="password" class="form-control" name="password" id="password" placeholder="Enter password" title="Password cannot be empty!">
                    </div>
                </div>
                <div class="row form-group justify-content-end">
                    <div class="control-label">
                        <button type="submit" class="btn btn-primary px-5 mt-3">Sing in</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
