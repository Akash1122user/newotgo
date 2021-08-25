<!doctype html>

<html lang="en" data-ng-app="myModule">

<head>

<title>OutGo | Services</title>
 <link rel="icon" href="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png" >
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<meta
	content="www.outgo.co ,outgo payment solutions, all services at one place, landline payment, broadband payment,OutGo, Payment Simplified,Easy to pay"
	name="description">
<meta
	content="www.outgo.co is a  website to provide the payment solution for every user as per respective marchent."
	name="keywords">
<meta content="outgo" name="author">
<meta name="robots" content="index,follow">
<jsp:include page="shortcontaint/css.jsp"></jsp:include>
 <jsp:include page="shortcontaint/links.jsp"></jsp:include>
 <jsp:include page="shortcontaint/analyticScript.jsp"></jsp:include>

</head>
<body onload="javascript:chooseStyle('blue', 60)" data-ng-controller="myController">

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


		<div class="page-banner"
			style="padding: 40px 0; background: url(<%=request.getContextPath()%>/assets/outgoAssets/images/banner2.jpg) center #f9f9f9;background-size: cover; opacity: 2.5;">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h1 style="color: #fff">Services</h1>
						<!-- <p>We Are Professional</p> -->
					</div>
					<div class="col-md-6">
						<ul class="breadcrumbs">
							<li><a href="home" style="color: #fff">Home</a></li>
							<li style="color: #fff">Services</li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<div id="content">
			<div class="container-fluid">
				<div class="page-content">


					<div class="hr1" style="margin-bottom: 45px;"></div>



					<div class="row">

						<div class="col-md-5 image-service-box" style="margin-top: 10px;height: 600px;">
							<img class="" style="height:450px;width: 550px"
								src="/outgo/assets/outgoAssets/images/desktop.png" alt="">
							
						</div>


						<div class="col-md-4">
							<div class=""  style="margin-left: 100px;">
							<h1 style="color: #00afd1">Our Features</h1>
							</div>
							<div class="hr1" style="margin-bottom: 30px;"></div>
							<div class="service-content" style="margin-left: 60px;"> 
										<h3>&diams; Multilingual Merchant App </h3>
										
									</div>
							<div class="hr1" style="margin-bottom: 20px;"></div>
							<div class="service-content"  style="margin-left: 60px;">
										<h3 >&diams; Invoicing &amp; Receipts </h3>
										
									</div>
									<div class="hr1" style="margin-bottom: 20px;"></div>
							<div class="service-content"  style="margin-left: 60px;">
										<h3>&diams; Employee Management </h3>
										
									</div>
									<div class="hr1" style="margin-bottom: 20px;"></div>
							<div class="service-content"  style="margin-left: 60px;">
										<h3>&diams; Online Payment Collection </h3>
										
									</div>
									<div class="hr1" style="margin-bottom: 20px;"></div>
							<div class="service-content"  style="margin-left: 60px;">
										<h3>&diams; Send Bulk SMS/Email </h3>
										
									</div>
									<div class="hr1" style="margin-bottom: 20px;"></div>
							<div class="service-content"  style="margin-left: 60px;">
										<h3>&diams;Tasks/Leads management</h3>
										
									</div>
									<div class="hr1" style="margin-bottom: 20px;"></div>
							<div class="service-content"  style="margin-left: 60px;">
										<h3>&diams; Expense management </h3>
										
									</div>
									
						</div>


						<div class="col-md-3 image-service-box">
							<img class="" style="height:500px;width: 300px" src="/outgo/assets/outgoAssets/images/marathidashboard.png" alt="">
							
						</div>

					</div>



					<!-- 					<div class="row">
						<div class="col-md-4">

							<h4 class="classic-title">
								<span></span>
							</h4>

							<div class="panel-group" id="accordion">

								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse-one"> <i
												class="fa fa-angle-up control-icon"></i> <i
												class=""></i>
											</a>
										</h4>
									</div>
									<div id="collapse-one" class="panel-collapse collapse in">
										<div class="panel-body">
										<img alt="" src="/outgo/assets/outgoAssets/images/Businesses-01.png">
										
										
										
										
										</div>
									</div>
								</div>


								

							

							</div>

						</div>
						<div class="col-md-8">

							<h4 class="classic-title">
								<span>Our Features</span>
							</h4>
							<div class="row">
							<div class="col-md-6">
								<div class="col-md-12 service-box service-icon-left-more">
									<div class="service-icon">
										<i class="fa fa-magic icon-medium"></i>
									</div>
									<div class="service-content">
										<h4>Invoicing &amp; Receipts</h4>
										
									</div>
								</div>


								<div class="col-md-12 service-box service-icon-left-more">
									<div class="service-icon">
										<i class="fa fa-users icon-medium"></i>
									</div>
									<div class="service-content">
										<h4>Employee Management </h4>
									
									</div>
								</div>


								<div class="col-md-12 service-box service-icon-left-more">
									<div class="service-icon">
										<i class="fa fa-globe icon-medium"></i>
									</div>
									<div class="service-content">
										<h4>Online Collection</h4>
										
									</div>
								</div>


								<div class="col-md-12 service-box service-icon-left-more">
									<div class="service-icon">
								
									</div>
									<div class="service-content">
										<h4>Send Bulk SMS/Email</h4>
										
									</div>
								</div>


								<div class="col-md-12 service-box service-icon-left-more">
									<div class="service-icon">
									
									</div>
									<div class="service-content">
									<h4>Tasks/Leads management</h4>
										
									</div>
								</div>


								<div class="col-md-12 service-box service-icon-left-more">
									<div class="service-icon">
										
									</div> 
									<div class="service-content">
										<h4>Expense management</h4>
										
									</div>
								</div>
								</div>
								<div class="col-md-2">
								
								
								</div>
							</div>
						</div>
					</div> -->
					
<!-- 
					<div class="hr1" style="margin-bottom: 25px;"></div>
					<div class="row">
						<div class="col-md-8">

							<div class="our-clients">

								<h4 class="classic-title">
									<span>Our Clients</span>
								</h4>
								<div class="clients-carousel custom-carousel touch-carousel"
									data-appeared-items="4">

									<div class="client-item item">
										<a href="#"><img src="images/c1.png" alt="" /></a>
									</div>

									<div class="client-item item">
										<a href="#"><img src="images/c2.png" alt="" /></a>
									</div>

									<div class="client-item item">
										<a href="#"><img src="images/c3.png" alt="" /></a>
									</div>

									<div class="client-item item">
										<a href="#"><img src="images/c4.png" alt="" /></a>
									</div>

									<div class="client-item item">
										<a href="#"><img src="images/c5.png" alt="" /></a>
									</div>

									<div class="client-item item">
										<a href="#"><img src="images/c6.png" alt="" /></a>
									</div>

									<div class="client-item item">
										<a href="#"><img src="images/c7.png" alt="" /></a>
									</div>

									<div class="client-item item">
										<a href="#"><img src="images/c8.png" alt="" /></a>
									</div>
								</div>
							</div>

						</div>
						<div class="col-md-4">

							<h4 class="classic-title">
								<span>Client Testimonials</span>
							</h4>

							<div class="custom-carousel show-one-slide touch-carousel"
								data-appeared-items="1">

								<div class="classic-testimonials item">
									<div class="testimonial-content">
										<p>Excepteur sint occaecat cupidatat non proident, sunt in
											culpa qui officia deserunt mollit anim laborum.</p>
									</div>
									<div class="testimonial-author">
										<span>John Doe</span> - Customer
									</div>
								</div>

								<div class="classic-testimonials item">
									<div class="testimonial-content">
										<p>Excepteur sint occaecat cupidatat non proident, sunt in
											culpa qui officia deserunt mollit anim laborum.</p>
									</div>
									<div class="testimonial-author">
										<span>John Doe</span> - Customer
									</div>
								</div>

								<div class="classic-testimonials item">
									<div class="testimonial-content">
										<p>Excepteur sint occaecat cupidatat non proident, sunt in
											culpa qui officia deserunt mollit anim laborum.</p>
									</div>
									<div class="testimonial-author">
										<span>John Doe</span> - Customer
									</div>
								</div>
							</div>

						</div> -->
					</div>
				</div>
			</div>
			<div id="" class="container" style="padding-bottom: 30px;margin-top: -70px;" >
		<div class="row">
					<div class="col-md-12 text-center"
						style="padding-top: 00px; padding-bottom: 5px">
						<h1 style="color: #00afd1; font-size: 24px; line-height: 30px;">SERVICES</h1>
					</div>
				</div>
			<div class="row">	

				<div class="hr1 margin-top"></div>

				<div class="recent-projects">
					<h4 class="title">
						<span style="padding-left: 5px">We provide services to </span>
					</h4>
					<div class="projects-carousel touch-carousel">
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-phone fa-4x"></b><br> LANDLINE</h4>  
										
										
									</a>
								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-wifi fa-4x"></b><br> BROADBAND</h4>  
										
										
									</a>
								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-television fa-4x"></b><br> CABLE TV</h4>  
										
										
									</a>
								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-leanpub fa-4x"></b><br> CLASSES</h4>  
										
										
									</a>
								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-newspaper-o fa-4x"></b><br> NEWS PAPER</h4>  
										
										
									</a>
								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><!-- <b  class="fa fa-meetup"></b> -->
										<i class="fa fa-maxcdn fa-4x" aria-hidden="true"></i>
										<br> MILK PROVIDER</h4>  
										
										
									</a>
								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-female fa-4x"></b><br> MAID SERVICE</h4>  
										
										
									</a>

								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="#">
									
										<h4><b class="fa fa-university fa-4x"></b><br> LIBRARY</h4>  
										
										
									</a>

								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-sun-o fa-4x"></b><br> 	JEWELLERY</h4>  
										
										
									</a>

								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								<div class="portfolio-thumb">
									
								</div>
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-qq fa-4x"></b><br> BIRD FEEDER</h4>  
										
										
									</a>

								</div>
							</div>
						</div>
						<div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details text-center">
									<a href="user">
									
										<h4><b class="fa fa-wrench fa-4x"></b><br> HARDWARE REPAIRING</h4>  
										
										
									</a>

								</div>
							</div>
						</div>
						<!-- <div class="portfolio-item item">
							<div class="portfolio-border">
								
								<div class="portfolio-details">
									<a href="#">
										<h4>Lorem Ipsum Dolor</h4> <span>Ilustration</span> <span>Animation</span>
									</a>
								</div>
							</div>
						</div> -->
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