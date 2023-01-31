package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.ReusableMethods;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

public class TC1_LoginStep extends ReusableMethods {
	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the adactin page")
	public void user_is_on_the_adactin_page() throws FileNotFoundException, IOException {
		
	}
	@When("User should perform login {string},{string}")
	public void user_should_perform_login(String userName, String password) {
		pom.getLoginpage().login(userName, password);
	}
	
    @When("User should perform login {string},{string} with Enter Key")
	public void user_should_perform_login_with_enter_key(String userName, String password) throws AWTException {
    	pom.getLoginpage().loginWithEnter(userName, password);
	}
    @Then("User should verify after login with invalid credential error message contains {string}")
    public void user_should_verify_after_login_with_invalid_credential_error_message_contains(String expLoginErrorMsg) {
    	WebElement txtError = pom.getLoginpage().getLoginErrorMsg();
    	String getText = getText(txtError);
    	boolean b = getText.contains(expLoginErrorMsg);
    	Assert.assertTrue("verify after login with invalid credential error message contains", b);
    	
    }
    }
