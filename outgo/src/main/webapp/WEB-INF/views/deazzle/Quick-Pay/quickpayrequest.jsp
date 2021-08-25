<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
    display: -ms-flexbox; /* IE10 */
    display: flex;
    width: 100%;
    margin-bottom: 15px;
}

.icon {
    padding: 10px;
    background:  #3fbdab;;
    color: white;
    min-width: 50px;
    text-align: center;
}

.input-field {
    width: 100%;
    padding: 10px;
    outline: none;
}

.input-field:focus {
    border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
    background-color: #3fbdab;
    color: white;
    padding: 15px 20px;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

.btn:hover {
    opacity: 1;
}
</style>



  
</head>
<body>

<form action="<%=request.getContextPath() %>/Quick-Pay" style="max-width:500px;margin:auto; border: 2px solid ;border-color:  #3fbdab;padding: 3px; " method="post" >
  <h2 align="center"><%=request.getParameter("businessName") %></h2>
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" required="required" placeholder="Name" name="name" value="<%=request.getParameter("name") %>">
  </div>

  <div class="input-container">
    <i class="fa fa-mobile icon"></i>
    <input class="input-field" type="text" readonly="readonly" placeholder="Mobile No" name="phone" value="<%=request.getParameter("phone") %>">
  </div>


  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="text" placeholder="Email" required="required" name="email" value="<%=request.getParameter("email")%>">
  </div>
 
  <div class="input-container">
    <i class="fa fa-rupee icon"></i>
    <input class="input-field" type="text" readonly="readonly" required="required" placeholder="Amount" name="amount" value="<%=request.getParameter("amount")%>">
  </div>
 
  
  <div class="input-container">
    <i class="fa fa-info icon"></i>
    <input class="input-field" type="text" placeholder="Description" required="required" name="description" value="<%=request.getParameter("description")%>">
  </div>


  <input type="hidden" name="businessName" value="<%=request.getParameter("businessName")%>">
  <input type="hidden" name="objectId" value="<%=request.getParameter("objectId") %>">
  <input type="hidden" name="invoiceId" value="<%=request.getParameter("invoiceId") %>">
  <input type="hidden" name="merchantId" value="<%=request.getParameter("merchantId")%>">
  <input type="hidden" name="userId" value="<%=request.getParameter("userId")%>">
  <input type="hidden" name="merchantMobile" value="<%=request.getParameter("merchantMobile")%>">


  <button type="submit" class="btn">Pay</button>
</form>

</body>
</html>
    