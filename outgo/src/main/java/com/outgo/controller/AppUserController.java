package com.outgo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.outgo.bean.ALL;
import com.outgo.bean.CustomerMaster;
import com.outgo.bean.ExpenceMaster;
import com.outgo.bean.ExpenseCategories;
import com.outgo.bean.IncomeMaster;
import com.outgo.bean.Interaction;
import com.outgo.bean.MerchantServiceDetailMaster;
import com.outgo.bean.MessagesMaster;
import com.outgo.bean.OTP_Verifay;
import com.outgo.messages.Messages;
import com.outgo.myfun.MyFunction;
import com.outgo.services.ApiServices;
@Controller
public class AppUserController {
	@Autowired
	ApiServices service;
	
	
	@RequestMapping(value = "/signupuser", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> signUpUser(Model model, HttpServletRequest request,
			@RequestParam(value = "fullname") String fullname,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "mobileNo") String mobileNo,
			@RequestParam(value = "userPassword") String userPassword) {
		
			JSONObject obj = new JSONObject();
		//System.out.println("fullname---->"+fullname);
		//System.out.println("email---->"+email);
		//System.out.println("mobileNo---->"+mobileNo);
		//System.out.println("userPassword---->"+userPassword);
			try {		
			
			if(fullname.equals(null)||fullname.isEmpty()) {
				obj.put("message", "Name should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			} catch (NullPointerException e) {
				obj.put("message", "Name should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			try {				
			
			if(email.equals(null) || email.isEmpty()) {
				obj.put("message", "Email should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			} catch (NullPointerException e) {
				obj.put("message", "Email should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			
			if(!validateEmail(email)) {
				obj.put("message", "Email is not valid!");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			
			
			try {				
			
			if(mobileNo.equals(null) || mobileNo.isEmpty()) {
				obj.put("message", "Mobile Number should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
	
			}
			} catch (NullPointerException e) {
				obj.put("message", "Mobile Number should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			
			
			if (mobileNo.matches("\\d{10}")) {}else {
				obj.put("message", "Mobile Number is not valid !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}


			
			try {
				
			
			if(userPassword.equals(null) || userPassword.isEmpty()) {
				obj.put("message", "Password should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			} catch (NullPointerException e) {
				obj.put("message", "Password should not be empty !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
					
			String pattern = "(?=.*[0-9])";
			
								 pattern = ".{6,}";
									if (userPassword.matches(pattern)) {}else {
										obj.put("message", "Password at least 6 characters!");
										return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
									}
						
				
				
		CustomerMaster customer=new CustomerMaster();
		try {
			CustomerMaster cust=null;
			cust=service.checkCustomer("Select * from Customer_Master cm where cm.customer_mobile='"+mobileNo+"'");
			//System.out.println("cust data---"+cust);
		if(cust!=null) {
			obj.put("message", "Customer is Already Registered !");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
		}
		} catch (NullPointerException e) {
			//System.out.println("cust null");
			obj.put("message", "error");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
		}
		customer.setCustomer_email(email);
		customer.setCustomer_mobile(mobileNo);
		customer.setCustomer_name(fullname);
		customer.setCustomer_verfiy_mobile(false);
		customer.setCustomer_verfiy_email(false);
		customer.setCustomer_password(userPassword);
		boolean custo= service.saveOutGoCustomer(customer);
		if(custo) {
			
			String otp=	String.valueOf(OTP_Verifay.OTP(6));
			OTP_Verifay OTP =new OTP_Verifay();
			OTP.setMobileNo(mobileNo);
			OTP.setOTP(otp);
			OTP.setCreateDate(MyFunction.date());
			OTP.setUpdateDate(MyFunction.date());
			OTP.setStatus(false);
			service.insertOTP(OTP);
			String message = Messages.OTP_MOBILE_VERIFICATION;
			
			message =message.replace("[OTP]", otp);
			//System.out.println(message);
			insertInteraction(email, fullname, mobileNo, 47, 81, "Customer Verification", "SMS", customer.getCustomer_id(), "OCustomer");
			
			MyFunction.sendOTP(mobileNo,message);  //SMS OTP
			//System.out.println("my ID----"+OTP.getId());
			obj.put("code", OTP.getId());
			obj.put("message", "Singnup Successfully!");			
			return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
		}else {
			obj.put("message", "error");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			
				
		}
		
	
	
	
	public boolean validateEmail(String email) {
		Matcher matcher;
		final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern  pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	
	
	
	@RequestMapping(value = "/validate-mobile", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> ValidateMyMobile(Model model, HttpServletRequest request,
			@RequestParam(value = "code") String code,
			@RequestParam(value = "otp") String otp,
			@RequestParam(value = "mobileNo") String mobileNo
			)
			 {
			JSONObject obj = new JSONObject();
			//System.out.println("code--->"+code);
			//System.out.println("otp--->"+otp);
			//System.out.println("mobileNo--->"+mobileNo);	
			CustomerMaster cust=service.checkCustomer("Select * from Customer_Master cm where cm.customer_mobile='"+mobileNo+"'and cm.customer_verfiy_mobile=false");
			
			if (otp.matches("\\d{6}")) {

				OTP_Verifay otpv = service.validateOTP(otp, mobileNo,Long.parseLong(code));	
				//System.out.println("---OTP Data---"+new Gson().toJson(otpv));
				try {					
				
				if (otpv.getOTP().equals(otp)) {
					otpv.setId(Long.parseLong(code));
					otpv.setStatus(true);	
					//System.out.println("OTO------------> 2"+new Gson().toJson(otpv));					
					otpv=service.insertOTP(otpv);//NotUpdated
					//System.out.println("OTO------------>3 "+new Gson().toJson(otpv));
					cust.setCustomer_verfiy_mobile(true);
					cust.setStatus(true);
					service.saveOutGoCustomer(cust);
					
					MyFunction.Email(cust.getCustomer_email(), "Welcome To deAzzle", "	Dear Customer, Welcome to deAzzle family. We hope to give the most value add for your business. Thank you for choosing our services. deAzzle Team..");
					insertInteraction(cust.getCustomer_email(), cust.getCustomer_name(), mobileNo, 47, 81, "Welcome Customer ", "SMS", cust.getCustomer_id(), "OCustomer");

					
					obj.put("message","success");
					//System.out.println("success");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
				}else {
					obj.put("message", "Invalid OTP");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				} catch (NullPointerException e) {
					//System.out.println("null pointer Ex--"+e);
					obj.put("message", "error");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);	
				}
				
				
			}else {
				obj.put("message", "Invalid OTP");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);	
			}
			
			
		 }
	
	
	@RequestMapping(value = "/user-login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> userLogin(Model model, HttpServletRequest request,
			@RequestParam(value = "mobileNo") String mobileNo,
			@RequestParam(value = "password") String password
			
			)
			 {
		JSONObject obj = new JSONObject();
		
		try {
			if(mobileNo==null||mobileNo.equals("")) {
				obj.put("message","Please Enter valid Customer Mobile");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			
		}catch(NullPointerException n) {
			obj.put("message","Please Enter valid Customer Mobile");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
		}
		
		
		try {
			if(password==null||password.equals("")) {
				obj.put("message","Please Enter valid Customer Password.");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			
		}catch(NullPointerException n) {
			obj.put("message","Please Enter valid Customer Password.");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
		}
		try {			
		
		CustomerMaster cust=service.checkCustomer("Select * from Customer_Master cm where cm.customer_mobile='"+mobileNo+"'and cm.customer_password='"+password+"' and cm.customer_verfiy_mobile=true");
		
		if(cust.equals(null)) {
			obj.put("message","Invalid User");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
		}else {
			if(cust.getCustomer_password().equals(password)) {
				obj.put("message","success");
				obj.put("regi_id", cust.getCustomer_id());
				obj.put("full_name", cust.getCustomer_name());
				obj.put("password", cust.getCustomer_password());
				obj.put("mobileNo", cust.getCustomer_mobile());
				obj.put("emailId", cust.getCustomer_email());
				return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
			}else {
				obj.put("message","Wrong Password !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
		}
		} catch (NullPointerException e) {
			obj.put("message","Wrong Mobile Number and Password");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
		}
				
			
 }
	
	@RequestMapping(value = "/forget-password", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> forgetMyPSW(Model model, HttpServletRequest request,		
			@RequestParam(value = "mobileNo") String mobileNo
			)
			 {
			JSONObject obj = new JSONObject();
		
			//System.out.println("mobileNo--->"+mobileNo);	
			CustomerMaster cust=service.checkCustomer("Select * from Customer_Master cm where cm.customer_mobile='"+mobileNo+"'and cm.customer_verfiy_mobile=true");
			try {
						
			if(cust.equals(null)) {
				obj.put("message", "Mobile Number is not registered !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			} catch (NullPointerException e) {
				obj.put("message", "Mobile Number is not registered !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}catch (IndexOutOfBoundsException e) {
				obj.put("message", "Mobile Number is not registered !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			if(cust.getCustomer_mobile().equals(mobileNo)) {
			
				String otp=	String.valueOf(OTP_Verifay.OTP(6));
				OTP_Verifay OTP =new OTP_Verifay();
				OTP.setMobileNo(mobileNo);
				OTP.setOTP(otp);
				OTP.setCreateDate(MyFunction.date());
				OTP.setUpdateDate(MyFunction.date());
				OTP.setStatus(false);
				service.insertOTP(OTP);
				String message = Messages.OTP_MOBILE_VERIFICATION;
				
				message =message.replace("[OTP]", otp);
				//System.out.println(message);
				MyFunction.sendOTP(mobileNo,message);  //SMS OTP
				System.out.println("my ID----"+OTP.getId());
				obj.put("code", OTP.getId());
				obj.put("message", "success");		
				insertInteraction(cust.getCustomer_email(), cust.getCustomer_name(), mobileNo, 47, 81, "Cusomer Verifaction ", "SMS", cust.getCustomer_id(), "OCustomer");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
			}else {
				obj.put("message", "error");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
	
			
			
		 }
	
	@RequestMapping(value = "/new-password", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> changeMyPSW(Model model, HttpServletRequest request,		
			@RequestParam(value = "code") String code,
			@RequestParam(value = "otp") String otp,
			@RequestParam(value = "mobileNo") String mobileNo,
			@RequestParam(value = "password") String password
			)
			 {
		JSONObject obj = new JSONObject();
		//System.out.println("code--->"+code);
		//System.out.println("otp--->"+otp);
		//System.out.println("mobileNo--->"+mobileNo);	

		//System.out.println("password--->"+password);	
		CustomerMaster cust=service.checkCustomer("Select * from Customer_Master cm where cm.customer_mobile='"+mobileNo+"'and cm.customer_verfiy_mobile=true");
		
		if (otp.matches("\\d{6}")) {

			OTP_Verifay otpv = service.validateOTP(otp, mobileNo,Long.parseLong(code));	
			//System.out.println("---OTP Data---"+new Gson().toJson(otpv));
			try {					
			
				if(cust.getCustomer_password().equals(password)) {
					obj.put("message", "Old password and New password should not be same !");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				
			if (otpv.getOTP().equals(otp)) {
				otpv.setId(Long.parseLong(code));
				otpv.setStatus(true);	
				//System.out.println("OTO------------> 2"+new Gson().toJson(otpv));					
				otpv=service.insertOTP(otpv);//NotUpdated
				//System.out.println("OTO------------>3 "+new Gson().toJson(otpv));
				//cust.setCustomer_verfiy_mobile(true);
				//cust.setStatus(true);
				cust.setCustomer_password(password);
				service.saveOutGoCustomer(cust);
				
				obj.put("message","Password is change Successfully, Please login ! ");
				//System.out.println("success");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
			}else {
				obj.put("message", "Old password and New password should not be same !");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			} catch (NullPointerException e) {
				//System.out.println("null pointer Ex--"+e);
				obj.put("message", "error");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);	
			}
			
			
		}else {
			obj.put("message", "Invalid OTP");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);	
		}
		
			 
			 }
	
	@RequestMapping(value = "/all-services", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> myAllServices(Model model, HttpServletRequest request)
			 {
				JSONObject obj = new JSONObject();
		
				List<Object> sm=service.list("Select sm.service_id,sm.service_name,sm.service_code,sm.imageUrl  from Service_Master sm where sm.status=true  ORDER BY sm.priority");
				try {
					if(sm.equals(null) || sm.isEmpty()) {
						obj.put("message","Something Wrong!");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","Something Wrong!");
					//System.out.println("error Null Ex");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				//System.out.println();
				
				
				
				obj.put("message",new Gson().toJson(sm));
				//System.out.println("success---"+new Gson().toJson(sm));
				return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
				//return new ResponseEntity<String>(obj.to,HttpStatus.OK);
		
			 
			 }
	@RequestMapping(value = "/operator-list", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> myAllServiceOperators(Model model, HttpServletRequest request,
			@RequestParam(value = "service_id",defaultValue="0",required=false) String service_id,
			@RequestParam(value = "city_id", defaultValue="0",required=false) String city_id,
			@RequestParam(value = "regi_id",defaultValue="0",required=false) String regi_id,
			@RequestParam(value = "area_id",defaultValue="0",required=false) String area_id,
			@RequestParam(value = "mode",defaultValue="0",required=false) String mode)
			 {
				JSONObject obj = new JSONObject();
				List<Object> sm=null;
				String sql="Select  msm.merchant_service_id,msm.merchant_business_name,cmm.city_name,ams.area_name,sm.service_name,msm.merchant_service_logo,cl.email,cl.mobileNo from Merchant_Service_Detail_Master msm, Service_Master sm ,Address_Master am ,Tax_Master tm,Area_Master ams, City_Master cmm,Merchant_Payment_keys mpk, Contact_login cl  where  msm.service_code=sm.service_id and sm.`status`=1 and"
						+ " am.address_id=msm.address_id and msm.tax_id=tm.tax_id and ams.area_id=msm.service_area_id and cmm.city_id=ams.city_id and msm.merchant_id=mpk.merchant_key  and msm.merchant_id=cl.merchantId ";
				if(mode.equals("F")) {
				
					try {
						CustomerMaster cust=service.checkCustomer("Select * from Customer_Master cm where cm.customer_id="+Long.parseLong(regi_id)+" and cm.customer_verfiy_mobile=true");
					if(cust.equals(null) || cust.toString().isEmpty()) {
						obj.put("message","User data available");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
					sm=service.list("Select   msm.merchant_service_id,msm.merchant_business_name,cmm.city_name,ams.area_name,sm.service_name,msm.merchant_service_logo,cl.email,cl.mobileNo from merchant_service_detail_master msm, Service_Master sm ,Address_Master am ,Tax_Master tm,Area_Master ams, City_Master cmm,Merchant_Payment_keys mpk, Contact_login cl,transaction_master txm where  msm.service_code=sm.service_id and sm.`status`=1 and am.address_id=msm.address_id and msm.tax_id=tm.tax_id and ams.area_id=msm.service_area_id and cmm.city_id=ams.city_id and msm.merchant_id=mpk.merchant_key  and msm.merchant_id=cl.merchantId\r\n" + 
								" and txm.customer_mobile='"+cust.getCustomer_mobile()+"' and txm.merchant_service_id=msm.merchant_service_id and  txm.merchant_service_id!=0  GROUP by msm.merchant_service_id ORDER by COUNT(txm.merchant_service_id) DESC  ");
					} catch (NullPointerException e) {
						obj.put("message","User data available");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
					
					}else {
						if(area_id.equals("0")) {
							sm=service.list(sql+" and sm.service_id="+Long.parseLong(service_id)+" GROUP by msm.merchant_service_id ORDER by msm.merchant_service_id");
						}else {
							sm=service.list(sql+" and msm.service_area_id="+Long.parseLong(area_id)+" and sm.service_id="+Long.parseLong(service_id)+" GROUP by msm.merchant_service_id ORDER by msm.merchant_service_id");
						}
					}
					
				
			
				try {
					if(sm.equals(null) || sm.isEmpty()) {
						obj.put("message","No data available");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","No data available");
					//System.out.println("error Null Ex");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				//System.out.println();
				
				
				
				obj.put("message",new Gson().toJson(sm));
				//System.out.println("success---"+new Gson().toJson(sm));
				return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
				//return new ResponseEntity<String>(obj.to,HttpStatus.OK);
		
			 
			 }
	
	@RequestMapping(value = "/area-list", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> servicewizeAreaList(Model model, HttpServletRequest request,
			@RequestParam(value = "service_id") String service_id)
			 {
				JSONObject obj = new JSONObject();
				List<Object> sm=null;
				String sql="select am.area_id,am.area_name from Merchant_Service_Detail_Master mcm,Area_Master am where mcm.service_area_id=am.area_id and mcm.service_code="+Long.parseLong(service_id)+" GROUP BY am.area_id ORDER by am.area_name";
				sm=service.list(sql);
				try {
					if(sm.equals(null) || sm.isEmpty()) {
						obj.put("message","No data available");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (Exception e) {
					obj.put("message","No data available");
					//System.out.println("error Null");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				
				obj.put("message",new Gson().toJson(sm));
				////System.out.println("success---"+new Gson().toJson(sm));
				return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
				
		
			 
			 }
	@ResponseBody
	@RequestMapping(value="/service-pay/PAY-TO-09-03-{merchant_service_id}APP{id2}45-TRANSACTION{regId}95-96{id}")
	public ModelAndView  returnurl(HttpServletRequest request,HttpServletResponse response,Model model,
			@PathVariable(value = "merchant_service_id") String merchant_service_id
			,@PathVariable(value = "regId") String regId,@PathVariable(value = "id") String id,@PathVariable(value = "id2") String id2) {
		
		ModelAndView mav = new ModelAndView();
		//System.out.println("regId-->"+regId);		
		//System.out.println("regId-->"+id);
		//System.out.println("merchant_service_id-->"+merchant_service_id);
		//System.out.println("merchant_service_id-->"+id2);
		try {			
		
		if(!merchant_service_id.equals(id2)) {
			model.addAttribute("error","Authentication Fail...Invalid  merchant_service_id Mismatch.");
			//System.out.println("a");
			 return null;	
		}
		if(!regId.equals(id)){
			//System.out.println("b");
			model.addAttribute("error","Authentication Fail...Invalid  regId Mismatch.");
			 return null;
		}
		} catch (NullPointerException e) {
			//System.out.println("c");
			model.addAttribute("error","Authentication Fail....");
			 return null;
		}
		
		try {
		ALL all=service.getData("select mcm.merchant_service_id,mcm.merchant_id,tm.gst_tax,mcm.merchant_service_logo,mcm.merchant_business_name,kys.merchant_key_url,sm.service_name"
				+ " from Merchant_Service_Detail_Master mcm , Tax_Master  tm,Service_Master sm,Merchant_Payment_keys kys where  tm.tax_id=mcm.tax_id and mcm.service_code=sm.service_id and mcm.merchant_id=kys.merchant_key and mcm.merchant_service_id="+Long.parseLong(merchant_service_id));
		
		CustomerMaster cust=service.checkCustomer("select * from  Customer_Master cm where cm.customer_id="+Long.parseLong(regId));

			request.setAttribute("userId",cust.getCustomer_id());
			request.setAttribute("table","Customer_Master");
			request.setAttribute("c_name", cust.getCustomer_name());
			request.setAttribute("c_email",cust.getCustomer_email());
			request.setAttribute("c_mobile",cust.getCustomer_mobile());
			request.setAttribute("m_Id",all.getMerchant_id());
			request.setAttribute("m_gst",all.getGst_tax());
			request.setAttribute("m_name",all.getMerchant_business_name());
			request.setAttribute("m_logo",all.getMerchant_service_logo());
			request.setAttribute("s_id",all.getMerchant_service_id());
			request.setAttribute("m_url",all.getMerchant_key_url());
			request.setAttribute("m_serviceToPay",all.getService_name());
			System.out.println("b Name--->"+all.getMerchant_business_name());
			System.out.println("b merchant_service_id--->"+merchant_service_id);
		} catch (NullPointerException e) {
			 return null;	
		}
		
	    //mav.setViewName("appOutgo/brpay");
		  mav.setViewName("appOutgo/brpay");
	    return mav;
	}
	
	
	@RequestMapping(value = "/txn-History-list", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> appTransactionHistory(Model model, HttpServletRequest request,
			@RequestParam(value = "regi_id") String regi_id,@RequestParam(value = "mode",defaultValue="C",required=false) String mode
			,@RequestParam(value = "t_month" ,defaultValue="0",required=false) String t_month
			,@RequestParam(value = "t_year" ,defaultValue="0",required=false ) String t_year)
			 {
				JSONObject obj = new JSONObject();
				CustomerMaster cust=service.checkCustomer("select * from  Customer_Master cm where cm.customer_id="+Long.parseLong(regi_id)+" and cm.status=true");
				//System.out.println("cust---"+new Gson().toJson(cust));
				try {
					
					if(cust.equals(null)) {
						obj.put("message","Something wrong..");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","Something wrong..");
					//System.out.println("error Null");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				List<Object> sm=null;
				String sql="select CASE WHEN tm.transaction_status IS NULL THEN 'N/A' ELSE tm.transaction_status END  AS transaction_status,tm.transaction_order_id,tm.transaction_amount,sm.service_name," + 
						" tm.transaction_update_date,mcm.merchant_service_logo,mcm.merchant_business_name from  Merchant_Service_Detail_Master mcm ,Transaction_Master tm,Service_Master sm" + 
						" where tm.merchant_service_id!=0 and sm.service_id=mcm.service_code and mcm.merchant_service_id=tm.merchant_service_id  and tm.customer_mobile='"+cust.getCustomer_mobile()+"'";
					
				if(mode.equals("C")) {
					sm=service.list(sql+"and MONTH(tm.transaction_update_date)=MONTH(CURRENT_DATE()) GROUP by tm.transaction_order_id ORDER BY tm.transaction_update_date DESC");
				}else if(mode.equals("F")){
					
				}else {
					sm=service.list(sql+"and YEAR(tm.transaction_update_date) = "+t_year+" AND MONTH(tm.transaction_order_id) ="+t_month+" GROUP by tm.transaction_order_id ORDER BY tm.transaction_update_date DESC");
					} 
				
				try {
					if(sm.equals(null) || sm.isEmpty()) {
						obj.put("message","No data available");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (Exception e) {
					obj.put("message","No data available");
					//System.out.println("error Null");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				
				obj.put("message",new Gson().toJson(sm));
				//System.out.println("success---"+new Gson().toJson(sm));
				return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
				
		
			 
			 }
	
	@RequestMapping(value = "/change-password", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> changePassword(Model model, HttpServletRequest request,
			@RequestParam(value = "regi_id") String regi_id,@RequestParam(value = "newPassword") String newPassword,
			@RequestParam(value = "oldPassword") String oldPassword)
			 {
				JSONObject obj = new JSONObject();
				CustomerMaster cust=service.checkCustomer("select * from  Customer_Master cm where cm.customer_id="+Long.parseLong(regi_id)+" and cm.status=true");
				try {
					
					if(cust.equals(null)) {
						obj.put("message","Something wrong1..");
						//System.out.println("error Null");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","Something wrong2..");
					//System.out.println("error Null");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				
				if(cust.getCustomer_password().equals(oldPassword)) {
					
					if(cust.getCustomer_password().equals(newPassword)) {
						obj.put("message","Old password is same as new password..");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}else {
						cust.setCustomer_password(newPassword);
						boolean custo= service.saveOutGoCustomer(cust);
						if(custo) {
							obj.put("message","Success");
							return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
							}else {								
								obj.put("message","Something wrong..");
								return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
							}						
					}
				}else {
					obj.put("message","Incorrect password..!");
					//System.out.println("error Null");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
			
				
		
			 
			 }
	
	//Expense---->
	@RequestMapping(value = "/add-expense-income", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addExpense(Model model, HttpServletRequest request,
			ExpenceMaster em,IncomeMaster im,@RequestParam(value = "mode") String mode)
			 {
				JSONObject obj = new JSONObject();
				try {
									
					//System.out.println("expenseId--->"+em.getExpence_id());
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
					Date startDate;
					
					if(mode.equals("expense")) {
						em.setStatus(true);
						String startDateString = em.getExpense_selectedDate();
						try {
						    startDate = df.parse(startDateString);
						   // String newDateString = df.format(startDate);
						 //   System.out.println(newDateString);
						    DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
				            String startDateString2 = df2.format(startDate);
				           // System.out.println("Date in format yyyy-MM-dd: " + startDateString2);
				            em.setExpense_selectedDate(startDateString2);
				            
						} catch (ParseException e) {
						    e.printStackTrace();
						}
						boolean expence=service.saveExpence(em);
						if(expence) {
							
							obj.put("message","Success");
							return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
						}else {
							obj.put("message","Something wrong1..");
							return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
						}
					}
					if(mode.equals("income")){
						im.setStatus(true);
						String startDateString = im.getIncome_selectedDate();
						try {
						    startDate = df.parse(startDateString);
						   // String newDateString = df.format(startDate);
						   // System.out.println(newDateString);
						    DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
				            String startDateString2 = df2.format(startDate);
				            //System.out.println("Date in format yyyy-MM-dd: " + startDateString2);
				            im.setIncome_selectedDate(startDateString2);
				            
						} catch (ParseException e) {
						    e.printStackTrace();
						}
						boolean income=service.saveIncome(im);
						if(income) {
							obj.put("message","Success");
							return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
						}else {
							obj.put("message","Something wrong1..");
							return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
						}
					}
					
					
					
			
				} catch (NullPointerException e) {
					obj.put("message","Something wrong.2.");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				obj.put("message","Something wrong.3.");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				
			
		
			 
			 }
	
	@RequestMapping(value = "/add-category", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addCategory(Model model, HttpServletRequest request,
			ExpenseCategories ec)
			 {
				JSONObject obj = new JSONObject();		
					
			try {				
					ec.setStatus(true);
					boolean cat=service.saveEXCategory(ec);
					if(cat) {
						obj.put("message","Category added Successfully");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
					}else {
						obj.put("message","Something wrong1..");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
			} catch (Exception e) {
				obj.put("message","Something wrong..");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			 }
	
	@RequestMapping(value = "/display-category", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> displayCategory(Model model, HttpServletRequest request,
			ExpenseCategories ec,@RequestParam(value = "mode") String mode)
			 {
				JSONObject obj = new JSONObject();
				try {				
					if(ec.getRegi_id()==0) {
						obj.put("message","Something wrong..");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","Something wrong..");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				List<Object> sm=null;
				if(mode.equals("expense")) {
					 sm=service.list("select * FROM Expense_Categories ex where ex.regi_id="+ec.getRegi_id()+" and ex.category_type='expense' and ex.status=true");
				}
				if(mode.equals("income")) {
					 sm=service.list("select * FROM Expense_Categories ex where ex.regi_id="+ec.getRegi_id()+"  and ex.category_type='income' and ex.status=true");
				}
				
				
				obj.put("message",new Gson().toJson(sm));
				//System.out.println("success---"+new Gson().toJson(sm));
				return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
			
			
			 }
	
	@RequestMapping(value = "/display-count", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> displayCount(Model model, HttpServletRequest request,
			@RequestParam(value = "regi_id") String regi_id)
			 {
				JSONObject obj = new JSONObject();
				try {
					if(regi_id.equals(null) || regi_id.isEmpty()) {
						obj.put("message","Something wrong..");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","Something wrong..");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				List<Object> sm= service.list("SELECT  CASE WHEN  A.expenseCount IS NULL THEN '0' ELSE (A.expenseCount) END  AS expenseCount,\r\n" + 
							"CASE WHEN B.incomeCount IS NULL THEN '0' ELSE (B.incomeCount) END  AS incomeCount,\r\n" + 
							"CASE WHEN (B.incomeCount-A.expenseCount) IS NULL THEN '0' ELSE (B.incomeCount-A.expenseCount) END  AS Balance\r\n" + 
							"FROM\r\n" + 
							" (select SUM(em.expense_amount) expenseCount FROM  Expence_Master em where em.regi_id="+Long.parseLong(regi_id)+") A\r\n" + 
							"CROSS JOIN \r\n" + 
							" (select SUM(im.income_amount) incomeCount FROM  Income_Master im where im.regi_id="+Long.parseLong(regi_id)+") B");
					
		
					return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
						
			
			 }
	
	@RequestMapping(value = "/display-expense", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> displayIncome(Model model, HttpServletRequest request,
			@RequestParam(value = "regi_id") String regi_id,
			@RequestParam(value = "mode",defaultValue="P",required=false) String mode
			,@RequestParam(value = "d_month" ,defaultValue="0",required=false) String d_month
			,@RequestParam(value = "d_year" ,defaultValue="0",required=false ) String d_year)
			 {
				JSONObject obj = new JSONObject();
				try {
					if(regi_id.equals(null) || regi_id.isEmpty()) {
						obj.put("message","Something wrong..");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","Something wrong..");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}
				List<Object> sm=null;
					String sql="select * from Expence_Master em where em.regi_id="+Long.parseLong(regi_id);
					if(mode.equals("C")) {
						sm=service.list(sql+" and MONTH(em.expense_selectedDate)=MONTH(CURRENT_DATE())");
					}else {
						sm=service.list(sql+" and YEAR(em.expense_selectedDate) = "+d_year+" AND MONTH(em.expense_selectedDate) = "+d_month);
					}
					
					obj.put("message",new Gson().toJson(sm));
					//System.out.println("success---"+new Gson().toJson(sm));
					return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
						
			
			 }
	@RequestMapping(value = "/outgo-enquiry", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> displayExpense(Model model, HttpServletRequest request,
			@RequestParam(value = "regi_id") String regi_id,
			@RequestParam(value = "mode",defaultValue="N/A",required=false) String mode,
			MessagesMaster msg)
			 {
				JSONObject obj = new JSONObject();
				try {
					if(regi_id.equals(null) || regi_id.isEmpty()) {
						obj.put("message","Something wrong..");
						return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
					}
				} catch (NullPointerException e) {
					obj.put("message","Something wrong..");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}			
				msg.setRef_id(Long.parseLong(regi_id));
				try {
					msg.setMerchant_service_id(msg.getMerchant_service_id());
					MerchantServiceDetailMaster msm=service.getServiceData(msg.getMerchant_service_id());
					try {
						//System.out.println("----"+msm.getMerchant_id());
						if(msm.getMerchant_id()!=0) {
							msg.setMerchantId(msm.getMerchant_id());
						}
					} catch (Exception e) {
						msg.setMerchantId(0);
					}					
					
					
				} catch (NullPointerException e) {
					msg.setMerchant_service_id(0);
					msg.setMerchantId(0);
				}				
				
				if(mode.equals("M_ENQ")) {
					msg.setType("Enquiry");
				}else if(mode.equals("M_COM")){
					msg.setType("Complaint");
				}else {
				msg.setMerchant_service_id(0);
				msg.setMerchantId(0);
				msg.setType("Complaint");
				}
				
				msg.setTable_ref("Customer_Master");				
				msg.setMode("App User");
				msg.setMsg_status("Open");
				msg.setStatus(true);
				msg=service.insertMassages(msg);	
				CustomerMaster c=service.checkCustomer("select * from Customer_Master c where c.customer_id="+regi_id);

				insertInteraction(c.getCustomer_email(), c.getCustomer_name(), c.getCustomer_mobile(), msg.getMerchant_service_id(), msg.getMerchantId(), "Open "+msg.getType(), msg.getType(), msg.getMsgId(), "Complaint");
				if(msg.equals(null)||msg.toString().isEmpty()) {
					obj.put("message","Something wrong..");
					return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
				}else {
					if(mode.equals("M_ENQ")) {
						obj.put("message","Your enquiry has been sent successfully");
					}else if(mode.equals("M_COM")){
						obj.put("message","Your Complain has been sent successfully");
					}else {
						obj.put("message","Your Complain has been sent successfully");
					}
					
					return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
				}
				
				
			 }
	@RequestMapping(value = "/delete-functions", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> deleteCategory(Model model, HttpServletRequest request,
			@RequestParam(value = "regi_id") String regi_id,
			@RequestParam(value = "all_id") String all_id,
			@RequestParam(value = "mode",defaultValue="0", required=true) String mode
			)
			 {
			JSONObject obj = new JSONObject();
			if(mode.equals("0")) {
				obj.put("message","Undefined input");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			boolean result=true;
			if(mode.equals("EX")) {
				 result = service.update("DELETE FROM Expence_Master WHERE regi_id="+Long.parseLong(regi_id)+" and expence_id="+Long.parseLong(all_id));
			}
			if(mode.equals("IN")) {
				 result = service.update("DELETE FROM Income_Master WHERE regi_id="+Long.parseLong(regi_id)+" and income_id="+Long.parseLong(all_id));
			}
			if(mode.equals("CATE")) {
				 result = service.update("DELETE FROM Expense_Categories WHERE regi_id="+Long.parseLong(regi_id)+" and expence_cat_id="+Long.parseLong(all_id));
			}
			if (result) {
				obj.put("message","Deleted successfully!");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
					
			}
			else {
				obj.put("message","Error");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
				
			
				
			}
			
			 }
	
	
	@RequestMapping(value = "/all-graph", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> allGraph(Model model, HttpServletRequest request,
			@RequestParam(value = "regi_id") String regi_id,
			@RequestParam(value = "mode",defaultValue="0", required=true) String mode
			)
			 {
			JSONObject obj = new JSONObject();
			if(mode.equals("0")) {
				obj.put("message","Undefined input");
				return new ResponseEntity<String>(obj.toString(),HttpStatus.NOT_FOUND);
			}
			List<Object> sm=null;
			
			if(mode.equals("EX")) {
				
				sm=service.list("SELECT em.expense_category,em.expense_amount\r\n" + 
						"				    FROM Expence_Master em " + 
						"				   WHERE em.regi_id="+Long.parseLong(regi_id) + 
						"				GROUP BY em.expense_category");
				
				 /*SELECT em.expense_category,em.expense_amount
				    FROM expence_master em
				    JOIN income_master im ON im.regi_id = em.regi_id
				   WHERE im.regi_id=1
				GROUP BY em.expense_category*/
			}
			
			if(mode.equals("PAY")) {
				
			}
			obj.put("message",new Gson().toJson(sm));
			//System.out.println("data---"+new Gson().toJson(sm));
			return new ResponseEntity<String>(new Gson().toJson(sm),HttpStatus.OK);
				
	 }
	
	

	
	@RequestMapping(value = "/qr", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> qr( HttpServletRequest request,
			@RequestParam(value = "merchantId") String merchantId
			)
			 {
		
		return new ResponseEntity<String>(new Gson().toJson(service.list("select ms.merchant_service_id, ms.merchant_business_name,  am.area_name,sm.service_name,adm.address_desc from Merchant_Service_Detail_Master ms ,  Area_Master am, Address_Master adm , Service_Master sm where sm.service_id=ms.service_code and am.area_id=ms.service_area_id and ms.address_id=adm.address_id  and ms.merchant_id="+merchantId+"")),HttpStatus.OK);
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
