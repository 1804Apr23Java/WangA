package com.revature.java.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class JDBCTest {
	
	@Test
	void testGetAccounts() {
		User a = new User("200","password");
		Account acct1 = new Account("200","100",200);
		Account acct2 = new Account("200","111",30);
		assertEquals(acct1, UserDaoImpl.getAccounts(a).get(1));
	}

}
