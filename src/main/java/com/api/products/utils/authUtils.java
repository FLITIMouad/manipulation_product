package com.api.products.utils;
import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;

public final class authUtils {
    
    public static final String LOGNAME="test";
    public static final String PASSWORD="test";
  public static   String ConveteToBase64(String username, String password){
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64( 
				auth.getBytes(Charset.forName("US-ASCII")));
		return new String(encodedAuth);
	 }
}
