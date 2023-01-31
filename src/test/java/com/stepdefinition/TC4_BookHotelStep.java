package com.stepdefinition;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.ReusableMethods;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_BookHotelStep extends ReusableMethods {
	PageObjectManager pom = new PageObjectManager();
	@Then("User should book hotel {string},{string} and {string}")
	public void user_should_book_hotel_and(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	pom.getBookHotelPage().book(firstName, lastName, address);
	List<List<String>> card = dataTable.asLists();
	List<String> l = card.get(2);
	String ccNo = l.get(0);
	String ccType = l.get(1);
	String expiryMonth = l.get(2);
	String expiryYear = l.get(3);
	String cvvNo = l.get(4);
	WebElement txtcardno = pom.getBookHotelPage().getTxtCardNo();
	elementSendkeys(txtcardno, ccNo);

	WebElement txtCardType = pom.getBookHotelPage().getDdCardType();
	elementSendkeys(txtCardType, ccType);

	WebElement txtExpiryMonth = pom.getBookHotelPage().getDdExpiryMonth();
	elementSendkeys(txtExpiryMonth, expiryMonth);

	WebElement txtExpiryYear = pom.getBookHotelPage().getDdExpiryYear();
	elementSendkeys(txtExpiryYear, expiryYear);

	WebElement txtCVVNo = pom.getBookHotelPage().getTxtCvvNo();
	elementSendkeys(txtCVVNo, cvvNo);
    pom.getBookHotelPage().clickBookNow();
//	pom.getBookHotelPage().BookHotel(firstName, lastName, address);
	Thread.sleep(7000);
	}
	@Then("User should verify after book hotel with success message {string}")
	public void user_should_verify_after_book_hotel_with_success_message(String expbookingsuccessmsg) {
	WebElement bookingSuccess = pom.getBookHotelPage().getBookingSuccess();
	String actbookingsuccessmsg = getText(bookingSuccess);
	Assert.assertEquals("verify after book hotel with success message", expbookingsuccessmsg, actbookingsuccessmsg);
	}

	@Then("User should click book now by without entering any fields")
	public void user_should_click_book_now_by_without_entering_any_fields() {
	    pom.getBookHotelPage().clickBookNow();
    }
	@Then("User should verify after book hotel with error message {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_book_hotel_with_error_message_and(String expfirstnameError, String explastnameError, String expaddressError, String expcardnoError, String expcardtypeError, String expexpiryError, String expcvvError) {
	WebElement fNErrorMsg = pom.getBookHotelPage().getFirstNameErrorMsg();
	String actfirstnameError = getText(fNErrorMsg);
	Assert.assertEquals("verify after book hotel with error message", expfirstnameError, actfirstnameError);
	
	WebElement lnErrorMsg = pom.getBookHotelPage().getLastNameErrorMsg();
	String actlastnameError = getText(lnErrorMsg);
	Assert.assertEquals("verify after book hotel with error message", explastnameError, actlastnameError);
	
	WebElement addressErrorMsg = pom.getBookHotelPage().getAddressErrorMsg();
	String actaddresserror = getText(addressErrorMsg);
	Assert.assertEquals("verify after book hotel with error message", expaddressError, actaddresserror);
	
	WebElement cardNoErrorMsg = pom.getBookHotelPage().getCardNoErrorMsg();
	String actcarderror = getText(cardNoErrorMsg);
	Assert.assertEquals("verify after book hotel with error message", expcardnoError, actcarderror);

    WebElement cardTypeErrorMsg = pom.getBookHotelPage().getCardTypeErrorMsg();
    String actcardtypeerror = getText(cardTypeErrorMsg);
    Assert.assertEquals("verify after book hotel with error message", expcardtypeError, actcardtypeerror);

    WebElement expiryErrorMsg = pom.getBookHotelPage().getExpiryErrorMsg();
    String actexpiryerror = getText(expiryErrorMsg);
    Assert.assertEquals("verify after book hotel with error message", expexpiryError, actexpiryerror);
    
    WebElement cvvErrorMsg = pom.getBookHotelPage().getCvvErrorMsg();
    String actcvverror = getText(cvvErrorMsg);
    Assert.assertEquals("verify after book hotel with error message", expcvvError, actcvverror);


	}







}
