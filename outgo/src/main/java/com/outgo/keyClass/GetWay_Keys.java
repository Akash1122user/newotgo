package com.outgo.keyClass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*18 July 2018 Integration multiple Payment Getway */

public class GetWay_Keys {
	
	/*public static String EASYBUZZ_SUCCESS_URL="https://smartbizapi.deazzle.in/ebsresponse";
	public static String EASYBUZZ_FAIL_URL="https://smartbizapi.deazzle.in/ebfresponse";
  */
	public static String EASYBUZZ_SUCCESS_URL="http://localhost:8082/outgo/ebsresponse";
	public static String EASYBUZZ_FAIL_URL="http://localhost:8082/outgo/ebfresponse";
  
	
	
	
	
	
	
	
	public static boolean empty(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }
	
	
	  public String clean(String s) {
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
