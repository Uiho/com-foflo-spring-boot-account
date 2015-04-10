package org.uchoi.banking.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uchoi.banking.account.app.SpringBootAccountApplication;

public class HelloSpringBootAccount {
	
	private Logger logger = LoggerFactory.getLogger(SpringBootAccountApplication.class);
	
	public HelloSpringBootAccount() {
		System.out.println("##############		Print console test		############");
		logger.info("@@@@@@@@@@@@@@		Logging test		@@@@@@@@@@@@@@");
	}
}
