<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<style>
	<%@ include file ="assets/css/bootstrap.min.css"%>
	<%@ include file="assets/css/custom.css" %>
</style>
<title>Carnet d'adresse</title>
</head>
<body>

	<c:import url="nav.jsp"/>
	
	<main class="pt-3">
		<div class="container">
			<div class="row">
				<div class="col-md-9 ml-auto mr-auto">
					<div class="card">
						<div class="card-header"><strong>Tous les contacts</strong></div>
						<div class="card-body">
							<table class="table table-striped table-bordered" style="width:100%">
								<thead>
						            <tr>
						                <th>ID</th>
						                <th>Nom</th>
						                <th>Prenom</th>
						                <th>Telephone</th>
						                <th>Email</th>
						                <th>Actions</th>
						            </tr>
						        </thead>
							
								<tbody>
						            <tr>
						                <td>1</td>
						                <td>Takam</td>
						                <td>Rushclin</td>
						                <td>690139627</td>
						                <td>takamrushclin@gmail.com</td>
						                <td>
						                	<a href="${pageContext.request.contextPath}/?action=edit" class="btn btn-outline-primary btn-circle btn-xs" title="Editer">
						                        <i class="fa fa-edit"></i>
						                    </a>
						                    <a href="#" class="btn btn-outline-danger btn-circle btn-xs" title="Supprimer">
						                        <i class="fa fa-times"></i>
						                    </a>
						                </td>
						            </tr>
						            <tr>
						                <td>1</td>
						                <td>Takam</td>
						                <td>Rushclin</td>
						                <td>690139627</td>
						                <td>takamrushclin@gmail.com</td>
						                <td>
						                	<a href="" class="btn btn-outline-primary btn-circle btn-xs" title="Editer">
						                        <i class="fa fa-edit"></i>
						                    </a>
						                    <a href="#" class="btn btn-outline-danger btn-circle btn-xs" title="Supprimer">
						                        <i class="fa fa-times"></i>
						                    </a>
						                </td>
						            </tr>
						        </tbody>
						        <tfoot>
						        	<tr class="text-center">
						        		<td colspan="6">Generated by @UDS-TEAM</td>
						        	</tr>
						        </tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<script type="text/javascript">
		<%@ include file="assets/js/jquery.min.js" %>
		<%@ include file="assets/js/bootstrap.min.js" %>
	</script>
	
</body>
</html>