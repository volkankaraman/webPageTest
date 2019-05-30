package com.tr.object;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BreakLinkPage extends PageObject {
	
	public List<WebElement> BreakLinks() {
		// TODO Auto-generated method stub
		List<WebElement> links=driver.findElements(By.tagName("a"));
		return links;
	}	
	public BreakLinkPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
