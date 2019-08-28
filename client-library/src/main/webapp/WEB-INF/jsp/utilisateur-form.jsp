<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>livre form</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />


</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<div class="panel-body">
			<h2>Création utilisateur </h2>

				<form:form action="saveFormUser" cssClass="form-horizontal"
					method="post" modelAttribute="utilisateurBean">
					<h2>${lePretBean.nomLivre}</h2>
					<br>
                   	<form:hidden path="id" />
                    <div class="form-group">
						<label for="identifiant" class="col-md-3 control-label">identifiant</label>
						<div class="col-md-9">
							<form:input path="identifiant" cssClass="form-control" />
						</div>
					</div>
                  <div class="form-group">
						<label for="mail" class="col-md-3 control-label">mail</label>
						<div class="col-md-9">
							<form:input path="mail" cssClass="form-control" />
						</div>
					</div>
				    <div class="form-group">
                    <label for="password" class="col-md-3 control-label">mot de passe</label>
                    <div class="col-md-9">
                    <form:input path="password" type="password" cssClass="form-control" />
                    </div>
                    </div>





					<div class="form-group">
						<div class="col-md-offset-3 col-md-9">
							<form:button cssClass="btn btn-primary">Submit</form:button>
						</div>
					</div>
				</form:form>




			</div>
		</div>
	</div>

</body>
</html>