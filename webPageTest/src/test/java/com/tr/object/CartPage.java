package com.tr.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {
	
	public CartPage(WebDriver driver) {
		super(driver);
		
	}

	By CartElement =By.xpath("(//h1[contains(.,'Added to Cart')])[1]");
	
	
	public WebElement CartElement()
	{	
		
		return driver.findElement(CartElement);
	}
	
	
	
	

}
