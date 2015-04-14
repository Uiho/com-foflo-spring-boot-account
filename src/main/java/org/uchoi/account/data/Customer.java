package org.uchoi.account.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import scala.unchecked;


@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id",unique=true, nullable=false)
	private Integer customerId;
	
	@Column(name="customer_name",nullable=false)
	private String customerName;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
	private Set<Account> accounts = new HashSet<Account>();
	

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public Customer(Integer customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
