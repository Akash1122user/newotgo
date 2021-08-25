package com.outgo.services;

import java.util.List;

import org.hibernate.cfg.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outgo.bean.TaxInvoice;
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
import com.outgo.bean.TransactionMaster;
import com.outgo.bean.User;
import com.outgo.dao.ApiDao;

@Service
public class ApiServicesImpl implements ApiServices{
	@Autowired
	public ApiDao apidao;

	@Override
	public List<Object> list(String sql) {
		// TODO Auto-generated method stub
		return apidao.list(sql);
	}

	@Override
	public OtherCustomerRegisterMaster getNonRegisterCustomer(String sql) {
		// TODO Auto-generated method stub
		return apidao.OtherCustomerRegisterMaster(sql);
	}

	@Override
	public OtherCustomerRegisterMaster saveNonRegisterCustomer(OtherCustomerRegisterMaster ocrm) {
		// TODO Auto-generated method stub
		return apidao.saveNonRegisterCustomer(ocrm);
	}

	@Override
	public TransactionMaster saveCustomerTransaction(TransactionMaster tx) {
		// TODO Auto-generated method stub
		return apidao.saveCustomerTransaction(tx);
	}

	@Override
	public String getService(long sid) {
		return apidao.getService(sid);
	}

	@Override
	public TransactionMaster getTransaction(String txId) {
		return apidao.getTransaction(txId);
	}

	@Override
	public MessagesMaster insertMassages(MessagesMaster msg) {
		return apidao.insertMassages(msg);
	}

	@Override
	public com.outgo.bean.Settings getSetting(String string) {
		return apidao.getSetting(string);
	}

	@Override
	public SMSMaster getSms(String string) {
		return apidao.getSms(string);
	}

	@Override
	public void insertSMS(SMSMaster sms) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OtherCustomerRegisterMaster> getNonRegisterCustomerr(String string) {
		return apidao.getNonRegisterCustomerr(string);
	}

	@Override
	public List<MerchantCustomerMaster> searchUser(String string) {
		return apidao.searchUser(string);

	}

	@Override
	public User getUserdetail(String mobileNo) {
		// TODO Auto-generated method stub
		return apidao.getUserdetail(mobileNo);
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		return apidao.update(sql);
	}

	@Override
	public TransactionMaster payment(String sql) {
		// TODO Auto-generated method stub
		return  apidao.payment(sql);
	}

	@Override
	public ALL info(String sql) {
		// TODO Auto-generated method stub
		return apidao.info(sql);
	}

	@Override
	public List<String> getstrList(String string) {
		// TODO Auto-generated method stub
		return apidao.getstrList(string);
	}

	@Override
	public MerchantCustomerMaster insertTransaction(MerchantCustomerMaster mm) {
		// TODO Auto-generated method stub
		return apidao.insertTransaction(mm);
	}

	@Override
	public Merchant_Payment_keys getMerchantKey(String sql) {
		// TODO Auto-generated method stub
		return apidao.getMerchantKey(sql);
	}

	@Override
	public ALL getData(String sql) {
		// TODO Auto-generated method stub
		return apidao.getData(sql);
	}

	@Override
	public MerchantCustomerMaster searchUserMerchant(String sql) {
		// TODO Auto-generated method stub
		return apidao.searchUserMerchant(sql);
	}

	@Override
	public MerchantCustomerMaster saveRegisterCustomer(MerchantCustomerMaster cust) {
		// TODO Auto-generated method stub
		return apidao.saveRegisterCustomer(cust);
	}

	@Override
	public OTP_Verifay insertOTP(OTP_Verifay oTP) {
		// TODO Auto-generated method stub
		return apidao.insertOTP(oTP);
	}

	@Override
	public OTP_Verifay validateOTP(String otp, String merchant_customer_mobile, long id) {
		// TODO Auto-generated method stub
		return apidao.validateOTP(otp,merchant_customer_mobile,id);
	}

	@Override
	public Expenses insertexpenses(Expenses exp) {
		// TODO Auto-generated method stub
		return apidao.insertexpenses(exp);
	}

	@Override
	public OTP_Verifay validateOTP(String otp, String mobileNo, long id, String new_password) {
		// TODO Auto-generated method stub
		return apidao.validateOTP(otp,mobileNo,id,new_password);
	}

	@Override
	public User insertContact(User u) {
		return apidao.insertContact(u);
		// TODO Auto-generated method stub
		
	}
//-------------------user Actions--------------------
//====================UserApp=======
	@Override
	public boolean saveOutGoCustomer(CustomerMaster customer) {
		// TODO Auto-generated method stub
		return apidao.saveOutGoCustomer(customer);
	}

	@Override
	public CustomerMaster checkCustomer(String sql) {
		// TODO Auto-generated method stub
		return apidao.checkCustomer(sql);
	}

	@Override
	public Merchant_Payment_keys updateMerchantKeys(Merchant_Payment_keys keys) {
		// TODO Auto-generated method stub
		return apidao.updateMerchantKeys(keys);
	}

	@Override
	public MerchantCustomerMaster saveRegisterCustomerUpdate(MerchantCustomerMaster cust) {
		// TODO Auto-generated method stub
		return apidao.saveRegisterCustomerUpdate(cust);
	}

	@Override
	public boolean saveTaxInvoice(TaxInvoice tax) {
		// TODO Auto-generated method stub
		return apidao.saveTaxInvoice(tax);
	}

	@Override
	public boolean saveExpence(ExpenceMaster em) {
		// TODO Auto-generated method stub
		return apidao.saveExpence(em);
	}

	@Override
	public boolean saveIncome(IncomeMaster im) {
		// TODO Auto-generated method stub
		return apidao.saveIncome(im);
	}

	@Override
	public boolean saveEXCategory(ExpenseCategories ec) {
		// TODO Auto-generated method stub
		return apidao.saveEXCategory(ec);
	}

	@Override
	public MerchantServiceDetailMaster getServiceData(long merchant_service_id) {
		// TODO Auto-generated method stub
		return apidao.getServiceData(merchant_service_id);
	}

	@Override
	public Interaction insertInteraction(Interaction i) {
		// TODO Auto-generated method stub
		return apidao.insertInteraction(i);
	}
	

	
	
	
	

}
