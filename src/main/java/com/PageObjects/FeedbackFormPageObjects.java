package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Controllers.PageFactoryInitializer;

public class FeedbackFormPageObjects extends PageFactoryInitializer {
	@FindBy(xpath="//span[@class='wpcf7-form-control-wrap name']/input")
	private WebElement formNameLocator;
	
	@FindBy(xpath="//span[@class='wpcf7-form-control-wrap email']/input")
	private WebElement formEmailLocator;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement sendLocator;
	
	@FindBy(xpath="//span[@class='wpcf7-form-control-wrap message']/descendant::span")
	private WebElement formErrorMessageLocator;
	
	public FeedbackFormPageObjects getFormName(String Name){
		formNameLocator.sendKeys(Name);
		return this;
	}
	
	public FeedbackFormPageObjects getFormEmail(String Email){
		formEmailLocator.sendKeys(Email);
		return this;
	}
	public FeedbackFormPageObjects clickOnSend(){
		sendLocator.click();
		return this;
	}
	
	public FeedbackFormPageObjects verifyErrorMessages(String Error_Message){
		Assert.assertTrue(formErrorMessageLocator.equals(Error_Message));
		return this;
	}
	
}
