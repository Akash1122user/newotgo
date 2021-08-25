package com.outgo.messages;

public class SQLString {
	
	public final static String  SUCCESS=" p.transaction_status='SUCCESS' ";
	public final static  String  CANCEL=" p.transaction_status='CANCEL' ";
	public final static  String  FAIL=" p.transaction_status='FAIL' ";
	public final static  String  STATUS=" p.transaction_status='<STATUS>' ";
	public final static  String TYPE=" p.transaction_type='<TYPE>' ";
	public final static  String SERVICE=" p.merchant_service_id='<SERVICE>'";
	public final static  String MERCHANT=" p.merchant_id='<MERCHANT>'";
	public final static  String MONTH=" MONTH(p.transaction_update_date)='<MONTH>' ";
	public final static  String YEAR=" YEAR(p.transaction_update_date)='<YEAR>' ";
	public final static  String DAY=" DATE(p.transaction_update_date)='<DAY>' ";
	public final static  String AND=" AND ";
	


	public final static  String OR=" OR ";
	public final static  String WHERE=" WHERE ";
	
	public final static  String BETWEEN=" DATE(p.transaction_update_date) BETWEEN '<TODATE>' AND '<FROMDATE>' ";
	
	
	public final static String Name="CASE p.ref_table\n" + 
			"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((p.ref_id=n.other_cust_id and p.ref_table='Non_Register_Customer') ))\n" + 
			"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((p.ref_id=m.merchant_customer_id and p.ref_table='Merchant_Customer_Master') ))\n" + 
			"  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((p.ref_id=c.customer_id and p.ref_table='Customer_Master') ))\n" + 
			"  ELSE 'Unknow' \n" + 
			"END as name \n" + 
			"";

	
	public final static String MSG_SERVICE=" msg.merchant_service_id='<SERVICE>'";
	public final static String MSG_Type=" msg.type='<TYPE>'";
	public final static String MSG_Status=" msg.msg_status='<STATUS>'";
	public final static  String MSG_BETWEEN=" DATE(msg.msg_create_date) BETWEEN '<TODATE>' AND '<FROMDATE>' ";
	public final static  String MSG_MERCHANT=" msg.merchant_id='<MERCHANT>'";
	
	public final static String MSG_NAME="CASE msg.table_ref\n" + 
			"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_name from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n" + 
			"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_name from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n" + 
			"  WHEN 'Customer_Master' THEN (select c.customer_name from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n" + 
			"  ELSE 'Unknow' END as name ";

	public final static String MSG_Mobile="CASE msg.table_ref\n" + 
			"  WHEN 'Non_Register_Customer' THEN (select n.other_cust_mobile from Non_Register_Customer n where  ((msg.ref_id=n.other_cust_id and msg.table_ref='Non_Register_Customer') ))\n" + 
			"  WHEN 'Merchant_Customer_Master' THEN (select m.merchant_customer_mobile from Merchant_Customer_Master m where  ((msg.ref_id=m.merchant_customer_id and msg.table_ref='Merchant_Customer_Master') ))\n" + 
			"  WHEN 'Customer_Master' THEN (select c.customer_mobile from Customer_Master c where  ((msg.ref_id=c.customer_id and msg.table_ref='Customer_Master') ))\n" + 
			"  ELSE 'Unknow' END as mobile ";

	public final static String empolyee=" CASE msg.employeeId\r\n" + 
			"  WHEN 0 THEN  'Un-Assigned'\r\n" + 
			"  ELSE (select cl.employeeName from Contact_login cl where cl.id=msg.employeeId ) END as Employee \r\n" + 
			"";

	
	
	public final static String HomeCount="select (select sum(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' and t.transaction_type='Online') online,\n" + 
			"       (select sum(t.transaction_amount) from Transaction_Master t where t.merchant_id=[MERCHANTID] and t.transaction_status='SUCCESS' and t.transaction_type='Offline') offline,\n" + 
			"       (select  COUNT(m.merchant_customer_id) from Merchant_Customer_Master m where m.`status`=1 and m.merchant_id=[MERCHANTID] ) as activecust,\n" + 
			"        (select  COUNT(mm.merchant_customer_id) from Merchant_Customer_Master mm where mm.`status`=0 and mm.merchant_id=[MERCHANTID] ) as deactivecust,\n" + 
			"         (select COUNT(mmm.msgId ) from Messages_Master mmm where mmm.merchant_id=[MERCHANTID] and mmm.msg_status='Open') as openmsg,\n" + 
			"         (select COUNT(mmmm.msgId ) from Messages_Master mmmm where mmmm.merchant_id=[MERCHANTID] and mmmm.msg_status='Closed') as closemsg";
	

	public final static String countmsg="	select (select count(m1.msgId)  from Messages_Master m1 where  m1.`type`='Enquiry' and m1.merchant_id=[ID] and [date] )      as Enquiry,"
			+ "		 (select count(m1.msgId)  from Messages_Master m1 where  m1.`type`='Complaint' and m1.merchant_id=[ID] and [date] )      as Complaint,\n" + 
		"			 			 (select count(m1.msgId)  from Messages_Master m1 where  m1.msg_status='Open' and m1.merchant_id=[ID] and [date] )      as Openmsg,\n" + 
		"			 			 			 			 (select count(m1.msgId)  from Messages_Master m1 where  m1.msg_status='Closed' and m1.merchant_id=[ID] and [date] )      as closemsg";


	public final static String countmsg1="	select (select count(msg.msgId)  from Messages_Master msg where  msg.`type`='Enquiry' and [sql] )      as Enquiry,"
			+ "		 (select count(msg.msgId)  from Messages_Master msg where  msg.`type`='Complaint' and [sql] )      as Complaint,\n" + 
		"			 			 (select count(msg.msgId)  from Messages_Master msg where  msg.msg_status='Open' and [sql] )      as Openmsg,\n" + 
		"			 			 			 			 (select count(msg.msgId)  from Messages_Master msg where  msg.msg_status='Closed' and [sql] )      as closemsg";

}
