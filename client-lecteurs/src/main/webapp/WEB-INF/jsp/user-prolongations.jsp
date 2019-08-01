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
		<br>
		<p>
        <button type="button" name="back" onclick="history.back()">back</button>

        </p>
		<br>


			<h3>Mes prolongations </h3>

			<table class="table table-striped table-bordered">
				<tr>
					<th>Date de demande</th>
					<th> Livre emprunté</th>
					<th>statut prolongation</th>






				</tr>

				<c:forEach var="userProlongations" items="${userProlongations}">

					<tr>
						<td>${userProlongations.dateDemande}</td>
						<td>${userProlongations.nomLivre}</td>
						<td>${userProlongations.statut}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>