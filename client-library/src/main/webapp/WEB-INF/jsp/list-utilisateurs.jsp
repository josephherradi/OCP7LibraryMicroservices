<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>liste utilisateurs</title>
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
                		<div style="text-align: left">
                        				<a
                        					href="http://localhost:8080/livres"
                        					class="button medium hpbottom">Liste des livres</a>
                        			</div>

                		<br>

			<h2>Liste des utilisateurs</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>id</th>
					<th>identifiant</th>
					<th>mail</th>






				</tr>

				<c:forEach var="tempUsers" items="${usersList}">



					<tr>
						<td>${tempUsers.id}</td>
						<td>${tempUsers.identifiant}</td>
						<td>${tempUsers.mail}</td>

					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>