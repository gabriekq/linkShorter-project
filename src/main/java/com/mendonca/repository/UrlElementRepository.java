package com.mendonca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.model.UrlElement;

@Repository
public interface UrlElementRepository extends JpaRepository<UrlElement, String> {

	
	public Optional<UrlElement> findById(String id);
	
	
	
}
