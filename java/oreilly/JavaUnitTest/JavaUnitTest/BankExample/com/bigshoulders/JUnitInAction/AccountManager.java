package com.bigshoulders.JUnitInAction;

public interface AccountManager {
	Account findAccountForUser(Owner owner);
	void updateAccount(Account account);

}
