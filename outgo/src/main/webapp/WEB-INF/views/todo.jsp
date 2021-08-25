<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>To Do Task</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>







<!--Payment Entry Modal -->
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">

			<div class="">
				<div class="col-md-12">
					<div class="card">
              <h3 class="card-title">New Message</h3>
              <div class="card-body">
                <form class="form-horizontal" id="enq" method="post">
                
               <div class="form-group">
                    <label class="control-label col-md-3">Select Service</label>
                    <div class="col-md-8">
                    
                     
                      <select class="form-control "  id="merchant_service_id" name="merchant_service_id" >
                     <option  value="0"> Select Service  </option>
                   <c:forEach var="i" items="${service}">
                   
                   <option  value="${i.merchant_service_id }"> ${i.service_name } : ${i.merchant_business_name } : ${area_name }  </option>
                   </c:forEach>
                
                  
                  </select>
                    </div>
                  </div>
               <!--   <div class="form-group">
                    <label class="control-label col-md-3">Existing Customer</label>
                    <div class="col-md-8">
                               <select class="form-control" onchange="showcust()" id="ref_id" name="ref_id">
                  <optgroup label="Select Customers">
                  </optgroup>
                  </select>
                 
                    </div>
                  </div>
               <div class="form-group">
                    <div class="col-md-8 col-md-offset-3">
                      <div class="checkbox">
                        <label>
                         Or Fill Customer Details
                        </label>
                      </div>
                    </div>
                  </div> -->
                
                
                  <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-8">
                     <input class="form-control" type="hidden"  name="ref_id" value="0">
                     <input class="form-control" type="hidden"  name="merchantId" value="${merchantId}">
                      <input class="form-control" type="text" placeholder="Enter full name" id="custName" name="custName">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Mobile No</label>
                    <div class="col-md-8">
                      <input class="form-control col-md-8" type="tel" id="customer_mobile" name="customer_mobile" placeholder="Enter Mobile No">
                    </div>
                  </div>
                   <div class="form-group">
                    <label class="control-label col-md-3">Email</label>
                    <div class="col-md-8">
                      <input class="form-control col-md-8" type="email" id="customer_email" name="customer_email" placeholder="Enter email address">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Address</label>
                    <div class="col-md-8">
                      <textarea class="form-control" rows="2" id="custAddress" name="custAddress" placeholder="Enter your address"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label col-md-3">Message Type</label>
                    <div class="col-md-9">
                      <div class="radio-inline">
						<div class="animated-radio-button">
                        <label>
                          <input type="radio"  name="type" value="Enquiry"><span class="label-text">Enquiry</span>
                        </label>
                        </div>
                      </div>
                      <div class="radio-inline">
                      <div class="animated-radio-button">
                        <label>
                          <input type="radio" class="" name="type" value="Complaint" ><span class="label-text">Complaint</span>
                        </label>
                        </div>
                      </div>
                      
                       <div class="radio-inline">
                      <div class="animated-radio-button">
                        <label>
                          <input type="radio" class="" name="type" value="Task" ><span class="label-text">Task</span>
                        </label>
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  
                  
                  <div class="form-group">
                    <label class="control-label col-md-3">Message</label>
                    <div class="col-md-8">
                      <textarea class="form-control" rows="2" placeholder="Enter your Message" name="msg_description" id="msg_description"></textarea>
                    </div>
                  </div>
                 <!--  <div class="form-group">
                    <div class="col-md-8 col-md-offset-3">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox">I accept the terms and conditions
                        </label>
                      </div>
                    </div>
                  </div> -->
                </form>
              </div>
              <div class="card-footer">
                <div class="row">
                  <div class="col-md-8 col-md-offset-3">
                    <button class="btn btn-primary icon-btn" type="button" onclick="save()"><i class="fa fa-fw fa-lg fa-check-circle"></i>Submit</button>&nbsp;&nbsp;&nbsp;
                    <button class="btn btn-default icon-btn"  type="button" onclick="close1()">Close</button>
                  </div>
                </div>
              </div>
            </div>
				</div>
			</div>
		</div>
	</div>




<script type="text/javascript">


function save(){
	 $(this).prop('disabled',true);
	 
	    var form = $('#enq')[0];
	    console.log(form)
	    var data = new FormData(form);
	
	   
	  var ajaxReq = $.ajax({
	      url : "<%=request.getContextPath()%>/newMeassage",
	      type : "POST",
	      data : data,
	      cache : false,
	      contentType : false,
	      processData : false,
	      xhr: function(){
	        //Get XmlHttpRequest object
	         var xhr = $.ajaxSettings.xhr() ;
	        
	        //Set onprogress event handler 
	         xhr.upload.onprogress = function(event){
	          
	         };
	         return xhr ;
	    	},
	    	beforeSend: function( xhr ) {
	    	
	              }
	    });
	  
	    // Called on success of file upload
	    ajaxReq.done(function(msg) {
	    	 alert(msg)
	    	  			     
	   
	    });
	    
	    // Called on failure of file upload
	    ajaxReq.fail(function(jqXHR) {
	    	
	      alert(jqXHR.responseText);
	      
	    	//alert(jqXHR.status);
	    	
	    })		
}

function close1(){
	window.close();
}

</script>


</body>
</html>