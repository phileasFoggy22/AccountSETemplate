package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountService {

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	public String createAccount(String account) {
		if (account.contains("9999")) {
			return "{\"message\": \"This account is blocked\"}";

		} else {
			return repo.createAccount(account);
		}
	}

	public String deleteAccount(int accountNumber) {

		return repo.deleteAccount(accountNumber);
	}

	public String updateAccount(int accountNumber, String account) {

		return repo.updateAccount(accountNumber, account);
	}

}
