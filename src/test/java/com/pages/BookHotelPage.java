package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableMethods;

public class BookHotelPage extends ReusableMethods {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="first_name")
private WebElement txtFirstName;
@FindBy(id="last_name")
private WebElement txtLastName;
@FindBy(id="address")
private WebElement txtAddress;
@FindBy(id="cc_num")
private WebElement txtCardNo;
@FindBy(id="cc_type")
private WebElement ddCardType;
@FindBy(id="cc_exp_month")
private WebElement ddExpiryMonth;
@FindBy(name="cc_exp_year")
private WebElement ddExpiryYear;
@FindBy(name="cc_cvv")
private WebElement txtCvvNo;
@FindBy(id="book_now")
private WebElement btnBook;
@FindBy(xpath="//td[text()='Booking Confirmation ']")
private WebElement bookingSuccess;

@FindBy(id="first_name_span")
private WebElement firstNameErrorMsg;
@FindBy(id="last_name_span")
private WebElement lastNameErrorMsg;
@FindBy(id="address_span")
private WebElement addressErrorMsg;
@FindBy(id="cc_num_span")
private WebElement cardNoErrorMsg;
@FindBy(id="cc_type_span")
private WebElement cardTypeErrorMsg;
@FindBy(id="cc_expiry_span")
private WebElement expiryErrorMsg;
@FindBy(id="cc_cvv_span")
private WebElement cvvErrorMsg;
public WebElement getBookingSuccess() {
	return bookingSuccess;
}

public WebElement getFirstNameErrorMsg() {
	return firstNameErrorMsg;
}

public WebElement getLastNameErrorMsg() {
	return lastNameErrorMsg;
}

public WebElement getAddressErrorMsg() {
	return addressErrorMsg;
}

public WebElement getCardNoErrorMsg() {
	return cardNoErrorMsg;
}

public WebElement getCardTypeErrorMsg() {
	return cardTypeErrorMsg;
}

public WebElement getExpiryErrorMsg() {
	return expiryErrorMsg;
}

public WebElement getCvvErrorMsg() {
	return cvvErrorMsg;
}


public WebElement getTxtFirstName() {
	return txtFirstName;
}
public WebElement getTxtLastName() {
	return txtLastName;
}
public WebElement getTxtAddress() {
	return txtAddress;
}
public WebElement getTxtCardNo() {
	return txtCardNo;
}
public WebElement getDdCardType() {
	return ddCardType;
}
public WebElement getDdExpiryMonth() {
	return ddExpiryMonth;
}
public WebElement getDdExpiryYear() {
	return ddExpiryYear;
}
public WebElement getTxtCvvNo() {
	return txtCvvNo;
}
public WebElement getBtnBook() {
	return btnBook;
}
public void bookHotelCommonStep() {
	elementClick(getBtnBook());
}
public void book(String firstName,String lastName,String address) {
	elementSendkeys(getTxtFirstName(), firstName);
	elementSendkeys(getTxtLastName(), lastName);
	elementSendkeys(getTxtAddress(), address);
	bookHotelCommonStep();
}
public void clickBookNow() {
	 bookHotelCommonStep();
}

}
