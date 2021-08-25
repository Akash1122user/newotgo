package com.outgo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.hibernate.cfg.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.outgo.bean.TaxInvoice;
import com.deazzle.api.AESEncryption;
import com.deazzle.api.deAzzleAPIS;
import com.deazzle.model.easebuzzkeys.Converter;
import com.deazzle.model.easebuzzkeys.EaseBuzz;
import com.deazzle.model.easebuzzkeys.GetWay_Keys;import com.deazzle.model.login.LoginResponse;
import com.deazzle.model.login.Registration;
import com.deazzle.model.payment.Business;
import com.deazzle.model.payment.From;
import com.deazzle.model.payment.Payment;
import com.deazzle.model.payment.PaymentClass;
import com.deazzle.model.payment.PaymentConverter;
import com.deazzle.model.payment.PaymentResponse;
import com.deazzle.model.payment.Person;
import com.deazzle.model.payment.Receipt;
import com.deazzle.model.payment.To;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import com.outgo.bean.ALL;
import com.outgo.bean.Interaction;
//import com.mysql.jdbc.Messages;
import com.outgo.bean.MerchantCustomerMaster;
import com.outgo.bean.Merchant_Payment_keys;
import com.outgo.bean.MessagesMaster;
import com.outgo.bean.OTP_Verifay;
import com.outgo.bean.OtherCustomerRegisterMaster;
import com.outgo.bean.SMSMaster;
import com.outgo.bean.SendKeys;
import com.outgo.bean.TransactionMaster;
import com.outgo.bean.User;
import com.outgo.keyClass.CitrusKey;
import com.outgo.messages.Messages;
import com.outgo.messages.Error;
import com.outgo.messages.Link;
import com.outgo.myfun.MyFunction;
import com.outgo.bean.Settings;
import com.outgo.services.ApiServices;
import com.outgo.services.ImageThread;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Controller
public class ApiController {
	@Autowired
	ApiServices service;
	
	@RequestMapping(value = { "/ex" }, method = RequestMethod.GET)
	public String error2() {
		return "NewFile3";
		
	}

	
	// initial
	@ResponseBody
	@RequestMapping(value="/messages/{keyurl}")
	public ModelAndView  messages(@PathVariable("keyurl") String keyurl,HttpServletRequest request,Model model) {		
		ModelAndView mav = new ModelAndView();		
		Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"'");
		
		try {if(keys==null)
		{
			model.addAttribute("error","Authentication Fail...Invalid Production Url.");
			 mav.setViewName("messages");
			    return mav;
		}
			
		}catch(NullPointerException e)
		{		
			model.addAttribute("error","Authentication Fail...Invalid Production Url.");
			 mav.setViewName("messages");
			    return mav;
		}
	
		/*ALL all=service.getData("");*/
		
	    mav.setViewName("messages");
	    return mav;
	}
/*
	@RequestMapping(value ="/invoice-{order_id}-smartBiz", method = RequestMethod.GET)
	
	public ModelAndView invoice(ModelMap model,HttpServletRequest  request,@PathVariable("order_id") String order_id) {
		ModelAndView mav = new ModelAndView();
		
		//System.out.println(order_id);
		try {
		String Name="CASE tm.ref_table\n" + 
				"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((tm.ref_id=n.other_cust_id and tm.ref_table='Non_Register_Customer') ))\n" + 
				"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((tm.ref_id=m.merchant_customer_id and tm.ref_table='Merchant_Customer_Master') ))\n" + 
				"  WHEN 'Merchant_Info' THEN (select mi.name from Merchant_Info mi where ((tm.ref_id=mi.merchantId and tm.ref_table='Merchant_Info') )) \n"+
				"  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((tm.ref_id=c.customer_id and tm.ref_table='Customer_Master') ))\n" + 
				"  ELSE 'Unknow' \n" + 
				"END as name ,am.address_desc\n" + "";
		TransactionMaster tx=service.getTransaction(order_id);		
		Settings settings=service.getSetting("select * from Settings s where s.merchant_id="+tx.getMerchant_id());
		
		model.addAttribute("settings",settings);
		String name="-";
		model.addAttribute("c",service.list("SELECT tm.*,cl.employeeName,cl.email,cl.mobileNo,mm.merchant_business_name,mm.merchant_terms_conditions,mm.contact_id,mm.merchant_service_logo,tx.gstn_number,tx.gst_tax,tx.pan_number,"+Name+" FROM Transaction_Master tm,Merchant_Service_Detail_Master mm,Tax_Master tx,Contact_login cl,Address_Master am  where \r\n" + 
				"tm.merchant_service_id=mm.merchant_service_id  and   am.address_id=mm.address_id  and \r\n" + 
				"tx.tax_id=mm.tax_id and mm.contact_id=cl.id and transaction_order_id='"+order_id+"'").get(0));
		
		try {
			if(tx.getRef_table().equals("Merchant_Customer_Master")) {
				MerchantCustomerMaster cust =service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_id="+tx.getRef_id());
				name=cust.getMerchant_customer_name();
				model.addAttribute("cust",cust);
			}
		}catch(NullPointerException n) {}
		insertInteraction(tx.getCustomer_email(), name, tx.getCustomer_mobile(), tx.getMerchant_service_id(), tx.getMerchant_id(), "Invoice", "Invoice", tx.getTransaction_id(), "Transaction");

		
		if(tx.isLandlineInvoice()) {
		//System.out.println("COMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
			mav.setViewName("landlineInvoive"); 
		}else {
			//System.out.println("COMMMMMMMMMMMMMMMMMMMMMMMMMMMMM222");
		mav.setViewName("invoice"); 
		}
		
		
		
		return mav;
	}catch(IndexOutOfBoundsException e) {return null;}
		catch(NullPointerException e) {return null;}
			
	}
	
@RequestMapping(value ="/receipt-{order_id}-smartBiz", method = RequestMethod.GET)
	
	public ModelAndView receiptOrder(ModelMap model,HttpServletRequest  request,@PathVariable("order_id") String order_id) {
		ModelAndView mav = new ModelAndView();
		
		//System.out.println(order_id);
		try {
		String Name="CASE tm.ref_table\n" + 
				"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((tm.ref_id=n.other_cust_id and tm.ref_table='Non_Register_Customer') ))\n" + 
				"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((tm.ref_id=m.merchant_customer_id and tm.ref_table='Merchant_Customer_Master') ))\n" + 
				"  WHEN 'Merchant_Info' THEN (select mi.name from Merchant_Info mi where ((tm.ref_id=mi.merchantId and tm.ref_table='Merchant_Info') )) \n"+
				"  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((tm.ref_id=c.customer_id and tm.ref_table='Customer_Master') ))\n" + 
				"  ELSE 'Unknow' \n" + 
				"END as name ,am.address_desc\n" + "";
		TransactionMaster tx=service.getTransaction(order_id);		
		Settings settings=service.getSetting("select * from Settings s where s.merchant_id="+tx.getMerchant_id());
		model.addAttribute("settings",settings);
		List<Object> l=service.list("SELECT tm.*,am.address_desc as addressOfM,cl.employeeName,cl.email,cl.mobileNo,mm.merchant_business_name,mm.merchant_terms_conditions,mm.contact_id,mm.merchant_service_logo,tx.gstn_number,tx.gst_tax,tx.pan_number,"+Name+" FROM Transaction_Master tm,Merchant_Service_Detail_Master mm,Tax_Master tx,Contact_login cl,Address_Master am  where \r\n" + 
				"tm.merchant_service_id=mm.merchant_service_id  and   am.address_id=mm.address_id  and \r\n" + 
				"tx.tax_id=mm.tax_id and mm.contact_id=cl.id and transaction_order_id='"+order_id);
		
		
		String name="-";
		model.addAttribute("c",service.list("SELECT tm.*,am.address_desc as addressOfM,cl.employeeName,cl.email,cl.mobileNo,mm.merchant_business_name,mm.merchant_terms_conditions,mm.contact_id,mm.merchant_service_logo,tx.gstn_number,tx.gst_tax,tx.pan_number,"+Name+" FROM Transaction_Master tm,Merchant_Service_Detail_Master mm,Tax_Master tx,Contact_login cl,Address_Master am  where \r\n" + 
				"tm.merchant_service_id=mm.merchant_service_id  and   am.address_id=mm.address_id  and \r\n" + 
				"tx.tax_id=mm.tax_id and mm.contact_id=cl.id and transaction_order_id='"+order_id+"'").get(0));
		
		try {
			if(tx.getRef_table().equals("Merchant_Customer_Master")) {
				MerchantCustomerMaster cust =service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_id="+tx.getRef_id());
				name=cust.getMerchant_customer_name();
				model.addAttribute("cust",cust);
			}
		}catch(NullPointerException n) {}
		
	
		insertInteraction(tx.getCustomer_email(), name, tx.getCustomer_mobile(), tx.getMerchant_service_id(), tx.getMerchant_id(), "Receipt", "Receipt", tx.getTransaction_id(), "Transaction");

		mav.setViewName("receipt"); 
		
		return mav;
	}catch(IndexOutOfBoundsException e) {return null;}
		catch(NullPointerException e) {return null;}
			
	}
	
*/	@RequestMapping(value="/pay/{keyurl}" ,method=RequestMethod.POST)
	public String  showData(Model model,TransactionMaster tx,HttpServletRequest request,HttpSession session,
			HttpServletResponse response,String name,String address,
			@PathVariable("keyurl") String keyurl,
			@RequestParam(value="validity", defaultValue="N/A",required=false)  String validity
			,@RequestParam(value="mode",defaultValue="N/A",required=false) String mode
			,@RequestParam(value="merchantMobile",defaultValue="0",required=false) String merchantMobile
			,@RequestParam(value="objectId",defaultValue="N/A",required=false) String objectId
			,@RequestParam(value="businessName",defaultValue="N/A",required=false) String businessName
			
			) {
		
	System.err.println(tx.getCustomer_mobile());
	//HttpSession session=request.getSession();  
    session.invalidate();  

	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and  m.merchant_key='"+tx.getMerchant_id()+"'");
	
		try {if(keys==null)
		{
			model.addAttribute("error","Authentication Fail...Invalid Production Url.");
			return "error";	
		}
			
		}catch(NullPointerException e)
		{		
			model.addAttribute("error","Authentication Fail...Invalid Production Url.");
			   return "error";	
		}
		
		
		System.out.println("ACCESS "+request.getParameter("access_key"));
		try 
		{
			if(request.getParameter("access_key")==null)
		{
			model.addAttribute("error","Authentication Fail...Invalid  access_key.");
			return "error";	
		}
			
		if(!request.getParameter("access_key").equals(keys.getAccess_key())){
			model.addAttribute("error","Authentication Fail...Invalid  access_key.");
			return "error";	
		}
		
		}catch(NullPointerException e)
		{		
			model.addAttribute("error","Authentication Fail...Invalid  access_key.");
			   return "error";	
		}
		
		
		
		try 
		{
			if(request.getParameter("merchant_id")==null)
		{
			model.addAttribute("error","Authentication Fail...Invalid  access_key.");
			return "error";	
		}
			
		if(!request.getParameter("merchant_id").equals(keys.getMerchant_key())){
			model.addAttribute("error","Authentication Fail...Invalid  Id Mismatch.");
			return "error";	
		}
		
		}catch(NullPointerException e)
		{		
			model.addAttribute("error","Authentication Fail...Invalid   Id Mismatch.");
			   return "error";	
		}
		
		try {		
			if(tx.getMerchant_service_id()==0L)
			{
				model.addAttribute("error","Authentication Fail...Please Select Service.");
				return "error";	
			}
		}catch(NullPointerException e)
		{		
			   model.addAttribute("error","Authentication Fail...Please Select Service.");
			   return "error";	
		}
		
		
		try {		
			if(name==null||name.equals(""))
			{
				model.addAttribute("error","Authentication Fail...Please Enter Name.");
			    return "error";
			}	
		}catch(NullPointerException e)
		{		
			   model.addAttribute("error","Authentication Fail...Please Enter Name.");
			   return "error";	
		}

		try {		
			if(tx.getCustomer_mobile()==null||tx.getCustomer_mobile().equals(""))
			{		
				model.addAttribute("error","Authentication Fail...Please Enter Valid Mobile No.");
				return "error";	
			}
			if (!tx.getCustomer_mobile().matches("\\d{10}")) 
			{		
				model.addAttribute("error","Authentication Fail...Please Enter Valid Mobile No.");
				return "error";	
			}
		}catch(NullPointerException e)
		{		
			 model.addAttribute("error","Authentication Fail...Please Enter Valid Mobile No.");
			 return "error";	
		}
		
		try {		
			if(tx.getCustomer_email()==null||tx.getCustomer_email().equals(""))
			{
			   model.addAttribute("error","Authentication Fail...Please Enter Email.");
			   return "error";	
			}
			
		}catch(NullPointerException e)
		{		
			   model.addAttribute("error","Authentication Fail...Please Enter Email.");
			   return "error";	
		}
		try {		
			if(tx.getTransaction_amount()==0)
			{
				model.addAttribute("error","Authentication Fail...Please Enter Amount.");
			    return "error";
			}	
			
		}catch(NullPointerException e)
		{		
			model.addAttribute("error","Authentication Fail...Please Enter Amount.");
			return "error";	
		}
		
		//OtherCustomerRegisterMaster o=service.getNonRegisterCustomer("select * from Non_Register_Customer n where n.other_cust_mobile='"+tx.getCustomer_mobile()+"'");
		 MerchantCustomerMaster mm=service.searchUserMerchant("select * from Merchant_Customer_Master mcm where mcm.merchant_id="+keys.getMerchant_key()+" and mcm.merchant_service_id="+tx.getMerchant_service_id()+" and  mcm.merchant_customer_mobile='"+tx.getCustomer_mobile()+"'");
		
		//System.out.println("ref_id-->" +new Gson().toJson(mm));
			//System.out.println("ref_id2-->" +tx.getCustomer_userId());

		 boolean addcust=false;
		 if(mode.equals("p")) {
			try {
				if (mm == null) {
					addcust = true;

				} else {
					addcust = false;
				}
			} catch (NullPointerException n) {
				addcust = true;

			}
				
				
				if(addcust) {
					MerchantCustomerMaster m1=new MerchantCustomerMaster();
					m1.setMerchant_customer_user_id(tx.getCustomer_userId());
					m1.setMerchant_customer_name(name);
					m1.setStatus(false);
					m1.setMerchant_customer_address(address);
					m1.setMerchant_customer_email(tx.getCustomer_email());
					m1.setMerchant_customer_mobile(tx.getCustomer_mobile());
					m1.setMerchant_id(tx.getMerchant_id());
					m1.setMerchant_service_id(tx.getMerchant_service_id());
					m1.setMerchant_customer_amount(tx.getTransaction_amount());
					m1.setMerchant_customer_description("New Registration");
					m1=service.saveRegisterCustomer(m1);
					tx.setRef_id(m1.getMerchant_customer_id());
					tx.setRef_table("Merchant_Customer_Master");
				}
				
				
			}else {				
				
				tx.setRef_id(0);
				tx.setRef_table("deazzle");
		}
		
		tx.setMerchant_id(Long.parseLong((keys.merchant_key)));
		tx.setTransaction_mode("Web User Site");

		/*18 July 2018 Integration multiple Payment Getway */

		tx.setTransaction_payment_gatway_name(keys.getway);

		
		tx.setTransaction_type("Online");
		
		try {

			if(tx.getTransaction_order_id()==null)
				tx.setTransaction_order_id("SW"+System.currentTimeMillis());
			if(tx.getTransaction_order_id().equals(""))
				tx.setTransaction_order_id("SW"+System.currentTimeMillis());
			
		}catch(NullPointerException n) {tx.setTransaction_order_id("SW"+System.currentTimeMillis());
		}
		//save data in transaction table		
		//tx=service.saveCustomerTransaction(tx);
		//System.out.println("Done "+new Gson().toJson(tx));
	
		//search service by service id
		//String service_name=service.getService(tx.getMerchant_service_id());
		/*Registration Process deazzle*/		{
			
			Registration reg=new Registration(Long.parseLong(tx.getCustomer_mobile()), "", "", "", "", name, Long.parseLong(tx.getCustomer_mobile()), "outgo");
			
			Gson g=new Gson();
			System.out.println(g.toJson(reg));
			try {
				String Failure=deAzzleAPIS.sendPost("", "register/", g.toJson(reg),"POST");
			
				if("Failure".equals(Failure)) {
					String res=deAzzleAPIS.sendGet("", "passcode/beforeLogin/?username="+tx.getCustomer_mobile());
					
				}else
					deAzzleAPIS.sendGet("", "passcode/beforeLogin/?username="+tx.getCustomer_mobile());

					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		
		/*Send Otp Code*/
/*		{
			
			try {
				String res=deAzzleAPIS.sendGet("", "passcode/beforeLogin/?username="+tx.getCustomer_mobile());
			
			System.out.println("SUCESSSSSSSS--------------"+res);	
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
*/		//System.out.println("service name-->"+service_name);
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		String amt =String.valueOf(df.format(tx.getTransaction_amount()));
		amt=amt.replaceAll(",", "");
		
		if(true){
		
		request.setAttribute("email",tx.getCustomer_email());
		request.setAttribute("amount",amt);
		request.setAttribute("mobile",tx.getCustomer_mobile());
		request.setAttribute("address", address);
		request.setAttribute("name",name);
		request.setAttribute("validity", validity); 
		
		/*New Added 3 sep*/
		request.setAttribute("merchantMobile", merchantMobile); 
		request.setAttribute("link", ""); 
			request.setAttribute("objectId", objectId); 
		request.setAttribute("tx",tx );; 
		request.setAttribute("keyurl", keyurl); 
		request.setAttribute("mode", mode); 
		request.setAttribute("businessName", businessName); 
		request.setAttribute("xno", tx.getCustomer_mobile().substring(0, 2)+"XXXXXX"+tx.getCustomer_mobile().substring(8, 10)); 
		session.setMaxInactiveInterval(1000); 
		Map<String, Object> map=new ModelMap();
		

		
		String res="-";
		try {
		res=MyFunction.getOnlyStrings(tx.getCustomer_plan_name());
		if(res==null||res.isEmpty())
			res="-";
		
		}catch (NullPointerException e) {
			res="-";
		}
		res=res.replace(".","");
		String plan="-";
		try {
		
		if(!GetWay_Keys.empty(tx.getCustomer_plan_name())) {
			plan=GetWay_Keys.clean(tx.getCustomer_plan_name());
		}
			
		
		}catch (NullPointerException e) {
			plan="-";
		}
		
		String sw="SW";
		try {
			if(request.getParameter("sw").equals("sw"));
			sw="UP";
			if(request.getParameter("sw").equals("sr"));
			sw="SR";

		}catch (NullPointerException e) {
			sw="SW";		}
		
		
		System.err.println("Name  ? "+name);
		name=name.replace(".", "");
		System.err.println("Name  ? "+name);
		
		
		
		   map.put("paymode",sw);
		   map.put("productinfo",res.trim());
		   map.put("plan",plan);
		   map.put("firstname", name.trim());
		   map.put("email", tx.getCustomer_email().trim());
		   map.put("phone", tx.getCustomer_mobile());
		   map.put("amount", amt);
		   map.put("amount1", tx.getTransaction_amount());
		   map.put("txnid", tx.getTransaction_order_id());
		   map.put("udf1", ""+tx.getMerchant_id());
		   map.put("udf2", ""+tx.getMerchant_service_id());
	       map.put("address", address);
		   map.put("businessName", businessName.trim());
		   map.put("merchantMobile", merchantMobile.trim());
		   map.put("validity", validity.trim()); 
		 //  map.put("tx", tx);
		   map.put("keyurl", keyurl.trim());
		   map.put("mode", mode.trim());
		   map.put("keyurl", keyurl.trim()); 
		   String userId="-";
		   try {
		   if(GetWay_Keys.empty(tx.getCustomer_userId())) {
			   userId="-";
		   }else
			   userId=GetWay_Keys.clean(tx.getCustomer_userId());
		   }catch (NullPointerException e) {
			   userId="-";
		}
		   userId=userId.replaceAll(".", "");
		   
		   System.err.println("User Id----------"+userId);
		   map.put("userId", userId.trim());
		   session = request.getSession();

	
		session.setAttribute("data", map);
		
		return "deazzle/static-payment/otp";
		}
		
		
		if(keys.getway.equals("Citrus"))
		{
		SendKeys key=new SendKeys();
		key.setCurrency(CitrusKey.currency);
		key.setFormPostUrl(CitrusKey.formPostUrl);
		key.setMerchantTxnId(tx.getTransaction_order_id());
		key.setEmail(tx.getCustomer_email());
		key.setMobile(tx.getCustomer_mobile());
		//key.setNotifyUrl(CitrusKey.notifyUrl+"redirect");
		key.setAddress(validity);
		key.setReturnURL(CitrusKey.returnURL+"redirect");
		key.setAmount(tx.getTransaction_amount());
		key.setSecuritySignature(CitrusKey.securitySignature(amt , tx.getTransaction_order_id()));
		
		//request.setAttribute("key",key);
		request.setAttribute("returnURL",CitrusKey.returnURL+"redirect");
		request.setAttribute("formPostUrl",CitrusKey.formPostUrl);
		request.setAttribute("currency",CitrusKey.currency);
		request.setAttribute("MerchantTxnId",key.merchantTxnId);
		request.setAttribute("secSignature",key.securitySignature);
		 return "ApiInfo";
		}else {
			
			String k[]=keys.getway_keys.split("deazzle");
	        String merchant_key = k[0];
	        String salt = k[1];
			String sub_merchant_id=k[3];
	        String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";    

			   Map<String, String> params = new HashMap<String, String>();
			   params.put("productinfo",tx.getCustomer_plan_name());
			   params.put("firstname", name);
			   params.put("email", tx.getCustomer_email());
			   params.put("phone", tx.getCustomer_mobile());
			   params.put("surl", GetWay_Keys.EASYBUZZ_SUCCESS_URL);
			   params.put("furl", GetWay_Keys.EASYBUZZ_FAIL_URL);
			   params.put("amount", amt);
			   params.put("txnid", tx.getTransaction_order_id());
			   params.put("udf1", ""+tx.getMerchant_id());
			   params.put("udf2", ""+tx.getMerchant_service_id());

				try {
						if(validity==null)
							validity="0";
						if(validity.equals("N/A"))
							validity="0";
						//System.out.println("validity=\"0\";     "+validity);
				}catch(NullPointerException n) {validity="0";}
				
			   
			   params.put("udf3", validity);
			   params.put("udf4", "");
			   params.put("udf5", "");
			   params.put("udf6", "");
			   params.put("udf7", "");
			   params.put("udf8", "");
			   params.put("udf9", "");
			   params.put("udf10", "");
			   params.put("key",merchant_key);

			   
		      
		        String base_url ="";
		        if(k[2].equals("prod")){
		            base_url = "https://pay.easebuzz.in/";
		        }else{
		            base_url = "https://testpay.easebuzz.in/";
		        }
		        String hashString = "";
		        String hash = "";
		        int error = 0;
		        if (GetWay_Keys.empty(merchant_key)) {
	                error = 1;
	            } else {
	                String[] hashVarSeq = hashSequence.split("\\|");

	                for (String part : hashVarSeq) {
	                	hashString = (GetWay_Keys.empty(params.get(part))) ? hashString.concat("") : hashString.concat(params.get(part));
	                	System.out.println("hashString FOR->"+hashString);

	                	hashString = hashString.concat("|");
	                    
	                }
	                 System.out.println("hashString->"+hashString);
	                
	                hashString = hashString.concat(salt);
	                

	                hash = GetWay_Keys.Easebuzz_Generatehash512("SHA-512", hashString);
	                params.put("hash", hash);
	                params.put("sub_merchant_id",sub_merchant_id);
	                System.out.println("hash->"+hash);
	                
	                System.out.println(params);
	                
                    try {
	                
	                StringBuilder sb = new StringBuilder();
	                for (Map.Entry<String, String> e : params.entrySet()) {
	                    if (sb.length() > 0) {
	                        sb.append('&');
	                    }
							sb.append(URLEncoder.encode(e.getKey().trim(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue().trim(), "UTF-8"));
	                }

	                URL url;
						url = new URL(base_url + "payment/initiateLink");
	                
	                System.out.println("URL: "+url);
	                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
	                con.setRequestMethod("POST");
	                con.setDoOutput(true);
	                PrintStream ps = new PrintStream(con.getOutputStream());
	                ps.println(sb);
	                ps.close();
	                con.connect();
	                StringBuilder res = new StringBuilder();
	                if (con.getResponseCode() == HttpsURLConnection.HTTP_OK) {
	                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	                    String line;
	                    while ((line = br.readLine()) != null) {
	                        res.append(line);
	                    }
	                    br.close();
	                }
	                con.disconnect();
	                System.out.print(res);
					
                    
	                
	                Object obj = new JSONParser().parse(res.toString());
	                JSONObject jo = (JSONObject) obj;

	                System.out.println("json: "+res.toString());
	                if (jo.get("status").toString().equals("1")) {
	                    //response.sendRedirect(base_url + "pay/" + jo.get("data").toString());
	                	return "redirect:"+base_url + "pay/" + jo.get("data").toString();
	                } else {
	                    System.out.print(jo.get("data").toString());
	                }
                    
                    
                    
                    } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (org.json.simple.parser.ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

                    
                    
                    

	                
	            }}
		return amt;
			   
		
		
	}
		

	@ResponseBody
	@RequestMapping(value="/deazzle-resend-otp" , method = RequestMethod.POST)
	public  String resendotp(Model model,HttpServletRequest request,HttpSession session,String mobile  ){
		Map data=(ModelMap)session.getAttribute("data");
		
		System.out.println(data.get("phone"));
		
		//TransactionMaster tx=(TransactionMaster) data.get("tx");
		if(data.get("phone").equals(mobile))
		
		try {
			String res=deAzzleAPIS.sendGet("", "passcode/beforeLogin/?username="+mobile);
		
		System.out.println("SUCESSSSSSSS--------------"+res);	
		return "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "fail";
		//return new Gson().toJson(tx);
	}
	
	@ResponseBody
	@RequestMapping(value="/deazzle-otp-validation" , method = RequestMethod.POST)
	public  String deazzleotpvalidation(Model model,HttpServletRequest request,HttpSession session  ){

		System.out.println("Coming");

		Map data=(ModelMap)session.getAttribute("data");
		
		 try {
			String encryptpassword = AESEncryption.encrypt(request.getParameter("txtOtp"));
			System.out.println(encryptpassword);
			String da="{\r\n" + 
					"	\"client_id\": \"FyDQdh4qTXMSKnwVqyMNholYdpEa\",\r\n" + 
					"	\"client_secret\": \"6aQCIU4g0L9UBoPinRMNEk1DHCwa\",\r\n" + 
					"	\"grant_type\": \"password\",\r\n" + 
					"	\"username\": \""+data.get("phone")+"\",\r\n" + 
					"	\"otp\": \""+encryptpassword+"\"\r\n" + 
					"	\r\n" + 
					"}";
			
			System.out.println(da);
			
		String r=	deAzzleAPIS.sendPost("", "login/", da,"POST");

		if("Failure".equals(r)) {
			
			return "fail";

		}if("401".equals(r)) {
			return "fail";
		}else {
			
		
		//	System.out.println(r);
			Gson g=new Gson();
			
			
			LoginResponse l=g.fromJson(r, LoginResponse.class);

			Payment payment=new Payment();
			From from=new From();
			To to=new To();
			Business business=new Business();
			Person person=new Person();
			
			person.setPhoneNumber(mobile(data.get("phone")+""));
			System.out.println("---------------------?"+data.get("firstname"));
			
			person.setName(stringArray(data.get("firstname")+""));
			from.setPerson(person);
			business.setPhoneNumber(mobile(data.get("merchantMobile")+""));
			to.setBusiness(business);
			
			PaymentClass pay=new PaymentClass();
			String plan="N/A";
			try {
				
			if(data.get("plan")==null)
				plan=data.get("businessName")+"";
			else
				plan=data.get("plan")+"";
			}catch (NullPointerException e) {
				// TODO: handle exception
			}
			
			pay.setServiceName(stringArray(plan));
			pay.setAmountPaid((int)Float.parseFloat(data.get("amount")+""));
			pay.setTransactionID(""+(System.currentTimeMillis()/1000));
			pay.setDate(MyFunction.date4());
			pay.setPaymentDate(MyFunction.date3());
			if(data.get("paymode").equals("RC"))
				pay.setGateway("_");
				else
			pay.setGateway("EaseBuzz");
			pay.setHTTPReferrer("outgo");
			pay.setPaymentDescription(data.get("paln")+"");
			if(data.get("paymode").equals("RC"))
				pay.setPaymentSource("REGISTER_CUSTOMER");
			else if(data.get("paymode").equals("SL"))
				pay.setPaymentSource("SMARTBIZ_LINK");
			else if(data.get("paymode").equals("UP")||data.get("paymode").equals("SR")||data.get("paymode").equals("DR"))
				pay.setPaymentSource("SMARTBIZ_WEB");
			else
			pay.setPaymentSource("SELLER_WEB");
			pay.setPaymentStatus("Pending");
			pay.setPayuID(data.get("txnid")+"");
			pay.setOutgo_customer_user_id(data.get("userId")+"");
		
			payment.setFrom(from);
			payment.setPayment(pay);
			payment.setTo(to);
			String payR=deAzzleAPIS.sendPost(l.getResultData().getAuthorization_Info().getAccess_token(), "payment/",PaymentConverter.toJsonString(payment),"POST");
		
			if(payR.equals("401")) {
				/*Insert Repress Token Code*/
			}if(payR.equals("Failure")){
					
					/*Wrong*/
				}else {
					PaymentResponse	 p=g.fromJson(payR, PaymentResponse.class);
					
						System.out.println("Object_id +++"+p.getResultData().get(0).getObject_id());
					
						session.setAttribute("object_id", p.getResultData().get(0).getObject_id());
						
				}
		 
			session.setAttribute("accesstoken", l.getResultData().getAuthorization_Info().getAccess_token());
			session.setAttribute("refreshtoken", l.getResultData().getAuthorization_Info().getRefresh_token());
			System.out.println("Refress Tokan"+ l.getResultData().getAuthorization_Info().getAccess_token());
		}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		if(data.get("paymode").equals("RC"))
			return"success2";
			else
		return "success";
	}
	
	
	long []mobile(String mobile){
		long []mo= {Long.parseLong(mobile)};
		return mo;
		
	}
	

	String []stringArray(String string){
		String []mo= {string};
		return mo;
		
	}
	
	
	
	
	@RequestMapping(value="/pay-offline" , method = RequestMethod.POST)
	public  String payoffline(Model model,HttpServletRequest request,HttpSession session  ){
		
			
			Map data1=(ModelMap)session.getAttribute("data");
			Object object_id=(Object)session.getAttribute("object_id");
			
            String access=(String)session.getAttribute("accesstoken");
            
            String data="        {\r\n" + 
            		"          \"payment_status\":\"Success\",\r\n" + 
            		"          \"easepayid\":\"-\",\r\n" + 
            		"          \"Payment_mode\":\"CASH\"\r\n" + 
            		"        }";
            
            try {
				String res=deAzzleAPIS.sendPost(access, "payment/"+object_id+"/", data, "PUT");
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            
            /*Recipt
             * 
*/            

			Payment payment=new Payment();
			From from=new From();
			To to=new To();
			Business business=new Business();
			Person person=new Person();
			person.setPhoneNumber(mobile(data1.get("phone")+""));
			from.setPerson(person);
			business.setPhoneNumber(mobile(data1.get("merchantMobile")+""));
			to.setBusiness(business);

			Receipt receipt =new Receipt();
			
			receipt.setAmount_received((int)Float.parseFloat(data1.get("amount")+""));
			receipt.setHttp_referrer("outgo");
			receipt.setPayment_mode("CASH");
			receipt.setPayment_Ref_Id(request.getParameter("udf4"));
			receipt.setReceipt_date(new Date()+"");
			receipt.setReceipt_description(data1.get("plan")+"");
			receipt.setStatus("Success");
			payment.setFrom(from);
			payment.setTo(to);
			payment.setReceipt(receipt);
			
			
			try {
				String res1=deAzzleAPIS.sendPost(access, "receipt/", PaymentConverter.toJsonString(payment), "POST");
				System.out.println("---------------------------"+res1);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	    session.setAttribute("date",MyFunction.date());
    		session.setAttribute("TxStatus","Success");
    		session.setAttribute("paymentMode","");
		

		return "redirect:/redirection-url/"+data1.get("udf1") +"-"+data1.get("txnid")+"-"+data1.get("firstname");
    	
	}
	@RequestMapping(value="/pay-easebuzz" , method = RequestMethod.POST)
	public  String payeasebuzz(Model model,HttpServletRequest request,HttpSession session  ){

		System.out.println("Coming");

		Map data=(ModelMap)session.getAttribute("data");
		Object object_id=(Object)session.getAttribute("object_id");
		
		
		//TransactionMaster tx=(TransactionMaster) data.get("tx");
		
		
		
		Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+data.get("keyurl")+"' and  m.merchant_key='"+data.get("udf1")+"'");

		String merchant_key = GetWay_Keys.Key;
        String salt = GetWay_Keys.Salt;
        
        EaseBuzz[] key = null;
		try {
			key = Converter.fromJsonString(keys.getway_keys);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
		String sub_merchant_id=key[0].getSubMerchantID();

        String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";    

        
        System.out.println("First Name --------"+data.get("firstname")+"");
        
		   Map<String, String> params = new HashMap<String, String>();
		   params.put("productinfo",data.get("productinfo")+"");
		   params.put("firstname", data.get("firstname")+"");
		   params.put("email", data.get("email")+"");
		   params.put("phone", data.get("phone")+"");
		   
		   params.put("surl", GetWay_Keys.EASYBUZZ_SUCCESS_URL+"ebsresponse");
		   params.put("furl", GetWay_Keys.EASYBUZZ_FAIL_URL+"ebfresponse");
		   
		   params.put("amount", data.get("amount")+"");
		   params.put("txnid", data.get("txnid")+"");
		   params.put("udf1", data.get("udf1")+"");
		   params.put("udf2", data.get("udf2")+"");
		   String validity=data.get("validity")+"";
			try {
					if(validity==null)
						validity="0";
					if(validity.equals("N/A"))
						validity="0";
					//System.out.println("validity=\"0\";     "+validity);
			}catch(NullPointerException n) {validity="0";}
			
		   
		   params.put("udf3", validity);
		   params.put("udf4", object_id+"");
		   params.put("udf5", data.get("userId")+"");
		   params.put("udf6", "");
		   params.put("udf7", "");
		   params.put("udf8", "");
		   params.put("udf9", "");
		   params.put("udf10", "");
		   params.put("key",merchant_key);

		   
	      
	        String base_url ="";
	        if(GetWay_Keys.BaseURL.equals("prod")){
	            base_url = "https://pay.easebuzz.in/";
	        }else{
	            base_url = "https://testpay.easebuzz.in/";
	        }
	        String hashString = "";
	        String hash = "";
	        int error = 0;
	        if (GetWay_Keys.empty(merchant_key)) {
                error = 1;
            } else {
                String[] hashVarSeq = hashSequence.split("\\|");

                for (String part : hashVarSeq) {
                	hashString = (GetWay_Keys.empty(params.get(part))) ? hashString.concat("") : hashString.concat(params.get(part));
                	//System.out.println("hashString FOR->"+hashString);

                	hashString = hashString.concat("|");
                    
                }
                 //System.out.println("hashString->"+hashString);
                
                hashString = hashString.concat(salt);
                

                hash = GetWay_Keys.Easebuzz_Generatehash512("SHA-512", hashString);
                params.put("hash", hash);
                params.put("sub_merchant_id",sub_merchant_id);
                System.out.println("hash->"+hash);
                
                System.out.println(params);
                
                try {
                
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> e : params.entrySet()) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
						sb.append(URLEncoder.encode(e.getKey().trim(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue().trim(), "UTF-8"));
                }

                URL url;
					url = new URL(base_url + "payment/initiateLink");
                
                System.out.println("URL: "+url);
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                PrintStream ps = new PrintStream(con.getOutputStream());
                ps.println(sb);
                ps.close();
                con.connect();
                StringBuilder res = new StringBuilder();
                if (con.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        res.append(line);
                    }
                    br.close();
                }
                con.disconnect();
                System.out.print(res);
				
                
                
                Object obj = new JSONParser().parse(res.toString());
                JSONObject jo = (JSONObject) obj;

                System.out.println("json: "+res.toString());
                if (jo.get("status").toString().equals("1")) {
                    //response.sendRedirect(base_url + "pay/" + jo.get("data").toString());
                	return "redirect:"+base_url + "pay/" + jo.get("data").toString();
                } else {
                    System.out.print(jo.get("data").toString());
                }
                
                
                
                } catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (org.json.simple.parser.ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

                
                
                

                
            }
		
		return "success";
	}
	
	
	
	@RequestMapping(value="/ebsresponse" , method = RequestMethod.POST)
	public  ModelAndView easybuzzrespose(Model model,HttpServletRequest request ,HttpSession session ){
		Map data1=(ModelMap)session.getAttribute("data");
	 	Merchant_Payment_keys keys=service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key='"+data1.get("udf1")+"'");
		
        String salt = GetWay_Keys.Salt;
		
		 //reverse hash matching while response
        
        Enumeration paramNames = request.getParameterNames();
        Map<String, String> params = new HashMap<String, String>();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String paramValue = ((String) request.getParameter(paramName)).trim();
            params.put(paramName, paramValue);
        }
        Map<String, String[]> parameters = request.getParameterMap();
        for (String parameter : parameters.keySet()) {
            params.put(parameter, parameters.get(parameter)[0].toString());
        }
        params.put("salt", salt);
        params.put("status", request.getParameter("status"));
        String hashString = "";
        String hash = "";

        String hashSequence = "salt|status|udf10|udf9|udf8|udf7|udf6|udf5|udf4|udf3|udf2|udf1|email|firstname|productinfo|amount|txnid";

        String[] hashVarSeq = hashSequence.split("\\|");

        for (String part : hashVarSeq) {
            hashString = (GetWay_Keys.empty(params.get(part))) ? hashString.concat("") : hashString.concat(params.get(part));
            hashString = hashString.concat("|");
        }
        hashString = hashString.concat(request.getParameter("key"));
        hash = GetWay_Keys.Easebuzz_Generatehash512("SHA-512", hashString);

        String responseHash = request.getParameter("hash");
        if (hash.trim().equals(responseHash.trim())) {
            Map<String, String[]> parameters1 = request.getParameterMap();
            
            for (String parameter : parameters1.keySet()) {
                System.out.println(parameter + " : " + parameters1.get(parameter)[0].toString() + "");

            }
            
            
            TransactionMaster tx=new TransactionMaster();
            tx.setCustomer_email(data1.get("email")+"");
            tx.setCustomer_mobile(data1.get("phone")+"");
            tx.setCustomer_plan_name(data1.get("plan")+"");
            tx.setCustomer_userId(data1.get("userId")+"");
            tx.setMerchant_id(Long.parseLong(data1.get("udf1")+""));
            tx.setTransaction_update_date(new Date());
            tx.setTransaction_created_date(new Date());
            tx.setTransaction_amount(Float.parseFloat(data1.get("amount1")+""));
            tx.setTransaction_order_id(request.getParameter("txnid"));
            //tx.setTransaction_payment_response(params.toString());
    		tx.setTransaction_status(request.getParameter("status"));
    		System.out.println("RESPONSE  :  "+ new Gson().toJson(params));
    		String payment_mode;
    		try {
    			if(request.getParameter("mode").equals("DC")) {
    				tx.setTransaction_payment_mode("DEBIT_CARD");payment_mode="DEBIT_CARD";}
    			if(request.getParameter("mode").equals("CC")){
    				tx.setTransaction_payment_mode("CREDIT_CARD"); payment_mode="CREDIT_CARD";}
    			if(request.getParameter("mode").equals("NB")) {
    				tx.setTransaction_payment_mode("NET_BANKING"); payment_mode="NET_BANKING";}
    			if(request.getParameter("mode").equals("MW")) {
    				tx.setTransaction_payment_mode("Mobile_Wallet"); payment_mode="Mobile_Wallet";}

    			else {
    			tx.setTransaction_payment_mode(request.getParameter("mode"));
    			payment_mode=request.getParameter("mode");
    			
    			}
    			
    		}catch(NullPointerException n) {
    			payment_mode=request.getParameter("mode");
        			
    			tx.setTransaction_payment_mode(request.getParameter("mode"));
    			
    		}
    		
    		
    		
    		
    		
    		
    		
    		
            
            String status;
            try {
            	if("success".equalsIgnoreCase(request.getParameter("status"))) {
            		tx.setTransaction_status("SUCCESS");
            		status="Success";
            	}else {
            		tx.setTransaction_status(request.getParameter("status"));
            		status=request.getParameter("status");
            		        	
            	}
            }catch (NullPointerException e) {
        		tx.setTransaction_status(request.getParameter("status"));
        		status=request.getParameter("status");
            }
            
            String access=(String)session.getAttribute("accesstoken");
            
            String data="        {\r\n" + 
            		"          \"payment_status\":\""+status+"\",\r\n" + 
            		"          \"easepayid\":\""+request.getParameter("easepayid")+"\",\r\n" + 
            		"          \"Payment_mode\":\""+payment_mode+"\"\r\n" + 
            		"        }";
            
            try {
				String res=deAzzleAPIS.sendPost(access, "payment/"+request.getParameter("udf4")+"/", data, "PUT");
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            
            /*Recipt
             * 
*/            

			Payment payment=new Payment();
			From from=new From();
			To to=new To();
			Business business=new Business();
			Person person=new Person();
			person.setPhoneNumber(mobile(data1.get("phone")+""));
			from.setPerson(person);
			business.setPhoneNumber(mobile(data1.get("merchantMobile")+""));
			to.setBusiness(business);

			Receipt receipt =new Receipt();
			
			receipt.setAmount_received((int)Float.parseFloat(data1.get("amount")+""));
			receipt.setHttp_referrer("outgo");
			receipt.setPayment_mode(payment_mode);
			receipt.setPayment_Ref_Id(request.getParameter("udf4"));
			receipt.setReceipt_date(new Date()+"");
			receipt.setReceipt_description(data1.get("plan")+"");
			receipt.setStatus(status);
			payment.setFrom(from);
			payment.setTo(to);
			payment.setReceipt(receipt);
			
			
			try {
				String res1=deAzzleAPIS.sendPost(access, "receipt/", PaymentConverter.toJsonString(payment), "POST");
				System.out.println("---------------------------"+res1);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
    		//tx=service.saveCustomerTransaction(tx);
    		
    		
    		
    		
    		
    		
    		
    		
			    ALL all=service.getData("select cl.mobileNo,cl.email, m.service,m.expiry_date\r\n" + 
			    		" from   Contact_login cl\r\n" + 
			    		", Merchant_Info m where  cl.merchantId=m.merchantId and cl.merchantId="+data1.get("udf1")+" and cl.mobileNo='"+data1.get("merchantMobile")+"'");     			
		        Settings settings=service.getSetting("select * from Settings s where s.merchant_id="+tx.getMerchant_id());     			
    		
    		paymentEmails(tx, all, settings, request.getParameter("firstname"),data1.get("businessName")+"");
    		
    		autorenew(request.getParameter("udf3"), keys, tx);
    		
    		
    		
    	    request.setAttribute("keys",keys);
    		request.setAttribute("firstName",request.getParameter("firstname"));
    		request.setAttribute("amount",tx.getTransaction_amount());
    		request.setAttribute("TxId",request.getParameter("txnid"));
    		request.setAttribute("txnDateTime",tx.getTransaction_created_date());
    		request.setAttribute("TxStatus",request.getParameter("status"));
    		request.setAttribute("email",tx.getCustomer_email());
    		request.setAttribute("paymentMode",payment_mode);
    		request.setAttribute("action",keys.getReturn_url());
    		request.setAttribute("method",keys.getForm_method());
    	    session.setAttribute("date",MyFunction.date());
    		session.setAttribute("TxStatus",status);
    		session.setAttribute("paymentMode",payment_mode);

    		
    		insertInteraction(tx.getCustomer_email(),request.getParameter("firstname"),tx.getCustomer_mobile(), tx.getMerchant_service_id(),tx.getMerchant_id(),tx.getTransaction_status(),tx.getTransaction_type()+" Payment",tx.getTransaction_id(),"Transaction"); 
    		ModelAndView mav = new ModelAndView();
    		mav.setViewName("redirect:/redirection-url/"+tx.getMerchant_id()+"-"+tx.getTransaction_order_id()+"-"+request.getParameter("firstname"));
    		    return mav;
            
        } else {
        	 System.out.println("something wrong happend");

        }


      return null;

	}
	

	
	@RequestMapping(value="/ebfresponse" , method = RequestMethod.POST)
	public  ModelAndView easybuzzfrespose(Model model,HttpServletRequest request ,HttpSession session ){
		Map data1=(ModelMap)session.getAttribute("data");
	 	Merchant_Payment_keys keys=service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key='"+data1.get("udf1")+"'");
		
        String salt = GetWay_Keys.Salt;
		
		 //reverse hash matching while response
        
        Enumeration paramNames = request.getParameterNames();
        Map<String, String> params = new HashMap<String, String>();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String paramValue = ((String) request.getParameter(paramName)).trim();
            params.put(paramName, paramValue);
        }
        Map<String, String[]> parameters = request.getParameterMap();
        for (String parameter : parameters.keySet()) {
            params.put(parameter, parameters.get(parameter)[0].toString());
        }
        params.put("salt", salt);
        params.put("status", request.getParameter("status"));
        String hashString = "";
        String hash = "";

        String hashSequence = "salt|status|udf10|udf9|udf8|udf7|udf6|udf5|udf4|udf3|udf2|udf1|email|firstname|productinfo|amount|txnid";

        String[] hashVarSeq = hashSequence.split("\\|");

        for (String part : hashVarSeq) {
            hashString = (GetWay_Keys.empty(params.get(part))) ? hashString.concat("") : hashString.concat(params.get(part));
            hashString = hashString.concat("|");
        }
        hashString = hashString.concat(request.getParameter("key"));
        hash = GetWay_Keys.Easebuzz_Generatehash512("SHA-512", hashString);

        String responseHash = request.getParameter("hash");
        if (hash.trim().equals(responseHash.trim())) {
            Map<String, String[]> parameters1 = request.getParameterMap();
            for (String parameter : parameters1.keySet()) {
                System.out.println(parameter + " : " + parameters1.get(parameter)[0].toString() + "");

            }
          
            String status;
            try {
            	if("userCancelled".equals(request.getParameter("status"))) {
            		status="CANCELED";
            	}else {
            		status=request.getParameter("status");
            		        	
            	}
            }catch (NullPointerException e) {
        		status=request.getParameter("status");
            }
            
            String access=(String)session.getAttribute("accesstoken");
            
            String data="        {\r\n" + 
            		"          \"payment_status\":\""+status+"\",\r\n" + 
            		"          \"easepayid\":\""+request.getParameter("easepayid")+"\"\r\n" + 
            		"        }";
            
            try {
				String res=deAzzleAPIS.sendPost(access, "payment/"+request.getParameter("udf4")+"/", data, "PUT");
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    	    request.setAttribute("keys",keys);
    		//request.setAttribute("firstName",request.getParameter("firstname"));
    		//request.setAttribute("amount",data1.get("amount1"));
    		//request.setAttribute("TxId",request.getParameter("txnid"));
    	    session.setAttribute("date",MyFunction.date());
    		session.setAttribute("TxStatus",status);
    		session.setAttribute("paymentMode","");
    		//request.setAttribute("email",data1.get("email"));

    		//request.setAttribute("action",keys.getReturn_url());
    		//request.setAttribute("method",keys.getForm_method());
    		//insertInteraction(data1.get("email"),request.getParameter("firstname"),data1.get("phone"), 0,data1.get("udf1"),status,"Online"+" Payment",0,"Transaction"); 
    		ModelAndView mav = new ModelAndView();
    		mav.setViewName("redirect:/redirection-url/"+data1.get("udf1")+"-"+data1.get("txnid")+"-"+request.getParameter("firstname"));
    		    return mav;
            
        } else {
        	 System.out.println("something wrong happend");

        }


      return null;

	}

	
	
	@RequestMapping(value="/redirect" )
	public  ModelAndView redirect(Model model,HttpServletRequest request ){
		
		//System.out.println("Print 1:  Coming First");
		ModelAndView mav = new ModelAndView();
		
		String TxId=request.getParameter("TxId");
		String pgRespCode=request.getParameter("pgRespCode");
		String amount=request.getParameter("amount");
		String TxMsg=request.getParameter("TxMsg");
		String signature=request.getParameter("signature");
		String TxStatus=request.getParameter("TxStatus");
		String paymentMode=request.getParameter("paymentMode");
		String txnDateTime=request.getParameter("txnDateTime");
		String cardHolderName=request.getParameter("cardHolderName");
		String maskedCardNumber=request.getParameter("maskedCardNumber");
		String TxRefNo=request.getParameter("TxRefNo");
		String pgTxnNo=request.getParameter("pgTxnNo");
		String firstName=request.getParameter("firstName");
		String email=request.getParameter("email");
		String txnStatus=request.getParameter("TxStatus");		
		String validity=request.getParameter("addressStreet1");
		String marketplaceTxId=request.getParameter("marketplaceTxId");
		String data = null;
		String issuerRefNo=request.getParameter("issuerRefNo");
		String authIdCode=request.getParameter("authIdCode");
		String id=request.getParameter("lastName");		
		
		if (TxId != null) {
            data += TxId;
        }
        if (txnStatus != null) {
            data += txnStatus;
        }
        if (amount != null) {
            data += amount;
        }
        if (pgTxnNo != null) {
            data += pgTxnNo;
        }
        if (issuerRefNo != null) {
            data += issuerRefNo;
        }
        if (authIdCode != null) {
            data += authIdCode;
        }
        if (firstName != null) {
            data += firstName;
        }
        if (id != null) {
            data += id;
        }
        if (pgRespCode != null) {
            data += pgRespCode;
        }
        if (amount != null) {
            data += amount;
        }
        //System.out.println("Print 2: "+ data);

		
		
		TransactionMaster tx=service.getTransaction(TxId);		
		
		 data=pgRespCode+";;"+TxMsg+";;"+signature+";;"+txnDateTime+";;"+cardHolderName+";;"+maskedCardNumber+";;"+TxRefNo+";;"+pgTxnNo+";;"+marketplaceTxId;
		
		tx.setTransaction_payment_response(data);
		 tx.setTransaction_payment_mode(paymentMode);
		//System.out.println("Print 3: "+ new Gson().toJson(tx));
		try {
			
	    if(txnStatus.equalsIgnoreCase("Success")) {
	    	txnStatus="SUCCESS";
	        tx.setTransaction_status(txnStatus);
	       
	    }else {    	
	    if(! tx.getTransaction_status().equals("Pending"))
	    	   tx.setTransaction_status(txnStatus);    
	    else
	    	tx.setTransaction_payment_mode(tx.getTransaction_payment_mode());	
	    }}catch (NullPointerException e) {
	    	 tx.setTransaction_status(txnStatus);    
		}
		
		tx.setMarketplaceTxId(marketplaceTxId);
	     	
	 	tx=service.saveCustomerTransaction(tx);
	 	Merchant_Payment_keys keys=service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key='"+tx.getMerchant_id()+"'");
	   	     
	     try {
	     	if (txnStatus != null) {
	     		if(txnStatus.equals("SUCCESS")) {
	     			
	     			
	     			
	     			    ALL all=service.getData("select cl.mobileNo,cl.email,msdm.merchant_business_name,msdm.merchant_service_logo ,sm.service_name\r\n" + 
	    					"from Transaction_Master tx,Merchant_Service_Detail_Master msdm,Contact_login cl,Service_Master sm where tx.transaction_order_id='"+tx.getTransaction_order_id()+"'\r\n" + 
	    					" and msdm.merchant_service_id=tx.merchant_service_id \r\n" + 
	    					" and cl.id=msdm.contact_id\r\n" + 
	    					" and sm.service_id=msdm.service_code");     			
	     		        	Settings settings=service.getSetting("select * from Settings s where s.merchant_id="+tx.getMerchant_id());     			
		        			ALL m = service.info("select m.expiry_date,m.service from Merchant_Info m where merchantId='" + tx.getMerchant_id() + "'");
		        			String msg=null;
		        			
		        			//System.out.println("Email Merchant ---------------------------------------");
		        		          String merchantMail=MyFunction.merchantEmail;
			        			  merchantMail=merchantMail.replace("[M-NAME]", all.getMerchant_business_name());		
			        			  merchantMail=merchantMail.replace("[AMOUNT]", tx.getTransaction_amount()+"");	        					
			        			  merchantMail=merchantMail.replace("[ORDER-ID]", TxId);		
			        			 	
			        			  merchantMail=merchantMail.replace("[PRICE]", tx.getTransaction_amount()+"");
			        			  merchantMail=merchantMail.replace("[TOTAL-PRICE]",tx.getTransaction_amount()+"");
			        			  
			        			  merchantMail=merchantMail.replace("[NAME]", firstName);		
			        			  		
			        			  merchantMail=merchantMail.replace("[MOBILE]", tx.getCustomer_mobile());		  
			        			  merchantMail=merchantMail.replace("[EMAIL]", tx.getCustomer_email());		
			        			  merchantMail=merchantMail.replace("[T-DATE]", txnDateTime);   
			        			  
			        			/*String table="                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			        							"                                    <tr>\n" + 
			        							"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
			        							"                                            <p style=\"font-weight: 800;\">Download Receipt </p>\n" + 
			        							"                                            <p>\n";
			        			String table1=  "	                                         <a href=\"www.outgo.co/invoice-"+TxId+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;     width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #269fff; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Download</a>\n";
			        			String table2= 	"                                            </p>\n" + 
			        							"                                        </td>\n" + 
			        							"                                    </tr>\n" + 
			        							"                                </table>\n";*/
			        			  String table="                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
		        							"                                    <tr>\n" + 
		        							"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
		        							"                                            <p style=\"font-weight: 800;\">Download. </p>\n" + 
		        							"                                            <p>\n <a href=\"https://smartbizapi.deazzle.in/invoice-"+TxId+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;text-align: center; width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #1b8a79; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Recipt</a>\n<br/>";
			        			  String table1=null;
			        			  if(settings.isRecipt()) { 
			        				  table1=  "	                                         <a href=\"https://smartbizapi.deazzle.in/receipt-"+TxId+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;text-align: center; width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #1b8a79; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Invoice</a>\n";
			        			  }else {
			        				  table1="<br>";
			        			  }
		        			String table2= 	"                                            </p>\n" + 
		        							"                                        </td>\n" + //www.outgo.co //192.168.0.102:8080/outgo/receipt-"+TxId+"-smartBiz
		        							"                                    </tr>\n" + 
		        							"                                </table>\n";
			        			
			        			   //System.out.println("Email Code finish");
				        			 
				        			 
				        			  try {
				        				  merchantMail=merchantMail.replace("[ID]", tx.getCustomer_userId()); //error
				        			}catch(NullPointerException e) {
				        				merchantMail=merchantMail.replace("[ID]","-"); //error
				        					//System.out.println("----Email user Ex ---------------------------------------"+e);
				        			}
				        			  

				        			  try {
				        				  merchantMail=merchantMail.replace("[DESCRIPTION]", tx.getCustomer_plan_name());//error
				        			}catch(NullPointerException e) {
				        				merchantMail=merchantMail.replace("[DESCRIPTION]", "-");//error
				        			}
				        			  /*---------------------------------------------! Merchant-------------------------------------------------------	*/
				        			  //System.out.println("------------------------------------Mail Start-----------------------------------");
					        			 String userMail=MyFunction.userEmail;		  
					        			
					        			
					        			  userMail=userMail.replace("[CUSTOMER-NAME]", firstName);		
					        			  userMail=userMail.replace("[AMOUNT]", tx.getTransaction_amount()+"");	        					
					        			  userMail=userMail.replace("[ORDER-ID]", TxId);		
					        			  		
					        			  userMail=userMail.replace("[PRICE]", tx.getTransaction_amount()+"");
					        			  userMail=userMail.replace("[TOTAL-PRICE]",tx.getTransaction_amount()+"");	  
					        			  userMail=userMail.replace("[M-NAME]", all.getMerchant_business_name());		
					        					
					        			  userMail=userMail.replace("[M-MOBILE]", all.getMobileNo());		  
					        			  userMail=userMail.replace("[M-EMAIL]", all.getEmail());		
					        			  userMail=userMail.replace("[T-DATE]", txnDateTime);	
					        			  
					        			  msg="Dear Customer, your payment of Rs."+tx.getTransaction_amount()+" to "+all.getMerchant_business_name()+" has been successful. Payment reference is "+tx.getTransaction_order_id()+".Thank you. deAzzle";
						        			MyFunction.sendSMS(tx.getCustomer_mobile(), msg,  Link.SELF_SMS_LINK);
					        			 
					        			  try {
					        				  userMail=userMail.replace("[ID]", tx.getCustomer_userId()); //error
					        			}catch(NullPointerException e) {
					        				 userMail=userMail.replace("[ID]","-"); //error
					        			}
					        			 

					        			  try {
					        				  userMail=userMail.replace("[DESCRIPTION]", tx.getCustomer_plan_name());//error
					        			}catch(NullPointerException e) {
					        				userMail=userMail.replace("[DESCRIPTION]", "-");//error
					        			}
					        			  if(settings.isInvoice_email()==true) {
					        				  userMail=userMail.replace("[TABLE]", "<table>&nbsp</table>");	 
					        				 
					        				 
						        			  }else {
						        				  userMail=userMail.replace("[TABLE]", table+table1+table2);
						        			  }
					        			  MyFunction.Email(tx.getCustomer_email(),  "Payment for "+all.getMerchant_business_name(), userMail);
					        			 			
					        			  try {
					        				  if(m.equals(null)) {
		        					
		        				}else {
		        					int diff = AppController.dateDiff2(m.getExpiry_date());
				        			if (diff < 0) {				        				
				        				
				        				if(m.getService().equals("Pay As You Go")) {
				        					msg="You have received a payment of Rs. "+tx.getTransaction_amount()+" from: "+firstName+", userid :"+tx.getCustomer_userId()+" , plan :"+tx.getCustomer_plan_name()+" ,contact no. : "+tx.getCustomer_mobile()+". Thx. deAzzle";
						        			 
						        			/* SMSThread s1=new SMSThread(all.getMobileNo(), msg, Link.SELF_SMS_LINK);	s1.start();*/ 
						        			
						        			MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
						        			MyFunction.Email(all.getEmail(),  "Payment of "+firstName, merchantMail);
				        					
				        				}else {
				        					//System.out.println("diffff" + diff);// Expired (false)
					        				 msg="Dear Customer, you have received a payment. To view the details, please renew the deAzzle Smartbiz subscription at https://www.deazzle.in/ .Thankyou, deAzzle";
					        				MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
					        				MyFunction.Email(all.getEmail(),  "Payment of "+firstName, msg);
				        				}
				        				
				        			} else {
				        				// Not Expired (true)   					        				 
				        				
					        			msg="You have received a payment of Rs. "+tx.getTransaction_amount()+" from: "+firstName+", userid :"+tx.getCustomer_userId()+" , plan :"+tx.getCustomer_plan_name()+" ,contact no. : "+tx.getCustomer_mobile()+". Thx. deAzzle";
					        			/* SMSThread s1=new SMSThread(all.getMobileNo(), msg, Link.SELF_SMS_LINK);	s1.start();*/ 
					        			
					        			MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
					        			MyFunction.Email(all.getEmail(),  "Payment of "+firstName, merchantMail);
				        			}
		        				}
							} catch (NullPointerException e) {
								
							}
		        			
		        			 
		        			/*	SMSThread s=new SMSThread(tx.getCustomer_mobile(), msg, Link.SELF_SMS_LINK);
		        			s.start();*/	
		        			
		        			
		        					
		        			
		        	/*		String merchantEmail="<div style='background:#ffffff'><div class='adM'> </div><table class='m_-6717598879372283451main' align='center' cellpadding='0' cellspacing='0'> <tbody><tr> <td> <div style='border:1px solid #eaeaea;width:452px;float:left'> <div style='width:100%;margin:auto;padding:27px 0 30px 0;overflow:hidden'> <img height='50' width='100' src='https://s3.ap-south-1.amazonaws.com/image-ssl/ssl/comodo_secure_seal_113x59_transp.png' style='float:right;margin-right:34px' class='CToWUd'> <img width='60' height='60' src='https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/263.png' style='float:left;margin:3px 0 0 34px' class='CToWUd'> </div> <div style='background:hsla(187, 100%, 42%, 0.23);color:#5b5b5b;font-family:'Open Sans',Arial,sans-serif;font-size:13px;width:90%;line-height:17px;clear:both;padding:35px 5%;float:left'> <div style='width:100%;float:left;padding:0 0 45px 0'> <div style='width:140px;float:left;font-size:11px;text-align:center;color:#4e4e4e'> Transaction ID <span style='font-weight:600;display:block;color:#252525'>"+tx.getTransaction_order_id()+"</span> </div> <div style='width:140px;float:right;font-size:11px;text-align:center;color:#4e4e4e'> Transaction Date <span style='font-weight:600;display:block;color:#252525'>"+tx.getTransaction_created_date()+"</span> </div> </div> <div> <table cellpadding='0' cellspacing='0' border='0'> <tbody><tr> <td style='width:50px'> <img height='70' width='70' src='https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/inr.png' style='float:left' class='CToWUd'></td> <td> <div style='float:left;margin:3px 0 0 28px;font-size:22px;line-height:29px;font-weight:100;color:#000000'> payment of <span style='color:#00b0de;padding-left:5px;font-weight:600'>Rs."+tx.getTransaction_amount()+" </span> from <span style='font-weight:400;color:#00b0de'> "+firstName+" </span><span> has been successful.</span> <span style='font-size:15px;clear:both;display:block;padding-top:10px;font-weight:100;color:#000000'><a href='http://payapi.outgo.co/invoice-"+tx.getTransaction_order_id()+"-smartBiz' style=' background-color:#5DBCC7; border: none;color: white;padding: 15px 30px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius: 8px;'>Download invoice </a> <span style='font-weight:400'></span></span> </div> </td> </tr> </tbody></table> </div> </div> <div style='line-height:17px;clear:both;padding:55px 48px 0 48px;text-align:left;font-family:'Open Sans',Arial,sans-serif;font-size:14px;color:#222222;font-weight:100'> <b>Terms & Conditions</b> <br><br> 1) Plans renewal is Not Refundable<br> 2) Plan Once Renewed can not be changed<br> 3) Data plan can not be renewed in advance<br> 4) After office hour payment, account will be recharged within 24 hrs.<br> </div><br> <div style='background:#33E9FF;height:10px'></div> <div style='background:black;height:10px;border-bottom:1px solid #eaeaea'></div> </div> </td> </tr> <tr> <td> <table width='452' border='0' cellspacing='0' cellpadding='0' style='padding:15px 5px'> <tbody><tr> <td style='font-family:'Open Sans',Arial,sans-serif,Arial,sans-serif;font-size:12px'> <div style='float:left;width:50%' class='m_-6717598879372283451downInfo'> <a hrfe='https://goo.gl/khHxWA'> Download OutGo App </a><div style='width:40%;display:inline-block'> <a style='vertical-align:middle;padding:0 0 0 4%;display:inline-block' href='https://goo.gl/khHxWA' target='_blank'  width='12' height='14' border='0' class='CToWUd'></a> </div> </div> <div style='float:right' class='m_-6717598879372283451downInfo'> Need Help?<a href='https://www.outgo.co/contactUs' style='color:#00b0de;font-size:12px;text-decoration:none;padding-left:5px' target='_blank' >Reach us here.</a> </div> </td> </tr> </tbody></table> </td> </tr> <tr> <td style='text-align:center;font-family:Open Sans,Arial,sans-serif,Arial,sans-serif;font-size:12px'>Copyright � 2016 OutGo Payment Solution Pvt. Ltd.<td> </tr> </tbody></table> </div>";
		        			String userEmail="<div style='background:#ffffff'><div class='adM'> </div><table class='m_-6717598879372283451main' align='center' cellpadding='0' cellspacing='0'> <tbody><tr> <td> <div style='border:1px solid #eaeaea;width:452px;float:left'> <div style='width:100%;margin:auto;padding:27px 0 30px 0;overflow:hidden'> <img height='50' width='100' src='https://s3.ap-south-1.amazonaws.com/image-ssl/ssl/comodo_secure_seal_113x59_transp.png' style='float:right;margin-right:34px' class='CToWUd'> <img width='60' height='60' src='https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/263.png' style='float:left;margin:3px 0 0 34px' class='CToWUd'> </div> <div style='background:hsla(187, 100%, 42%, 0.23);color:#5b5b5b;font-family:'Open Sans',Arial,sans-serif;font-size:13px;width:90%;line-height:17px;clear:both;padding:35px 5%;float:left'> <div style='width:100%;float:left;padding:0 0 45px 0'> <div style='width:140px;float:left;font-size:11px;text-align:center;color:#4e4e4e'> Transaction ID <span style='font-weight:600;display:block;color:#252525'>"+tx.getTransaction_order_id()+"</span> </div> <div style='width:140px;float:right;font-size:11px;text-align:center;color:#4e4e4e'> Transaction Date <span style='font-weight:600;display:block;color:#252525'>"+tx.getTransaction_created_date()+"</span> </div> </div> <div> <table cellpadding='0' cellspacing='0' border='0'> <tbody><tr> <td style='width:50px'> <img height='70' width='70' src='https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/263.png' style='float:left' class='CToWUd'></td> <td> <div style='float:left;margin:3px 0 0 28px;font-size:22px;line-height:29px;font-weight:100;color:#000000'> payment of <span style='color:#00b0de;padding-left:5px;font-weight:600'>Rs."+tx.getTransaction_amount()+" </span> to <span style='font-weight:400;color:#00b0de'> OutGo smartBiz </span><span> has been successful.</span> <span style='font-size:15px;clear:both;display:block;padding-top:10px;font-weight:100;color:#000000'><a href='http://payapi.outgo.co/invoice-"+tx.getTransaction_order_id()+"-smartBiz' style=' background-color:#5DBCC7; border: none;color: white;padding: 15px 30px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius: 8px;'>Download invoice </a> <span style='font-weight:400'></span></span> </div> </td> </tr> </tbody></table> </div> </div> <div style='line-height:17px;clear:both;padding:55px 48px 0 48px;text-align:left;font-family:'Open Sans',Arial,sans-serif;font-size:14px;color:#222222;font-weight:100'> <b>Terms & Conditions</b> <br><br> 1) Plans renewal is Not Refundable<br> 2) Plan Once Renewed can not be changed<br> 3) Data plan can not be renewed in advance<br> 4) After office hour payment, account will be recharged within 24 hrs.<br> </div><br> <div style='background:#33E9FF;height:10px'></div> <div style='background:black;height:10px;border-bottom:1px solid #eaeaea'></div> </div> </td> </tr> <tr> <td> <table width='452' border='0' cellspacing='0' cellpadding='0' style='padding:15px 5px'> <tbody><tr> <td style='font-family:'Open Sans',Arial,sans-serif,Arial,sans-serif;font-size:12px'> <div style='float:left;width:50%' class='m_-6717598879372283451downInfo'><a href='https://goo.gl/khHxWA'> Download OutGo App </a><div style='width:40%;display:inline-block'> <a style='vertical-align:middle;padding:0 0 0 4%;display:inline-block' href='https://goo.gl/khHxWA' target='_blank' ><img src='https://ci3.googleusercontent.com/proxy/yzmiEYvJ_grraMXxKwbTfDVh4E3J4kCSyyLWG8kTS9Hk04fX213Ix9OzXyWadIAU7QqtiN6x6f8ojSTF7cLQTchzY7YEkLdtxthErqijeWPryo_5GvjBUMGL72SpZ7eyc0NOtMJVI5LsTlc9Ona89ErkITOq=s0-d-e1-ft#https://s3-ap-southeast-1.amazonaws.com/assets.outgo.co/promotion/Aziz/folder/android_logo.png' width='12' height='14' border='0' class='CToWUd'></a> </div> </div> <div style='float:right' class='m_-6717598879372283451downInfo'> Need Help?<a href='https://www.outgo.co/contactUs' style='color:#00b0de;font-size:12px;text-decoration:none;padding-left:5px' target='_blank' >Reach us here.</a> </div> </td> </tr> </tbody></table> </td> </tr> <tr> <td style='text-align:center;font-family:Open Sans,Arial,sans-serif,Arial,sans-serif;font-size:12px'>Copyright � 2016 OutGo Payment Solution Pvt. Ltd.<td> </tr> </tbody></table> </div>";
		        			 MyFunction.Email(tx.getCustomer_email(),  "Payment for "+all.getMerchant_business_name(), userEmail);
		        			 MyFunction.Email(all.getEmail(),  "Payment To "+firstName, merchantEmail);
		        		*/
		        			
		        			
		        			
		        			
		        		
		        			  //================================ New ==================================       
					         
					          
					        
					         MerchantCustomerMaster reg=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+tx.getCustomer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" and m.merchant_service_id="+tx.getMerchant_service_id());
					        try {
		        		    	 if(reg!=null) {			        		    	 
			        		       		    	 reg.setStatus(true);
			        		       		    	reg=service.saveRegisterCustomer(reg);
			        		       		    	}
			        		     
							} catch (NullPointerException e) {	} 
					         
		        		     if(keys.isAuto_renual()==true) { 
		        		    	 
		        		    	 MerchantCustomerMaster regCust=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+tx.getCustomer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" and m.merchant_service_id="+tx.getMerchant_service_id());
		        		    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      	 
		        			       	Calendar cal3 = Calendar.getInstance();   	
		        			       	//System.out.println("in Auto renual mode---"+validity);
		        					
		        					//System.out.println("in Auto renual mode and json customer---"+new Gson().toJson(regCust));
		        					String date1 =formatter.format(cal3.getTime());
		        					String date2 =regCust.getMerchant_customer_plan_expire_date();
		        					//System.out.println("in Auto renual  date1---"+date1);
		        					//System.out.println("in Auto expire date2---"+regCust.getMerchant_customer_plan_expire_date());
		        					
		        					try {
		        							if(validity==null)
		        								validity="0";
		        							//System.out.println("validity=\"0\";     "+validity);
		        					}catch(NullPointerException n) {validity="0";}
		        					
		        					
		        					 try {
		        						 if(!regCust.getMerchant_customer_user_id().equals("new")) {
		        							 //System.out.println("--------------------------is new---------------------------------------");
		        						 
		        						 if(regCust.getMerchant_customer_plan_expire_date().equals(null)|| regCust.getMerchant_customer_plan_expire_date()==null || regCust.getMerchant_customer_plan_expire_date().isEmpty())
		        							{
		        								
		        								
		        							}else {
		        								 if(date1.compareTo(date2)>0){				 
		        									 //System.out.println("Date1 is after Date2");
		        									 date2=date1;
		        									 int validity3=Integer.parseInt(validity);
		        							 			Date date = null;
		        										try {
		        											date = formatter.parse(date2);
		        										} catch (ParseException e) {
		        											// TODO Auto-generated catch block
		        											e.printStackTrace();
		        										}
		        						 				Calendar cal = Calendar.getInstance();
		        						 				cal.setTime(date);
		        						 		        cal.add(cal.DATE, validity3);// setting value to cal 
		        						 		       date2=formatter.format(cal.getTime());
		        									 //System.out.println("renual date-->"+date1+"----Expire Date---->>"+date2);
		        									 
		        									 
		        									 
		        								 }else  if(date1.compareTo(date2)<0){
		        									 
		        									 //System.out.println("Date1 is before Date2");
		        									 date1=date2;
		        							 			int validity3=Integer.parseInt(validity);
		        							 			Date date = null;
		        										
		        											try {
		        												date = formatter.parse(date2);
		        											
		        										
		        						 				Calendar cal = Calendar.getInstance();
		        						 				cal.setTime(date);
		        						 		        cal.add(cal.DATE, validity3);// setting value to cal 
		        						 		       date2=formatter.format(cal.getTime());
		        						 		      //System.out.println("renual date-->"+date1+"----Expire Date---->>"+date2);
		        						 		    
		        											} catch (ParseException e) {
		        												// TODO Auto-generated catch block
		        												e.printStackTrace();
		        											}
		        									 
		        								 }else
		        								 {
		        									 //System.out.println("Both Dates are equal");
		        									 
		        									 date2=date1;
		        							 			int validity3=Integer.parseInt(validity);
		        							 			Date date = null;
		        										try {
		        											date = formatter.parse(date2);
		        										} catch (ParseException e) {
		        											// TODO Auto-generated catch block
		        											e.printStackTrace();
		        										}
		        						 				Calendar cal = Calendar.getInstance();
		        						 				cal.setTime(date);
		        						 		        cal.add(cal.DATE, validity3);// setting value to cal 
		        						 		       date2=formatter.format(cal.getTime());
		        						 		      //System.out.println("renual date-->"+date1+"----Expire Date---->>"+date2);
		        						 		    
		        								 }
		        								
		        								//System.out.println("in else");
		        								
		        								  boolean c=service.update("update Merchant_Customer_Master m set m.merchant_customer_plan_expire_date='"+date2+"'"
		        						 		    		+ ",m.merchant_customer_plan_renew_date='"+date1+"',m.payment_status=true  where m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  
		        								  boolean txn=service.update("update Transaction_Master tm set tm.transaction_renew_date='"+date1+"'"
		        							 		   		+ ",tm.transaction_expire_date='"+date2+"',tm.transaction_active_status=true where tm.transaction_order_id='"+tx.getTransaction_order_id()+"'");
		        								
		        							}
		        						 }
		        						} catch (NullPointerException e) {
		        							try {
		        					 			
		        					 			Date date = null;	
		        					 			int validity3=Integer.parseInt(validity);
		        								date = formatter.parse(date1);
		        								Calendar cal = Calendar.getInstance();
		        									cal.setTime(date);
		        							        cal.add(cal.DATE, validity3-1);// setting value to cal 
		        							       String expDate=formatter.format(cal.getTime());
		        							       //System.out.println("Null Exception---"+date1+"--jjjjj---"+expDate);
		        						 		   
		        						 		    boolean c=service.update("update Merchant_Customer_Master m set m.merchant_customer_plan_expire_date='"+expDate+"'"
		        						 		    		+ ",m.merchant_customer_plan_renew_date='"+date1+"' ,m.payment_status=true where "
		        						 		    		+ " m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  
		        						 		   boolean txn=service.update("update Transaction_Master tm set tm.transaction_renew_date='"+date1+"'"
		        						 		   		+ ",tm.transaction_expire_date='"+expDate+"', tm.transaction_active_status=true  where tm.transaction_order_id='"+tx.getTransaction_order_id()+"'");
		        							} catch (ParseException e1) {
		        								e1.printStackTrace();
		        							}
		        						}
		        					
		        				     	
		        		     }else {
		        					MerchantCustomerMaster regCust=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+tx.getCustomer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" and m.merchant_service_id="+tx.getMerchant_service_id());

		        				    boolean c=service.update("update Merchant_Customer_Master m set m.payment_status=true where "
						 		    		+ " m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  
						
		        		    	
		        		     }
		        		    
		        		     
		        		     //===================================================================================
		        		       
		        		     //System.out.println("Print 4: "+"----------------------Out----------------------");
		        	
	     		}
	     	 		
	     	}
	     }catch(NullPointerException e) {}  
	     
	    request.setAttribute("keys",keys);
		request.setAttribute("firstName",firstName);
		request.setAttribute("amount",amount);
		request.setAttribute("TxId",TxId);
		request.setAttribute("txnDateTime",txnDateTime);
		request.setAttribute("TxStatus",request.getParameter("TxStatus"));
		request.setAttribute("email",email);
		request.setAttribute("paymentMode",paymentMode);
		request.setAttribute("action",keys.getReturn_url());
		request.setAttribute("method",keys.getForm_method());

		insertInteraction(tx.getCustomer_email(),firstName,tx.getCustomer_mobile(), tx.getMerchant_service_id(),tx.getMerchant_id(),tx.getTransaction_status(),tx.getTransaction_type()+" Payment",tx.getTransaction_id(),"Transaction"); 
		
		mav.setViewName("redirect:/redirection-url/"+tx.getMerchant_id()+"-"+tx.getTransaction_order_id()+"-"+firstName);
		    return mav;
		
	}

	
	
	
	
	
	@RequestMapping(value="/redirection-url/{merchantId}-{TxId}-{firstName}" ,method=RequestMethod.GET)
	public  ModelAndView redirectionurl(Model model,HttpServletRequest request,@PathVariable(value="merchantId")String merchantId,@PathVariable(value="TxId")String TxId,@PathVariable(value="firstName")String firstName,HttpSession  session  ){
		
		try {
	 	Merchant_Payment_keys keys=service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key='"+merchantId+"'");
		Map data1=(ModelMap)session.getAttribute("data");

		   request.setAttribute("keys",keys);
			request.setAttribute("firstName",firstName);
			request.setAttribute("amount",data1.get("amount1"));
			request.setAttribute("TxId",TxId);
			request.setAttribute("txnDateTime",session.getAttribute("date"));
			request.setAttribute("TxStatus",session.getAttribute("TxStatus"));
			request.setAttribute("email",data1.get("email"));
			request.setAttribute("paymentMode",data1.get("paymentMode"));
			request.setAttribute("action",keys.getReturn_url());
			request.setAttribute("method",keys.getForm_method());
			ModelAndView mav = new ModelAndView();
			
		if(data1.get("paymode").equals("SW"))
			mav.setViewName("ResponsePage");
		else if(data1.get("paymode").equals("RC"))
			mav.setViewName("ResponsePage");
		else if(data1.get("paymode").equals("UP")||data1.get("paymode").equals("SR")||data1.get("paymode").equals("DR")) {
			
			
			request.setAttribute("accesstoken",	session.getAttribute("accesstoken"));
			request.setAttribute("sw", data1.get("paymode"));
			request.setAttribute("plan", data1.get("plan"));
					mav.setViewName("deazzle/smartbiz-web");

		}else{
			request.setAttribute("business",data1.get("businessName"));
			mav.setViewName("deazzle/Quick-Pay/ResponsePage");
		}
			//System.out.println("Print 5: "+"----------------------END----------------------");
			    return mav;
		}catch (NullPointerException e) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("deazzle/Quick-Pay/invalidrequest");
		    return mav;
		
		}
		
		
	}
	
	
@CrossOrigin
@ResponseBody
@RequestMapping(value =  "/newMessage/{keyurl}", method = RequestMethod.POST)
public ResponseEntity<String> newMeassge( Model model,MessagesMaster msg,HttpServletRequest request, @PathVariable(value="keyurl")String keyurl,String access_key,String customer_mobile,String customer_email) {
	Map<String,String> map=new HashMap<String, String>();
	
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	try {	
	if(keys==null||keys.equals(null)) {
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
	} catch (NullPointerException e) {
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
	
	try {
		
		
		if(msg.getRef_id()==0) {
			
			List<OtherCustomerRegisterMaster> list=service.getNonRegisterCustomerr("select * from Non_Register_Customer nrc where nrc.other_cust_mobile='"+customer_mobile+"'");
			try {
				//System.out.println("SIZE-"+list.size());
				if(list.size()!=0) {
					msg.setRef_id(list.get(0).getOther_cust_id());
				}else {
					OtherCustomerRegisterMaster OCRM = new OtherCustomerRegisterMaster();
					OCRM.setOther_cust_address(request.getParameter("custAddress"));
					OCRM.setOther_cust_email(customer_email);
					OCRM.setOther_cust_mobile(customer_mobile);
					OCRM.setOther_cust_name(request.getParameter("custName"));
					
					OCRM=service.saveNonRegisterCustomer(OCRM);
					msg.setRef_id(OCRM.getOther_cust_id());
				}
				
			}catch(NullPointerException n) {}
			
			msg.setTable_ref("Non_Register_Customer");
		}else {
			msg.setTable_ref("Merchant_Customer_Master");
		}
		
	}catch(NullPointerException e) {
		return new ResponseEntity<String>("Please Enter valid Customer Details..",HttpStatus.BAD_REQUEST);
	}
	
	msg.setMerchantId(Long.parseLong(keys.getMerchant_key()));
	msg.setMsg_description(msg.getMsg_description());
	msg.setMerchant_service_id(msg.getMerchant_service_id());
	msg.setMerchantId(msg.getMerchantId());
	msg.setMode("Web Merchant_User Site");
	msg.setMsg_status("Open");
	msg.setStatus(true);
	msg.setType(msg.getType());
	msg=service.insertMassages(msg);	
	Settings settings = null;
	try{
	settings=service.getSetting("select * from Settings s where s.merchant_id="+keys.getMerchant_key());
	}catch(NullPointerException e){}
	
	try{
	if(settings.isMessage_register()) {
	SMSMaster sms=service.getSms("select * from SMS_MASTER sms where sms.merchant_id="+keys.getMerchant_key());
	if(sms.getSmsLimit()>sms.getSmsCount()) {  

	String message;
	if(msg.getType().equals("Complaint")) {
	 message=Messages.RegisterComplaint;
	 message=message.replace("[ID]","COM"+msg.getMsgId());
	}else {
		 message=Messages.RegisterEnquiry;
		 message=message.replace("[ID]","ENQ"+msg.getMsgId());

	}
	MyFunction.sendSMS(customer_mobile, message,sms.getSms_URL());
	sms.setSmsCount(sms.getSmsCount()+1);
	service.insertSMS(sms);
	}
	}
	}
	catch(NullPointerException e){};
	
	//insertInteraction(tx.getCustomer_email(),firstName,tx.getCustomer_mobile(), tx.getMerchant_service_id(),tx.getMerchant_id(),"SUCCESS","Transaction",tx.getTransaction_id(),"Transaction");
	insertInteraction(customer_email, request.getParameter("custName"), customer_mobile, msg.getMerchant_service_id(),msg.getMerchantId(),"Open "+msg.getType(),msg.getType(), msg.getMsgId(), "Complaint");
	map.put("error", "error");
	map.put("msg",Error.InsertMSG);
	map.put("data",new Gson().toJson(msg));
	return new ResponseEntity<String>("Successfully insert..",HttpStatus.OK);
}


@ResponseBody
@RequestMapping(value =  "/newMeassage", method = RequestMethod.POST)
public ResponseEntity<String> newMeassge( Model model,MessagesMaster msg,HttpServletRequest request,String customer_mobile,String customer_email) {
	Map<String,String> map=new HashMap<String, String>();
	//System.out.println("In newMessage...");
	try {
		if(msg.getMerchant_service_id()==0) {
			return new ResponseEntity<String>("Please Select Service..",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException e) {
		return new ResponseEntity<String>("Please Select Service..",HttpStatus.BAD_REQUEST);
	}
	
	try {
		if(request.getParameter("custName")==null||request.getParameter("custName").equals("")) {
			return new ResponseEntity<String>("Please Enter valid Customer Name.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter valid Customer Name.",HttpStatus.BAD_REQUEST);
	}
	try {
		if(customer_mobile==null||customer_mobile.equals("")) {
			return new ResponseEntity<String>("Please Enter valid Customer Mobile.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter valid Customer Mobile.",HttpStatus.BAD_REQUEST);
	}
	
	
	try {
		if(customer_email==null||customer_email.equals("")) {
			return new ResponseEntity<String>("Please Enter valid Customer Email.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter valid Customer Email.",HttpStatus.BAD_REQUEST);
	}
	try {
		if(msg.getType()==null) {
			return new ResponseEntity<String>("Please Enter Message Type.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter Message Type.",HttpStatus.BAD_REQUEST);
	}
	try {
		if(msg.getMerchantId()==0L) {
			return new ResponseEntity<String>("Please Enter valid Merchant Id.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter valid Merchant Id.",HttpStatus.BAD_REQUEST);
	}
	
	try {
		
		
		if(msg.getRef_id()==0) {
			
			List<OtherCustomerRegisterMaster> list=service.getNonRegisterCustomerr("select * from Non_Register_Customer nrc where nrc.other_cust_mobile='"+customer_mobile+"'");
			try {
				//System.out.println("SIZE-"+list.size());
				if(list.size()!=0) {
					msg.setRef_id(list.get(0).getOther_cust_id());
				}else {
					OtherCustomerRegisterMaster OCRM = new OtherCustomerRegisterMaster();
					OCRM.setOther_cust_address(request.getParameter("custAddress"));
					OCRM.setOther_cust_email(customer_email);
					OCRM.setOther_cust_mobile(customer_mobile);
					OCRM.setOther_cust_name(request.getParameter("custName"));
					OCRM=service.saveNonRegisterCustomer(OCRM);
					msg.setRef_id(OCRM.getOther_cust_id());
				}
				
			}catch(NullPointerException n) {}
			
			msg.setTable_ref("Non_Register_Customer");
		}else {
			msg.setTable_ref("Merchant_Customer_Master");
		}
		
	}catch(NullPointerException e) {
		return new ResponseEntity<String>("Please Enter valid Customer Details..",HttpStatus.BAD_REQUEST);
	}
	

	msg.setMsg_description(msg.getMsg_description());
	msg.setMerchant_service_id(msg.getMerchant_service_id());
	msg.setMerchantId(msg.getMerchantId());
	msg.setMode("Web Merchant_User Site");
	msg.setMsg_status("Open");
	msg.setType(msg.getType());
	msg.setStatus(true);
	msg=service.insertMassages(msg);
	
	
	
	Settings settings = null;
	try{
	settings=service.getSetting("select * from Settings s where s.merchant_id="+msg.getMerchantId());
	}catch(NullPointerException e){}
	
	try{
	if(settings.isMessage_register()) {
	SMSMaster sms=service.getSms("select * from SMS_MASTER sms where sms.merchant_id="+msg.getMerchantId());
	if(sms.getSmsLimit()>sms.getSmsCount()) {  

	String message;
	if(msg.getType().equals("Complaint")) {
	 message=Messages.RegisterComplaint;
	 message=message.replace("[ID]","COM"+msg.getMsgId());
	}else {
		 message=Messages.RegisterEnquiry;
		 message=message.replace("[ID]","ENQ"+msg.getMsgId());

	}
	MyFunction.sendSMS(customer_mobile, message,sms.getSms_URL());
	sms.setSmsCount(sms.getSmsCount()+1);
	service.insertSMS(sms);
	}
	}
	}
	catch(NullPointerException e){};
	
	insertInteraction(customer_email, request.getParameter("custName"), customer_mobile, msg.getMerchant_service_id(),msg.getMerchantId(),"Open "+msg.getType(),msg.getType(), msg.getMsgId(), "Complaint");
	map.put("error", "error");
	map.put("msg",Error.InsertMSG);
	map.put("data",new Gson().toJson(msg));
	return new ResponseEntity<String>("Successfully insert..",HttpStatus.OK);
}



/*
 * old Enq/Compl
 */ 
/*@CrossOrigin
@ResponseBody
@RequestMapping(value =  "/newMeassage", method = RequestMethod.POST)
public ResponseEntity<String> newMeassge( Model model,MessagesMaster msg,HttpServletRequest request,String customer_mobile,String customer_email) {
	Map<String,String> map=new HashMap<String, String>();
	System.out.println("In newMessage...");
	try {
		if(msg.getMerchant_service_id()==0) {
			return new ResponseEntity<String>("Please Select Service..",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException e) {
		return new ResponseEntity<String>("Please Select Service..",HttpStatus.BAD_REQUEST);
	}
	
	try {
		if(request.getParameter("custName")==null) {
			return new ResponseEntity<String>("Please Enter valid Customer Name.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter valid Customer Name.",HttpStatus.BAD_REQUEST);
	}
	try {
		if(customer_mobile==null) {
			return new ResponseEntity<String>("Please Enter valid Customer Mobile.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter valid Customer Mobile.",HttpStatus.BAD_REQUEST);
	}
	
	try {
		if(msg.getType()==null) {
			return new ResponseEntity<String>("Please Enter Message Type.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter Message Type.",HttpStatus.BAD_REQUEST);
	}
	try {
		if(msg.getMerchantId()==0L) {
			return new ResponseEntity<String>("Please Enter valid Merchant Id.",HttpStatus.BAD_REQUEST);
		}
		
	}catch(NullPointerException n) {
		return new ResponseEntity<String>("Please Enter valid Merchant Id.",HttpStatus.BAD_REQUEST);
	}
	
	try {
		
		
		if(msg.getRef_id()==0) {
			
			List<OtherCustomerRegisterMaster> list=service.getNonRegisterCustomerr("select * from Non_Register_Customer nrc where nrc.other_cust_mobile='"+customer_mobile+"'");
			try {
				System.out.println("SIZE-"+list.size());
				if(list.size()!=0) {
					msg.setRef_id(list.get(0).getOther_cust_id());
				}else {
					OtherCustomerRegisterMaster OCRM = new OtherCustomerRegisterMaster();
					OCRM.setOther_cust_address(request.getParameter("custAddress"));
					OCRM.setOther_cust_email(customer_email);
					OCRM.setOther_cust_mobile(customer_mobile);
					OCRM.setOther_cust_name(request.getParameter("custName"));
					OCRM=service.saveNonRegisterCustomer(OCRM);
					msg.setRef_id(OCRM.getOther_cust_id());
				}
				
			}catch(NullPointerException n) {}
			
			msg.setTable_ref("Non_Register_Customer");
		}else {
			msg.setTable_ref("Merchant_Customer_Master");
		}
		
	}catch(NullPointerException e) {
		return new ResponseEntity<String>("Please Enter valid Customer Details..",HttpStatus.BAD_REQUEST);
	}
	

	msg.setMsg_description(msg.getMsg_description());
	msg.setMerchant_service_id(msg.getMerchant_service_id());
	msg.setMerchantId(msg.getMerchantId());
	msg.setMode("Web Merchant_User Site");
	msg.setMsg_status("Open");
	msg.setType(msg.getType());
	msg=service.insertMassages(msg);
	
	
	
	Settings settings = null;
	try{
	settings=service.getSetting("select * from Settings s where s.merchant_id="+msg.getMerchantId());
	}catch(NullPointerException e){}
	
	try{
	if(settings.isMessage_register()) {
	SMSMaster sms=service.getSms("select * from SMS_MASTER sms where sms.merchant_id="+msg.getMerchantId());
	if(sms.getSmsLimit()>sms.getSmsCount()) {  

	String message;
	if(msg.getType().equals("Complaint")) {
	 message=Messages.RegisterComplaint;
	 message=message.replace("[ID]","COM"+msg.getMsgId());
	}else {
		 message=Messages.RegisterEnquiry;
		 message=message.replace("[ID]","ENQ"+msg.getMsgId());

	}
	MyFunction.sendSMS(customer_mobile, message,sms.getSms_URL());
	sms.setSmsCount(sms.getSmsCount()+1);
	service.insertSMS(sms);
	}
	}
	}
	catch(NullPointerException e){};
	
	
	map.put("error", "error");
	map.put("msg",Error.InsertMSG);
	map.put("data",new Gson().toJson(msg));
	return new ResponseEntity<String>("Successfully insert..",HttpStatus.OK);
}*/

@CrossOrigin
@ResponseBody
@RequestMapping(value="/searchUser/{keyurl}" ,method=RequestMethod.POST)
public ResponseEntity<String> searchUser(Model model,HttpServletRequest request,@PathVariable(value="keyurl")String  keyurl,
		String access_key,@RequestParam(value="service_code",required=false) String service_code,@RequestParam(value="mode",defaultValue="0")String mode,String user_key){
	
	//System.out.println("In searchUser..");
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
		try {
			
			if(keys.equals(null)||keys==null)
				{
				return new ResponseEntity<String>("Bad Request",HttpStatus.NOT_FOUND);
				}
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Bad Request",HttpStatus.NOT_FOUND);
		}	
				try{					
					MerchantCustomerMaster list=service.searchUser("select * from Merchant_Customer_Master mcm where ( mcm.merchant_customer_mobile='"+user_key+"' OR mcm.merchant_customer_user_id='"+user_key+"') and mcm.merchant_id='"+keys.getMerchant_key()+"'").get(0);//and mcm.merchant_service_id="+ Long.parseLong(service_code)+"
					//System.out.println("data----->"+new Gson().toJson(list));
				if(list==null) {
					return new ResponseEntity<String>("User Not Available..",HttpStatus.NOT_FOUND);			
				}else {
					if(mode.equals("0")) {
						
						
						boolean test=false;
						try {
							TransactionMaster t=service.payment("select * from Transaction_Master t where  t.customer_userId='"+list.getMerchant_customer_user_id()+"' and month(t.transaction_created_date)=month(CURRENT_DATE()) and t.transaction_status='SUCCESS' and  t.merchant_id='"+list.getMerchant_id()+"'");
								
							if(t!=null)
								test=true;
							else             
								test=false;
						}catch (NullPointerException e) {
							// TODO: handle exception
						}catch(IndexOutOfBoundsException e){
						}
						
						list.setAlreadyTransaction(test);
						
						
					return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
					}else {
						return new ResponseEntity<String>("User is Available..",HttpStatus.OK);
					}
				}
			}catch(IndexOutOfBoundsException e){
				return new ResponseEntity<String>("User Not Available..",HttpStatus.NOT_FOUND);

			}
				
	
}



@CrossOrigin
@ResponseBody
@RequestMapping(value="/getPlan" ,method=RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> getPlan(Model model,HttpServletRequest request,String merchant_key,String type){
	
	//System.out.println("In searchUser..");

	String cat="";
	
	try {
		
		if(!type.equals("NA"))
		cat="and p.category='"+type+"'";
	}catch(NullPointerException e) {}
	
	
		if(merchant_key.equals(null)) {
			return new ResponseEntity<String>("Invalid Request..",HttpStatus.BAD_REQUEST);
		}
		else
		{
				try{
					List<Object> list=service.list("select * from Product_Plan_Master p where p.merchantId="+merchant_key+" "+cat);

				if(list==null) {
					return new ResponseEntity<String>("Plan Not Found",HttpStatus.BAD_GATEWAY);
			
				}else
					//System.out.println("plan--->"+new Gson().toJson(list));
					return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
		
			}catch(IndexOutOfBoundsException e){
				return new ResponseEntity<String>("Plan Not Found",HttpStatus.BAD_GATEWAY);

			}
				}
	
}


@CrossOrigin
@ResponseBody
@RequestMapping(value="/getType" ,method=RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> getType(Model model,HttpServletRequest request,String merchant_key,String service_key){
	
	//System.out.println("In searchUser..");
	String service1="";
		try {
		
		if(!service_key.equals("NA"))
			service1="and p.category='"+service_key+"'";
	}catch(NullPointerException e) {}
	
	
		if(merchant_key.equals(null)) {
			return new ResponseEntity<String>("Invalid Request..",HttpStatus.BAD_REQUEST);
		}
		else
		{
				try{
					List<Object> list=service.list("select * from Product_Plan_Master p where p.merchantId="+merchant_key+"  GROUP BY p.category");

				if(list==null) {
					return new ResponseEntity<String>("Plan Not Found",HttpStatus.BAD_GATEWAY);
			
				}else
					//System.out.println("ptype--->"+new Gson().toJson(list));
					return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
		
			}catch(IndexOutOfBoundsException e){
				return new ResponseEntity<String>("Plan Not Found",HttpStatus.BAD_GATEWAY);

			}
				}
	
}

/*
 * Pranal Sawarkar
 * 
 * 
*/

//Registration to send document
/*@CrossOrigin
@ResponseBody
@RequestMapping(value="/registraionStatus/{keyurl}", method = RequestMethod.POST,headers = "Accept=application/json")
public String newRegistrationTT(		
		Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,
		@RequestParam(value="imageFile1",required=false ) MultipartFile imageFile1,
		@RequestParam(value="imageFile2" , required=false) MultipartFile imageFile2,
		@RequestParam(value="imageFile3",required=false) MultipartFile imageFile3,MerchantCustomerMaster cust,String access_key){
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
			try {if(keys==null){		
		return "400";//null key 
		}}catch(NullPointerException e){return "2";}
	MerchantCustomerMaster mcustList=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+cust.getMerchant_customer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" and m.merchant_service_id="+cust.getMerchant_service_id());
	try {if(mcustList.equals(null) || mcustList==null) { 
		
		}else {
		return "301";//user/Customer Found
		}

		} catch (NullPointerException e) { 	}	
	
	System.out.println("Serch NOn M Cust---"+new Gson().toJson(mcustList));
	ALL all=service.getData("select  cl.email,cl.mobileNo  from  Merchant_Info mi,Contact_login cl where cl.merchantId="+keys.getMerchant_key()+" and mi.merchantId="+keys.getMerchant_key()+"  GROUP BY mi.merchantId");
	System.out.println("data ----???>>>"+all.getEmail());
		
	
	String mailTo =all.getEmail();
 String subject = "Registration email with attachments";
 String host = "smtp.gmail.com";
 String port = "587";
 String mailFrom = "support@outgo.co";
 String password = "R9[XKyzT8HunBP";
 String message="<table border='1' style=' border-collapse: collapse;'>"
  		+ "<thead style='text-align: center;'><tr><th colspan='2'>Customer Information</th></tr></thead>"
  		+ "<tbody><tr><td>Name</td><td>"+cust.getMerchant_customer_name()+"</td></tr>"
  		+ "<tr><td>Mobile Number</td><td>"+cust.getMerchant_customer_mobile()+"</td></tr>"
  		+ "<tr><td>Email ID</td><td>"+cust.getMerchant_customer_email()+"</td></tr>"
  		+ "<tr><td>Address</td><td>"+cust.getMerchant_customer_address()+"</td></tr>"	     				
  		+ "</tbody></table>"
  		+ "<br>"
  		+ "<h4><i style='color:red;'>*</i>For Documents purpose, please find the attached Copies</h4>";
 		System.out.println("data");
 		try {
 			if(cust.getMerchant_customer_user_id().equals(null)||cust.getMerchant_customer_user_id().isEmpty() ||cust.getMerchant_customer_user_id()=="")
 				cust.setMerchant_customer_user_id("new");
 			else
 				cust.setMerchant_customer_user_id(cust.getMerchant_customer_user_id());			
		} catch (NullPointerException e) {			
		}
		
		cust.setMerchant_customer_description("New Registration");		
	
			 if(keys.isAttachment()==true) {
	    		 if (imageFile1.isEmpty()) {	    			
	    				return "551";//file f1 not found
	    		 }
	    		 if (imageFile2.isEmpty()) {	    			
	    				return "552";//file f2 not found
	    		 }
	    		 if (imageFile3.isEmpty()) {	    			
	    				return "553";//file f3 not found
	    		 }
	    		 try {
					sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
					         subject, message, imageFile1,imageFile2,imageFile3);
				} catch (AddressException e) {
				
					e.printStackTrace();
				} catch (MessagingException e) {
					
					e.printStackTrace();
				}
	    		 System.out.println("Email sent.");
	    		}
	    	cust.setMerchant_id(Long.parseLong(keys.getMerchant_key()));
	    
	 	  if(keys.isRegisterpay()==true){
	    	 cust=service.saveRegisterCustomer(cust);
				return "33";//Pay for Registration
	     }
	    	 cust=service.saveRegisterCustomer(cust);
	    	 System.out.println("plan list---->>>>>"+new Gson().toJson(cust));	    	 
				return "22";//Successfully Register without pay
	    
		

	//return "5";
	
} 
*/


@CrossOrigin
@ResponseBody
@RequestMapping(value="/registraionStatus/{keyurl}", method = RequestMethod.POST,headers = "Accept=application/json")
public String newRegistrationTT(		
		Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,
		@RequestParam(value="imageFile1",required=false ) MultipartFile imageFile1,
		@RequestParam(value="imageFile2" , required=false) MultipartFile imageFile2,
		@RequestParam(value="imageFile3",required=false) MultipartFile imageFile3,MerchantCustomerMaster cust,String access_key){
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
			try {if(keys==null){		
		return "400";//null key 
		}}catch(NullPointerException e){return "400";}
	MerchantCustomerMaster mcustList=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+cust.getMerchant_customer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" and m.merchant_service_id="+cust.getMerchant_service_id());
	try {if(mcustList.equals(null) || mcustList==null) { 
		
		}else {
			
				return "301";//user/Customer Found
			
		}
 
		} catch (NullPointerException e) { 	}	
	  try {
			 	if(cust.getMerchant_service_id()==0 || cust.getMerchant_service_id()+""==null||cust.getMerchant_service_id()+""=="") {
	    		return "400";
	    	}
	    } catch (NullPointerException e) {
	    	return "400";
		}
	//System.out.println("Serch Non M Cust---"+new Gson().toJson(mcustList));
	ALL all=service.getData("select  cl.email,cl.mobileNo  from  Merchant_Info mi,Contact_login cl where cl.merchantId="+keys.getMerchant_key()+" and mi.merchantId="+keys.getMerchant_key()+"  GROUP BY mi.merchantId");
	
		try {		
			//System.out.println("data ----???>>>"+all.getEmail());
			if(all.getEmail().equals(null)||all.getEmail().isEmpty()) {
				return "400";
				}
		} catch (NullPointerException e) {return "400";	}
	 String mailTo =all.getEmail();
	 String subject = "Registration email with attachments";
	 String host = "smtp.gmail.com";
	 String port = "587";
	 String mailFrom = "noreply@deazzle.in'";
	 String password = "R9[XKyzT8HunBP";
 String message="<table border='1' style=' border-collapse: collapse;'>"
  		+ "<thead style='text-align: center;'><tr><th colspan='2'>Customer Information</th></tr></thead>"
  		+ "<tbody><tr><td>Name</td><td>"+cust.getMerchant_customer_name()+"</td></tr>"
  		+ "<tr><td>Mobile Number</td><td>"+cust.getMerchant_customer_mobile()+"</td></tr>"
  		+ "<tr><td>Email ID</td><td>"+cust.getMerchant_customer_email()+"</td></tr>"
  		+ "<tr><td>Address</td><td>"+cust.getMerchant_customer_address()+"</td></tr>"	     				
  		+ "</tbody></table>"
  		+ "<br>"
  		+ "<h4><i style='color:red;'>*</i>For Documents purpose, please find the attached Copies</h4>";
 		//System.out.println("data");
 		try {
 			if(cust.getMerchant_customer_user_id().equals(null)||cust.getMerchant_customer_user_id().isEmpty() ||cust.getMerchant_customer_user_id()=="")
 				cust.setMerchant_customer_user_id("new");
 			else
 				cust.setMerchant_customer_user_id(cust.getMerchant_customer_user_id());			
		} catch (NullPointerException e) {			
		}
		
		cust.setMerchant_customer_description("New Registration");		
	
			 if(keys.isAttachment()==true) {
	    		 if (imageFile1.isEmpty()) {	    			
	    				return "551";//file f1 not found
	    		 }
	    		 if (imageFile2.isEmpty()) {	    			
	    				return "552";//file f2 not found
	    		 }
	    		 if (imageFile3.isEmpty()) {	    			
	    				return "553";//file f3 not found
	    		 }
	    		
					  			 
	    			 ImageThread img=new ImageThread(host, port, mailFrom, password, mailTo,
					         subject, message, imageFile1,imageFile2,imageFile3);
	    			 
	    			 img.start();
	    			 
	    		 //System.out.println("Email sent.");
	    		}
	    	cust.setMerchant_id(Long.parseLong(keys.getMerchant_key()));
	    	
	    	
	 	  if(keys.isRegisterpay()==true){
	    	 cust=service.saveRegisterCustomer(cust);
	    	 insertInteraction(cust.getMerchant_customer_email(),cust.getMerchant_customer_name(), cust.getMerchant_customer_mobile(), cust.getMerchant_service_id(),cust.getMerchant_id(),"New Customer","Email",cust.getMerchant_customer_id(), "Customer");
				return "33";//Pay for Registration
	     }
	    	 cust=service.saveRegisterCustomer(cust);
	    	 insertInteraction(cust.getMerchant_customer_email(),cust.getMerchant_customer_name(), cust.getMerchant_customer_mobile(), cust.getMerchant_service_id(),cust.getMerchant_id(),"New Customer","Email",cust.getMerchant_customer_id(), "Customer");
	    	 //System.out.println("plan list---->>>>>"+new Gson().toJson(cust));	    	 
				return "22";//Successfully Register without pay
	    
		

	//return "5";
	
} 



//Registration to pay
@CrossOrigin
@RequestMapping(value="/regiPay/{keyurl}", method = RequestMethod.POST,headers = "Accept=application/json")
public String newRegistrationTPay(		
		Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,MerchantCustomerMaster cust,TransactionMaster tx
		){
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"'");
	try {if(keys==null){		
return "400";//null key 
}}catch(NullPointerException e){return "400";}
	//System.out.println("---Mid1------>"+cust.getMerchant_id());	
	MerchantCustomerMaster mcustList=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+cust.getMerchant_customer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" and m.merchant_service_id="+cust.getMerchant_service_id());
	tx.setTransaction_order_id("WUS"+System.currentTimeMillis());
	tx.setTransaction_mode("Web User Site");
	tx.setTransaction_payment_gatway_name("Citrus");
	tx.setTransaction_type("Online");
	tx.setCustomer_email(cust.getMerchant_customer_email());
	tx.setCustomer_mobile(cust.getMerchant_customer_mobile());
	tx.setCustomer_userId("new");
	tx.setMerchant_service_id(cust.getMerchant_service_id());
	
	
	tx.setRef_id(mcustList.getMerchant_customer_id());
	//System.out.println("---Mid2------>"+mcustList.getMerchant_id());
	//System.out.println("---mSid2------>"+cust.getMerchant_service_id());
	
	tx.setRef_table("Merchant_Customer_Master");
	tx.setTransaction_amount(cust.getMerchant_customer_amount());
	tx=service.saveCustomerTransaction(tx);
	
	//System.out.println("Done "+new Gson().toJson(tx));
	
	String service_name=service.getService(tx.getMerchant_service_id());
	//System.out.println("service name-->"+service_name);
	request.setAttribute("email",tx.getCustomer_email());
	request.setAttribute("amount",tx.getTransaction_amount());
	request.setAttribute("mobile",tx.getCustomer_mobile());
	request.setAttribute("address", cust.getMerchant_customer_address());
	request.setAttribute("name",cust.getMerchant_customer_name());
	request.setAttribute("service_name",service_name);
	
	
	SendKeys key=new SendKeys();
	key.setCurrency(CitrusKey.currency);
	key.setFormPostUrl(CitrusKey.formPostUrl);
	key.setMerchantTxnId(tx.getTransaction_order_id());
	key.setEmail(tx.getCustomer_email());
	key.setMobile(tx.getCustomer_mobile());
	//key.setNotifyUrl(CitrusKey.notifyUrl+"redirect");
	key.setReturnURL(CitrusKey.returnURL+"redirect");
	key.setAmount(tx.getTransaction_amount());
	key.setSecuritySignature(CitrusKey.securitySignature(tx.getTransaction_amount()+"" , tx.getTransaction_order_id()));
	
	//request.setAttribute("key",key);
	request.setAttribute("returnURL",CitrusKey.returnURL+"redirect");
	request.setAttribute("formPostUrl",CitrusKey.formPostUrl);
	request.setAttribute("currency",CitrusKey.currency);
	request.setAttribute("MerchantTxnId",key.merchantTxnId);
	request.setAttribute("secSignature",key.securitySignature);
	 return "ApiInfo";

}
//---------------------------------------
//sending email of registration
public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
		String toAddress, String subject, String message, MultipartFile attachFiles1, MultipartFile attachFiles2,
		MultipartFile attachFiles3) throws AddressException, MessagingException {
	
	
	
	
System.out.println("Coming 2222");	
	// sets SMTP server properties
	Properties props = new Properties();
	  props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.user", "noreply@deazzle.in");
	   props.put("mail.smtp.password","R9[XKyzT8HunBP");
	   props.put("mail.smtp.port", "587");
	   props.put("mail.smtp.auth", "true");;

	// creates a new session with an authenticator
	Authenticator auth = new Authenticator() {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, password);
		}
	};
	Session session = Session.getInstance(props, auth);

	// creates a new e-mail message
	Message msg = new MimeMessage(session);
	 msg.setFrom(new InternetAddress("noreply@deazzle.in"));
	//msg.setFrom(new InternetAddress(userName));
	InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	msg.setRecipients(Message.RecipientType.TO, toAddresses);
	InternetAddress[] BCcAddress = { new InternetAddress("pranal.sawarkar@deazzle.co.in")}; //CC Email
    msg.setRecipients(Message.RecipientType.BCC, BCcAddress);
	msg.setSubject(subject);
	msg.setSentDate(new Date());

	// creates message part
	MimeBodyPart messageBodyPart = new MimeBodyPart();
	messageBodyPart.setContent(message, "text/html");

	// creates multi-part
	Multipart multipart = new MimeMultipart();
	multipart.addBodyPart(messageBodyPart);
	MimeBodyPart attachPart1 = new MimeBodyPart();
	MimeBodyPart attachPart2 = new MimeBodyPart();
	MimeBodyPart attachPart3 = new MimeBodyPart();

	try {
		File f = convert(attachFiles1);
		attachPart1.attachFile(f);
		f = convert(attachFiles2);
		attachPart2.attachFile(f);
		f = convert(attachFiles3);
		attachPart3.attachFile(f);

	} catch (IOException ex) {
		ex.printStackTrace();
	}

	multipart.addBodyPart(attachPart1);
	multipart.addBodyPart(attachPart2);
	multipart.addBodyPart(attachPart3);

	// adds attachments
	/*
	 * if (attachFiles != null && attachFiles.length > 0) { for (String
	 * filePath : attachFiles) { MimeBodyPart attachPart = new
	 * MimeBodyPart();
	 * 
	 * try { attachPart.attachFile(filePath); } catch (IOException ex) {
	 * ex.printStackTrace(); }
	 * 
	 * multipart.addBodyPart(attachPart); } }
	 */

	// sets the multi-part as e-mail's content
	msg.setContent(multipart);

	// sends the e-mail
    Transport transport = session.getTransport("smtp");
    System.out.println("transxbsajbxmas");
    transport.connect( "smtp.gmail.com", "noreply@deazzle.in","R9[XKyzT8HunBP" );
    System.out.println("trans1");
    transport.sendMessage(msg, msg.getAllRecipients());
    System.out.println("Mail has been sent");
    transport.close();

	//Transport.send(msg);
	//System.out.println("Message" + msg);

}




















public static File convert(MultipartFile file) throws IOException {
	File convFile = new File(file.getOriginalFilename());
	convFile.createNewFile();
	FileOutputStream fos = new FileOutputStream(convFile);
	fos.write(file.getBytes());
	fos.close();
	return convFile;
}


//Login Api

@CrossOrigin
@ResponseBody
@RequestMapping(value="/login/{keyurl}" ,method=RequestMethod.POST)
public ResponseEntity<String> loginCustomer(Model model,HttpServletRequest request,HttpServletResponse response,
		@PathVariable("keyurl") String keyurl,String merchant_serviceId,String access_key,String customer_uniqueId,
		String customer_mobile,String customer_password)

	 {
	
		Map<String,Object> map= new Hashtable<String, Object>();	

		Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	
	try {if(keys==null)
	{
		
		return new ResponseEntity<String>("key Url Error",HttpStatus.BAD_REQUEST);	
	}
		
	}catch(NullPointerException e)
	{		
		
		return new ResponseEntity<String>("key Url Error",HttpStatus.BAD_REQUEST);	
	}
	try {if(request.getParameter("access_key")==null || request.getParameter("access_key")=="")
	{
	
		map.put("error", "access key is Invalid 1");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);	
	}
		
	if(!request.getParameter("access_key").equals(keys.getAccess_key())){
	
		map.put("error", "access key is Invalid 1");
		map.put("error", "1");		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		
		/*return new ResponseEntity<String>("Authentication Fail...Invalid  access key.2",HttpStatus.OK);	*/
	}
	
	}catch(NullPointerException e)
	{		
		map.put("error", "access key is Invalid 1");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		/*return new ResponseEntity<String>("Authentication Fail...Invalid  access key.3",HttpStatus.OK);*/
	}
	try {if(request.getParameter("merchant_serviceId").equals(null) || request.getParameter("merchant_serviceId").isEmpty())
	{
		
		
		map.put("error", "merchant serviceId is Invalid 1");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		/*return new ResponseEntity<String>("Authentication Fail...Invalid  Service code",HttpStatus.OK);	*/
	}
		
	}catch(NullPointerException e)
	{		
		map.put("error", "merchant serviceId is Invalid 1");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		/*return new ResponseEntity<String>("Authentication Fail...Invalid  Service code.",HttpStatus.OK);	*/
	}
	
try {if(request.getParameter("customer_uniqueId").equals(null) || request.getParameter("customer_uniqueId").isEmpty())
	{
	map.put("error", "customer uniqueId is Invalid 1");
	map.put("error", "1");
	
	return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		/*return new ResponseEntity<String>("Authentication Fail...Invalid  User Id.",HttpStatus.OK);	*/
	}
		
	}catch(NullPointerException e)
	{		
		map.put("error", "customer uniqueId is Invalid 1");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		//return new ResponseEntity<String>("Authentication Fail...Invalid  User Id",HttpStatus.OK);	
	}
	
		
	try {if(request.getParameter("customer_password").equals(null) || request.getParameter("customer_password").isEmpty())
	{
		map.put("error", "customer password is Invalid 1");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		//return new ResponseEntity<String>("Authentication Fail...Invalid Password.",HttpStatus.OK);	
	}
		
	}catch(NullPointerException e)
	{		
		map.put("error", "customer password is Invalid 1");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		//return new ResponseEntity<String>("Authentication Fail...Invalid  Password.",HttpStatus.OK);	
	}
	
	try{
		MerchantCustomerMaster list=service.searchUser("select * from Merchant_Customer_Master mcm where ( mcm.merchant_customer_mobile='"+customer_uniqueId+"' OR mcm.merchant_customer_user_id='"+customer_uniqueId+"' OR mcm.merchant_customer_email='"+customer_uniqueId+"' )"
				+ " and mcm.merchant_service_id="+ Long.parseLong(merchant_serviceId)+"  and mcm.merchant_id='"+keys.getMerchant_key()+"' and mcm.status="+true).get(0); // and mcm.merchant_customer_password='"+customer_password+"'

	if(list==null) {
		map.put("error", "User Not Available");
		map.put("error", "1");
		
		return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		//return new ResponseEntity<String>("User Not Available..",HttpStatus.BAD_GATEWAY);

	}else {
		if(list.getMerchant_customer_password().equals(customer_password)) {
			
			map.put("error", "Incorrect password please try again");
			map.put("error", list);
			//System.out.println("merchant---->"+new Gson().toJson(list));
			return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
			
			//return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
				
		}else {
			map.put("error", "Incorrect password please try again");
			map.put("error", "1");
			
			return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
			//return new ResponseEntity<String>("Incorrect password please try again.",HttpStatus.OK);
			
		}
			}
		}catch(IndexOutOfBoundsException e){
			map.put("error", "User Not Available");
			map.put("error", "1");
			
			return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
			//return new ResponseEntity<String>("User Not Available..",HttpStatus.BAD_GATEWAY);
		
		}catch (NullPointerException e) {
			map.put("error", "User Not registered! Please call service provider");
			map.put("error", "1");
			
			return new ResponseEntity<String>(new Gson().toJson(map),HttpStatus.OK);
		}		
		
			
		}

// 13-02-2018



/*@CrossOrigin
@ResponseBody
@RequestMapping(value="/getPendingTransaction/{keyurl}",method=RequestMethod.POST, headers="Accept=application/json")
public ResponseEntity<String>  pendingBill(Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,String access_key,MerchantCustomerMaster cust) {
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	try {
		
	if(keys==null) {
		//System.out.println("if null");
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
		}else {
		
				List<Object> tm=service.list("select  tm.*,mcm.merchant_customer_name as cust_name, mcm.merchant_customer_user_id as userId from Transaction_Master tm,Merchant_Customer_Master mcm where tm.merchant_id='"+keys.getMerchant_key()+"' and mcm.merchant_customer_id= tm.ref_id and tm.merchant_service_id="+cust.getMerchant_service_id()+" and tm.ref_table='Merchant_Customer_Master'"
					+ "  and tm.customer_mobile='"+cust.getMerchant_customer_mobile()+"' and tm.transaction_status='Pending'");//order by tm.transaction_id desc limit 1
			
			try {		
		
		if(tm==null || tm.isEmpty()) {
			return new ResponseEntity<String>("404",HttpStatus.OK);
		}else {
			
			System.out.println("else null tm"+new Gson().toJson(tm));
			return new ResponseEntity<String>(new Gson().toJson(tm),HttpStatus.OK);
		}
		} catch (NullPointerException e) {
			
			return new ResponseEntity<String>("404",HttpStatus.OK);
		}catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<String>("404",HttpStatus.OK);
		}
	}
	
	
	} catch (NullPointerException e) {
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
}

*/
@CrossOrigin
@ResponseBody
@RequestMapping(value="/getPendingTransaction/{keyurl}",method=RequestMethod.POST, headers="Accept=application/json")
public ResponseEntity<String>  pendingBill(Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,String access_key,MerchantCustomerMaster cust) {
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	try {
		
	if(keys==null) {
		//System.out.println("if null");
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
		}else {
		
				/*List<Object> tm=service.list("select  tm.*,mcm.merchant_customer_name as cust_name, mcm.merchant_customer_user_id as userId from Transaction_Master tm,Merchant_Customer_Master mcm where tm.merchant_id='"+keys.getMerchant_key()+"' and mcm.merchant_customer_id= tm.ref_id and tm.merchant_service_id="+cust.getMerchant_service_id()+" and tm.ref_table='Merchant_Customer_Master'"
					+ "  and tm.customer_mobile='"+cust.getMerchant_customer_mobile()+"' and tm.transaction_status='Pending'");//order by tm.transaction_id desc limit 1
		*/	
			
			
			
			List<Object> tm=service.list("select  tm.*,mcm.merchant_customer_name as cust_name, mcm.merchant_customer_user_id as userId,pm.json from Transaction_Master tm,Merchant_Customer_Master mcm,Product_Plan_Master pm where pm.merchantId=tm.merchant_id and pm.serviceId=tm.merchant_service_id and tm.merchant_id='"+keys.getMerchant_key()+"' and mcm.merchant_customer_id= tm.ref_id and tm.merchant_service_id="+cust.getMerchant_service_id()+" and tm.ref_table='Merchant_Customer_Master'"
					+ "  and tm.customer_mobile='"+cust.getMerchant_customer_mobile()+"' and  pm.subcategory=tm.customer_plan_name and tm.transaction_status='Pending' GROUP BY tm.transaction_order_id");
			
			
			try {		
		
		if(tm==null || tm.isEmpty()) {
			return new ResponseEntity<String>("404",HttpStatus.OK);
		}else {
			
						
			//System.out.println("else null tm"+new Gson().toJson(tm));
			return new ResponseEntity<String>(new Gson().toJson(tm),HttpStatus.OK);
		}
		} catch (NullPointerException e) {
			
			return new ResponseEntity<String>("404",HttpStatus.OK);
		}catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<String>("404",HttpStatus.OK);
		}
	}
	
	
	} catch (NullPointerException e) {
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
}




@CrossOrigin
@ResponseBody
@RequestMapping(value="/transcation-history/{keyurl}",method=RequestMethod.POST, headers="Accept=application/json")		
public ResponseEntity<String>  transactionHistory(Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,String access_key,MerchantCustomerMaster cust) {
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	try {
	if(keys==null) {
		//System.out.println("if null");
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
		}else { 
	
			
			List<Object> tmHistoryData=service.list("select * from Transaction_Master tm where tm.merchant_id="+keys.getMerchant_key()+" and (tm.customer_mobile='"+cust.getMerchant_customer_mobile()+"' or tm.customer_userId='"+cust.getMerchant_customer_user_id()+"' or tm.customer_email='"+cust.getMerchant_customer_email()+"') and tm.transaction_status='SUCCESS' and " + 
					" tm.transaction_update_date >= DATE_SUB(now(), interval 3 month)");//order by tm.transaction_id desc limit 1
			
	try {		

if(tmHistoryData==null || tmHistoryData.isEmpty()) {
	return new ResponseEntity<String>("404",HttpStatus.OK);
}else {
	
	//System.out.println("tmHistoryData----"+new Gson().toJson(tmHistoryData));
	return new ResponseEntity<String>(new Gson().toJson(tmHistoryData),HttpStatus.OK);
}
} catch (NullPointerException e) {
	
	return new ResponseEntity<String>("404",HttpStatus.OK);
}catch (IndexOutOfBoundsException e) {
	return new ResponseEntity<String>("404",HttpStatus.OK);
}
			
		}		


} catch (NullPointerException e) {
	return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
}

}

@CrossOrigin
@ResponseBody
@RequestMapping(value="/send-Otp/{keyurl}",method=RequestMethod.POST, headers="Accept=application/json")		
public ResponseEntity<String>  sendOTP(Model model,String mode,HttpServletRequest request, @PathVariable("keyurl") String keyurl,String access_key,String userSearchKey,String serviceId,@RequestParam(value="id",defaultValue="0")long id) {
	
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	try {
	if(keys==null) {
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
	}catch(NullPointerException e){
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
		
	}		
	MerchantCustomerMaster mcMaster=service.searchUserMerchant("select * from Merchant_Customer_Master mcm where  mcm.merchant_customer_user_id='"+userSearchKey+"' and mcm.merchant_service_id="+serviceId+" and mcm.`status`=true and mcm.merchant_id="+keys.getMerchant_key());
	
	//System.out.println("");
	//System.out.println("tmHistoryData----"+new Gson().toJson(mcMaster));
	try {
		
	
	if(mcMaster.getMerchant_customer_password()==null || mcMaster.getMerchant_customer_password().isEmpty()) {
		return new ResponseEntity<String>("444",HttpStatus.OK);
	}
	} catch (NullPointerException e) {
		return new ResponseEntity<String>("405",HttpStatus.OK);
	}
		try {
		if(mcMaster.getMerchant_customer_mobile()==null)return null;
		if (!mcMaster.getMerchant_customer_mobile().matches("\\d{10}")) return new ResponseEntity<String>("404",HttpStatus.OK);
	}catch (Exception e) {
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
		if(mode.equals("1")) {
			String otp=	String.valueOf(OTP_Verifay.OTP(6));
			OTP_Verifay OTP =new OTP_Verifay();
			OTP.setMobileNo(mcMaster.getMerchant_customer_mobile());
			OTP.setOTP(otp);
			OTP.setCreateDate(MyFunction.date());
			OTP.setUpdateDate(MyFunction.date());
			OTP.setStatus(false);
			insertInteraction(mcMaster.getMerchant_customer_email(),mcMaster.getMerchant_customer_name(), mcMaster.getMerchant_customer_mobile(), mcMaster.getMerchant_service_id(), mcMaster.getMerchant_id(),"Customer Verification", "SMS", mcMaster.getMerchant_customer_id(), "Customer");
			
			service.insertOTP(OTP);
			String message = Messages.OTP_Forget_Password;
			message =message.replace("[OTP]", otp);
			//System.out.println(message);

			MyFunction.sendOTP(mcMaster.getMerchant_customer_mobile(),message);  //SMS OTP
			//System.out.println("my ID----"+OTP.getId());
			return new ResponseEntity<String>(new Gson().toJson(OTP.getId()),HttpStatus.OK);
			}else if(mode.equals("2")) {
				
				String otp = request.getParameter("otp");
				String password = request.getParameter("password");
				
				if(password.equals(mcMaster.getMerchant_customer_password())) {
					return new ResponseEntity<String>("403",HttpStatus.OK);
				}
				try {
					if (otp.matches("\\d{6}")) {
						OTP_Verifay otpv=service.validateOTP(otp,mcMaster.getMerchant_customer_mobile(),id);
						if(otpv.getOTP().equals(otp)) {
						
							otpv.setStatus(true);
							mcMaster.setMerchant_customer_password(password);
							service.insertOTP(otpv);
							//service.saveRegisterCustomer(mcMaster);	
							service.update("update Merchant_Customer_Master m set m.merchant_customer_password='"+password
										   +"' where m.merchant_customer_id="+mcMaster.getMerchant_customer_id()+" and m.merchant_id="+mcMaster.getMerchant_id());
							return new ResponseEntity<String>("0",HttpStatus.OK);
						}
					} else {
						
						return new ResponseEntity<String>("404",HttpStatus.OK);
					}
				} catch (NullPointerException e) {
					
					return new ResponseEntity<String>("404",HttpStatus.OK);
				}
				
				
				
			}
			
		 return new ResponseEntity<String>("404",HttpStatus.OK);			
	

}	


@CrossOrigin
@ResponseBody
@RequestMapping(value="/getServices/{keyurl}",method=RequestMethod.POST, headers="Accept=application/json")
public ResponseEntity<String> getServicesData(HttpServletRequest request,HttpServletResponse response, @PathVariable("keyurl") String keyurl,String access_key){
	
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	try {
	if(keys==null) {
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
	}catch(NullPointerException e){
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
		
	}
		List<Object> list= service.list("select ms.* ,am.area_name,sm.service_name from Merchant_Service_Detail_Master ms , Bank_Master bm ,\n" + 
			"Tax_Master tm, Area_Master am, Address_Master adm , Contact_login cl,Service_Master sm where ms.bank_id=bm.bank_id and ms.tax_id=tm.tax_id and sm.service_id=ms.service_code and\n" + 
			"am.area_id=ms.service_area_id and ms.address_id=adm.address_id and cl.id=ms.contact_id and ms.merchant_id="+keys.merchant_key+" ");
	//System.out.println("List---->>>"+new Gson().toJson(list));
	
	return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
//	return null;
	
}




/*
 * !End code Pranal Sawarkar  
 * 
*/


@ResponseBody
@RequestMapping(value="/todo-{merchantId}-smartBiz=19-02-2018-456-987-123-outgo--9874-14-9875-09-new-app-4609-{merchantId2}", method = RequestMethod.GET)
public ModelAndView  todo(ModelMap model,@PathVariable("merchantId") String merchantId,@PathVariable("merchantId2") String merchantId2) {
	ModelAndView mav = new ModelAndView();
	if(merchantId2.equals(merchantId)) {
	
	
	
	
	List<Object> list= service.list("select ms.* ,bm.bank_account_number,bm.bank_ifsc_code,bm.bank_verify,bm.bank_name,tm.gstn_number,tm.pan_number,tm.name_of_pan_card,tm.Business_Registered_GST,\n" + 
			"tm.gst_tax,tm.verifyTax,am.area_name,adm.address_desc,cl.mobileNo,cl.email,sm.service_name from Merchant_Service_Detail_Master ms , Bank_Master bm ,\n" + 
			"Tax_Master tm, Area_Master am, Address_Master adm , Contact_login cl,Service_Master sm where ms.bank_id=bm.bank_id and ms.tax_id=tm.tax_id and sm.service_id=ms.service_code and\n" + 
			"am.area_id=ms.service_area_id and ms.address_id=adm.address_id and cl.id=ms.contact_id and ms.merchant_id='"+merchantId+"' ");

	model.addAttribute("service",list);
	model.addAttribute("merchantId",merchantId);

    mav.setViewName("todo");
    return mav;
    }
	return null;
	
}
/*@CrossOrigin
@ResponseBody*/
@RequestMapping(value="/registered-customer/{keyurl}",method=RequestMethod.POST, headers="Accept=application/json")
public String custRegistered(ModelMap model,HttpServletRequest request,HttpServletResponse response,TransactionMaster tx,String name,String address, @PathVariable("keyurl") String keyurl,String access_key,String merchantMobile,String businessName,HttpSession session){
	ModelAndView mav = new ModelAndView();
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
	try {
		if(keys==null) {
			model.addAttribute("error","Authentication Fail...Invalid  Input.");
			 return null;
		}
		}catch(NullPointerException e){ model.addAttribute("error","Authentication Fail...Invalid  Input.");
		 return null;
		}		
	try 
	{
		if(request.getParameter("merchant_id")==null)
	{
		model.addAttribute("error","Authentication Fail...Invalid  access_key.");
		return null;	
	}
		
	if(!request.getParameter("merchant_id").equals(keys.getMerchant_key())){
		model.addAttribute("error","Authentication Fail...Invalid  Id Mismatch.");
		 return null;	
	}
	
	}catch(NullPointerException e)
	{		
		model.addAttribute("error","Authentication Fail...Invalid   Id Mismatch.");
		 return null;	
	}
	
	try {		
		if(tx.getMerchant_service_id()==0L)
		{
			model.addAttribute("error","Authentication Fail...Please Select Service.");
			 return null;	
		}
	}catch(NullPointerException e)
	{		
		   model.addAttribute("error","Authentication Fail...Please Select Service.");
		   return null;	
	}
	
	
	try {		
		if(name==null||name.equals(""))
		{
			model.addAttribute("error","Authentication Fail...Please Enter Name.");
		    return null;
		}	
	}catch(NullPointerException e)
	{		
		   model.addAttribute("error","Authentication Fail...Please Enter Name.");
		  // return "error";	
	}

	try {		
		if(tx.getCustomer_mobile()==null||tx.getCustomer_mobile().equals(""))
		{		
			model.addAttribute("error","Authentication Fail...Please Enter Mobile No.");
			return null;	
		}
		if (!tx.getCustomer_mobile().matches("\\d{10}")) 
		{		
			model.addAttribute("error","Authentication Fail...Please Enter Mobile No.");
			return null;
		}
	}catch(NullPointerException e)
	{		
		 model.addAttribute("error","Authentication Fail...Please Enter Mobile No.");
		 return null;
	}
	
	try {		
		if(tx.getCustomer_email()==null||tx.getCustomer_email().equals(""))
		{
		   model.addAttribute("error","Authentication Fail...Please Enter Email.");
		   return null;
		}
		
	}catch(NullPointerException e)
	{		
		   model.addAttribute("error","Authentication Fail...Please Enter Email.");
		   return null;	
	}
	MerchantCustomerMaster o=new MerchantCustomerMaster();
	//OtherCustomerRegisterMaster o=service.getNonRegisterCustomer("select * from Non_Register_Customer n where n.other_cust_mobile='"+tx.getCustomer_mobile()+"'");
	o=service.searchUserMerchant("select * from Merchant_Customer_Master mcm where mcm.merchant_id="+keys.getMerchant_key()+" and mcm.merchant_service_id="+tx.getMerchant_service_id()+" and  mcm.merchant_customer_mobile='"+tx.getCustomer_mobile()+"'");
	try {
	if(tx.getRef_id()==0){
		
		//OtherCustomerRegisterMaster o=service.getNonRegisterCustomer("select * from Non_Register_Customer n where n.other_cust_mobile='"+tx.getCustomer_mobile()+"'");
		//System.out.println("list "+new Gson().toJson(o));
		try{
		if(o==null){
			
					o.setMerchant_customer_user_id(tx.getCustomer_userId());
					o.setMerchant_customer_name(name);
					o.setStatus(true);
					o.setMerchant_customer_address(address);
					o.setMerchant_customer_email(tx.getCustomer_email());
					o.setMerchant_customer_mobile(tx.getCustomer_mobile());
					o.setMerchant_id(tx.getMerchant_id());
					o.setMerchant_service_id(tx.getMerchant_service_id());
					o.setMerchant_customer_amount(tx.getTransaction_amount());
					o=service.saveRegisterCustomer(o);
					tx.setRef_id(o.getMerchant_customer_id());
					tx.setRef_table("Merchant_Customer_Master");
			
		}else{
			tx.setRef_id(o.getMerchant_customer_id());
			tx.setRef_table("Merchant_Customer_Master");
		}}catch(NullPointerException n){
			o.setMerchant_customer_user_id(tx.getCustomer_userId());
			o.setMerchant_customer_name(name);
			o.setStatus(true);
			o.setMerchant_customer_address(address);
			o.setMerchant_customer_email(tx.getCustomer_email());
			o.setMerchant_customer_mobile(tx.getCustomer_mobile());
			o.setMerchant_id(tx.getMerchant_id());
			o.setMerchant_service_id(tx.getMerchant_service_id());
			o.setMerchant_customer_amount(tx.getTransaction_amount());
			o=service.saveRegisterCustomer(o);
			tx.setRef_id(o.getMerchant_customer_id());
			tx.setRef_table("Merchant_Customer_Master");
			
			}
		
			}else{
				tx.setRef_table("Merchant_Customer_Master");
			}
		}
		catch(NullPointerException e) {
			
			//System.out.println("ref_id-->" +tx.getRef_id());
		}

	//System.out.println("list "+new Gson().toJson(mcm));
	
	tx.setMerchant_id(Long.parseLong((keys.merchant_key)));
	tx.setTransaction_mode("Web User Site");
	tx.setTransaction_payment_gatway_name("Offline");
	tx.setTransaction_type("Offline");
	tx.setTransaction_order_id("WUS"+System.currentTimeMillis());
	
	insertInteraction(tx.getCustomer_email(),name, tx.getCustomer_mobile(),tx.getMerchant_service_id(),tx.getMerchant_id(),"New Registration", "Email",tx.getRef_id(),"Customer");
	
	tx.setTransaction_payment_mode("Registered-Member");
	tx.setTransaction_status("SUCCESS");
	
	//save data in transaction table		
	tx=service.saveCustomerTransaction(tx);

	
	
	//System.out.println("Done "+new Gson().toJson(tx));

	
/*	    request.setAttribute("keys",keys);
		request.setAttribute("firstName",name);
		request.setAttribute("amount",tx.getTransaction_amount());
		request.setAttribute("TxId",tx.getTransaction_order_id());
		request.setAttribute("txnDateTime",tx.getTransaction_created_date());
		request.setAttribute("TxStatus","SUCCESS");
		request.setAttribute("email",tx.getCustomer_email());
		request.setAttribute("paymentMode","Web User Site");
		request.setAttribute("action",keys.getReturn_url());
		request.setAttribute("method",keys.getForm_method());

		mav.setViewName("redirect:/redirection-url/"+tx.getMerchant_id()+"-"+tx.getTransaction_order_id()+"-"+name);
		  return mav;
*/	//return null;

	
	
	request.setAttribute("email",tx.getCustomer_email());
	request.setAttribute("amount","0");
	request.setAttribute("mobile",tx.getCustomer_mobile());
	request.setAttribute("address", address);
	request.setAttribute("name",name);
	request.setAttribute("validity", "0"); 
	
	/*New Added 3 sep*/
	request.setAttribute("merchantMobile", merchantMobile); 
	request.setAttribute("link", ""); 
	request.setAttribute("objectId", ""); 
	request.setAttribute("tx",tx );; 
	request.setAttribute("keyurl", keyurl); 
	request.setAttribute("mode", ""); 
	request.setAttribute("businessName", businessName); 
	request.setAttribute("xno", tx.getCustomer_mobile().substring(0, 2)+"XXXXXX"+tx.getCustomer_mobile().substring(8, 10)); 
	session.setMaxInactiveInterval(1000); 
	Map<String, Object> map=new ModelMap();
	

	
	String res="-";
	try {
	res=MyFunction.getOnlyStrings(tx.getCustomer_plan_name());
	if(res==null||res.isEmpty())
		res="-";
	
	}catch (NullPointerException e) {
		res="-";
	}
	
	String plan="-";
	try {
	
	if(!GetWay_Keys.empty(tx.getCustomer_plan_name())) {
		plan=GetWay_Keys.clean(tx.getCustomer_plan_name());
	}
		
	
	}catch (NullPointerException e) {
		plan="-";
	}
	
	   map.put("paymode","RC");
	   map.put("productinfo",res);
	   map.put("plan",plan);
	   map.put("firstname", name);
	   map.put("email", tx.getCustomer_email());
	   map.put("phone", tx.getCustomer_mobile());
	   map.put("amount","0");
	   map.put("amount1","0");
	   map.put("txnid", "RC"+System.currentTimeMillis());
	   map.put("udf1", ""+tx.getMerchant_id());
	   map.put("udf2", ""+tx.getMerchant_service_id());
       map.put("address", address);
	   map.put("businessName", businessName);
	   map.put("merchantMobile", merchantMobile);
	   map.put("validity", ""); 
	 //  map.put("tx", tx);
	   map.put("keyurl", keyurl);
	   map.put("mode", "");
	   map.put("keyurl", keyurl); 
	   String userId="-";
	   try {
	   if(GetWay_Keys.empty(tx.getCustomer_userId())) {
		   userId="-";
	   }else
		   userId=GetWay_Keys.clean(tx.getCustomer_userId());
	   }catch (NullPointerException e) {
		   userId="-";
	}
	   
	   System.err.println("User Id----------"+userId);
	   map.put("userId", userId);
	   session = request.getSession();


	session.setAttribute("data", map);
	
	return "deazzle/static-payment/otp";

	
}


@CrossOrigin
@ResponseBody
@RequestMapping(value="/landline-search/{keyurl}" ,method=RequestMethod.POST)
public ResponseEntity<String> landlineSearch(Model model,HttpServletRequest request,@PathVariable(value="keyurl")String  keyurl,
		String access_key,@RequestParam(value="service_code",required=false) String service_code,@RequestParam(value="mode",defaultValue="0")String mode,String user_key){
	
	//System.out.println("In Landline Search-"+keyurl);
	Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
		
	try {
			
			if(keys.equals(null)||keys==null)
				{
				return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
				}
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
		}	
		try {
			MerchantCustomerMaster list = service
					.searchUser("select * from Merchant_Customer_Master mcm where (mcm.merchant_customer_user_id='" + user_key + "') and mcm.merchant_id='"
							+ keys.getMerchant_key() + "'")
					.get(0);// and mcm.merchant_service_id="+ Long.parseLong(service_code)+"
			
			
			
			
			//System.out.println("data----->" + new Gson().toJson(list));
			if (list == null) {
				return new ResponseEntity<String>("User Not Available..", HttpStatus.BAD_REQUEST);
			} else {
				if (mode.equals("0")) {
					//check due date for billing
					double fine_amount=0;
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      	 
			       	Calendar cal3 = Calendar.getInstance();   	
			       	String date1 =formatter.format(cal3.getTime());
					String date2 =list.getDue_date();
					
					ALL a=service.getData("select tax.gst_tax from Tax_Master tax ,Merchant_Service_Detail_Master m where m.tax_id=tax.tax_id and m.merchant_service_id="+list.getMerchant_service_id());

					double tax=Double.parseDouble(a.getGst_tax());
					double gst_amount=list.getMerchant_customer_amount()*tax/100;
					list.setGst_amount(gst_amount);
					//System.out.println(list.getMerchant_customer_amount()+"+"+gst_amount+"="+list.getMerchant_customer_amount()+gst_amount);
					list.setMerchant_customer_amount(list.getMerchant_customer_amount()+gst_amount);
					if(date1.compareTo(date2)>0) {
								fine_amount=list.getFine_amount();
								list.setFinal_amount(list.getMerchant_customer_amount()+fine_amount+list.getPending_amount());
					}
					else if(date1.compareTo(date2)<=0){
						//fine_amount=list.getFine_amount();
						list.setFinal_amount(list.getMerchant_customer_amount()+list.getPending_amount());
					}
					
					
										
					return new ResponseEntity<String>(new Gson().toJson(list), HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("User is Available..", HttpStatus.OK);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<String>("User Not Available..", HttpStatus.BAD_GATEWAY);

		}
				
	
}
//-------Old V2 Api Code Api PHONE HOUSE Cha code
@RequestMapping(value="TaxInvoice/genrateTaxInvoice")
public ModelAndView genrateTaxInvoice(String custName,String custEmail,String custMobile,String custId,String custAddress,String amount,String gstId,
		String billNo,String billDueDate,String billDate,String billPeriod,String serviceCode,String serviceName,String SAC,int regId,HttpServletRequest request){

	TaxInvoice tax=new  TaxInvoice();
	tax.setAmount(amount);
	tax.setBillDate(billDate);
	tax.setBillDueDate(billDueDate);
	tax.setBillNo(billNo);
	tax.setBillPeriod(billPeriod);
	tax.setCustAddress(custAddress);
	tax.setCustEmail(custEmail);
	tax.setCustId(custId);
	tax.setCustMobile(custMobile);
	tax.setCustName(custName);
	tax.setGstId(gstId);
	tax.setRegId(regId);
	tax.setSAC(SAC);
	tax.setServiceCode(serviceCode);
	tax.setServiceName(serviceName);
	service.saveTaxInvoice(tax);
	insertInteraction(custEmail, custName, custMobile, 15, 64, "Tax Invoice", "Email", tax.getInvoiceId(), "TaxInvoice");

	request.setAttribute("custName", custName);
	request.setAttribute("custMobile", custMobile);
	request.setAttribute("custId", custId);
	request.setAttribute("custAddress", custAddress);
	request.setAttribute("amount", amount);
	request.setAttribute("gstId", gstId);
	request.setAttribute("billNo", billNo);
	request.setAttribute("billDueDate", billDueDate);
	request.setAttribute("billDate", billDate);
	request.setAttribute("billPeriod", billPeriod);
	request.setAttribute("serviceCode", serviceCode);
	request.setAttribute("serviceName", serviceName);
	request.setAttribute("SAC", SAC);
	invoiceEmail(custName, custEmail, custMobile, custId, custAddress, amount, gstId,serviceCode, billNo, billDueDate, billDate, billPeriod, serviceName,SAC);
	 return new ModelAndView("TaxInvoice","list","");
}



@RequestMapping(value="taxinvoice")
public ModelAndView taxinvoice(String custName,String custEmail,String custMobile,String custId,String custAddress,String amount,String gstId,
		String billNo,String billDueDate,String billDate,String billPeriod,String serviceCode ,String serviceName,String SAC,HttpServletRequest request){

	//insertInteraction(custEmail, custName, custMobile, 15, 64, "Tax Invoice", "Email", 0, "");
	request.setAttribute("custName", custName);
	request.setAttribute("custMobile", custMobile);
	request.setAttribute("custId", custId);
	request.setAttribute("custAddress", custAddress);
	request.setAttribute("amount", amount);
	request.setAttribute("gstId", gstId);
	request.setAttribute("billNo", billNo);
	request.setAttribute("billDueDate", billDueDate);
	request.setAttribute("billDate", billDate);
	request.setAttribute("billPeriod", billPeriod);
	request.setAttribute("serviceCode", serviceCode);
	request.setAttribute("serviceName", serviceName);
	request.setAttribute("SAC", SAC);
	//invoiceEmail(custName, custEmail, custMobile, custId, custAddress, amount, gstId, billNo, billDueDate, billDate, billPeriod);
	 return new ModelAndView("TaxInvoice","list","");
}


private static String USER_NAME = "noreply@deazzle.in'";
private static String PASSWORD = "R9[XKyzT8HunBP";
static String HOST = "smtp.gmail.com";
static String PORT = "587";
public static void invoiceEmail(String custName,String custEmail,String custMobile,String custId,String custAddress,String amount,String gstId,String serviceCode,
		String billNo,String billDueDate,String billDate,String billPeriod,String serviceName,String SAC) {
	   String[] to = {custEmail};
	     
	     String subject="Invoice from Phone House";
String msg="<form action='https://smartbizapi.deazzle.in/taxinvoice' method='GET' target='_blank'>"
+"<input type='hidden' name='custName' value='"+custName+"'>"
+"<input type='hidden' name='custEmail' value='"+custEmail+"'>"
+"<input type='hidden' name='custMobile' value='"+custMobile+"'>"
+"<input type='hidden' name='custId' value='"+custId+"'>"
+"<input type='hidden' name='custAddress' value='"+custAddress+"'>"
+"<input type='hidden' name='amount' value='"+amount+"'>"
+"<input type='hidden' name='gstId' value='"+gstId+"'>"
+"<input type='hidden' name='billNo' value='"+billNo+"'>"
+"<input type='hidden' name='billDueDate' value='"+billDueDate+"'>"
+"<input type='hidden' name='billDate' value='"+billDate+"'>"
+"<input type='hidden' name='billPeriod' value='"+billPeriod+"'>"
+"<input type='hidden' name='serviceCode' value='"+serviceCode+"'>"
+"<input type='hidden' name='serviceName' value='"+serviceName+"'>"
+"<input type='hidden' name='SAC' value='"+SAC+"'>"
+"<input type='submit' value='Download Invoice'>"
+"</form> ";

String str="https://smartbizapi.deazzle.in/taxinvoice/"+custName+"-*-"+custEmail+"-*-"+custMobile+"-*-"+custId+"-*-"+custAddress+"-*-"+
amount+"-*-"+gstId+"-*-"+billNo+"-*-"+billDueDate+"-*-"+billDate+"-*-"+billPeriod+"-*-"+serviceCode;
String msg1="<a href='"+str+"'><img src='https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/pdf.jpg' alt='Download Invoice' width='80' height='80'></a>";

Email5(custEmail, subject, msg,"phonehouse.asf@gmail.com");
/*
 * 
	   Properties props = System.getProperties();
	   props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.user", USER_NAME);
		props.put("mail.smtp.password", PASSWORD);
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.auth", "true");
	   
	   Session session = Session.getDefaultInstance(props);
	   MimeMessage message = new MimeMessage(session);

	   try {
	    message.setFrom(new InternetAddress(USER_NAME));
	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    // To get the array of addresses
	    for (int i = 0; i < to.length; i++) {
	     toAddress[i] = new InternetAddress(to[i]);
	    }

	    for (int i = 0; i < toAddress.length; i++) {
	     message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(subject);
	    message.setContent(msg, "text/html");
	    message.setRecipients(Message.RecipientType.CC, "phonehouse.asf@gmail.com");
	    //message.setRecipients(Message.RecipientType.BCC, "support@outgo.co");
	    // message.setText(body);
	    Transport transport = session.getTransport("smtp");
	    transport.connect( HOST, USER_NAME,PASSWORD );
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	   } catch (AddressException ae) {
	    ae.printStackTrace();
	   } catch (MessagingException me) {
	    me.printStackTrace();
	   }
*/	        //System.out.println("success");
	    
}



public static  boolean Email5(String email,String subject,String Email_Template_Welcome ,String cc) {
	System.out.println("In Mail");

     String[] to = {email};
     
     //String subject="Welcome To The OUTGO Family";

   Properties props = System.getProperties();
   props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.host", "smtp.gmail.com");
   props.put("mail.smtp.user", "noreply@deazzle.in");
   props.put("mail.smtp.password","R9[XKyzT8HunBP");
   props.put("mail.smtp.port", "587");
   props.put("mail.smtp.auth", "true"); //smtpauth.net4india.com
   props.put("mail.smtp.socketFactory.fallback", "true");
   Session session = Session.getDefaultInstance(props);
   MimeMessage message = new MimeMessage(session);

   try {
    message.setFrom(new InternetAddress("noreply@deazzle.in"));
    InternetAddress[] toAddress = new InternetAddress[to.length];

    // To get the array of addresses
    for (int i = 0; i < to.length; i++) {
     toAddress[i] = new InternetAddress(to[i]);
    }

    for (int i = 0; i < toAddress.length; i++) {
     message.addRecipient(Message.RecipientType.TO, toAddress[i]);
    }
    message.setRecipients(Message.RecipientType.CC, cc);

    message.setSubject(subject);
    message.setContent(Email_Template_Welcome, "text/html");
    // message.setText(body);
    Transport transport = session.getTransport("smtp");
    System.out.println("trans ");
    transport.connect( "smtp.gmail.com", "noreply@deazzle.in","R9[XKyzT8HunBP" );
    System.out.println("trans1 ");
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
   } catch (AddressException ae) {
    ae.printStackTrace();
   } catch (MessagingException me) {
    me.printStackTrace();
   }
        System.out.println("success");
     return false;


 }





//--- ! end



// commit testing
@CrossOrigin
@ResponseBody
@RequestMapping(value="/javaScriptSQLConsole",method = RequestMethod.GET)
public String javaScriptSQLConsole(ModelMap model,HttpServletRequest  request,String sql,String access_auth , String access_MID, String access_key, String access_id) {
			
	try {
		if(access_auth==null)
			return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";
		if(access_id==null)
			return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";
		if(access_key==null)
			return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";
		if(access_MID==null)
			return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";		
		if(Integer.parseInt(access_MID)!=0)
			return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";
			User u=service.getUserdetail("SELECT * FROM Contact_login cl where cl.id='"+access_id+"' and cl.mobileNo='"+access_auth+"' and cl.password='"+access_key+"' and  cl.merchantId='0' and cl.STATE='Administrator'");
		if(u==null)
			return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";
	}catch (NullPointerException e) {
		return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";
	}catch(NumberFormatException e) {
		return "[{\"Note\":\"Sorry Can not Use  Authorised  &#9785; &#9785; &#9785;\"}]";
	}
	
	
	
		if (sql.indexOf("DELETE") != -1 || sql.indexOf("delete") != -1 || sql.indexOf("Delete") != -1) {
			return "[{\"Note\":\"Sorry Can not Use  Delete SQL   &#9785; &#9785; &#9785;\"}]";
		} else {
		}
	
	if (sql.indexOf("select") != -1 || sql.indexOf("Select") != -1 || sql.indexOf("SELECT") != -1) {
		return new Gson().toJson(service.list(sql+" limit 60"));
    } else {
    }

	if (sql.indexOf("update") != -1 || sql.indexOf("Update") != -1 || sql.indexOf("UPDATE") != -1) {
		if(service.update(sql))
		return "[{\"Note\":\"Successfully Updated   &#9785; &#9785; &#9785;\"}]";
		else
			return "[{\"Note\":\"Please Check SQL  Query   &#9785; &#9785; &#9785;\"}]";
			
    } else {
    }
	
	
	// returning something
	
	return "[{\"Note\":\"Please Check SQL  Query   &#9785; &#9785; &#9785;\"}]";
   } 


public  void insertInteraction(String  email ,String name, String mobile, long serviceId, long merchantId,String description,String interaction, long ref_Id, String teb) {
	Interaction i=new Interaction();
	i.setMobile(mobile);
	i.setName(name);
	i.setDescription(description);
	i.setEmail(email);
	i.setMerchantId(merchantId);
	i.setServiceId(serviceId);
    i.setRef_Id(ref_Id);
	i.setInteraction(interaction);
	i.setRef_teb(teb);
	i=service.insertInteraction(i);
	
}









public void paymentEmails(TransactionMaster tx,ALL all,Settings settings,String firstName,String business) {
	String merchantMail=MyFunction.merchantEmail;
	  merchantMail=merchantMail.replace("[M-NAME]", business);		
	  merchantMail=merchantMail.replace("[AMOUNT]", tx.getTransaction_amount()+"");	        					
	  merchantMail=merchantMail.replace("[ORDER-ID]", tx.getTransaction_order_id());		
	 	
	  merchantMail=merchantMail.replace("[PRICE]", tx.getTransaction_amount()+"");
	  merchantMail=merchantMail.replace("[TOTAL-PRICE]",tx.getTransaction_amount()+"");
	  
	  merchantMail=merchantMail.replace("[NAME]", firstName);		
	  		
	  merchantMail=merchantMail.replace("[MOBILE]", tx.getCustomer_mobile());		  
	  merchantMail=merchantMail.replace("[EMAIL]", tx.getCustomer_email());		
	  merchantMail=merchantMail.replace("[T-DATE]", ""+tx.getTransaction_created_date());   
	  
	  String table="                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
				"                                    <tr>\n" + 
				"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
				"                                            <p style=\"font-weight: 800;\">Download. </p>\n" + 
				"                                            <p>\n <a href=\"https://smartbizapi.deazzle.in/invoice-"+tx.getTransaction_order_id()+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;text-align: center; width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #1b8a79; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Recipt</a>\n<br/>";
	  String table1=null;
	  if(settings.isRecipt()) { 
		  table1=  "	                                         <a href=\"https://smartbizapi.deazzle.in/receipt-"+tx.getTransaction_order_id()+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;text-align: center; width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #1b8a79; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Invoice</a>\n";
	  }else {
		  table1="<br>";
	  }
String table2= 	"                                            </p>\n" + 
				"                                        </td>\n" + //www.outgo.co //192.168.0.102:8080/outgo/receipt-"+TxId+"-smartBiz
				"                                    </tr>\n" + 
				"                                </table>\n";
	
	   //System.out.println("Email Code finish");
		 
		 
		  try {
			  merchantMail=merchantMail.replace("[ID]", tx.getCustomer_userId()); //error
		}catch(NullPointerException e) {
			merchantMail=merchantMail.replace("[ID]","-"); //error
				//System.out.println("----Email user Ex ---------------------------------------"+e);
		}
		  

		  try {
			  merchantMail=merchantMail.replace("[DESCRIPTION]", tx.getCustomer_plan_name());//error
		}catch(NullPointerException e) {
			merchantMail=merchantMail.replace("[DESCRIPTION]", "-");//error
		}
		  /*---------------------------------------------! Merchant-------------------------------------------------------	*/
		  //System.out.println("------------------------------------Mail Start-----------------------------------");
			 String userMail=MyFunction.userEmail;		  
			
			
			  userMail=userMail.replace("[CUSTOMER-NAME]", firstName);		
			  userMail=userMail.replace("[AMOUNT]", tx.getTransaction_amount()+"");	        					
			  userMail=userMail.replace("[ORDER-ID]", tx.getTransaction_order_id());		
			  		
			  userMail=userMail.replace("[PRICE]", tx.getTransaction_amount()+"");
			  userMail=userMail.replace("[TOTAL-PRICE]",tx.getTransaction_amount()+"");	  
			  userMail=userMail.replace("[M-NAME]", business);		
					
			  userMail=userMail.replace("[M-MOBILE]", all.getMobileNo());		  
			  userMail=userMail.replace("[M-EMAIL]", all.getEmail());		
			  userMail=userMail.replace("[T-DATE]", ""+tx.getTransaction_created_date());	
			
			 
			  try {
				  userMail=userMail.replace("[ID]", tx.getCustomer_userId()); //error
			}catch(NullPointerException e) {
				 userMail=userMail.replace("[ID]","-"); //error
			}
			 

			  try {
				  userMail=userMail.replace("[DESCRIPTION]", tx.getCustomer_plan_name());//error
			}catch(NullPointerException e) {
				userMail=userMail.replace("[DESCRIPTION]", "-");//error
			}
			  if(settings.isInvoice_email()==true) {
				  userMail=userMail.replace("[TABLE]", "<table>&nbsp</table>");	 
				 
				 
  			  }else {
  				  userMail=userMail.replace("[TABLE]", table+table1+table2);
  			  }
			  
			  
			  //System.out.println("\n\n\n USER TEMPLATE  ...............................\n\n"+userMail);
			  
			  /*Customer Email*/
			  MyFunction.Email(tx.getCustomer_email(),  "Payment for "+business, userMail);

			 /*Customer Sms*/ 
			String msg="Dear Customer, your payment of Rs."+tx.getTransaction_amount()+" to "+business+" has been successful. Payment reference is "+tx.getTransaction_order_id()+".Thank you. deAzzle";
  			MyFunction.sendSMS(tx.getCustomer_mobile(), msg,  Link.SELF_SMS_LINK);

  			
			  try {
				  if(all.equals(null)) {
		
	}else {
		int diff = AppController.dateDiff2(all.getExpiry_date());
		if (diff < 0) {				        				
			
			if(all.getService().equals("Pay As You Go")) {
				msg="You have received a payment of Rs. "+tx.getTransaction_amount()+" from: "+firstName+", userid :"+tx.getCustomer_userId()+" , plan :"+tx.getCustomer_plan_name()+" ,contact no. : "+tx.getCustomer_mobile()+". Thx. deAzzle";
    			 
    			/* SMSThread s1=new SMSThread(all.getMobileNo(), msg, Link.SELF_SMS_LINK);	s1.start();*/ 
    			
    			MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
    			MyFunction.Email(all.getEmail(),  "Payment of "+firstName, merchantMail);
				
			}else {
				//System.out.println("diffff" + diff);// Expired (false)
				 msg="Dear Customer, you have received a payment. To view the details, please renew the deAzzle Smartbiz subscription at https://www.deazzle.in/ .Thankyou, deAzzle";
				MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
				MyFunction.Email(all.getEmail(),  "Payment of "+firstName, msg);
				
				
				
				
			}
			
		} else {
			// Not Expired (true)   					        				 
			
			msg="You have received a payment of Rs. "+tx.getTransaction_amount()+" from: "+firstName+", userid :"+tx.getCustomer_userId()+" , plan :"+tx.getCustomer_plan_name()+" ,contact no. : "+tx.getCustomer_mobile()+". Thx. deAzzle";
			/* SMSThread s1=new SMSThread(all.getMobileNo(), msg, Link.SELF_SMS_LINK);	s1.start();*/ 
			
			MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
			MyFunction.Email(all.getEmail(),  "Payment of "+firstName, merchantMail);
			System.out.println(" SEND SMS "+msg);
		}
	}
} catch (NullPointerException e) {
	
}
			  
			  
			  
			  
}


public void autorenew(String validity ,Merchant_Payment_keys keys,TransactionMaster tx) {
try {
    MerchantCustomerMaster reg=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+tx.getCustomer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" limit 1");
   try {
   	 if(reg!=null) {			        		    	 
	       		    	 reg.setStatus(true);
	       		    	reg=service.saveRegisterCustomer(reg);
	       		    	}
	     
	} catch (NullPointerException e) {	} 
    
    if(keys.isAuto_renual()==true) { 
   	 
        MerchantCustomerMaster regCust=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+tx.getCustomer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" limit 1");
   	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      	 
	       	Calendar cal3 = Calendar.getInstance();   	
			String date1 =formatter.format(cal3.getTime());
			String date2 =regCust.getMerchant_customer_plan_expire_date();
			try {
					if(validity==null)
						validity="0";
			}catch(NullPointerException n) {validity="0";}
			
			
			 try {
				 if(!regCust.getMerchant_customer_user_id().equals("new")) {
					 //System.out.println("--------------------------is new---------------------------------------");
				 
				 if(regCust.getMerchant_customer_plan_expire_date().equals(null)|| regCust.getMerchant_customer_plan_expire_date()==null || regCust.getMerchant_customer_plan_expire_date().isEmpty())
					{
						
						
					}else {
						 if(date1.compareTo(date2)>0){				 
							 //System.out.println("Date1 is after Date2");
							 date2=date1;
							 int validity3=Integer.parseInt(validity);
					 			Date date = null;
								try {
									date = formatter.parse(date2);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				 				Calendar cal = Calendar.getInstance();
				 				cal.setTime(date);
				 		        cal.add(cal.DATE, validity3);// setting value to cal 
				 		       date2=formatter.format(cal.getTime());
							 //System.out.println("renual date-->"+date1+"----Expire Date---->>"+date2);
							 
							 
							 
						 }else  if(date1.compareTo(date2)<0){
							 
							 //System.out.println("Date1 is before Date2");
							 date1=date2;
					 			int validity3=Integer.parseInt(validity);
					 			Date date = null;
								
									try {
										date = formatter.parse(date2);
									
								
				 				Calendar cal = Calendar.getInstance();
				 				cal.setTime(date);
				 		        cal.add(cal.DATE, validity3);// setting value to cal 
				 		       date2=formatter.format(cal.getTime());
				 		      //System.out.println("renual date-->"+date1+"----Expire Date---->>"+date2);
				 		    
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							 
						 }else
						 {
							 //System.out.println("Both Dates are equal");
							 
							 date2=date1;
					 			int validity3=Integer.parseInt(validity);
					 			Date date = null;
								try {
									date = formatter.parse(date2);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				 				Calendar cal = Calendar.getInstance();
				 				cal.setTime(date);
				 		        cal.add(cal.DATE, validity3);// setting value to cal 
				 		       date2=formatter.format(cal.getTime());
				 		      //System.out.println("renual date-->"+date1+"----Expire Date---->>"+date2);
				 		    
						 }
						
						//System.out.println("in else");
						
						  boolean c=service.update("update Merchant_Customer_Master m set m.merchant_customer_plan_expire_date='"+date2+"'"
				 		    		+ ",m.merchant_customer_plan_renew_date='"+date1+"',m.payment_status=true  where m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  
/*						  boolean txn=service.update("update Transaction_Master tm set tm.transaction_renew_date='"+date1+"'"
					 		   		+ ",tm.transaction_expire_date='"+date2+"',tm.transaction_active_status=true where tm.transaction_order_id='"+tx.getTransaction_order_id()+"'");
*/						
					}
				 }
				} catch (NullPointerException e) {
					try {
			 			
			 			Date date = null;	
			 			int validity3=Integer.parseInt(validity);
						date = formatter.parse(date1);
						Calendar cal = Calendar.getInstance();
							cal.setTime(date);
					        cal.add(cal.DATE, validity3-1);// setting value to cal 
					       String expDate=formatter.format(cal.getTime());
					       //System.out.println("Null Exception---"+date1+"--jjjjj---"+expDate);
				 		   
				 		    boolean c=service.update("update Merchant_Customer_Master m set m.merchant_customer_plan_expire_date='"+expDate+"'"
				 		    		+ ",m.merchant_customer_plan_renew_date='"+date1+"' ,m.payment_status=true where "
				 		    		+ " m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  
/*				 		   boolean txn=service.update("update Transaction_Master tm set tm.transaction_renew_date='"+date1+"'"
				 		   		+ ",tm.transaction_expire_date='"+expDate+"', tm.transaction_active_status=true  where tm.transaction_order_id='"+tx.getTransaction_order_id()+"'");
*/					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			
		     	
    }else {
			MerchantCustomerMaster regCust=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+tx.getCustomer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" limit 1");

		    boolean c=service.update("update Merchant_Customer_Master m set m.payment_status=true where "
		    		+ " m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  

   	
    }
   
    
    //===================================================================================
      
    //System.out.println("Print 4: "+"----------------------Out----------------------");

}catch (NullPointerException e) {
	// TODO: handle exception
}
    
}




}

