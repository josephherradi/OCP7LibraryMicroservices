<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>liste livres</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">



		<div class="col-md-offset-2 col-md-9">
		<br>
        		<div style="text-align: left">
                				<a
                					href="http://localhost:8080/prets"
                					class="button medium hpbottom">Liste des prets</a>
                			</div>

        		<br>


			<h2>Liste des prolongations demandées</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>id</th>
					<th>dateDemande</th>
					<th>statut</th>
					<th>pretId</th>
					<th>nomLivre</th>
					<th>utilisateur</th>






				</tr>

				<c:forEach var="prolongationsList" items="${prolongationsList}">
	                <c:url var="acceptLink" value="/pret/${prolongationsList.pretId}/prolongation/updateProlongation">
						<c:param name="prolongationId" value="${prolongationsList.prolongationId}" />
					</c:url>



					<tr>
						<td>${prolongationsList.prolongationId}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${prolongationsList.dateDemande}" /></td>
						<td>${prolongationsList.statut}</td>
                        <td>${prolongationsList.pretId}</td>
						<td>${prolongationsList.nomLivre}</td>
						<td>${prolongationsList.utilisateur}</td>
                    <c:if test="${prolongationsList.statut != 'Validee'}" var="variable">

                    	<td><a href="${acceptLink}">accepter</a>

						</c:if>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>