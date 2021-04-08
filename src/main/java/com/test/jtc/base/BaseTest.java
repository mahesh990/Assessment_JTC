package com.test.jtc.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.test.jtc.pages.GoogleSearchPage;


public class BaseTest {
	
	 WebDriver driver;	
	BasePage bpage;
	Properties prop;
	 protected GoogleSearchPage gsp;
		
	@BeforeTest
	public void setup() 
	{
	 bpage = new BasePage();
	 prop= bpage.init_properties();
	 driver=bpage.init_browser(prop);
	 gsp = new GoogleSearchPage(driver);	
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}
	

}
