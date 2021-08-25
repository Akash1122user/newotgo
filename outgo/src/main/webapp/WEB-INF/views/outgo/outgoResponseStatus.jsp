<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>

<html lang="en" data-ng-app="myModule">


<head>

<title>OutGo | Response <%=request.getAttribute("TxStatus") %></title>

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
<body onload="javascript:chooseStyle('blue', 60)" data-ng-controller="myController">

	<div id="container">

		<header class="clearfix">

			<div class="top-bar">
			<jsp:include page="shortcontaint/top.jsp"></jsp:include>
			</div>


			<div class="navbar navbar-default navbar-top" role="navigation"
				data-spy="affix" data-offset-top="50">
				
			<div class="container">

	<div class="navbar-header" style="margin-top: -5px">

					 <button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse" style="margin-top: 25px">
							<i class="fa fa-bars"></i>
						</button> 

						<a class="navbar-brand" href="home"> <img alt=""
							src="<%=request.getContextPath()%>/assets/outgoAssets/images/outgo.png"
							style="width: 114px; height: 44px;margin-top: -7px;">
						</a>
					</div>
	<div class="navbar-collapse collapse">




		<ul class="nav navbar-nav navbar-right">
			<li><a href="home">Home</a></li>
			<li><a href="about-us" class="">AboutUs</a></li>

			<!-- <li><a href="services" class="">Services</a></li>
			<li><a href="pricing" class="">Pricing</a></li>
			<li><a href="blogs" class="">Blogs</a></li> -->
			<li><a href="contact" class="">Contact</a></li>
			<li><a href="user-home"><b style=""> User </b></a></li>
		</ul>

	</div>
</div>

<ul class="wpb-mobile-menu">
	<li><a href="home" class="">Home</a></li>
	<li><a href="about-us" class="">AboutUs</a></li>

	<!-- <li><a href="services" class="">Services</a></li>

	<li><a href="pricing" class="">Pricing</a></li>
	<li><a href="blogs" class="">Blogs</a></li> -->
	<li><a 	href="http://smartbiz.outgo.co/login">For Merchant</a></li>
	<li> <a href="user-home">For User</a></li>
	<li><a class="open-switcher show-switcher" >Send Enquiry</a>
								</li>

	<li><a href="contact" class="">Contact</a></li>
	<li><a href="user-home"><b style=""> User </b></a></li>
</ul>

			</div>

		</header>


		<div id="content">
			<div class="container">
				<div class="page-content">
				
				
					<!--  <div class="error-page">
						<h3>Coming Soon!</h3><br>
						
						
						<div class="text-center">
							<a href="home" class="btn-system btn-small">Back To
								Home</a>
							</div>
					</div>  -->
					<div class="col-md-6 col-md-offset-3">
						<div class="box box-info">
						<div class="box-header with-border">
                            <br><br>
                  			<h5 class="box-title">
							<input type="hidden" id="statusMsg">
							<span id="successMsg" style="display:none;color:green"> Your transaction has been completed</span>
							<span id="cancelMsg" style="display:none;color:red">Your transaction has been cancelled</span>
							</h5>
                  			<h4 class="box-title">Your transaction details</h4>
                		</div>
                		
                		<div class="box-body" id="data">
                			<div class="table-responsive">  
       													 
                                    <table id="example1" class="table table-bordered " style="text-align:left;">
                                    	 <thead>
                                            <tr>
                                                <th>Contents</th>
                                                <th>Details</th>
                                                
                                            </tr>
                                        </thead>                                    
                                        <tbody>
                        
                                           
						<tr>
                   <td>Transaction Id</td>
                   <td id="txId"> <%=request.getAttribute("TxId") %></td>
                   </tr>
                   
                   <tr>
                   <td>Name</td>
                   <td id="txName"> <%=request.getAttribute("firstName") %></td>
                   </tr>
				   
				   <tr>
                   <td>Email</td>
                   <td id="txEmail"><%=request.getAttribute("email") %>  </td>
                   </tr>
                   
                   <tr>
                   <td>Transaction Status</td>
                   <td id="txnStatus">
 					<%=request.getAttribute("TxStatus") %>
                   </td>
                   </tr>
                   
                   <tr>
                   <td>Transaction Amount</td>
                   <td id="txAmount"> <%=request.getAttribute("amount") %></td>
                   </tr>
                   
                   <tr>
                   <td>Transaction Date</td>
                   <td id="txDate"> <%=request.getAttribute("txnDateTime") %></td>
                   </tr>
                   
                       </tbody>
                                    
                                                 
                                    </table><!--//table-->
                                    
                                  
                                </div><!--//table-responsive-->		
                		</div>
                		
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