<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
        					class="button medium hpbottom">Liste des prêts</a>
        			</div>

		<br>
			<input type="button" value="Ajouter livre"
        					onclick="window.location.href='showFormLivre'; return false;"
        					class="btn btn-primary" />
         <br>

			<h2>Liste des livres</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>id</th>
					<th>nom</th>
					<th>description</th>
					<th>categorie</th>
					<th>disponibilite</th>





				</tr>

				<c:forEach var="tempLivres" items="${listLivres}">
                <c:url var="updateLink" value="updateFormLivre">
                 <c:param name="livreId" value="${tempLivres.id}" />
                  </c:url>

                   <c:url var="deleteLink" value="deleteLivre">
                    <c:param name="livreId" value="${tempLivres.id}" />
                     </c:url>
                    <c:url var="pretLink" value="showFormPret">
                   <c:param name="livreId" value="${tempLivres.id}" />
                     </c:url>


					<tr>
						<td>${tempLivres.id}</td>
						<td>${tempLivres.nom}</td>
						<td>${tempLivres.description}</td>
						<td>${tempLivres.categorie}</td>
						<td>${tempLivres.disponibilite}</td>
						<td><a href="${updateLink}">Update |</a>
						<a href="${deleteLink}" onclick="if (!(confirm('supprimer ce livre?'))) return false">Delete</a>
						<a href="${pretLink}">| Pret</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>