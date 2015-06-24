package org.foflo.account.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.foflo.account.data.Account;
import org.foflo.account.data.Customer;
import org.springframework.jdbc.core.RowMapper;



public class AccountMapper implements RowMapper<Account>{

	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account(rs.getInt("account_id"),
									rs.getDouble("account_balance"),
									new Customer(rs.getInt("customer_id"),rs.getString("customer_name")));
		return account;
	}

}
