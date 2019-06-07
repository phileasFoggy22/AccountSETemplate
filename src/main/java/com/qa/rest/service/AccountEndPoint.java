package com.qa.rest.service;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path(value = "/account")
public class AccountEndPoint {
	@Inject
	private AccountService aSI;

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return aSI.createAccount(account);
	}

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return aSI.getAllAccounts();
	}

	@Path("/deleteAccount/{accountNumber}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("accountNumber") int accountNumber) {
		return aSI.deleteAccount(accountNumber);
	}

	@Path("/updateAccount/{accountNumber}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("accountNumber") int accountNumber, String account) {
		return aSI.updateAccount(accountNumber, account);
	}

	public void setaSI(AccountService aSI) {
		this.aSI = aSI;
	}
}
