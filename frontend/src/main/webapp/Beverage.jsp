<%@ page import="java.util.*"%>
<%@ page import="de.uniba.dsg.dsam.model.Beverage"%>

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
		
			<a href="addBeverage.jsp" class="btn btn-primary">Create new
				Beverage</a>

		<p>&nbsp;</p>



		<table class="table table-striped">
			<thead>
				<tr>
					<th class="col-md-4" scope="col">Name of Beverage</th>
					<th class="col-md-4" scope="col">Manufacturer</th>
					<th class="col-md-4" scope="col">Quantity</th>
					<th class="col-md-4" scope="col">Price</th>
					<th class="col-md-4" scope="col">Incentive</th>

					<!-- 	<th class="col-md-1" scope="col">Edit Beverage</th>
					<th class="col-md-1" scope="col">Delete Beverage</th>
					<th class="col-md-1" scope="col">Assign Incentive</th> -->

				</tr>
			</thead>
			<tbody>
				<%
					List<Beverage> beverages = (List<Beverage>) request.getAttribute("BeverageList");
					for (Beverage bvs : beverages) {
				%>
				<tr>
					<td class="col-md-4"><%=bvs.getName()%></td>
					<td class="col-md-4"><%=bvs.getManufacturer()%></td>
					<td class="col-md-4"><%=bvs.getQuantity()%></td>
					<td class="col-md-4"><%=bvs.getPrice()%></td>
					<td class="col-md-4"><%=bvs.getIncentive()%></td>
					<td class="col-md-4">
						<div class="btn-group" role="group">
							 <a href="/frontend/addIncentivetoBeverage?beverage_id=<%=bvs.getId()%>"
								class="btn btn-success">Assign Incentives</a>
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
		
	</script>
</body>

</html>
