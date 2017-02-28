package com.bigshoulders.JUnitInAction;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class AccountTest {
	long balance;
	Account account;
	Owner owner;
	
	@Before
	public void setUp() throws Exception{
		balance=1000;
		owner= new Owner("Dave","8009 Fierro");
		account= new Account(owner,balance);
		
	}
	@Test
	public void testBalance(){
		
		assertEquals("Balance Fails",balance, account.getBalance());
	}
	@Test
	public void testCreditBalance(){
		long credit=500;
		account.creditBalance(credit);
		assertEquals("CreditBalance Fails",1500,account.getBalance());
	}
	@Test
	public void testDebitBalance(){
		long debit=500;
		account.debitBalance(debit);
		assertEquals("DebitBalance Fails",500,account.getBalance());
	}
	/*
	@Ignore
	public void testAddAccountOwner(){
		account.addOwner(Owner owner);
		assertEquals("AddAccount Owner fails",owner.getName(),account.getName());
	}
	*/

}
