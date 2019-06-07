package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class AccountRepoDB implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@PersistenceContext
	public void setEntityManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String createAccount(String accountJSON) {
		Account anAccount = util.getObjectForJSON(accountJSON, Account.class);
		System.out.println("error: " + anAccount);

		manager.persist(anAccount);

		return "{\"message\": \"account sucessfully added\"}";
	}

	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a", Account.class);
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String deleteAccount(int accountNumber) {
		Account anAccount = manager.find(Account.class, accountNumber);
		manager.remove(anAccount);
		return "{\"message\": \"account sucessfully removed\"}";
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String updateAccount(int accountNumber, String accountJSON) {
		Account anAccount = util.getObjectForJSON(accountJSON, Account.class);
		Account updateThisAccount = manager.find(Account.class, accountNumber);
		updateThisAccount.setFirstName(anAccount.getFirstName());
		updateThisAccount.setLastName(anAccount.getLastName());
		updateThisAccount.setAccountNumber(anAccount.getAccountNumber());
		manager.persist(updateThisAccount);
		return "{\"message\": \"account sucessfully updated\"}";
	}

}
