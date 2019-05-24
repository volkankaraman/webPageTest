package com.tr.object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {
	
	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id ="nav-cart-count")
	WebElement UrunAdet;
	
	
	@FindBy(id="hlb-ptc-btn-native")
	WebElement SatinAl;

	
	
	
	public WebElement SatinAl()
	{	
		
		return SatinAl;
	}
	
	public WebElement UrunAdet()
	{	
		
		return UrunAdet;
	}
	
	

}
