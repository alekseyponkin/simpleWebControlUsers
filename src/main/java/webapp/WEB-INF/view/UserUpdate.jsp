<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update user</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script>
        function validate() {
            if ($('#name').val() === '') {
                alert($('#name').attr('title'));
                return false;
            }
            if ($('#login').val() === '') {
                alert($('#login').attr('title'));
                return false;
            }
            if ($('#password').val() === '') {
                alert($('#password').attr('title'));
                return false;
            }
            if ($('#country').val() === '') {
                alert($('#country').attr('title'));
                return false;
            }
            if ($('#city').val() === '') {
                alert($('#city').attr('title'));
                return false;
            }
            if ($('#email').val() === '') {
                alert($('#email').attr('title'));
                return false;
            }
            return true;
        }

        function getAllCountry() {
            $.ajax({
                url: "/items/country-city",
                success: function (data) {
                    var dataCountry = '<option value = "">Chose country</option>';
                    $.each(data, function (index, value) {
                        console.log(value);
                        dataCountry = dataCountry +
                            '<option>' + value + '</option>'
                    });
                    $('#country').append(dataCountry);
                }
            });
        }

        $(document).ready(getAllCountry());

        function getAllCityByCountry(country) {
            $.ajax({
                method: "POST",
                url: "/items/country-city",
                data: {
                    country : country
                },
                success: function (data) {
                    var dataCity = '<option value = "">Chose city</option>';
                    $.each(data, function (index, value) {
                        console.log(value);
                        dataCity = dataCity +
                            '<option>' + value + '</option>'
                    });
                    $('#city').empty();
                    $('#city').append(dataCity);
                }
            });
        }
    </script>
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
            </li>
        </ul>
        <c:if test="${registeredUser != null}">
            <div class="navbar-text mr-3">${registeredUser.name}</div>
            <form class="form-inline my-2 my-lg-0" action="${pageContext.servletContext.contextPath}/singout">
                <button class="btn my-2 my-sm-0" type="submit">Sing out</button>
            </form>
        </c:if>
    </div>
</nav>
<h1 class="text-center mt-5">Update user <c:out value="${user.name}"></c:out></h1>
<h1></h1>
<div class="row">
    <div class="col offset-md-2">
        <form class="form-horizontal" action = "${pageContext.servletContext.contextPath}/" method="post">
            <div class="row form-group">
                <input type = "hidden" name = "action" value = "update">
                <input type = "hidden" name = "id" value = "<c:out value="${user.id}"></c:out>">
            </div>
            <div class="row form-group">
                <label class="control-label col-sm-2 col-form-label" for="name">Name:</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="name" value = "<c:out value="${user.login}"></c:out>" id="name" placeholder="Enter name" title="Name cannot be empty!">
                </div>
            </div>
            <div class="row form-group">
                <label class="control-label col-sm-2 col-form-label" for="login">Login:</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="login" value = "<c:out value="${user.login}"></c:out>" id="login" placeholder="Enter login" title="Login cannot be empty!">
                </div>
            </div>
            <div class="row form-group">
                <label class="control-label col-sm-2 col-form-label" for="password">Password:</label>
                <div class="col-md-6">
                    <input type="password" class="form-control" name="password" value = "<c:out value="${user.password}"></c:out>" id="password" placeholder="Enter password" title="Password cannot be empty!">
                </div>
            </div>
            <div class="row form-group">
                <label class="control-label col-sm-2 col-form-label" for="country">Country:</label>
                <div class="col-md-6">
                    <select type="text" class="form-control" name="country" id="country" title="Country cannot be empty!" onchange="getAllCityByCountry(this.value)">
                        <option value="<c:out value="${user.country}"></c:out>"><c:out value="${user.country}"></c:out></option>
                    </select>
                </div>
            </div>
            <div class="row form-group">
                <label class="control-label col-sm-2 col-form-label" for="city">City:</label>
                <div class="col-md-6">
                    <select type="text" class="form-control" name="city" id="city" title="City cannot be empty!" >
                        <option value="<c:out value="${user.city}"></c:out>"><c:out value="${user.city}"></c:out></option>
                    </select>
                </div>
            </div>
            <div class="row form-group">
                <label class="control-label col-sm-2 col-form-label" for="email">Email:</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="email" value = "<c:out value="${user.email}"></c:out>" id="email" placeholder="Enter email" title="Email cannot be empty!">
                </div>
            </div>

            <c:if test="${registeredUser.role.name == 'admin'}">
                <div class="row form-group">
                    <label class="control-label col-sm-2 col-form-label" for="role">Enter role for user:</label>
                    <div class="col-md-6">
                        <select class="form-control" id = "role" name = "roleName">
                            <c:forEach items="${roles}" var="role">
                                <option value="<c:out value="${role.name}"></c:out>"><c:out value="${role.name}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </c:if>
            <div class="row form-group">
                <div class="offset-md-7 ">
                    <button type="submit" class="btn btn-primary px-5 mt-3" onclick="return validate();">Update</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
