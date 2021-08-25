<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="http://dinus.org/assets/mail/mailtip.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://dinus.org/assets/mail/jquery.mailtip.js"></script>
<style>
body {
    background-color:#f1f1f1;
}

div.center{
    margin-left:400px;
}

</style>
<script>
$(function (){
    var info = $('.info');
    $('#mailtip2').mailtip({
    onselected: function (mail){
    info.text('you choosed email: ' + mail)
    }
    });
});
</script>
<body>
<div class="container">
	<div class="row">
		<!-- <center><h2>Awesome Form Complaints Or Suggestions Via E-mail</h2></center> -->
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="col-md-12 row" style="padding:0px;margin-bottom:10px;">
                            
                            <div class="col-md-2">
                                <img src="http://dinus.org/img/fakultas/FIK/cs/cs.svg">
                                <div style="margin-left:30px;">
                                    <img src="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/Logo-14-2017-12-25-1514195655767.png" width="70px" height="70px" class="img-circle" style="border:3px solid #052C52;">
                                </div>
                            </div>
                            <div class="col-md-10">
                                <hr>
                                <p style="padding-left:55px;font-size:1.3em;"><strong>Sanika Deshpande</strong></p>
                                
                            </div>
                         
                        </div>

                        <form action="" method="post">
                         <input type="text" class="form-control" name="merchant_service_id" value="1"/>
		   <input type="text" class="form-control ref_id"  name="ref_id" value="0"/>
		   <!-- <input type="text" class="form-control" name="type" value="Enquiry"/> -->
                            <table class="table">
                                <tr>
                                    <td>
                                      <input type="tel" class="form-control sendenq-field mobile" name="customer_mobile" id="EnqMobile" placeholder="Mobile No." maxlength="10" data-toggle="EnqMobile" title="Please enter coorrect contact no" onkeypress="return isNumber(event)" onchange=search(this.value) maxlength="10">
        
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                      	<input type="text" class="form-control sendenq-field name" name="custName" id="EnqName" placeholder="Your Name" maxlength="30"
          	data-toggle="EnqName" title="Please fill out this field">
	
                                    </td>
                                </tr>
                                
                                <tr>
                                <td>
                                	<input type="text" class="form-control sendenq-field email" name="customer_email" id="Enqemail" placeholder="Your Email"
          	data-toggle="Enqemail" title="Please enter correct email">
                                
                                </td>
                                
                                </tr>
                                
                                <tr>
                                    <td>
                                        	<textarea rows="3" cols="4" class="form-control address" name="address" id="Enqaddress" placeholder="Address" maxlength="150"
			 data-toggle="enquiryDesc" title="Please fill out this field"></textarea>
                                    </td>
                                </tr>
                                 <tr>
                                    <td>
									    <div class="radio-inline">
									      <label><input type="radio" name="type">Enquiry</label>
									    </div>
									    <div class="radio-inline">
									      <label><input type="radio" name="type">Complaint</label>
									    </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <!-- <button class="btn btn-danger btn-sm" style="width: 100%;"><i class="fa fa-envelope-o" style="padding-right: 5px;"></i> Send</button> -->
                                        	<button type="button" onclick="removeIFrame()" id="enqBtn" class="btn  btn-danger"data-loading-text="<i class='fa fa-spinner fa-spin '></i> Processing">Send Enquiry </button>          
     
                                    </td>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>

            </div>

        </div>
	</div>
	

	
	
<!-- 
<!-- Created By :Amol Delmade
<div class="container">
    <div class="row">
        <center>
            <footer>Dev : Amol Delmade <cite title="Source Title">Indonesia</cite></footer>
            <p style="color:#b1b1b1;">
                <br>
              
              
            </p>
        </center>
    </div>
</div> -->
<script type="text/javascript">

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
		  url:"http://192.168.0.102:8080/outgo/searchUser/test",
		 // url:"http://payapi.outgo.co/searchUser",
		   data:{
			   access_key:12,
		 user_key:userId,
		 service_code:1
		},
					
		success:function(data){
			   console.log(data)
			 // alert(data)
			   data=JSON.parse(data);
			  console.log(data.merchant_customer_mobile)
			   if(data!='null'){
			  
					  $('.name').val(data.merchant_customer_name);
					  $('.email').val(data.merchant_customer_email);
					  $('.mobile').val(data.merchant_customer_mobile);
					  $('.address').val(data.merchant_customer_address);
					  $('.amount').val(data.merchant_customer_amount);
					   $('.planName').val(data.merchant_customer_plan);
					   $('.ref_id').val(data.merchant_customer_id);
			   }
			   
			 },
			 error:function(e){
			  alert('error'+e);
			 }
			 
		 });

	
}
function removeIFrame() {
	 window.close();
  }

</script>
</body>