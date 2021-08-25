<!DOCTYPE html>
<%@page import="com.deazzle.api.deAzzleAPIS"%>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>deAzzle</title>
 <link rel="icon" href="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png" >
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
  border-top: 16px solid #f9e56b;
  border-right: 16px solid #3fbeab;
  border-bottom: 16px solid #f9e56b;
  border-left: 16px solid #3fbeab;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 5s linear infinite;
  animation: spin 3s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style> 
  </head>
<script>
  function myfun(){
document.getElementById("myfrm").submit();
}
</script>

<body onload="myfun()">

 
    
    <div align="center" style="padding-top:150px;">
<div class="loader"></div>
<img src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png" class="w3-round" alt="deAzzle"   height="60">
 <p style="font-size:25px;color:#3fbeab;">Please wait.. redirecting to deAzzle  </p>
 </div>

<div style="display: none;">
    <header class="masthead  text-white">
      <div class="masthead-content">
        <div class="container">
        <div class="row h-100">
          <div class="col-md-12 ">
            <div class="col-sm-5 header-content mx-auto">
                    <div class="alert" >
        
			<h3 class=" text-center">Transaction Details</h3>
                    <hr> 
					<div class="box-body" id="data">
                			<div class="table-responsive">  
       													 
                                    <table id="example1" class="table table-bordered" style="text-align:left" >
                                    	 <thead>
                                            <tr>
                                                <th>Contents</th>
                                                <th>Details</th>
                                                
                                            </tr>
                                        </thead>                                    
                                        <tbody>
                        
                                           
						<tr>
                   <td>Transaction Id</td>
                   <td> <%=request.getAttribute("TxId") %></td>
                   </tr>
                   
                   <tr>
                   <td>Name</td>
                   <td><%=request.getAttribute("firstName") %></td>
                   </tr>
				   
				   <tr>
                   <td>Email</td>
                   <td><%=request.getAttribute("email") %></td>
                   </tr>
                   
                   <tr>
                   <td>Transaction Status</td>
                   <td> <%=request.getAttribute("TxStatus") %> </td>
                   </tr>
                   
                   <tr>
                   <td>Transaction Amount</td>
                   <td><%=request.getAttribute("amount") %></td>
                   </tr>
                   
                   <tr>
                   <td>Transaction Date</td>
                   <td> <%=request.getAttribute("txnDateTime") %></td>
                   </tr>
                   
                       </tbody>
                                    
                                                 
                                    </table><!--//table-->
                                    
                                  
                                </div><!--//table-responsive-->		
                		</div>                   
      	
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


<form action="<%=deAzzleAPIS.smartbiz%>Citrus/ebsupgrad" method="POST" id="myfrm">
<input type="hidden" name="name" value="<%=request.getAttribute("firstName") %>" >
<input type="hidden" name="txnId" value="<%=request.getAttribute("TxId") %>" >
<input type="hidden" name="txnStatus" value=<%=request.getAttribute("TxStatus") %> " >
<input type="hidden" name="amount" value="<%=request.getAttribute("amount") %>">
<input type="hidden" name="email" value="<%=request.getAttribute("email") %>" >
<input type="hidden" name="sw" value="<%=request.getAttribute("sw") %>" >
<input type="hidden" name="plan" value="<%=request.getAttribute("plan") %>" >

<input type="hidden" name="accesstoken" value="<%=request.getAttribute("accesstoken") %>" >

<input type="hidden" name="deazzleKey" value="xYoemT4URhxnXwG2V3zbN9bz1UcZ/ggzjPeYUs0llvepPXhHm5Dsu0lPlM+Jc/X0" >
<input type="hidden" name="txnDateTime" value="<%=request.getAttribute("txnDateTime") %>" >
</form>
</div>

  </body>

</html>
             