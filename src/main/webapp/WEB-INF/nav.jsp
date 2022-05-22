<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container">
			<a class="navbar-brand text-uppercase" href="${pageContext.request.contextPath}/"> Carnet
				d'adresse </a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- /.navbar-header -->
			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="${pageContext.request.contextPath}/"
						class="btn btn-outline-primary mr-2">Liste des contacts</a></li>
					<li class="nav-item"><a href="${pageContext.request.contextPath}/?action=new"
						class="btn btn-outline-primary">Nouveau contact</a></li>
				</ul>
			</div>
		</div>
	</nav>