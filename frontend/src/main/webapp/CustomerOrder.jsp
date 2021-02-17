<%@ page import="java.util.*"%>
<%@ page import="de.uniba.dsg.dsam.model.CustomerOrder"%>

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
			<h2>Customer Order Management</h2>
		</div>
			<a href="/frontend"  type="button" class="btn btn-default" style="margin-right:2px">
				Home </a>
		
			<a href="addIncentive.jsp" class="btn btn-primary">Create new
				Customer Order</a>

		<p>&nbsp;</p>



		<table class="table table-striped">
			<thead>
				<tr>
				
					<th class="col-md-4" scope="col">Date of Customer Order</th>
					<th class="col-md-4" scope="col">List of Beverage</th>

					<!-- 	<th class="col-md-1" scope="col">Edit Beverage</th>
					<th class="col-md-1" scope="col">Delete Beverage</th>
					<th class="col-md-1" scope="col">Assign Incentive</th> -->

				</tr>
			</thead>
			<tbody>
				<%
					List<CustomerOrder> customerOrders = (List<CustomerOrder>) request.getAttribute("orderList");
					for (CustomerOrder ord : customerOrders) {
				%>
				<tr>
					<td class="col-md-4"><%=ord.getIssueDate()%></td>
					<td class="col-md-4"><%=ord.getOrderItems()%></td>
					<td class="col-md-4">
						<div class="btn-group" role="group">
							<a href="/frontend/incentives?incentive_id=<%=ord.getId()%>"
								class="btn btn-primary">Edit order</a> <a
								id="<%=ord.getId()%>" href="" class="delete btn btn-danger">Delete
								order</a> 
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
			$(".delete").click(function() {
				event.preventDefault();

				$.ajax({
					url : '/frontend/customerorders?order_id=' + event.target.id,
					type : 'DELETE',
					success : function(response) {
						location.reload();
					}
				});
			});
		});
	</script>
</body>

</html>
