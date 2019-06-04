package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private AccountMapRepository amr = new AccountMapRepository(new HashMap<Integer, Account>());

	@Test
	public void addAccountTest() {

		Account acc1 = new Account(1, "1", "Matt", "Hunt");
		String util = new JSONUtil().getJSONForObject(acc1);
		assertEquals("Added Successfully", amr.createAccount(util));

	}

	@Test
	public void add2AccountsTest() {
		Account acc2 = new Account(2, "2", "Matty", "Huntsworth");
		Account acc1 = new Account(3, "3", "Matthew", "Hunter");
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		String util = new JSONUtil().getJSONForObject(acc1);
		assertEquals("Added Successfully", amr.createAccount(util));

	}

	@Test
	public void removeAccountTest() { //
		Account acc2 = new Account(2, "2", "Matthew", "Hunter");
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		assertEquals("Removed Successfully", amr.deleteAccount(2));
	}

	@Test
	public void remove2AccountsTest() {
		Account acc2 = new Account(2, "2", "Matty", "Huntsworth");
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		Account acc1 = new Account(3, "3", "Matthew", "Hunter");
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		assertEquals("Removed Successfully", amr.deleteAccount(2));
		assertEquals("Removed Successfully", amr.deleteAccount(3));
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		Account acc1 = new Account(1, "1", "Matt", "Hunt");
		Account acc2 = new Account(2, "2", "Matty", "Huntsworth");
		Account acc3 = new Account(3, "3", "Matthew", "Hunter");
		amr.createAccount(new JSONUtil().getJSONForObject(acc3));
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		assertEquals("Removed Successfully", amr.deleteAccount(2));
		assertEquals("Removed Successfully", amr.deleteAccount(3));
		assertEquals("Record does not exist", amr.deleteAccount(4));
		// assertEquals("Record does not exist", amr.deleteAccount(2));
	}

	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality f
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}
