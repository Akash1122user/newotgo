<!doctype html>

<html lang="en">


<head>

<title>OutGo | Contact</title>
 <link rel="icon" href="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png" >
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<meta content="www.outgo.co ,outgo payment solutions, all services at one place, landline payment, broadband payment,OutGo, Payment Simplified,Easy to pay" name="description">
<meta content="www.outgo.co is a  website to provide the payment solution for every user as per respective marchent." name="keywords">
<meta content="outgo" name="author">
<meta name="robots" content="index,follow">

<jsp:include page="shortcontaint/css.jsp"></jsp:include>
 <jsp:include page="shortcontaint/links.jsp"></jsp:include>
<jsp:include page="shortcontaint/analyticScript.jsp"></jsp:include>
<style>

</style>

</head>
<body onload="javascript:chooseStyle('blue', 60)">

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
						<h2 style="color: #fff">Contact Us</h2>
						<!-- <p>We Are Professional</p> -->
					</div>
					<div class="col-md-6">
						<ul class="breadcrumbs">
							<li><a href="home" style="color: #fff">Home</a></li>
							<li style="color: #fff">Contact Us</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="row" style="padding-top: 10px">
				
				<!-- 	<div class="col-md-8">

						<h4 class="classic-title">
							<span>Contact Us</span>
						</h4>

						<form role="form" id="contactForm" data-toggle="validator"
							class="shake">
							<div class="form-group">
								<div class="controls">
									<input type="text" id="name" placeholder="Name" required
										data-error="Please enter your name">
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="controls">
									<input type="email" class="email" id="email"
										placeholder="Email" required
										data-error="Please enter your email">
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="controls">
									<input type="text" id="msg_subject" placeholder="Subject"
										required data-error="Please enter your message subject">
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="controls">
									<textarea id="message" rows="7" placeholder="Message" required
										data-error="Write your message"></textarea>
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<button type="submit" id="submit" class="btn-system btn-large">Send</button>
							<div id="msgSubmit" class="h3 text-center hidden"></div>
							<div class="clearfix"></div>
						</form>

					</div> -->
					<div class="col-md-4 col-md-offset-2">

						<h4 class="classic-title">
							<span>Information</span>
						</h4>

					<!-- 	<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry. Lorem Ipsum.</p> -->

						<div class="hr1" style="margin-bottom: 10px;"></div>

						<ul class="icons-list">
							<li><i class="fa fa-globe"> </i> <strong>Address:</strong>
								Shreedhan Society, Shivajinagar, Pune</li>
							<li><i class="fa fa-envelope-o"></i> <strong>Email:</strong>
								<a href="mailto:support@outgo.co" target="_blank">support@outgo.co</a></li>
							<li><i class="fa fa-mobile"></i> <strong>Phone:</strong> +91 7083083646
								</li>
						</ul>

						<div class="hr1" style="margin-bottom: 15px;"></div> 

						<h4 class="classic-title">
							<span>Working Hours</span>
						</h4>

						<ul class="list-unstyled">
							<li><strong>Monday - Friday</strong> - 9am to 6pm</li>
							
							<li><strong>Saturday &amp; Sunday</strong> - Closed</li>
						</ul>
					</div>
					<div class="col-md-4 image-service-box" style="margin-top: 50px"> <img alt="" class="responsive"
							src="<%=request.getContextPath()%>/assets/outgoAssets/images/outgo.png"  >
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/form-validator.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/contact-form-script.js"></script>

	
	
</body>


</html>