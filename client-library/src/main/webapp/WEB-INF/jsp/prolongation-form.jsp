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
		<div class="col-md-offset-1 col-md-11">

			<div class="panel-body">
				<h3>Valider prolongation?</h3>
				<br>

				<form:form action="saveFormProlo" cssClass="form-horizontal"
					method="post" modelAttribute="laProlongation">
                   	<form:hidden path="prolongationId" />
                   	<form:hidden path="dateDemande" />
                    <br>

                   	<div class="form-group">
                   						<label for="statut" class="col-md-3 control-label">statut</label>
                   						<div class="col-md-9">
                   							<form:select path="statut" cssClass="form-control">
                   								<form:option value="en attente">en attente</form:option>
                   								<form:option value="Validee">validée</form:option>
                   							</form:select>
                   						</div>
                   					</div>

                                                                  <br>

                    <div class="form-group">
                                                <label for="nomLivre" class="col-md-3 control-label">nomLivre</label>
                                                   <div class="col-md-9">
                                                    <form:input  path="nomLivre" cssClass="form-control" readonly="true"  />
                                                    </div>
                                              </div>
                                              <br>
                    <div class="form-group">
                      <label for="utilisateur" class="col-md-3 control-label">utilisateur</label>
                         <div class="col-md-9">
                          <form:input  path="utilisateur" cssClass="form-control" readonly="true"/>
                          </div>
                    </div>

                        					<div class="form-group">
                        						<div class="col-md-10">
                        							<br> <input type="submit" name="Valider">
                        						</div>
                        					</div>
				</form:form>




			</div>
		</div>
	</div>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>