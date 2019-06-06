// package com.qa.persistence.repository;
//
// import java.util.Map;
//
// import javax.enterprise.inject.Alternative;
//
// import com.qa.persistence.domain.Account;
// import com.qa.util.JSONUtil;
//
// @Alternative
// public class AccountMapRepository implements AccountRepository {
//
// private Map<Integer, Account> accountMap;
//
// public String getAllAccounts() {
//
// JSONUtil util = new JSONUtil();
// return util.getJSONForObject(accountMap);
//
// }
//
// public AccountMapRepository(Map<Integer, Account> accountMap) {
// super();
// this.accountMap = accountMap;
// }
//
// public Map<Integer, Account> getAccountMap() {
// return this.accountMap;
// }
//
// public void setAccountMap(Map<Integer, Account> accountMap) {
// this.accountMap = accountMap;
// }
//
// public String createAccount(String account) {
// try {
// Account util = new JSONUtil().getObjectForJSON(account, Account.class);
// this.getAccountMap().put(util.getId(), util);
// return "Added Successfully";
//
// } catch (Exception e) {
// return e.getMessage();
// }
// }
//
// public String deleteAccount(int accountNumber) {
// try {
// if (this.getAccountMap().containsKey(accountNumber)) {
// this.getAccountMap().remove(accountNumber);
// return "Removed Successfully";
// } else {
// return "Record does not exist";
// }
//
// } catch (Exception e) {
// return e.getMessage();
// }
//
// }
//
// public String updateAccount(int accountNumber, String account) {
// try {
// Account util = new JSONUtil().getObjectForJSON(account, Account.class);
// this.getAccountMap().put(accountNumber, util);
// return "Updated Successfully";
// } catch (Exception e) {
// return e.getMessage();
// }
//
// }
//
// public int countFirstNames() {
// int counter = 0;
// for (Map.Entry<Integer, Account> entry : this.getAccountMap().entrySet()) {
// if (entry.getValue().getFirstName() != null) {
// counter++;
// }
// }
//
// return counter;
// }
//
// public int findName(String name) {
// for (Map.Entry<Integer, Account> entry : this.getAccountMap().entrySet()) {
// if (entry.getValue().getFirstName().equalsIgnoreCase(name)) {
// return (entry.getKey());
// }
// }
// return -1;
// }
//
// public int findNames(String name) {
// int counter = 0;
// for (Map.Entry<Integer, Account> entry : this.getAccountMap().entrySet()) {
// if (entry.getValue().getFirstName().equalsIgnoreCase(name)) {
// counter++;
// }
// }
// System.out.println("Found " + counter + " instances of " + name + " in map");
// return counter;
// }
//
// }
