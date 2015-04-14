package org.uchoi.account.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.xml.ws.ResponseWrapper;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.uchoi.account.data.Account;
import org.uchoi.account.data.Customer;
import org.uchoi.account.mapper.AccountMapper;
import org.uchoi.account.view.AccountView;

@Repository
@Transactional
@Component("accountDao")
public class AccountDaoImpl implements AccountDao {
	
	private Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@PostConstruct  
	public void initialize(){
		//this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("Inside @PostConstruct after bean initialization");
	}

	public AccountDaoImpl() {
		logger.info("Inside AccountDao Constructor");
	}

	@Override
	public Account saveAccount(String name, Double initialBalance){
		InsertAccount(initialBalance, InsertCustomer(name));
		logger.info("You've Finished creating a bank account for " + name);
		return null;
	}

	@Override
	public Map<Integer, Account> showAllAccounts() {
		logger.info("You've Required Dao showAllAccounts");
		ShowAllAccountsByJdbc();
		return null;
	}

	@Override
	public Account getSpeicificAccount(Integer number) {
		Account account = new Account();
		return account;
	}

	@Override
	public double deposit(Integer number, Double deposit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdraw(Integer number, Double wd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteAccount(Integer number) {

		return false;
	}

	@Override
	public boolean doesAccountExists(Integer number) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Customer InsertCustomer(String name) {
		Customer customer = new Customer(name);
		entityManager.persist(customer);
		return customer;
	}

	public Account InsertAccount(Double initialBalance, Customer customer) {
		Account account = new Account(initialBalance, customer);
		entityManager.persist(account);
		return account;
	}

	@Override
	public double getAccountBalance(Integer number) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCustomerName(Integer CustomerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void ShowAllAccountsByJdbc(){
		String SQL  = "SELECT account_id, Account.customer_id, customer_name, account_balance "
				+ " FROM Account "
				+ " JOIN Customer "
				+ " ON Account.customer_id = Customer.customer_id "
				+ " ORDER BY Account_id ASC"; //DESC, ASC
		List<Account> accounts = jdbcTemplate.query(SQL, new AccountMapper());
		for (Account account : accounts) {
			showAccountDetails(account);
		}
	}
	public void showAccountDetails(Account account){
		System.out.print(account.getAccountId()+"  ");
		System.out.print(account.getCustomer().getCustomerId()+"  ");
		System.out.print(account.getCustomer().getCustomerName()+"  ");
		System.out.println(account.getAccountBalance());
	}
	
	

}
