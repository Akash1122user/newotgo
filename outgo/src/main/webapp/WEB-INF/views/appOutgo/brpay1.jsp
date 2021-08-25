<html>

<head>
<title>Pay Bill </title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
</head>
<style>

body, html {
    height: 100%;
    background-repeat: no-repeat;
    background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));
}

.card-container.card {
    max-width: 500px;
    padding: 40px 40px;
}

.btn {
    font-weight: 700;
    height: 36px;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    cursor: default;
}


.card {
    background-color: #F7F7F7;

    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
   
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
    <!--width: 96px;
    height: 96px;-->
	width: 124px;
    height: 124px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
	margin-top:-80px;
}


.profile-name-card {
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    margin: 10px 0 0;
    min-height: 1em;
}
@media screen and (max-width: 767px) {
  .table-responsive {
    width: 100%;
    margin-bottom: 15px;
    overflow-y: auto  !important;
     -lg-overflow-style: -lg-autohiding-scrollbar !important; 
     
    border: 1px solid #ddd;
   	/* width: 2em !important; */
    /* height:   !important; */
  }
.reauth-email {
    display: block;
    color: #404040;
    line-height: 2;
    margin-bottom: 10px;
    font-size: 14px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin #inputEmail,
.form-signin #inputPassword {
    direction: ltr;
    height: 44px;
    font-size: 16px;
}

.form-signin input[type=email],
.form-signin input[type=password],
.form-signin input[type=text],
.form-signin button {
    width: 100%;
    display: block;
    margin-bottom: 10px;
    z-index: 1;
    position: relative;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin .form-control:focus {
    border-color: rgb(104, 145, 162);
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
  
    background-color: rgb(104, 145, 162);
 
    padding: 0px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
}

.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
    background-color: rgb(12, 97, 33);
}

.forgot-password {
    color: rgb(104, 145, 162);
}

.forgot-password:hover,
.forgot-password:active,
.forgot-password:focus{
    color: rgb(12, 97, 33);
}
</style>
</head>




<body onload="getPlanType()">

 <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" style="background-color: #fff" width="110px"  height="200px" src="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/<%=request.getAttribute("m_logo") %>" />
            <p id="profile-name" class="profile-name-card"></p>
      
	 <!--<form action="https://smartbiztest.outgo.co/pay/ctnlbroadband" id="payBillFrm" method="post">-->
	 <!--<form action="https://www.outgo.co/pay/ctnlbroadband" id="payBillFrm" method="post"> -->
		<!--<form action="http://api.outgo.co/payYourBill" id="payBillFrm" method="post">	-->
		
		<div class="col-md-12">
		<div class="col-md-6"><p><b>Name :</b> <%=request.getAttribute("c_name")%></p></div>
		<div class="col-md-6"><p><b>Operator :</b> <%=request.getAttribute("m_name")%></p></div>
		</div>
		
		
		 <%--  <form action="http://192.168.0.102:8080/outgo/paybillOutgo/<%=request.getAttribute("m_url")%>" id="payBillFrm" method="post"> --%> 
		  <form action="https://www.outgo.co/paybillOutgo/<%=request.getAttribute("m_url")%>" id="payBillFrm" method="post"> 
			<input type="hidden" class="form-control" name="merchant_id" id="c_merchant_id"  value="<%=request.getAttribute("m_Id")%>"/>
		   <input type="hidden" class="form-control" name="merchant_service_id" id="c_service_id" value="<%=request.getAttribute("s_id")%>"/>
		    <input type="hidden" class="form-control ref_id" id="ref_id" name="ref_id" value="<%=request.getAttribute("userId")%>"/>
			<!--<input type="hidden" class="form-control" name="access_key"  value="CTNL60" /> -->
			<input type="hidden" class="form-control" name="validity"  id="addressStreet1" />
			<input type="hidden" class="form-control" name="mode"  id="mode"  value="App"/>
		
		
			<div class="form-group">
			
			<input type="text" class="form-control" placeholder="User Id" name="customer_userId" id="userId" 
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
			<div class="form-group">
			
				<input type="text" class="form-control amount" placeholder="Amount" name="transaction_amount" id="amount" 
			data-toggle="amount"  data-placement="bottom" title="Please fill out this field" style="width:40%;float:left;" >
               <i id="space"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>               	
            <a class="btn btn-primary portfolio-link plan" href="#plansModal"  data-toggle="modal" onclick="plan('LIMITED')">Browse Plans</a>	
			</div>
			
			<div class="form-group">
			
			<input type="text" class="form-control planName" placeholder="Plan Name"  id="planName"  name="customer_plan_name"
			data-toggle="planName"  data-placement="bottom" title="Please fill out this field" >
			
			                  
            </div>
		
		
				<div class="form-group">
                   
                     
				<input type="submit" id="paymentBtn" class="btn btn-primary" value="Pay Now">
				
				 <a class="btn btn-primary portfolio-link" onclick="closeModel()" >close</a>
				</div>
				</form>
			</div>
  </div><!-- /card-container -->
   
		

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
	
	$( document ).ready(function() {
    // DOM ready

    // Test data
    /*
     * To test the script you should discomment the function
     * testLocalStorageData and refresh the page. The function
     * will load some test data and the loadProfile
     * will do the changes in the UI
     */
    // testLocalStorageData();
    // Load profile if it exits
    loadProfile();
});

/**
 * Function that gets the data of the profile in case
 * thar it has already saved in localstorage. Only the
 * UI will be update in case that all data is available
 *
 * A not existing key in localstorage return null
 *
 */
function getLocalProfile(callback){
    var profileImgSrc      = localStorage.getItem("PROFILE_IMG_SRC");
    var profileName        = localStorage.getItem("PROFILE_NAME");
    var profileReAuthEmail = localStorage.getItem("PROFILE_REAUTH_EMAIL");

    if(profileName !== null
            && profileReAuthEmail !== null
            && profileImgSrc !== null) {
        callback(profileImgSrc, profileName, profileReAuthEmail);
    }
}

/**
 * Main function that load the profile if exists
 * in localstorage
 */
function loadProfile() {
    if(!supportsHTML5Storage()) { return false; }
    // we have to provide to the callback the basic
    // information to set the profile
    getLocalProfile(function(profileImgSrc, profileName, profileReAuthEmail) {
        //changes in the UI
        $("#profile-img").attr("src",profileImgSrc);
        $("#profile-name").html(profileName);
        $("#reauth-email").html(profileReAuthEmail);
        $("#inputEmail").hide();
        $("#remember").hide();
    });
}

/**
 * function that checks if the browser supports HTML5
 * local storage
 *
 * @returns {boolean}
 */
function supportsHTML5Storage() {
    try {
        return 'localStorage' in window && window['localStorage'] !== null;
    } catch (e) {
        return false;
    }
}

/**
 * Test data. This data will be safe by the web app
 * in the first successful login of a auth user.
 * To Test the scripts, delete the localstorage data
 * and comment this call.
 *
 * @returns {boolean}
 */
function testLocalStorageData() {
    if(!supportsHTML5Storage()) { return false; }
    localStorage.setItem("PROFILE_IMG_SRC", "" );
    localStorage.setItem("PROFILE_NAME", "xyz");
    localStorage.setItem("PROFILE_REAUTH_EMAIL", "test@gmail.com");
}


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
		 htm+="<tr> <td>"+ value.subcategory+"</td> <td>"+obj.validity+" </td> <td><input type='button'  onclick='payNow("+ x + value.subcategory + x + ","+value.amount+","+ x + obj.validity + x +")' class='btn btn-info'  value='"+value.amount+"'> </td> </tr> ";
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
			  if(data.length === 0){				
				  $(".plan").css("display","none");
				  $("#amount").css("width","100%");	
				  $("#amount").css("margin-bottom","12px");	
				  $("#space").css("display","none");
				  $("#planName").attr("placeholder","Remark");
				  $("#userId").attr("placeholder","SubscriberId/LandlineNo/IntercomNo");
				 
			  }
			 $.each(data, function(i,value) {
				 
				 console.log(value.category)
				
					
				 htm+="<div class='col-md-4  col-xs-4' style='padding-top: 5px; padding-bottom: 5px;'>" +
				 		"<input class='btn btn-primary myBtnfk' type='button'" +
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
	
	


  
	<script type="text/javascript">
	function closeModel(){
		window.top.close();
	}
	
	
	</script>
	
	
</body>
</html>




   