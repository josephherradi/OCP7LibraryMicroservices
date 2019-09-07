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
                					href="http://localhost:8080/livres"
                					class="button medium hpbottom">Liste des livres</a>
                			</div>

        		<br>


			<h2>Liste des prets</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>id</th>
					<th>nom livre</th>
					<th>date du pret</th>
					<th>date de retour</th>
					<th>pret deja prolonge?</th>
					<th>utilisateur</th>
					<th>Rendu?</th>







				</tr>

				<c:forEach var="tempPrets" items="${listPrets}">
                <c:url var="updateLink" value="updateFormPret">
                 <c:param name="pretId" value="${tempPrets.id}" />
                  </c:url>

                   <c:url var="deleteLink" value="deletePret">
                    <c:param name="pretId" value="${tempPrets.id}" />
                     </c:url>


					<tr>
						<td>${tempPrets.id}</td>
						<td>${tempPrets.nomLivre}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${tempPrets.datePret}"/></td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${tempPrets.dateRetour}"/> </td>
						<td>${tempPrets.pretProlonge}</td>
						<td>${tempPrets.utilisateur}</td>
						<td>${tempPrets.rendu}</td>

                    <c:if test="${tempPrets.rendu==false}" var="variable">

						<td><a href="${updateLink}">Update |</a>
						<a href="${deleteLink}" onclick="if (!(confirm('supprimer ce pret'))) return false">Delete</a>
						</td>
					</c:if>

					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>