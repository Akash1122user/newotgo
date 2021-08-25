package com.outgo.services;

import java.util.List;

import org.hibernate.cfg.Settings;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.outgo.bean.ALL;
import com.outgo.bean.CityMaster;
import com.outgo.bean.CustomerMaster;
import com.outgo.bean.ExpenceMaster;
import com.outgo.bean.ExpenseCategories;
import com.outgo.bean.Expenses;
import com.outgo.bean.IncomeMaster;
import com.outgo.bean.Interaction;
import com.outgo.bean.MerchantCustomerMaster;
import com.outgo.bean.MerchantServiceDetailMaster;
import com.outgo.bean.Merchant_Payment_keys;
import com.outgo.bean.MessagesMaster;
import com.outgo.bean.OTP_Verifay;
import com.outgo.bean.OtherCustomerRegisterMaster;
import com.outgo.bean.SMSMaster;
import com.outgo.bean.ServiceMaster;
import com.outgo.bean.TaxInvoice;
import com.outgo.bean.TransactionMaster;
import com.outgo.bean.User;


public interface ApiServices {

	List<Object> list(String sql);

	OtherCustomerRegisterMaster getNonRegisterCustomer(String sql);

	OtherCustomerRegisterMaster saveNonRegisterCustomer(OtherCustomerRegisterMaster ocrm);

	TransactionMaster saveCustomerTransaction(TransactionMaster tx);

	String getService(long sid);

	TransactionMaster getTransaction(String txId);

	MessagesMaster insertMassages(MessagesMaster msg);

	com.outgo.bean.Settings getSetting(String string);

	SMSMaster getSms(String string);

	void insertSMS(SMSMaster sms);

	List<OtherCustomerRegisterMaster> getNonRegisterCustomerr(String string);

	List<MerchantCustomerMaster> searchUser(String string);

	User getUserdetail(String mobileNo);

	boolean update(String sql);

	TransactionMaster payment(String sql);

	ALL info(String sql);

	List<String> getstrList(String string);

	MerchantCustomerMaster insertTransaction(MerchantCustomerMaster mm);

	Merchant_Payment_keys getMerchantKey(String sql);

	
	ALL getData(String sql);
	
	/*
	 * 
	 * Pranal Sawarkar
	 */

	MerchantCustomerMaster searchUserMerchant(String sql);

	MerchantCustomerMaster saveRegisterCustomer(MerchantCustomerMaster cust);

	OTP_Verifay insertOTP(OTP_Verifay oTP);

	OTP_Verifay validateOTP(String otp, String merchant_customer_mobile, long id);

	Expenses insertexpenses(Expenses exp);

	OTP_Verifay validateOTP(String otp, String mobileNo, long id, String new_password);

	User insertContact(User u);
	//OtherCustomerRegisterMaster insertNonRegisterCustomer(OtherCustomerRegisterMaster oCRM);
	// user Actions

	boolean saveOutGoCustomer(CustomerMaster customer);

	public CustomerMaster checkCustomer(String sql);

	Merchant_Payment_keys updateMerchantKeys(Merchant_Payment_keys keys);

	MerchantCustomerMaster saveRegisterCustomerUpdate(MerchantCustomerMaster cust);

	public boolean saveTaxInvoice(TaxInvoice tax);

	boolean saveExpence(ExpenceMaster em);

	boolean saveIncome(IncomeMaster im);

	boolean saveEXCategory(ExpenseCategories ec);

	public MerchantServiceDetailMaster getServiceData(long merchant_service_id);

	public Interaction insertInteraction(Interaction i);

	
	
	

	
	
}
