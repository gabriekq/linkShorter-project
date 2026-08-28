package com.mendonca.controller;


import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.mendonca.model.UrlElement;
import com.mendonca.service.UrlService;

@RestController
public class UrlShorterController {

	@Autowired
	private UrlService urlService;
		
	
	@RequestMapping(method = RequestMethod.GET,path = "/url/{address}")
	public synchronized ResponseEntity<?>  getShorterUrl(@PathVariable String address) {
		
		 UrlElement urlElement = urlService.generateShortUrl(address);
		 String body = urlService.getClickableLink(urlElement);
		 
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(body);  
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/navigate/{address}")
	public synchronized ResponseEntity<?> navigate(@PathVariable String address,Model model) {
		
		 UrlElement urlElement  =urlService.getUrlElement(address);
		 String urlPath =urlService.completeUrl(urlElement);
	
		  HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(URI.create(urlPath));
		 
	      return new ResponseEntity<>(headers, HttpStatus.FOUND);	
	}
	
	
	
	
	
}
