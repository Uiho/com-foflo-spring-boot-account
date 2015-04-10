package org.uchoi.banking.account.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uchoi.banking.account.HelloSpringBootAccount;

@SpringBootApplication
public class SpringBootAccountApplication {

    public static void main(String[] args) {
    	
        SpringApplication.run(SpringBootAccountApplication.class, args);
        
        HelloSpringBootAccount hello = new HelloSpringBootAccount();
        
    }
}
