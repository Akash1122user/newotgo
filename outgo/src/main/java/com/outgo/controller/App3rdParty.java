package com.outgo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.outgo.bean.ALL;
import com.outgo.bean.Interaction;
import com.outgo.bean.MerchantCustomerMaster;
import com.outgo.bean.MerchantServiceDetailMaster;
import com.outgo.bean.Merchant_Payment_keys;
import com.outgo.bean.OtherCustomerRegisterMaster;
import com.outgo.bean.SendKeys;
import com.outgo.bean.Settings;
import com.outgo.bean.TransactionMaster;
import com.outgo.keyClass.CitrusKey;
import com.outgo.messages.Link;

import com.outgo.myfun.MyFunction;
import com.outgo.services.ApiServices;
@RestController
public class App3rdParty {
	@Autowired
	ApiServices service;
	

	/*
	 *  Asynchronous Action
	 * 
	*/

		
	@RequestMapping(value = "/pay-now/{key_url}/{order_id}/{vendor_id}/{cust_id}/{cust_name}/{cust_mobile}/{cust_email}/{remark}/{amount}/{vendor_serviceId}")
	/*@RequestMapping(value = "/pay-now",method=RequestMethod.POST)*/
	public String pay3rdParty(Model model, HttpServletRequest request,		
			@PathVariable(value = "key_url") String key_url,//url
			@PathVariable(value="order_id") String order_id,
			@PathVariable(value = "vendor_id") long vendor_id,//merchantId
			@PathVariable(value = "cust_id") String cust_id,
			@PathVariable(value = "cust_name") String cust_name,
			@PathVariable(value = "cust_mobile") String cust_mobile,
			@PathVariable(value = "cust_email") String cust_email,
			@PathVariable(value = "remark") String remark,
			@PathVariable(value = "amount") String amount,
			@PathVariable(value = "vendor_serviceId") long vendor_serviceId //merchant_service_id
			/*	@RequestParam(value = "key_url") String key_url,//url
				@RequestParam(value="order_id") String order_id,
				@RequestParam(value = "vendor_id") long vendor_id,//merchantId
				@RequestParam(value = "cust_id") String cust_id,
				@RequestParam(value = "cust_name") String cust_name,
				@RequestParam(value = "cust_mobile") String cust_mobile,
				@RequestParam(value = "cust_email") String cust_email,
				@RequestParam(value = "remark") String remark,
				@RequestParam(value = "amount") String amount,
				@RequestParam(value = "vendor_serviceId") long vendor_serviceId//merchant_service_id
			 	*/			
			){
			TransactionMaster txn=new TransactionMaster();
			//long merchant_id=14;	
			Merchant_Payment_keys mk=service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+key_url+"'");
			
			if(mk.equals(null)){
				model.addAttribute("error","Authentication Fail...Invalid Key");
				return "error";	
			}
			if(!mk.getMerchant_key().equals(vendor_id+"")) {
				model.addAttribute("error","Authentication Fail...Invalid Key");
				return "error";	
			}
			if(order_id.equals(null)|| order_id.isEmpty()) {
				model.addAttribute("error","Authentication Fail...Invalid Order Id");
				return "error";	
			}
			try {		
				if((vendor_serviceId)==0L)
				{
					model.addAttribute("error","Authentication Fail...Please check your Service ID.");
					return "error";	
				}
			}catch(NullPointerException e)
			{		
				   model.addAttribute("error","Authentication Fail...Please check your Service ID.");
				   return "error";	
			}
			MerchantServiceDetailMaster mcm=service.getServiceData(vendor_serviceId);
			
			System.out.println("my service---"+mcm.getMerchant_service_id()); // syso
			
			if(mcm.getMerchant_service_id()!=vendor_serviceId) {
				 model.addAttribute("error","Authentication Fail...Service is not registered.");
				   return "error";	
			}
			if(mcm.getMerchant_id()!=vendor_id) {
				model.addAttribute("error","Authentication Fail...Wrong service selection.");
				   return "error";	
				}
		
			try {		
				if(cust_id==null||cust_id.equals(""))
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
			if(cust_name==null||cust_name.equals(""))
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
			if(cust_mobile==null||cust_mobile.equals(""))
			{		
				model.addAttribute("error","Authentication Fail...Please Enter Mobile No.");
				return "error";	
			}
			if (!cust_mobile.matches("\\d{10}")) 
			{		
				model.addAttribute("error","Authentication Fail...Please Enter Mobile No.");
				return "error";	
			}
		}catch(NullPointerException e)
		{		
			 model.addAttribute("error","Authentication Fail...Please Enter Mobile No.");
			 return "error";	
		}
		
		try {		
			if(cust_email==null||cust_email.equals(""))
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
			if(amount==null || amount.equals(""))
			{
				if(Long.parseLong(amount)==0) {
				model.addAttribute("error","Authentication Fail...Please Enter Amount.");
			    return "error";
			    }else {
			    	model.addAttribute("error","Authentication Fail...Please Enter Amount.");
				    return "error";
			    }
			}	
			
		}catch(NullPointerException e)
		{		
			model.addAttribute("error","Authentication Fail...Please Enter Amount.");
			return "error";	
		}	
		txn.setCustomer_email(cust_email);
		txn.setCustomer_mobile(cust_mobile);	
		txn.setCustomer_plan_name(remark);
		txn.setCustomer_userId(cust_id);
		txn.setMerchant_id(vendor_id);
		txn.setMerchant_service_id(vendor_serviceId);
		txn.setTransaction_amount(Double.parseDouble(amount));
		txn.setTransaction_mode("App");
		txn.setTransaction_payment_gatway_name("Citrus");
		txn.setTransaction_type("Online");
		txn.setTransaction_order_id(order_id);
		OtherCustomerRegisterMaster o=service.getNonRegisterCustomer("select * from Non_Register_Customer n where n.other_cust_mobile='"+cust_mobile+"'");
		//System.out.println("list "+new Gson().toJson(o));
		try{
		if(o==null){
			OtherCustomerRegisterMaster ocrm=new OtherCustomerRegisterMaster();
			ocrm.setOther_cust_address("N/A");
			ocrm.setOther_cust_email(cust_email);
			ocrm.setOther_cust_mobile(cust_mobile);
			ocrm.setOther_cust_name(cust_name);
			ocrm=service.saveNonRegisterCustomer(ocrm);
			txn.setRef_id(ocrm.getOther_cust_id());
			txn.setRef_table("non_register_customer");
		}else{
			txn.setRef_id(o.getOther_cust_id());
			txn.setRef_table("non_register_customer");
		}}catch(NullPointerException n){
			OtherCustomerRegisterMaster ocrm=new OtherCustomerRegisterMaster();
			ocrm.setOther_cust_address("N/A");
			ocrm.setOther_cust_email(cust_email);
			ocrm.setOther_cust_mobile(cust_mobile);
			ocrm.setOther_cust_name(cust_name);
			ocrm=service.saveNonRegisterCustomer(ocrm);
			txn.setRef_id(ocrm.getOther_cust_id());
			txn.setRef_table("Non_Register_Customer");
			}
			
		/*try {
			if(tx.getTransaction_order_id()==null)
				tx.setTransaction_order_id("UAP"+System.currentTimeMillis());
			if(tx.getTransaction_order_id().equals(""))
				tx.setTransaction_order_id("UAP"+System.currentTimeMillis());			
		}catch(NullPointerException n) {tx.setTransaction_order_id("UAP"+System.currentTimeMillis());
		}*/
		//save data in transaction table		
		txn=service.saveCustomerTransaction(txn);
		System.out.println("Done "+new Gson().toJson(txn));		
		//search service by service id
			
		request.setAttribute("email",txn.getCustomer_email());		
		request.setAttribute("amount",amount);
		request.setAttribute("mobile",txn.getCustomer_mobile());
		request.setAttribute("address", "N/A");
		request.setAttribute("name",cust_name);
		request.setAttribute("service_name","N/A");
		request.setAttribute("validity", "N/A"); //Pranal Changes		
		request.setAttribute("mode", "App"); //Pranal Changes		
		SendKeys key=new SendKeys();
		key.setCurrency(CitrusKey.currency);
		key.setFormPostUrl(CitrusKey.formPostUrl);
		key.setMerchantTxnId(txn.getTransaction_order_id());
		key.setEmail(txn.getCustomer_email());
		key.setMobile(txn.getCustomer_mobile());		
		key.setAddress("N/A");
		key.setReturnURL(CitrusKey.returnURL+"redirectRel");	
		key.setAmount(Double.parseDouble(amount));
		key.setSecuritySignature(CitrusKey.securitySignature(amount+"" , txn.getTransaction_order_id()));
		request.setAttribute("returnURL",CitrusKey.returnURL+"redirectRel");
		request.setAttribute("formPostUrl",CitrusKey.formPostUrl);
		request.setAttribute("currency",CitrusKey.currency);
		request.setAttribute("MerchantTxnId",key.merchantTxnId);
		request.setAttribute("secSignature",key.securitySignature);	
		
		
		return "appOutgo/cnfInfoREL"; //brpay
	}	
	
	
	
	
	@RequestMapping(value="/redirectRel" )
	public  ModelAndView redirectRel(Model model,HttpServletRequest request ){
		/*JSONObject obj = new JSONObject();*/
		System.out.println("Print 1:  Coming First");
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
		String mode=request.getParameter("addressStreet2");
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

		//System.out.println("mode-->"+mode);
		
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
			        			
			        			System.out.println("Email Merchant ---------------------------------------");
			        			String merchantMail=MyFunction.merchantEmail;
			        			
			        				 //https://
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
				        							"                                            <p>\n" + 
				        							"                                            <a href=\"www.outgo.co/invoice-"+TxId+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;     width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #269fff; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Download</a>\n" + 
				        							"                                            </p>\n" + 
				        							"                                        </td>\n" + 
				        							"                                    </tr>\n" + 
				        							"                                </table>\n";*/
				        			  
				        			  
				        			  String table="                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			        							"                                    <tr>\n" + 
			        							"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
			        							"                                            <p style=\"font-weight: 800;\">Download. </p>\n" + 
			        							"                                            <p>\n <a href=\"https://smartbizapi.deazzle.in/invoice-"+TxId+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;text-align: center; width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #269fff; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Recipt</a>\n<br/>";
				        			  String table1=null;
				        			  if(settings.isRecipt()) { 
				        				  table1=  "	                                         <a href=\"https://smartbizapi.deazzle.in/receipt-"+TxId+"-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;text-align: center; width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #269fff; padding: 6px 21px; border: 1px solid #66b3b7; display: block;\">Invoice</a>\n";
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
					        			 //---------------------------------------------! Merchant-------------------------------------------------------	
					        			 // System.out.println("------------------------------------Mail Start-----------------------------------");
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
							        			 
							        		// SMSThread s1=new SMSThread(all.getMobileNo(), msg, Link.SELF_SMS_LINK);	s1.start(); 
							        			
							        			MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
							        			MyFunction.Email(all.getEmail(),  "Payment To "+firstName, merchantMail);
					        					
					        				}else {
					        					//System.out.println("diffff" + diff);// Expired (false)
						        				 msg="Dear Customer, you have received a payment. To view the details, please renew the deAzzle Smartbiz subscription at https://www.deazzle.in .Thankyou, deAzzle";
						        				MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
						        				MyFunction.Email(all.getEmail(),  "Payment To "+firstName, msg);
					        				}
					        				
					        			} else {
					        				// Not Expired (true)   					        				 
					        				
						        			msg="You have received a payment of Rs. "+tx.getTransaction_amount()+" from: "+firstName+", userid :"+tx.getCustomer_userId()+" , plan :"+tx.getCustomer_plan_name()+" ,contact no. : "+tx.getCustomer_mobile()+". Thx. deAzzle";
						        			// SMSThread s1=new SMSThread(all.getMobileNo(), msg, Link.SELF_SMS_LINK);	s1.start(); 
						        			
						        			MyFunction.sendSMS(all.getMobileNo(), msg,  Link.SELF_SMS_LINK); 
						        			MyFunction.Email(all.getEmail(),  "Payment To "+firstName, merchantMail);
					        			}
			        				}
								} catch (NullPointerException e) {
									
								}
			        			
			        			 
			        			//SMSThread s=new SMSThread(tx.getCustomer_mobile(), msg, Link.SELF_SMS_LINK);
			        			//s.start();	
			        		
			        			  //================================ New ==================================   
			        		     if(keys.isAuto_renual()==true) {        		    	 
			        		    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      	 
			        			       	Calendar cal3 = Calendar.getInstance();   	
			        			       	//System.out.println("in Auto renual mode---"+validity);
			        					MerchantCustomerMaster regCust=service.searchUserMerchant("select * from Merchant_Customer_Master m where m.merchant_customer_mobile='"+tx.getCustomer_mobile()+"' and m.merchant_id="+keys.getMerchant_key()+" and m.merchant_service_id="+tx.getMerchant_service_id());
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
			        						 		    		+ ",m.merchant_customer_plan_renew_date='"+date1+"' where m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  
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
			        						 		    		+ ",m.merchant_customer_plan_renew_date='"+date1+"' where "
			        						 		    		+ " m.merchant_customer_id="+regCust.getMerchant_customer_id()+" and m.merchant_id="+regCust.getMerchant_id());  
			        						 		   boolean txn=service.update("update Transaction_Master tm set tm.transaction_renew_date='"+date1+"'"
			        						 		   		+ ",tm.transaction_expire_date='"+expDate+"', tm.transaction_active_status=true  where tm.transaction_order_id='"+tx.getTransaction_order_id()+"'");
			        							} catch (ParseException e1) {
			        								e1.printStackTrace();
			        							}
			        						}
			        					
			        				     	
			        		     }
			        		     
			        		     //===================================================================================
			        		       
			        		     //System.out.println("Print 4: "+"----------------------Out----------------------");
			        	
		     		}
		     	 		
		     	}
		     }catch(NullPointerException e) {}  
	     
	 	/*obj.put("FirstName", firstName);
	 	obj.put("Amount", amount);
	 	obj.put("Order Id", TxId);
	 	obj.put("Transaction Date ", txnDateTime);
	 	obj.put("Transaction status", request.getParameter("TxStatus"));
	 	obj.put("Email Id", email);
	 	obj.put("Payment Mode", paymentMode);
		obj.put("message", TxMsg);
		return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);*/	 	 
	 	  /*request.setAttribute("keys",keys);
			request.setAttribute("firstName",firstName);
			request.setAttribute("amount",amount);
			request.setAttribute("TxId",TxId);
			request.setAttribute("txnDateTime",txnDateTime);
			request.setAttribute("TxStatus",request.getParameter("TxStatus"));
			request.setAttribute("email",email);
			request.setAttribute("paymentMode",paymentMode);
			request.setAttribute("action",keys.getReturn_url());
			request.setAttribute("method",keys.getForm_method());
			mav.setViewName("redirect:/redirection-url/"+tx.getMerchant_id()+"-"+tx.getTransaction_order_id()+"-"+firstName);
			    return mav;*/
		
	 	/*request.setAttribute("firstName",firstName);
		request.setAttribute("amount",amount);
		request.setAttribute("TxId",TxId);
		request.setAttribute("txnDateTime",txnDateTime);
		request.setAttribute("TxStatus",request.getParameter("TxStatus"));
		request.setAttribute("email",email);
		request.setAttribute("paymentMode",paymentMode);*/
		//request.setAttribute("action",keys.getReturn_url());
		//request.setAttribute("method",keys.getForm_method());

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
		
		mav.setViewName("redirect:/redirection-url1/"+tx.getMerchant_id()+"-"+tx.getTransaction_order_id()+"-"+firstName);
				//return mav;
		return mav;
		
	}	
	@RequestMapping(value="/redirection-url1/{merchantId}-{TxId}-{firstName}" ,method=RequestMethod.GET)
	public  ModelAndView redirectionurl(Model model,HttpServletRequest request,@PathVariable(value="merchantId")String merchantId,@PathVariable(value="TxId")String TxId,@PathVariable(value="firstName")String firstName  ){
		
		
	 	Merchant_Payment_keys keys=service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key='"+merchantId+"'");
		TransactionMaster tx=service.getTransaction(TxId);	
		  request.setAttribute("keys",keys);
			request.setAttribute("firstName",firstName);
			request.setAttribute("amount",tx.getTransaction_amount());
			request.setAttribute("TxId",TxId);
			System.out.println("my ID--"+TxId);
			request.setAttribute("txnDateTime",tx.getTransaction_update_date());
			request.setAttribute("TxStatus",tx.getTransaction_status());
			request.setAttribute("email",tx.getCustomer_email());
			request.setAttribute("paymentMode",tx.getTransaction_payment_mode());
			request.setAttribute("action",keys.getReturn_url());
			request.setAttribute("method",keys.getForm_method());
			ModelAndView mav = new ModelAndView();
			mav.setViewName("ResponsePage");
			//mav.setViewName("appOutgo/appResponse1");
		     //System.out.println("Print 5: "+"----------------------END----------------------");
			    return mav;

	}
	@ResponseBody
	@RequestMapping(value="/appResp")
	public ModelAndView  appResp(ModelMap model,TransactionMaster tx,HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		String txnStatus = request.getParameter("txnStatus");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String amount = request.getParameter("amount");
		String marketplaceTxId = request.getParameter("txnId");
		String txnDateTime = request.getParameter("txnDateTime");
		// String orgName=request.getParameter("lastName");
		String paymentMode = request.getParameter("paymentMode");
		//request.setAttribute("txnStatus", txnStatus);
		request.setAttribute("txnStatus", txnStatus);
		request.setAttribute("email", email);
		request.setAttribute("name", name);
		request.setAttribute("amount", amount);
		request.setAttribute("TxId", marketplaceTxId);
		request.setAttribute("txnDateTime", txnDateTime);
		request.setAttribute("paymentMode", paymentMode);
		//model.addAttribute("txnStatus", txnStatus);
		System.out.println("res00000"+txnStatus);
		
		
		
	    mav.setViewName("appOutgo/appResponse1");
	    return mav;
	}
	
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/registraionStatus-As/{keyurl}", method = RequestMethod.POST,headers = "Accept=application/json")
	public String newRegistrationTTAs(		
			Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,
			MerchantCustomerMaster cust,String access_key){
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
		
	 		
	 		try {
	 			if(cust.getMerchant_customer_user_id().equals(null)||cust.getMerchant_customer_user_id().isEmpty() ||cust.getMerchant_customer_user_id()=="")
	 				cust.setMerchant_customer_user_id("new");
	 			else
	 				cust.setMerchant_customer_user_id(cust.getMerchant_customer_user_id());			
			} catch (NullPointerException e) {			
			}
			
			cust.setMerchant_customer_description("New Registration");		
		
				 
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

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/registraionStatus-As-img/{keyurl}", method = RequestMethod.POST,headers = "Accept=application/json")
	public String newRegistrationImg(		
			Model model,HttpServletRequest request, @PathVariable("keyurl") String keyurl,
			@RequestParam(value="imageFile1",required=false ) MultipartFile imageFile1,
			@RequestParam(value="imageFile2" , required=false) MultipartFile imageFile2,
			@RequestParam(value="imageFile3",required=false) MultipartFile imageFile3,MerchantCustomerMaster cust,String access_key) throws InterruptedException{
		Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+keyurl+"' and m.access_key='"+access_key+"'");
				
	
		ALL all=service.getData("select  cl.email,cl.mobileNo  from  Merchant_Info mi,Contact_login cl where cl.merchantId="+keys.getMerchant_key()+" and mi.merchantId="+keys.getMerchant_key()+"  GROUP BY mi.merchantId");

				String mailTo =all.getEmail();
				//String mailTo = "pran.savarkar@gmail.com";
				String subject = "Registration email with attachments";
				String host = "smtp.gmail.com";
				String port = "587";
				String mailFrom = "noreply@deazzle.in";
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
				System.out.println("datall,l");
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
		    			System.out.println("datall,sdasdsl");
						ApiController.sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
						         subject, message, imageFile1,imageFile2,imageFile3);
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	 		
		    		 		 
		    		 System.out.println("Email sent. test");
		    		}
		    	
			 	return "ok";

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
}
