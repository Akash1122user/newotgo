<!doctype html>

<html lang="en">


<head>

<title>OutGo | File not Found</title>

<meta charset="utf-8">
<link rel="icon" href="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png" >
<meta content="www.outgo.co ,outgo payment solutions, all services at one place, landline payment, broadband payment,OutGo, Payment Simplified,Easy to pay" name="description">
<meta content="www.outgo.co is a  website to provide the payment solution for every user as per respective marchent." name="keywords">
<meta content="outgo" name="author">
<meta name="robots" content="index,follow">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<jsp:include page="shortcontaint/css.jsp"></jsp:include>
<jsp:include page="shortcontaint/links.jsp"></jsp:include>

</head>
<body>

	<div id="container">

		<header class="clearfix">

			<div class="top-bar">
			<jsp:include page="shortcontaint/top.jsp"></jsp:include>
			</div>


			<div class="navbar navbar-default navbar-top" role="navigation"
				data-spy="affix" data-offset-top="50">
				
	<jsp:include page="shortcontaint/header.jsp"></jsp:include>

			</div>

		</header>


		<div id="content">
			<div class="container">
				<div class="page-content">
					 <div class="error-page">
						<h1>404</h1>
						<h3>File not Found</h3>
						<p>We're sorry, but the page you were looking for doesn't
							exist.</p>
						<div class="text-center">
							<a href="home" class="btn-system btn-small">Back To
								Home</a>
						</div>
					</div> 
				</div>
			</div>
		</div>


		<footer>
			<jsp:include page="shortcontaint/footer.jsp"></jsp:include>
		</footer>

	</div>

<jsp:include page="shortcontaint/models.jsp"></jsp:include>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/script.js"></script>
</body>


</html>