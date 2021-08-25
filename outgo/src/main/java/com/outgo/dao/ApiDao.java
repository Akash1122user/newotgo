package com.outgo.dao;

import java.util.List;

import org.hibernate.cfg.Settings;
import org.springframework.stereotype.Repository;

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


public interface ApiDao {

	List<Object> list(String sql);

	OtherCustomerRegisterMaster OtherCustomerRegisterMaster(String sql);

	OtherCustomerRegisterMaster saveNonRegisterCustomer(OtherCustomerRegisterMaster ocrm);

	TransactionMaster saveCustomerTransaction(TransactionMaster tx);

	String getService(long sid);

	TransactionMaster getTransaction(String txId);

	MessagesMaster insertMassages(MessagesMaster msg);

	com.outgo.bean.Settings getSetting(String string);

	SMSMaster getSms(String string);

	List<OtherCustomerRegisterMaster> getNonRegisterCustomerr(String string);

	List<MerchantCustomerMaster> searchUser(String string);

	User getUserdetail(String mobileNo);

	boolean update(String sql);

	TransactionMaster payment(String sql);

	ALL info(String sql);

	List<String> getstrList(String string);

	MerchantCustomerMaster insertTransaction(MerchantCustomerMaster mm);

	ALL getData(String sql);

	Merchant_Payment_keys getMerchantKey(String sql);

	MerchantCustomerMaster searchUserMerchant(String sql);

	MerchantCustomerMaster saveRegisterCustomer(MerchantCustomerMaster cust);

	OTP_Verifay insertOTP(OTP_Verifay oTP);

	OTP_Verifay validateOTP(String otp, String merchant_customer_mobile, long id);

	User insertContact(User u);

	Expenses insertexpenses(Expenses exp);

	OTP_Verifay validateOTP(String otp, String mobileNo, long id, String new_password);
	// User Actions	

	boolean saveOutGoCustomer(CustomerMaster customer);

	CustomerMaster checkCustomer(String sql);

	Merchant_Payment_keys updateMerchantKeys(Merchant_Payment_keys keys);

	MerchantCustomerMaster saveRegisterCustomerUpdate(MerchantCustomerMaster cust);

	boolean saveTaxInvoice(TaxInvoice tax);

	boolean saveExpence(ExpenceMaster em);

	boolean saveIncome(IncomeMaster im);

	boolean saveEXCategory(ExpenseCategories ec);

	MerchantServiceDetailMaster getServiceData(long merchant_service_id);

	Interaction insertInteraction(Interaction i);


	

	


	
	
}
