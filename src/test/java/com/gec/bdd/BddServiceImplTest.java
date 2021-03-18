package com.gec.bdd;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.gec.GecApplication;
import com.gec.model.Login;
import com.gec.model.User;
import com.gec.service.UserService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
@SpringBootTest(classes=GecApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class BddServiceImplTest {
	
	Login login;
	User user;
	
	@Autowired
	UserService userService;

	@Given("^User enter his matricule {string} and password {string} $")
	public void user_enter_his_matricule_and_password (String matricule, String password) throws Throwable {
		login= new Login(matricule, password);
	}
	
	
	@When("^searching users in the data base")
	public void searching_user_in_the_database() throws Throwable{
		user = userService.login(login);
				}
	
	@Then("^The result should be {string}$")
	public void the_result_should_be(String result) {
		if (result.equals("ok")) {
			Assert.assertNotNull(user);
		}else if (result.equals("non ok")){
		    Assert.assertNull(user);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}