package com.qa.MapTests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.AccountRepository;
import com.qa.persistence.repository.AccountServiceDB;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private AccountRepository amr;
	private Account acc1;
	private Account acc2;
	private Account acc3;
	private String test;
	int counter;

	private AccountServiceDB adbr;

	@Before
	public void start() {
		amr = new AccountMapRepository(new HashMap<Integer, Account>());
		acc1 = new Account(1, "1", "Matt", "Hunt");
		acc2 = new Account(2, "2", "Matty", "Huntsworth");
		acc3 = new Account(3, "3", "Matthew", "Hunter");
		test = "{\"id\":2,\"accountNumber\":\"2\",\"firstName\":\"Matty\",\"lastName\":\"Huntsworth\"}";
		counter = 0;
		setAdbr(new AccountServiceDB());
	}

	@Test
	public void addAccountTest() {
		System.out.println(new JSONUtil().getJSONForObject(acc1));
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		assertEquals(true, amr.getAccountMap().containsKey((Integer) 1));

		// adbr.createAccount(new JSONUtil().getJSONForObject(acc1));
	}

	@Test
	public void add2AccountsTest() {

		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		assertEquals(true, amr.getAccountMap().containsKey((Integer) 1));
		assertEquals(true, amr.getAccountMap().containsKey((Integer) 2));

	}

	@Test
	public void removeAccountTest() {

		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		amr.deleteAccount(2);
		assertEquals(false, amr.getAccountMap().containsKey((Integer) 2));
	}

	@Test
	public void remove2AccountsTest() {

		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		amr.deleteAccount(1);
		amr.deleteAccount(2);
		assertEquals(false, amr.getAccountMap().containsKey((Integer) 1));
		assertEquals(false, amr.getAccountMap().containsKey((Integer) 2));
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		amr.deleteAccount(1);
		amr.deleteAccount(2);
		assertEquals("Record does not exist", amr.deleteAccount(4));
	}

	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil

		Account util = new JSONUtil().getObjectForJSON(test, Account.class);
		assertEquals(2, util.getId());
	}

	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil

		assertEquals(test, new JSONUtil().getJSONForObject(acc2));

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {

		assertEquals(0, amr.countFirstNames());

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		assertEquals(1, amr.countFirstNames());
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		assertEquals(2, amr.countFirstNames());
	}

	@Test
	public void findMapEntryWhereNameIsMatty() {

		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		amr.createAccount(new JSONUtil().getJSONForObject(acc3));
		assertEquals(2, amr.findName("Matty"));

	}

	@Test
	public void findNumberOfMattsInMap() {
		amr.createAccount(new JSONUtil().getJSONForObject(acc1));
		amr.createAccount(new JSONUtil().getJSONForObject(acc2));
		amr.createAccount(new JSONUtil().getJSONForObject(acc3));
		assertEquals(1, amr.findName("Matt"));
	}

	// @Test
	// public void invalidAccountNumber() {
	//
	// Account acc4 = new Account(9999, "9999", "Mat", "Huntington");
	// assertEquals("{\"message\": \"This account is blocked\"}",
	// amr.createAccount(new JSONUtil().getJSONForObject(acc4)));
	// }

	public AccountServiceDB getAdbr() {
		return adbr;
	}

	public void setAdbr(AccountServiceDB adbr) {
		this.adbr = adbr;
	}
}
