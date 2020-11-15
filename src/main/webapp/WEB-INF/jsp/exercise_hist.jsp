<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Hypertension Exercise History</title>
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

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form:form method="POST"></form:form>
                    <h2>Exercise History</h2>
                    <label>Last 5 days:</label>
                    <br>

                    <div class="grid-container">
                        <div class="grid-item">Day 1</div>
                        <div class="grid-item">Day 2</div>
                        <div class="grid-item">Day 3</div>
                        <div class="grid-item">Day 4</div>
                        <div class="grid-item">Day 5</div>
                    </div><br><br>

                    <h2>Last 30 Days Summary</h2>

                    <label>Duration of Aerobic Exercise</label>
                    <li><a>${pageContext.request.userPrincipal.name}</a></li>
                    <br>

                    <label>Duration of Strength Exercise</label>
                    <li><a>${pageContext.request.userPrincipal.name}</a></li>
                    <br>

                    <label>Current Standing (Great job / Needs improvement in Aerobic exercises / Strength exercises):</label>
                    <li><a>${pageContext.request.userPrincipal.name}</a></li>
                    <br>
            </form:form>
        </c:if>

    </c:if>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>