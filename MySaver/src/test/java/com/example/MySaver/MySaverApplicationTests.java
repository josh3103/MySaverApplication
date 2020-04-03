package com.example.MySaver;


import static org.junit.jupiter.api.Assertions.assertNotNull;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MySaver.apis.CurrentAccountService;
import com.example.MySaver.apis.SaverAccountService;
import com.example.MySaver.apis.UserService;
import com.example.MySaver.entities.CurrentAccount;
import com.example.MySaver.entities.SaverAccount;
import com.example.MySaver.entities.Transaction;
import com.example.MySaver.entities.User;

//@RunAs(SpringRunner.class)
@SpringBootTest
class MySaverApplicationTests {
	
	
	@Autowired
	SaverAccount saverAccount;
	
	@Autowired
	CurrentAccount currentAccount;
	
	@Autowired
	CurrentAccountService currentAccountService;
	
	@Autowired
	SaverAccountService saverAccountService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	User user;
	
	@Autowired
	Transaction transaction;
	

	
	
	//Tests
	
	@Test
	public void addOrUpdateCurrentAccountUsingService() {
		currentAccount.setCurrentAccountId(111111);
		currentAccount.setCurrentAccountSortCode(908472);
		currentAccount.setCurrentAccountNumber(8);
		currentAccount.setCurrentAccountExpirationDate("2024");
		currentAccount.setAvailableBalance(900);
		currentAccount.setArrangedOverdraft(400);
		currentAccount = currentAccountService.registerOrUpdateCurrentAccount(currentAccount);
		assertNotNull(currentAccount);
	
	}
	
	@Test
	public void addOrUpdateSaverAccountUsingService() {
		saverAccount.setSaverAccountNo(12345);
		saverAccount.setWeeklySaver(100);
		saverAccount.setAccountName("John");
		saverAccount = saverAccountService.registerOrUpdateSaverAccount(saverAccount);
		assertNotNull(saverAccount);
	
	}
	
	/*@Test
	public void deleteSaverAccountUsingService() {
	int accountId = 2;
	SaverAccountService.deleteSaverAccountById(accountId);
	assertNull(SaverAccountService.findBySaverAccountId(accountId));
	}*/
	
	/*@Test
	public void findBySaverAccountIdUsingService() {
		int jobId = 4;
		assertNotNull(SaverAccountService.findBySaverAccountId(accountId));
	}*/
	
	@Test
	public void addOrUpdateUserUsingService() {
		user.setUserName("John");
		user.setUserPassword("password");
		user.setUserAge(25);
		user = userService.registerOrUpdateUser(user);
		assertNotNull(user);
	}
	

	
	/*@Test
	void contextLoads() {
	}*/

}
