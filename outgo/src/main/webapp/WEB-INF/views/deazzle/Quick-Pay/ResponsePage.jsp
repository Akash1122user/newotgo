<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title><%=request.getAttribute("business") %></title>
		<link rel="icon" href="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png" >

<script type="text/javascript">

setTimeout(function() {

	var url="<%=request.getContextPath()%>";
		//alert(url)
		var request = $.ajax({
			  url: url+"/sessionout",
			  method: "POST"
			});
			request.done(function( msg ) {
			});
			 
			request.fail(function( jqXHR, textStatus ) {
			});

}, 3000); 

</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  .header-right {
    float: none;
  }
}
</style>
</head>
<body>

<div class="header">
  <a href="http://www.deazzle.in" class="logo">  <img alt="deazzle" height="50px;" src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png"> </a>
  <div class="header-right">
   <!--  <a class="active" href="#home">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a> -->
  </div>
</div>

<div style="padding-left:20px;border: 2px solid;overflow-x:auto;  width:410px;  height:360px; margin: auto;" >






<table border="0"   width="100%"  height="100%"  style="padding-top: 30px;">
                                    	 <thead>
                                            <tr style="">
                                                <th colspan="2" style="border-bottom: 2px solid;" > <h1><%=request.getAttribute("business") %></h1></th>
                                                
                                                
                                            </tr>
                                        </thead>                                    
                                        <tbody>
                        
                                           
						<tr >
                   <td >Transaction Id</td>
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
                   <td> <%if(request.getAttribute("TxStatus").equals("Success")){ %> <b style="color: green;">SUCCESS</b> <% } else{%><b style="color: red;"><%=request.getAttribute("TxStatus") %></b> <%  } %> </td>
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
                                    
                                                 
                                    </table>
                                    
                                  

</div>

</body>
</html>
    