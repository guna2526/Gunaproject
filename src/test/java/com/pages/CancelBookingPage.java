package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableMethods;

public class CancelBookingPage extends ReusableMethods {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='BookedItinerary.php']")
    private WebElement bookedItinerary;
	
	@FindBy(id="order_id_text")
	private WebElement txtidSearch;
	
	@FindBy(id="search_hotel_id")
	private WebElement SearchId;
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnCancel;
	@FindBy(id="search_result_error")
	private WebElement aftercancelsuccessmsg;

	public WebElement getAftercancelsuccessmsg() {
		return aftercancelsuccessmsg;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getTxtidSearch() {
		return txtidSearch;
	}

	public WebElement getSearchId() {
		return SearchId;
	}



	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public void cancelOrderId(String orderId) {
		elementClick(getBookedItinerary());
		elementSendkeys(getTxtidSearch(),orderId);
		elementClick(getSearchId());
		elementClick(getBtnCancel());
		alertOk();
	}

}
