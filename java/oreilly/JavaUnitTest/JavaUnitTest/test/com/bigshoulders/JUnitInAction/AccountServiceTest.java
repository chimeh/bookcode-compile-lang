package com.bigshoulders.JUnitInAction;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AccountServiceTest {
	MockAccountManager mockAccountManager;
	Owner ownerSender;
	Owner ownerReceiver;
	Account accountSender;
	Account accountReceiver;
	
	

	@Before
	public void setUp() throws Exception{
		this.mockAccountManager = new MockAccountManager();
		this.ownerSender = new Owner("Dave", "8009Fierro");
		this.ownerReceiver= new Owner("Elsa", "300Keysonte");
		this.accountSender = new Account(ownerSender, 1000);
		this.accountReceiver = new Account(ownerReceiver, 1000);
	}
	@Test
	public void testTransferOK(){
	
	mockAccountManager.addAccount(ownerSender, accountSender);
	mockAccountManager.addAccount(ownerReceiver, accountReceiver);
	AccountService accountService = new AccountService();
	accountService.setAccountManager(mockAccountManager);
	accountService.transfer(ownerSender, ownerReceiver, 100);
	assertEquals("Sender Balance Fail", 900,accountSender.getBalance());
	assertEquals("Receiver Balance Fail",1100,accountReceiver.getBalance());
	}
	
}

