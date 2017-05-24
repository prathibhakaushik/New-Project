package com.Modules;

import com.Controllers.PageFactoryInitializer;
import com.DataProvider.DataDrivenTestingFromExcel;

import org.testng.annotations.Test;

public class HomePageTest extends PageFactoryInitializer{


	public void verifyHomePage()
	{
		homePage()
		.getTitle()
		.verifyTitle();
		
	}
	
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void feedbackFormData(String Name, String Email, String Message, String Error_Message)throws Exception {
		
		feedbackformpage()
		.getFormName(Name)
		.getFormEmail(Email)
		.clickOnSend()
	    .verifyErrorMessages(Error_Message);
	
		
}
}