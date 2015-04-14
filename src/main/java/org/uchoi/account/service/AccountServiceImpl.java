package org.uchoi.account.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uchoi.account.dao.AccountDao;
import org.uchoi.account.data.Account;

@Component("accountService")
public class AccountServiceImpl implements AccountService{
	
	private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountDao accountDao;

	public AccountServiceImpl() {
		logger.info("Inside AccountService Constructor");
	}

	@Override
	public Account saveAccount(String customerName, Double initialBalance) {
		accountDao.saveAccount(customerName, initialBalance);
		return null;
	}

	@Override
	public Map<Integer, Account> showAllAccounts() {
		accountDao.showAllAccounts();
		return null;
	}

	@Override
	public Account getSpecificAccount(Integer number) {
		Account account = accountDao.getSpeicificAccount(number);
		return account;
	}

	@Override
	public double deposit(Integer number, Double deposit) {
		accountDao.deposit(number, deposit);
		return 0;
	}

	@Override
	public double withdraw(Integer number, Double wd) {
		accountDao.withdraw(number, wd);
		return 0;
	}

	@Override
	public boolean deleteAccount(Integer number) {
		accountDao.deleteAccount(number);
		return false;
	}

	@Override
	public boolean doesAccountExists(Integer number) {
		accountDao.doesAccountExists(number);
		return false;
	}
	
	
	

}
