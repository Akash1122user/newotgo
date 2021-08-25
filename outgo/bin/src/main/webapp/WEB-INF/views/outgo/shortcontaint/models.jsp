<a href="#" class="back-to-top"><i class="fa fa-angle-up"></i></a>
	<!-- <div id="loader">
		<div class="spinner">
			<div class="dot1"></div>
			<div class="dot2"></div>
		</div>
	</div> -->

	<div class="switcher-box" style="padding-left: 15px;padding-right: 15px;background-color: #eee;">
		<a class="open-switcher hidden-xs show-switcher" style="font-family: sans-serif;font-size:medium;background-color: #00afd1; color: #fff;padding-top: 5px"><b>Enquiry</b></a>
		<h4 style="background-color: #00afd1 ">Send Enquiry</h4>
		<!-- <span>12 Predefined Color Skins</span> -->
		
		
		        <div class="row" style="padding-left: 10px;padding-right: 10px;background-color: #eee">
          <div class="col-md-12">
		  
		   <span id="successMsgEq" style="display:none;color:green">Enquiry sent successfully</span>
		  <span id="errorMsgEq" style="display:none;color:red">Enquiry sending error....</span>  
		  
          <form id="enq" action="" method="post">
		  <div class="box-body">
          	<div class="form-group">
          	<div class="inner-addon left-addon">
			<input type="hidden" class="form-control" name="access_key"  value="PrideTelecom65" />
		 
		   <input type="hidden" class="form-control ref_id"  name="ref_id" value="0"/>
		   <input type="hidden" class="form-control" name="type" value="Enquiry"/>

          	<input type="tel" class="form-control sendenq-field mobile" name="customer_mobile" id="EnqMobile" placeholder="Mobile No." maxlength="10" data-toggle="EnqMobile" title="Please enter coorrect contact no" onkeypress="return isNumber(event)" onchange=searchComp(this.value) maxlength="10">
          	</div>
          	</div>
          	
          	</div>
          	<div class="box-body">
          	<div class="form-group">
          	<div class="inner-addon left-addon">
          	
          	<input type="text" class="form-control sendenq-field name" name="custName" id="EnqName" placeholder="Your Name" maxlength="30"
          	data-toggle="EnqName" title="Please fill out this field">
			
          	</div>
          	</div>
          	</div>
        	<div class="box-body">
          	
          	<div class="form-group">
          	<div class="inner-addon left-addon">
          
          	<input type="text" class="form-control sendenq-field" name="customer_email" id="Enqemail" placeholder="Your Email"
          	data-toggle="Enqemail" title="Please enter correct email">
          	</div>
          	</div>
          	
          	</div>
          
          
          	 <!-- <div class="box-body">
          	
          	<div class="form-group">
          	<div class="inner-addon left-addon">
		   <select class="form-control myServiceUpload" id="myServiceUpload" 
                      data-toggle="myServiceUpload"  title="Please select your Service"
                     name="merchant_service_id">
                         
                         
                            </select> 
		  </div>
          	</div>
          	
          	</div> -->
          	
                 <div class="form-group">
			<div class="inner-addon left-addon">
			
			<textarea rows="4" cols="4" class="form-control" name="msg_description" id="EnqDesc" placeholder="Description" maxlength="150"
			 data-toggle="EnqDesc" title="Please fill out this field"></textarea>
			
			</div>
          	</div>  	
          	<div class="form-group">
          	<button type="button" onclick="enquiry()" id="enqBtn" class="btn" style="background-color: #00afd1;color: #fff" data-loading-text="<i class='fa fa-spinner fa-spin '></i> Processing">Send Enquiry </button>          
          	</div>
          	
          	
          	</form>
          	</div>
          </div>
		
	</div>