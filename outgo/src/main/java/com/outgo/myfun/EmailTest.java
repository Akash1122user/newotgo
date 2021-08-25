package com.outgo.myfun;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class EmailTest {

	public static void main(String[] args) {
		
		
		String startDateString = "06/27/2007";
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		Date startDate;
		try {
		    startDate = df.parse(startDateString);
		    String newDateString = df.format(startDate);
		    System.out.println(newDateString);
		    DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
            String startDateString2 = df2.format(startDate);
            System.out.println("Date in format yyyy-MM-dd: " + startDateString2);
            
            
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	}
	
	
}
