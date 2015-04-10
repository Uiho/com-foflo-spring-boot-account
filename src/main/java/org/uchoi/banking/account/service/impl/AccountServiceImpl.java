package org.uchoi.banking.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uchoi.banking.account.dao.AccountDao;

@Component
public class AccountServiceImpl {
	@Autowired
	private AccountDao accountDao;
	
}
