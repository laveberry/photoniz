package com.laveberry.photoniz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PhotonizApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotonizApplication.class, args);
	}

}
