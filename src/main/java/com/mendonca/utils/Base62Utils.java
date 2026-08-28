package com.mendonca.utils;


import org.springframework.stereotype.Component;

import io.seruco.encoding.base62.Base62;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Component
public class Base62Utils {

	private Base62 base62 = Base62.createInstanceWithInvertedCharacterSet();
	
			
  
	public String encodeUrl(String originalUrl) {
		
		 try {
			byte[] urlEncodedByte = base62.encode(originalUrl.getBytes());
			String urlEncoded =  new String(urlEncodedByte,StandardCharsets.UTF_8.name());
			int endString = urlEncoded.length()/3;
			return  urlEncoded.substring(0, endString);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	  
		
	}
	
	
}
