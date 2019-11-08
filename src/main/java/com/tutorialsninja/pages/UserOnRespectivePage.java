package com.tutorialsninja.pages;

import com.tutorialsninja.utils.TestBase;

public class UserOnRespectivePage extends TestBase {
	
	public void userOnRespectivePage(String expectedUrl) {
		String actualurl=driver.getCurrentUrl();
		validate.validation(actualurl, expectedUrl);
	}

}
