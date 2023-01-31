package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.ReusableMethods;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends ReusableMethods {

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_hotel_and(String location, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrensPerRoom) {
	pom.getSearchHotelPage().searchHotel(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrensPerRoom);
	}
	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String aftersearchHotelSuccessMsg) {
		WebElement afterSearchSuccess = pom.getSearchHotelPage().getAfterSearchSuccess();
		String text = getText(afterSearchSuccess);
		boolean s = text.contains(aftersearchHotelSuccessMsg);
		Assert.assertTrue("verify after search hotel success message",s);
	}

	
	@Then("User should search only mandatory fields {string},{string},{string},{string} and {string}")
	public void user_should_search_only_mandatory_fields_and(String location, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().SearchHotelMantatoryFields(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}
    @Then("User should verify after search hotel with invalid date error message {string} and {string}")
	public void user_should_verify_after_search_hotel_with_invalid_date_error_message_and(String dateInError, String dateOutError) {
    	WebElement checkInError = pom.getSearchHotelPage().getCheckInError();
    	String gettext = getText(checkInError);
    	boolean d1 = gettext.contains(dateInError);
    	Assert.assertTrue("verify after search hotel with invalid datein error message",d1);
    	WebElement checkOutError = pom.getSearchHotelPage().getCheckInError();
    	String gettext1 = getText(checkInError);
    	boolean d2 = gettext.contains(dateInError);
    	Assert.assertTrue("verify after search hotel with invalid dateout error message",d2);
	}
	
	@Then("User should search hotel without enter any fields")
	public void user_should_search_hotel_without_enter_any_fields() {
		pom.getSearchHotelPage().searchButton();
		
	}
	@Then("User should verify after search hotel error message {string}")
	public void user_should_verify_after_search_hotel_error_message(String locationErrorMsg) {
		WebElement locError = pom.getSearchHotelPage().getLocError();
	    String gettext = getText(locError);
	    boolean l = gettext.contains(locationErrorMsg);
	    Assert.assertTrue("verify after search hotel error message",l);
	
	}











	
}
