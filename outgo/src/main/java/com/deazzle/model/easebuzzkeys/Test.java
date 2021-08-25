package com.deazzle.model.easebuzzkeys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.net.SyslogAppender;

import com.deazzle.model.login.LoginResponse;
import com.deazzle.model.login.Registration;
import com.google.gson.Gson;

public class Test {

	
	static String json="{\n" + 
			"    \"ResultData\": {\n" + 
			"        \"me\": {\n" + 
			"            \"phone_number_dq\": [\n" + 
			"                1\n" + 
			"            ],\n" + 
			"            \"selectedLanguage\": \"en\",\n" + 
			"            \"name_dq\": [\n" + 
			"                -1\n" + 
			"            ],\n" + 
			"            \"created_date_time\": 1534845657,\n" + 
			"            \"image\": \"/person/Profile -Male 02.png\",\n" + 
			"            \"ClientId\": \"hkOKS9oEeuzSLkCp6ijwFW889nsa\",\n" + 
			"            \"last_updated_date_time\": 1535088094,\n" + 
			"            \"employee_at\": [\n" + 
			"                \"bf4c5510-a531-11e8-92d6-fa163e76315a\"\n" + 
			"            ],\n" + 
			"            \"privacy_level\": 1,\n" + 
			"            \"password\": \"b1YyWGQ3YXZBNWx4akJwOTQ1MjI2YmJjMjk5ZTQ2YTdlNjIxOTU0ZjI1YWE2NzNj\",\n" + 
			"            \"WorkflowInfo\": {\n" + 
			"                \"collectmoney\": {\n" + 
			"                    \"create\": {\n" + 
			"                        \"WorkflowMapping\": [],\n" + 
			"                        \"primaryOperation\": true,\n" + 
			"                        \"Description\": \"COLLECT_MONEY_DETAIL\",\n" + 
			"                        \"subscribe\": true,\n" + 
			"                        \"MappingErrorMsg\": \"\",\n" + 
			"                        \"UIcaption\": \"COLLECT_MONEY\",\n" + 
			"                        \"visibility\": {\n" + 
			"                            \"associatedType\": [],\n" + 
			"                            \"status\": []\n" + 
			"                        },\n" + 
			"                        \"order\": 1,\n" + 
			"                        \"workflowname\": \"DeAz_Collect_Money:22:687354\",\n" + 
			"                        \"UIDescription\": \"COLLECT_MONEY_DESCRIPTION\",\n" + 
			"                        \"key\": \"collectmoney_create\",\n" + 
			"                        \"UIMetaData\": {\n" + 
			"                            \"custom_fields\": {\n" + 
			"                                \"comment\": {\n" + 
			"                                    \"caption\": \"PAYMENT_COMMENT\",\n" + 
			"                                    \"order\": 4\n" + 
			"                                },\n" + 
			"                                \"phone_number\": {\n" + 
			"                                    \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                                    \"order\": 2\n" + 
			"                                },\n" + 
			"                                \"amount\": {\n" + 
			"                                    \"caption\": \"AMOUNT\",\n" + 
			"                                    \"order\": 3\n" + 
			"                                },\n" + 
			"                                \"name\": {\n" + 
			"                                    \"caption\": \"CUSTOMER_NAME\",\n" + 
			"                                    \"order\": 1\n" + 
			"                                }\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"UIImage\": \"/business/default_biz.png\",\n" + 
			"                        \"UIbutton\": \"icon_collect_norm\",\n" + 
			"                        \"invokedBy\": \"person\"\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"sendmoney\": {\n" + 
			"                    \"create\": {\n" + 
			"                        \"WorkflowMapping\": [],\n" + 
			"                        \"primaryOperation\": true,\n" + 
			"                        \"Description\": \"SEND_MONEY_DETAIL\",\n" + 
			"                        \"subscribe\": true,\n" + 
			"                        \"MappingErrorMsg\": \"\",\n" + 
			"                        \"UIcaption\": \"SEND_MONEY\",\n" + 
			"                        \"visibility\": {\n" + 
			"                            \"associatedType\": [],\n" + 
			"                            \"status\": []\n" + 
			"                        },\n" + 
			"                        \"order\": 1,\n" + 
			"                        \"workflowname\": \"DeAz_Send_Money:22:687314\",\n" + 
			"                        \"UIDescription\": \"SEND_MONEY_DESCRIPTION\",\n" + 
			"                        \"key\": \"sendmoney_create\",\n" + 
			"                        \"UIMetaData\": {\n" + 
			"                            \"custom_fields\": {\n" + 
			"                                \"phone_number\": {\n" + 
			"                                    \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                                    \"order\": 2\n" + 
			"                                },\n" + 
			"                                \"amount_paid\": {\n" + 
			"                                    \"caption\": \"AMOUNT\",\n" + 
			"                                    \"order\": 3\n" + 
			"                                },\n" + 
			"                                \"name\": {\n" + 
			"                                    \"caption\": \"CUSTOMER_NAME\",\n" + 
			"                                    \"order\": 1\n" + 
			"                                },\n" + 
			"                                \"payment_description\": {\n" + 
			"                                    \"caption\": \"DESCRIPTION\",\n" + 
			"                                    \"order\": 4\n" + 
			"                                }\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"UIImage\": \"/business/default_biz.png\",\n" + 
			"                        \"UIbutton\": \"icon_pay_norm\",\n" + 
			"                        \"invokedBy\": \"person\"\n" + 
			"                    }\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"notificationInfo\": {\n" + 
			"                \"PaymentNotReceivedReceiver\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"Payment Rejected\"\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"RejectPaymentPP\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"Payment Rejected\"\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"ReceivedPaymentPP\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"Payment Received\"\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"SuccessfulPaymentPP\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"PAYMENT_SUCCESSFUL\"\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"PaymentReceivedSender\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"Payment successful\"\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"CollectMoneyConfirmPaymentPP\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"CONFIRM_PAYMENT_RECEIVED\"\n" + 
			"                    },\n" + 
			"                    \"custom_fields\": {\n" + 
			"                        \"payer_phone_number\": {\n" + 
			"                            \"caption\": \"COMMON_PHONE\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"payer_name\": {\n" + 
			"                            \"caption\": \"COMMON_NAME\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"amount\": {\n" + 
			"                            \"caption\": \"AMOUNT\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"confirm_payment\": {\n" + 
			"                            \"caption\": \"CONFIRM\",\n" + 
			"                            \"type\": \"singleselect\"\n" + 
			"                        },\n" + 
			"                        \"comment\": {\n" + 
			"                            \"caption\": \"PAYMENT_COMMENT\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        }\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"PaymentRequestPP\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"PAYMENT_REQUESTED\"\n" + 
			"                    },\n" + 
			"                    \"custom_fields\": {\n" + 
			"                        \"comment\": {\n" + 
			"                            \"caption\": \"PAYMENT_COMMENT\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"payment_date\": {\n" + 
			"                            \"caption\": \"DATE\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"amount_paid\": {\n" + 
			"                            \"caption\": \"AMOUNT\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        }\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"ConfirmPaymentPP\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"Payment Received\"\n" + 
			"                    },\n" + 
			"                    \"custom_fields\": {\n" + 
			"                        \"comment\": {\n" + 
			"                            \"caption\": \"COMMENT\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"receiverphonenumber\": {\n" + 
			"                            \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"amount\": {\n" + 
			"                            \"caption\": \"AMOUNT\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"receivername\": {\n" + 
			"                            \"caption\": \"NAME\",\n" + 
			"                            \"type\": \"label\"\n" + 
			"                        },\n" + 
			"                        \"confirm\": {\n" + 
			"                            \"caption\": \"Payment Received\",\n" + 
			"                            \"type\": \"singleselect\"\n" + 
			"                        }\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"UnsuccessfulPaymentPP\": {\n" + 
			"                    \"custom_UI_element\": {\n" + 
			"                        \"UIPage_title\": \"PAYMENT_UNSUCCESSFUL\"\n" + 
			"                    }\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"privacy_type\": 2,\n" + 
			"            \"object_id\": \"19787ab8-a529-11e8-92d6-fa163e76315a\",\n" + 
			"            \"email\": [\n" + 
			"                \"yogeshchaurse1990@gmail.com\"\n" + 
			"            ],\n" + 
			"            \"phone_number\": [\n" + 
			"                8999356617\n" + 
			"            ],\n" + 
			"            \"l_name\": \"Chaurse\",\n" + 
			"            \"f_name\": \"Yogesh\",\n" + 
			"            \"is_active\": true,\n" + 
			"            \"android_reg_id\": \"cO53pq43FjQ:APA91bHj-z7wxdd0b-BrsA3XWvHBKYv5NesoNOQuI7jjT6Sva_PacJBUOm4wkvgUO_V417H_Kcwy7sBShNEAOp_GkAgUFYiVvft512_1KjWbNeW2J3JLNYupy0Waf6vQuNdQJDPloA4JRjMANaBobdj6rl4p3nT60g\",\n" + 
			"            \"passcode_expirytime\": 1535174494.73,\n" + 
			"            \"http_referrer\": \"deazzle\",\n" + 
			"            \"name\": [\n" + 
			"                \"Yogesh\"\n" + 
			"            ],\n" + 
			"            \"gender\": \"male\",\n" + 
			"            \"username\": \"8999356617\",\n" + 
			"            \"passcode\": \"5126\",\n" + 
			"            \"email_dq\": [\n" + 
			"                -1\n" + 
			"            ]\n" + 
			"        },\n" + 
			"        \"business_list\": [\n" + 
			"            \"bf4c5510-a531-11e8-92d6-fa163e76315a\"\n" + 
			"        ],\n" + 
			"        \"profile\": [\n" + 
			"            {\n" + 
			"                \"phone_number_dq\": [\n" + 
			"                    -1\n" + 
			"                ],\n" + 
			"                \"resource_list\": {},\n" + 
			"                \"selectedLanguage\": \"en\",\n" + 
			"                \"name_dq\": [\n" + 
			"                    -1\n" + 
			"                ],\n" + 
			"                \"created_date_time\": 1534849371,\n" + 
			"                \"service_name\": [\n" + 
			"                    \"paper\"\n" + 
			"                ],\n" + 
			"                \"image\": \"/business/default_biz.png\",\n" + 
			"                \"ClientId\": \"hkOKS9oEeuzSLkCp6ijwFW889nsa\",\n" + 
			"                \"referral_code\": \"\",\n" + 
			"                \"last_updated_date_time\": 1534849373,\n" + 
			"                \"merchantUrl\": \"yy\",\n" + 
			"                \"category\": [\n" + 
			"                    \"Book Store\"\n" + 
			"                ],\n" + 
			"                \"ratings\": 0,\n" + 
			"                \"WorkflowInfo\": {\n" + 
			"                    \"directreceipt\": {\n" + 
			"                        \"create\": {\n" + 
			"                            \"WorkflowMapping\": [],\n" + 
			"                            \"primaryOperation\": true,\n" + 
			"                            \"invokedBy\": \"business\",\n" + 
			"                            \"group\": null,\n" + 
			"                            \"Description\": \"DIRECT_RECEIPT_DESCRIPTION_DETAIL\",\n" + 
			"                            \"UIDescription\": \"DIRECT_RECEIPT_DESCRIPTION\",\n" + 
			"                            \"MappingErrorMsg\": \"\",\n" + 
			"                            \"UIcaption\": \"DIRECT_RECEIPT\",\n" + 
			"                            \"visibility\": {\n" + 
			"                                \"associatedType\": [],\n" + 
			"                                \"status\": []\n" + 
			"                            },\n" + 
			"                            \"key\": \"directreceipt_create\",\n" + 
			"                            \"subscribe\": true,\n" + 
			"                            \"workflowname\": \"Deaz_Direct_Receipt:42:687334\",\n" + 
			"                            \"UIMetaData\": {\n" + 
			"                                \"custom_UI_element\": null,\n" + 
			"                                \"custom_fields\": {\n" + 
			"                                    \"payment_date\": {\n" + 
			"                                        \"caption\": \"PAYMENT_DATE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 10\n" + 
			"                                    },\n" + 
			"                                    \"receipt_date\": {\n" + 
			"                                        \"caption\": \"SELECT_DATE\",\n" + 
			"                                        \"type\": \"dateonly\",\n" + 
			"                                        \"order\": 6\n" + 
			"                                    },\n" + 
			"                                    \"description\": {\n" + 
			"                                        \"caption\": \"Description\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 8\n" + 
			"                                    },\n" + 
			"                                    \"receipt_id\": {\n" + 
			"                                        \"caption\": \"RECEIPT_ID\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 8\n" + 
			"                                    },\n" + 
			"                                    \"email_id\": {\n" + 
			"                                        \"caption\": \"EMAIL\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 3\n" + 
			"                                    },\n" + 
			"                                    \"service_name\": {\n" + 
			"                                        \"caption\": \"SELECT_SERVICE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 5\n" + 
			"                                    },\n" + 
			"                                    \"bill\": {\n" + 
			"                                        \"caption\": \"Attach Image (only 1)\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 9\n" + 
			"                                    },\n" + 
			"                                    \"customer_phone_number\": {\n" + 
			"                                        \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 1\n" + 
			"                                    },\n" + 
			"                                    \"amount\": {\n" + 
			"                                        \"caption\": \"AMOUNT\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 4\n" + 
			"                                    },\n" + 
			"                                    \"mode\": {\n" + 
			"                                        \"caption\": \"Payment_mode\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 7\n" + 
			"                                    },\n" + 
			"                                    \"customer_name\": {\n" + 
			"                                        \"caption\": \"CUSTOMER_NAME\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 2\n" + 
			"                                    }\n" + 
			"                                }\n" + 
			"                            },\n" + 
			"                            \"OnbehalfUIcaption\": null,\n" + 
			"                            \"UIImage\": \"/business/default_biz.png\",\n" + 
			"                            \"UIbutton\": \"icon_send_receipt\",\n" + 
			"                            \"order\": 1\n" + 
			"                        }\n" + 
			"                    },\n" + 
			"                    \"enquiry\": {\n" + 
			"                        \"create\": {\n" + 
			"                            \"WorkflowMapping\": [],\n" + 
			"                            \"primaryOperation\": true,\n" + 
			"                            \"invokedBy\": \"person\",\n" + 
			"                            \"group\": null,\n" + 
			"                            \"Description\": \"ENQUIRY_DESCRIPTION_DETAIL\",\n" + 
			"                            \"UIDescription\": \"ENQUIRY_DESCRIPTION\",\n" + 
			"                            \"MappingErrorMsg\": \"\",\n" + 
			"                            \"UIcaption\": \"ENQUIRY\",\n" + 
			"                            \"visibility\": {\n" + 
			"                                \"associatedType\": [],\n" + 
			"                                \"status\": []\n" + 
			"                            },\n" + 
			"                            \"key\": \"enquiry_create\",\n" + 
			"                            \"subscribe\": true,\n" + 
			"                            \"workflowname\": \"DeAz_Enquiry:24:490505\",\n" + 
			"                            \"UIMetaData\": {\n" + 
			"                                \"custom_UI_element\": null,\n" + 
			"                                \"custom_fields\": {\n" + 
			"                                    \"enquiry\": {\n" + 
			"                                        \"caption\": \"QUESTION\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 1\n" + 
			"                                    }\n" + 
			"                                }\n" + 
			"                            },\n" + 
			"                            \"OnbehalfUIcaption\": null,\n" + 
			"                            \"UIImage\": \"\",\n" + 
			"                            \"UIbutton\": \"operation-enquiry\",\n" + 
			"                            \"order\": 1\n" + 
			"                        }\n" + 
			"                    },\n" + 
			"                    \"directpayment\": {\n" + 
			"                        \"create\": {\n" + 
			"                            \"WorkflowMapping\": [],\n" + 
			"                            \"primaryOperation\": true,\n" + 
			"                            \"invokedBy\": \"business\",\n" + 
			"                            \"group\": null,\n" + 
			"                            \"Description\": \"DIRECT_PAYMENT_DETAIL\",\n" + 
			"                            \"UIDescription\": \"DIRECT_PAYMENT_DESCRIPTION\",\n" + 
			"                            \"MappingErrorMsg\": \"\",\n" + 
			"                            \"UIcaption\": \"APPT_SEND_ORDER_SUMMARY\",\n" + 
			"                            \"visibility\": {\n" + 
			"                                \"associatedType\": [],\n" + 
			"                                \"status\": []\n" + 
			"                            },\n" + 
			"                            \"key\": \"directpayment_create\",\n" + 
			"                            \"subscribe\": true,\n" + 
			"                            \"workflowname\": \"DeAz_Direct_Payment_Without_Appt:36:687338\",\n" + 
			"                            \"UIMetaData\": {\n" + 
			"                                \"custom_UI_element\": null,\n" + 
			"                                \"custom_fields\": {\n" + 
			"                                    \"description\": {\n" + 
			"                                        \"caption\": \"DESCRIPTION\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 6\n" + 
			"                                    },\n" + 
			"                                    \"email_id\": {\n" + 
			"                                        \"caption\": \"COMMON_EMAIL\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 3\n" + 
			"                                    },\n" + 
			"                                    \"service_name\": {\n" + 
			"                                        \"caption\": \"SELECT_SERVICE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 4\n" + 
			"                                    },\n" + 
			"                                    \"bill\": {\n" + 
			"                                        \"caption\": \"Attach Image (only 1)\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 7\n" + 
			"                                    },\n" + 
			"                                    \"invoice_date\": {\n" + 
			"                                        \"caption\": \"SELECT_DATE\",\n" + 
			"                                        \"type\": \"dateonly\",\n" + 
			"                                        \"order\": 5\n" + 
			"                                    },\n" + 
			"                                    \"customer_phone_number\": {\n" + 
			"                                        \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 1\n" + 
			"                                    },\n" + 
			"                                    \"amount\": {\n" + 
			"                                        \"caption\": \"AMOUNT\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 3\n" + 
			"                                    },\n" + 
			"                                    \"invoice_id\": {\n" + 
			"                                        \"caption\": \"ORDER_SUMMARY_NUMBER\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 7\n" + 
			"                                    },\n" + 
			"                                    \"customer_name\": {\n" + 
			"                                        \"caption\": \"CUSTOMER_NAME\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 2\n" + 
			"                                    }\n" + 
			"                                }\n" + 
			"                            },\n" + 
			"                            \"OnbehalfUIcaption\": null,\n" + 
			"                            \"UIImage\": \"/business/default_biz.png\",\n" + 
			"                            \"UIbutton\": \"operation-send_invoice\",\n" + 
			"                            \"order\": 1\n" + 
			"                        }\n" + 
			"                    },\n" + 
			"                    \"quickpay\": {\n" + 
			"                        \"create\": {\n" + 
			"                            \"WorkflowMapping\": [],\n" + 
			"                            \"primaryOperation\": true,\n" + 
			"                            \"invokedBy\": \"person\",\n" + 
			"                            \"group\": null,\n" + 
			"                            \"Description\": \"QUICKPAY_DESCRIPTION_DETAIL\",\n" + 
			"                            \"UIDescription\": \"QUICKPAY_DESCRIPTION\",\n" + 
			"                            \"MappingErrorMsg\": \"\",\n" + 
			"                            \"UIcaption\": \"QUICK_PAY\",\n" + 
			"                            \"visibility\": {\n" + 
			"                                \"associatedType\": [],\n" + 
			"                                \"status\": []\n" + 
			"                            },\n" + 
			"                            \"key\": \"quickpay_create\",\n" + 
			"                            \"subscribe\": true,\n" + 
			"                            \"workflowname\": \"DeAz_Quick_Pay:5:692833\",\n" + 
			"                            \"UIMetaData\": {\n" + 
			"                                \"custom_UI_element\": null,\n" + 
			"                                \"custom_fields\": {\n" + 
			"                                    \"amount_paid\": {\n" + 
			"                                        \"caption\": \"Amount\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 2\n" + 
			"                                    },\n" + 
			"                                    \"biz_phonenumber\": {\n" + 
			"                                        \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 1\n" + 
			"                                    }\n" + 
			"                                }\n" + 
			"                            },\n" + 
			"                            \"OnbehalfUIcaption\": null,\n" + 
			"                            \"UIImage\": \"\",\n" + 
			"                            \"UIbutton\": \"icon_quickpay_wf\",\n" + 
			"                            \"order\": 1\n" + 
			"                        }\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"WorkflowInfo_1_21\": {},\n" + 
			"                \"WorkflowInfo_1_22\": {\n" + 
			"                    \"directreceipt\": {\n" + 
			"                        \"create\": {\n" + 
			"                            \"WorkflowMapping\": [],\n" + 
			"                            \"primaryOperation\": true,\n" + 
			"                            \"invokedBy\": \"business\",\n" + 
			"                            \"group\": null,\n" + 
			"                            \"Description\": \"DIRECT_RECEIPT_DESCRIPTION_DETAIL\",\n" + 
			"                            \"UIDescription\": \"DIRECT_RECEIPT_DESCRIPTION\",\n" + 
			"                            \"MappingErrorMsg\": \"\",\n" + 
			"                            \"UIcaption\": \"DIRECT_RECEIPT\",\n" + 
			"                            \"visibility\": {\n" + 
			"                                \"associatedType\": [],\n" + 
			"                                \"status\": []\n" + 
			"                            },\n" + 
			"                            \"key\": \"directreceipt_create\",\n" + 
			"                            \"subscribe\": true,\n" + 
			"                            \"workflowname\": \"Deaz_Direct_Receipt_with_Summary:6:813964\",\n" + 
			"                            \"UIMetaData\": {\n" + 
			"                                \"custom_UI_element\": {\n" + 
			"                                    \"UIButton_caption_1\": \"APPT_SEND_RECEIPT\"\n" + 
			"                                },\n" + 
			"                                \"custom_fields\": {\n" + 
			"                                    \"payment_date\": {\n" + 
			"                                        \"caption\": \"PAYMENT_DATE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 10\n" + 
			"                                    },\n" + 
			"                                    \"receipt_date\": {\n" + 
			"                                        \"caption\": \"SELECT_DATE\",\n" + 
			"                                        \"type\": \"dateonly\",\n" + 
			"                                        \"order\": 6\n" + 
			"                                    },\n" + 
			"                                    \"description\": {\n" + 
			"                                        \"caption\": \"Description\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 8\n" + 
			"                                    },\n" + 
			"                                    \"receipt_id\": {\n" + 
			"                                        \"caption\": \"RECEIPT_ID\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 8\n" + 
			"                                    },\n" + 
			"                                    \"email_id\": {\n" + 
			"                                        \"caption\": \"EMAIL\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 3\n" + 
			"                                    },\n" + 
			"                                    \"service_name\": {\n" + 
			"                                        \"caption\": \"SELECT_SERVICE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 5\n" + 
			"                                    },\n" + 
			"                                    \"bill\": {\n" + 
			"                                        \"caption\": \"ATTACH_IMAGE_ONLY_ONE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 9\n" + 
			"                                    },\n" + 
			"                                    \"customer_phone_number\": {\n" + 
			"                                        \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 1\n" + 
			"                                    },\n" + 
			"                                    \"amount\": {\n" + 
			"                                        \"caption\": \"AMOUNT\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 4\n" + 
			"                                    },\n" + 
			"                                    \"mode\": {\n" + 
			"                                        \"caption\": \"Payment_mode\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 7\n" + 
			"                                    },\n" + 
			"                                    \"customer_name\": {\n" + 
			"                                        \"caption\": \"CUSTOMER_NAME\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 2\n" + 
			"                                    }\n" + 
			"                                }\n" + 
			"                            },\n" + 
			"                            \"OnbehalfUIcaption\": null,\n" + 
			"                            \"UIImage\": \"/business/default_biz.png\",\n" + 
			"                            \"UIbutton\": \"icon_send_receipt\",\n" + 
			"                            \"order\": 1\n" + 
			"                        }\n" + 
			"                    },\n" + 
			"                    \"enquiry\": {\n" + 
			"                        \"create\": {\n" + 
			"                            \"WorkflowMapping\": [],\n" + 
			"                            \"primaryOperation\": true,\n" + 
			"                            \"invokedBy\": \"person\",\n" + 
			"                            \"group\": null,\n" + 
			"                            \"Description\": \"ENQUIRY_DESCRIPTION_DETAIL\",\n" + 
			"                            \"UIDescription\": \"ENQUIRY_DESCRIPTION\",\n" + 
			"                            \"MappingErrorMsg\": \"\",\n" + 
			"                            \"UIcaption\": \"ENQUIRY\",\n" + 
			"                            \"visibility\": {\n" + 
			"                                \"associatedType\": [],\n" + 
			"                                \"status\": []\n" + 
			"                            },\n" + 
			"                            \"key\": \"enquiry_create\",\n" + 
			"                            \"subscribe\": true,\n" + 
			"                            \"workflowname\": \"DeAz_Enquiry_categorization:14:567377\",\n" + 
			"                            \"UIMetaData\": {\n" + 
			"                                \"custom_UI_element\": {\n" + 
			"                                    \"UIButton_caption_1\": \"APPT_SEND\"\n" + 
			"                                },\n" + 
			"                                \"custom_fields\": {\n" + 
			"                                    \"enquiry\": {\n" + 
			"                                        \"caption\": \"QUESTION\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 2\n" + 
			"                                    },\n" + 
			"                                    \"type\": {\n" + 
			"                                        \"caption\": \"TYPE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 1\n" + 
			"                                    }\n" + 
			"                                }\n" + 
			"                            },\n" + 
			"                            \"OnbehalfUIcaption\": null,\n" + 
			"                            \"UIImage\": \"\",\n" + 
			"                            \"UIbutton\": \"operation-enquiry\",\n" + 
			"                            \"order\": 1\n" + 
			"                        }\n" + 
			"                    },\n" + 
			"                    \"directpayment\": {\n" + 
			"                        \"create\": {\n" + 
			"                            \"WorkflowMapping\": [],\n" + 
			"                            \"primaryOperation\": true,\n" + 
			"                            \"invokedBy\": \"business\",\n" + 
			"                            \"group\": null,\n" + 
			"                            \"Description\": \"DIRECT_PAYMENT_DETAIL\",\n" + 
			"                            \"UIDescription\": \"DIRECT_PAYMENT_DESCRIPTION\",\n" + 
			"                            \"MappingErrorMsg\": \"\",\n" + 
			"                            \"UIcaption\": \"APPT_SEND_ORDER_SUMMARY\",\n" + 
			"                            \"visibility\": {\n" + 
			"                                \"associatedType\": [],\n" + 
			"                                \"status\": []\n" + 
			"                            },\n" + 
			"                            \"key\": \"directpayment_create\",\n" + 
			"                            \"subscribe\": true,\n" + 
			"                            \"workflowname\": \"DeAz_Direct_Payment_with_Summary_Without_Appt:15:687350\",\n" + 
			"                            \"UIMetaData\": {\n" + 
			"                                \"custom_UI_element\": {\n" + 
			"                                    \"UIButton_caption_1\": \"APPT_CONFIRM\"\n" + 
			"                                },\n" + 
			"                                \"custom_fields\": {\n" + 
			"                                    \"description\": {\n" + 
			"                                        \"caption\": \"DESCRIPTION\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 6\n" + 
			"                                    },\n" + 
			"                                    \"email_id\": {\n" + 
			"                                        \"caption\": \"COMMON_EMAIL\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 3\n" + 
			"                                    },\n" + 
			"                                    \"service_name\": {\n" + 
			"                                        \"caption\": \"SELECT_SERVICE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 4\n" + 
			"                                    },\n" + 
			"                                    \"bill\": {\n" + 
			"                                        \"caption\": \"ATTACH_IMAGE_ONLY_ONE\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 7\n" + 
			"                                    },\n" + 
			"                                    \"invoice_date\": {\n" + 
			"                                        \"caption\": \"SELECT_DATE\",\n" + 
			"                                        \"type\": \"dateonly\",\n" + 
			"                                        \"order\": 5\n" + 
			"                                    },\n" + 
			"                                    \"customer_phone_number\": {\n" + 
			"                                        \"caption\": \"MOBILE_NUMBER\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 1\n" + 
			"                                    },\n" + 
			"                                    \"amount\": {\n" + 
			"                                        \"caption\": \"AMOUNT\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 3\n" + 
			"                                    },\n" + 
			"                                    \"invoice_id\": {\n" + 
			"                                        \"caption\": \"ORDER_SUMMARY_NUMBER\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 7\n" + 
			"                                    },\n" + 
			"                                    \"customer_name\": {\n" + 
			"                                        \"caption\": \"CUSTOMER_NAME\",\n" + 
			"                                        \"type\": null,\n" + 
			"                                        \"order\": 2\n" + 
			"                                    }\n" + 
			"                                }\n" + 
			"                            },\n" + 
			"                            \"OnbehalfUIcaption\": null,\n" + 
			"                            \"UIImage\": \"/business/default_biz.png\",\n" + 
			"                            \"UIbutton\": \"operation-send_invoice\",\n" + 
			"                            \"order\": 1\n" + 
			"                        }\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"notificationInfo\": {\n" + 
			"                    \"CashReceiptBPFailure\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"RECEIPT_FAILURE\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"CashReceiptBPNewsPaper\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"RECEIPT_RECEIVED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"NotifyEmployeeStillAllocated\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"CUSTOMER_ASSIGNED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"DeleteAppointment\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"DELETE_APPOINTMENT\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"NotifyEmployeeDeAllocation\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"CUSTOMER_UNASSIGNED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"UpdateServiceRequestPerson\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"APPOINTMENT_RESCHEDULED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"CashPaymentSP\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"PAYMENT_INITIATED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"CashReceiptBP\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"RECEIPT_RECEIVED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"DeleteAppointmentFailure\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"APPOINTMENT_CANCELLATION_FAILURE\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"CashReceipt\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"CASH_RECEIPT\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"GenericRating\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"Rating\": {\n" + 
			"                                \"caption\": \"RATE_OUR_SERVICE\",\n" + 
			"                                \"type\": \"ratinginput\"\n" + 
			"                            },\n" + 
			"                            \"Review\": {\n" + 
			"                                \"caption\": \"COMMENTS_AND_SUGGESTIONS\",\n" + 
			"                                \"type\": \"string\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": null,\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"NotifyEmployeeAllocation\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"CUSTOMER_ASSIGNED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"CashPaymentPB\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"note\": {\n" + 
			"                                \"caption\": \"NOTE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"receipt_date\": {\n" + 
			"                                \"caption\": \"NOTI_RECEIPT_DATE\",\n" + 
			"                                \"type\": \"date\"\n" + 
			"                            },\n" + 
			"                            \"receipt_description\": {\n" + 
			"                                \"caption\": \"DESCRIPTION\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"amount_received\": {\n" + 
			"                                \"caption\": \"AMOUNT\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"receipt_id\": {\n" + 
			"                                \"caption\": \"RECEIPT_NUMBER\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": null,\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"ConfirmRequest\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"APPOINTMENT_CONFIRMED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"ServiceRequest\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"confirmed\": {\n" + 
			"                                \"caption\": \"CONFIRM_APPT\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            },\n" + 
			"                            \"event_start_datetime\": {\n" + 
			"                                \"caption\": \"DATE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"servicename\": {\n" + 
			"                                \"caption\": \"SERVICE_NAME\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"description\": {\n" + 
			"                                \"caption\": \"DESCRIPTION\",\n" + 
			"                                \"type\": \"string\"\n" + 
			"                            },\n" + 
			"                            \"SelectedEmployee\": {\n" + 
			"                                \"caption\": \"SELECT_EMPLOYEE\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"APPOINTMNET_REQUEST\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"UpdateServiceRequest\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"confirmed\": {\n" + 
			"                                \"caption\": \"CONFIRM_APPT\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            },\n" + 
			"                            \"event_start_datetime\": {\n" + 
			"                                \"caption\": \"DATE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"servicename\": {\n" + 
			"                                \"caption\": \"SERVICE_NAME\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"description\": {\n" + 
			"                                \"caption\": \"DESCRIPTION\",\n" + 
			"                                \"type\": \"string\"\n" + 
			"                            },\n" + 
			"                            \"SelectedEmployee\": {\n" + 
			"                                \"caption\": \"SELECT_EMPLOYEE\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"UPDATE_APPOINTMENT\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"EnquiryRequest\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"answer\": {\n" + 
			"                                \"caption\": \"RESPONSE\",\n" + 
			"                                \"type\": \"textarea\"\n" + 
			"                            },\n" + 
			"                            \"question\": {\n" + 
			"                                \"caption\": \"QUERY_ASKED\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": null,\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"GenericRatingConfirmation\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"customers_rating_of_business\": {\n" + 
			"                                \"caption\": \"CUSTOMER_RATINGS\",\n" + 
			"                                \"type\": \"ratingdisplay\"\n" + 
			"                            },\n" + 
			"                            \"my_rating_of_customer\": {\n" + 
			"                                \"caption\": \"RATE_THE_CUSTOMER\",\n" + 
			"                                \"type\": \"ratinginput\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"CUSTOMER_RATINGS\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"UpdateServiceRequestRecurrence\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"confirmed\": {\n" + 
			"                                \"caption\": \"CONFIRM_APPT\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            },\n" + 
			"                            \"event_start_datetime\": {\n" + 
			"                                \"caption\": \"DATE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"servicename\": {\n" + 
			"                                \"caption\": \"SERVICE_NAME\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"description\": {\n" + 
			"                                \"caption\": \"DESCRIPTION\",\n" + 
			"                                \"type\": \"string\"\n" + 
			"                            },\n" + 
			"                            \"SelectedEmployee\": {\n" + 
			"                                \"caption\": \"SELECT_EMPLOYEE\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            },\n" + 
			"                            \"service_qty\": {\n" + 
			"                                \"caption\": \"SERVICE_QUANTITY\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"UPDATE_APPOINTMENT\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"WalletPaymentPB\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"PAYMENT_RECEIVED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"SendInvoiceBPNewsPaper\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"Pay_Bill_For\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"CashPaymentPBNewsPaper\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"note\": {\n" + 
			"                                \"caption\": \"NOTE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"receipt_date\": {\n" + 
			"                                \"caption\": \"NOTI_RECEIPT_DATE\",\n" + 
			"                                \"type\": \"date\"\n" + 
			"                            },\n" + 
			"                            \"receipt_description\": {\n" + 
			"                                \"caption\": \"DESCRIPTION\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"amount_received\": {\n" + 
			"                                \"caption\": \"AMOUNT\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"receipt_id\": {\n" + 
			"                                \"caption\": \"RECEIPT_NUMBER\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": null,\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"SendInvoiceBP\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"payment_date\": {\n" + 
			"                                \"caption\": \"DUE_DATE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"serviceNameLabel\": {\n" + 
			"                                \"caption\": \"SERVICE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"bizName\": {\n" + 
			"                                \"caption\": \"BUSINESS\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"amount_paid\": {\n" + 
			"                                \"caption\": \"AMOUNT_DUE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"payment_description\": {\n" + 
			"                                \"caption\": \"PAYMENT_COMMENT\",\n" + 
			"                                \"type\": \"string\"\n" + 
			"                            },\n" + 
			"                            \"bill_image\": {\n" + 
			"                                \"caption\": \"BILL_IMAGE\",\n" + 
			"                                \"type\": \"hyperlink\"\n" + 
			"                            },\n" + 
			"                            \"transaction_id\": {\n" + 
			"                                \"caption\": \"TRANSACTION_NUMBER\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"Pay_Bill_For\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"RecurringServiceRequest\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": {\n" + 
			"                            \"confirmed\": {\n" + 
			"                                \"caption\": \"CONFIRM_APPT\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            },\n" + 
			"                            \"event_start_datetime\": {\n" + 
			"                                \"caption\": \"RECURRENCE_STARTDATE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"servicename\": {\n" + 
			"                                \"caption\": \"SERVICE_NAME\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"description\": {\n" + 
			"                                \"caption\": \"DESCRIPTION\",\n" + 
			"                                \"type\": \"string\"\n" + 
			"                            },\n" + 
			"                            \"SelectedEmployee\": {\n" + 
			"                                \"caption\": \"SELECT_EMPLOYEE\",\n" + 
			"                                \"type\": \"singleselect\"\n" + 
			"                            },\n" + 
			"                            \"event_enddate_label\": {\n" + 
			"                                \"caption\": \"RECURRENCE_ENDDATE\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"service_qty\": {\n" + 
			"                                \"caption\": \"SERVICE_QUANTITY\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            },\n" + 
			"                            \"repeat_label\": {\n" + 
			"                                \"caption\": \"RECURRENCE_REPEAT\",\n" + 
			"                                \"type\": \"label\"\n" + 
			"                            }\n" + 
			"                        },\n" + 
			"                        \"custom_UI_element\": null,\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"CashPaymentPBFailure\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"CASH_PAYMENT_FAILURE\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    },\n" + 
			"                    \"WalletPaymentPBNewsPaper\": {\n" + 
			"                        \"UINotification_title\": null,\n" + 
			"                        \"custom_fields\": null,\n" + 
			"                        \"custom_UI_element\": {\n" + 
			"                            \"UIPage_title\": \"PAYMENT_RECEIVED\"\n" + 
			"                        },\n" + 
			"                        \"Submit_Button\": null\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"privacy_type\": 2,\n" + 
			"                \"object_id\": \"bf4c5510-a531-11e8-92d6-fa163e76315a\",\n" + 
			"                \"service_list\": {\n" + 
			"                    \"paper\": {\n" + 
			"                        \"is_hidden\": false,\n" + 
			"                        \"cost\": \"3\",\n" + 
			"                        \"serviceImage\": \"/business/service_default.png\",\n" + 
			"                        \"description\": \"daily paper\"\n" + 
			"                    }\n" + 
			"                },\n" + 
			"                \"address_lat\": \"0.0\",\n" + 
			"                \"Banner\": \"\",\n" + 
			"                \"email\": [\n" + 
			"                    \"yogeshchaurse@yopmail.com\"\n" + 
			"                ],\n" + 
			"                \"phone_number\": [\n" + 
			"                    8999356617\n" + 
			"                ],\n" + 
			"                \"description\": \"apninbkok\",\n" + 
			"                \"address1\": \"pime\",\n" + 
			"                \"privacy_level\": 1,\n" + 
			"                \"is_active\": true,\n" + 
			"                \"address\": [],\n" + 
			"                \"otp\": \"\",\n" + 
			"                \"employee_list\": [\n" + 
			"                    \"19787ab8-a529-11e8-92d6-fa163e76315a\"\n" + 
			"                ],\n" + 
			"                \"name\": [\n" + 
			"                    \"Apna Business\"\n" + 
			"                ],\n" + 
			"                \"is_verified\": \"no\",\n" + 
			"                \"identifier_type\": \"business\",\n" + 
			"                \"address_long\": \"0.0\",\n" + 
			"                \"keyword_mapping\": [],\n" + 
			"                \"email_dq\": [\n" + 
			"                    -1\n" + 
			"                ],\n" + 
			"                \"payment_gateway\": {\n" + 
			"                    \"disablePaymentGateway\": false\n" + 
			"                }\n" + 
			"            }\n" + 
			"        ],\n" + 
			"        \"Authorization_Info\": {\n" + 
			"            \"access_token\": \"cbe294e1e0db90a49df5e9db4c2eb419\",\n" + 
			"            \"scope\": \"scope_business scope_person\",\n" + 
			"            \"token_type\": \"Bearer\",\n" + 
			"            \"expires_in\": 3141,\n" + 
			"            \"refresh_token\": \"dde9ac4a04233e45b2344b2425c3763d\"\n" + 
			"        }\n" + 
			"    },\n" + 
			"    \"ResultCode\": \"Success\"\n" + 
			"}";

	
	public static void main(String[] args) throws ParseException {

		 long unixTime = System.currentTimeMillis()/1000;
			System.out.println(unixTime);
			
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(unixTime*1000);
			
			
			
			System.out.println(c.getTime());

		
	}
	





}
