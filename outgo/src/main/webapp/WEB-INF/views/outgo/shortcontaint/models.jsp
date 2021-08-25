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
		  
          <form id="enq" name="enq" method="post">
		  <div class="box-body">
          	<div class="form-group">
          	<div class="inner-addon left-addon">
          	
			<input type="hidden" class="form-control"  name="merchantId" value="0"/>		 
		   <input type="hidden" class="form-control"  name="ref_id" value="0"/>
		   <input type="hidden" class="form-control"  name="merchant_service_id" value="0"/>
		 
			<input type="text" class="form-control sendenq-field name" name="custName" id="EnqName" placeholder="Your Name" maxlength="30"
          	data-toggle="EnqName" title="Please fill out this field">
          
          	</div>
          	</div>
          	
          	</div>
          	<div class="box-body">
          	<div class="form-group">
          	<div class="inner-addon left-addon">
          	
          
          	
          		<input type="tel" class="form-control sendenq-field mobile" name="customer_mobile" id="EnqMobile" 
          	 placeholder="Mobile No." maxlength="10" data-toggle="EnqMobile" title="Please enter coorrect contact no"
          	  data-ng-keypress="filterValue($event)" maxlength="10" >
			
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
          
          
          	
           	<div class="form-group">
			<div class="inner-addon left-addon">
			
			<textarea rows="4" cols="4" class="form-control" name="msg_description" id="EnqDesc" placeholder="Description" maxlength="150"
			 data-toggle="EnqDesc" title="Please fill out this field"></textarea>
			
			</div>
          	</div>  	
          	<div class="form-group">
          	<button type="button" data-ng-click="enquiry()" id="enqBtn" class="btn" style="background-color: #00afd1;color: #fff" data-loading-text="<i class='fa fa-spinner fa-spin '></i> Processing">Send Enquiry </button>          
          	</div>
          	
          	
          	</form>
          	</div>
          </div>
		
	</div>
	
	
	<!--  modal pay modal -->
<div class="modal fade" id="squarespaceModalPay" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" style="padding-top : 30px">
  <div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header text-center" style="background-color: #00afd1">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			<h3 class="modal-title" id="lineModalLabel1" style="color: #fff">Pay Bill <b class="serviceToPayDisplay"></b></h3>
		</div> 
		 <form  id="payBillFrmBr" method="post">
		<div class="modal-body">
			
            <!-- content goes here -->
			
			<input type="hidden" class="form-control" id="merchant_id_ld01"  name="merchant_id" />
		   <input type="hidden" class="form-control" id="merchant_service_id_ld01" name="merchant_service_id" />
		   <input type="hidden" class="form-control" id="ref_id_ld01" name="ref_id" value="0"/>			
			<input type="hidden" class="form-control" id="validity_ld01" name="validity"   value="0"/>
			<input type="hidden" class="form-control" id="url_ld01"  />
			<input type="hidden" class="form-control" id="access_key_ld01"  />
			<input type="hidden" class="form-control" name="mode"  id="mode"  value="Web"/>
			<div class="form-group">
			
			<input type="text" class="form-control" placeholder="User Id" name="customer_userId" id="userId_ld01" 
			data-toggle="userId_ld01"  data-placement="bottom" title="Please fill out this field" data-ng-model="customer_mobile" data-ng-blur="search('pay')" >
                  
            </div>
           
			
			<div class="form-group">
			
			<input type="text" class="form-control name" placeholder="Name" name="name" id="name_ld01" 
			data-toggle="name_ld01"  data-placement="bottom" title="Please fill out this field" >
                  
            </div>
		
			<div class="form-group">
			
			<input type="text" class="form-control " placeholder="Email" name="customer_email" id="email_ld01" 
			data-toggle="email_ld01"  data-placement="bottom" title="Please fill out this field" >
                  
            </div>
			
			<div class="form-group">
			
			<input type="text" class="form-control mobile" placeholder="Mobile" name="customer_mobile" id="mobile_ld01" 
			data-toggle="mobile_ld01"  data-placement="bottom" title="Please fill out this field" data-ng-keypress="filterValue($event)"  maxlength="10">
                  
            </div>
			<div class="form-group">
			
			<input type="text" class="form-control address" name="address" placeholder="Address" id="address_ld01" 
			data-toggle="address_ld01"  data-placement="bottom" title="Please fill out this field" >
                  
            </div>
			<div class="form-group">
			
				<input type="text" class="form-control amount" placeholder="Amount" name="transaction_amount" id="amount_ld01" 
			data-toggle="amount_ld01"  data-placement="bottom" title="Please fill out this field" style="width:40%;float:left;margin-bottom: 0px" >
               <!-- <i id="space"> </i>     -->           	
            <a class="btn btn-primary portfolio-link plan" style="background-color: #00afd1" href="#plansModal"  data-toggle="modal" data-ng-click="getPlan('FUP'); getPlanType()">Browse Plans</a>	
			</div>
			
			<div class="form-group">
			
			<input type="text" class="form-control planName" placeholder="Plan Name"  id="planName_ld01"  name="customer_plan_name"
			data-toggle="planName_ld01"  data-placement="bottom" title="Please fill out this field" >
			
			                  
            </div>
		

         
      	

		</div>
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
			<div class="btn-group" role="group">
					<!-- <input type="submit" id="pay_ld01" style="" class="btn btn-default btn-hover-green" data-action="save" role="button" value="Pay Now!"> -->
					<!-- <input type="button" data-ng-click="payNow()"  class="btn btn-default" value="Pay Now !"> -->
					<button type="button" data-ng-click="payNow()" style="background-color: #00afd1;color:#fff" class="btn btn-default btn-hover-green" data-action="save" role="button"> Pay Now !</button>
				</div>
			<div class="btn-group" role="group" >
					<button type="button" class="btn btn-default" style="background-color: #d25128;color:#fff"  data-dismiss="modal"  role="button">Close</button>
				</div>
				
				<!-- <div class="btn-group btn-delete hidden" role="group">
					<button type="button" id="close_ld01" class="btn btn-default btn-hover-red" data-dismiss="modal"  role="button">Close</button>
				</div> -->
				
			</div>
		</div>
		</form>
	</div>
  </div>
</div>
	
	
	
	
	<!--  modal complaint -->
<div class="modal fade" id="squarespaceModalComp" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" style="padding-top: 30px">
  <div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header" style="text-align: center; background-color: #00afd1">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			<h3 class="modal-title" id="lineModalLabel2" style="color: #fff">Send Massage !</h3>
		</div>
		<div class="modal-body">
			
            <!-- content goes here -->
			<form id="comp"  method="post">
		  <div class="box-body">
          	<div class="form-group">
          	<div class="inner-addon left-addon">
			<input type="hidden" class="form-control" name="access_key" data-ng-model="access_key_com"  id="access_key_com"  /> <!-- access_key_com,ref_id_com,url_com -->
		 
		   <input type="hidden" class="form-control"  name="ref_id" id="ref_id_com" value="0"/>
		   <input type="hidden" class="form-control" name="type" value="Complaint"/>
  			<input type="hidden" class="form-control" id="url_com"  />
          	<input type="tel" class="form-control sendenq-field mobile" name="customer_mobile" id="CompMobile" placeholder="Mobile No."
          	 maxlength="10" data-toggle="CompMobile" title="Please enter coorrect contact no" data-ng-model="customer_mobile" data-ng-blur="search('msg')" data-ng-keypress="filterValue($event)"   maxlength="10">
          	</div>
          	</div>
          	
          	</div>
          	<div class="box-body">
          	<div class="form-group">
          	<div class="inner-addon left-addon">
          	
          	<input type="text" class="form-control sendenq-field name" name="custName" id="CompName" placeholder="Your Name" maxlength="30"
          	data-toggle="CompName" title="Please fill out this field">
			
          	</div>
          	</div>
          	</div>
        	<div class="box-body">
          	
          	<div class="form-group">
          	<div class="inner-addon left-addon">
          
          	<input type="text" class="form-control sendenq-field" name="customer_email" id="Compemail" placeholder="Your Email"
          	data-toggle="Compemail" title="Please enter correct email">
          	</div>
          	</div>
          	
          	</div>
          
          
          	 <div class="box-body">
          	
          	<div class="form-group">
          	<div class="inner-addon left-addon">
		  
			<input type="hidden" class="form-control" name="merchant_service_id" data-ng-model="Compservice"  id="Compservice" />
							
		  </div>
          	</div>
          	
          	</div>
          	
                 <div class="form-group">
			<div class="inner-addon left-addon">
			
			<textarea rows="4" cols="4" class="form-control" name="msg_description" id="CompDesc" placeholder="Description" maxlength="150"
			 data-toggle="CompDesc" title="Please fill out this field"></textarea>
			
			</div>
          	</div>  	
          	
          	
          	</form>

		</div>
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
			<div class="btn-group" role="group" >
					<button type="button" style="background-color: #00afd1;color:#fff" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" data-ng-click="logcomplain()" role="button">Send Massage </button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" style="background-color: #d25128;color:#fff" data-dismiss="modal"  role="button">Close</button>
				</div>
				<!-- <div class="btn-group btn-delete hidden" role="group">
					<button type="button" id="delImage" class="btn btn-default btn-hover-red" data-dismiss="modal"  role="button">Delete</button>
				</div> -->
				
			</div>
		</div>
	</div>
  </div>
</div>

<div id="squarespaceModalCityAndArea" class="modal fade" role="dialog" style="padding-top : 30px">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header text-center" style="background-color: #00afd1;">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h3 class="modal-title" style="color:#fff">Select City And Area</h3>
      </div>
      <div class="modal-body">
      
      
      				<div class="col-md-12">
							<div class="col-md-4 col-md-offset-2 image-service-box" style="margin-top: 10px;width: 150px;height: 68px;"> 
							<img alt="" class="responsive"
							src="<%=request.getContextPath()%>/assets/outgoAssets/images/outgo.png"  >
							</div>
							
					<div class="col-md-4 vl" style="margin-top: 5px;"> 
					<!-- <div class="vl"></div> -->
					<h1 style="font-weight: bold;color: #87c43c; font-size:21px;  padding-top: 20px">
						Find Your City  
						</h1>
						
					</div>
					</div>
      
         <div class="form-group">
              			 <select class="js-example-basic-single "  style="width: 100% !important;" data-ng-model="city_id" id="cityID" name="city_id" data-ng-change="getArea()" id="city">
								 <option value="">Select City </option>
  							<option data-ng-repeat="obj in city | orderBy : 'city_name'" value="{{obj.city_id}}">{{obj.city_name}}</option>  
							</select>
              </div>
               <div class="form-group">
              
              <select class="js-example-basic-single " style="width: 100% !important;" data-ng-modal="area_id" name="area_id"  id="area_id"  >
                                            	<option value="">Select Area </option>
                                            	<option data-ng-repeat="areaObj in areaText | orderBy:'area_name'" value="{{areaObj.area_id}}">{{areaObj.area_name}}</option> 
                                            </select>
              </div>
            
      </div>
     <div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
			<div class="btn-group" role="group">
					<button type="button" data-ng-click="getAllMerchant()" style="background-color: #00afd1;color:#fff" id="findBtn" class="btn btn-default btn-hover-green" data-action="save" role="button">Find</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" style="background-color: #d25128;color:#fff" data-dismiss="modal"  role="button">Close</button>
				</div>
				
				
				<!-- <div class="btn-group btn-delete hidden" role="group">
					<button type="button" id="delImage" class="btn btn-default btn-hover-red" data-dismiss="modal"  role="button">Delete</button>
				</div> -->
			</div>
		</div>
    </div>

  </div>
</div>


  <div class="modal fade" id="myModalPlan" role="dialog" style="padding-top: 50px">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title text-center" style="color: #00afd1;font-size:x-large;">Plans<b  class="serviceToPayDisplay"></b></h4> 
          
        </div>
        
        <div class="row">
        <!-- <div class="col-md-4"><h4 class="modal-title" id="modalTitle"></h4></div>
        	<div class="col-md-2">
        		
        		</div> -->
					<div class="col-md-6" id="planT">
						<div class="col-md-4  col-xs-4" data-ng-repeat="type in planType"
							style="padding-top: 5px; padding-bottom: 5px;">
							<input class="btn btn-primary myBtnfk" type="button"
								data-ng-click="getPlan(type.category)" value="{{type.category}}">
						</div>
						
					</div>
				</div>
        
        <div class="modal-body">
          
                  <div class="row">
        	<div class="content-wrapper col-md-12 col-sm-12">  
                            <div class="page-row">
                                <!-- <h3 class="has-divider text-highlight"><strong>Unlimited Plans</strong></h3> -->
                                <div class="table-responsive" style="height:400px;">                      
                                   
							
                                     <table class="table table-boxed" id="myTable">
                                    	
                                        <thead>
                                            <tr>
                                                <th>Plan</th>
                                                <th>Validity(Days)</th>
                                                <th>Price</th>
                                                 <!-- <th>new Price</th> -->
                                                <th>Pay</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <tr data-ng-repeat="p in plan" data-ng-init="myInfo=parJson(p.json)">
                                        <td>{{p.subcategory}}</td>
                                        <td>{{myInfo.validity}}</td>
                                        <td>{{p.amount}}</td>
                                        <!-- <td>{{}}</td> -->
                                        <td><input type='button'  data-ng-click='selectPlan(p,myInfo)' class='btn btn-info'  value='Subscribe'> </td>
                                        </tr>
                                        
                                        </tbody> 
                                    </table>
                                </div><!-- //table-responsive -->
                                
                               
                                
                            </div><!-- //page-row  -->                                                                   
                        </div><!-- //content-wrapper -->
        </div>
          
        </div>
      <div class="modal-footer">
			<!-- <div class="btn-group btn-group-justified" role="group" aria-label="group button">
			<div class="btn-group" role="group">
					<button type="button" data-ng-click="getAllMerchant()" id="" class="btn btn-default btn-hover-green" data-action="save" role="button">Find</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
				</div>
				
			
			</div> -->
		</div>
      </div>
    </div>
  </div>
  
  
  

 
	
	
	 <div class="modal fade" id="myModalLD01" role="dialog" style="padding-top: 50px">
    <div class="modal-dialog modal-md">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title text-center" style="color: #00afd1;font-size:x-large;">Pay Bill</h4> 
          
        </div>
      
        <div class="modal-body">
          
                  <div class="row">
        	  <div class="col-md-12">
		  
		  <div id="loginError" style="color:red;display:none">Please enter correct user id and password</div>
		
        <form action="paybillOutgo/space-communication" id="payBillFrm1" method="post">
		 
		  	<input type="hidden" class="form-control" value="SPACE80">
			<input type="hidden" class="form-control" name="validity" id="addressStreet1" value="0">
		   	<input type="hidden" class="form-control" name="merchant_service_id" value="46">
			<input type="hidden" class="form-control" name="merchant_id" value="80">
		  	<input type="hidden" class="form-control ref_id" id="ref_id1" name="ref_id" value="0">
			<input type="hidden" class="form-control ref_id" id="mode" name="landlineInvoice" value="true">
			<input type="hidden" class="form-control" name="mode" id="mode1" value="Web">
			
						
			
			<div class="form-group">
			
			<input type="text" class="form-control" placeholder="Landline Number" name="customer_userId" id="userId1" data-toggle="userId1" data-placement="bottom" title="Please fill out this field" onchange="searchLandline(this.value,46)">
                  
            </div>
           
			
			<div class="form-group">
			
			<input type="text" class="form-control name" placeholder="Name" name="name" id="name1" data-toggle="name1" data-placement="bottom" title="Please fill out this field">
                  
            </div>
		
			<div class="form-group">
			
			<input type="text" class="form-control" placeholder="Email" name="customer_email" id="email1" data-toggle="email1" data-placement="bottom" title="Please fill out this field">
                  
            </div>
			
			<div class="form-group">
			
			<input type="text" class="form-control mobile" placeholder="Mobile" name="customer_mobile" id="mobile1" data-toggle="mobile1" data-placement="bottom" title="Please fill out this field" data-ng-keypress="filterValue($event)" maxlength="10">
                  
            </div>

			
			<div class=" col-md-12 form-group">
			<div class="col-md-6" style="color:#222;">
			Current Bill
			</div>
			<div class="col-md-6">
			<input type="text" class="form-control address" name="currentBill" placeholder="Current BIll" id="currentBill" data-toggle="currentBill" data-placement="bottom" title="Please fill out this field" readonly>
			<input type="hidden" class="form-control planName" placeholder="Plan Name" id="planName1" name="customer_plan_name" data-toggle="planName" value="NA" data-placement="bottom" title="Please fill out this field" readonly>
              </div>    
            </div>
		
			<div class="col-md-12 form-group">
			<div class="col-md-6" style="color:#222;">
			Previous Pending Bill
			</div>
			<div class="col-md-6">
			<input type="text" class="form-control address" name="pendingAmount" placeholder="Pending Amount" id="pendingAmount" data-toggle="pendingAmount" data-placement="bottom" title="Please fill out this field" readonly>
              </div>    
            </div>
                        	
            <div class="col-md-12 form-group">
          
			 <div class="col-md-6" style="color:#222;">
			Total to Pay
			</div>
            <div class="col-md-6">
            <input type="text" class="form-control" placeholder="Amount" name="transaction_amount" id="amount1" data-toggle="amount1" data-placement="bottom" title="Please fill out this field" readonly>
            </div>
           
               
            </div>
			</form></div>
        </div>
          
        </div>
      <div class="modal-footer">
		<div class="btn-group btn-group-justified" role="group" aria-label="group button">
			<div class="btn-group" role="group">
					<button type="button" onclick="payNowValidateLandline()"  class="btn btn-default btn-hover-green" data-action="save" role="button">Pay Now !</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
				</div>
				
			
			</div> 
		</div>
      </div>
    </div>
  </div>
  
	
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/outgoAssets/js/angular/angular.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/outgoAssets/js/angular/angular-cookies.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular-filter/0.5.8/angular-filter.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/outgoAssets/js/angular/app.js"></script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui/0.4.0/angular-ui.js"></script>
		<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/js/select2.min.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function() {
	    $('.js-example-basic-single').select2();
	});
	</script>
	<script type="text/javascript">
	
	 function searchLandline(searchId,sId){
		 
		 //alert("searchId :"+searchId);
		 
		 $.ajax({
									  type:"POST",
									 // url:"http://192.168.0.106:8080/outgo/landline-search/space-communication",
									  url:"https://www.outgo.co/landline-search/space-communication",
									 // url:"https://www.outgo.co/searchUser",
									   data:{
									 access_key:'SPACE80',
									 user_key:searchId,
									
									},
									   success:function(data){
										   //console.log(data)
										 // alert(data)
										   data=JSON.parse(data);
										  //console.log(data.merchant_customer_mobile)
										   if(data!='null'){
												if(data.merchant_service_id==sId){
													var amt=parseInt(data.merchant_customer_amount)-parseInt(data.gst_amount);
													var final=parseInt(data.final_amount)-parseInt(data.gst_amount);
													$('#name1').val(data.merchant_customer_name);
													$('#email1').val(data.merchant_customer_email);
													$('#mobile1').val(data.merchant_customer_mobile);
													
													
													$('#currentBill').val(amt);
													$('#pendingAmount').val(data.pending_amount);
													//$('#amount1').val(Number((data.final_amount).toFixed(2)));
									
													$('#amount1').val(final);
													$('#gst').val(Number((data.gst_amount).toFixed(2)));
													$('#planName1').val(data.pending_amount+":"+data.merchant_customer_amount+":"+data.gst_amount);
													$('#ref_id1').val(data.merchant_customer_id);
												}
											}
										 },
										 error:function(e){
										 // alert('Customer Not Found');
										 }
										 
									 });
		 
		 
		 
	 }
	 function payNowValidateLandline(){
		  var userId=$('#userId1').val();
		   	var name=$('#name1').val();
			var email=$('#email1').val();
			var mobile=$('#mobile1').val();
			var amount=$('#amount1').val();
			var currentbill=$('#currentBill').val();
			var pendingAmount=$('#pendingAmount').val();
		
		var flag=true;
		
		if(!userId){
			$('[data-toggle="userId1"]').tooltip(); 
			$('#userId1').focus();
			flag=false;
		}
		else if(!name){
			 $('[data-toggle="name1"]').tooltip(); 
	 		$('#name1').focus();
	 		flag=false;
		 }
		 
		else if(IsvalidEmail(email)==false){
			$('[data-toggle="email1"]').tooltip(); 
			$('#email1').focus();
			flag=false;
			} 
		else if(IsValidateMob(mobile)==false){
			$('[data-toggle="mobile1"]').tooltip(); 
			$('#mobile1').focus();
			flag=false;
		}
		else if(!currentbill){
			 $('[data-toggle="currentBill"]').tooltip(); 
	 		$('#currentBill').focus();
	 		flag=false;
		 }
		else if(!amount){
			$('[data-toggle="amount1"]').tooltip(); 
			$('#amount1').focus();
			flag=false;
		}
		
		else if(!pendingAmount){
			$('[data-toggle="pendingAmount"]').tooltip(); 
			$('#pendingAmount').focus();
			
			flag=false;
		}
		if(flag){
			$('#payBillFrm1').submit();
		}
		 
	  }
	</script>
	