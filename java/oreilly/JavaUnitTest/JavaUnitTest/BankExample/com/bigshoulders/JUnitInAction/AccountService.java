package com.bigshoulders.JUnitInAction;

public class AccountService {
	private AccountManager accountManager;
	public void setAccountManager(AccountManager manager){
		this.accountManager=manager;
		
	}
	public void transfer(Owner sender, Owner receiver, long amount){
		Account accountSender= this.accountManager.findAccountForUser(sender);
		Account accountReceiver= this.accountManager.findAccountForUser(receiver);
		accountSender.debitBalance(amount);
		accountReceiver.creditBalance(amount);
		this.accountManager.updateAccount(accountSender);
		this.accountManager.updateAccount(accountReceiver);
		
	}

}
