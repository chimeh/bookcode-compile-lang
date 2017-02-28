package com.bigshoulders.JUnitInAction;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
	Bank bank;
	Account account;
	Owner owner;
	long balance;

	@Before
	public void setUp() throws Exception {
		balance=1000;
		bank=new Bank();
		owner= new Owner("Dave","8009 Fierro");
		account= new Account(owner,balance);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testAddAccount(){
		bank.addAccount(account);
		assertEquals("AddAcount Fails",1,bank.getNumberOfAccounts());
		
		
		
	}
	@Test
	public void testAddMultipleAccounts(){
		bank.addAccount(account);
		bank.addAccount(account);
		bank.addAccount(account);
		assertEquals("AddMultipleAccounts Fails",3,bank.getNumberOfAccounts());
	}

}
