package com.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Controllers.PageFactoryInitializer;
import com.Utils.SearchDataPropertyFile;

public class HomePageObjects extends PageFactoryInitializer{

	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//title")
	private WebElement pageTitle;

	
	public HomePageObjects getTitle(){
		pageTitle.getText();
		return this;
	}
	
	public HomePageObjects verifyTitle(){
	Assert.assertTrue(pageTitle.equals(data.getactualTitle()));
		return this;
	}
	
	public HomePageObjects pageScrolldown(){
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		return this;
		}
	
}
