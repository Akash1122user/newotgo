package com.outgo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.record.formula.functions.False;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.outgo.bean.ALL;
import com.outgo.bean.Interaction;
import com.outgo.bean.MerchantCustomerMaster;
import com.outgo.bean.Merchant_Payment_keys;
import com.outgo.bean.MessagesMaster;
import com.outgo.bean.OtherCustomerRegisterMaster;
import com.outgo.bean.SMSMaster;
import com.outgo.bean.SendKeys;
import com.outgo.bean.Settings;
import com.outgo.bean.TransactionMaster;
import com.outgo.keyClass.CitrusKey;
import com.outgo.messages.Error;
import com.outgo.messages.Link;
import com.outgo.messages.Messages;
import com.outgo.myfun.MyFunction;
import com.outgo.services.ApiServices;
/* Author Pranal Sawarkar.....*/
@Controller
public class UserController {
	@Autowired
	ApiServices service;
	
	@ResponseBody
	@RequestMapping(value="/googleb1829dd02edce981.html")
	public ModelAndView  google() {
		
		ModelAndView mav = new ModelAndView();
			
	    mav.setViewName("outgo/google");
	    return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/about-us")
	public ModelAndView  about() {
		
		ModelAndView mav = new ModelAndView();
			
	    mav.setViewName("outgo/aboutus");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/blogs")
	public ModelAndView  blog() {
		
		ModelAndView mav = new ModelAndView();
			
	    mav.setViewName("outgo/blogs");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/contact")
	public ModelAndView  contact() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("outgo/contact");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/terms")
	public ModelAndView  terms() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("outgo/terms");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/services")
	public ModelAndView  services() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("outgo/services");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/pricing")
	public ModelAndView  pricing() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("outgo/pricing");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/404")
	public ModelAndView  error404() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("outgo/404");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/home")
	public ModelAndView  back() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("redirect:/");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/test")
	public ModelAndView  testttt() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("appOutgo/appResponse");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/user-home")
	public ModelAndView  user() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("outgo/user-home");
	    return mav;
	}
	@ResponseBody
	@RequestMapping(value="/user-hometest1---Test")
	public ModelAndView  user1() {
		
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("outgo/user-home");
	    return mav;
	}
	
	
	@RequestMapping(value="/getMyCityArea") 
	public String  getCity(HttpServletRequest request,
			HttpServletResponse response, Model model,@RequestParam(value="city_id",defaultValue="0",required=false) String city_id ) {
		try {
			//System.out.println(city_id);
			List<Object> cityList=null;
				if(city_id.equals("0")||city_id.equals(null)) {
					cityList=service.list("select * FROM City_Master");
				}else {
					 cityList=service.list("select am.area_id,am.area_name from Area_Master am,Merchant_Service_Detail_Master msm where am.area_id=msm.service_area_id  and am.city_id="+Long.parseLong(city_id)+" GROUP BY am.area_id");
				}			
		//System.out.println("city list my cityyyyy--->"+new Gson().toJson(cityList));
		response.getWriter().write(new Gson().toJson(cityList));
		} catch (NullPointerException e) {
			// TODO: handle exception
			return "error";
		}catch (IndexOutOfBoundsException e2) {
			// TODO: handle exception
			return "error";
		}catch (IOException e) {
			return "error";
		}
		return null;
	
	}
	
	
	
	//Get All data
	@RequestMapping(value="/getServicesWIthMerchant") 
	public String  getServicesWIthMerchant(HttpServletRequest request,
			HttpServletResponse response, Model model,@RequestParam(value="s_id",defaultValue="N/A",required=false) String s_id,@RequestParam(value="area_id",defaultValue="0",required=false) String area_id,@RequestParam(value="mode")String mode) {
		try {
			//System.out.println(area_id);
			List<Object> allData=null;
			/*String sql="Select msm.*,sm.service_name,tm.gst_tax,ams.area_name ,cmm.city_name,mpk.* from Merchant_Service_Detail_Master msm, Service_Master sm ,Address_Master am ,Tax_Master tm,Area_Master ams, City_Master cmm,Merchant_Payment_keys mpk  where msm.service_area_id="+Long.parseLong(area_id) +" and msm.service_code=sm.service_id and sm.`status`=1 and"
					+ " am.address_id=msm.address_id and msm.tax_id=tm.tax_id and ams.area_id=msm.service_area_id and cmm.city_id=ams.city_id and msm.merchant_id=mpk.merchant_key ";
		*/	
			String sql="Select msm.merchant_service_id,msm.merchant_id,msm.merchant_business_name,msm.merchant_service_logo,sm.service_name,ams.area_name ,cmm.city_name,mpk.merchant_key_url,mpk.access_key from Merchant_Service_Detail_Master msm, Service_Master sm ,Address_Master am ,Tax_Master tm,Area_Master ams, City_Master cmm,Merchant_Payment_keys mpk  where msm.service_area_id="+Long.parseLong(area_id) +" and msm.service_code=sm.service_id and sm.`status`=1 and"
					+ " am.address_id=msm.address_id and msm.tax_id=tm.tax_id and ams.area_id=msm.service_area_id and cmm.city_id=ams.city_id and msm.merchant_id=mpk.merchant_key ";
		
			if(area_id.equals("N/A")||area_id.equals(null)) {
					return "error";
				}else {
					if(mode.equals("0"))
					allData=service.list(sql+" group by msm.merchant_service_id");
					if(mode.equals("1"))
					allData=service.list(sql+" and sm.service_id="+Long.parseLong(s_id)+" group by msm.merchant_service_id");	
				}
			
		//System.out.println("All Data list--->"+new Gson().toJson(allData));
		response.getWriter().write(new Gson().toJson(allData));
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			return "error";
		}catch (IndexOutOfBoundsException e2) {
			// TODO: handle exception
			return "error";
		}catch (IOException e) {
			return "error";
		}
		return null;
	
	}
	
	@ResponseBody
	@RequestMapping(value="/getServiceToPay" )
	public String  mailgmail(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="area_id",defaultValue="0",required=false) String area_id) {
		
		try {
			//System.out.println(area_id);
			List<Object> allData=null;
			String sql="select sm.service_name,sm.service_id from  Merchant_Service_Detail_Master msm,Service_Master sm where msm.service_area_id="+Long.parseLong(area_id) +" and sm.service_id=msm.service_code GROUP by sm.service_name";
				if(area_id.equals("N/A")||area_id.equals(null)) {
					return "error";
				}else {					
					allData=service.list(sql);	
				}
				//System.out.println("All Data Service to Pay--->"+new Gson().toJson(allData));
				response.getWriter().write(new Gson().toJson(allData));
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	//Enquiry Admin
	@ResponseBody
	@RequestMapping(value="/outgoEnq" )
	public String  outgoEnq(HttpServletRequest request,HttpServletResponse response,MessagesMaster msg,String customer_mobile,String customer_email) {
		Map<String,String> map=new HashMap<String, String>();
		try {
			//System.out.println(msg.getMerchantId());
			List<OtherCustomerRegisterMaster> list=service.getNonRegisterCustomerr("select * from Non_Register_Customer nrc where nrc.other_cust_mobile='"+customer_mobile+"'");
			
			if(msg.getRef_id()==0) {
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
		} catch (NullPointerException e) {
			return null;
		}	
		
		msg.setMsg_description(msg.getMsg_description());
		msg.setMerchant_service_id(msg.getMerchant_service_id());
		msg.setMerchantId(msg.getMerchantId());
		msg.setMode("deAzzle Web Site");
		msg.setMsg_status("Open");
		msg.setStatus(true);
		msg.setType("Enquiry");
		msg=service.insertMassages(msg);	
			
		insertInteraction(customer_email, request.getParameter("custName"), customer_mobile, msg.getMerchant_service_id(), msg.getMerchantId(), "Open "+msg.getType(), msg.getType(), msg.getMsgId(), "Complaint");
	
		
		//map.put("error", "error");
		map.put("msg",Error.InsertMSG);
		map.put("data",new Gson().toJson(msg));
		 try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return null;
	}
	
	//pay bill OutGo

		
	@RequestMapping(value="/redirectOutGo" )
	public  ModelAndView redirectOutGo(Model model,HttpServletRequest request ){
		
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
			        			
			        			//System.out.println("Email Merchant ---------------------------------------");
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
				        			  
				        			  //---------------------------
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
				        			  //----------------------------
				        			  
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
			        						 		    		+ ",m.merchant_customer_plan_renew_date='"+date1+"',m.payment_status=true where "
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
	     
	   // request.setAttribute("keys",keys);
		request.setAttribute("firstName",firstName);
		request.setAttribute("amount",amount);
		request.setAttribute("TxId",TxId);
		request.setAttribute("txnDateTime",txnDateTime);
		request.setAttribute("TxStatus",request.getParameter("TxStatus"));
		request.setAttribute("email",email);
		request.setAttribute("paymentMode",paymentMode);
		//request.setAttribute("action",keys.getReturn_url());
		//request.setAttribute("method",keys.getForm_method());
		insertInteraction(email, firstName, tx.getCustomer_email(), tx.getMerchant_service_id(), tx.getMerchant_id(), tx.getTransaction_status(), tx.getTransaction_type()+" Payment", tx.getTransaction_id(), "Transaction");
		if(mode.equals("App")) {
			mav.setViewName("appOutgo/appResponse");
			//mav.setViewName("appOutgo/brpay");//brpay
		}
		if(mode.equals("Web")) {
			mav.setViewName("outgo/outgoResponseStatus");
		} 
		//return mav;
		return mav;
		
	}

	
	
	@RequestMapping(value="/paybillOutgo/{keyurl}" ,method=RequestMethod.POST)
	public String  paybillOutgo(Model model,TransactionMaster tx,HttpServletRequest request,
			HttpServletResponse response,String name,String address,@PathVariable("keyurl") String keyurl,@RequestParam(value="validity", defaultValue="N/A",required=false)  String validity,
			@RequestParam(value="mode", defaultValue="Web",required=false)String mode) {
		
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
				model.addAttribute("error","Authentication Fail...Please Enter Mobile No.");
				return "error";	
			}
			if (!tx.getCustomer_mobile().matches("\\d{10}")) 
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
		
		//System.out.println("ref_id-->" +new Gson().toJson(tx));
		 double total=0;
		  ALL all=service.getData("select tm.gst_tax,s.taxGstType from Settings s ,Tax_Master tm where  tm.merchant_id=s.merchant_id and s.merchant_id="+Long.parseLong(keys.getMerchant_key())+" and s.display_gstin_calaculate_in_receipt=true");
		  try {
				if(all.isTaxGstType()) {
			  if(all.equals(null)) {total=tx.getTransaction_amount(); }
			  else {
				 total=(tx.getTransaction_amount()*Double.parseDouble(all.getGst_tax())/100)+tx.getTransaction_amount();
			  }
				}else {
					total=tx.getTransaction_amount();
				}
			  } catch (NullPointerException e) {
				  total=tx.getTransaction_amount();
				}
			  tx.setTransaction_amount(total);
		  if(mode.equals("Web")) { 
		try{
			//System.out.println("ref_id2-->" +tx.getRef_id());
			 
			if(tx.getRef_id()==0){
				
				OtherCustomerRegisterMaster o=service.getNonRegisterCustomer("select * from Non_Register_Customer n where n.other_cust_mobile='"+tx.getCustomer_mobile()+"'");
				//System.out.println("list "+new Gson().toJson(o));
				try{
				if(o==null){
					OtherCustomerRegisterMaster ocrm=new OtherCustomerRegisterMaster();
					ocrm.setOther_cust_address(address);
					ocrm.setOther_cust_email(tx.getCustomer_email());
					ocrm.setOther_cust_mobile(tx.getCustomer_mobile());
					ocrm.setOther_cust_name(name);
					ocrm=service.saveNonRegisterCustomer(ocrm);
					tx.setRef_id(ocrm.getOther_cust_id());
					tx.setRef_table("non_register_customer");
				}else{
					tx.setRef_id(o.getOther_cust_id());
					tx.setRef_table("non_register_customer");
				}}catch(NullPointerException n){
					OtherCustomerRegisterMaster ocrm=new OtherCustomerRegisterMaster();
					ocrm.setOther_cust_address(address);
					ocrm.setOther_cust_email(tx.getCustomer_email());
					ocrm.setOther_cust_mobile(tx.getCustomer_mobile());
					ocrm.setOther_cust_name(name);
					ocrm=service.saveNonRegisterCustomer(ocrm);
					tx.setRef_id(ocrm.getOther_cust_id());
					tx.setRef_table("Non_Register_Customer");
				}
				
			}else{
				tx.setRef_table("Merchant_Customer_Master");
			}
		}
		catch(NullPointerException e) {
			
			//System.out.println("ref_id-->" +tx.getRef_id());
		}
		
		tx.setTransaction_mode("deAzzle Site");
		tx.setTransaction_payment_gatway_name("Citrus");
		tx.setTransaction_type("Online");
		
		try {

			if(tx.getTransaction_order_id()==null)
				tx.setTransaction_order_id("US"+System.currentTimeMillis());
			if(tx.getTransaction_order_id().equals(""))
				tx.setTransaction_order_id("US"+System.currentTimeMillis());
			
		}catch(NullPointerException n) {tx.setTransaction_order_id("US"+System.currentTimeMillis());
}
	}
		  
		  
	if(mode.equals("App")) { // app code
		
		tx.setRef_table("Customer_Master");
		tx.setTransaction_mode("App");
		tx.setTransaction_payment_gatway_name("Citrus");
		tx.setTransaction_type("Online");
		
		try {

			if(tx.getTransaction_order_id()==null)
				tx.setTransaction_order_id("UAP"+System.currentTimeMillis());
			if(tx.getTransaction_order_id().equals(""))
				tx.setTransaction_order_id("UAP"+System.currentTimeMillis());
			
		}catch(NullPointerException n) {tx.setTransaction_order_id("UAP"+System.currentTimeMillis());
		}
	}
		
		tx.setMerchant_id(Long.parseLong((keys.merchant_key)));
		
		
		//save data in transaction table		
		tx=service.saveCustomerTransaction(tx);
		//System.out.println("Done "+new Gson().toJson(tx));
		
		
		
		//search service by service id
		String service_name=service.getService(tx.getMerchant_service_id());
		//System.out.println("service name-->"+service_name);
		request.setAttribute("email",tx.getCustomer_email());
		//request.setAttribute("amount",tx.getTransaction_amount());//total
		request.setAttribute("amount",total);
		request.setAttribute("mobile",tx.getCustomer_mobile());
		request.setAttribute("address", address);
		request.setAttribute("name",name);
		request.setAttribute("service_name",service_name);
		request.setAttribute("validity", validity); //Pranal Changes
		
		request.setAttribute("mode", mode); //Pranal Changes
		
		SendKeys key=new SendKeys();
		key.setCurrency(CitrusKey.currency);
		key.setFormPostUrl(CitrusKey.formPostUrl);
		key.setMerchantTxnId(tx.getTransaction_order_id());
		key.setEmail(tx.getCustomer_email());
		key.setMobile(tx.getCustomer_mobile());
		//key.setMode(mode);
		//key.setNotifyUrl(CitrusKey.notifyUrl+"redirect");
		key.setAddress(validity);
		key.setReturnURL(CitrusKey.returnURL+"redirectOutGo");
		//key.setAmount(tx.getTransaction_amount());
		key.setAmount(total);
		//key.setSecuritySignature(CitrusKey.securitySignature(tx.getTransaction_amount()+"" , tx.getTransaction_order_id()));
		key.setSecuritySignature(CitrusKey.securitySignature(total+"" , tx.getTransaction_order_id()));
		//request.setAttribute("key",key); 
		request.setAttribute("returnURL",CitrusKey.returnURL+"redirectOutGo");
		request.setAttribute("formPostUrl",CitrusKey.formPostUrl);
		request.setAttribute("currency",CitrusKey.currency);
		request.setAttribute("MerchantTxnId",key.merchantTxnId);
		request.setAttribute("secSignature",key.securitySignature);
		if(mode.equals("App")) {
			 return "appOutgo/cnfInfo"; //brpay		 
		}
		if(mode.equals("Web")) {
		 return "outgo/outgoPayInfo";
		}else 
		return null;
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
