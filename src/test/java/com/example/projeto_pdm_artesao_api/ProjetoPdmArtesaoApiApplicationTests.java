package com.example.projeto_pdm_artesao_api;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.projeto_pdm_artesao_api.Service.BCryptService;

@SpringBootTest
class ProjetoPdmArtesaoApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void bCryptService() {
		String password = "12345678";
		String hashedPassword = BCryptService.encode(password);
		boolean bool = false;
		System.out.println("Password: " + password);
		System.out.println("Hashed password: " + hashedPassword);
		bool = BCryptService.matches(password, hashedPassword);
		System.out.println("Password matches hash: " + bool);
		if (bool == false) {
			fail("Password is supposed to match its hash. Something has gone wrong in BCryptService.matches()");
		}
		bool = BCryptService.matches(password, "açldfhçasdgpy1g2--4942");
		System.out.println("password matches random invalid hash: " + bool);
		if (bool == true) {
			fail("Password cannot match random invalid hash. Something has gone wrong in BCryptService.matches()");
		}
	}
}
