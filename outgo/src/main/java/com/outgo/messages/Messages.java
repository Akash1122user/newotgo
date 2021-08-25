package com.outgo.messages;

public class Messages {
	//public static final String site="http://192.168.0.113:8080/merchantv3/pay/";
	public static final String URL="http://smartBiz.deazzle.in";

	
	
	public static final String PAYPENDING = "Dear <NAME>  pay your <Business> bill, using  link <LINK> Thank You" ;



	public static final String RegisterComplaint = "Dear Customer, Your complaint has been registered with us with id [ID]. We will work upon it, at the earliest.Thanks.";
	public static final String RegisterEnquiry = "Dear Customer, Your enquiry has been registered with us with id [ID].We will work upon it, at the earliest. Thanks.\n" + 
			"";
	public static final String AssignMessage = "A new task has been assigned to you. Taskid is : [ID]. For more details, pls login to "+URL;



	public static final String ClosedMessage = "Dear Customer, your [TYPE] with Id : [ID] has been completed. Thanks.";
	//public static final String ClosedMessage = "Dear Customer, A task with TaskId : [ID] has been completed. Thanks.";
	


	public static final String SENDLINK = "	Dear [name], please pay your [org] bill, using this link [url] . Thank You.";



	public static final String OTP_MOBILE_VERIFICATION = "Your OTP for Mobile Number Validation is [OTP]. Thanks, deAzzle.";
	public static final String OTP_Forget_Password = "Your OTP for Forgot Password is [OTP]. Thanks, deAzzle.";



	public static final String WELCOME_MERCHANT = "Dear Customer, Welcome to deAzzle Merchant family. We hope to give the most value add for your business. Thank you for choosing our services. deAzzle Team";



	public static final String Welcome_Customer = "Dear Customer, Your userid : [USERID] and Password : [PASSWORD]. Thanks, [ORG] click on [SITE]";
	public static String  OTP_MESSAGE="Your OTP for [TYPE] is [OTP].";
	public static String WELCOME_MESSAGE="";
	
	
	public static String Email_Template_Welcome="<!--\n" + 
			"Author: deAzzle\n" + 
			"Author URL: https://www.deAzzle.in\n" + 
			"License: \n" + 
			"License URL: \n" + 
			"-->\n" + 
			"<!DOCTYPE html>\n" + 
			"<html>\n" + 
			"<head>\n" + 
			"<title>deAzzle</title>\n" + 
			"<!-- Custom Theme files -->\n" + 
			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
			"<meta name=\"keywords\" content=\"deAzzle , \n" + 
			"	\" />\n" + 
			"<!-- //Custom Theme files -->\n" + 
			"<!-- Responsive Styles and Valid Styles -->\n" + 
			"	<style type=\"text/css\">\n" + 
			"    	\n" + 
			"	    body{\n" + 
			"            width: 100%;  \n" + 
			"            margin:0; \n" + 
			"            padding:0; \n" + 
			"            -webkit-font-smoothing: antialiased;	\n" + 
			"        }\n" + 
			"        html{\n" + 
			"            width: 100%; \n" + 
			"        }\n" + 
			"        \n" + 
			"        table{\n" + 
			"            font-size: 14px;\n" + 
			"            border: 0;\n" + 
			"        }\n" + 
			"		 /* ----------- responsivity ----------- */\n" + 
			"		 @media only screen and (max-width: 800px){\n" + 
			"				table.container.top-header-left {\n" + 
			"					width: 726px;\n" + 
			"				}\n" + 
			"		 }\n" + 
			"		 @media only screen and (max-width: 736px){\n" + 
			"			 table.container.top-header-left {\n" + 
			"				width: 684px;\n" + 
			"			}\n" + 
			"			}\n" + 
			"		@media only screen and (max-width: 667px){\n" + 
			"			table.container.top-header-left {\n" + 
			"				width: 600px;\n" + 
			"			}\n" + 
			"			table.container-middle {\n" + 
			"				width: 565px;\n" + 
			"			}\n" + 
			"			/*a.logo-text img {\n" + 
			"				width: 100%;\n" + 
			"				height: inherit;\n" + 
			"			}*/\n" + 
			"			table.logo {\n" + 
			"				width: 40%;\n" + 
			"			}\n" + 
			"			table.mail_left {\n" + 
			"				width: 200px;\n" + 
			"			}\n" + 
			"			td.mail_gd,td.mail_gd a {\n" + 
			"				text-align: center !important;\n" + 
			"			}\n" + 
			"			td.ban_pad {\n" + 
			"				height: 48px;\n" + 
			"			}\n" + 
			"			td.future {\n" + 
			"				font-size: 2em !important;\n" + 
			"			}\n" + 
			"			td.ban_tex {\n" + 
			"				height: 18px;\n" + 
			"			}\n" + 
			"			table.ban-hei {\n" + 
			"				height: 315px !important;\n" + 
			"			}\n" + 
			"			td.ser_pad {\n" + 
			"				height: 50px;\n" + 
			"			}\n" + 
			"			td.wel_text {\n" + 
			"				font-size: 2.1em !important;\n" + 
			"			}\n" + 
			"			td.ser_text {\n" + 
			"				line-height: 2em !important;\n" + 
			"				font-size: 1em !important;\n" + 
			"			}\n" + 
			"			table.twelve_one {\n" + 
			"				width: 316px;\n" + 
			"			}\n" + 
			"			table.twelve_two {\n" + 
			"				width: 229px;\n" + 
			"			}\n" + 
			"			td.pic_one img {\n" + 
			"				width: 100%;\n" + 
			"				height: inherit;\n" + 
			"			}\n" + 
			"			table.ser_left_two {\n" + 
			"				width: 100px;\n" + 
			"			}\n" + 
			"			table.ser_left_one {\n" + 
			"				width: 200px;\n" + 
			"			}\n" + 
			"			img.full {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			table.twelve_three {\n" + 
			"				width: 272px;\n" + 
			"			}\n" + 
			"			td.ser_text2 {\n" + 
			"				font-size: 1.5em !important;\n" + 
			"			}\n" + 
			"			table.cir_left {\n" + 
			"				width: 276px;\n" + 
			"			}\n" + 
			"			table.twelve_four {\n" + 
			"				width: 200px;\n" + 
			"			}\n" + 
			"			table.twelve_five {\n" + 
			"				width: 337px;\n" + 
			"			}\n" + 
			"			td.ser_one {\n" + 
			"				height: 45px;\n" + 
			"			}\n" + 
			"			table.foo {\n" + 
			"				width: 370px;\n" + 
			"			}\n" + 
			"		}\n" + 
			"        @media only screen and (max-width: 640px){\n" + 
			"			td.ser_one {\n" + 
			"				height: 60px;\n" + 
			"			}\n" + 
			"            .top-bottom-bg{width: 420px !important; height: auto !important;}\n" + 
			"			\n" + 
			"			table.container-middle.navi-grid {\n" + 
			"				width: 360px !important;\n" + 
			"			}\n" + 
			"			table.logo {\n" + 
			"				width: 45%;\n" + 
			"			}\n" + 
			"        }\n" + 
			"		@media only screen and (max-width: 600px){\n" + 
			"			table.container.top-header-left {\n" + 
			"				width: 535px;\n" + 
			"			}\n" + 
			"			table.container-middle{\n" + 
			"				width: 485px;\n" + 
			"			}\n" + 
			"			table.ban-hei {\n" + 
			"				height: 288px !important;\n" + 
			"			}\n" + 
			"			table.ser_left_one {\n" + 
			"				width: 151px;\n" + 
			"			}\n" + 
			"			table.ser_left_two {\n" + 
			"				width: 86px;\n" + 
			"			}\n" + 
			"			table.twelve_one {\n" + 
			"				width: 239px;\n" + 
			"			}\n" + 
			"			table.twelve_two {\n" + 
			"				width: 221px;\n" + 
			"			}\n" + 
			"			table.twelve_three {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			img.full {\n" + 
			"				width: inherit;\n" + 
			"			}\n" + 
			"			table.cir_left {\n" + 
			"				width: 230px;\n" + 
			"			}\n" + 
			"			table.cir_left img {\n" + 
			"				width: 54%;\n" + 
			"				height: inherit;\n" + 
			"			}\n" + 
			"			img.full.team_img {\n" + 
			"				width: 100% !important;\n" + 
			"				height:inherit;\n" + 
			"			}\n" + 
			"			table.twelve_four {\n" + 
			"				width: 160px;\n" + 
			"			}\n" + 
			"			table.twelve_five {\n" + 
			"				width: 298px;\n" + 
			"			}\n" + 
			"			td.team_pad {\n" + 
			"				height: 0;\n" + 
			"			}\n" + 
			"			table.foo {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			td.ser_text.editable {\n" + 
			"				text-align: center;\n" + 
			"			}\n" + 
			"			table.foo1 {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"		}\n" + 
			"		@media only screen and (max-width: 568px){\n" + 
			"			/*-- w3layouts --*/\n" + 
			"			table.container.top-header-left {\n" + 
			"				width: 495px !important;\n" + 
			"			}\n" + 
			"			table.ban_info {\n" + 
			"				width: 400px;\n" + 
			"			}\n" + 
			"			\n" + 
			"			td.future {\n" + 
			"				font-size: 1.8em !important;\n" + 
			"			}\n" + 
			"			table.ban-hei {\n" + 
			"				height: 258px !important;\n" + 
			"			}\n" + 
			"			table.container-middle {\n" + 
			"				width: 449px;\n" + 
			"			}\n" + 
			"			table.twelve_two {\n" + 
			"				width: 190px;\n" + 
			"			}\n" + 
			"			td.ser_one {\n" + 
			"				height: 34px;\n" + 
			"			}\n" + 
			"			td.ser_two {\n" + 
			"				height: 21px;\n" + 
			"			}\n" + 
			"			table.cir_left {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			table.cir_left img {\n" + 
			"				width: 30%;\n" + 
			"				height: inherit;\n" + 
			"			}\n" + 
			"			table.twelve_four {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			img.full.team_img {\n" + 
			"				width: 45% !important;\n" + 
			"				height: inherit;\n" + 
			"			}\n" + 
			"			table.twelve_five {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			td.text_team {\n" + 
			"				text-align: center;\n" + 
			"			}\n" + 
			"			td.twel_pad {\n" + 
			"				height: 25px;\n" + 
			"			}\n" + 
			"		}\n" + 
			"		/*-- agileits --*/\n" + 
			"        @media only screen and (max-width: 480px){\n" + 
			"            .container{width: 290px !important;}\n" + 
			"            .container-middle {\n" + 
			"				width: 85% !important;\n" + 
			"			}\n" + 
			"            .mainContent{width: 240px !important;}\n" + 
			"            .top-bottom-bg{width: 260px !important; height: auto !important;\n" + 
			"			}\n" + 
			"		\n" + 
			"			table.logo {\n" + 
			"				width: 33% !important;\n" + 
			"			}\n" + 
			"			table.container.top-header-left {\n" + 
			"				width: 422px !important;\n" + 
			"			}\n" + 
			"			\n" + 
			"			table.container-middle.navi-grid {\n" + 
			"				width: 399px !important;\n" + 
			"			}\n" + 
			"			table.container-middle.nav-head {\n" + 
			"				width: 350px !important;\n" + 
			"			}\n" + 
			"			table.twelve_one {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			table.ser_left_one {\n" + 
			"				width: 271px;\n" + 
			"			}\n" + 
			"			table.twelve_two {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			td.pic_one {\n" + 
			"				text-align: center !important;\n" + 
			"			}\n" + 
			"			td.pic_one img {\n" + 
			"				width: 70%;\n" + 
			"				height: inherit;\n" + 
			"			}\n" + 
			"			td.ser_pad {\n" + 
			"				height: 32px;\n" + 
			"			}\n" + 
			"			td.future {\n" + 
			"				font-size: 1.5em !important;\n" + 
			"			}\n" + 
			"			table.ban_info {\n" + 
			"				width: 348px;\n" + 
			"			}\n" + 
			"			table.logo {\n" + 
			"				width: 43% !important;\n" + 
			"			}\n" + 
			"			/*-- w3layouts --*/\n" + 
			"			table.ban-hei {\n" + 
			"				height: 242px !important;\n" + 
			"			}\n" + 
			"			td.ban_pad {\n" + 
			"				height: 24px;\n" + 
			"			}	\n" + 
			"			table.logo {\n" + 
			"				width: 54% !important;\n" + 
			"			}\n" + 
			"			td.ser_text {\n" + 
			"				font-size: 13px !important;\n" + 
			"			}			\n" + 
			"	    }\n" + 
			"		\n" + 
			"		@media only screen and (max-width: 414px){\n" + 
			"			table.container.top-header-left {\n" + 
			"				width: 397px !important;\n" + 
			"			}\n" + 
			"			table.container-middle.navi-grid {\n" + 
			"				width: 372px !important;\n" + 
			"			}\n" + 
			"			table.container.top-header-left {\n" + 
			"				width: 370px !important;\n" + 
			"			}\n" + 
			"			.container-middle {\n" + 
			"				width: 95% !important;\n" + 
			"			}\n" + 
			"			table.ser_left_one {\n" + 
			"				width: 255px;\n" + 
			"			}\n" + 
			"		}\n" + 
			"		@media only screen and (max-width: 384px){\n" + 
			"		\n" + 
			"			table.container-middle.navi-grid ,table.container.top-header-left{\n" + 
			"				width: 300px !important;\n" + 
			"			}\n" + 
			"			table.ban_info {\n" + 
			"				width: 297px;\n" + 
			"			}\n" + 
			"			td.future {\n" + 
			"				font-size: 1.3em !important;\n" + 
			"			}\n" + 
			"			.container-middle {\n" + 
			"				width: 90% !important;\n" + 
			"			}\n" + 
			"			table.ban_info {\n" + 
			"				width: 310px;\n" + 
			"			}\n" + 
			"			/*-- agileits --*/\n" + 
			"			table.container-middle.nav-head {\n" + 
			"				width: 340px !important;\n" + 
			"			}\n" + 
			"			\n" + 
			"			table.ser_left_one {\n" + 
			"				width: 216px;\n" + 
			"			}\n" + 
			"			table.mail_left,table.mail_right {\n" + 
			"				width: 100%;\n" + 
			"				height: 38px;\n" + 
			"			}\n" + 
			"			table.ban-hei {\n" + 
			"				height: 207px !important;\n" + 
			"			}\n" + 
			"			td.ser_one {\n" + 
			"				height: 11px;\n" + 
			"			}\n" + 
			"		}\n" + 
			"		\n" + 
			"		@media only screen and (max-width: 320px){\n" + 
			"			td.wel_text {\n" + 
			"				font-size: 1.9em !important;\n" + 
			"			}\n" + 
			"			img.full {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			table.container.top-header-left {\n" + 
			"				width: 284px !important;\n" + 
			"			}\n" + 
			"			table.container-middle.nav-head {\n" + 
			"				width: 257px !important;\n" + 
			"			}\n" + 
			"			table.ban_info {\n" + 
			"				width: 257px;\n" + 
			"			}\n" + 
			"			td.future {\n" + 
			"				font-size: 1.2em !important;\n" + 
			"			}\n" + 
			"			td.ban_tex {\n" + 
			"				height: 10px;\n" + 
			"			}\n" + 
			"			table.ban-hei {\n" + 
			"				height: 175px !important;\n" + 
			"			}\n" + 
			"			table.logo {\n" + 
			"				width: 56% !important;\n" + 
			"			}\n" + 
			"			td.top_mar {\n" + 
			"				height: 6px;\n" + 
			"			}\n" + 
			"			table.mail_left, table.mail_right {\n" + 
			"				width: 100%;\n" + 
			"				height: 29px;\n" + 
			"			}\n" + 
			"			table.ser_left_one {\n" + 
			"				width: 181px;\n" + 
			"			}\n" + 
			"			table.ser_left_two {\n" + 
			"				width: 73px;\n" + 
			"			}\n" + 
			"			td.pic_one img {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			table.cir_left img {\n" + 
			"				width: 37%;\n" + 
			"			}\n" + 
			"			td.thompson {\n" + 
			"				font-size: 1.5em !important;\n" + 
			"			}\n" + 
			"			table.follow {\n" + 
			"				width: 100%;\n" + 
			"			}\n" + 
			"			table.follow td {\n" + 
			"				text-align: center !important;\n" + 
			"			}\n" + 
			"			table.logo {\n" + 
			"				width: 69% !important;\n" + 
			"			}\n" + 
			"		}\n" + 
			"    </style>  \n" + 
			"</head>\n" + 
			"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" + 
			"	<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
			"		\n" + 
			"        <tr>\n" + 
			"            <td width=\"100%\" align=\"center\" valign=\"top\"  bgcolor=\"062f3c\" style=\"\">\n" + 
			"				<table>\n" + 
			"					<tr><td class=\"top_mar\" height=\"50\"></td></tr>\n" + 
			"				</table>\n" + 
			"				<!-- main content -->\n" + 
			"				<table style=\"box-shadow:0px 0px 0px 0px #E0E0E0;\"width=\"800\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"container top-header-left\">	\n" + 
			"					<tr bgcolor=\"ffffff\">\n" + 
			"						<td> \n" + 
			"							<table border=\"0\" width=\"650\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle nav-head\">\n" + 
			"								<tr>\n" + 
			"									<td height=\"15\"></td>\n" + 
			"								</tr>\n" + 
			"								<tr>\n" + 
			"									<td>\n" + 
			"										<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\" class=\"logo\">\n" + 
			"											<tbody>\n" + 
			"												\n" + 
			"												<tr>\n" + 
			"													<td align=\"right\">\n" + 
			"														<a href=\"#\" class=\"logo-text\" style=\"text-decoration:none;\"><img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/263.png\" alt=\" \" width=\"90\" height=\"80\"></a>\n" + 
			"													</td>\n" + 
			"												</tr>\n" + 
			"											</tbody>\n" + 
			"										</table>		\n" + 
			"									</td>\n" + 
			"								</tr>\n" + 
			"								<tr>\n" + 
			"									<td height=\"15\"></td>\n" + 
			"								</tr>\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr bgcolor=\"#af1610\">\n" + 
			"						<td> \n" + 
			"							<table border=\"0\" width=\"650\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle nav-head\">\n" + 
			"								<tr>\n" + 
			"									<td height=\"15\"></td>\n" + 
			"								</tr>\n" + 
			"								<tr>\n" + 
			"									<td>\n" + 
			"										<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"											<tbody>\n" + 
			"												<tr>\n" + 
			"													<td>\n" + 
			"														<table class=\"mail_left\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n" + 
			"															<tbody>\n" + 
			"																<tr> \n" + 
			"																	<td class=\"mail_gd\" align=\"center\" style=\" text-align: left; font-size:1.2em; font-family:Candara; color: #FFFFFF;\">\n" + 
			"																		<a href=\"mailto:support@deazzle.in\" style=\"color:#fff;text-decoration:none\"><img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/envelope.png\" alt=\"\" border=\"0\" height=\"18\" width=\"18\">&nbsp; &nbsp;support@deazzle.in</a>\n" + 
			"																	</td>\n" + 
			"																</tr>\n" + 
			"															</tbody>\n" + 
			"														</table>\n" + 
			"														<table class=\"mail_right\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"150\">\n" + 
			"															<tbody>\n" + 
			"																<tr>			\n" + 
			"																	<td align=\"center\"  style=\"font-size:14px;color:#f5f5f5;font-family:Arial,serif\"><img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/phone1.png\" alt=\"\" border=\"0\" height=\"16\" width=\"16\">&nbsp; &nbsp;+91 7083083646</td>\n" + 
			"																</tr>\n" + 
			"															</tbody>\n" + 
			"														</table>\n" + 
			"													</td>\n" + 
			"												</tr>\n" + 
			"											</tbody>\n" + 
			"										</table>		\n" + 
			"									</td>\n" + 
			"								</tr>\n" + 
			"								<tr>\n" + 
			"									<td height=\"15\"></td>\n" + 
			"								</tr>\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr>\n" + 
			"						<td>\n" + 
			"							<table class=\"ban-hei\" width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"background:url(https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/ban1.jpg); background-size:cover;\" height=\"380\">	\n" + 
			"								<tbody>\n" + 
			"									<tr>\n" + 
			"										<td class=\"ban_pad\" height=\"80\"></td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td>\n" + 
			"											<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"  style=\"border:2px solid #af1610\">\n" + 
			"												<tbody>\n" + 
			"													<tr>\n" + 
			"														<td>				\n" + 
			"															<table class=\"ban_info\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  width=\"500\">				\n" + 
			"																<tbody>\n" + 
			"																	<tr>\n" + 
			"																		<td class=\"ban_tex\" height=\"30\"></td>\n" + 
			"																	</tr>\n" + 
			"																	<tr>\n" + 
			"																		<td class=\"future\" style=\"font-size:2.3em;color:#fff;text-transform:capitalize;font-family:Candara;text-align:center;line-height:1.5em\">Welcome To The deAzzle Family</td>\n" + 
			"																	</tr>	\n" + 
			"																	<tr><td class=\"ban_tex\" height=\"30\"></td></tr>	\n" + 
			"																</tbody>\n" + 
			"															</table>		\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"												</tbody>\n" + 
			"											</table>\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td style=\"font-size:1.3em;color:#fff;text-transform:capitalize;font-family:Candara;text-align:center\">\n" + 
			"											Your Partner In Technology\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td class=\"ban_pad\" height=\"80\"></td>\n" + 
			"									</tr>\n" + 
			"								</tbody>\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr bgcolor=\"#ffffff\">\n" + 
			"						<td>\n" + 
			"							<table border=\"0\" width=\"650\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle\">\n" + 
			"								<tbody>\n" + 
			"									<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"									<!-- //padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"wel_text\" align=\"center\" style=\"font-size:2.5em;color:#d70b03;font-family:Candara;text-align:center;font-weight:600;\"> \n" + 
			"											SERVICES\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td height=\"15\"></td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_text\" align=\"center\" style=\"color:#464646; font-size: 1.2em; font-family: Candara; line-height:1.8em;\">\n" + 
			"											We help your business to save cost and go digital.here are the highlights:\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td height=\"20\"></td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td>\n" + 
			"											<table class=\"twelve_one\" width=\"350\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_one\" height=\"60\"></td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td>\n" + 
			"															<table class=\"ser_left_one\" width=\"250\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"																<tbody>\n" + 
			"																	<tr>\n" + 
			"																		<td class=\"ser_text\" align=\"right\" style=\"color:#464646; font-size: 1.2em; font-family: Candara; line-height:1.8em;\">Bulk Invoicing & SMS </td>\n" + 
			"																	</tr>\n" + 
			"																</tbody>\n" + 
			"															</table>\n" + 
			"															<table class=\"ser_left_two\" width=\"100\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"																<tbody>\n" + 
			"																	<tr>\n" + 
			"																		<td  align=\"center\">\n" + 
			"																			<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/download.jpeg\" alt=\" \" width=\"60\" height=\"60\" style=\"margin-top:-10px\">\n" + 
			"																		</td>\n" + 
			"																	</tr>\n" + 
			"																</tbody>\n" + 
			"															</table>\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_two\" height=\"35\"></td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td>\n" + 
			"															<table class=\"ser_left_one\" width=\"250\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"																<tbody>\n" + 
			"																	<tr>\n" + 
			"																		<td class=\"ser_text\" align=\"right\" style=\"color:#464646; font-size: 1.2em; font-family: Candara; line-height:1.8em;\">Online Payment Collection </td>\n" + 
			"																	</tr>\n" + 
			"																</tbody>\n" + 
			"															</table>\n" + 
			"															<table class=\"ser_left_two\" width=\"100\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"																<tbody>\n" + 
			"																	<tr>\n" + 
			"																		<td align=\"center\">\n" + 
			"																			<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/payment.png\" alt=\" \" width=\"60\" height=\"60\" style=\"margin-top:-10px\">\n" + 
			"																		</td>\n" + 
			"																	</tr>\n" + 
			"																</tbody>\n" + 
			"															</table>\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_two\" height=\"35\"></td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td>\n" + 
			"															<table class=\"ser_left_one\" width=\"250\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"																<tbody>\n" + 
			"																	<tr>\n" + 
			"																		<td class=\"ser_text\" align=\"right\" style=\"color:#464646; font-size: 1.2em; font-family: Candara; line-height:1.8em;\">Consumer Communiction Tools</td>\n" + 
			"																	</tr>\n" + 
			"																</tbody>\n" + 
			"															</table>\n" + 
			"															<table class=\"ser_left_two\" width=\"100\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"																<tbody>\n" + 
			"																	<tr>\n" + 
			"																		<td align=\"center\">\n" + 
			"																			<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/consumer.png\" alt=\" \" width=\"60\" height=\"60\" style=\"margin-top:-10px\">\n" + 
			"																		</td>\n" + 
			"																	</tr>\n" + 
			"																</tbody>\n" + 
			"															</table>\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"												</tbody>\n" + 
			"											</table>\n" + 
			"											<!-- SPACE -->\n" + 
			"											<table class=\"twelve\" width=\"20\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tr>\n" + 
			"													<td width=\"20\" height=\"20\" style=\"font-size: 60px; line-height: 60px;\"></td>\n" + 
			"												</tr>\n" + 
			"											</table>\n" + 
			"											<!-- END SPACE -->\n" + 
			"											<table class=\"twelve_two\" width=\"250\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													<tr>\n" + 
			"														<td class=\"pic_one\" align=\"right\">\n" + 
			"															<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/pic1.jpg\" alt=\" \" width=\"250\" height=\"376\">\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"												</tbody>\n" + 
			"											</table>\n" + 
			"											\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"									<!-- //padding-top -->\n" + 
			"								</tbody>\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr bgcolor=\"f7f7f7\">\n" + 
			"						<td>\n" + 
			"							<table border=\"0\" width=\"650\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle\" >\n" + 
			"								<tbody>\n" + 
			"									<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"									<!-- //padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"wel_text\" align=\"center\" style=\"font-size:2.5em;color:#d70b03;font-family:Candara;text-align:center;font-weight:600;\"> \n" + 
			"											ABOUT US\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td height=\"15\"></td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_text\" align=\"center\" style=\"color:#464646; font-size: 1.2em; font-family: Candara; line-height:1.8em;\">\n" + 
			"											We are serving hundreds of small businesses,in there day to day operations. \n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td height=\"20\"></td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td>\n" + 
			"											<table class=\"twelve_three\" width=\"310\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													\n" + 
			"													<tr>\n" + 
			"														<td height=\"20\">&nbsp;</td>\n" + 
			"													</tr>\n" + 
			"\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text2\" style=\"text-align:left;color: #d70b03;font-size: 1.8em;font-family:Candara;font-weight:500;\">Automation</span></td>\n" + 
			"													</tr>\n" + 
			"\n" + 
			"\n" + 
			"													<tr>\n" + 
			"														<td height=\"15\">&nbsp;</td>\n" + 
			"													</tr>\n" + 
			"\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text\" align=\"left\" style=\"color: #464646;font-size: 1.2em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															Create bulk invoices<br>Send bulk messages<br>Share payment links \n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td height=\"15\">&nbsp;</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td align=\"left\">\n" + 
			"															<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/pic6.jpg\" alt=\" \" width=\"310\" height=\"190\" class=\"full\">\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"												</tbody>\n" + 
			"											</table>\n" + 
			"											<!-- SPACE -->\n" + 
			"											<table class=\"twelve\" width=\"20\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"\n" + 
			"												<tr>\n" + 
			"													<td width=\"20\" height=\"20\" style=\"font-size: 60px; \"></td>\n" + 
			"												</tr>\n" + 
			"\n" + 
			"											</table>\n" + 
			"											<!-- END SPACE -->\n" + 
			"											<table class=\"twelve_three\" width=\"310\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													\n" + 
			"													<tr>\n" + 
			"														<td height=\"20\">&nbsp;</td>\n" + 
			"													</tr>\n" + 
			"\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text2\" style=\"text-align:left;color: #d70b03;font-size: 1.8em;font-family:Candara;font-weight:500;\">Secure Payment</span></td>\n" + 
			"													</tr>\n" + 
			"\n" + 
			"\n" + 
			"													<tr>\n" + 
			"														<td height=\"15\">&nbsp;</td>\n" + 
			"													</tr>\n" + 
			"\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text\" align=\"left\" style=\"color: #464646;font-size: 1.2em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															All payment mode supported<br>Secure payment process<br>T+2 credit in your bank account\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td height=\"15\">&nbsp;</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td align=\"left\">\n" + 
			"															<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/pic7.jpg\" alt=\" \" width=\"310\" height=\"190\" class=\"full\">\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"												</tbody>\n" + 
			"											</table>\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td height=\"50\"></td>\n" + 
			"									</tr>\n" + 
			"									\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"									<!-- //padding-top -->\n" + 
			"								</tbody>\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"				\n" + 
			"					<tr bgcolor=\"ffffff\">\n" + 
			"						<td>\n" + 
			"							<table border=\"0\" width=\"650\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle\" >\n" + 
			"								<tbody>\n" + 
			"									<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"									<!-- //padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"wel_text\" align=\"center\" style=\"font-size:2.5em;color:#d70b03;font-family:Candara;text-align:center;font-weight:600;\"> \n" + 
			"											PRODUCT DEMO\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td height=\"25\"></td>\n" + 
			"									</tr>\n" + 
			"									<tr>\n" + 
			"										<td>\n" + 
			"											<table class=\"twelve_four\" width=\"100\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													<tr>\n" + 
			"														<td align=\"center\">\n" + 
			"															<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/imgpsh_fullsize.png\" alt=\" \" width=\"160\" height=\"150\" class=\"full team_img\">\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"												</tbody>\n" + 
			"											</table>\n" + 
			"											<!-- SPACE -->\n" + 
			"											<table  width=\"20\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tr>\n" + 
			"													<td width=\"20\" height=\"20\" style=\"font-size: 60px; line-height: 60px;\"></td>\n" + 
			"												</tr>\n" + 
			"											</table>\n" + 
			"											<!-- END SPACE -->\n" + 
			"											<table class=\"twelve_five\" width=\"430\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													<tr>\n" + 
			"														<td class=\"team_pad\" height=\"20\"></td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text2 text_team\" align=\"left\" style=\"color: #d70b03;font-size: 1.5em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															Mobile App\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td height=\"10\"></td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text text_team\" align=\"left\" style=\"color: #464646;font-size: 1.2em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															Business dashboard at your finger tips<br> View of recent payments<br>View enquiries & customer messages\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td height=\"10\"></td>\n" + 
			"													</tr>\n" + 
			"													<!--<tr>\n" + 
			"														<td class=\"text_team\" align=\"left\" style=\"color: #d70b03;font-size: 1.2em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															 Thompson \n" + 
			"														</td>\n" + 
			"													</tr>-->\n" + 
			"												</tbody>\n" + 
			"											</table>	\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"twel_pad\" height=\"50\"></td>\n" + 
			"									</tr>\n" + 
			"									<!-- //padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td>\n" + 
			"											<table class=\"twelve_five\" width=\"430\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													<tr>\n" + 
			"														<td class=\"team_pad\" height=\"20\"></td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text2 text_team\" align=\"right\" style=\"color: #d70b03;font-size: 1.5em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															Web Portal\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td height=\"10\"></td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td class=\"ser_text text_team\" align=\"right\" style=\"color: #464646;font-size: 1.2em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															Historical data,Customer upload<br>Invoice creation,Messaging facility,Payouts \n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"													<tr>\n" + 
			"														<td height=\"10\"></td>\n" + 
			"													</tr>\n" + 
			"													<!--<tr>\n" + 
			"														<td class=\"text_team\" align=\"right\" style=\"color: #d70b03;font-size: 1.2em;font-family: Candara;line-height: 1.8em;\">\n" + 
			"															 Federica \n" + 
			"														</td>\n" + 
			"													</tr>-->\n" + 
			"												</tbody>\n" + 
			"											</table>\n" + 
			"											<!-- SPACE -->\n" + 
			"											<table  width=\"20\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tr>\n" + 
			"													<td width=\"20\" height=\"20\" style=\" line-height: 60px;\"></td>\n" + 
			"												</tr>\n" + 
			"											</table>\n" + 
			"											<!-- END SPACE -->\n" + 
			"											<table class=\"twelve_four\" width=\"100\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"												<tbody>\n" + 
			"													<tr>\n" + 
			"														<td align=\"center\">\n" + 
			"															<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/imgpsh_fullsize1.png\" alt=\" \" width=\"200\" height=\"150\" class=\"full team_img\">\n" + 
			"														</td>\n" + 
			"													</tr>\n" + 
			"												</tbody>\n" + 
			"											</table>									\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"									<!-- //padding-top -->\n" + 
			"								</tbody>\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr bgcolor=\"f7f7f7\">\n" + 
			"						<td>\n" + 
			"							<table border=\"0\" width=\"650\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle\">\n" + 
			"								<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"								<!-- //padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td>\n" + 
			"											<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\n" + 
			"												<tr>\n" + 
			"													<td align=\"center\">\n" + 
			"														<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/263.png\" alt=\" \" class=\"img-responsive circle-left-img\" style=\"text-align:center;\" width=\"130\" height=\"130\" />\n" + 
			"													</td>\n" + 
			"												</tr>\n" + 
			"												\n" + 
			"												<tr>\n" + 
			"													<td>&nbsp;</td>\n" + 
			"												</tr>\n" + 
			"												<tr>\n" + 
			"													<td class=\"thompson\" align=\"center\" style=\"font-size:1.8em;color:#8c8c8c;font-family:Candara;\">Collection Made Easier</td>\n" + 
			"												</tr>\n" + 
			"												\n" + 
			"												<tr>\n" + 
			"													<td height=\"5\"></td>\n" + 
			"												</tr>\n" + 
			"												\n" + 
			"												<!--<tr>\n" + 
			"													<td align=\"center\" style=\"font-size:1.2em;color:#d70b03;font-family:Candara;\">Web Developer</td>\n" + 
			"												</tr>-->\n" + 
			"												<tr>\n" + 
			"													<td>&nbsp;</td>\n" + 
			"												</tr>\n" + 
			"												<tr>\n" + 
			"													<td class=\"ser_text\" align=\"center\" style=\"font-size:1.1em;color:#464646;line-height:1.8em;font-family:Candara;\">\n" + 
			"														We strive to provide operational ease to save cost and empower your business with technology.\n" + 
			"													</td>\n" + 
			"												</tr>\n" + 
			"													\n" + 
			"											</table>\n" + 
			"											\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"								<!-- padding-top -->\n" + 
			"									<tr>\n" + 
			"										<td class=\"ser_pad\" height=\"70\"></td>\n" + 
			"									</tr>\n" + 
			"								<!-- //padding-top -->\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr>\n" + 
			"						<td>\n" + 
			"							<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\"  style=\"border-bottom:1px solid #f7f7f7\">\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr bgcolor=\"ffffff\">\n" + 
			"						<td>\n" + 
			"							<table class=\"us_on\" border=\"0\" width=\"300\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle\">\n" + 
			"								<tr><td height=\"20\"></td></tr>\n" + 
			"								<tr>\n" + 
			"									<td>\n" + 
			"										<table class=\"follow\" width=\"100\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"											<tr>\n" + 
			"												<td style=\"color:#868283; font-size: 1.3em; font-family: Candara; text-align:left;line-height:1.6em;\">Follow us on\n" + 
			"												</td>\n" + 
			"											</tr>\n" + 
			"										</table>\n" + 
			"										<table class=\"follow\" width=\"150\" align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\">\n" + 
			"											<tr>\n" + 
			"												<td>\n" + 
			"													<table border=\"0\" width=\"100%\">\n" + 
			"														<tbody>\n" + 
			"															<tr>\n" + 
			"																<td width=\"22\">\n" + 
			"																	<a href=\"https://www.facebook.com/deAzzleapp\">\n" + 
			"																		<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/icon1.png\" width=\"22\" height=\"22\" alt=\"\">\n" + 
			"																	</a>\n" + 
			"																</td>\n" + 
			"																<td width=\"1\">\n" + 
			"																</td>\n" + 
			"																<td width=\"22\">\n" + 
			"																	<a href=\"https://twitter.com/deazzleapp\">\n" + 
			"																		<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/icon2.png\" width=\"22\" height=\"22\" alt=\"\">\n" + 
			"																	</a>\n" + 
			"																</td>\n" + 
			"																<td width=\"1\">\n" + 
			"																</td>\n" + 
			"																<td width=\"22\">\n" + 
			"																	<a href=\"https://www.linkedin.com/deazzle\">\n" + 
			"																		<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/link.jpeg\" width=\"22\" height=\"22\" alt=\"\">\n" + 
			"																	</a>\n" + 
			"																</td>\n" + 
			"																<td width=\"1\">\n" + 
			"																</td>\n" + 
			"																<!--<td width=\"22\">\n" + 
			"																	<a href=\"#\">\n" + 
			"																		<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/icon4.png\" width=\"22\" height=\"22\" alt=\"\">\n" + 
			"																	</a>\n" + 
			"																</td>\n" + 
			"																<td width=\"1\">\n" + 
			"																</td>\n" + 
			"																<td width=\"22\">\n" + 
			"																	<a href=\"#\">\n" + 
			"																		<img src=\"https://s3.ap-south-1.amazonaws.com/profile-merchant-logo/images/icon5.png\" width=\"22\" height=\"22\" alt=\"\">\n" + 
			"																	</a>\n" + 
			"																</td>-->\n" + 
			"															</tr>\n" + 
			"														</tbody>\n" + 
			"													</table>\n" + 
			"												</td>\n" + 
			"											</tr>\n" + 
			"										</table>\n" + 
			"									</td>\n" + 
			"								</tr>\n" + 
			"								<tr><td height=\"20\"></td></tr>\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"					<tr bgcolor=\"d70b03\">\n" + 
			"						<td>\n" + 
			"							<table border=\"0\" width=\"650\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container-middle\">\n" + 
			"								<tr>\n" + 
			"									<td height=\"10\" style=\"font-size: 1px; line-height: 10px;\">&nbsp;</td>\n" + 
			"								</tr>\n" + 
			"									\n" + 
			"									<tr>\n" + 
			"										<td>\n" + 
			"\n" + 
			"											<table class=\"foo\" width=\"375\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
			"												<tr>\n" + 
			"													<td class=\"ser_text editable\"style=\"font-family: Candara; font-size: 1em; color: #ffffff; line-height: 24px;\">\n" + 
			"														<!--© 2016 Innovative . All Rights Reserved | Design by <a href=\"http://w3layouts.com/\" style=\"color: #fff; font-size: 1em;text-decoration:none;\"> W3layouts</a>-->\n" + 
			"													</td>\n" + 
			"												</tr>\n" + 
			"											</table>\n" + 
			"\n" + 
			"											<!-- SPACE -->\n" + 
			"											<table width=\"1\" height=\"10\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\n" + 
			"												<tr>\n" + 
			"													<td height=\"10\" style=\"font-size: 0;line-height: 0;border-collapse: collapse;padding-left: 24px;\">\n" + 
			"														&nbsp;\n" + 
			"													</td>\n" + 
			"												</tr>\n" + 
			"											</table>\n" + 
			"											<!-- END SPACE -->\n" + 
			"\n" + 
			"											<table class=\"foo1\" width=\"170\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
			"												<tr>\n" + 
			"													<td class=\"ser_text editable\" style=\"font-family: Candara; font-size: 1em; color: #ffffff; line-height: 24px;\">\n" + 
			"\n" + 
			"														<!-- Place URL to Web Version-->\n" + 
			"														<a href=\"#\" style=\"color:#ffffff;text-decoration:none;\" data-size=\"Footer Text\" data-color=\"Footer Text\">\n" + 
			"\n" + 
			"															<!-- Change Text -->\n" + 
			"															\n" + 
			"\n" + 
			"														</a>\n" + 
			"\n" + 
			"														<!--<span data-size=\"Footer Text\" data-color=\"Footer Text\">&nbsp;&nbsp;|&nbsp;&nbsp;</span>\n" + 
			"														<a href=\"#\" style=\"color:#ffffff;text-decoration:none;\">\n" + 
			"															\n" + 
			"														</a>\n" + 
			"													</td>\n" + 
			"												</tr>\n" + 
			"											</table>\n" + 
			"\n" + 
			"										</td>\n" + 
			"									</tr>\n" + 
			"									\n" + 
			"									<tr>\n" + 
			"										<td height=\"10\" style=\"font-size: 1px; line-height: 10px;\">&nbsp;</td>\n" + 
			"									</tr>\n" + 
			"\n" + 
			"							</table>\n" + 
			"						</td>\n" + 
			"					</tr>\n" + 
			"\n" + 
			"				</table>\n" + 
			"				<table>\n" + 
			"					<tr><td class=\"top_mar\" height=\"50\"></td></tr>\n" + 
			"				</table>\n" + 
			"			</td>\n" + 
			"		</tr>\n" + 
			"	</table>\n" + 
			"</body>\n" + 
			"</html>";

}
