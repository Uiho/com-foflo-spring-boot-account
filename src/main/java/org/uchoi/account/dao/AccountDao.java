package org.uchoi.account.dao;

import java.util.Map;

import org.uchoi.account.data.Account;
import org.uchoi.account.data.Customer;

public interface AccountDao {
	
	Account saveAccount(String customerName, Double initialBalance);
	Map<Integer,Account>showAllAccounts();
	Account getSpeicificAccount(Integer number);
	double deposit(Integer number, Double deposit);
	double withdraw(Integer number, Double wd);
	boolean deleteAccount(Integer number);
	boolean doesAccountExists(Integer number) ;
	Customer InsertCustomer(String name);
	Account InsertAccount(Double initialBalance, Customer customer);
	double getAccountBalance(Integer number);
	String getCustomerName(Integer CustomerId);

}
