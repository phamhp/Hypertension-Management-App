<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Hypertension Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="/resources/css/shared.css" rel="stylesheet">
    <link href="/resources/css/home.css" rel="stylesheet">
</head>
<body>
<div>The Dietary Guidelines for Americans recommend that an adult&sbquo;s total daily calories come from the following: 45&ndash;65% carbohydrates 10&ndash;30% protein 20&ndash;35 % fat.</div>
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

        <!-- <div class="grid-container">
        <c:forEach var="singleEntry" items="${dietEntries}">

            <div class="grid-item ${singleEntry.name}" >
            <span>${singleEntry.name} </span>
            <span>${singleEntry.category} </span>
            <span>${singleEntry.description} </span>
            </div>

        </c:forEach>
        </div>
        -->
        <div>
            <table border="1">

                <tr>
                    <th style="width:5%" class="grid-item">Created date</th>
                    <th style="width:10%" class="grid-item">Type</th>
                    <th style="width:10%"  class="grid-item">Name</th>
                    <th style="width:20%" class="grid-item">Description</th>
                    <th style="width:5%" class="grid-item">Carb</th>
                    <th style="width:5%" class="grid-item">Protein</th>
                    <th style="width:5%" class="grid-item">Fat</th>
                </tr>


                <c:forEach var="singleEntry" items="${dietEntries}">
                    <tr>
                        <td> ${singleEntry.createdDate} </td>
                        <td> ${singleEntry.category} </td>
                        <td> ${singleEntry.name} </td>
                        <td> ${singleEntry.description} </td>
                        <td> ${singleEntry.carb} </td>
                        <td> ${singleEntry.protein} </td>
                        <td> ${singleEntry.fat} </td>
                    </tr>
                    </tr>
                </c:forEach>

            </table>

        </div>
        <div class="grid-container">
            <c:forEach var="entry" items="${totalDateList}">
                <!-- date: ${entry} | total: ${totalCarbHash[entry]} | good ? bad ? </br>-->
                <div class="grid-item ${entry}">
                    <br>Date: ${entry} </br>
                    <br>Total carb: ${totalCarbHash[entry]} </br>
                    <br>Total protein: ${totalProteinHash[entry]} </br>
                    <br>Total fat: ${totalFatHash[entry]} </br>
                    <br>${decisionCarbHash[entry]} </br>
                    <br>${decisionProteinHash[entry]} </br>
                    <br>${decisionFatHash[entry]} </br>


                </div>
            </c:forEach>
        </div>
        <div>
        </div>

    </c:if>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>