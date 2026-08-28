package com.mendonca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.model.UrlElement;
import com.mendonca.repository.UrlElementRepository;
import com.mendonca.utils.Base62Utils;

@Service
public class UrlService {

	@Autowired
	private UrlElementRepository  urlElementRepository;
	
	
	@Autowired
	private Base62Utils base62Utils;
	
	
	  public UrlElement generateShortUrl(String originalUrl) {
	 
	 
	  String encodedUrl=base62Utils.encodeUrl(originalUrl);
	  
	  Optional<UrlElement> UrlElementOptional =urlElementRepository.findById(encodedUrl);
	  
	  if(UrlElementOptional.isPresent()) { 
		  return UrlElementOptional.get(); 
	  }else {
	      UrlElement urlElement = new UrlElement();
	      urlElement.setShorterUrl(encodedUrl); urlElement.setOriginalUrl(originalUrl);
	    return urlElementRepository.save(urlElement);
	   }
	  
	 }
	 
	public String getClickableLink(UrlElement urlElement) {
		   String redirectPath = "/navigate/"+urlElement.getShorterUrl(); 
		   String body ="<HTML><body> <a href=\"?\">?</a></body></HTML>".replace("?", redirectPath);
		   return body;
	}
	
	
	public UrlElement getUrlElement(String encodedUrl) {
		Optional<UrlElement> UrlElementOptional =urlElementRepository.findById(encodedUrl);
		if(UrlElementOptional.isPresent()) {
			return UrlElementOptional.get();
		}else {
			return null;
		}
		
	}
	
	public String completeUrl(UrlElement urlElement) {
		
		if(!urlElement.getOriginalUrl().contains("https://")) {
			
			return "https://"+urlElement.getOriginalUrl();
		}else {
			return urlElement.getOriginalUrl();
		}
		
		
	}

	
}
