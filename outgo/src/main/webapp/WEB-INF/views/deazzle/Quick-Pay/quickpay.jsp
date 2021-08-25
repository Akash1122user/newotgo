<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${businessName}</title>
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
<body>
  
    <div align="center" style="padding-top:150px;">
<div class="loader"></div>
<img src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png" class="w3-round" alt="deAzzle"   height="60">
 <p style="font-size:25px;color:#3fbeab;">Please wait.. redirecting   </p>
 </div>


<form action="<%=request.getContextPath()%>/quickpay" method="post" style=" display: none;" id="frm">
  <input type="text" name="name" value="${name}">
  <input type="text" name="businessName" value="${businessName}">
  <input type="text" name="phone" value="${phone}">
  <input type="text" name="description" value="${description}">
  <input type="text" name="objectId" value="${objectId}">
  <input type="text" name="invoiceId" value="${invoiceId}">
  <input type="text" name="merchantId" value="${merchantId}">
  <input type="text" name="amount" value="${amount}">
  <input type="text" name="email" value="${email}">
  <input type="text" name="userId" value="${userId}">
  <input type="text" name="merchantMobile" value="${merchantMobile}">
  <input type="submit" value="Submit">
</form>

</body>
<script type="text/javascript">
document.getElementById("frm").submit();
</script>

</html>