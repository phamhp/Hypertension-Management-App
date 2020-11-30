<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Hypertension Exercise Entry</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="/resources/css/shared.css" rel="stylesheet">
    <link href="/resources/css/home.css" rel="stylesheet">
</head>
<body>
<div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/home">Hypertension Management App</a>
                </div>

                <form id="logoutForm" method="POST" action="/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <ul class="nav navbar-nav navbar-right">
                    <li><a>${pageContext.request.userPrincipal.name}</a></li>
                    <li>
                        <a id="logout-btn" onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <form:form method="POST" modelAttribute="exerciseForm">
            <h2>Exercise Entry</h2>
            <label for="type">Type:</label><br>
            <spring:bind path="type">
                <form:input type="text" path="type" id="type" placeholder="Aerobic / Strength"></form:input>
            </spring:bind>
        </br>

            <label for="duration">Duration of exercise:</label><br>
            <spring:bind path="duration">
                <form:input type="text" path="duration" id="duration" placeholder="ex: 25 mins "></form:input>
            </spring:bind>
        </br>

            <label for="notes">Notes:</label><br>
            <spring:bind path="notes">
                <form:input type="text" path="notes" id="notes" placeholder="Ex: running / weights"></form:input>
            </spring:bind>
        </br>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </c:if>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
