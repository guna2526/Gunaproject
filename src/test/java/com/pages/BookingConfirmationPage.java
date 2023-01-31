package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableMethods;

public class BookingConfirmationPage extends ReusableMethods {
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
    private WebElement orderNo;	
	
	public WebElement getOrderNo() {
		return orderNo;
	}
	
	public String getOrderId() {
	String orderId = elementGetAttribute(getOrderNo());
	return orderId;
	}
}
