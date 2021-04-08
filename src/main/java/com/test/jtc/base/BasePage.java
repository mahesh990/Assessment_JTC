package com.test.jtc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	public  WebDriver init_browser(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		System.out.println("name is "+ browserName);
				
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver= new ChromeDriver();
						
		}
		else {
					System.out.println("Please pass the correct browser "+ browserName );
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	
	public Properties init_properties()
	{
		prop = new Properties();
		
		try {
			FileInputStream fi= new FileInputStream("./config.properties/config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return prop;
		
		
	}

}
