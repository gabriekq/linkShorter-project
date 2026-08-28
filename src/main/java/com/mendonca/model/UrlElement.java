package com.mendonca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UrlElement {

	
	@Id
	private String shorterUrl;
	
	
	
	private String originalUrl;
	
	

	
	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShorterUrl() {
		return shorterUrl;
	}

	public void setShorterUrl(String shorterUrl) {
		this.shorterUrl = shorterUrl;
	}
	
	
	
	
}
