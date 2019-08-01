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

				<form:form action="saveFormLivre" cssClass="form-horizontal"
					method="post" modelAttribute="leLivreBean">
					<h2>Livre</h2>
                   	<form:hidden path="id" />

					<div class="form-group">
						<label for="nom" class="col-md-3 control-label">nom</label>
						<div class="col-md-9">
							<form:input path="nom" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-md-3 control-label">description</label>
						<div class="col-md-9">
							<form:input path="description" cssClass="form-control" />
						</div>
					</div>
					 <div class="form-group">
                     <label for="categorie" class="col-md-3 control-label">categorie</label>
                     <div class="col-md-9">
                     <form:select path="categorie" cssClass="form-control">
                     <form:option value="NONE" label="--- Select ---" />
                     <form:options items="${categorieList}" />
                     </form:select>
                     </div>
                     </div>
					<div class="form-group">
						<label for="disponibilite" class="col-md-3 control-label">disponibilite</label>
						<div class="col-md-9">
							<form:input path="disponibilite" cssClass="form-control" />
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