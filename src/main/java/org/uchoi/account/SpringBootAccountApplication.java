package org.uchoi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.uchoi.account.view.AccountView;

@SpringBootApplication
public class SpringBootAccountApplication implements CommandLineRunner {
	
	@Autowired
	private AccountView accountView;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(this.accountView.showMainMenu());
	}
	
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAccountApplication.class, args);
    }

	
}
