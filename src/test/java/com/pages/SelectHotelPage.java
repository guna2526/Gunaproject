package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableMethods;

public class SelectHotelPage extends ReusableMethods {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement btnSelect;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement afterSelectSuccess;
	@FindBy(id="radiobutton_span")
	private WebElement selectErrorMsg;
	
	
	public WebElement getAfterSelectSuccess() {
		return afterSelectSuccess;
	}
	public WebElement getSelectErrorMsg() {
		return selectErrorMsg;
	}
	public WebElement getBtnSelect() {
		return btnSelect;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	public void selectHotelCommonStep() {
    elementClick(getBtnContinue());
	}
	public void selectHotelName() {
		 elementClick(getBtnSelect());
		 selectHotelCommonStep();
	}
	public void clickContinue() {
		 selectHotelCommonStep();
}
	}
