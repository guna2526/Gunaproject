package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.ReusableMethods;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SelectHotelStep extends ReusableMethods {

	PageObjectManager pom = new PageObjectManager();
	@Then("User should select the hotel and click continue")
	public void user_should_select_the_hotel_and_click_continue() {
		pom.getSelectHotelPage().selectHotelName();
	}
	
    @Then("User should click continue without select any hotel")
	public void user_should_click_continue_without_select_any_hotel() {
		pom.getSelectHotelPage().clickContinue();
	}
	@Then("User should verify after select hotel with error message {string}")
	public void user_should_verify_after_select_hotel_with_error_message(String afterSelectErrorMsg) {
	WebElement selectErrorMsg = pom.getSelectHotelPage().getSelectErrorMsg();
	String text1 = getText(selectErrorMsg);
	Assert.assertEquals("verify after select hotel with error message", afterSelectErrorMsg, text1);
	}
}
