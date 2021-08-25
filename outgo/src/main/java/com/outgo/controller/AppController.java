/*package com.outgo.controller;

 
 *  
 * Author Punam Patil.....
 * 
 * 
 * 



import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.webApi.bean.ALL;
import com.webApi.bean.MerchantCustomerMaster;
import com.webApi.bean.MerchantServiceDetailMaster;
import com.webApi.bean.SMSMaster;
import com.webApi.bean.Settings;
import com.webApi.bean.TransactionMaster;
import com.webApi.bean.User;
import com.webApi.messages.Link;
import com.webApi.messages.Messages;
import com.webApi.messages.SQLString;
import com.webApi.myfun.MyFunction;
import com.webApi.services.ApiServices;


@Controller
public class AppController {

	@Autowired
	ApiServices service;
	
	@RequestMapping(value =  "/userLogin", method = RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<String> userLogin( Model model,HttpServletRequest request,@RequestParam(value = "mobileNo") String mobileNo,@RequestParam(value = "password")String password) {
		Map<String,String> map=new HashMap<String, String>();
		JSONObject obj = new JSONObject();
		try {
			if(mobileNo==null)
			{
				return new ResponseEntity<String>("Please Enter Mobile No.",HttpStatus.BAD_REQUEST);
			}
			}catch(NullPointerException e) {
				return new ResponseEntity<String>("Please Enter Mobile No.",HttpStatus.BAD_REQUEST);
			}
		
		User u = service.getUserdetail("select *  FROM Contact_login where mobileNo='"+mobileNo+"'  and password='"+password+"'");
		if(u!=null) {
			
			obj.put("merchant_id", u.getMerchantId());
			obj.put("password", u.getPassword());
			obj.put("name", u.getEmployeeName());
			obj.put("mobileno", u.getMobileNo());
			obj.put("msg","success");
			return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity<String>("{\"message\":\"Please enter correct password\"}",HttpStatus.BAD_REQUEST) ;

		}
				
	}
	
	@RequestMapping(value =  "/changePassword", method = RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<String> changePassword( Model model,HttpServletRequest request,@RequestParam(value = "mobileNo") String mobileNo,
			@RequestParam(value = "new_password") String new_password,
			@RequestParam(value = "password")String old_password) {
		    Map<String,String> map=new HashMap<String, String>();
		
		    
		try {
			if(new_password==null)
			{
				return new ResponseEntity<String>("Please Enter New Password.",HttpStatus.BAD_REQUEST);
			}
			}catch(NullPointerException e) {
				return new ResponseEntity<String>("Please Enter New Password.",HttpStatus.BAD_REQUEST);
			}
	
			boolean u = service.update("update Contact_login set password='"+new_password+"' where mobileNo='"+mobileNo+"' and password='"+old_password+"'");
			
		   
			if(u) {
				
				return new ResponseEntity<String>("{\"message\":\"Your Password Successfully Updated!\"}",HttpStatus.OK);
			
			}else {
				
				return new ResponseEntity<String>("{\"message\":\"Old Password not matched!\"}",HttpStatus.BAD_REQUEST);
	
			}
		
	}
	
	
	@RequestMapping(value ="/Delete", method = RequestMethod.POST)
	public ResponseEntity<String> deleteMerchant( Model model,HttpServletRequest request,
			@RequestParam(value = "msgId") long msgId,boolean status) {

	   
		boolean result=service.update("update Messages_Master set status="+status+" where msgId="+msgId );
		System.out.println("Result Deleted:"+result);
		
		if(result)
			result=false;
			else
				result=true;
		
		return new ResponseEntity<String>("deleted Successfully!",HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/Payment", method = RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<String> payment( Model model,HttpServletRequest request,@RequestParam(value = "month") String month,@RequestParam(value = "year") String year,
			@RequestParam(value = "merchant_id") String merchant_id){
		
		try {
			if(month==null)
			{
				return new ResponseEntity<String>("Failure.",HttpStatus.BAD_REQUEST);
			}
			}catch(NullPointerException e) {
				return new ResponseEntity<String>("Failure",HttpStatus.BAD_REQUEST);
			}
		List<Object> list= service.list("select p.customer_mobile,p.customer_email,p.transaction_order_id,p.transaction_amount,p.transaction_status,p.transaction_type,p.transaction_update_date,p.transaction_payout ,p.customer_plan_name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.name from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_mobile from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_user_id from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_mobile from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.Description from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as remark ,msdm.merchant_business_name,sm.service_name from Transaction_Master p ,Merchant_Service_Detail_Master msdm,Service_Master sm where  p.transaction_status='SUCCESS'  AND  MONTH(p.transaction_update_date)="+month+"  AND  YEAR(p.transaction_update_date)="+year+"  AND  p.merchant_id='"+merchant_id+"'" + "and msdm.merchant_service_id=p.merchant_service_id and sm.service_id=msdm.service_code");
		
		if(list!=null) {
			
			return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity<String>("Failure!",HttpStatus.BAD_REQUEST);

		}
		
		
	}
	
	@RequestMapping(value ="/Recentpayment", method = RequestMethod.POST,headers = "Accept=application/json")
	
	public ResponseEntity<String> payment( Model model,HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id,@RequestParam(value = "calender_mode") String calender_mode){
		String date="";
		if(calender_mode.equals("D")) 
		date=" AND  DATE(p.transaction_update_date)=DATE(CURDATE()) ";
		List<Object> list= service.list("select p.customer_mobile,p.customer_email,p.transaction_order_id,p.transaction_amount,p.transaction_status,p.transaction_type,p.transaction_update_date,p.transaction_payout ,p.customer_plan_name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.name from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_mobile from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_user_id from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_mobile from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.Description from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as remark ,msdm.merchant_business_name,sm.service_name from Transaction_Master p ,Merchant_Service_Detail_Master msdm,Service_Master sm where  p.transaction_status='SUCCESS'  AND  MONTH(p.transaction_update_date)=MONTH(CURDATE())  AND  YEAR(p.transaction_update_date)=YEAR(CURDATE())  AND  p.merchant_id='"+merchant_id+"'" + "and msdm.merchant_service_id=p.merchant_service_id and sm.service_id=msdm.service_code"+date);
		
		if(list!=null) {
			
			return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity<String>("Failure!",HttpStatus.BAD_REQUEST);

		}
		
		
	}
	
@RequestMapping(value ="/CustomerList", method = RequestMethod.POST,headers = "Accept=application/json")
	
	public ResponseEntity<String> customer( Model model,HttpServletRequest request,@RequestParam(value = "merchant_id") String merchant_id){
		
		List<Object> list= service.list("select m.merchant_customer_id,m.merchant_customer_name,m.merchant_customer_mobile from Merchant_Customer_Master m where merchant_id='"+merchant_id+"'");	
		
		if(list!=null) {
			
			return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
		
		}else {
	
			return new ResponseEntity<String>("Failure!",HttpStatus.BAD_REQUEST);

		}
		
	}
	
@RequestMapping(value ="/SendPaymentLink", method = RequestMethod.POST)

public ResponseEntity<String> paymentlink( Model model,HttpServletRequest request,@RequestParam(value = "id") String id){
	String msg="please select customers";
	
	try {
		if(id.equals("")||id.equals(" ")||id==null)
			return new ResponseEntity<String>(""+msg,HttpStatus.OK);
	}catch(NullPointerException i) {
		return new ResponseEntity<String>(""+msg,HttpStatus.OK);
		
	}
	
   String str[]=id.split(":");
	
    for(String s:str) {
	
	System.out.println(str);

	System.out.println(id);
	ALL list=service.info("select m.*,mi.businessName from Merchant_Customer_Master m,Merchant_Info mi   where m.merchant_customer_id='"+s+"'  and mi.merchantId=m.merchant_id");
	
	//MyFunction.sendSMS(list.getMerchant_customer_mobile(),"Dear Customer, Welcome to Outgo Merchant family. We hope to give the most value add for your business. Thank you for choosing our services. Outgo Team.", Link.SELF_SMS_LINK);

	if(list!=null) {
		
		TransactionMaster tx=new TransactionMaster();
		tx.setTransaction_order_id("SLW"+System.currentTimeMillis());
		tx.setCustomer_mobile(list.getMerchant_customer_mobile());
		
		tx.setCustomer_email(list.getMerchant_customer_email());
		tx.setCustomer_plan_name(list.getMerchant_customer_plan());
		tx.setRef_id(Long.parseLong(list.getMerchant_customer_id()+""));
		tx.setTransaction_mode("Web Merchant Panel Link");
		tx.setMerchant_service_id(Long.parseLong(list.getMerchant_service_id()+""));
		tx.setRef_table("Merchant_Customer_Master");
		tx.setTransaction_amount(Double.parseDouble(list.getMerchant_customer_amount()+""));
		tx.setTransaction_payment_gatway_name("Citrus");
		tx.setTransaction_type("Online");
		tx.setTransaction_status("Pending");
		tx=service.saveCustomerTransaction(tx);
		String key= MyFunction.encriptUrl(tx.getTransaction_id()+"");
		
		
		String message="Dear "+list.getMerchant_customer_name()+", please pay your" +list.getBusinessName()+ " bill, using this link https://smartbiz.outgo.co/pay/"+key+" . Thank You.";
		
	
		Settings settings = null;
		try{
		settings=service.getSetting("select * from Settings s where s.merchant_id="+list.getMerchant_id());
		}catch(NullPointerException e){}
		
		try{
		if(settings.isSend_link_sms()) {
		SMSMaster sms=service.getSms("select * from SMS_MASTER sms where sms.merchant_id="+list.getMerchant_id());
		if(sms.getSmsLimit()>sms.getSmsCount()) {  

		
		MyFunction.sendSMS(list.getMerchant_customer_mobile(), message,sms.getSms_URL());
		sms.setSmsCount(sms.getSmsCount()+1);
		service.insertSMS(sms);
		msg="message has been sent";

		}else
			msg="Not sufficient balance,Please renew your SMS pack from web panel https://smartbiz.outgo.co";

		}else
			msg="Please start SMS service from our web pannel https://smartbiz.outgo.co to send messeges.";
		
		
		}
		catch(NullPointerException e){};
		}
	}

return new ResponseEntity<String>(""+msg,HttpStatus.OK);


}

@RequestMapping(value ="/Message", method = RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<String> message( Model model,HttpServletRequest request,@RequestParam(value = "merchant_id") String merchant_id){
		
		
	 String MSG_NAME="CASE msg.table_ref\n" + 
				"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n" + 
				"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n" + 
				"  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n" + 
				"  ELSE 'Unknow' END as name ";

	 String MSG_Mobile="CASE msg.table_ref\n" + 
				"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_mobile from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n" + 
				"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_mobile from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n" + 
				"  WHEN 'Customer_Master' THEN (select c.customer_mobile from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n" + 
				"  ELSE 'Unknow' END as mobile ";

    String empolyee=" CASE msg.employeeId\r\n" + 
				"  WHEN 0 THEN  'Un-Assigned'\r\n" + 
				"  ELSE (select cl.employeeName from Contact_login cl where cl.id=msg.employeeId ) END as Employee \r\n" + 
				"";

    String MSG_Email="CASE msg.table_ref\n" + 
			"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_email from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n" + 
			"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_email from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n" + 
			"  WHEN 'Customer_Master' THEN (select c.customer_email from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n" + 
			"  ELSE 'Unknow' END as email ";	
		
		
        String date=" AND  MONTH(msg.msg_create_date)=MONTH(CURDATE()) ";
		//List<Object> list1= service.list("select  from Messages_Master t where MONTH(t.msg_create_date)='"+month+"' and YEAR(t.msg_create_date)='"+year+"' and merchant_id='"+merchant_id+"'");
		
		List<Object> list1= service.list("select msg.msgId,msg.msg_create_date,msg.msg_description,msg.msg_status,msg.type,msg.merchant_id,SM.service_name,"+MSG_NAME+","+MSG_Mobile+","+MSG_Email+", "+empolyee +" from Messages_Master msg,Service_Master SM ,Area_Master AM ,Merchant_Service_Detail_Master MSDM where msg.merchant_id="+merchant_id+" and msg.status=1 and MSDM.merchant_id=msg.merchant_id AND SM.service_id=MSDM.service_code AND MSDM.service_area_id=AM.area_id AND MSDM.merchant_service_id=msg.merchant_service_id "+date);
		
		if(list1!=null){
			
			return new ResponseEntity<String>(new Gson().toJson(list1),HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity<String>("Failure!",HttpStatus.BAD_REQUEST);

		}
		
		
	}

@RequestMapping(value="/search" ,method=RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> search(Model model,HttpServletRequest request,@RequestParam(value = "merchant_id") String merchant_id,@RequestParam(value = "mobileno") String mobileno){

	
	JSONObject obj = new JSONObject();

	try {
	MerchantCustomerMaster list=service.searchUser("select * from Merchant_Customer_Master mcm where ( mcm.merchant_customer_mobile='"+mobileno+"' OR mcm.merchant_customer_user_id='"+mobileno+"') and merchant_id='"+merchant_id+"'").get(0);
	

	if(list!=null) {
		
		obj.put("cust_amount", list.getMerchant_customer_amount());
		obj.put("cust_email", list.getMerchant_customer_email());
		obj.put("cust_mobile", list.getMerchant_customer_mobile());
		obj.put("cust_name", list.getMerchant_customer_name());
		obj.put("message", "success");
		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

	}else {
		
		
		obj.put("message", "fail");
		return new ResponseEntity<String>(obj.toString(),HttpStatus.BAD_REQUEST) ;

	}
	}catch(IndexOutOfBoundsException e) {
		
		obj.put("message", "fail");
		return new ResponseEntity<String>(obj.toString(),HttpStatus.BAD_REQUEST) ;
	}
	
}


	@RequestMapping(value ="/Count", method = RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<String> count( Model model,HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id){
				
		
		String HomeCount="select (select sum(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' AND MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE()))  payments,\n" + 
				"       (select COUNT(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' and MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE())) payment_count,\n" + 
				"       (select  COUNT(m.merchant_customer_id) from Merchant_Customer_Master m where m.`status`=1 and m.merchant_id=[MERCHANTID] and m.merchant_service_id!=0) as customer_count,\n" + 
				"        (select  COUNT(mm.merchant_customer_id) from Merchant_Customer_Master mm where mm.`status`=0 and mm.merchant_id=[MERCHANTID] and mm.merchant_service_id!=0) as deactivecust,\n" + 
				"         (select COUNT(mmm.msgId ) from Messages_Master mmm where mmm.merchant_id=[MERCHANTID] and mmm.status=1 and MONTH(mmm.msg_create_date)=MONTH( CURDATE()) and YEAR(mmm.msg_create_date)=YEAR( CURDATE())) as enquiry_count,\n" + 
				"         (select COUNT(mmmm.msgId ) from Messages_Master mmmm where mmmm.merchant_id=[MERCHANTID] and mmmm.msg_status='Closed') as closemsg";
//				+ "(select count(i.invoice_num_id) from Invoice_Numbers i where i.status_invoice='PAID' and i.merchant_regi_id=[MERCHANTID] )as paid,"
//				+ "(select count(i.invoice_num_id) from Invoice_Numbers i where i.status_invoice!='PAID' and i.merchant_regi_id=[MERCHANTID] )as unpaid";
		
		HomeCount=HomeCount.replace("[MERCHANTID]", merchant_id);


		List<Object> list1= service.list(HomeCount);
		
		return new ResponseEntity<String>(new Gson().toJson(list1),HttpStatus.OK);
		
		}
	
@RequestMapping(value ="/Count", method = RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> count( Model model,HttpServletRequest request,
		@RequestParam(value = "merchant_id") String merchant_id){
			
	
	String HomeCount="select (select sum(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' AND MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE()))  payments,\n" + 
			"       (select COUNT(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' and MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE())) payment_count,\n" + 
			"       (select  COUNT(m.merchant_customer_id) from Merchant_Customer_Master m where m.`status`=1 and m.merchant_id=[MERCHANTID] and m.merchant_service_id!=0) as customer_count,\n" + 
			"        (select  COUNT(mm.merchant_customer_id) from Merchant_Customer_Master mm where mm.`status`=0 and mm.merchant_id=[MERCHANTID] and mm.merchant_service_id!=0) as deactivecust,\n" + 
			"         (select COUNT(mmm.msgId ) from Messages_Master mmm where mmm.merchant_id=[MERCHANTID] and mmm.status=1 and MONTH(mmm.msg_create_date)=MONTH( CURDATE()) and YEAR(mmm.msg_create_date)=YEAR( CURDATE())) as enquiry_count,\n" + 
			"         (select COUNT(mmmm.msgId ) from Messages_Master mmmm where mmmm.merchant_id=[MERCHANTID] and mmmm.msg_status='Closed') as closemsg,"
			+ "(select count(ex.amount) from Expenses ex where ex.merchantId=[MERCHANTID] and MONTH(ex.created_date)=MONTH(CURDATE()) and YEAR(ex.created_date)=YEAR(CURDATE())) as excount,"
			+ "(select sum(ex.amount) from Expenses ex where ex.merchantId=[MERCHANTID] and MONTH(ex.created_date)=MONTH(CURDATE()) and YEAR(ex.created_date)=YEAR(CURDATE())) as extotal";
	
	HomeCount=HomeCount.replace("[MERCHANTID]", merchant_id);


	List<Object> list1= service.list(HomeCount);
	
	return new ResponseEntity<String>(new Gson().toJson(list1),HttpStatus.OK);
	
	}




@RequestMapping(value ="/Link", method = RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> merchantLink( Model model,HttpServletRequest request,
		@RequestParam(value = "merchant_id") String merchant_id){
	String Name="CASE p.ref_table\n" + 
			"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))\n" + 
			"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))\n" + 
			"  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))\n" + 
			"  ELSE 'Unknow' \n" + 
			"END as name \n" + 
			"";



	List<Object> list1= service.list("select p.transaction_status as status,p.customer_mobile,p.transaction_id, "+Name+" from Transaction_Master p where p.merchant_id="+merchant_id+" and p.transaction_mode='Web Merchant Panel Link'");
	
	return new ResponseEntity<String>(new Gson().toJson(list1),HttpStatus.OK);
	
	}


@RequestMapping(value ="/Create_Link", method = RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> merchantCreateLink( Model model,HttpServletRequest request,
		@RequestParam(value = "merchant_id") long merchant_id,
		@RequestParam(value = "cust_name") String cust_name,
		@RequestParam(value = "cust_email") String cust_email,
		@RequestParam(value = "cust_mobile") String cust_mobile,
		@RequestParam(value = "cust_amount") double cust_amount,
		@RequestParam(value = "cust_desc") String cust_desc,TransactionMaster tx
		){
	
	ALL msdm=service.info("select m.Merchant_service_id,m.Merchant_business_name from Merchant_Service_Detail_Master m where m.merchant_id='"+merchant_id+"' group by merchant_id");
	
	MerchantCustomerMaster mm=service.searchUser("select * from Merchant_Customer_Master mcm where ( mcm.merchant_customer_mobile='"+cust_mobile+"' ) and merchant_id='"+merchant_id+"'").get(0);

	if(mm!=null) {
		
			tx.setRef_id(mm.getMerchant_customer_id());
	}else {
		
		mm.setMerchant_customer_email(cust_email);
		mm.setMerchant_customer_mobile(cust_mobile);
		mm.setMerchant_customer_name(cust_name);
		mm.setMerchant_customer_description(cust_desc);
		mm.setMerchant_customer_amount(cust_amount);
		mm.setMerchant_id(merchant_id);
		mm=service.insertTransaction(mm);
		mm.setMerchant_service_id(Long.parseLong(msdm.getMerchant_service_id()+""));
		
		tx.setRef_id(mm.getMerchant_customer_id());
	}
	try {
	tx.setMerchant_service_id(Long.parseLong(msdm.getMerchant_service_id()+""));
	}catch(NullPointerException e){}
     HttpSession session = request.getSession();
	
	JSONObject obj = new JSONObject();

	String business = (String) session.getAttribute("business");
	
	tx.setTransaction_order_id("SLW"+System.currentTimeMillis());
	
	tx.setRef_table("Merchant_Customer_Master");
	tx.setCustomer_mobile(cust_mobile);
	tx.setCustomer_email(cust_email);
	tx.setTransaction_payment_gatway_name("Citrus");
	tx.setTransaction_type("Online");
	tx.setTransaction_mode("app link");
	tx=service.saveCustomerTransaction(tx);

	String key=	MyFunction.encriptUrl(tx.getTransaction_id()+"");
	
	
	String message;;
	
	String msg="please select customers";

	message="Dear "+mm.getMerchant_customer_name()+", please pay your " +msdm.getMerchant_business_name()+ " bill, using this link https://smartbiz.outgo.co/pay/"+key+" . Thank You.";

	Settings settings = null;
	try{
	settings=service.getSetting("select * from Settings s where s.merchant_id="+mm.getMerchant_id());
	}catch(NullPointerException e){}
	
	try{
	if(settings.isSend_link_sms()) {
	SMSMaster sms=service.getSms("select * from SMS_MASTER sms where sms.merchant_id="+mm.getMerchant_id());
	if(sms.getSmsLimit()>sms.getSmsCount()) {  

	
	MyFunction.sendSMS(mm.getMerchant_customer_mobile(), message,sms.getSms_URL());
	sms.setSmsCount(sms.getSmsCount()+1);
	service.insertSMS(sms);
	 msg="message has been sent link is https://smartbiz.outgo.co/pay/"+key;

	}else
		msg="Not sufficient balance,Please renew your SMS pack from web panel https://smartbiz.outgo.co  link is https://smartbiz.outgo.co/pay/"+key;;

	}else
		msg="Please start SMS service from our web pannel https://smartbiz.outgo.co to send messeges.link is https://smartbiz.outgo.co/pay/"+key;;
	
	
	}
	catch(NullPointerException e){};
 	
	obj.put("success", msg);
	
    return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
	
	

}


@RequestMapping(value ="/ResendLink", method = RequestMethod.POST)
public ResponseEntity<String> resendLink( Model model,HttpServletRequest request,
		@RequestParam(value = "transaction_id") String transaction_id){
	String msg="please select customers";

	String Name="CASE tm.ref_table\n" + 
			"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((tm.ref_id=n.other_cust_id and tm.ref_table='Non_Register_Customer') ))\n" + 
			"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((tm.ref_id=m.merchant_customer_id and tm.ref_table='Merchant_Customer_Master') ))\n" + 
			"  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((tm.ref_id=c.customer_id and tm.ref_table='Customer_Master') ))\n" + 
			"  ELSE 'Unknow' \n" + 
			"END as merchant_customer_name \n" + "";
	

	ALL list=service.info("SELECT tm.customer_mobile,tm.merchant_id,cl.employeeName,cl.email,cl.mobileNo,mm.merchant_business_name,mm.merchant_terms_conditions,mm.contact_id,mm.merchant_service_logo,tx.gstn_number,tx.gst_tax,tx.pan_number,"+Name+" FROM Transaction_Master tm,Merchant_Service_Detail_Master mm,Tax_Master tx,Contact_login cl where \n" + 
			"			tm.merchant_service_id=mm.merchant_service_id  and\n" + 
			"			tx.tax_id=mm.tax_id and mm.contact_id=cl.id and tm.transaction_id='"+transaction_id+"'");

	ALL list=service.info("SELECT tm.customer_mobile,mm.merchant_business_name,"+Name+",tm.merchant_id FROM Transaction_Master tm,Merchant_Service_Detail_Master mm where \n" + 
			"			tm.merchant_service_id=mm.merchant_service_id and transaction_id='"+transaction_id+"'");

	
	String key= MyFunction.encriptUrl(transaction_id);
	String message="Dear "+list.getMerchant_customer_name()+", please pay your " +list.getMerchant_business_name()+ " bill, using this link https://smartbiz.outgo.co/pay/"+key+" . Thank You.";

	Settings settings = null;
	try{
	settings=service.getSetting("select * from Settings s where s.merchant_id="+list.getMerchant_id());
	}catch(NullPointerException e){}
	
	try{
	if(settings.isSend_link_sms()) {
	SMSMaster sms=service.getSms("select * from SMS_MASTER sms where sms.merchant_id="+list.getMerchant_id());
	if(sms.getSmsLimit()>sms.getSmsCount()) {  

	
	MyFunction.sendSMS(list.getCustomer_mobile(), message,sms.getSms_URL());
	sms.setSmsCount(sms.getSmsCount()+1);
	service.insertSMS(sms);
	 msg="message has been sent";

	}else
		msg="Not sufficient balance,Please renew your SMS pack from web panel https://smartbiz.outgo.co";

	}else
		msg="Please start SMS service from our web pannel https://smartbiz.outgo.co to send messeges.";
	
	
	}
	catch(NullPointerException e){};
	
		return new ResponseEntity<String>(""+msg,HttpStatus.OK);
}


@RequestMapping(value ="/payout", method = RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> payout( Model model,HttpServletRequest request, HttpSession session,
		@RequestParam(value = "merchant_id") String merchantId) throws JsonParseException, JsonMappingException, IOException{
	
	
	String date=SQLString.MONTH+SQLString.AND+SQLString.YEAR;
	date=date.replace("<MONTH>", Calendar.getInstance().get(Calendar.MONTH)+1+"").replace("<YEAR>", Calendar.getInstance().get(Calendar.YEAR)+"");

	String merchant=" p.merchant_id='"+merchantId+"'";
	List<String> strList=service.getstrList("select p.transaction_release_code as code from Transaction_Master  p "+SQLString.WHERE+merchant+SQLString.AND+date+" GROUP BY p.transaction_release_code");

	System.out.println(new Gson().toJson(strList));
	List<Object> list = new ArrayList<Object>();

	for(int i=0;i<strList.size();i++) {
	String json =new Gson().toJson(strList.get(i));
    ObjectMapper mapper = new ObjectMapper();		
    Map<String, Object> map = new HashMap<String, Object>();
    map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

    String sql="select sum(t.transaction_amount) as tx_amount,sum(t.transaction_realease_amount)as release_amount, \r\n" + 
		"sum(t.transaction_amount-t.transaction_realease_amount)as cut, t.transaction_release_code ,COUNT(b.bank_id) as txCount,\r\n" + 
		" b.bank_name,b.bank_account_number ,t.transaction_Release_date as release_date \r\n" + 
		"from Transaction_Master t ,Merchant_Service_Detail_Master m,Bank_Master b   where  t.merchant_id="+merchantId+"  and t.transaction_release_code='"+map.get("code")+"'    and t.transaction_payout=true\r\n" + 
		"and m.merchant_service_id=t.merchant_service_id and m.bank_id=b.bank_id  and t.transaction_status='SUCCESS' and t.transaction_type='Online' GROUP by b.bank_id\r\n" + 
		"";

    list.addAll(service.list(sql));
	
	}
	//model.addAttribute("list",list);
	
	return new ResponseEntity<String>(new Gson().toJson(list),HttpStatus.OK);
	
	}



@RequestMapping(value ="/Logout", method = RequestMethod.POST,headers = "Accept=application/json")
public ResponseEntity<String> logout( Model model,HttpServletRequest request,
		@RequestParam(value = "password") String password,
		@RequestParam(value = "mobileNo") String mobileNo){
	
	JSONObject obj = new JSONObject();
	
	User u = service.getUserdetail("select *  FROM Contact_login where mobileNo='"+mobileNo+"' and password='"+password+"'");
	if(u!=null) {
		
		obj.put("msg","success");
		return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
	
	}
	obj.put("message", "Your Password is changed please login again!");
	return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
	
	
}







}

	
	

*/

package com.outgo.controller;

/* Author Punam Patil.....*/

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.outgo.bean.ALL;
import com.outgo.bean.Expenses;
import com.outgo.bean.Interaction;
import com.outgo.bean.Merchant;
import com.outgo.bean.MerchantCustomerMaster;
import com.outgo.bean.MerchantServiceDetailMaster;
import com.outgo.bean.MessagesMaster;
import com.outgo.bean.OTP_Verifay;
import com.outgo.bean.OtherCustomerRegisterMaster;
import com.outgo.bean.SMSMaster;
import com.outgo.bean.Settings;
import com.outgo.bean.TransactionMaster;
import com.outgo.bean.User;
import com.outgo.messages.Link;
import com.outgo.messages.Messages;
import com.outgo.messages.SQLString;
import com.outgo.myfun.MyFunction;
import com.outgo.services.ApiServices;

@Controller
public class AppController {

	@Autowired
	ApiServices service;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> userLogin(Model model, HttpServletRequest request,
			@RequestParam(value = "mobileNo") String mobileNo, @RequestParam(value = "password") String password) {
		Map<String, String> map = new HashMap<String, String>();
		JSONObject obj = new JSONObject();
		try {
			if (mobileNo == null) {
				return new ResponseEntity<String>("Please Enter Mobile No.", HttpStatus.BAD_REQUEST);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Please Enter Mobile No.", HttpStatus.BAD_REQUEST);
		}

		User u = service.getUserdetail(
				"select *  FROM Contact_login where mobileNo='" + mobileNo + "'  and password='" + password + "'");

		if (u != null) {
			ALL m = service
					.getData("select m.businessName from Merchant_Info m where m.merchantId=" + u.getMerchantId());
			obj.put("merchant_id", u.getMerchantId());
			obj.put("password", u.getPassword());
			obj.put("name", u.getEmployeeName());
			obj.put("mobileno", u.getMobileNo());
			obj.put("businessName", m.getBusinessName());
			obj.put("msg", "success");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

		} else {

			return new ResponseEntity<String>("{\"msg\":\"Please enter correct password\"}", HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> changePassword(Model model, HttpServletRequest request,
			@RequestParam(value = "mobileNo") String mobileNo,
			@RequestParam(value = "new_password") String new_password,
			@RequestParam(value = "password") String old_password) {
		//Map<String, String> map = new HashMap<String, String>();

		try {
			if (new_password == null) {
				return new ResponseEntity<String>("Please Enter New Password.", HttpStatus.BAD_REQUEST);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Please Enter New Password.", HttpStatus.BAD_REQUEST);
		}

		boolean u = service.update("update Contact_login set password='" + new_password + "' where mobileNo='"
				+ mobileNo + "' and password='" + old_password + "'");

		//insertInteraction(email, name, mobile, serviceId, merchantId, description, interaction, ref_Id, teb);
		if (u) {
				User uu=service.getUserdetail(mobileNo);
			MyFunction.Email(uu.getEmail(), uu.getEmployeeName()+", your password was successfully reset", "Hi "+uu.getEmployeeName()+",\n" + 
					" \n" + 
					"You've successfully changed your deAzzle SmartBiz password.\n" + 
					" \n" + 
					"Thanks for using deAzzle!\n" + 
					"The deAzzle Team");
			insertInteraction(uu.getEmail(), uu.getEmployeeName(), uu.getMobileNo(), 47, 81, "Password Reset", "Email", uu.getId(), "Employee");
			
			return new ResponseEntity<String>("{\"message\":\"Your password is successfully updated!\"}",
					HttpStatus.OK);
			
			

		} else {

			return new ResponseEntity<String>("{\"message\":\"Old password is not matched!\"}", HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/Delete", method = RequestMethod.POST)
	public ResponseEntity<String> deleteMerchant(Model model, HttpServletRequest request,
			@RequestParam(value = "msgId") long msgId, boolean status) {

		boolean result = service.update("update Messages_Master set status=" + status + " where msgId=" + msgId);
		System.out.println("Result Deleted:" + result);

		if (result)
			result = false;
		else
			result = true;

		return new ResponseEntity<String>("deleted Successfully!", HttpStatus.OK);

	}

	@RequestMapping(value = "/Payment", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> payment(Model model, HttpServletRequest request,
			@RequestParam(value = "month") String month, @RequestParam(value = "year") String year,
			@RequestParam(value = "merchant_id") String merchant_id) {

		try {
			if (month == null) {
				return new ResponseEntity<String>("Failure.", HttpStatus.BAD_REQUEST);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}
		/*List<Object> list1 = service.list(
				"select p.customer_mobile,p.customer_email,p.transaction_order_id,p.transaction_amount,p.transaction_status,p.transaction_type,p.transaction_update_date,p.transaction_payout ,p.customer_plan_name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.name from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_mobile from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_user_id from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_mobile from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.Description from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as remark ,msdm.merchant_business_name,sm.service_name from Transaction_Master p ,Merchant_Service_Detail_Master msdm,Service_Master sm where  p.transaction_status='SUCCESS'  AND  MONTH(p.transaction_update_date)="
						+ month + "  AND  YEAR(p.transaction_update_date)=" + year + "  AND  p.merchant_id='"
						+ merchant_id + "'"
						+ "and msdm.merchant_service_id=p.merchant_service_id and sm.service_id=msdm.service_code ORDER BY p.transaction_id DESC");
*/		
		List<Object> list = service.list(
				"select p.customer_mobile,p.customer_email,p.transaction_order_id,p.transaction_amount,p.transaction_status,p.transaction_type,p.transaction_update_date,p.transaction_payout ,p.customer_plan_name,\n"
						+ "CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n \n"
						+ "	where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') )) \n"
						+ " WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m \n"
						+ " 	where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  \n"
						+ "  WHEN 'Merchant_Info' THEN (select mi.name from Merchant_Info mi where ((p.ref_id=mi.merchantId and p.ref_table='Merchant_Info') )) \n"
						+ "	 	WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c \n"
						+ "		 where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.name from Link_Transaction l \n"
						+ "		 	where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  \n"
						+ "			 ELSE 'Unknow' END as name,msdm.merchant_business_name,sm.service_name,\n"
						+ "			  CASE WHEN p.customer_userId IS NULL THEN 'N/A' ELSE p.customer_userId END AS remark\n"
						+ "			  from Transaction_Master p ,Merchant_Service_Detail_Master msdm,Service_Master sm where  p.transaction_status='SUCCESS'  AND  MONTH(p.transaction_update_date)="
						+ month + "  AND  YEAR(p.transaction_update_date)=" + year + "  AND  p.merchant_id='"
						+ merchant_id + "'"
						+ "and msdm.merchant_service_id=p.merchant_service_id and sm.service_id=msdm.service_code ORDER BY p.transaction_id DESC");
		if (list != null) {

			return new ResponseEntity<String>(new Gson().toJson(list), HttpStatus.OK);

		} else {

			return new ResponseEntity<String>("Failure!", HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "/ExpensesList", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> expenses_list(Model model, HttpServletRequest request,
			@RequestParam(value = "month") String month, @RequestParam(value = "year") String year,
			@RequestParam(value = "merchantId") String merchantId) {

		/*
		 * String
		 * HomeCount="select (select sum(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' AND MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE()))  payments,\n"
		 * +
		 * "       (select COUNT(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' and MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE())) payment_count,\n"
		 * +
		 * "       (select  COUNT(m.merchant_customer_id) from Merchant_Customer_Master m where m.`status`=1 and m.merchant_id=[MERCHANTID] and m.merchant_service_id!=0) as customer_count,\n"
		 * +
		 * "        (select  COUNT(mm.merchant_customer_id) from Merchant_Customer_Master mm where mm.`status`=0 and mm.merchant_id=[MERCHANTID] and mm.merchant_service_id!=0) as deactivecust,\n"
		 * +
		 * "         (select COUNT(mmm.msgId ) from Messages_Master mmm where mmm.merchant_id=[MERCHANTID] and mmm.status=1 and MONTH(mmm.msg_create_date)=MONTH( CURDATE()) and YEAR(mmm.msg_create_date)=YEAR( CURDATE())) as enquiry_count,\n"
		 * +
		 * "         (select COUNT(mmmm.msgId ) from Messages_Master mmmm where mmmm.merchant_id=[MERCHANTID] and mmmm.msg_status='Closed') as closemsg"
		 * ; +
		 * "(select count(i.invoice_num_id) from Invoice_Numbers i where i.status_invoice='PAID' and i.merchant_regi_id=[MERCHANTID] )as paid,"
		 * +
		 * "(select count(i.invoice_num_id) from Invoice_Numbers i where i.status_invoice!='PAID' and i.merchant_regi_id=[MERCHANTID] )as unpaid"
		 * ;
		 */

		try {
			if (month == null) {
				return new ResponseEntity<String>("Failure.", HttpStatus.BAD_REQUEST);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}
		List<Object> list = service.list(
				"select p.discription,p.selectedDate,p.amount,p.reference,p.category,p.type from Expenses p where MONTH(p.created_date)="
						+ month + "  AND  YEAR(p.created_date)=" + year + "  AND  p.merchantId='" + merchantId
						+ "'   ORDER BY p.id desc");

		if (list != null) {

			return new ResponseEntity<String>(new Gson().toJson(list), HttpStatus.OK);

		} else {

			return new ResponseEntity<String>("Failure!", HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/Recentpayment", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> payment(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id,
			@RequestParam(value = "calender_mode") String calender_mode) {
		String date = "";
		if (calender_mode.equals("D"))
			date = " AND  DATE(p.transaction_update_date)=DATE(CURDATE()) ";
		/*List<Object> list = service.list(
				"select p.customer_mobile,p.customer_email,p.transaction_order_id,p.transaction_amount,p.transaction_status,p.transaction_type,p.transaction_update_date,p.transaction_payout ,p.customer_plan_name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.name from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as name,CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_mobile from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_user_id from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))  WHEN 'Customer_Master' THEN (select c.customer_mobile from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.Description from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as remark ,msdm.merchant_business_name,sm.service_name from Transaction_Master p ,Merchant_Service_Detail_Master msdm,Service_Master sm where  p.transaction_status='SUCCESS'  AND  MONTH(p.transaction_update_date)=MONTH(CURDATE())  AND  YEAR(p.transaction_update_date)=YEAR(CURDATE())  AND  p.merchant_id='"
						+ merchant_id + "'"
						+ "and msdm.merchant_service_id=p.merchant_service_id and sm.service_id=msdm.service_code"
						+ date + " ORDER BY p.transaction_id DESC");*/ //old code
		List<Object> list = service.list(
				"select p.customer_mobile,p.customer_email,p.transaction_order_id,p.transaction_amount,p.transaction_status,p.transaction_type,p.transaction_update_date,p.transaction_payout ,p.customer_plan_name,\n" + 
				"			CASE p.ref_table  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n \n" + 
				"				where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))"
				+ "  WHEN 'Merchant_Info' THEN (select mi.name from Merchant_Info mi where ((p.ref_id=mi.merchantId and p.ref_table='Merchant_Info') )) \n"
				+ "  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m \n" + 
				"				where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') )) \n" + 
				"					 WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))  WHEN 'Link_Transaction' THEN (select l.name from Link_Transaction l where ((p.ref_id=l.id and p.ref_table='Link_Transaction') ))  ELSE 'Unknow' END as name,\n" + 
				"					 	CASE WHEN p.customer_userId IS NULL THEN 'N/A' ELSE p.customer_userId END AS remark,msdm.merchant_business_name,sm.service_name from Transaction_Master p ,Merchant_Service_Detail_Master msdm,Service_Master sm where  p.transaction_status='SUCCESS'  AND  MONTH(p.transaction_update_date)=MONTH(CURDATE())  AND  YEAR(p.transaction_update_date)=YEAR(CURDATE())  AND  p.merchant_id='"
						+ merchant_id + "'"
						+ "and msdm.merchant_service_id=p.merchant_service_id and sm.service_id=msdm.service_code"
						+ date + " ORDER BY p.transaction_id DESC");

		if (list != null) {

			return new ResponseEntity<String>(new Gson().toJson(list), HttpStatus.OK);

		} else {

			return new ResponseEntity<String>("Failure!", HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/CustomerList", method = RequestMethod.POST, headers = "Accept=application/json")

	public ResponseEntity<String> customer(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id) {

		List<Object> list = service.list(
				"select m.merchant_customer_id,m.merchant_customer_name,m.merchant_customer_mobile from Merchant_Customer_Master m where m.merchant_id='"
						+ merchant_id + "' and m.`status`=1");

		if (list != null) {

			return new ResponseEntity<String>(new Gson().toJson(list), HttpStatus.OK);

		} else {

			return new ResponseEntity<String>("Failure!", HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> forgetPassword(Model model, HttpServletRequest request,
			@RequestParam(value = "mobileNo") String mobileNo) {

		JSONObject obj = new JSONObject();

		try {
			if (mobileNo == null)
				return null;
			if (!mobileNo.matches("\\d{10}")) {
				obj.put("message", "Invalid Mobile No.");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			obj.put("message", "Invalid Mobile No.");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
		}

		User u = service.getUserdetail("select * from Contact_login where mobileNo='" + mobileNo + "'");

		// System.out.println(mobileNo+" "+new Gson().toJson(u));
		try {
			if (u == null) {
				obj.put("message", "Mobile No. not register");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			obj.put("message", "Mobile No. not register");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
		}

		String otp = String.valueOf(OTP_Verifay.OTP(6));
		OTP_Verifay OTP = new OTP_Verifay();
		OTP.setMobileNo(mobileNo);
		OTP.setOTP(otp);
		OTP.setCreateDate(MyFunction.date());
		OTP.setUpdateDate(MyFunction.date());
		OTP.setStatus(true);
		OTP = service.insertOTP(OTP);
		String message = "Your OTP for Forgot Password is [OTP]. Thanks, deAzzle.";
		message = message.replace("[OTP]", otp);

		MyFunction.sendOTP(mobileNo, message); // SMS OTP
		insertInteraction(u.getEmail(),u.getEmployeeName(), u.getMobileNo(), 47, 81,"Customer Verification", "SMS", u.getId(), "Employee");
		obj.put("message", "success");
		obj.put("code", OTP.getId());
		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

		// return ""+OTP.getId();

	}

	@RequestMapping(value = "/OTP", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> OTP(Model model, HttpServletRequest request,
			@RequestParam(value = "mobileNo") String mobileNo, @RequestParam(value = "id") long id,
			@RequestParam(value = "new_password") String new_password, @RequestParam(value = "otp") String otp) {

		JSONObject obj = new JSONObject();
		User u = service.getUserdetail("select * from Contact_login where mobileNo='" + mobileNo + "'");

		try {
			if (otp.matches("\\d{6}")) {
				OTP_Verifay otpv = service.validateOTP(otp, mobileNo, id, new_password);
				if (otpv.getOTP().equals(otp)) {

					obj.put("message", "Please Login With New Password");
					// OTP.setOTP(otp);
					u.setPassword(new_password);

					
					service.insertOTP(otpv);
					service.insertContact(u);
					
					MyFunction.Email(u.getEmail(), u.getEmployeeName()+", your password was successfully reset", "Hi "+u.getEmployeeName()+",\n" + 
							" \n" + 
							"You've successfully changed your deAzzle SmartBiz password.\n" + 
							" \n" + 
							"Thanks for using deAzzle!\n" + 
							"The deAzzle Team");
					insertInteraction(u.getEmail(), u.getEmployeeName(), u.getMobileNo(), 47, 81, "Password Reset", "Email", u.getId(), "Employee");

					// obj.put("mobileNo", otpv.getMobileNo());
					return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);
				}
			} else {
				obj.put("message", "Invalid Otp");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);

			}
		} catch (NullPointerException e) {

			obj.put("message", "Invalid Otp");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);

		}
		obj.put("message", "Invalid Otp");
		return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/SendPaymentLink", method = RequestMethod.POST)
	public ResponseEntity<String> paymentlink(Model model, HttpServletRequest request,
			@RequestParam(value = "id") String id) {
		String msg = "please select customers";
		try {
			if (id.equals("") || id.equals(" ") || id == null)
				return new ResponseEntity<String>("" + msg, HttpStatus.OK);
		} catch (NullPointerException i) {
			return new ResponseEntity<String>("" + msg, HttpStatus.OK);

		}

		String str[] = id.split(":");

		for (String s : str) {

			System.out.println(str);

			System.out.println(id);
			ALL list = service.info(
					"select m.*,mi.businessName from Merchant_Customer_Master m,Merchant_Info mi   where m.merchant_customer_id='"
							+ s + "'  and mi.merchantId=m.merchant_id");
			// MyFunction.sendSMS(list.getMerchant_customer_mobile(),"Dear Customer, Welcome
			// to Outgo Merchant family. We hope to give the most value add for your
			// business. Thank you for choosing our services. Outgo Team.",
			// Link.SELF_SMS_LINK);

			if (list != null) {
				TransactionMaster tx = new TransactionMaster();
				tx.setTransaction_order_id("SLW" + System.currentTimeMillis());
				tx.setCustomer_mobile(list.getMerchant_customer_mobile());
				tx.setCustomer_email(list.getMerchant_customer_email());
				tx.setCustomer_plan_name(list.getMerchant_customer_plan());
				tx.setRef_id(Long.parseLong(list.getMerchant_customer_id() + ""));
				tx.setTransaction_mode("Web Merchant Panel Link");
				tx.setMerchant_service_id(Long.parseLong(list.getMerchant_service_id() + ""));
				tx.setRef_table("Merchant_Customer_Master");
				tx.setTransaction_amount(Double.parseDouble(list.getMerchant_customer_amount() + ""));
				tx.setTransaction_payment_gatway_name("Citrus");
				tx.setTransaction_type("Online");
				tx.setTransaction_status("Pending");
				tx = service.saveCustomerTransaction(tx);
				String key = MyFunction.encriptUrl(tx.getTransaction_id() + "");
				String message = "Dear " + list.getMerchant_customer_name() + ", please pay your"
						+ list.getBusinessName() + " bill, using this link https://smartbiz.deazzle.in/pay/" + key
						+ " . Thank You.";
				Settings settings = null;
				
				insertInteraction(tx.getCustomer_email(), list.getMerchant_customer_name(), tx.getCustomer_mobile(), tx.getMerchant_service_id(), tx.getMerchant_id(), "Send Payment Link -> "+message, "SMS", tx.getTransaction_id(), "Transaction");
				try {
					settings = service
							.getSetting("select * from Settings s where s.merchant_id=" + list.getMerchant_id());
				} catch (NullPointerException e) {
				}

				try {
					if (settings.isSend_link_sms()) {
						SMSMaster sms = service
								.getSms("select * from SMS_MASTER sms where sms.merchant_id=" + list.getMerchant_id());
						if (sms.getSmsLimit() > sms.getSmsCount()) {
							MyFunction.sendSMS(list.getMerchant_customer_mobile(), message, sms.getSms_URL());
							sms.setSmsCount(sms.getSmsCount() + 1);
							service.insertSMS(sms);
							msg = "message has been sent";

						} else
							msg = "Not sufficient balance,Please renew your SMS pack from web panel https://smartbiz.deazzle.in";

					} else
						msg = "Please start SMS service from our web pannel https://smartbiz.deazzle.in to send messeges.";

				} catch (NullPointerException e) {
				}
				;
			}
		}

		return new ResponseEntity<String>("" + msg, HttpStatus.OK);

	}
		//+ "  WHEN 'Merchant_Info' THEN (select mi.name from Merchant_Info mi where ((p.ref_id=mi.merchantId and p.ref_table='Merchant_Info') )) \n"
	@RequestMapping(value = "/Message", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> message(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id) {
		String MSG_NAME = "CASE msg.table_ref\n"
				+ "  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n"
				+ "  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n"
				+ "  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n"
				+ "  ELSE 'Unknow' END as name ";
		String MSG_Mobile = "CASE msg.table_ref\n"
				+ "  WHEN 'Non_Register_Customer' THEN (select n.other_cust_mobile from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n"
				+ "  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_mobile from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n"
				+ "  WHEN 'Customer_Master' THEN (select c.customer_mobile from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n"
				+ "  ELSE 'Unknow' END as mobile ";
		String empolyee = " CASE msg.employeeId\r\n" + "  WHEN 0 THEN  'Un-Assigned'\r\n"
				+ "  ELSE (select cl.employeeName from Contact_login cl where cl.id=msg.employeeId ) END as Employee \r\n"
				+ "";
		String MSG_Email = "CASE msg.table_ref\n"
				+ "  WHEN 'Non_Register_Customer' THEN (select n.other_cust_email from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n"
				+ "  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_email from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n"
				+ "  WHEN 'Customer_Master' THEN (select c.customer_email from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n"
				+ "  ELSE 'Unknow' END as email ";
		String date = " AND  MONTH(msg.msg_create_date)=MONTH(CURDATE()) ";
		// List<Object> list1= service.list("select from Messages_Master t where
		// MONTH(t.msg_create_date)='"+month+"' and YEAR(t.msg_create_date)='"+year+"'
		// and merchant_id='"+merchant_id+"'");
		List<Object> list1 = service.list(
				"select msg.msgId,msg.msg_create_date,msg.msg_description,msg.msg_status,msg.type,msg.merchant_id,SM.service_name,"
						+ MSG_NAME + "," + MSG_Mobile + "," + MSG_Email + ", " + empolyee
						+ " from Messages_Master msg,Service_Master SM ,Area_Master AM ,Merchant_Service_Detail_Master MSDM where msg.merchant_id="
						+ merchant_id
						+ " and msg.status=1 and MSDM.merchant_id=msg.merchant_id AND SM.service_id=MSDM.service_code AND MSDM.service_area_id=AM.area_id AND MSDM.merchant_service_id=msg.merchant_service_id "
						+ date);

		if (list1 != null) {

			return new ResponseEntity<String>(new Gson().toJson(list1), HttpStatus.OK);

		} else {

			return new ResponseEntity<String>("Failure!", HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> search(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id,
			@RequestParam(value = "mobileno") String mobileno) {

		JSONObject obj = new JSONObject();

		try {
			MerchantCustomerMaster list = service
					.searchUser("select * from Merchant_Customer_Master mcm where ( mcm.merchant_customer_mobile='"
							+ mobileno + "' OR mcm.merchant_customer_user_id='" + mobileno + "') and merchant_id='"
							+ merchant_id + "'")
					.get(0);

			if (list != null) {

				obj.put("cust_amount", list.getMerchant_customer_amount());
				obj.put("cust_email", list.getMerchant_customer_email());
				obj.put("cust_mobile", list.getMerchant_customer_mobile());
				obj.put("cust_name", list.getMerchant_customer_name());
				obj.put("message", "success");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

			} else {

				obj.put("message", "fail");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);

			}
		} catch (IndexOutOfBoundsException e) {

			obj.put("message", "fail");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/Count", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> count(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id) {

		String HomeCount = "select (select  if(sum(t.transaction_amount),sum(t.transaction_amount),0) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' AND MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE()))  payments,\n"
				+ "       (select COUNT(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' and MONTH(t.transaction_update_date)=MONTH( CURDATE()) and YEAR(t.transaction_update_date)=YEAR( CURDATE())) payment_count,\n"
				+ "       (select  COUNT(m.merchant_customer_id) from Merchant_Customer_Master m where m.`status`=1 and m.merchant_id=[MERCHANTID] and m.merchant_service_id!=0) as customer_count,\n"
				+ "        (select  COUNT(mm.merchant_customer_id) from Merchant_Customer_Master mm where mm.`status`=0 and mm.merchant_id=[MERCHANTID] and mm.merchant_service_id!=0) as deactivecust,\n"
				+ "         (select COUNT(mmm.msgId ) from Messages_Master mmm where mmm.merchant_id=[MERCHANTID] and mmm.status=1 and MONTH(mmm.msg_create_date)=MONTH( CURDATE()) and YEAR(mmm.msg_create_date)=YEAR( CURDATE())) as enquiry_count,\n"
				+ "         (select COUNT(mmmm.msgId ) from Messages_Master mmmm where mmmm.merchant_id=[MERCHANTID] and mmmm.msg_status='Closed') as closemsg,"
				+ "(select count(ex.amount) from Expenses ex where ex.merchantId=[MERCHANTID] and MONTH(ex.created_date)=MONTH(CURDATE()) and YEAR(ex.created_date)=YEAR(CURDATE())) as excount,"
				+ "(select if(sum(ex.amount),sum(ex.amount),0) from Expenses ex where ex.merchantId=[MERCHANTID] and MONTH(ex.created_date)=MONTH(CURDATE()) and YEAR(ex.created_date)=YEAR(CURDATE())) as extotal";
		HomeCount = HomeCount.replace("[MERCHANTID]", merchant_id);

		List<Object> list1 = service.list(HomeCount);

		return new ResponseEntity<String>(new Gson().toJson(list1), HttpStatus.OK);

	}

	@RequestMapping(value = "/Link", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> merchantLink(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id) {
		String Name = "CASE p.ref_table\n"
				+ "  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))\n"
				+ "  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))\n"
				+ "  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))\n"
				+ "  ELSE 'Unknow' \n" + "END as name \n" + "";

		List<Object> list1 = service.list("select p.transaction_status as status,p.customer_mobile,p.transaction_id, "
				+ Name + " from Transaction_Master p where p.merchant_id=" + merchant_id
				+ " and p.transaction_mode like '%Link%'");

		return new ResponseEntity<String>(new Gson().toJson(list1), HttpStatus.OK);

	}

	@RequestMapping(value = "/Create_Link", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> merchantCreateLink(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") long merchant_id, @RequestParam(value = "cust_name") String cust_name,
			@RequestParam(value = "cust_email") String cust_email,
			@RequestParam(value = "cust_mobile") String cust_mobile,
			@RequestParam(value = "cust_amount") double cust_amount,
			@RequestParam(value = "cust_desc") String cust_desc, TransactionMaster tx) {

		ALL msdm = service.info(
				"select m.Merchant_service_id,m.Merchant_business_name from Merchant_Service_Detail_Master m where m.merchant_id='"
						+ merchant_id + "' group by merchant_id");
		MerchantCustomerMaster mm = new MerchantCustomerMaster();
		try {
			mm = service.searchUser("select * from Merchant_Customer_Master mcm where ( mcm.merchant_customer_mobile='"
					+ cust_mobile + "' ) and merchant_id='" + merchant_id + "'").get(0);
		} catch (IndexOutOfBoundsException e) {

		}
		if (mm.getMerchant_customer_id() != 0) {

			tx.setRef_id(mm.getMerchant_customer_id());
		} else {

			mm.setMerchant_customer_email(cust_email);
			mm.setMerchant_customer_mobile(cust_mobile);
			mm.setMerchant_customer_name(cust_name);
			mm.setMerchant_customer_description(cust_desc);
			mm.setMerchant_customer_amount(cust_amount);
			mm.setMerchant_id(merchant_id);
			mm = service.insertTransaction(mm);
			mm.setMerchant_service_id(Long.parseLong(msdm.getMerchant_service_id() + ""));

			tx.setRef_id(mm.getMerchant_customer_id());
		}
		try {
			tx.setMerchant_service_id(Long.parseLong(msdm.getMerchant_service_id() + ""));
		} catch (NullPointerException e) {
		}
		HttpSession session = request.getSession();

		JSONObject obj = new JSONObject();

		String business = (String) session.getAttribute("business");

		tx.setTransaction_order_id("SLW" + System.currentTimeMillis());

		tx.setRef_table("Merchant_Customer_Master");
		tx.setCustomer_mobile(cust_mobile);
		tx.setCustomer_email(cust_email);
		tx.setTransaction_payment_gatway_name("Citrus");
		tx.setTransaction_type("Online");
		tx.setTransaction_mode("app link");
		tx.setTransaction_amount(cust_amount);
		tx.setTransaction_status("Pending");
		tx = service.saveCustomerTransaction(tx);

		String key = MyFunction.encriptUrl(tx.getTransaction_id() + "");

		String message;
		;

		String msg = "please select customers";

		message = "Dear " + mm.getMerchant_customer_name() + ", please pay your " + msdm.getMerchant_business_name()
				+ " bill, using this link https://smartbiz.deazzle.in/pay/" + key + " . Thank You.";

		Settings settings = null;
		try {
			settings = service.getSetting("select * from Settings s where s.merchant_id=" + mm.getMerchant_id());
		} catch (NullPointerException e) {
		}

		try {

			if (settings.isSend_link_sms()) {
				SMSMaster sms = service
						.getSms("select * from SMS_MASTER sms where sms.merchant_id=" + mm.getMerchant_id());
				if (sms.getSmsLimit() > sms.getSmsCount()) {

					MyFunction.sendSMS(mm.getMerchant_customer_mobile(), message, sms.getSms_URL());
					sms.setSmsCount(sms.getSmsCount() + 1);
					service.insertSMS(sms);
					msg = "message has been sent link is https://smartbiz.deazzle.in/pay/" + key;

				} else
					msg = "Not sufficient balance,Please renew your SMS pack from web panel https://smartbiz.deazzle.in  link is https://smartbiz.deazzle.in/pay/"
							+ key;
				;

			} else
				msg = "Please start SMS service from our web pannel https://smartbiz.deazzle.in to send messeges.link is https://smartbiz.deazzle.in/pay/"
						+ key;
			;

		} catch (NullPointerException e) {
		}
		;
		insertInteraction(tx.getCustomer_email(), cust_name, tx.getCustomer_mobile(), tx.getMerchant_service_id(), tx.getMerchant_id(), "Send Payment Link -> "+message, "SMS", tx.getTransaction_id(), "Transaction");

		obj.put("success", msg);

		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/ResendLink", method = RequestMethod.POST)
	public ResponseEntity<String> resendLink(Model model, HttpServletRequest request,
			@RequestParam(value = "transaction_id") String transaction_id) {
		String msg = "please select customers";

		String Name = "CASE tm.ref_table\n"
				+ "  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((tm.ref_id=n.other_cust_id and tm.ref_table='Non_Register_Customer') ))\n"
				+ "  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((tm.ref_id=m.merchant_customer_id and tm.ref_table='Merchant_Customer_Master') ))\n"
				+ "  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((tm.ref_id=c.customer_id and tm.ref_table='Customer_Master') ))\n"
				+ "  ELSE 'Unknow' \n" + "END as merchant_customer_name \n" + "";

		/*
		 * ALL list=service.
		 * info("SELECT tm.customer_mobile,tm.merchant_id,cl.employeeName,cl.email,cl.mobileNo,mm.merchant_business_name,mm.merchant_terms_conditions,mm.contact_id,mm.merchant_service_logo,tx.gstn_number,tx.gst_tax,tx.pan_number,"
		 * +Name+" FROM Transaction_Master tm,Merchant_Service_Detail_Master mm,Tax_Master tx,Contact_login cl where \n"
		 * + "			tm.merchant_service_id=mm.merchant_service_id  and\n" +
		 * "			tx.tax_id=mm.tax_id and mm.contact_id=cl.id and tm.transaction_id='"
		 * +transaction_id+"'");
		 */
		ALL list = service.info("SELECT tm.customer_email,tm.merchant_service_id, tm.customer_mobile,mm.merchant_business_name," + Name
				+ ",tm.merchant_id FROM Transaction_Master tm,Merchant_Service_Detail_Master mm where \n"
				+ "			tm.merchant_service_id=mm.merchant_service_id and transaction_id='" + transaction_id + "'");

		String key = MyFunction.encriptUrl(transaction_id);
		String message = "Dear " + list.getMerchant_customer_name() + ", please pay your "
				+ list.getMerchant_business_name() + " bill, using this link https://smartbiz.deazzle.in/pay/" + key
				+ " . Thank You.";

		Settings settings = null;
		try {
			settings = service.getSetting("select * from Settings s where s.merchant_id=" + list.getMerchant_id());
		} catch (NullPointerException e) {
		}

		try {
			if (settings.isSend_link_sms()) {
				SMSMaster sms = service
						.getSms("select * from SMS_MASTER sms where sms.merchant_id=" + list.getMerchant_id());
				if (sms.getSmsLimit() > sms.getSmsCount()) {

					MyFunction.sendSMS(list.getCustomer_mobile(), message, sms.getSms_URL());
					sms.setSmsCount(sms.getSmsCount() + 1);
					service.insertSMS(sms);
					msg = "message has been sent";

				} else
					msg = "Not sufficient balance,Please renew your SMS pack from web panel https://smartbiz.deazzle.in";

			} else
				msg = "Please start SMS service from our web pannel https://smartbiz.deazzle.in to send messeges.";

		} catch (NullPointerException e) {
		}
		;
		insertInteraction(list.getMerchant_customer_email(), list.getMerchant_customer_name(), list.getCustomer_mobile(), Long.parseLong(list.getMerchant_service_id()+""), Long.parseLong(list.getMerchant_id()+""), "Resend  Payment Link -> "+message, "SMS", Long.parseLong(transaction_id), "Transaction");

		return new ResponseEntity<String>("" + msg, HttpStatus.OK);
	}

	@RequestMapping(value = "/payout", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> payout(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam(value = "merchant_id") String merchantId)
			throws JsonParseException, JsonMappingException, IOException {

		String date = SQLString.MONTH + SQLString.AND + SQLString.YEAR;
		date = date.replace("<MONTH>", Calendar.getInstance().get(Calendar.MONTH) + 1 + "").replace("<YEAR>",
				Calendar.getInstance().get(Calendar.YEAR) + "");

		String merchant = " p.merchant_id='" + merchantId + "'";
		List<String> strList = service
				.getstrList("select p.transaction_release_code as code from Transaction_Master  p " + SQLString.WHERE
						+ merchant + SQLString.AND + date + " GROUP BY p.transaction_release_code");

		System.out.println(new Gson().toJson(strList));
		List<Object> list = new ArrayList<Object>();

		for (int i = 0; i < strList.size(); i++) {
			String json = new Gson().toJson(strList.get(i));
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			map = mapper.readValue(json, new TypeReference<Map<String, String>>() {
			});

			String sql = "select sum(t.transaction_amount) as tx_amount,sum(t.transaction_realease_amount)as release_amount, \r\n"
					+ "sum(t.transaction_amount-t.transaction_realease_amount)as cut, t.transaction_release_code ,COUNT(b.bank_id) as txCount,\r\n"
					+ " b.bank_name,b.bank_account_number ,t.transaction_Release_date as release_date \r\n"
					+ "from Transaction_Master t ,Merchant_Service_Detail_Master m,Bank_Master b   where  t.merchant_id="
					+ merchantId + "  and t.transaction_release_code='" + map.get("code")
					+ "'    and t.transaction_payout=true\r\n"
					+ "and m.merchant_service_id=t.merchant_service_id and m.bank_id=b.bank_id  and t.transaction_status='SUCCESS' and t.transaction_type='Online' GROUP by b.bank_id\r\n"
					+ "";

			list.addAll(service.list(sql));

		}
		// model.addAttribute("list",list);

		return new ResponseEntity<String>(new Gson().toJson(list), HttpStatus.OK);

	}

	@RequestMapping(value = "/Service_Expired", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> expired_service(Model model, HttpServletRequest request,
			@RequestParam(value = "merchantId") String merchantId) {
		JSONObject obj = new JSONObject();
		ALL m = service.info("select m.expiry_date,m.service,m.businessName from Merchant_Info m where merchantId='" + merchantId + "'");
		int diff = dateDiff2(m.getExpiry_date());
		if (diff == 0 || diff < 0) { //check conditions
			System.out.println("my service--->"+m.getService());
			if(m.getService().equals("Pay As You Go")) {
				obj.put("msg", "True");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);
			}else {
			System.out.println(" else1--->" + diff);
			obj.put("msg", "False");
			
			ALL email=service.info("select l.email ,l.mobileNo from Contact_login l where l.merchantId="+merchantId+" LIMIT 1");
			
			insertInteraction(email.getEmail(), m.getBusinessName(), email.getMobileNo(), 47, 81, "deAzzle SmartBiz application is expired", "Email", Long.parseLong(merchantId), "Merchant");
			MyFunction.Email(email.getEmail(), "deAzzle SmartBiz application is expired ", "Dear Customer, you deAzzle SmartBiz application is expired already. Please renew your plan at https://www.deazzle.in/ . Thankyou, deAzzle Team");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
			}
		} else {
			
			obj.put("msg", "True");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);
		}

	}

	public static int dateDiff2(String date1) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			Date dt2 = dateFormat.parse(date1);
			Date dt1 = dateFormat.parse(date());
			int diffInDays = (int) ((dt2.getTime() - dt1.getTime()) / (1000 * 60 * 60 * 24));
			return diffInDays;
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return 0;

	}

	public static String date() {
		Calendar now = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(now.getTime());
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> logout(Model model, HttpServletRequest request,
			@RequestParam(value = "password") String password, @RequestParam(value = "mobileNo") String mobileNo) {

		JSONObject obj = new JSONObject();

		User u = service.getUserdetail(
				"select *  FROM Contact_login where mobileNo='" + mobileNo + "' and password='" + password + "'");
		if (u != null) {

			obj.put("msg", "success");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

		}
		obj.put("msg", "Your Password is changed please login again!");
		return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/updatetoken", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> token(Model model, HttpServletRequest request,
			@RequestParam(value = "token") String token, @RequestParam(value = "mobileNo") String mobileNo) {

		System.out.println(token);

		JSONObject obj = new JSONObject();

		User u = service.getUserdetail(
				"select *  FROM Contact_login where mobileNo='" + mobileNo + "' and token='" + token + "'");

		obj.put("success", "1");

		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/support", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> support(Model model, HttpServletRequest request,
			@RequestParam(value = "msg_description") String msg_description,
			@RequestParam(value = "merchant_id") long merchant_id) {

		JSONObject obj = new JSONObject();
		MessagesMaster mm = new MessagesMaster();

		mm.setTable_ref("Merchant_Info");
		mm.setMsg_description(msg_description);
		mm.setRef_id(merchant_id);
		mm.setMerchant_service_id(47);
		mm.setType("Enquiry");
		mm.setMsg_status("Open");
		mm.setMode("App");
		mm.setMerchantId(81);

		mm = service.insertMassages(mm);

		User u = service.getUserdetail(
				"select * from Contact_login l where l.merchantId="+merchant_id+" LIMIT 1");
			
		MyFunction.Email("support@deazzle.in", "Seller Enquiry", "Seller Name: "+u.getEmployeeName()+" "
				+ msg_description);
		insertInteraction(u.getEmail(), u.getEmail(), u.getMobileNo(), 47, 81, "Open Enquiry", "Enquiry", mm.getMsgId(), "Messages");
		
		obj.put("message:", "success");
		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/Expenses", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> saveexpenses(Model model, HttpServletRequest request,
			@RequestParam(value = "discription") String discription,
			@RequestParam(value = "merchantId") long merchantId, @RequestParam(value = "category") String category,
			@RequestParam(value = "amount") String amount, @RequestParam(value = "reference") String reference,
			@RequestParam(value = "type") String type, @RequestParam(value = "selectedDate") String selectedDate) {

		JSONObject obj = new JSONObject();
		Expenses exp = new Expenses();

		try {
			if (discription == null || discription.equals("")) {
				obj.put("error", "Please enter description");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
			}
		} catch (NullPointerException e) {
			obj.put("error", "Please enter description");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
		}
		try {
			if (category == null || category.equals("")) {
				obj.put("error", "Please enter category");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
			}
		} catch (NullPointerException e) {
			obj.put("error", "Please enter category");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
		}
		try {
			if (amount == null || amount.equals("")) {
				obj.put("error", "Please enter amount");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
			}
		} catch (NullPointerException e) {
			obj.put("error", "Please enter amount");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
		}
		try {
			if (reference == null || reference.equals("")) {
				obj.put("error", "Please enter reference");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
			}
		} catch (NullPointerException e) {
			obj.put("error", "Please enter reference");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
		}

		try {
			if (type == null || type.equals("")) {
				obj.put("error", "Please enter type");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
			}
		} catch (NullPointerException e) {
			obj.put("error", "Please enter type");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
		}
		try {
			if (selectedDate == null || selectedDate.equals("")) {
				obj.put("error", "Please enter Date");
				return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
			}
		} catch (NullPointerException e) {
			obj.put("error", "Please enter Date");
			return new ResponseEntity<String>(obj.toString(), HttpStatus.NOT_FOUND);
		}
		exp.setDiscription(discription);
		exp.setCategory(category);
		exp.setAmount(amount);
		exp.setReference(reference);
		exp.setType(type);
		exp.setSelectedDate(selectedDate);
		exp.setMerchantId(merchantId);
		;
		exp = service.insertexpenses(exp);
		obj.put("message:", "success");

		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/New_message", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> message(Model model, HttpServletRequest request,
			@RequestParam(value = "msg_description") String msg_description,
			@RequestParam(value = "merchant_id") long merchant_id,
			@RequestParam(value = "cust_mobile") String cust_mobile, @RequestParam(value = "type") String type) {

		JSONObject obj = new JSONObject();
		MessagesMaster mm = new MessagesMaster();
		try {

			if (mm.getRef_id() == 0) {

				List<OtherCustomerRegisterMaster> list = service.getNonRegisterCustomerr(
						"select * from Non_Register_Customer nrc where nrc.other_cust_mobile='" + cust_mobile + "'");
				try {
					System.out.println("SIZE-" + list.size());
					if (list.size() != 0) {
						mm.setRef_id(list.get(0).getOther_cust_id());
					} else {
						OtherCustomerRegisterMaster OCRM = new OtherCustomerRegisterMaster();
						OCRM.setOther_cust_address(request.getParameter("custAddress"));
						// OCRM.setOther_cust_email(customer_email);
						OCRM.setOther_cust_mobile(cust_mobile);
						OCRM.setOther_cust_name(request.getParameter("custName"));
						OCRM = service.saveNonRegisterCustomer(OCRM);
						mm.setRef_id(OCRM.getOther_cust_id());
					}

				} catch (NullPointerException n) {
				}

				mm.setTable_ref("Non_Register_Customer");
			} else {
				mm.setTable_ref("Merchant_Customer_Master");
			}

		} catch (NullPointerException e) {
		}

		// mm.setTable_ref("Merchant_Info");
		mm.setMsg_description(msg_description);
		// mm.setRef_id(merchant_id);
		mm.setMerchant_service_id(6);
		mm.setType(type);
		mm.setMsg_status("Open");
		mm.setMode("App");
		mm.setMerchantId(merchant_id);
		mm = service.insertMassages(mm);
		
		insertInteraction("", request.getParameter("custName"), cust_mobile, 6, merchant_id, msg_description, type, mm.getMsgId(), "Complaint");
		obj.put("message:", "success");
		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

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
	
	
	
	
	
	
	@RequestMapping(value = "/insertInteraction", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> insertInteraction(Model model, HttpServletRequest request,
			@RequestParam(value = "merchant_id") String merchant_id,@RequestParam(value = "interation") String interation,@RequestParam(value = "des") String des) {
		
		User u = service.getUserdetail("select * from Contact_login where merchantId='" + merchant_id + "' limit 1");
		
		insertInteraction(u.getEmail(), u.getEmployeeName(), u.getMobileNo(), 47, 81, des, interation, u.getId(), "Employee");
		JSONObject obj = new JSONObject();
		obj.put("msg", "Success");

		return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);

	}

}
