<!doctype html>
<html lang="en" data-ng-app="myModule">


<head>

<title>OutGo | User-Home</title>

<link rel="icon"
	href="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png">
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
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/css/select2.min.css"
	media="screen">
<jsp:include page="shortcontaint/css.jsp"></jsp:include>
<jsp:include page="shortcontaint/links.jsp"></jsp:include>


<jsp:include page="shortcontaint/analyticScript.jsp"></jsp:include>
<style>
.vl {
	border-left: 6px solid #eee;
	height: 66px;
}

.n {
	border-bottom-style: solid !important;
	border-bottom-color: #eee !important;
}
</style>

<style type="text/css">
.bs-calltoaction {
	position: relative;
	width: auto;
	padding: 5px 15px;
	border: 1px solid black;
	margin-top: 10px;
	margin-bottom: 10px;
	border-radius: 5px;
}

.bs-calltoaction>.row {
	display: table;
	width: calc(100% + 30px);
}

.bs-calltoaction>.row>[class^="col-"], .bs-calltoaction>.row>[class*=" col-"]
	{
	float: none;
	display: table-cell;
	vertical-align: middle;
}

.cta-contents {
	padding-top: 10px;
	padding-bottom: 10px;
}

.cta-title {
	margin: 0 auto 15px;
	padding: 0;
}

.cta-desc {
	padding: 0;
}

.cta-desc p:last-child {
	margin-bottom: 0;
}

.cta-button {
	padding-top: 10px;
	padding-bottom: 10px;
}

@media ( max-width : 991px) {
	.bs-calltoaction>.row {
		display: block;
		width: auto;
	}
	.bs-calltoaction>.row>[class^="col-"], .bs-calltoaction>.row>[class*=" col-"]
		{
		float: none;
		display: block;
		vertical-align: middle;
		position: relative;
	}
	.cta-contents {
		text-align: center;
	}
}

.bs-calltoaction.bs-calltoaction-default {
	color: #333;
	background-color: #fff;
	border-color: #ccc;
}

.bs-calltoaction.bs-calltoaction-primary {
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
}

.bs-calltoaction.bs-calltoaction-info {
	color: #fff;
	background-color: #5bc0de;
	border-color: #46b8da;
}

.bs-calltoaction.bs-calltoaction-success {
	color: #fff;
	background-color: #5cb85c;
	border-color: #4cae4c;
}

.bs-calltoaction.bs-calltoaction-warning {
	color: #fff;
	background-color: #f0ad4e;
	border-color: #eea236;
}

.bs-calltoaction.bs-calltoaction-danger {
	color: #fff;
	background-color: #d9534f;
	border-color: #d43f3a;
}

.bs-calltoaction.bs-calltoaction-primary .cta-button .btn,
	.bs-calltoaction.bs-calltoaction-info .cta-button .btn,
	.bs-calltoaction.bs-calltoaction-success .cta-button .btn,
	.bs-calltoaction.bs-calltoaction-warning .cta-button .btn,
	.bs-calltoaction.bs-calltoaction-danger .cta-button .btn {
	border-color: #fff;
}
</style>
<style type="text/css">
.center {
	margin-top: 50px;
}

.modal-header {
	padding-bottom: 5px;
}

.modal-footer {
	padding: 0;
}

.modal-footer .btn-group button {
	height: 40px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
	border: none;
	border-right: 1px solid #ddd;
}

.modal-footer .btn-group:last-child>button {
	border-right: 0;
}
</style>
</head>
<body onload="javascript:chooseStyle('blue', 60);checkCookie();myFunctionMedia()"
	data-ng-controller="myController" data-ng-init="city()">

	<div id="container">

		<header class="clearfix n">

			<div class="top-bar">
				<jsp:include page="shortcontaint/top.jsp"></jsp:include>
			</div>


			<div class="navbar navbar-default navbar-top" role="navigation"
				data-spy="affix" data-offset-top="50">

				<jsp:include page="shortcontaint/userHeader.jsp"></jsp:include>

			</div>

		</header>


		<div class="page-banner displayHidden"
			style="padding: 40px 0; background: url(<%=request.getContextPath()%>/assets/outgoAssets/images/banner2.jpg) center #f9f9f9;background-size: cover; opacity: 2.5;">
		
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h1 style="color: #fff">USER</h1>
					</div>
					<div class="col-md-6">
						<ul class="breadcrumbs">
							<li><a href="home" style="color: #fff">Home</a></li>
							<li style="color: #fff">User</li>
						</ul>
					</div>
				</div>
			</div>
		</div> 


		<div id="content" style="margin-top: -10px">
			<div class="container displayHidden" id="find-city"
				style="display: block;">
				<!-- ! css  -->
				<div class="row sidebar-page">



					<%-- <div class="col-md-12">
							<div class="col-md-3 col-md-offset-3 image-service-box" style="margin-top: 10px;width: 180px;height: 68px;"> 
							<img alt="" class="responsive"
							src="<%=request.getContextPath()%>/assets/outgoAssets/images/outgo.png"  >
							</div>
							
					<div class="col-md-3 vl" style="margin-top: 5px;"> 
					<!-- <div class="vl"></div> -->
					<h1 style="font-weight: bold;color: #87c43c;font-size: xx-large;padding-top: 25px">
						Find Your City  
						</h1>
						
					</div>
					</div> --%>
					<!-- forms  -->
					
						<h1 class="classic-title text-center" style="color: #00afd1"><span>Services To Pay</span></h1>
					
					<div class="col-md-12" style="padding-top: 20px">
						<div class="row">

							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i class="fa fa-phone icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>LANDLINE</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i class="fa fa-wifi icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>BROADBAND</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i
										class="fa fa-television icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>CABLE TV</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i
										class="fa fa-leanpub icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>CLASSES</h4>
									<p></p>
								</div>
							</div>

						</div>
									<div class="row">

							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i class="fa fa-newspaper-o icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>NEWS PAPER</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i class="fa fa-maxcdn icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>MILK PROVIDER</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i
										class="fa fa-female icon-medium-effect icon-effect-2 "></i>
								</div>
								<div class="service-content">
									<h4>MAID SERVICE</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i
										class="fa fa-university icon-medium-effect icon-effect-2 "></i>
								</div>
								<div class="service-content">
									<h4>LIBRARY</h4>
									<p> </p>
								</div>
							</div>

						</div>
						<div class="row">

							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i class="fa fa-sun-o icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>JEWELLERY</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i class="fa fa-qq icon-medium-effect icon-effect-2"></i>
								</div>
								<div class="service-content">
									<h4>BIRD FEEDER</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()">
								<div class="service-icon">
									<i
										class="fa fa-wrench icon-medium-effect icon-effect-2 "></i>
								</div>
								<div class="service-content">
									<h4>HARDWARE REPAIRING</h4>
									<p></p>
								</div>
							</div>


							<div class="col-md-3 col-sm-6 service-box service-center" style="cursor: pointer; " data-ng-click="funtush()" >
							
								<div class="service-icon">
								<i
										class="fa fa-plus-circle icon-medium-effect icon-effect-2 "></i>
								</div>
								<div class="service-content">
									<h4>OTHER</h4>
									<p> </p>
								</div>
								
							</div>

						</div>
		
					</div>
				</div>
			</div>


			<!-- Display Content Search -->

			<div class="container display" id="display-services"
				style="padding-top: 20px; display: none;">
				<!--! css  -->





				<div class="row sidebar-page">

					<div class="col-md-3 sidebar left-sidebar">

						<div class="widget widget-search">
							<form >
								<input type="search" placeholder="Enter Keywords..." data-ng-model="searchName.merchant_business_name">
								<button class="search-btn" type="button">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>

						<div class="widget widget-categories">
							<h4>
								Services in  <b class="serviceArea"></b><span class="head-line " style="width: 270px"></span>
							</h4>

							<ul data-ng-repeat="item in serviceData ">
								<li><a style="cursor: pointer;"
									data-ng-click="getMyService(item.service_id)">{{item.service_name}}</a></li>

							</ul>



						</div>





					</div>


					<div class="col-md-9 page-content">

						<h4 class="classic-title">
							<span>Operators -<b class="serviceArea"></b></span>
						</h4>

						<div class="col-sm-12 " id="displayStrip" style=""
							data-ng-repeat="mdata in allData | filter : searchName | orderBy : 'merchant_business_name'">
							<!-- Append Strip  -->

							<div class="bs-calltoaction bs-calltoaction-default ">
								<div class="row">
									<div class="col-md-10 cta-contents ">

										<div class="cta-desc">
											<div class="col-md-12">
												<div class="col-md-10">
													<div class="col-md-4">
														<img style="height: 80px"
															src="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/{{mdata.merchant_service_logo}}"
															alt="{{mdata.merchant_business_name}}">
													</div>
													<div class="col-md-8">

														<h1 class="cta-title businessName">{{mdata.merchant_business_name}}</h1>
														<b id="serviceToPay">{{mdata.service_name}}</b>
														<p id="businessArea">{{mdata.area_name}} &nbsp;{{mdata.city_name}}</p>
													</div>
												</div>
												<!-- <div class="col-md-2 vl">
                                
                                </div>  -->
											</div>
										</div>
									</div>
									<div class="col-md-2  cta-button xx" id="m">
										<a class="btn btn-lg btn-block btn-info"
											data-ng-click="payNowModel(mdata)">Pay Now!</a> <a
											class="btn btn-lg btn-block btn-default"
											data-ng-click="complaint(mdata)">Send Message!</a>
									</div>
								</div>
							</div>



						</div>
						<div class="hr5" style="margin-top: 30px; margin-bottom: 45px;"></div>
						<div class="col-sm-10 " style="display: none;" id="myMsg">
						<h2> </h2>
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



<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/outgoAssets/js/script.js"></script>


	<script type="text/javascript">
	function myFunctionMedia() {
	    
	    if (window.matchMedia("(max-width: 700px)").matches) {
	    	//alert("small")
	    	$(".xx").removeClass("vl");
	    } else {
	    	//alert("long")
	    	$(".xx").addClass("vl");
	    }
	}
/* var mq = window.matchMedia('@media all and (max-width: 700px)');
if(mq.matches) {
	
	$(".bar111").addClass("vl");
} else {
	 
	$(".bar111").removeClass("vl");
} */
</script>
	

</body>


</html>