package com.deazzle.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;




public class deAzzleAPIS {
	
	static String deazzleurl="http://35.154.230.245/api/v2.0/";
	
	
	//static String deazzleurl="http://ec2-13-126-249-211.ap-south-1.compute.amazonaws.com/api/v2.0/";
	public static String smartbiz="https://smartbiztest.deazzle.in/";
	
	
	//String deazzleurl="http://ec2-13-126-249-211.ap-south-1.compute.amazonaws.com/api/v2.0/";
	
	
	
	public static String sendGet(String authorization,String url) throws Exception,IOException {
		

		// url = "http://35.154.230.245/api/v2.0/"+url;
		 
		url=deazzleurl+url;
		System.out.println(url);
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("Authorization", "Bearer "+authorization);
		con.setRequestProperty("ClientId", "FyDQdh4qTXMSKnwVqyMNholYdpEa");
		con.setRequestProperty("Content-Type", "application/json");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println("deazzle Response   : "+response.toString());
		Gson g=new Gson();
		Data d=g.fromJson(response.toString(), Data.class);
		if(d.getResultCode().equals("Success"))
	    return response.toString();
		else
			return "Failure";
		//print result

	}
	
	
	
	// HTTP POST request
	public static String sendPost(String authorization,String url,String data,String method) throws Exception {

		System.out.println(data);
		

		try {
		 //url = "http://35.154.230.245/api/v2.0/"+url;

		 url=deazzleurl+url;
		 System.out.println(url);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(method);
		con.setRequestProperty("Authorization", "Bearer "+authorization);
		con.setRequestProperty("ClientId", "FyDQdh4qTXMSKnwVqyMNholYdpEa");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		//String data = "{\"search_criteria\":{\"RelationArray\":[{\"r1\":{\"type\":\"payment\"}}],\"NodeArray\":[{\"n1\":\"\"},{\"n2\":\"business\"}],\"Expression\":\"n2.object_id in [ '6b88f326-8131-11e8-be23-02014ca403d2' ] and r1.payment_status='Success'\",\"Return\":[\"r1.payment_date as Payment_date\",\"r1.payment_date as Payment_end_date\",\"r1.amount_paid as AMOUNT\",\"r1.payment_mode as Payment_mode\",\"n1.name[0] as Name\",\"n1.f_name as FirstName\",\"n1.l_name as LastName\",\"n2.name[0] as Business\",\"r1.transaction_id as Transaction_id\",\"r1.invoice_id as Invoice_id\",\"n1.image as person_image\",\"n1.phone_number as person_phone_number\"],\"Limit\":\"2\",\"OrderBy\":\"r1.payment_date desc\"}}";		
		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(data);
		
		wr.flush();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("deazzle Response   : "+response.toString());
			Gson g=new Gson();
			Data d=g.fromJson(response.toString(), Data.class);
			if(d.getResultCode().equals("Success"))
		    return response.toString();
			else
				return "Failure";
		} else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED){
			return "401";
		} {
			System.out.println("POST request not worked");
			return "404";
		}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("POST request not worked");

		return "404";
		
		
		}

	// HTTP POST request
	public static String publicsearch(String authorization,String url,String data,String method) throws Exception {

		System.out.println(data);
		

		try {
		 //url = "http://35.154.230.245/api/v2.0/"+url;

		 url=deazzleurl+url;
		 System.out.println(url);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(method);
		con.setRequestProperty("Public", authorization);
		con.setRequestProperty("ClientId", "FyDQdh4qTXMSKnwVqyMNholYdpEa");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		//String data = "{\"search_criteria\":{\"RelationArray\":[{\"r1\":{\"type\":\"payment\"}}],\"NodeArray\":[{\"n1\":\"\"},{\"n2\":\"business\"}],\"Expression\":\"n2.object_id in [ '6b88f326-8131-11e8-be23-02014ca403d2' ] and r1.payment_status='Success'\",\"Return\":[\"r1.payment_date as Payment_date\",\"r1.payment_date as Payment_end_date\",\"r1.amount_paid as AMOUNT\",\"r1.payment_mode as Payment_mode\",\"n1.name[0] as Name\",\"n1.f_name as FirstName\",\"n1.l_name as LastName\",\"n2.name[0] as Business\",\"r1.transaction_id as Transaction_id\",\"r1.invoice_id as Invoice_id\",\"n1.image as person_image\",\"n1.phone_number as person_phone_number\"],\"Limit\":\"2\",\"OrderBy\":\"r1.payment_date desc\"}}";		
		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(data);
		
		wr.flush();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("deazzle Response   : "+response.toString());
			Gson g=new Gson();
			Data d=g.fromJson(response.toString(), Data.class);
			if(d.getResultCode().equals("Success"))
		    return response.toString();
			else
				return "Failure";
		} else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED){
			return "401";
		} {
			System.out.println("POST request not worked");
			return "404";
		}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("POST request not worked");

		return "404";
		
		
		}

}
