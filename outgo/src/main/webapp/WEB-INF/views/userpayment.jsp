<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<head>
  <title>deAzzle</title>
  <link rel="icon" href="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png" >
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>
  
  .navbar-inverse {
    background-color: #fff;
    border-color: #3fbfac;
}
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #e4e4e4;
      color: black;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
    .btn1 { 
    background-color: yellow;
   color: black;

}
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" style="height: 80px;">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">
<img src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png" class="w3-round" alt="deAzzle"   height="60">
</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     <!--  <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul> -->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="https://play.google.com/store/apps/details?id=com.deAzzle.deAzzle" style="" class="btn"> <i class="fa fa-android pm-os-icons fa-2x " style="color: green;" aria-hidden="true"></i></a></li>
        <li><a href="https://itunes.apple.com/in/app/deazzle/id1111513266?mt=8" class="btn"> <i class="fa fa-apple pm-os-icons fa-2x " style="color: green;" aria-hidden="true"></i></a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav hidden-xs">
       <!-- <div class="well">
        <p>ADS</p>
        </div>
         <div class="well">
        <p>ADS</p>
        </div> -->
      
    </div>
    <div class="col-sm-7 text-center"> 
      <h1 style="color: #3fbeab" >${seller.businessName} </h1>
      <hr style="color:#3fbeab ">
<form class="form-horizontal" action="<%=request.getContextPath() %>/pay/${keys.merchant_key_url}" method="post">
			<input type="hidden" class="form-control" name="merchant_id" value="${keys.merchant_key}"/>
		   <input type="hidden" class="form-control ref_id" id="ref_id" name="ref_id" value="0"/>
			<input type="hidden" class="form-control" name="access_key"   value="${keys.access_key}" />

   <div class="form-group">
      <label class="control-label col-sm-2" >Service:</label>
      <div class="col-sm-10">
     <select name="merchant_service_id" class="form-control" onchange="getuserId(this)" required="required">
     <option value=""> Select Service </option>
     
     <c:forEach var = "i" items="${list}" >
              <option value="<c:out value = "${i.merchant_service_id}"/>" id="${i.custjson}"> <c:out value = "${i.service_name}"/></option>
 
      </c:forEach>
     </select>
      </div>
    </div>
    
     <div class="form-group"  id="div_userId">
    
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Mobile No:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="mobile" required="required" placeholder="Enter Mobile No" name="customer_mobile" onkeypress="return isNumber(event)"  maxlength="10">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" required>
      </div>
    </div>

   
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="customer_email" required>
      </div>
    </div>
    <div class="form-group" id="amt">
      <label class="control-label col-sm-2" for="pwd"> Amount</label>
      <div class="col-sm-10">          
        <input type="tel" class="form-control" id="amount" required="required" placeholder="Enter Amount" name="transaction_amount" onkeypress="return isNumber(event)">
      </div>
    </div>


    <div class="form-group" id="p"style="display: none;">
      <label class="control-label col-sm-2" for="pwd"> Plan</label>
      <div class="col-sm-10">          
			<input type="text" class="form-control planName" placeholder="Plan Name" required  id="planName"  name="customer_plan_name"
			data-toggle="planName"  data-placement="bottom" title="Please fill out this field" >
      </div>
    </div>
 

 
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: #ffd740">Submit</button>
      </div>
    </div>
  </form>   </div>
    <div class="col-sm-3 sidenav">
     <!--  <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div> -->
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <div class="row">
  <div class="col-sm-3">
  </div>
  <div class="col-sm-6">
   &copy; 2018 deAzzle. All Rights Reserved.
  </div>
  <div class="col-sm-3">
  </div>
  
  </div>
</footer>

</body>

<script type="text/javascript">
function getuserId(sel){
	if(sel.options[sel.selectedIndex].text=='Broadband'){
		var htm='<label class="control-label col-sm-2" id="label_userId">User Id</label>'
      +'<div class="col-sm-10">'
       +' <input type="tel" class="form-control" id="customer_userId" required placeholder="Enter User Id" name="customer_userId" onchange=search(this.value)>'
      +'</div>'
$('#div_userId').html(htm);
      
      
      var s='   <label class="control-label col-sm-2" for="pwd"> Amount</label>'
    	  +' <div class="col-sm-6">          '
		
    	  +'<input type="text" class="form-control amount"required placeholder="Amount" name="transaction_amount" id="amount" '
    	  +'data-toggle="amount"  data-placement="bottom" title="Please fill out this field"  >'
    	  +'</div> <div class="col-sm-4">          '

    	  +'  <a class="btn btn-primary portfolio-link form-control" style="color: black; background-color: yellow;" href="#plansModal"  data-toggle="modal" onclick="plan(\'LIMITED\'),getPlanType()">Browse Plans</a>'	
    	  +'</div>'
    	  $('#amt').html(s)
	}else{
		s='  <label class="control-label col-sm-2" for="pwd"> Amount</label>'
			+'<div class="col-sm-10">          '
			+'<input type="tel" class="form-control" id="amount" required placeholder="Enter Amount" name="transaction_amount" onkeypress="return isNumber(event)">'
			+'</div>'
	}

	
	if(sel.options[sel.selectedIndex].text=='Landline'){
	var	htm='<label class="control-label col-sm-2" id="label_userId">Landline No</label>'
      +'<div class="col-sm-10">'
       +' <input type="tel" class="form-control" required id="customer_userId" placeholder="Enter Landline No" name="customer_userId" onchange=search(this.value)>'
      +'</div>'
$('#div_userId').html(htm);
	}

}

function isNumber(evt) {
  evt = (evt) ? evt : window.event;
  var charCode = (evt.which) ? evt.which : evt.keyCode;
  if (charCode > 31 && (charCode < 48 || charCode > 57)) {
     
      return false;
  }

  return true;
}

function search(userId){
	
	//alert(searchId.length);
	
	 
	  $.ajax({
		  type:"POST",
		 // url:"http://192.168.0.102:8080/webApi/searchUser/test",
		 //url:"http://payapi.outgo.co/searchUser/Hi5NandedCity",
		 url:"<%=request.getContextPath()%>/searchUser/${keys.merchant_key_url}",
		 
		   data:{
			   access_key:'${keys.access_key}',
		 user_key:userId,
		
		},
					
		success:function(data){
			   console.log(data)
			   data=JSON.parse(data);
			  console.log(data.merchant_customer_mobile)
			   if(data!='null'){
			  
					  $('#name').val(data.merchant_customer_name);
					  $('#email').val(data.merchant_customer_email);
					  $('#mobile').val(data.merchant_customer_mobile);
					  $('#address').val(data.merchant_customer_address);
					  $('#amount').val(data.merchant_customer_amount);
					   $('#planName').val(data.merchant_customer_plan);
					   $('#ref_id').val(data.merchant_customer_id);
			   }
			   
			 },
			 error:function(e){
			  alert('error'+e);
			 },error : function(jqXHR, textStatus, errorThrown) { 
  if(jqXHR.status == 502 || errorThrown == 'Not Found') 
  { 
      console.log('There was a 404 error.'); 
  }
}
			 
		 });

	
}











function payNow(plan,payamount){

	$("#planName").val(plan);
	
	
	$('#p').show();
	
	var amt=parseInt(payamount);
		$("#amount").val(amt);
	$('#plansModal').modal('hide');

}	

function plan(type) {

var mId=$('#merchantId').val();
//alert(mId);
$.ajax({
type:"POST",
// url:"http://localhost:8080/outgo/getPlan",
url:"<%=request.getContextPath()%>/getPlan",
data:{
   merchant_key:"${keys.merchant_key}",
   service_code:$('#merchant_service_id').val(),
   type:type
},
success:function(data){
 	  console.log(data);
  var htm="";
  var html="";
  var x='"';		  
 $.each(data, function(i,value) {
	var dt=value.json
dt=dt.replace("\\","-");dt=dt.replace("\\","-");

 obj = JSON.parse(dt);
 console.log(value)
 
	 var des="";
	 des=value.plan_type+"_"+value.plan_speed+"_"+value.plan_limit;
 htm+="<tr> <td>"+ value.subcategory+"</td> <td>"+obj.validity+" Days </td>  <td>"+ value.amount+" </td> <td><input type='button'  onclick='payNow("+ x + value.subcategory + x + ","+value.amount+","+ x + obj.validity + x +")' class='btn btn1 btn-info'  value='Subscribe'> </td> </tr> ";
html+='<tr><td>'+ value.subcategory+'</td>   <td>'+ value.amount+' </td></tr>'

});	
 
$('#tr1').html(htm);

 $('#body1').html(html);
  
  
 },
 error:function(e){
  alert('error'+e);
 }
 
});
}

function getPlanType(){
//alert(mId+"-----"+scode)
$.ajax({
  type:"POST",  
  url:"<%=request.getContextPath()%>/getType",
   data:{
	   merchant_key:"${keys.merchant_key}",
	   service_code:$('#merchant_service_id').val()	    	   
},
   success:function(data){
     	  console.log(data);
	  var htm="";
	  var html="";
	  var x='"';		  
	 $.each(data, function(i,value) {
		 
		 console.log(value.category)


		 htm+="<div class='col-md-4  col-xs-4' style='padding-top: 5px; padding-bottom: 5px;'>" +
		 		"<input class='btn btn-primary myBtnfk btn1' type='button'" +
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


<div id="plansModal" class="modal fade" role="dialog">
  <div class="modal-dialog  modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <div class="row">
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
                                <div class="table-responsive" style="height:400px;">                      
                                   
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
                                             <!--    <th>Description</th> -->
                                                 <th>Plan Price</th>
                                                <th>Pay</th>
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
</html>
