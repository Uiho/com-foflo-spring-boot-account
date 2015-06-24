package org.foflo.account.service;

import java.util.Map;

import org.foflo.account.data.Account;

public interface AccountService {
	
	Account saveAccount(String customerName, Double initialBalance);
	Map<Integer,Account> showAllAccounts();
	Account getSpecificAccount(Integer number);
	double deposit(Integer number, Double deposit) ;
	double withdraw(Integer number, Double wd) ;
	boolean deleteAccount(Integer number) ;
	boolean doesAccountExists(Integer number);

}
