<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
 	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="beverage">
    <meta name="author" content="monojit,lucky">

<title>Beverage Store</title>

<!-- Bootstrap -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/4-col-portfolio.css" rel="stylesheet">
</head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Beverage Store</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container" style="margin-bottom: 5cm;">
		<h1>New incentive</h1>
		
		<p>&nbsp;</p>
		
		<form role="form" action="/frontend/incentives" method="post">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Incentive Name</span>
					<input name="incentive_name" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
			<span class="input-group-addon">Type of incentive</span>
		    <select class="form-control" id="addType" required="true"
			    name="<%= "incentive_type" %>">
			<option><%= "Promotional gift" %></option>
			<option><%= "Trial package" %></option>
		    </select>
		</div>
			<a href="/frontend/incentives" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-success">Save</button>
		</form>		
	</div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; DSG-DSAM-M: Assignment 1- Group 7 - Monojit Goon & Lucky Sutradhar (2017)</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
