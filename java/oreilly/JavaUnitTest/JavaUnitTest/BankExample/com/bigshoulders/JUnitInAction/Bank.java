package com.bigshoulders.JUnitInAction;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	List<Account> listOfAccounts;
	
	public Bank(){
		listOfAccounts = new ArrayList<Account>();
		
	}
	public int getNumberOfAccounts(){
		return listOfAccounts.size();
	}
	public void addAccount(Account account){
		listOfAccounts.add(account);
	}
	

}
