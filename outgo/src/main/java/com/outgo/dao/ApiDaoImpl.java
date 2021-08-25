package com.outgo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Settings;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.google.gson.Gson;
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
import com.outgo.bean.SMSMaster;
import com.outgo.bean.ServiceMaster;
import com.outgo.bean.TaxInvoice;
import com.outgo.bean.TransactionMaster;
import com.outgo.bean.User;


@Repository
public class ApiDaoImpl implements ApiDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Object> list(String sql) {
		Session session = null;
		 List<Object> l = new ArrayList<Object>(); 
		try {
			session = sessionFactory.openSession();
				SQLQuery query = session.createSQLQuery(sql);
			 query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<Object> list = query.list();
			System.out.println("size "+ list.size());
			return list;
		}catch(SQLGrammarException e){ 
			
			l.add(e);
			return l; 
		} catch (HibernateException e) {
			System.out.println(e);
			l.add(e);
			return l; 
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public com.outgo.bean.OtherCustomerRegisterMaster OtherCustomerRegisterMaster(String sql) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println("Coming list ");
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity( com.outgo.bean.OtherCustomerRegisterMaster.class);
			
			List<com.outgo.bean.OtherCustomerRegisterMaster> list = query.list();
			com.outgo.bean.OtherCustomerRegisterMaster a = list.get(0);
			return a;
		} catch (HibernateException e) {
			return null;
		}catch(IndexOutOfBoundsException a){return null;} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public com.outgo.bean.OtherCustomerRegisterMaster saveNonRegisterCustomer(
			com.outgo.bean.OtherCustomerRegisterMaster ocrm) {
		Session session= null;
		System.out.println("Coming ");
		try {
			session=sessionFactory.openSession();
			session.save(ocrm);
			return ocrm;
		} catch (HibernateException e) {
			e.printStackTrace();
			return ocrm;
		}finally{
			if(session != null)
				session.close();
		}
	}

	@Override
	public TransactionMaster saveCustomerTransaction(TransactionMaster tx) {
		Session session= null;
		Transaction tx1 = null;
		 
		System.out.println("Coming saveCustomerTransaction....");
		try {
			session=sessionFactory.openSession();
			
			tx1 = session.beginTransaction();
			session.saveOrUpdate(tx);
			tx1.commit();

			return tx;
					} catch (HibernateException e) {
			e.printStackTrace();
			return tx;
		}finally{
			if(session != null)
				session.close();
		}
	}

	@Override
	public String getService(long sid) {
		Session session = sessionFactory.openSession();
		  String sql="select service_name from Service_Master where service_id="+sid;
		  SQLQuery query=session.createSQLQuery(sql);
		  String sname = (String)query.uniqueResult();
		   session.close();
		  return sname;
	}

	@Override
	public TransactionMaster getTransaction(String txId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String sql = "select *  FROM Transaction_Master where transaction_order_id='"+txId+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(TransactionMaster.class);
			
			List<TransactionMaster> list = query.list();
			TransactionMaster a = list.get(0);
			System.out.println("In dao--->"+new Gson().toJson(a));
			return a;
		} catch (HibernateException e) {
			return null;
		} finally {
			if (session != null)
				session.close();
		}
		
	}

	@Override
	public MessagesMaster insertMassages(MessagesMaster msg) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(msg);
			tx.commit();
			return msg;
		} catch (HibernateException e) {
			e.printStackTrace();
			return msg;
		}finally{
			if(session != null)
				session.close();
		}
	}

	@Override
	public com.outgo.bean.Settings getSetting(String sql) {
		Session session = null;
		session = sessionFactory.openSession();
		try {
			SQLQuery query = session.createSQLQuery(sql); 
			query.addEntity(com.outgo.bean.Settings.class);
			com.outgo.bean.Settings list = (com.outgo.bean.Settings) query.list().get(0);
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		} 

	}

	@Override
	public SMSMaster getSms(String sql) {
		Session session = null;
		session = sessionFactory.openSession();
		try {
			SQLQuery query = session.createSQLQuery(sql); 
			query.addEntity(SMSMaster.class);
			SMSMaster list = (SMSMaster) query.list().get(0);
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<com.outgo.bean.OtherCustomerRegisterMaster> getNonRegisterCustomerr(String sql) {
		Session session = null;
		session = sessionFactory.openSession();
		try {
			SQLQuery query = session.createSQLQuery(sql); 
			query.addEntity(com.outgo.bean.OtherCustomerRegisterMaster.class);
			List<com.outgo.bean.OtherCustomerRegisterMaster> list = query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<MerchantCustomerMaster> searchUser(String string) {
		Session session = null;
		session = sessionFactory.openSession();
		try {
			SQLQuery query = session.createSQLQuery(string); 
			query.addEntity(MerchantCustomerMaster.class);
			List<MerchantCustomerMaster> list =  query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public User getUserdetail(String sql) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(User.class);
			
			List<User> list = query.list();
			User a = list.get(0);
			System.out.println("In dao--->"+new Gson().toJson(a));
			return a;
		} catch (HibernateException e) {
			System.out.println(e);
			return null;
		
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e);
			return null;
		
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean update(String sql) {
		Transaction tx=null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			int i=   query.executeUpdate();
			if(i>0)	{
				tx.commit();
			return true;
			}else
				return false;
		} catch (HibernateException e) {
			System.out.println(e);
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public TransactionMaster payment(String sql) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(TransactionMaster.class);
			
			List<TransactionMaster> list = query.list();
			
			TransactionMaster a = list.get(0);
			System.out.println("In dao--->"+new Gson().toJson(a));
			return a;
		} catch (HibernateException e) {
			System.out.println(e);
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public ALL info(String sql) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			List resultWithAliasedBean =session.createSQLQuery(sql)
				      .setResultTransformer( Transformers.aliasToBean(ALL.class))
				        .list();
				    return (ALL) resultWithAliasedBean.get(0);
		} catch (HibernateException e) {
			System.out.println(e);
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<String> getstrList(String sql) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery(sql); 
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<String> list = query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public MerchantCustomerMaster insertTransaction(MerchantCustomerMaster mm) {
		Session session= null;
		Transaction tx1 = null;
		 
		System.out.println("Coming saveCustomerTransaction....");
		try {
			session=sessionFactory.openSession();
			
			tx1 = session.beginTransaction();
			session.saveOrUpdate(mm);
			tx1.commit();

			return mm;
					} catch (HibernateException e) {
			e.printStackTrace();
			return mm;
		}finally{
			if(session != null)
				session.close();
		}
	}

	
	@Override
	public Merchant_Payment_keys getMerchantKey(String sql) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Merchant_Payment_keys.class);
			
			List<Merchant_Payment_keys> list = query.list();
			
			Merchant_Payment_keys a = list.get(0);
			System.out.println("In dao--->"+new Gson().toJson(a));
			return a;
		} catch (HibernateException e) {
			System.out.println(e);
			return null;
		}  catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			return null;
		}finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public ALL getData(String sql) {
		Session session = sessionFactory.openSession();
		try {
			List resultWithAliasedBean =session.createSQLQuery(sql)
				      .setResultTransformer( Transformers.aliasToBean(ALL.class))
				        .list();
				    return (ALL) resultWithAliasedBean.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}catch (IndexOutOfBoundsException e) {
			System.out.println("outof Bound");//insertion of Invoice Default
				
			return null;
		} 
	}
	
	@Override
	public MerchantCustomerMaster searchUserMerchant(String sql) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println("Coming list ");
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(MerchantCustomerMaster.class);
			List<MerchantCustomerMaster> list = query.list();
			MerchantCustomerMaster a = list.get(0);			
			return a;
		} catch (HibernateException e) {
			return null;
		}catch(IndexOutOfBoundsException a){return null;}catch (NullPointerException e) {
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	@Override
	public MerchantCustomerMaster saveRegisterCustomer(MerchantCustomerMaster cust) {
		Session session= null;
		System.out.println("Coming ");
		try {
			session=sessionFactory.openSession();
			session.save(cust);
			return cust;
		} catch (HibernateException e) {
			e.printStackTrace();
			return cust;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	@Override
	public OTP_Verifay insertOTP(OTP_Verifay oTP) {
		Session session= null;
		System.out.println("Coming  OTP"+oTP.isStatus());
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(oTP);
			tx.commit();
			return oTP;
		} catch (HibernateException e) {
			e.printStackTrace();
			return oTP;
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	public OTP_Verifay validateOTP(String otp, String mobileNo, long id) {
		Session session= null;
		session=sessionFactory.openSession();
		Criteria crit =  session.createCriteria(OTP_Verifay.class);
		crit.add(Restrictions.eq("mobileNo", mobileNo)).add(Restrictions.eq("OTP",otp)).add(Restrictions.eq("id",id));
		
		return (OTP_Verifay) crit.uniqueResult();
	}
	
	
	
	
@Override
public User insertContact(User u) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
		return u;
	} catch (HibernateException e) {
		e.printStackTrace();
		return u;
	}finally{
		if(session != null)
			session.close();
	}
}

@Override
public Expenses insertexpenses(Expenses exp) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(exp);
		tx.commit();
		return exp;
	} catch (HibernateException e) {
		e.printStackTrace();
		return exp;
	}finally{
		if(session != null)
			session.close();
	}
}

	
	

@Override
public OTP_Verifay validateOTP(String otp, String mobileNo, long id, String new_password) {
	Session session = null;
	Transaction tx = null;
	
	session=sessionFactory.openSession();
		Criteria crit =  session.createCriteria(OTP_Verifay.class);
		crit.add(Restrictions.eq("mobileNo", mobileNo)).add(Restrictions.eq("OTP",otp)).add(Restrictions.eq("id",id));
		
		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.eq("mobileNo",mobileNo)).add(Restrictions.eq("OTP",otp));
		//or.add(Restrictions.eq("id",Long.parseLong(id)));
		crit.add(or);
		return (OTP_Verifay) crit.uniqueResult();
		}
		//======================User Actions---------------------------

@Override
public boolean saveOutGoCustomer(CustomerMaster customer) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}finally{
		if(session != null)
			session.close();
	}
}

@Override
public CustomerMaster checkCustomer(String sql) {
	Session session = null;
	try {
		session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity( com.outgo.bean.CustomerMaster.class);
		
		List<com.outgo.bean.CustomerMaster> list = query.list();
		com.outgo.bean.CustomerMaster a = list.get(0);
		return a;
	} catch (HibernateException e) {
		return null;
	}catch(IndexOutOfBoundsException a){return null;} finally {
		if (session != null)
			session.close();
	}
}

@Override
public Merchant_Payment_keys updateMerchantKeys(Merchant_Payment_keys keys) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(keys);
		tx.commit();
		return keys;
	} catch (HibernateException e) {
		e.printStackTrace();
		return keys;
	}finally{
		if(session != null)
			session.close();
	}
}

@Override
public MerchantCustomerMaster saveRegisterCustomerUpdate(MerchantCustomerMaster cust) {
	Session session= null;
	System.out.println("Update save ");
	try {
		session=sessionFactory.openSession();
		session.saveOrUpdate(cust);
		return cust;
	} catch (HibernateException e) {
		e.printStackTrace();
		return cust;
	}finally{
		if(session != null)
			session.close();
	}
}

@Override
public boolean saveTaxInvoice(TaxInvoice tax) {
	
	Session session= null;
	Transaction tx=null;
	try {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(tax);
		tx.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}finally{
		if(session != null)
			session.close();
	}	
	
}

@Override
public boolean saveExpence(ExpenceMaster em) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(em);
		tx.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}finally{
		if(session != null)
			session.close();
	}
}

@Override
public boolean saveIncome(IncomeMaster im) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(im);
		tx.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}finally{
		if(session != null)
			session.close();
	}
}

@Override
public boolean saveEXCategory(ExpenseCategories ec) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(ec);
		tx.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}finally{
		if(session != null)
			session.close();
	}
}

@Override
public MerchantServiceDetailMaster getServiceData(long merchant_service_id) {
	Session session= null;
	session=sessionFactory.openSession();
	Criteria crit =  session.createCriteria(MerchantServiceDetailMaster.class);
	crit.add(Restrictions.eq("merchant_service_id", merchant_service_id));
	
	return (MerchantServiceDetailMaster) crit.uniqueResult();
}

@Override
public Interaction insertInteraction(Interaction i) {
	Session session = null;
	Transaction tx = null;
	try {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(i);
		tx.commit();
		return i;
	} catch (HibernateException e) {
		e.printStackTrace();
		return i;
	}finally{
		if(session != null)
			session.close();
	}
}


		
		
	
	
}
