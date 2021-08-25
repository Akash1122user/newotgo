<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.outgo.keyClass.CitrusKey"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deAzzle</title>
  <meta name="description" content="deAzzle is a fast growing financial technology company which aims to empower micro-small services/businesses with the power of technology to automate the invoicing, collect payments online, create visibility and use communcation tools for reminders, alerts, messages. Merchants are able to offer their customers multiple payment methods including credit cards, debit cards, net banking, mobile wallets and deAzzle helps these businesses to lower their cost of offline collection, communicate easily with their consumer base, reduce manual tasks like billing, collection, alerts, reminders and receipts etc. On the other hand, consumers are getting a one stop for all their bill payments including their hyper-local services. Consumers can save their valuable time by paying all their recurring bills using one interface, discover local services and avail them and most importantly manage their expenses automatically.">
  <meta name="keywords" content="Payment Collection, Payment Getway, Invoice ,Employee Leaves">
  <meta name="author" content="deAzzle">

  <link rel="icon" href="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png" type="image/gif" >


 <c:set var="amount" value="${tx.transaction_amount}"/>
 <c:set var="orderId" value="${tx.transaction_order_id}"/>
<script type="text/javascript">

</script>
<% 
String amount=""+request.getAttribute("amount");
String orderId=(String)pageContext.getAttribute("orderId"); 
String securitySignature= CitrusKey.securitySignature(amount, orderId);
%>
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
</style>  </head>
<body>
<div align="center" style="padding-top:150px;">
<div class="loader"></div>
<img src="https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png" class="w3-round" alt="deAzzle"   height="60">
 <p style="font-size:25px;color:#3fbeab;">Please wait.. redirecting to deAzzle </p>
 </div>
<form align="center" method="post" action="<%=CitrusKey.formPostUrl%>"  id="submitpay">
       <input type="hidden" id="merchantTxnId" name="merchantTxnId" value="<%=orderId%>" />
       <input type="hidden" id="orderAmount" name="orderAmount" value="<%=amount%>" />
       <input type="hidden" id="currency" name="currency" value="<%=CitrusKey.currency %>" />
       <input type="hidden" id="email" name="email" value="${tx.customer_email}" />
       <input type="hidden" id="phoneNumber" name="phoneNumber" value="${tx.customer_mobile}" />        
       <input type="hidden" name="returnUrl" value="<%=CitrusKey.returnURL %>${link}"/>
       <input type="hidden" id="notifyUrl" name="notifyUrl" value="<%=CitrusKey.returnURL %>" />
       <input type="hidden" id="secSignature" name="secSignature" value="<%=securitySignature%>" />
       <input type="hidden" id="firstName" name="firstName" value="${name}" />
       <input type="hidden" id="lastName" name="lastName" value="${tx.transaction_id}" />
       <input type="hidden" id="addressStreet1" name="addressStreet1" value="${validity}" />
       <input type="hidden" id="addressStreet2" name="addressStreet2" value="${tx.merchant_id }" />
       <input type="hidden" id="addressCity" name="addressCity" value="${tx.ref_table }" />
       <input type="hidden" id="addressState" name="addressState" value="${tx.transaction_mode }" />
       <input type="hidden" id="addressCountry" name="addressCountry" value="${tx.customer_plan_name }" />
       <input type="hidden" id="addressZip" name="addressZip" value="${tx.ref_id }" />

       
     
       </form>
</body>
<script type="text/javascript"> 
setTimeout(function() { 

	document.getElementById("submitpay").submit();
}, 2000);
</script>
</html>