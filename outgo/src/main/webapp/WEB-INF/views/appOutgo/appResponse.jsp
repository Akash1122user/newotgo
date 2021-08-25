
<!DOCTYPE html>
<html>
<head>
<title>OUTGO | Response <%=request.getAttribute("TxStatus") %> </title>
<!-- For-Mobile-Apps-and-Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta
	content="www.outgo.co ,outgo payment solutions, all services at one place, landline payment, broadband payment,OutGo, Payment Simplified,Easy to pay"
	name="description">
<meta
	content="www.outgo.co is a  website to provide the payment solution for every user as per respective marchent."
	name="keywords">
<meta content="outgo" name="author">
<meta name="robots" content="index,follow">

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps-and-Meta-Tags -->
<!-- Custom Theme files -->
<style type="text/css">



</style>
<link href="<%=request.getContextPath()%>/assets/appAssets/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath()%>/assets/appAssets/css/style.css" type="text/css" rel="stylesheet" media="all"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/appAssets/css/ken-burns.css" type="text/css" media="all" /> 
<!-- //Custom Theme files -->
<!-- js -->
<script src="<%=request.getContextPath()%>/assets/appAssets/js/jquery-2.2.3.min.js"></script> 
<!-- //js -->
<!-- pop-up-box -->
<script src="<%=request.getContextPath()%>/assets/appAssets/js/jquery.magnific-popup.js" type="text/javascript"></script>
	    <script>
			$(document).ready(function() {
				$('.popup-top-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
				});																							
			}); 
		</script>
<!--//pop-up-box -->
<!-- web-fonts -->  
<link href='//fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- //web-fonts -->
</head>
<body class="bg">
	
		<div class="content-wrap">
			<div class="header"> 
				<div class="menu-icon">   
					<button class="menu-button" onclick="showAndroidToast('Hello Android!')">O</button>
				</div>
				<div class="logo">
					<h2><img alt="" width="40px" height="36px" src="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png"> </h2>
				</div>
				<!-- <div class="login">
					<a href="#small-dialog" class="sign-in popup-top-anim"><span class="glyphicon glyphicon-user"></span></a> 
					
				</div>  -->
				<div class="clearfix"> </div>
			</div>
			
			<div class="content">
			<div class="container" style="padding-top: 40px;padding-bottom: 70px">
			<div class="properties-bottom">
							 <div>			
								<% try{
								String status=request.getAttribute("TxStatus").toString();
								System.out.println("Status--->"+status);
								if(status.equals("SUCCESS")){ %>
								<h5><p style="color: green;font-size: large;">
								Your transaction has been successful !
								</p></h5><br>
								<%}else{ %>
								<h5><p style="color: red;font-size: large;">
								Your transaction is CANCELED !
								</p></h5><br>
							<%} }catch(NullPointerException e){
								
								
							}%>
							</div> 
							<div class="w3ls-text">
								<h5>	
								<p>Name               -      	<b><%=request.getAttribute("firstName") %></b></p>
								<p>Email          	  -       	<%=request.getAttribute("email") %></p>
								<p>Transaction Id     -       	<%=request.getAttribute("TxId") %></p>								
								<p>Transaction Status -       	<b><%=request.getAttribute("TxStatus") %></b></p>
								<p>Transaction Amount - 		<b><%=request.getAttribute("amount") %></b></p>
								<p>Transaction Date   -   		<%=request.getAttribute("txnDateTime") %></p>
								</h5>
								
							</div>
							<input type="button" class="btn btn-primary btn-block" value="Back"  style="background-color: #0091ea" onclick="showAndroidToast('Hello Android!')">
						</div>
			
			</div>
			
				<!-- footer -->
				<div class="w3agile footer"> 
		
					
					<div class="footer-text">
						<p>
								Copyright © 2016 OutGo Payment Solutions Pvt. Ltd &amp; Developed by &nbsp; <a
									href="https://www.outgo.co/" target="_blank">www.outgo.co</a>
									|| <a href="https://ssl.comodo.com/comodo-ssl-certificate.php?track=8172" target="_blank"><img style="width: 65px;height: 22px;" alt="ssl" src="<%=request.getContextPath()%>/assets/img/comodo_secure_seal_76x26_transp.png"> </a>
							</p>
					</div>
				</div> 
			</div>
		</div>
	
	<!-- menu-js -->
	<script src="<%=request.getContextPath()%>/assets/appAssets/js/classie.js"></script>
	<script src="<%=request.getContextPath()%>/assets/appAssets/js/main.js"></script>
	<!-- //menu-js -->
	<!-- nice scroll-js -->
	<script src="<%=request.getContextPath()%>/assets/appAssets/js/jquery.nicescroll.min.js"></script> 
	<script>
		$(document).ready(function() {
	  
			var nice = $("html").niceScroll();  // The document page (body)
		
			$("#div1").html($("#div1").html()+' '+nice.version);
		
			$("#boxscroll").niceScroll({cursorborder:"",cursorcolor:"#00F",boxzoom:true}); // First scrollable DIV
		});
	</script>
	<!-- //nice scroll-js -->
<script type="text/javascript">
	function closeModel(){
		window.top.close();
	}
	
	   history.pushState(null, null, document.URL);
	  window.addEventListener('popstate', function () {
	    history.pushState(null, null, document.URL);
	  }); 
	  function showAndroidToast(toast) {
	        Android.showToast(toast);
	    }
	</script>
	
	

    

</body>
</html>