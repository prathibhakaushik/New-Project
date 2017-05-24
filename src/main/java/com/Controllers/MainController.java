package com.Controllers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Utils.ApplicationSetUpPropertyFile;

public class MainController {
	protected WebDriver driver;
	public static String outputVideo="";
	public static String outputReport="";
	public static String applicationSetUp = "D:\\DPM Automation Framework\\DPM\\resources\\PropertyFiles\\ApplicationSetUpPropertyFile.properties";
	public static String searchData = "D:\\DPM Automation Framework\\DPM\\resources\\PropertyFiles\\SearchData.properties";
@BeforeMethod(alwaysRun=true)
public boolean setUp() throws Exception {

	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	driver.get(setUp.getURL());
	driver.manage().deleteAllCookies();
	return true;
}
@BeforeTest(alwaysRun=true)
public void beforeTest() throws Exception
{
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
if(System.getProperty("os.name").toUpperCase().contains("WIN"))
{
	if(setUp.getBrowser().trim().equalsIgnoreCase("chrome"))
	{
		  
		System.setProperty("webdriver.chrome.driver", "D:\\DPM Automation Framework\\DPM\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		  
	}
	else if(setUp.getBrowser().trim().equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.ie.driver","D:\\DPM Automation Framework\\DPM\\resources\\drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	else if(setUp.getBrowser().trim().equalsIgnoreCase("firefox"))
	{

		System.setProperty("webdriver.gecko.driver", "D:\\DPM Automation Framework\\DPM\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("cannot load driver");
	}
}
	driver.manage().window().maximize();
	
}

@AfterMethod
public void tearDown(ITestResult result)
{
 
if(ITestResult.FAILURE==result.getStatus())
{
try 
{

TakesScreenshot ts=(TakesScreenshot)driver;
File source=ts.getScreenshotAs(OutputType.FILE);

DateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY");
DateFormat timeformat=new SimpleDateFormat("hh-mm-ss");
Date date=new Date();
String date1=dateFormat.format(date);
String time1=timeformat.format(date);
System.out.println(date1);
FileUtils.copyFile(source, new File("D:\\DPM Automation Framework\\DPM\\Screenshots"+"./"+date1+"/"+result.getName()+" "+time1+".png"));
 
System.out.println("Screenshot taken");
} 
catch (Exception e)
{
 System.out.println("Exception while taking screenshot "+e.getMessage());
} 

}

}

@AfterSuite(alwaysRun=true)
public void tearDown(){
driver.quit();
}

}
