package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.ReusableMethods;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_CancelBookingStep extends ReusableMethods {
	PageObjectManager pom = new PageObjectManager();
	@Then("User should cancel order id")
	public void user_should_cancel_order_id() {
		 String orderId = pom.getBookingConfirmationPage().getOrderId();
		pom.getCancelbookingnPage().cancelOrderId(orderId);
	}
	@Then("User should verify after cancel booking with success message {string}")
	public void user_should_verify_after_cancel_booking_with_success_message(String expsuccessmsg) {
		WebElement aftercancelsuccessmsg = pom.getCancelbookingnPage().getAftercancelsuccessmsg();
		String actsuccessmsg = getText(aftercancelsuccessmsg);
		Assert.assertEquals("verify after cancel booking with success message", expsuccessmsg, actsuccessmsg);
	}

	@Then("User should cancel booking by using existing order id {string}")
	public void user_should_cancel_booking_by_using_existing_order_id(String orderId) {
		pom.getCancelbookingnPage().cancelOrderId(orderId);
	}
}
