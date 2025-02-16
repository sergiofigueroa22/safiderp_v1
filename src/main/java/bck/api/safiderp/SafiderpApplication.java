package bck.api.safiderp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {
		"bck.api.safiderp.config",
		"bck.api.safiderp.core.exception",
	    "bck.api.safiderp.manage.controller",
	    "bck.api.safiderp.manage.service",
	    "bck.api.safiderp.manage.repository"
	})
public class SafiderpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafiderpApplication.class, args);
	}
	
}
