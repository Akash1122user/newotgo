<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OutGo</title>
 <link rel="icon" href="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png" >
    <!-- Bootstrap core CSS -->
    <link href="/outgo/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Custom styles for this template -->
    <link href="/outgo/assets/css/one-page-wonder.min.css" rel="stylesheet">

<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #1a95d9;
  border-right: 16px solid white;
  border-bottom: 16px solid #85c343;
  border-left: 16px solid white;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>  </head>

<script>
  function myfun(){

}
</script>

<body onload="">

    <!-- Navigation -->
    
    
    <div align="center" style="padding-top:150px;">
<div class="loader"></div>
<img src="<%=request.getContextPath() %>/assets/outgoAssets/images/outgo.png" class="w3-round" alt="OutGO"   height="60">
 <p style="font-size:20px;color:#3498db;">Please wait.. redirecting to OutGo Payment Solutions Pvt. Ltd</p>
 </div>

    
    
    
  
<div style="display: none;">
    <header class="masthead  text-white">
      <div class="masthead-content">
        <div class="container">
        <div class="row h-100">
          <div class="col-md-12 ">
            <div class="col-sm-5 header-content mx-auto">
                    <div class="border border-info alert alert-danger" >
        
          <h3 class=" text-center" style="margin-top: 16px;">Check Payment-Details</h3>
                    <hr> 
<%--                     <p>The person's name is <input type="text" value="<%=request.getAttribute("name") %>" readonly/></p>
 --%>            	<form id="addT" action="<%=request.getAttribute("formPostUrl") %>" method="post">
                    <div class="form-group">
                            Customer Name:<input type="text" id="firstName" name="firstName" class="form-control" value="<%=request.getAttribute("name") %>" readonly  />
                    </div>
                    <div class="form-group">
                           Customer Mobile: <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" value="<%=request.getAttribute("mobile") %>" readonly />
                    </div>
                    <div class="form-group">
                           Customer Email: <input type="text" id="email" name="email" class="form-control" value="<%=request.getAttribute("email") %>" readonly />
                    </div>
                    <div class="form-group">
                           Customer Address: <input type="text" id="addressCity" name="addressCity"  class="form-control" value="<%=request.getAttribute("address") %>" readonly />
                    </div>
                    <div class="form-group">
                           Service Name: <input type="text" class="form-control" value="<%=request.getAttribute("service_name") %>" readonly  />
                    </div>
                    <div class="form-group">
                           Amount: <input type="text" id="orderAmount" name="orderAmount" class="form-control" value="<%=request.getAttribute("amount") %>" readonly />
                    </div>
                        
                   <div class="form-group">
                            <input type="submit" class="btn btn-primary"  value="Pay"  />
                            
                        </div>
                         <div class="form-group">
                           Validity: <input type="text" id="addressStreet1" name="addressStreet1" class="form-control" value="<%=request.getAttribute("validity") %>" readonly />
                    </div>
      	 <input type="hidden" id="merchantTxnId" name="merchantTxnId" value="<%=request.getAttribute("MerchantTxnId") %>" />
            <input type="hidden" id="currency" name="currency" value="<%=request.getAttribute("currency") %>" />
      <%--  <input type="hidden" id="orderAmount" name="orderAmount" value="<%=request.getAttribute("orderAmount") %>" />
         <input type="text" id="email" name="email" value="${key.email}" />
       <input type="text" id="phoneNumber" name="phoneNumber" value="${key.mobile}" />    --%>     
       <input type="hidden" name="returnUrl" value="<%=request.getAttribute("returnURL") %>" />
       <input type="hidden" id="notifyUrl" name="notifyUrl" value="http://www.outgo.co" />
       <input type="hidden" id="secSignature" name="secSignature" value="<%=request.getAttribute("secSignature") %>" />
                    </form>
            	 
            </div></div></div>
        </div>
      </div></div>
      <div class="bg-circle-1 bg-circle"></div>
      <div class="bg-circle-2 bg-circle"></div>
      <div class="bg-circle-3 bg-circle"></div>
      <div class="bg-circle-4 bg-circle"></div>
    </header>

    

   
    
    <!-- Footer -->
   
    <!-- Bootstrap core JavaScript -->
    <script src="/outgo/assets/vendor/jquery/jquery.min.js"></script>
    <script src="/outgo/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</div>
  </body>
  <script type="text/javascript">
  
  setTimeout(function() { 

	  document.getElementById("addT").submit();
	}, 2000);
  
  </script>

</html>
