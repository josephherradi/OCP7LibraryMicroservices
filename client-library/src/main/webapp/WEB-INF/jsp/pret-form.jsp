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

				<form:form action="saveFormPret" cssClass="form-horizontal"
					method="post" modelAttribute="lePretBean">
					<h2>${lePretBean.nomLivre}</h2>
					<br>
                   	<form:hidden path="id" />
                   	<form:hidden path="idLivre" value="${lePretBean.idLivre}" />
                   <form:hidden path="datePret" />
                   <form:hidden path="dateRetour" />
                   <form:hidden path="nomLivre" />
                   <form:hidden path="tagForUpdate" />



                        <div class="form-group">
							<label for="pretProlonge" class="col-md-3 control-label">deja pret Prolonge?</label>
							<div class="col-md-9">
								<form:select path="pretProlonge" cssClass="form-control">
									<form:option value="FALSE">FAUX</form:option>
									<form:option value="TRUE">VRAI</form:option>

								</form:select>
							</div>
						</div>


                       					  <div class="form-group">
                                             <label for="utilisateur" class="col-md-3 control-label">utilisateur</label>
                                             <div class="col-md-9">
                                             <form:select path="utilisateur" cssClass="form-control">
                                             <form:option value="NONE" label="--- Select ---" />
                                             <form:options items="${listUtilisateurs}" itemValue="identifiant" itemLabel="identifiant"/>
                                              </form:select>
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