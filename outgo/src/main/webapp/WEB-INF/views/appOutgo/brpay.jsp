
<!DOCTYPE html>
<html>
<head>
<title>Pay Bill</title> 
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
<body class="bg" onload="getPlanType()">
	
		<div class="content-wrap">
			<div class="header"> 
				<div class="menu-icon">   
					<button class="menu-button" onclick="showAndroidToast('Hello Android!')">O</button>
				</div>
				<div class="logo">
					<h2><img alt="" width="40px" height="36px" src="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png"> </h2>
				</div>
				<!--  <div class="login">
					<a href="#small-dialog" class="sign-in popup-top-anim"><span class="glyphicon glyphicon-user"></span></a> 
					
				</div>  -->
				<div class="clearfix"> </div>
			</div>
			<div class="content">
			<div class="container" style="padding-top: 30px;padding-bottom: 60px">
			<div class="contact-form"> 
			<h3 class="w3ls-title">
			<%
			try{
			String logo=request.getAttribute("m_logo").toString(); 
			if(logo.equals("outgo.png")){
				 %> 
				 <img id="profile-img" class="profile-img-card" style="background-color: #fff" width="100px"  height="60px" src="https://www.outgo.co/assets/outgoAssets/images/outgo.png" />
				 <% 	
			}else{
				 %> 
				 <img id="profile-img" class="profile-img-card" style="background-color: #fff" width="100px"  height="70px" src="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/<%=request.getAttribute("m_logo") %>" />
				 <% 	
			}
			}catch(NullPointerException e){
			 %> 
		 		<img id="profile-img" class="profile-img-card" style="background-color: #fff" width="100px"  height="60px" src="https://www.outgo.co/assets/outgoAssets/images/outgo.png" />
		 	<% 	
			}			
			%>
			 
			</h3>
			<br>
				<h3 class="w3ls-title" style="color: #88c540"><b><%=request.getAttribute("m_name")%></b> </h3>
		<br>
						
						
		<%-- <form action="http://192.168.0.101:8080/outgo/paybillOutgo/<%=request.getAttribute("m_url")%>" id="payBillFrm" method="post"> --%>   
		    <form action="https://www.outgo.co/paybillOutgo/<%=request.getAttribute("m_url")%>"  id="payBillFrm" method="post">   
			<input type="hidden" class="form-control" name="merchant_id" id="c_merchant_id"  value="<%=request.getAttribute("m_Id")%>"/>
		   <input type="hidden" class="form-control" name="merchant_service_id" id="c_service_id" value="<%=request.getAttribute("s_id")%>"/>
		    <input type="hidden" class="form-control ref_id" id="ref_id" name="ref_id" value="<%=request.getAttribute("userId")%>"/>
			<!--<input type="hidden" class="form-control" name="access_key"  value="CTNL60" /> -->
			<input type="hidden" class="form-control" name="validity"  id="addressStreet1" />
			<input type="hidden" class="form-control" name="mode"  id="mode"  value="App"/>
		<input type="hidden" class="form-control"   id="serviceToPay"  value="<%=request.getAttribute("m_serviceToPay") %>"/>
		<!-- <div class=""></div> -->
			<div class="styled-input">
			
			<input type="text" style="color: #222;" class="form-control" placeholder="User Id" name="customer_userId" id="userId" 
			data-toggle="userId"  data-placement="bottom" title="Please fill out this field" >
                  
            </div>
           
			
			<div class="form-group">
			
			<input type="hidden" class="form-control name" placeholder="Name" name="name" id="name" 
			data-toggle="name"  data-placement="bottom" title="Please fill out this field"  value="<%=request.getAttribute("c_name")%>" >
                  
            </div>
		
			<div class="form-group">
			
			<input type="hidden" class="form-control email" placeholder="Email" name="customer_email" id="email" 
			data-toggle="email"  data-placement="bottom" title="Please fill out this field" value="<%=request.getAttribute("c_email")%>">
                  
            </div>
			
			<div class="form-group">
			
			<input type="hidden" class="form-control mobile" placeholder="Mobile" name="customer_mobile" id="mobile" 
			data-toggle="mobile" value="<%=request.getAttribute("c_mobile")%>"  data-placement="bottom" title="Please fill out this field" onkeypress="return isNumber(event)"  maxlength="10">
                  
            </div>
			<div class="form-group">
			
			<input type="hidden" class="form-control address" name="address" placeholder="Address" id="address" 
			data-toggle="email"  data-placement="bottom" title="Please fill out this field" value="N/A">
                  
            </div>
			<!-- <div class="form-group">
			
				<input type="text" class="form-control amount" placeholder="Amount" name="transaction_amount" id="amount" 
			data-toggle="amount"  data-placement="bottom" title="Please fill out this field" style="width:40%;float:left;" >
               <i id="space"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>               	
            <a class="btn btn-primary portfolio-link plan" href="#plansModal"  data-toggle="modal" onclick="plan('LIMITED')">Browse Plans</a>	
			</div> -->
			
			<div class="form-group">
			
				<input type="text" class="form-control amount" placeholder="Amount" name="transaction_amount" id="amount" 
			data-toggle="amount"  data-placement="bottom" title="Please fill out this field" style="width:65%;float:left;margin-bottom: 0px;color: #222;" >
               <!-- <i id="space"> </i>     --> 
               <%
               try{
               String service=request.getAttribute("m_serviceToPay").toString();
               
               if(service.equals("Broadband")){
            	   %> 
            	    <a  style="background-color: #0091ea" class="btn btn-primary portfolio-link plan" href="#plansModal"  data-toggle="modal"
             onclick="getPlan('FUP'); getPlanType()">Browse Plans</a>	
            	   <%
               } else{
            	   %>
            	   
           			<script type="text/javascript">
            	  	 $(".plan").css("display","none");
    				  $("#amount").css("width","100%");	
    				  $("#amount").css("margin-bottom","12px");	
    				  $("#space").css("display","none");
    				  //$("#planName").attr("placeholder","Remark");
    				  $("#userId").attr("placeholder","SubscriberId/LandlineNo/IntercomNo");
    				  </script>
            	   <%
               }
               }catch(NullPointerException e){
            	   %>
            	    <a  style="background-color: #0091ea" class="btn btn-primary portfolio-link plan" href="#plansModal"  data-toggle="modal"
             onclick="getPlan('FUP'); getPlanType()">Browse Plans</a>	
            	   <% 
               }
               %> 
			</div>
			
			<div class="form-group">
			
			<input type="text" style="color: #222;" class="form-control planName" placeholder="Plan Name"  id="planName"  name="customer_plan_name"
			data-toggle="planName"  data-placement="bottom" title="Please fill out this field" >
			
			                  
            </div>
		     	
		
				<div class="form-group">
                   
                  <div class="col-md-6 col-xs-6">   
				<input type="button" id="paymentBtn" style="background-color: #0091ea" class="btn btn-primary btn-block" onclick="payBtnNow()" value="Pay Now">
				</div>
				<div class="col-md-6 col-xs-6" >
				 <input type="button" class="btn btn-primary btn-block" style="background-color: #0091ea" onclick="showAndroidToast('Hello Android!')" value="Back">
				 </div>
				</div>
				</form>
						
						
					</div>
			
			</div>
			
				<!-- footer -->
				<div class="w3agile footer"> 
		
					
					<div class="footer-text">
						<p>
								Copyright © 2016 OutGo Payment Solutions Pvt. Ltd &amp; Developed by &nbsp; <a
									href="https://www.outgo.co/" target="_blank">www.outgo.co</a>
									|| <a href="https://ssl.comodo.com/comodo-ssl-certificate.php?track=8172" target="_blank"><img style="width: 65px;height: 22px;"  src="<%=request.getContextPath()%>/assets/img/comodo_secure_seal_76x26_transp.png"> </a>
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
			var service=$("#serviceToPay").val();
			if(service!="Broadband"){
				$("#planName").attr("placeholder","Remark");
			}
		});
	</script>
	<!-- //nice scroll-js -->
	<script type="text/javascript">
	function closeModel(){
		window.top.close();
	}
	
	function showAndroidToast(toast) {
        Android.showToast(toast);
    }
	</script>
	
    <script src="<%=request.getContextPath()%>/assets/appAssets/js/bootstrap.js"></script>
    <script type="text/javascript">
    /* geting plan  */
    function plan(type) {	
    	var id=$("#c_merchant_id").val();
    	var sid=$("#c_service_id").val();
    	
    	
      $.ajax({
          type:"POST",
           url:"https://www.outgo.co/getPlan",
           data:{
        	   merchant_key:id,
        	   service_code:sid,
        	   type:type
        },
           success:function(data){
             	  console.log(data);
    		  var htm="";
    		  var html="";
    		  var x='"';		  
    		 $.each(data, function(i,value) {
    		 obj = JSON.parse(value.json);
    		 //alert(obj.validity)
    		 
    			 var des="";
    			 //des=value.plan_type+"_"+value.plan_speed+"_"+value.plan_limit; // <td>"+ value.amount+" </td> 
    		 htm+="<tr> <td>"+ value.subcategory+"</td> <td>"+obj.validity+" </td> <td><input type='button'  onclick='payNow("+ x + value.subcategory + x + ","+value.amount+","+ x + obj.validity + x +")' class='btn btn-info' style='background-color:#0091ea'  value='"+value.amount+"'> </td> </tr> ";
    	 });	
    		 
    		$('#tr1').html(htm);
    		
    		 
    		  
    		  
             },
             error:function(e){
              alert('error'+e);
             }
             
         });
      }
      
    function payNow(plan,payamount,validity){
    			//alert(plan+"----"+amount+"-----"+validity);
    			$("#planName").val(plan);
    			//$("#planName").val(plan);
    			$("#amount").val(payamount);
    			var a=$("#amount").val();
    			//=======================
    			$('#addressStreet1').val(validity);
    			$('#plansModal').modal('hide');
    		

    }
    function getPlanType(){		
    	
        	var id=$("#c_merchant_id").val();
    	var sid=$("#c_service_id").val();
    	
    	 $.ajax({
    	      type:"POST",
    		   url:"https://www.outgo.co/getType",
    	       data:{
    	    	  	merchant_key:id,
        	   		service_code:sid,    	   
    	    },
    	       success:function(data,textStatus, xhr){
    	         	  console.log(data);
    	         	 
    			  var htm="";
    			  var html="";
    			  var x='"';
    			  
    			 $.each(data, function(i,value) {
    				 
    				 console.log(value.category)
    				
    					
    				 htm+="<div class='col-md-4  col-xs-4' style='padding-top: 5px; padding-bottom: 5px;'>" +
    				 		"<input class='btn btn-primary myBtnfk' style='background-color:#0091ea' type='button'" +
    				 		"onclick='plan("+ x +value.category+ x +")' value='"+value.category+"'>	</div>";
    				 if(i==0){
    					 
    					 plan(value.category);
    				 }
    				
    				 
    			 });	
    				 
    			 $('#planT').html(htm);
    				
    			
    				  
    		         },
    		         error:function(e){
    		          alert('error'+e);
    		         }
    		         
    		     });
    			 }
    			 
    function payBtnNow(){
    	
    	 var userId=$('#userId').val();
    	 var amount=$('#amount').val();
 		
 		var planName=$('#planName').val();
 		var flag=true;
 		
 		if(!userId){
 			$('[data-toggle="userId"]').tooltip(); 
 			$('#userId').focus();
 			flag=false;
 		}else if(!amount){
 			$('[data-toggle="amount"]').tooltip(); 
 			$('#amount').focus();
 			flag=false;
 		}
 		
 		else if(!planName){
 			$('[data-toggle="planName"]').tooltip(); 
 			$('#planName').focus();
 			flag=false;
 		}
 		if(flag){
 			$('#payBillFrm').submit();
 		}
    }
    			 
      
    
    </script>
    
    <!-- Plans Modal -->
	<div id="plansModal" class="modal fade" role="dialog">
  <div class="modal-dialog  modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <div class="row" style="margin-top: 18px;">
        <div class="col-md-4"><h4 class="modal-title" id="modalTitle"></h4></div>
        	<div class="col-md-2">
        		<!-- <h5><strong>Plan Type: </strong></h5> -->
        		</div>
        		<div class="col-md-6" id="planT">
        		<!-- <input  type="button" id="selectPlan"  value="UNLIMITED" class="btn btn-primary" onclick="browsPlans('UNLIMITED')" />
        			<input  type="button" value="LIMITED"   class="btn btn-primary" onclick="browsPlans('LIMITED')" />
        			
        			<input  type="button" value="Fair Usage Policy"     class="btn btn-primary" onclick="browsPlans('FUP')" />
        			 -->
        			 
        	</div>
        </div>
      </div>
      <div class="modal-body">
        
        
        <div class="row">
        	<div class="content-wrapper col-md-12 col-sm-12">  
                            <div class="page-row">
                                <!-- <h3 class="has-divider text-highlight"><strong>Unlimited Plans</strong></h3> -->
                                <div class="table-responsive t" style="height:400px; overflow-y: auto;">                      
                                   
										<!-- <label>1 Mbps Plans</label>		  -->
                                   <!--   <table style="color: #000" class="table table-boxed" id="myTable" >
                                    	
                                        <thead>
                                         <tr><th colspan="4"><b><font >Paln Show Only karve nagar</font></b></th></tr>
                                            <tr>
                                                <th>Plan</th>
                                                <th>Validity(Days)</th>
                                                <th>Description</th>
                                                 <th>Plan Price</th>
                                                
                                            </tr>
                                        </thead>
                                        
                                        <tbody id="planData">
                                        </tbody> 
                                    </table> -->
                                     <table class="table table-boxed" id="myTable" >
                                    	
                                        <thead>
                                            <tr>
                                                <th>Plan</th>
                                                <th>Validity(Days)</th>
                                              
                                                 <th>Plan Price</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody id="tr1">
                                        </tbody> 
                                    </table>
                                </div><!--//table-responsive-->
                                
                               
                                
                            </div><!--//page-row-->                                                                    
                        </div><!--//content-wrapper-->
        </div>
        
      </div>
     
    </div>

  </div>
</div>
	<!-- /Plans Modal -->
</body>
</html>