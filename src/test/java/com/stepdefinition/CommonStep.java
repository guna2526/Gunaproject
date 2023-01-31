package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.ReusableMethods;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStep extends ReusableMethods {
	PageObjectManager pom = new PageObjectManager();
 
	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String exploginsuccessmsg) {
		WebElement loginsuccessMsg = pom.getLoginpage().getLoginsuccessMsg();
		String actloginsuccessmsg = elementGetAttribute(loginsuccessMsg,"value");
	Assert.assertEquals("verify after login success message", exploginsuccessmsg, actloginsuccessmsg);
	}
	@Then("User should verify after select hotel with success message {string}")
	public void user_should_verify_after_select_hotel_with_success_message(String afterSelectSuccessMsg) {
	WebElement afterSelectSuccess = pom.getSelectHotelPage().getAfterSelectSuccess();
	String text = getText(afterSelectSuccess);
	Assert.assertEquals("verify after select hotel with success message", afterSelectSuccessMsg, text);
	}
    }
