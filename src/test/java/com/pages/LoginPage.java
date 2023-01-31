package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableMethods;

public class LoginPage extends ReusableMethods {
	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	@FindBy(id="username")
	private WebElement txtUserName;
	@FindBy(id="password")
	private WebElement txtPassword;
	@FindBy(id="login")
	private WebElement btnLogin;
	@FindBy(className="auth_error")
	private WebElement loginErrorMsg;
	@FindBy(className="input_show")
	private WebElement loginsuccessMsg;
	
	
	public WebElement getLoginsuccessMsg() {
		return loginsuccessMsg;
	}
	public WebElement getLoginErrorMsg() {
		return loginErrorMsg;
	}
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public void loginCommonSteps(String userName,String password) {
		elementSendkeys(getTxtUserName(), userName);
		elementSendkeys(getTxtPassword(), password);
		}
	public void login(String userName,String password) {
		loginCommonSteps(userName,password);
		elementClick(getBtnLogin());
	}
	public void loginWithEnter(String userName,String password) throws AWTException {
		loginCommonSteps(userName,password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void invalidLogin(String userName,String password) {
		login(userName,password);
   }

}
