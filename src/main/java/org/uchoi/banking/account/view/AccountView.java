package org.uchoi.banking.account.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uchoi.banking.account.service.AccountService;

@Component
public class AccountView {
	@Autowired
	private AccountService accountService;
	
}
