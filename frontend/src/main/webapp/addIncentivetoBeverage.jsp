<%@ page import="java.util.*"%>
<%@ page import="de.uniba.dsg.dsam.model.Incentive"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="beverage">
<meta name="author" content="monojit,lucky">

<title>Beverage Store</title>

<!-- Bootstrap -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/4-col-portfolio.css" rel="stylesheet">
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
		<%Object object = request.getAttribute("bev_id");
    		int bev_id =Integer.parseInt(object.toString());%>
			<a class="navbar-brand" href="#">Beverage Store</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		</div>
	</nav>

<div class="container" style="margin-bottom: 5cm;">


		<div class='page-header'>
			<h2>Beverage Management</h2>
		</div>
			<a href="/frontend"  type="button" class="btn btn-default" style="margin-right:2px">
				Home </a>
		
		<p>&nbsp;</p>



		<table class="table table-striped">
			<thead>
				<tr>
					<th class="col-md-4" scope="col">Name of Incentive</th>
					<th class="col-md-4" scope="col">Type of Incentive</th>

					<!-- 	<th class="col-md-1" scope="col">Edit Beverage</th>
					<th class="col-md-1" scope="col">Delete Beverage</th>
					<th class="col-md-1" scope="col">Assign Incentive</th> -->

				</tr>
			</thead>
			<tbody>
				<%
					List<Incentive> beverages = (List<Incentive>) request.getAttribute("IncentiveList");
					for (Incentive inc : beverages) {
				%>
				<tr>
					<td class="col-md-4"><%=inc.getName()%></td>
					<td class="col-md-4"><%=inc.getType()%></td>
					<td class="col-md-4">
						<div class="btn-group" role="group">
							 <a
								id="<%=inc.getId()%>" href="" class="assign btn btn-primary">Assign
								Incentive</a> 
						</div>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>


	</div>





	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy;
				DSG-DSAM-M: Assignment 1- Group 7 - Monojit Goon & Lucky Sutradhar
				(2017)</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".assign").click(function() {
				event.preventDefault();
			
				$.ajax({
					url : '/frontend/addIncentivetoBeverage?bev_id=<%= bev_id %>&inc_id=' + event.target.id,
					type : 'PUT',
					success : function(response) {
						location.reload();
					}
				});
			});
		});
	</script>
</body>

</html>
