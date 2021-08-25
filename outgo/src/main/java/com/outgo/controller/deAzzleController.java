package com.outgo.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.deazzle.api.AESEncryption;
import com.deazzle.api.deAzzleAPIS;
import com.deazzle.model.easebuzzkeys.GetWay_Keys;
import com.deazzle.model.login.Registration;
import com.deazzle.model.payment.PaymentResponesList;
import com.google.gson.Gson;
import com.outgo.bean.ALL;
import com.outgo.bean.Interaction;
import com.outgo.bean.Merchant;
import com.outgo.bean.MerchantCustomerMaster;
import com.outgo.bean.Merchant_Payment_keys;
import com.outgo.bean.Settings;
import com.outgo.bean.TransactionMaster;
import com.outgo.myfun.MyFunction;
import com.outgo.services.ApiServices;
@Controller
public class deAzzleController {

	
	@Autowired
	ApiServices service;
	
	
	@RequestMapping(value="/s/{seller_url}")
	public String  messages(@PathVariable("seller_url") String seller_url,HttpServletRequest request,Model model) {		
		
		Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where m.merchant_key_url='"+seller_url+"'");

		try {
			if(keys==null) {
				model.addAttribute("error","Invalid URL");
			    return "error";
			}
		}catch(NullPointerException e) {
			model.addAttribute("error","Invalid URL");
		    return "error";
			
		}
		
		ALL m=service.getData("select m.businessName,m.name,c.mobileNo,c.email from Merchant_Info m,Contact_login c where c.merchantId=m.merchantId and m.merchantId='"+keys.merchant_key+"' and c.user_role='Owner'");
		List<Object>  s=service.list("select m.merchant_service_id,m.merchant_business_name,m.custjson,m.planjson,s.service_name,t.gst_tax\n" + 
				" from Merchant_Service_Detail_Master m ,Service_Master s,Tax_Master t \n" + 
				" where m.merchant_id="+keys.merchant_key+" and s.service_id=m.service_code and t.tax_id=m.tax_id");
		
		model.addAttribute("seller",m);
		model.addAttribute("list",s);
		model.addAttribute("keys",keys);
		
		
		return "userpayment";		
	}
	
	
	
	
	/**
	 * @param id  :Business Object
	 * @param p	  :Phone Number
	 * @param a   :Amount
	 * @param d   :Description
	 * @param iid  :Invoice Id
	 * @param mid  :Merchant Id
	 * @param bn  :BusinessName
	 * @param request 
	 * @param model
	 * @return http://localhost:8081/outgo/quickpay/1/9764124609/2/Testing/5/81/Shree Techs/amol.delmade@deazzle.in/Amol Delmade
	 */
	
	@RequestMapping(value="/quickpay/{id}/{p}/{a}/{d}/{iid}/{mid}/{bn}/{e}/{n}/{u}/{mm}")
	public String  messages1(@PathVariable("id") String id,@PathVariable("p") String p,@PathVariable("a") float a,
			@PathVariable("d") String d,@PathVariable("iid") String iid,@PathVariable("mid") long mid,
			@PathVariable("bn") String bn,@PathVariable("e") String email,@PathVariable("n") String name,
			 @PathVariable("u") String userId, @PathVariable("mm") String merchantMobile,
			HttpServletRequest request,ModelMap model) {
		
		
		    request.setAttribute("phone", p.trim());
			request.setAttribute("objectId", id.trim());
			request.setAttribute("amount", a);
			
			if(d.trim().equals("NA"))
			request.setAttribute("description", "");
			else
				request.setAttribute("description", d.trim());
			request.setAttribute("invoiceId", iid.trim());
			request.setAttribute("merchantId", mid);
			request.setAttribute("businessName", bn.trim());
			if(email.trim().equals("NA"))
				request.setAttribute("email", "");
			else
			request.setAttribute("email", email.trim());
			if(name.trim().equals("NA"))
				request.setAttribute("name", "");
			else
			request.setAttribute("name", name.trim());
			request.setAttribute("userId", userId.trim());
			request.setAttribute("merchantMobile", merchantMobile.trim());
		return "deazzle/Quick-Pay/quickpay";		
	}


	@RequestMapping(value="/quickpay" , method = RequestMethod.POST)
	public String  pay(HttpServletRequest request,ModelMap model,HttpSession session ) {
					return "deazzle/Quick-Pay/quickpayrequest";		
	}
	
	@ResponseBody
	@RequestMapping(value="/sessionout" , method = RequestMethod.POST)
	public String  sessionout(HttpServletRequest request,ModelMap model ) {
		HttpSession session=request.getSession();  
        session.invalidate();  
		
					return "";		
	}
	
	
	
	@RequestMapping(value="/Quick-Pay" , method = RequestMethod.POST)
	public String  pay2(HttpServletRequest request,ModelMap model,HttpSession session ,float amount ) {
			String phone=String.valueOf(request.getParameter("phone"));
			String objectid=String.valueOf(request.getParameter("objectId"));
			String description=String.valueOf(request.getParameter("description"));
			String invoiceId=String.valueOf(request.getParameter("invoiceId"));
			String mertchantId=String.valueOf(request.getParameter("merchantId"));
			String business=String.valueOf(request.getParameter("businessName"));
			String email=String.valueOf(request.getParameter("email"));
			String name=String.valueOf(request.getParameter("name"));
			String merchantMobile=String.valueOf(request.getParameter("merchantMobile"));
			System.out.println("??????????"+amount);
			

			Map<String, Object> map=new ModelMap();
			
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			df.setMinimumFractionDigits(2);
			
			String amt =String.valueOf(df.format(amount));
			amt=amt.replaceAll(",", "");
			
			Merchant_Payment_keys keys=	service.getMerchantKey("select * from Merchant_Payment_keys m where   m.merchant_key='"+mertchantId+"'");

			
			Registration reg=new Registration(Long.parseLong(phone), "", "", "", "", name, Long.parseLong(phone), "outgo");
			
			Gson g=new Gson();
			System.out.println(g.toJson(reg));
			try {
				String Failure=deAzzleAPIS.sendPost("", "register/", g.toJson(reg),"POST");
			
				if("Failure".equals(Failure)) {
					deAzzleAPIS.sendGet("", "passcode/beforeLogin/?username="+phone);
					
				}else
					 deAzzleAPIS.sendGet("", "passcode/beforeLogin/?username="+phone);

					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			

			   map.put("productinfo",business);
			   map.put("plan",description);
			   map.put("firstname", name);
			   map.put("email", email.trim());
			   map.put("phone", phone.trim());
			   map.put("invoiceId", invoiceId.trim());
			   map.put("amount", amt);
			   map.put("amount1", amount);
			   map.put("txnid", "SL"+System.currentTimeMillis());
			   map.put("udf1", mertchantId);
			   map.put("udf2", "-");
		       map.put("address", "-");
			   map.put("businessName", business);
			   map.put("merchantMobile",merchantMobile);
			   map.put("validity", "0"); 
			   map.put("objectid", objectid); 
			   map.put("mode", "N/A");
			   map.put("keyurl", keys.getMerchant_key_url()); 
			   map.put("paymode","SL");

				session.setMaxInactiveInterval(1000); 

			   session = request.getSession();
			   session.setAttribute("data", map);
			
			   
			   
				request.setAttribute("email",email);
				request.setAttribute("amount",amt);
				request.setAttribute("mobile",phone);
				request.setAttribute("name",name);
				request.setAttribute("validity", 0); 
				
				/*New Added 3 sep*/
				request.setAttribute("merchantMobile", merchantMobile); 
				request.setAttribute("link", ""); 
					request.setAttribute("objectId", objectid); 
				request.setAttribute("businessName", business); 
				request.setAttribute("xno", phone.substring(0, 2)+"XXXXXX"+phone.substring(8, 10)); 

			
				return "deazzle/static-payment/otp";
	
	
	}
	
	
	@RequestMapping(value ="/receipt-{order_id}-smartBiz", method = RequestMethod.GET)
	public ModelAndView invoice(ModelMap model,HttpServletRequest  request,@PathVariable("order_id") String order_id) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		//System.out.println(order_id);
		try {

			mav.setViewName("deazzle/invoice"); 

			String data="{\"search_criteria\":{\"RelationArray\":[{\"r1\":{\"type\":\"payment\"}}],\"NodeArray\":[{\"n1\":\"\"},{\"n2\":\"business\"}],\"Expression\":\" r1.PayuId='"+order_id+"' and  r1.payment_status='Success' \",\"Return\":[\"r1.payment_date as date\",\"r1.payment_date as end_date\",\"r1.amount_paid as amount\",\"r1.payment_mode as payment_mode\",\"n1.name[0] as name\",\"n1.f_name as first_name\",\"n1.l_name as last_name\",\"n2.name[0] as business\",\"r1.transaction_id as transaction_id\",\"r1.invoice_id as invoice_id\",\"n1.image as person_image\",\"n1.phone_number[0] as person_phone_number\",\"r1.outgo_customer_user_id as userId\",\"r1.payment_status as status\",\"r1.PayuId as pay_id\",\"r1.http_referrer as http_referrer\",\"r1.payment_source as payment_source\",\"r1.easepayid as easepayid\",\"n2.phone_number[0] as merchant_phone_number\",\"n2.email[0] as merchant_email\",\"n2.merchant_id as merchant_id\",\"n2.image as logo\",\"n1.email[0] as email\",\"r1.service_name[0] as service\",\"n2.gst_terms_and_condition_summary as terms_condition\",\"n2.gstin_number as gstin_number\",\"n2.pan_number as pan_number\"],\"Limit\":\"10\",\"OrderBy\":\"r1.payment_date desc\"}}\n" + 
				"";
		
		String en=AESEncryption.encrypt("oxfordaccessASguestUserobl");
		
		
		String s=deAzzleAPIS.publicsearch("YWRkZmQxYjUzZDlhNTUxYjFjNWQ2NDZkNmIxYzcxMzJlM2U1NWJlY2I1MGJiNDAwOGY2NWI0ZDUwNjk1NDFjZWU0Y2M2NzQ2ZmYxYjk4Yzg=", "search/", data, "POST");
		if(!s.equals("Failure")) {
			Gson g=new Gson();
			PaymentResponesList pay=g.fromJson(s, PaymentResponesList.class);
		
	
			
			model.addAttribute("deazzle",pay.getResultData()[0]);
			
			try {
				Settings settings=service.getSetting("select * from Settings s where s.merchant_id="+pay.getResultData()[0].getMerchant_id());
				model.addAttribute("settings",settings);
			}catch (NullPointerException e) {
				Settings settings=new Settings();
				model.addAttribute("settings",settings);
			}catch (IndexOutOfBoundsException e) {
				Settings settings=new Settings();
				model.addAttribute("settings",settings);
			}

		
		
		}
		
		
		
		
		return mav;
	}catch(IndexOutOfBoundsException e) {return null;}
		catch(NullPointerException e) {return null;}
			
	}
	

	@RequestMapping(value ="/invoice-{order_id}-smartBiz", method = RequestMethod.GET)
	
	public ModelAndView receiptOrder(ModelMap model,HttpServletRequest  request,@PathVariable("order_id") String order_id) throws Exception {
		ModelAndView mav = new ModelAndView();
		String mode="deazzle/receipt";
		try {
	
		String data="{\"search_criteria\":{\"RelationArray\":[{\"r1\":{\"type\":\"receipt\"}}],\"NodeArray\":[{\"n1\":\"\"},{\"n2\":\"business\"}],\"Expression\":\" r1.PayuId='"+order_id+"'  \",\"Return\":[\"r1.payment_date as date\",\"r1.receipt_date as end_date\",\"r1.amount_received as amount\",\"r1.payment_mode as payment_mode\",\"n1.name[0] as name\",\"n1.f_name as first_name\",\"n1.l_name as last_name\",\"n2.name[0] as business\",\"r1.transaction_id as transaction_id\",\"r1.invoice_id as invoice_id\",\"n1.image as person_image\",\"n1.phone_number[0] as person_phone_number\",\"r1.outgo_customer_user_id as userId\",\"r1.payment_status as status\",\"r1.PayuId as pay_id\",\"r1.http_referrer as http_referrer\",\"r1.payment_source as payment_source\",\"r1.easepayid as easepayid\",\"n2.phone_number[0] as merchant_phone_number\",\"n2.email[0] as merchant_email\",\"n2.merchant_id as merchant_id\",\"n2.image as logo\",\"n1.email[0] as email\",\"r1.service_name[0] as service\",\"n2.gst_terms_and_condition_summary as terms_condition\",\"n2.gstin_number as gstin_number\",\"n2.pan_number as pan_number\",\"n2.category[0] as category\"],\"Limit\":\"10\",\"OrderBy\":\"r1.payment_date desc\"}}\n" + 
				"\n" + 
				"";
		
		System.out.println(data);
		//String en=AESEncryption.encrypt("oxfordaccessASguestUserobl");
		
		
	String s=deAzzleAPIS.publicsearch("YWRkZmQxYjUzZDlhNTUxYjFjNWQ2NDZkNmIxYzcxMzJlM2U1NWJlY2I1MGJiNDAwOGY2NWI0ZDUwNjk1NDFjZWU0Y2M2NzQ2ZmYxYjk4Yzg=", "search/", data, "POST");
		if(!s.equals("Failure")) {
			Gson g=new Gson();
			PaymentResponesList pay=g.fromJson(s, PaymentResponesList.class);
		
			model.addAttribute("deazzle",pay.getResultData()[0]);
	
		System.out.println(pay.getResultData()[0]);
		try {
			if(pay.getResultData()[0].getMerchant_id().equals("80")) {
			if("Landline".equals(pay.getResultData()[0].getCategory())) {
				System.err.println("COMING");
				mode="deazzle/landlineInvoive";
			}
				
			}
		}catch(NullPointerException e) {}
			
		try {
			Settings settings=service.getSetting("select * from Settings s where s.merchant_id="+pay.getResultData()[0].getMerchant_id());
			model.addAttribute("settings",settings);
		}catch (NullPointerException e) {
			Settings settings=new Settings();
			model.addAttribute("settings",settings);
		}catch (IndexOutOfBoundsException e) {
			Settings settings=new Settings();
			model.addAttribute("settings",settings);
		}

		}
		
	
		//insertInteraction(tx.getCustomer_email(), name, tx.getCustomer_mobile(), tx.getMerchant_service_id(), tx.getMerchant_id(), "Invoice", "Invoice", tx.getTransaction_id(), "Transaction");


	
		mav.setViewName(mode); 
		
		return mav;
	}catch(IndexOutOfBoundsException e) {return null;}
		catch(NullPointerException e) {return null;}
			
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
