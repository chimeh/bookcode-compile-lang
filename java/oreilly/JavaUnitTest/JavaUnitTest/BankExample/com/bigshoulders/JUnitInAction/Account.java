package com.bigshoulders.JUnitInAction;

public class Account {

	 long balance;
	 Owner owner;
	public Account(Owner owner,long balance){
		this.balance=balance;
		this.owner= owner;
		
		
		
	}
	public long getBalance(){
		return balance;
	}
	public void creditBalance(long credit){
		this.balance+=credit;
	}
	public void debitBalance(long debit){
		this.balance-=debit;
	}
	public String getName(){
		return owner.getName();
	}

}
