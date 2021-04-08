package com.test.jtc.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.jtc.Utility.Utility;
import com.test.jtc.base.BasePage;


public class GoogleSearchPage extends BasePage {
	WebDriver driver;
	Utility u;

	private By googleSearchField =By.name("q");	
	private By suggestionList=By.xpath("//ul[@class='erkvQe']//span");

	public  GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
		u= new Utility(driver);		
	}
	public String verifyGooglePageTitle() {
		return driver.getTitle();
	}
	
	public void inputSearchField() throws Exception  {
		driver.findElement(googleSearchField).sendKeys("selenium");
		List<WebElement> suggestionsList = driver.findElements(suggestionList);		
		for(WebElement ele : suggestionsList){		
			String text = ele.getText();		
				if(text.equals("selenium grid")){
					u.clickWhenReady(ele, 40);
					break;
				}
		}
	}
	
	
	
	
	
	
	
}
