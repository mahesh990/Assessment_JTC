package com.test.jtc.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.jtc.base.BaseTest;



public class GoogleSearchTest extends BaseTest{
	 
	@Test(priority = 1)
	public void verifyPageTitle() {
		String title=gsp.verifyGooglePageTitle();
		Assert.assertEquals(title, "Google");		
	}
	
	@Test(priority = 2)
	public void googleSearch() throws Exception  {		
		gsp.inputSearchField();
		
	}
}
