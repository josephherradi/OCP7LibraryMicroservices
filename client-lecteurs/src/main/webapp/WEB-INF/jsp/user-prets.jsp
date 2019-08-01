<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>liste livres</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">



		<div class="col-md-offset-2 col-md-9">
				<div style="text-align: right">
                				<a href="${pageContext.request.contextPath}/logout"
                					class="button medium hpbottom">Se déconnecter</a>
                			</div>
                			<p>Bienvenue ${sessionScope.user}</p>

		<br>
        		<div style="text-align: left">
                				<a
                					href="http://localhost:8082/livres"
                					class="button medium hpbottom">Liste des livres</a>
                			</div>

        		<br>

        		<div style="text-align: left">
                                				<a
                                					href="http://localhost:8082/userprolongations"
                                					class="button medium hpbottom">Mes prolongations</a>
                                			</div>

                        		<br>


			<h2>ma liste des prets</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>nom livre</th>
					<th>date du pret</th>
					<th>date de retour</th>
					<th>pret deja prolonge?</th>






				</tr>

				<c:forEach var="tempPrets" items="${userPrets}">
				<c:url var="prolongationLink"
                						value="pret/${tempPrets.id}/prolongation/showFormProlo">
                					</c:url>

					<tr>
						<td>${tempPrets.nomLivre}</td>
						<td>${tempPrets.datePret}</td>
						<td>${tempPrets.dateRetour}</td>
						<td>${tempPrets.pretProlonge}</td>

						<td><a href="${prolongationLink}">Prolongation</a></td>


					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>