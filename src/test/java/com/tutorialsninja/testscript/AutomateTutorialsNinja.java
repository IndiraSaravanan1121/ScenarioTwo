package com.tutorialsninja.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialsninja.config.Constants;
import com.tutorialsninja.utils.TestBase;

public class AutomateTutorialsNinja extends TestBase {

	@BeforeTest
	public void startBrowser() throws Exception {
		openBrowser();
	}
	
	@Test(dataProvider="url",priority=1)
	public void validateHomepage(String expectedUrl) throws Exception {
		log.info("1.validate Homepage");
		String url = driver.getCurrentUrl();
		validate.validation(url, expectedUrl);
	}

	@Test(dataProvider="addToCart",priority=2)
	public void addToCart(String macbookquantity,String iphonequantity) throws Exception {
		log.info("2.Add to cart");
		driver.findElement(By.cssSelector(property.properties("loc_macbook_lbl", Constants.NINJALOCATOR_PATH))).click();
		driver.findElement(By.cssSelector(property.properties("loc_macbookquantity_lbl", Constants.NINJALOCATOR_PATH))).sendKeys(macbookquantity);
		driver.findElement(By.cssSelector(property.properties("loc_macbook_addtocart_lbl", Constants.NINJALOCATOR_PATH))).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector(property.properties("loc_iphone_addtocart_lbl", Constants.NINJALOCATOR_PATH))).click();	
		driver.findElement(By.cssSelector(property.properties("loc_iphonequantity_lbl", Constants.NINJALOCATOR_PATH))).sendKeys(iphonequantity);
		driver.findElement(By.cssSelector(property.properties("loc_iphone_addtocart_lbl", Constants.NINJALOCATOR_PATH))).click();
	}
	
	@Test(priority=3)
	public void cartTotal() throws Exception {
		log.info("3.Verify cart total");
		String cartTotal=driver.findElement(By.id(property.properties("loc_carttotal_lbl", Constants.NINJALOCATOR_PATH))).getText();
		String expected=property.properties("carttotal", Constants.TESTDATACONFIG_PATH);
		validate.validation(cartTotal, expected);
	}

	@AfterTest
	public void endBrowser() {
		closeBrowser(driver);
	}
}
