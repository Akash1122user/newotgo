<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><head>
<title>Verified By DeAzzle Authentication...</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
.payerForm
{
    COLOR: navy;
    FONT-FAMILY: Verdana;
    FONT-WEIGHT: bold;
    FONT-SIZE: 10pt
}
.errorType
{
    COLOR: red;
    FONT-FAMILY: Verdana;
    FONT-WEIGHT: bold;
    FONT-SIZE: 10pt
}
.merchantName
{
    COLOR: #808000;
    FONT-FAMILY: Verdana;
    FONT-WEIGHT: bold;
    FONT-SIZE: 10pt
}
.important
{
    COLOR: #FF0000;
    FONT-FAMILY: Verdana;
    FONT-WEIGHT: bold;
    FONT-SIZE: 10pt
}
.smallNotes
{
    COLOR: navy;
    FONT-FAMILY: Verdana;
    FONT-SIZE: 8pt
}
.footNotes
{
    COLOR: #808080;
    FONT-FAMILY: Verdana;
    FONT-SIZE: 5pt;
	FONT-WEIGHT: normal;
}
.normal
{
    COLOR: navy;
    FONT-FAMILY: Verdana;
    FONT-WEIGHT: normal;
   /*  FONT-SIZE: 8pt */
}
.clean-error{
		border:solid 1px #CC0000; 
		background:#DADADA;
		color:#CC0000;
		font-weight:bold;
		padding:4px;
		text-align:center;
}
.justify1{

	 text-align: justify;
}
a:visited
{
	color:blue;
}
a:active
{
	color:green;
}
</style>

<style> 
input[type=password] {
    width: 60%;
    padding: 10px 15px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
}

input[type=text]:focus {
    border: 3px solid #555;
}
</style>

<script language="JAVASCRIPT">
	var secretArray = new Array(1);
	
	 var url='<%=request.getContextPath()%>';
	
	var noSubmit = 0;
	var intRegex = /^\d+$/;
	var floatRegex = /^((\d+(\.\d *)?)|((\d*\.)?\d+))$/;
	
	function ValidateForm(){
		if(document.frmPayerAuth.otpValue.value.length==0){
			swal('OTP cannot be blank.');
			return false;
		}else if(document.frmPayerAuth.otpValue.value.length!=4){
			swal('Invalid OTP.');
			return false;
		}else if(!intRegex.test(document.frmPayerAuth.otpValue.value) ) {
			swal('Invalid OTP.');
			return false;
			}else{
			
			var request = $.ajax({
			  url: url+"/deazzle-otp-validation",
			  method: "POST",
			  data: $('#frmPayerAuth').serialize()
			  /* dataType: "html" */
			});
			 
			request.done(function( msg ) {
			  if( msg=='success'){
					document.getElementById("cmd123456").style.visibility="hidden";
					document.getElementById("showtext").style.visibility="visible";		 
					document.frmPayerAuth.action = url+"/pay-easebuzz";
					document.frmPayerAuth.submit();

			  }else if( msg=='success2'){
					document.getElementById("cmd123456").style.visibility="hidden";
					document.getElementById("showtext").style.visibility="visible";		 
					document.frmPayerAuth.action = url+"/pay-offline";
					document.frmPayerAuth.submit();

			  }else{
					swal('Invalid OTP.');
			  }

			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		}
	}
	function cancelAction(){
/* 		var choice = confirm("Are you sure you want to Cancel? Your transaction may get declined. Click \"Ok\" to continue or \"Cancel\" to return to the authentication page.");
		if (choice){
			document.getElementById("cmd123456").style.visibility="hidden";
			document.getElementById("showtext").style.visibility="visible";		 
			document.frmPayerAuth.action = "https://deazzle.in/";
			document.frmPayerAuth.submit();
		}else{
			
		}
 */
 
	var choice = "Are you sure you want to Cancel? Your transaction may get declined. Click \"Ok\" to continue or \"Cancel\" to return to the authentication page.";
	
		swal({
			  title: "",
			  text: choice,
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete)=> {
			  if (willDelete) {
				  
					document.getElementById("cmd123456").style.visibility="hidden";
					document.getElementById("showtext").style.visibility="visible";		 
					document.frmPayerAuth.action = "https://deazzle.in/";
					document.frmPayerAuth.submit();

				  
/* 			    swal("Poof! Your imaginary file has been deleted!", {
			      icon: "success",
			    });
 */			  } else {
	/* 		    swal("Your imaginary file is safe!");
	 */		  }
			});
	
	}	
	
	var time=120;
var mm=1;
var ss=59;
	
	setInterval(function(){ 
		var d = new Date(); // for now
		var h=d.getHours(); // => 9
		var m=d.getMinutes(); // =>  30
		var s=d.getSeconds(); // => 51
		time=time-1;
		
		

		//alert(ss.toString().length)
		
		var pp=ss;
		
		
		if(ss.toString().length!=2)
			pp='0'+ss;
		
		$('#resend').val("Resend OTP 0"+mm+":"+pp)


		 if(ss==0 && mm==0){
			$('#resend').removeAttr("disabled");
			$('#resend').val("Resend OTP ")

			
		} else{
			ss=ss-1;
		
		if(mm==1 && ss==0){
			mm=0;
			ss=59;
		}
		}

	}, 1000);
	
	function forgot_password() 
	{ 
		
		var request = $.ajax({
			  url: url+"/deazzle-resend-otp",
			  method: "POST",
			  data: {mobile:'${mobile}'}
			  /* dataType: "html" */
			});
			 
			request.done(function( msg ) {
			  if( msg=='success'){
					mm=1;
					ss=59;
					swal('SMS sent successfully');

			  }
			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});

		
		

		// swal(h+":"+m+":"+s+ " Wait "+m+":"+s);
  		//window.location="https://deazzle.in/"
 	}
	
	function PostNotAuthenticated(){
		document.frmPayerAuth.action = "https://deazzle.in/";
			document.frmPayerAuth.submit();
	}

	function PostNotAuthenticatedTimedOut(){
		document.frmPayerAuth.action = "https://deazzle.in/";
			document.frmPayerAuth.submit();
	}


	
	
 

</script>
</head>
<body>
<form name="frmPayerAuth" id="frmPayerAuth" method="POST"  >

<table   align="center" style="margin-top: 20px;   border: 10px solid black; border-color: #43c0a5;"><tbody><tr>  <td style="padding: 20px;">

<table border="0" cellspacing="0" cellpadding="0" width="450" align="center" class="payerForm" height="400">
  <tbody>
  <tr> <td colspan="2" align="right" id="s"></td></tr>
  <tr> 
    <td colspan="2" align="center"><img width=130 alt="Verify deAzzle" src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png" border="0"></td>
	
<!--     <td align="right"><img id="deAzzlelogo" class="" alt="deAzzle Logo" src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png" border="0" height=80></td>
 -->  </tr>  
  
  <tr>
	<td align="center"><b></b>&nbsp;
	</td>
  </tr>
  <tr> 
    <td colspan="2">&nbsp;&nbsp;<font face="Verdana" size="2" color="#CC3333"><i>Enter OTP</i></font>
	<br>
	<table border="0" cellspacing="0" cellpadding="0" width="97%" align="center">
	<tbody><tr>
		<td class="normal justify1">
		<font face="Verdana" size="3" color="black">Please enter your Verified by<b> deAzzle</b><sup>®</sup> OTP in the field below to confirm your identity for this purchase. </font>
		</td></tr></tbody></table>
		</td>
	 </tr>
	
    <tr class=""> 
    <td align="right"><font face="Verdana" size="2">Business Name:</font> </td><td> <font face="Verdana" size="2">${businessName}</font></td>
  </tr> 

<!--    <tr class="merchantName"> 
    <td align="right"><font face="Verdana" size="2">Date: </font></td><td><font face="Verdana" size="2">Aug 28, 2018</font></td>
  </tr>
  <tr> 
    <td align="right"><font face="Verdana" size="2">Total Charge: </font></td><td> <font face="Verdana" size="2"><span title="INR 3.00" "="">Rs 3.00</span></font></td>
  </tr>  
 -->  <tr> 
    <td align="right"><font face="Verdana" size="2">Mobile: </font></td><td> <font face="Verdana" size="2">${mobile}</font></td>
  </tr>  
  
  
  <tr> 
    <td align="right"><font face="Verdana" size="2">Name: </font></td><td>

<input type="HIDDEN" name="txtLogin" value="193814">
	<font face="Verdana" size="2">${name}</font>

<br>
</td>
  </tr>
  <tr> 
    <td align="right"><font face="Verdana" size="2">OTP:</font> </td><td><input type="password" autofocus name="txtOtp" id="otpValue" maxlength="15" size="15" value="" autocomplete="off"></td>
  </tr>
  
  <tr> 
    <td colspan="2"></td>
  </tr>
  <tr> 
    <td align="center" colspan="2"><div id="cmd123456" style="visibility:visible"><input type="button" onclick=" ValidateForm()" name="cmdSubmit1" id="cmdSubmit1" value="Submit" title="Click here to submit" style="FONT-WEIGHT: bold; COLOR: #ffefd5; BACKGROUND-COLOR: #009688; height: 30px;">&nbsp;&nbsp;&nbsp;
	<input type="button" name="cmdSubmit" id="cmdSubmit" value="Cancel" title="Click here to cancel" style="FONT-WEIGHT: bold; COLOR: #ffefd5; BACKGROUND-COLOR: #009688; height: 30px;" onclick="javascript:cancelAction()">&nbsp; &nbsp;&nbsp;&nbsp;
	<input type="button" name="resend" id=resend value="Resend " disabled="disabled" title="Click here to Send OTP" style="FONT-WEIGHT: bold; COLOR: #000; BACKGROUND-COLOR: #fff; height: 30px;" onclick="javascript:forgot_password()">
</div>	
	<div id="showtext" style="visibility:hidden" class="footNotes"><font face="Verdana" size="2">Please wait...</font></div><span class="normal">
	
  </span>
  
  </td>
  </tr>
  <tr> 
		<td colspan="2" align="center" size="3" class="normal justify1" id="mobileBlock"><font face="Verdana" color="#000000"><br>OTP has been sent to your registered&nbsp; ${xno} and should reach you in few seconds.</font>
		</td>
	</tr>
	<tr>
	 <td colspan="2"></td>
	</tr>
		<tr>
	 <td colspan="2"></td>
	</tr>
	 <tr>	
		<td colspan="2" size="2" align="center" class="normal justify1"><font face="Verdana" color="#000000">If OTP is not received within 2 minutes, request you to please <a href="#" id="otpLink" onclick="return forgot_password()"> CLICK HERE</a> to resend OTP</font>
		</td>
	</tr>
   <tr> 
    <td colspan="2" align="center" class="footNotes">
	<br>
	<font face="Verdana" size="2">This page will automatically timeout after 5 minutes.</font>
	</td>
  </tr>
     
		    <tr> 
						 <td colspan="2" align="center">
							<!--
<span style='FONT-SIZE: 11px; COLOR: #808080; FONT-FAMILY: Tahoma, Helvetica, Arial; FONT-WEIGHT: normal'>Powered by </span>
<span style='font-size:9.0pt;font-family:"Georgia","serif";color:#FC7404'>en</span><span style='font-size:9.0pt;font-family:"Georgia","serif";color:#0070C0'>Stage</span>
-->

            <table>
				
				 	<tbody><tr><td><font color="#000000" size="1" face="Verdana">Powered by</font> </td>
				 
					 </tr></tbody></table><table>
					 
					  <tbody><tr><td><a><font><b><img src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png" width="25" height="25"></b></font></a></td>					
				
					 </tr></tbody></table></td></tr></tbody>
					
				
				</tbody></table>
                
			
</td>
</tr>
</tbody>
</table>
</form>	 


<script language="JAVASCRIPT">
var limit = 0;
var stopTimer = 0;
function doTimer(){
	if(stopTimer!=0) {
		return;
	}
	if (limit < 10){
		limit++;
		//alert("setTimeout");
		the_timeout = setTimeout("doTimer();", 30000);			
	} else {
		//PostNotAuthenticated();	
		PostNotAuthenticatedTimedOut();
	}
}
doTimer();

function notMyMobile(){	
	var bConfirm = confirm("Click OK if this is not your Mobile Number, else click Cancel");
	if(bConfirm){
		
		window.location = "https://deazzle.in"		
	}
	
}
</script>
	



</body></html>
     --%>
     
     
     
     
     
     
     
     
     
<html><head>
<title>Verified By DeAzzle Authentication...</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
.be-detail-header { border-bottom: 1px solid #edeff2; margin-bottom: 50px; }
</style>


<script language="JAVASCRIPT">
	var secretArray = new Array(1);
	
	 var url='<%=request.getContextPath()%>';
	
	var noSubmit = 0;
	var intRegex = /^\d+$/;
	var floatRegex = /^((\d+(\.\d *)?)|((\d*\.)?\d+))$/;
	
	function ValidateForm(){
		$("#submitbtn1").hide();
		$("#submitbtn2").show();		 
		
		if(document.frmPayerAuth.otpValue.value.length==0){
			swal('OTP cannot be blank.');
			$("#submitbtn1").show();
			$("#submitbtn2").hide();		 

			return false;
		}else if(document.frmPayerAuth.otpValue.value.length!=4){
			swal('Invalid OTP.');
			$("#submitbtn1").show();
			$("#submitbtn2").hide();		 
			return false;
		}else if(!intRegex.test(document.frmPayerAuth.otpValue.value) ) {
			$("#submitbtn1").show();
			$("#submitbtn2").hide();		 
			swal('Invalid OTP.');
			return false;
			}else{
			
			var request = $.ajax({
			  url: url+"/deazzle-otp-validation",
			  method: "POST",
			  data: $('#frmPayerAuth').serialize()
			  /* dataType: "html" */
			});
			 
			request.done(function( msg ) {
			  if( msg=='success'){
/* 					document.getElementById("cmd123456").style.visibility="hidden";
					document.getElementById("showtext").style.visibility="visible";		 
 */					document.frmPayerAuth.action = url+"/pay-easebuzz";
					document.frmPayerAuth.submit();

			  }else if( msg=='success2'){
/* 					document.getElementById("cmd123456").style.visibility="hidden";
					document.getElementById("showtext").style.visibility="visible";		 
 */					document.frmPayerAuth.action = url+"/pay-offline";
					document.frmPayerAuth.submit();

			  }else{
					$("#submitbtn1").show();
					$("#submitbtn2").hide();		 

				  swal('Invalid OTP.');
			  }

			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		}
	}
	function cancelAction(){
/* 		var choice = confirm("Are you sure you want to Cancel? Your transaction may get declined. Click \"Ok\" to continue or \"Cancel\" to return to the authentication page.");
		if (choice){
			document.getElementById("cmd123456").style.visibility="hidden";
			document.getElementById("showtext").style.visibility="visible";		 
			document.frmPayerAuth.action = "https://deazzle.in/";
			document.frmPayerAuth.submit();
		}else{
			
		}
 */
 
	var choice = "Are you sure you want to Cancel? Your transaction may get declined. Click \"Ok\" to continue or \"Cancel\" to return to the authentication page.";
	
		swal({
			  title: "",
			  text: choice,
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete)=> {
			  if (willDelete) {
				  
					document.getElementById("cmd123456").style.visibility="hidden";
					document.getElementById("showtext").style.visibility="visible";		 
					document.frmPayerAuth.action = "https://deazzle.in/";
					document.frmPayerAuth.submit();

				  
/* 			    swal("Poof! Your imaginary file has been deleted!", {
			      icon: "success",
			    });
 */			  } else {
	/* 		    swal("Your imaginary file is safe!");
	 */		  }
			});
	
	}	
	
	var time=120;
var mm=1;
var ss=59;
	
	setInterval(function(){ 
		var d = new Date(); // for now
		var h=d.getHours(); // => 9
		var m=d.getMinutes(); // =>  30
		var s=d.getSeconds(); // => 51
		time=time-1;
		
		

		//alert(ss.toString().length)
		
		var pp=ss;
		
		
		if(ss.toString().length!=2)
			pp='0'+ss;
		
		$('#resend').val("Resend OTP 0"+mm+":"+pp)


		 if(ss==0 && mm==0){
			$('#resend').removeAttr("disabled");
			$('#resend').val("Resend OTP ")

			
		} else{
			ss=ss-1;
		
		if(mm==1 && ss==0){
			mm=0;
			ss=59;
		}
		}

	}, 1000);
	
	function forgot_password() 
	{ 
		
		var request = $.ajax({
			  url: url+"/deazzle-resend-otp",
			  method: "POST",
			  data: {mobile:'${mobile}'}
			  /* dataType: "html" */
			});
			 
			request.done(function( msg ) {
			  if( msg=='success'){
					mm=1;
					ss=59;
					swal('SMS sent successfully');

			  }
			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});

		
		

		// swal(h+":"+m+":"+s+ " Wait "+m+":"+s);
  		//window.location="https://deazzle.in/"
 	}
	
	function PostNotAuthenticated(){
		document.frmPayerAuth.action = "https://deazzle.in/";
			document.frmPayerAuth.submit();
	}

	function PostNotAuthenticatedTimedOut(){
		document.frmPayerAuth.action = "https://deazzle.in/";
			document.frmPayerAuth.submit();
	}


	
	
 

</script>

</head>
<body>
<div class="container be-detail-container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <br>
            <img src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png" class="img-responsive" style="width:200px; margin:0 auto;"><br>
            
            <h1 class="text-center">Verify your mobile number</h1><br>
            <p class="lead" style="align:center"></p><p>		<font face="Verdana" size="3" color="black">Please enter your Verified by<b> deAzzle</b><sup>®</sup> OTP in the field below to confirm your identity for this purchase. </font>
  <p></p>
        <br>
       
            <form name="frmPayerAuth" id="frmPayerAuth" method="POST"  >
                <div class="row">                    
                <div class="form-group col-sm-8">
                	 <span style="color:red;"></span>                    <input  type="password" autofocus name="txtOtp" id="otpValue" maxlength="4" size="4" value="" autocomplete="off" style="border: 1px solid #2ebdab;" class="form-control"  placeholder="Enter your OTP number" required="">
                </div>
                <button type="button" onclick=" ValidateForm()" id="submitbtn1" style="background-color: #2ebdab; border: 1px solid #fff;" class="btn btn-primary  pull-right col-sm-3">Verify</button>
                <button type="button"  id="submitbtn2" style="background-color: #3bb15fb3; display:none; border: 1px solid #fff;" class="btn btn-primary  pull-right col-sm-3">Please wait...</button>
                </div>
            </form>
        <br><br>
        
        <p align="center"><font face="Verdana" color="#000000">If OTP is not received within 2 minutes, request you to please <a href="#" id="otpLink" onclick="return forgot_password()"> CLICK HERE</a> to resend OTP</font></p>
      
      <p align="center">	<font face="Verdana" size="2">This page will automatically timeout after 5 minutes.</font>
      </p>
        </div>
    </div>        
</div>

</body>