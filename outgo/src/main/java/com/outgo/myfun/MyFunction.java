package com.outgo.myfun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gson.Gson;
import com.outgo.messages.Link;

public class MyFunction {

	public static String getOnlyDigits(String s) {
	    Pattern pattern = Pattern.compile("[^0-9]");
	    Matcher matcher = pattern.matcher(s);
	    String number = matcher.replaceAll("");
	    return number;
	 }
	 public static String getOnlyStrings(String s) {
	    Pattern pattern = Pattern.compile("[^a-z A-Z 0-9]");
	    Matcher matcher = pattern.matcher(s);
	    String number = matcher.replaceAll(" ");
	    return number;
	 }
	public static boolean isValid(String s)
	{
		// The given argument to compile() method 
		// is regular expression. With the help of 
		// regular expression we can validate mobile
		// number. 
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number 
		// and regular expression
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	
	
	public static int dateDiff(String date1) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
			Date dt1 = dateFormat.parse(date1);
			Date dt2= dateFormat.parse(date());
			 int diffInDays = (int) ((dt2.getTime() - dt1.getTime()) / (1000 * 60 * 60 * 24));
			 return diffInDays;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
        
	}
	
	public static String releaseId() {
	        Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMwWFdd");
	        String datetime = ft.format(dNow);
		return datetime;
	}
	
	public static String date() {
		    Calendar now = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(now.getTime());
	}

	
	public static String date2() {
	    Calendar now = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return dateFormat.format(now.getTime());
}

	
	public static String date3() {
	    Calendar now = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd  hh:mm:ss a");
		return dateFormat.format(now.getTime());
}

	public static String date4() {
	    Calendar now = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd");
		return dateFormat.format(now.getTime());
}
	
/*	public static String getMobileNo(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	public static void sendOTP(String mobile, String message) {
		System.out.println("Coming");
		String postData = "";
		String retval = "";
	

		URL url;
		String link=Link.SELF_SMS_LINK;
		String urlData = link.replace("<PHONE>", mobile).replace("<MSG>", message).replaceAll(" ", "%20");
		System.out.println("URL "+urlData);
		try {
			url = new URL(urlData);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("POST");
			urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlconnection.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
			out.write(postData);
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String decodedString;
			while ((decodedString = in.readLine()) != null) {
				retval += decodedString;
			}
			in.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

	public static String json(String key,String data) {
		JSONParser jp = new JSONParser();
		Object object;
		String value;
		try {
			object = jp.parse(data);
			JSONObject jso = (JSONObject) object;
			try {
				value=jso.get(key).toString();
				if(value==null)
					return "0";
				System.out.println("Value: "+value);
					return value;
			}catch(NullPointerException e) {
				return "0";
			}
		}  catch (org.json.simple.parser.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "0";
		
	}
	*/
	public static String encriptUrl(String longUrl) {
		char[] a1 = {'0','A','1','B','2','C','3','X','4','Y','5','Z','6','D','7','E','8','F','9'};
        String s="";
		char [] value=longUrl.toCharArray();
		for(int i=0;i<value.length;i++) {
			s+=a1[Integer.parseInt(value[i]+"")]+"";
		}
		return s;
	}


	public static String decriptUrl(String sortUrl) {
		char[] a1 = {'0','A','1','B','2','C','3','X','4','Y','5','Z','6','D','7','E','8','F','9'};
		String key="";	
		char [] svalue=sortUrl.toCharArray();
		for(int i=0;i<svalue.length;i++) {
			for(int j=0;j<a1.length;j++) {
				if(svalue[i]==a1[j]) {
					key+=""+j;
				}
			}

		}
		return key;
	}
	
	
	public static  boolean Email5(String email,String subject,String Email_Template_Welcome) {
		System.out.println("In Mail");

	     String[] to = {email};
	     
	     //String subject="Welcome To The OUTGO Family";

	   Properties props = System.getProperties();
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.user", "noreply@deazzle.in");
	   props.put("mail.smtp.password","R9[XKyzT8HunBP");
	   props.put("mail.smtp.port", "587");
	   props.put("mail.smtp.auth", "true"); //smtpauth.net4india.com
	   props.put("mail.smtp.socketFactory.fallback", "true");
	   Session session = Session.getDefaultInstance(props);
	   MimeMessage message = new MimeMessage(session);

	   try {
	    message.setFrom(new InternetAddress("noreply@deazzle.in"));
	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    // To get the array of addresses
	    for (int i = 0; i < to.length; i++) {
	     toAddress[i] = new InternetAddress(to[i]);
	    }

	    for (int i = 0; i < toAddress.length; i++) {
	     message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(subject);
	    message.setContent(Email_Template_Welcome, "text/html");
	    // message.setText(body);
	    Transport transport = session.getTransport("smtp");
	    System.out.println("trans ");
	    transport.connect( "smtp.gmail.com", "noreply@deazzle.in","R9[XKyzT8HunBP" );
	    System.out.println("trans1 ");
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	   } catch (AddressException ae) {
	    ae.printStackTrace();
	   } catch (MessagingException me) {
	    me.printStackTrace();
	   }
	        System.out.println("success");
	     return false;


	 }

	
	
	public static  boolean Email(String email,String subject,String Email_Template_Welcome) {

		System.out.println("In Mail Function");

	     String[] to = {email};
	     
	     //String subject="Welcome To The OUTGO Family";

	   Properties props = System.getProperties();
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.user", "noreply@deazzle.in");
	   props.put("mail.smtp.password","R9[XKyzT8HunBP");
	   props.put("mail.smtp.port", "587");
	   props.put("mail.smtp.auth", "true");
	  // props.put("mail.smtp.socketFactory.fallback", "true");
	   Session session = Session.getDefaultInstance(props);
	   MimeMessage message = new MimeMessage(session);
	   try {
	    message.setFrom(new InternetAddress("noreply@deazzle.in"));
	    InternetAddress[] toAddress = new InternetAddress[to.length];
	    	System.out.println("in try----"+message);
	    // To get the array of addresses
	    for (int i = 0; i < to.length; i++) {
	     toAddress[i] = new InternetAddress(to[i]);
	    }

	    for (int i = 0; i < toAddress.length; i++) {
	     message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(subject);
	    message.setContent(Email_Template_Welcome, "text/html");
	    System.out.println("massage data  ");
	    
	    // message.setText(body);
	    Transport transport = session.getTransport("smtp");
	    System.out.println("trans");
	    transport.connect( "smtp.gmail.com", "noreply@deazzle.in","R9[XKyzT8HunBP" );
	    System.out.println("trans1");
	    transport.sendMessage(message, message.getAllRecipients());
	    System.out.println("Mail has been sent");
	    transport.close();
	   } catch (AddressException ae) {
		   System.out.println(" Address "+ae);
	    //ae.printStackTrace();
	   } catch (MessagingException me) {
		   System.out.println(" massage "+me);
		   
	   // me.printStackTrace();
	   }
	        System.out.println("success Mail");
	     return false;


	 }
	
	
	
	public static  boolean Email2(String email,String subject,String Email_Template_Welcome) {

		System.out.println("In Mail Function");

	     String[] to = {email};
	     
	     //String subject="Welcome To The OUTGO Family";

	   Properties props = System.getProperties();
	   //props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.user", "aws022017@gmail.com");
	   props.put("mail.smtp.password","amol4609");
	   props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
	   props.put("mail.smtp.port", "465");
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.debug", "true");
	   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	  props.put("mail.smtp.socketFactory.fallback", "false");
	   Session session = Session.getDefaultInstance(props);
	   MimeMessage message = new MimeMessage(session);

	   try {
	    message.setFrom(new InternetAddress("aws022017@gmail.com"));
	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    // To get the array of addresses
	    for (int i = 0; i < to.length; i++) {
	     toAddress[i] = new InternetAddress(to[i]);
	    }

	    for (int i = 0; i < toAddress.length; i++) {
	     message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(subject);
	    message.setContent(Email_Template_Welcome, "text/html");
	    // message.setText(body);
	    Transport transport = session.getTransport("smtp");
	    System.out.println("trans ");
	    transport.connect( "smtp.gmail.com",465, "aws022017@gmail.com","amol4609" );
	    System.out.println("trans 2 ");
	    transport.sendMessage(message, message.getAllRecipients());
	    System.out.println("Mail has been sent");
	    transport.close();
	   } catch (AddressException ae) {
		   System.out.println(" Address "+ae);
	    //ae.printStackTrace();
	   } catch (MessagingException me) {
		   System.out.println(" massage "+me);
		   
	   // me.printStackTrace();
	   }
	        System.out.println("success Mail");
	     return false;


	 }
	public static  boolean Email3(String email,String subject,String Email_Template_Welcome) {

		System.out.println("In Mail Function");

	     String[] to = {email};
	     
	     //String subject="Welcome To The OUTGO Family";

	   Properties props = System.getProperties();
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.user", "aws022017@gmail.com");
	   props.put("mail.smtp.password","amol4609");
	   props.put("mail.smtp.port", "587");
	   props.put("mail.smtp.auth", "true");
	   //props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	   Session session = Session.getDefaultInstance(props);
	   MimeMessage message = new MimeMessage(session);

	   try {
	    message.setFrom(new InternetAddress("aws022017@gmail.com"));
	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    // To get the array of addresses
	    for (int i = 0; i < to.length; i++) {
	     toAddress[i] = new InternetAddress(to[i]);
	    }

	    for (int i = 0; i < toAddress.length; i++) {
	     message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(subject);
	    message.setContent(Email_Template_Welcome, "text/html");
	    // message.setText(body);
	    Transport transport = session.getTransport("smtps");
	    transport.connect( "smtp.gmail.com", "aws022017@gmail.com","amol4609" );
	    transport.sendMessage(message, message.getAllRecipients());
	    System.out.println("Mail has been sent");
	    transport.close();
	   } catch (AddressException ae) {
		   System.out.println(" Address "+ae);
	    //ae.printStackTrace();
	   } catch (MessagingException me) {
		   System.out.println(" massage "+me);
		   
	   // me.printStackTrace();
	   }
	        System.out.println("success Mail");
	     return false;


	 }
	public static  boolean Email4(String email,String subject,String Email_Template_Welcome) {

		System.out.println("In Mail Function");

	     String[] to = {email};
	     
	     //String subject="Welcome To The OUTGO Family";

	   Properties props = System.getProperties();
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com'");
	   props.put("mail.smtp.user", "noreply@deazzle.in");
	   props.put("mail.smtp.password","R9[XKyzT8HunBP");
	   props.put("mail.smtp.socketFactory.port", "587"); //SSL Port
	   props.put("mail.smtp.socketFactory.class",
	 				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
	   props.put("mail.smtp.port", "587");
	   props.put("mail.smtp.auth", "true");
	 
	   Session session = Session.getDefaultInstance(props);
	   MimeMessage message = new MimeMessage(session);

	   try {
	    message.setFrom(new InternetAddress("noreply@deazzle.in"));
	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    // To get the array of addresses
	    for (int i = 0; i < to.length; i++) {
	     toAddress[i] = new InternetAddress(to[i]);
	    }

	    for (int i = 0; i < toAddress.length; i++) {
	     message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(subject);
	    message.setContent(Email_Template_Welcome, "text/html");
	    // message.setText(body);
	    Transport transport = session.getTransport("smtp");
	    transport.connect( "smtp.gmail.com", "noreply@deazzle.in","R9[XKyzT8HunBP" );
	    transport.sendMessage(message, message.getAllRecipients());
	    System.out.println("Mail has been sent");
	    transport.close();
	   } catch (AddressException ae) {
		   System.out.println(" Address "+ae);
	    //ae.printStackTrace();
	   } catch (MessagingException me) {
		   System.out.println(" massage "+me);
		   
	   // me.printStackTrace();
	   }
	        System.out.println("success Mail");
	     return false;


	 }
	
	public static void sendSMS(String customer_mobile, String message, String sms_URL) {
		System.out.println("SMS Coming");
		String postData = "";
		String retval = "";
	

		URL url;
	
		String urlData = sms_URL.replace("<PHONE>", customer_mobile).replace("<MSG>", message).replaceAll(" ", "%20");
		System.out.println("URL "+urlData);
		try {
			url = new URL(urlData);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("POST");
			urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlconnection.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
			out.write(postData);
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String decodedString;
			while ((decodedString = in.readLine()) != null) {
				retval += decodedString;
			}
			in.close();
			System.out.println("SMS Response "+customer_mobile+":"+retval);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	
	
	/*public static String createQRImage(String qrCodeText
			) throws WriterException, IOException {
	//String qrCodeText = "https://www.journaldev.com";
		
		int size = 125;
		Hashtable hintMap = new Hashtable();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText,
				BarcodeFormat.QR_CODE, size, size, hintMap);
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth,
				BufferedImage.TYPE_INT_RGB);
		image.createGraphics();
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( image, "png", baos );
		baos.flush();
		byte[] bytes = baos.toByteArray();
		baos.close();
		
		
		
		
		
		
		

		String fileName="QR-"+Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"-"+Calendar.getInstance().get(Calendar.DATE)+"-"+System.currentTimeMillis()+".png";
		
		
			
			
				try {
					//byte[] bytes = file.getBytes();
					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();
					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath() + File.separator + "qr.png");
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					;
					System.out.println("Server File Location=" + serverFile.getAbsolutePath());
					
					String url = AWSUtil.s3Upload(serverFile.getAbsolutePath(), "qr.png", "QR", fileName);
					
					System.out.println("S3 URL=" + url);

					System.out.println("You successfully uploaded file= QR"  );
				} catch (Exception e) {
					System.out.println("You successfully Error" +e.getMessage() );
				}
				return fileName;
		
		
		//ImageIO.write(image, fileType, qrFile);
	
	}*/
	public static void sendOTP(String mobile, String message) {
		System.out.println("Coming"+message);
		String postData = "";
		String retval = "";
	

		URL url;
		String link=Link.SELF_SMS_LINK;
		String urlData = link.replace("<PHONE>", mobile).replace("<MSG>", message).replaceAll(" ", "%20");
		System.out.println("URL "+urlData);
		try {
			url = new URL(urlData);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("POST");
			urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlconnection.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
			out.write(postData);
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String decodedString;
			while ((decodedString = in.readLine()) != null) {
				retval += decodedString;
			}
			in.close();

		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println("ProtocolException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		}
	
	
			  public static String userEmail="\n" + 
			  		"<!DOCTYPE html>\n" + 
			  		"<html>\n" + 
			  		"<head>\n" + 
			  		"<title>deAzzle</title>\n" + 
			  		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
			  		"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
			  		"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" + 
			  		"<style type=\"text/css\">\n" + 
			  		"/* CLIENT-SPECIFIC STYLES */\n" + 
			  		"body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\n" + 
			  		"table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\n" + 
			  		"img { -ms-interpolation-mode: bicubic; }\n" + 
			  		"\n" + 
			  		"/* RESET STYLES */\n" + 
			  		"img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }\n" + 
			  		"table { border-collapse: collapse !important; }\n" + 
			  		"body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }\n" + 
			  		"\n" + 
			  		"/* iOS BLUE LINKS */\n" + 
			  		"a[x-apple-data-detectors] {\n" + 
			  		"    color: inherit !important;\n" + 
			  		"    text-decoration: none !important;\n" + 
			  		"    font-size: inherit !important;\n" + 
			  		"    font-family: inherit !important;\n" + 
			  		"    font-weight: inherit !important;\n" + 
			  		"    line-height: inherit !important;\n" + 
			  		"}\n" + 
			  		"\n" + 
			  		"/* MEDIA QUERIES */\n" + 
			  		"@media screen and (max-width: 480px) {\n" + 
			  		"    .mobile-hide {\n" + 
			  		"        display: none !important;\n" + 
			  		"    }\n" + 
			  		"    .mobile-center {\n" + 
			  		"        text-align: center !important;\n" + 
			  		"    }\n" + 
			  		"}\n" + 
			  		"\n" + 
			  		"/* ANDROID CENTER FIX */\n" + 
			  		"div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\n" + 
			  		"</style>\n" + 
			  		"<body style=\"margin: 0 !important; padding: 0 !important; background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n" + 
			  		"\n" + 
			  		"\n" + 
			  		"<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Open Sans, Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n" + 
			  		"\n" + 
			  		"payment of Rs.[TOTAL-PRICE] to deAzzle smartBiz has been successful.\n" + 
			  		"</div>\n" + 
			  		"\n" + 
			  		"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" + 
			  		"    <tr>\n" + 
			  		"        <td align=\"center\" style=\"background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n" + 
			  		"       \n" + 
			  		"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" + 
			  		"            <tr>\n" + 
			  		"                <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 15px;\" bgcolor=\"#fff\">\n" + 
			  		"               \n" + 
			  		"                <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\">\n" + 
			  		"                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                        <tr>\n" + 
			  		"                            <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 36px; font-weight: 800; line-height: 48px;\" class=\"mobile-center\">\n" + 
			  		"                                <!-- <h1 style=\"font-size: 36px; font-weight: 800; margin: 0; color: #ffffff;\">deAzzle</h1> -->\n" + 
			  		"                                \n" + 
			  		"                                <h1 style=\"font-size: 36px; font-weight: 800; margin: 0;\">\n" + 
			  		"                                <img alt=\"\"\n" + 
			  		"							src=\"https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png\"\n" + 
			  		"							style=\"width: 114px; height: 44px;margin-top: -7px;\">\n" + 
			  		"                                \n" + 
			  		"                                </h1>\n" + 
			  		"                                \n" + 
			  		"                            </td>\n" + 
			  		"                        </tr>\n" + 
			  		"                    </table>\n" + 
			  		"                </div>\n" + 
			  		"               \n" + 
			  		"                <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\" class=\"mobile-hide\">\n" + 
			  		"                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                        <tr>\n" + 
			  		"                            <td align=\"right\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; line-height: 48px;\">\n" + 
			  		"                                <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"right\">\n" + 
			  		"                                    <tr>\n" + 
			  		"                                        <td style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400;\">\n" + 
			  		"                                            <p style=\"font-size: 18px; font-weight: 400; margin: 0; color: #1c92d9;\"><a href=\"https://www.deazzle.in\" target=\"_blank\" style=\"color: #1b8a79; text-decoration: none;\">Pay Your  Bill Online &nbsp;</a></p>\n" + 
			  		"                                        </td>\n" + 
			  		"                                        <td style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                                            <a href=\"https://www.deazzle.in\" target=\"_blank\" style=\"color: #1c92d9; text-decoration: none;\"><img src=\"https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png\" width=\"30\" height=\"30\" style=\"display: block; border: 0px;\"/></a>\n" + 
			  		"                                        </td>\n" + 
			  		"                                    </tr>\n" + 
			  		"                                  \n" + 
			  		"                                </table>\n" + 
			  		"                            </td>\n" + 
			  		"                        </tr>\n" + 
			  		"                    </table>\n" + 
			  		"                    \n" + 
			  		"                </div>\n" + 
			  		"              \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"            <tr> <td align=\"right\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 15px; font-weight: 400; background-color:#1b8a79; line-height: 24px;     padding-right: 43px;\" ><label style=\"color:  #fff;\">Date: [T-DATE] </label> </td> </tr>\n" + 
			  		"            \n" + 
			  		"            <tr>\n" + 
			  		"                <td align=\"center\" style=\"padding: 35px 35px 20px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" + 
			  		"                              <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\n" + 
			  		"                            <!-- <img src=\"https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" /><br> -->\n" + 
			  		"                            <h2 style=\"font-size: 30px; font-weight: 800; line-height: 36px; color: #1b8a79; margin: 0;\">\n" + 
			  		"                                Thank You For Your Transaction!\n" + 
			  		"                            </h2>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px; \">\n" + 
			  		"                            <p style=\"font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;\">\n" + 
			  		"                          Dear <b>[CUSTOMER-NAME]</b>, your payment of<b> Rs.[TOTAL-PRICE] </b>to <b>[M-NAME]</b> has been <b style=\"color: green;\">successful </b>.\n" + 
			  		"\n" + 
			  		"                            </p>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"left\" style=\"padding-top: 20px;\">\n" + 
			  		"                            <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">\n" + 
			  		"                                        Order Id #\n" + 
			  		"                                    </td>\n" + 
			  		"                                    \n" + 
			  		"                                    <td  align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">\n" + 
			  		"                                        Description\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td  align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">\n" + 
			  		"                                        Price\n" + 
			  		"                                    </td>\n" + 
			  		"                                   \n" + 
			  		"\n" + 
			  		"                                </tr>\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td  align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">\n" + 
			  		"                                        [ORDER-ID]\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td  align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">\n" + 
			  		"                                          [DESCRIPTION]\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td  align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">\n" + 
			  		"                                         &#x20B9; [PRICE]\n" + 
			  		"                                    </td>\n" + 
			  		"                                   \n" + 
			  		"                                </tr>\n" + 
			  		"                                                         </table>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"left\" style=\"padding-top: 20px;\">\n" + 
			  		"                            <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\">\n" + 
			  		"                                        TOTAL\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\">\n" + 
			  		"                                         &#x20B9; [TOTAL-PRICE]\n" + 
			  		"                                    </td>\n" + 
			  		"                                </tr>\n" + 
			  		"                            </table>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"               \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"             <tr>\n" + 
			  		"                <td align=\"center\" height=\"100%\" valign=\"top\" width=\"100%\" style=\"padding: 0 35px 35px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" + 
			  		"               \n" + 
			  		"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:660px;\">\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" valign=\"top\" style=\"font-size:0;\">\n" + 
			  		"                           \n" + 
			  		"                            <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n" + 
			  		"\n" + 
			  		"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                                    <tr>\n" + 
			  		"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                                            <p style=\"font-weight: 800;\">Operator </p>\n" + 
			  		"                                            <p>Business Name: [M-NAME]<br>Mobile :[M-MOBILE]<br>Email: [M-EMAIL]</p>\n" + 
			  		"\n" + 
			  		"                                        </td>\n" + 
			  		"                                    </tr>\n" + 
			  		"                                </table>\n" + 
			  		"                            </div>\n" + 
			  		"                           \n" + 
			  		"                            <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n" + 
			  		/*"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                                    <tr>\n" + 
			  		"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                                            <p style=\"font-weight: 800;\">Download Receipt </p>\n" + 
			  		"                                            <p>\n" + 
			  		"                                            <a href=\"https://www.outgo.co/invoice-[ORDER-ID]-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;     width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 32px; background-color: #269fff; padding: 6px 21px; border: 1px solid #1b8a79; display: block;\">Download</a>\n" + 
			  		"                                            </p>\n" + 
			  		"                                        </td>\n" + 
			  		"                                    </tr>\n" + 
			  		"                                </table>\n" + */
			  		"                            [TABLE]</div>\n" + 
			  		"                        \n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"               \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"            <tr>\n" + 
			  		"                <td align=\"center\" style=\" background-color: #1b8a79;\" bgcolor=\"#1b9ba3\">\n" + 
			  		"                \n" + 
			  		"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\n" + 
			  		"                            <h2 style=\"font-size: 24px; font-weight: 800; line-height: 30px; color: #ffffff; margin: 0;\">\n" + 
			  		"                               Download deAzzle App to pay all bills\n" + 
			  		"                            </h2>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"padding: 25px 0 15px 0;\">\n" + 
			  		"                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td align=\"center\" style=\"border-radius: 5px;\" bgcolor=\"#1b8a79\">\n" + 
			  		"                                      <a href=\"https://goo.gl/ArhVms\" target=\"_blank\" style=\"font-size: 18px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #1b8a79; text-decoration: none; border-radius: 32px; background-color: #fff; padding: 15px 30px; border: 1px solid #1b8a79; display: block;\">Download</a>\n" + 
			  		"                                    </td>\n" + 
			  		"                                </tr>\n" + 
			  		"                            </table>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"              \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"            <tr   >\n" + 
			  		"                <td align=\"center\" style=\" background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" + 
			  		"               \n" + 
			  		"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\">\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 24px; padding: 5px 0 10px 0;\">\n" + 
			  		"                            <p style=\"font-size: 14px; font-weight: 800; color: #333333;\">\n" + 
			  		"                          <a href=\"https://www.facebook.com/deAzzleapp\" target=\"_blank\" > <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/facebook.png\" ></a>\n" + 
			  		"                            <a href=\"https://www.linkedin.com/company/deazzle\" target=\"_blank\" >  <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/linkedin.png\" ></a>\n" + 
			  		"                             <a href=\"https://twitter.com/deazzleapp\" target=\"_blank\" > <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/twiter.png\" ></a>\n" + 
			  		"                             <a href=\"#\" target=\"_blank\" > <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/instagram.png\" ></a>\n" + 
			  		"                              \n" + 
			  		"                            </p>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr bgcolor=\"#009add\" style=\"color: #ffffff\">\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                            <p style=\"font-size: 14px; font-weight: 400; line-height: 20px; color: #ffffff;\">\n" + 
			  		"                             © 2018 deAzzle. All Rights Reserved.\n" + 
			  		"\n" + 
			  		"\n" + 
			  		"                            </p>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"               \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"        </table>\n" + 
			  		"       \n" + 
			  		"        </td>\n" + 
			  		"    </tr>\n" + 
			  		"</table>\n" + 
			  		"    \n" + 
			  		"</body>\n" + 
			  		"</html>\n" + 
			  		"";
			  
			  public static String merchantEmail="\n" + 
			  		"<!DOCTYPE html>\n" + 
			  		"<html>\n" + 
			  		"<head>\n" + 
			  		"<title>deAzzle</title>\n" + 
			  		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
			  		"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
			  		"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" + 
			  		"<style type=\"text/css\">\n" + 
			  		"/* CLIENT-SPECIFIC STYLES */\n" + 
			  		"body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\n" + 
			  		"table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\n" + 
			  		"img { -ms-interpolation-mode: bicubic; }\n" + 
			  		"\n" + 
			  		"/* RESET STYLES */\n" + 
			  		"img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }\n" + 
			  		"table { border-collapse: collapse !important; }\n" + 
			  		"body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }\n" + 
			  		"\n" + 
			  		"/* iOS BLUE LINKS */\n" + 
			  		"a[x-apple-data-detectors] {\n" + 
			  		"    color: inherit !important;\n" + 
			  		"    text-decoration: none !important;\n" + 
			  		"    font-size: inherit !important;\n" + 
			  		"    font-family: inherit !important;\n" + 
			  		"    font-weight: inherit !important;\n" + 
			  		"    line-height: inherit !important;\n" + 
			  		"}\n" + 
			  		"\n" + 
			  		"/* MEDIA QUERIES */\n" + 
			  		"@media screen and (max-width: 480px) {\n" + 
			  		"    .mobile-hide {\n" + 
			  		"        display: none !important;\n" + 
			  		"    }\n" + 
			  		"    .mobile-center {\n" + 
			  		"        text-align: center !important;\n" + 
			  		"    }\n" + 
			  		"}\n" + 
			  		"\n" + 
			  		"/* ANDROID CENTER FIX */\n" + 
			  		"div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\n" + 
			  		"</style>\n" + 
			  		"<body style=\"margin: 0 !important; padding: 0 !important; background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n" + 
			  		"\n" + 
			  		"\n" + 
			  		"<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Open Sans, Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n" + 
			  		"\n" + 
			  		"payment of Rs.[TOTAL-PRICE] to deAzzle smartBiz has been successful.\n" + 
			  		"</div>\n" + 
			  		"\n" + 
			  		"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" + 
			  		"    <tr>\n" + 
			  		"        <td align=\"center\" style=\"background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n" + 
			  		"       \n" + 
			  		"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" + 
			  		"            <tr>\n" + 
			  		"                <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 15px;\" bgcolor=\"#fff\">\n" + 
			  		"               \n" + 
			  		"                <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\">\n" + 
			  		"                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                        <tr>\n" + 
			  		"                            <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 36px; font-weight: 800; line-height: 48px;\" class=\"mobile-center\">\n" + 
			  		"                                <!-- <h1 style=\"font-size: 36px; font-weight: 800; margin: 0; color: #ffffff;\">deAzzle</h1> -->\n" + 
			  		"                                \n" + 
			  		"                                <h1 style=\"font-size: 36px; font-weight: 800; margin: 0;\">\n" + 
			  		"                                <img alt=\"\"\n" + 
			  		"							src=\"https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png\"\n" + 
			  		"							style=\"width: 114px; height: 44px;margin-top: -7px;\">\n" + 
			  		"                                \n" + 
			  		"                                </h1>\n" + 
			  		"                                \n" + 
			  		"                            </td>\n" + 
			  		"                        </tr>\n" + 
			  		"                    </table>\n" + 
			  		"                </div>\n" + 
			  		"               \n" + 
			  		"                <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\" class=\"mobile-hide\">\n" + 
			  		"                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                        <tr>\n" + 
			  		"                            <td align=\"right\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; line-height: 48px;\">\n" + 
			  		"                                <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"right\">\n" + 
			  		"                                    <tr>\n" + 
			  		"                                        <td style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400;\">\n" + 
			  		"                                            <p style=\"font-size: 18px; font-weight: 400; margin: 0; color: #1c92d9;\"><a href=\"https://www.deazzle.in\" target=\"_blank\" style=\"color: #1b8a79; text-decoration: none;\">Pay Your  Bill Online &nbsp;</a></p>\n" + 
			  		"                                        </td>\n" + 
			  		"                                        <td style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                                            <a href=\"https://www.deazzle.in\" target=\"_blank\" style=\"color: #1c92d9; text-decoration: none;\"><img src=\"https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_sl.png\" width=\"30\" height=\"30\" style=\"display: block; border: 0px;\"/></a>\n" + 
			  		"                                        </td>\n" + 
			  		"                                    </tr>\n" + 
			  		"                                  \n" + 
			  		"                                </table>\n" + 
			  		"                            </td>\n" + 
			  		"                        </tr>\n" + 
			  		"                    </table>\n" + 
			  		"                    \n" + 
			  		"                </div>\n" + 
			  		"              \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"            <tr> <td align=\"right\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 15px; font-weight: 400; background-color:#1b8a79; line-height: 24px;     padding-right: 43px;\" ><label style=\"color:  #fff;\" >Date: [T-DATE]  </label> </td> </tr>\n" + 
			  		"            \n" + 
			  		"            <tr>\n" + 
			  		"                <td align=\"center\" style=\"padding: 35px 35px 20px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" + 
			  		"                              <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\n" + 
			  		"                            <!-- <img src=\"https://s3.ap-south-1.amazonaws.com/smartbiz-images/deazzle_ll.png.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" /><br> -->\n" + 
			  		"                            <h2 style=\"font-size: 30px; font-weight: 800; line-height: 36px; color: #1b8a79; margin: 0;\">\n" + 
			  		"                                You have received a payment of Rs.2.0 !\n" + 
			  		"                            </h2>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px; \">\n" + 
			  		"                            <p style=\"font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;\">\n" + 
			  		"                          <!-- Dear <b>[CUSTOMER-NAME]</b>, your payment of<b> Rs.[TOTAL-PRICE] </b>to <b>[M-NAME]</b> has been <b style=\"color: green;\">successful </b>. -->\n" + 
			  		"						You have received a payment of <b> Rs.[TOTAL-PRICE] </b> from <b>[NAME]</b>\n" + 
			  		"                            </p>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"left\" style=\"padding-top: 20px;\">\n" + 
			  		"                            <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">\n" + 
			  		"                                        Order Id #\n" + 
			  		"                                    </td>\n" + 
			  		"                                    \n" + 
			  		"                                    <td  align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">\n" + 
			  		"                                        Description\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td  align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\">\n" + 
			  		"                                        Price\n" + 
			  		"                                    </td>\n" + 
			  		"                                   \n" + 
			  		"\n" + 
			  		"                                </tr>\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td  align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">\n" + 
			  		"                                        [ORDER-ID]\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td  align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">\n" + 
			  		"                                          [DESCRIPTION]\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td  align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">\n" + 
			  		"                                         &#x20B9; [PRICE]\n" + 
			  		"                                    </td>\n" + 
			  		"                                   \n" + 
			  		"                                </tr>\n" + 
			  		"                                                         </table>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"left\" style=\"padding-top: 20px;\">\n" + 
			  		"                            <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\">\n" + 
			  		"                                        TOTAL\n" + 
			  		"                                    </td>\n" + 
			  		"                                    <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\">\n" + 
			  		"                                         &#x20B9; [TOTAL-PRICE]\n" + 
			  		"                                    </td>\n" + 
			  		"                                </tr>\n" + 
			  		"                            </table>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"               \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"             <tr>\n" + 
			  		"                <td align=\"center\" height=\"100%\" valign=\"top\" width=\"100%\" style=\"padding: 0 35px 35px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" + 
			  		"               \n" + 
			  		"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:660px;\">\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" valign=\"top\" style=\"font-size:0;\">\n" + 
			  		"                           \n" + 
			  		"                            <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n" + 
			  		"\n" + 
			  		"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                                    <tr>\n" + 
			  		"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                                            <p style=\"font-weight: 800;\">Customer Details</p>\n" + 
			  		"                                            <p>Customer Name: [NAME]<br> User Id:[ID] <br>Mobile :[MOBILE]<br>Email: [EMAIL]</p>\n" + 
			  		"\n" + 
			  		"                                        </td>\n" + 
			  		"                                    </tr>\n" + 
			  		"                                </table>\n" + 
			  		"                            </div>\n" + 
			  		"                           \n" + 
			  		"                            <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n" + 
			  		"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" + 
			  		"                                    <tr>\n" + 
			  		"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                                            <p style=\"font-weight: 800;\">Download Receipt </p>\n" + 
			  		"                                            <p>\n" + 
			  		"                                            <a href=\"https://smartbizapi.deazzle.in/invoice-[ORDER-ID]-smartBiz\" target=\"_blank\"  style=\"font-size: 16px;     width: 90px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #1b8a79; text-decoration: none; border-radius: 32px; background-color: #fff; padding: 6px 21px; border: 1px solid #1b8a79; display: block;\">Download</a>\n" + 
			  		"                                            </p>\n" + 
			  		"                                        </td>\n" + 
			  		"                                    </tr>\n" + 
			  		"                                </table>\n" +
			  		"                           </div>\n" + 
			  		"                        \n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"               \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"            <tr>\n" + 
			  		"                <td align=\"center\" style=\" background-color: #1b8a79;\" bgcolor=\"#1b9ba3\">\n" + 
			  		"                \n" + 
			  		"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\n" + 
			  		"                            <h2 style=\"font-size: 24px; font-weight: 800; line-height: 30px; color: #ffffff; margin: 0;\">\n" + 
			  		"                               Download deAzzle App to pay all bills\n" + 
			  		"                            </h2>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"padding: 25px 0 15px 0;\">\n" + 
			  		"                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
			  		"                                <tr>\n" + 
			  		"                                    <td align=\"center\" style=\"border-radius: 5px;\" bgcolor=\"#1b8a79\">\n" + 
			  		"                                      <a href=\"https://goo.gl/ArhVms\" target=\"_blank\" style=\"font-size: 18px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #1b8a79; text-decoration: none; border-radius: 32px; background-color: #fff; padding: 15px 30px; border: 1px solid #1b8a79; display: block;\">Download</a>\n" + 
			  		"                                    </td>\n" + 
			  		"                                </tr>\n" + 
			  		"                            </table>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"              \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"            <tr   >\n" + 
			  		"                <td align=\"center\" style=\" background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" + 
			  		"               \n" + 
			  		"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\">\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr>\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 24px; padding: 5px 0 10px 0;\">\n" + 
			  		"                            <p style=\"font-size: 14px; font-weight: 800; color: #333333;\">\n" + 
			  		"                          <a href=\"https://www.facebook.com/deAzzleapp\" target=\"_blank\" > <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/facebook.png\" ></a>\n" + 
			  		"                            <a href=\"https://www.linkedin.com/company/deazzle\" target=\"_blank\" >  <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/linkedin.png\" ></a>\n" + 
			  		"                             <a href=\"https://twitter.com/deazzleapp\" target=\"_blank\" > <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/twiter.png\" ></a>\n" + 
			  		"                             <a href=\"#\" target=\"_blank\" > <img src=\"https://s3.ap-south-1.amazonaws.com/outgo-images/social-logo/instagram.png\" ></a>\n" + 
			  		"                              \n" + 
			  		"                            </p>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                    <tr bgcolor=\"#009add\" style=\"color: #ffffff\">\n" + 
			  		"                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 24px;\">\n" + 
			  		"                            <p style=\"font-size: 14px; font-weight: 400; line-height: 20px; color: #ffffff;\">\n" + 
			  		"                            © 2018 deAzzle. All Rights Reserved.\n" + 
			  		"                            </p>\n" + 
			  		"                        </td>\n" + 
			  		"                    </tr>\n" + 
			  		"                </table>\n" + 
			  		"               \n" + 
			  		"                </td>\n" + 
			  		"            </tr>\n" + 
			  		"        </table>\n" + 
			  		"       \n" + 
			  		"        </td>\n" + 
			  		"    </tr>\n" + 
			  		"</table>\n" + 
			  		"    \n" + 
			  		"</body>\n" + 
			  		"</html>\n" + 
			  		"";
	
}
