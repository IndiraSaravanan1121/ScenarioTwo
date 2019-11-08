package com.tutorialsninja.utils;

import org.testng.Assert;

public class Validation {
	public void validation(String actual,String expected) {
		Assert.assertEquals(actual, expected);
	}

}
