<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<style>
	<%@ include file="assets/css/bootstrap.min.css" %>
	<%@ include file="assets/css/custom.css" %>
</style>
<title>Editer contact</title>
</head>
<body>
	<c:import url="nav.jsp"/>
	
	<main class="pt-3">
		<div class="container">
			<div class="row">
				<div class="col-md-9 ml-auto mr-auto">
					<div class="card">
						<div class="card-header">
							<strong>Editer un contact</strong>
						</div>
						<div class="card-body">
							<form method="post">
								 <div class="form-group row">
				                    <label for="nom" class="col-md-3 col-form-label">Nom du contact</label>
				                    <div class="col-md-9">
				                      <input type="text" name="firstname" id="nom" class="form-control" placeholder="Entrez le nom du contact" value='<c:out value="${contacts.first_name}"></c:out>'>
				                    </div>
				                 </div>
				                 
				                  <div class="form-group row">
				                    <label for="prenom" class="col-md-3 col-form-label">Prenom du contact</label>
				                    <div class="col-md-9">
				                      <input type="text" name="lastname" id="prenom" class="form-control" placeholder="Entrez le prenom du contact" value='<c:out value="${contacts.last_name}"></c:out>'>
				                    </div>
				                 </div>
				                 
				                  <div class="form-group row">
				                    <label for="email" class="col-md-3 col-form-label">Email du contact</label>
				                    <div class="col-md-9">
				                      <input type="email" name="email" id="email" class="form-control" placeholder="Entrez l'email du contact" value='<c:out value="${contacts.email}"></c:out>'>
				                    </div>
				                 </div>
				                 
				                  <div class="form-group row">
				                    <label for="phone" class="col-md-3 col-form-label">Numero du contact</label>
				                    <div class="col-md-9">
				                      <input type="number" name="phone" id="phone" class="form-control" placeholder="Entrez le telephone du contact" value='<c:out value="${contacts.phone}"></c:out>'>
				                    </div>
				                 </div>
				                 
				                  <div class="form-group row">
				                    <label for="adresse" class="col-md-3 col-form-label">Adresse du contact</label>
				                    <div class="col-md-9">
				                      <input type="text" name="adresse" id="adresse" class="form-control" placeholder="Entrez son adresse" value='<c:out value="${contacts.adresse}"></c:out>'>
				                    </div>
				                 </div>
				                 
				                  <div class="row">
					                  <div class="col-md-6">
					                      <button type="submit" class="btn btn-primary">Sauvegarder</button>
					                      <button type="reset"  class="btn btn-outline-danger">Annuler</button>
					                  </div>
					             </div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	
</body>
</html>