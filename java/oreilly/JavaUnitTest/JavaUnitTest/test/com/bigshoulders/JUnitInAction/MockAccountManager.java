package com.bigshoulders.JUnitInAction;

import java.util.HashMap;
import java.util.Map;


public class MockAccountManager implements AccountManager {
	private Map<Owner, Account> accounts = new HashMap<Owner, Account>();

	public Account findAccountForUser(Owner owner) {
		// TODO Auto-generated method stub
		return this.accounts.get(owner);
		
	}

	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		//do nothing

	}
	public void addAccount(Owner owner, Account account){
		this.accounts.put(owner, account);
	}

}
