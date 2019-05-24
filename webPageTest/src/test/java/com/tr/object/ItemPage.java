package com.tr.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends PageObject 
{
	//By Items=By.tagName("h2");
	
	//@FindBy(xpath=".//*[@id='rot-B017SLNP3C']/div/a/div[1]/img")
	
	//to be included
	//@FindBy(xpath=".//*[@id='result_0']")
	//WebElement Item1;
	//to be included
	
	@FindBy(xpath=".//*[@id='add-to-cart-button']")
	WebElement AddToCart;
	
	//@FindBy(xpath=".//*[@id='result_0']/div/div[3]/div[1]/a/h2");
	//WebElement Item;
	
	//@FindAllBy(xpath=".//*[@id='result_2']/div/div[3]/div[1]/a/h2")
	//WebElement Item1;
	
	public ItemPage(WebDriver driver)
	{
		super(driver);
	}

	
	
	public WebElement AddToCart()
	{
		return AddToCart;
	}
	
	
	

	
}
