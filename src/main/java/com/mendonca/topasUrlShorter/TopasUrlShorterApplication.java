package com.mendonca.topasUrlShorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mendonca.controller.UrlShorterController;
import com.mendonca.model.UrlElement;
import com.mendonca.repository.UrlElementRepository;
import com.mendonca.service.UrlService;
import com.mendonca.utils.Base62Utils;

@SpringBootApplication
@ComponentScan(basePackageClasses = {UrlShorterController.class,UrlService.class,Base62Utils.class})
@EnableJpaRepositories(basePackageClasses = {UrlElementRepository.class})
@EntityScan(basePackageClasses = {UrlElement.class})
public class TopasUrlShorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopasUrlShorterApplication.class, args);
	}

}
