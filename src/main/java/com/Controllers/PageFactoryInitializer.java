package com.Controllers;

import org.openqa.selenium.support.PageFactory;

import com.PageObjects.FeedbackFormPageObjects;
import com.PageObjects.HomePageObjects;
import com.PageObjects.LoginPageObjects;

public class PageFactoryInitializer extends MainController{

	
		public HomePageObjects homePage() {
			HomePageObjects homePage = PageFactory.initElements(driver, HomePageObjects.class);
			return homePage;
		}
		
		public LoginPageObjects loginPage() {
			LoginPageObjects loginPage = PageFactory.initElements(driver, LoginPageObjects.class);
			return loginPage;
		}
		
		public FeedbackFormPageObjects feedbackformpage() {
			FeedbackFormPageObjects feedbackformpage = PageFactory.initElements(driver, FeedbackFormPageObjects.class);
			return feedbackformpage;
		}
	}


