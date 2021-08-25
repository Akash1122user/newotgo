package com.deazzle.model.easebuzzkeys;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*18 July 2018 Integration multiple Payment Getway */

public class GetWay_Keys {
	
	/*Testing*/
	
	
	
	public static String EASYBUZZ_SUCCESS_URL="https://deazzletest.deazzle.in/";
	public static String EASYBUZZ_FAIL_URL="https://deazzletest.deazzle.in/";
  
	//public static String EASYBUZZ_SUCCESS_URL="http://10.11.18.60:8081/outgo/";
	//public static String EASYBUZZ_FAIL_URL="http://10.11.18.60:8081/outgo/";
  
	/*Live*/
/*	public static String Key = "1U4AM39KIS";
	public static String Salt ="JHMBH1ZUKA";
	public static final String BaseURL = "prod";
*/	

	
	
	public static String Key = "2PBP7IABZ2";
	public static String Salt ="DAH88E3UWQ";
	public static final String BaseURL = "test";
	
	
	
	public static boolean empty(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }
	
	
	public static  String clean(String s) {
          s.trim();
          return s;
      }

	  
	  public static String Easebuzz_Generatehash512(String type, String str) {
          byte[] hashseq = str.getBytes();
          StringBuffer hexString = new StringBuffer();
          try {
              MessageDigest algorithm = MessageDigest.getInstance(type);
              algorithm.reset();
              algorithm.update(hashseq);
              byte messageDigest[] = algorithm.digest();

              for (int i = 0; i < messageDigest.length; i++) {
                  String hex = Integer.toHexString(0xFF & messageDigest[i]);
                  if (hex.length() == 1) {
                      hexString.append("0");
                  }
                  hexString.append(hex);
              }

          } catch (NoSuchAlgorithmException nsae) {
          }
          return hexString.toString();
      }
}
