package com.tr.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
	
	
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[2]/div[2]/div/a[1]/span[1]")
	WebElement Account;
	
	//@FindBy(className="nav-action-inner")
	@FindBy(xpath ="/html/body/div[1]/header/div/div[1]/div[4]/div[5]/div[1]/a/span")
	public
	WebElement SignIn;
	
	@FindBy(name="email")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(id="signInSubmit")
	WebElement Submit;
	
	public LoginPage(WebDriver driver)
	{
	super(driver);
	}
	
	public WebElement Account()
	{
		return Account;
	}
	
	public WebElement SignIn()
	{
		return SignIn;
	}
	
	public WebElement Username()
	{
		return Username;
	}
	
	public WebElement Password()
	{
		return Password;
	}
	
	public WebElement Submit()
	{
		return Submit;
	}
	

}
