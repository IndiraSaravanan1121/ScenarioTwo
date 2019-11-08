package com.tutorialsninja.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialsninja.config.Constants;
import com.tutorialsninja.utils.TestBase;

public class AutomateHeatClinic extends TestBase {

	@BeforeTest
	public void startBrowser() throws Exception {
		openBrowser();
	}

	@Test(dataProvider = "userPage", priority = 1)
	public void validateUserInRespectivePage(String expectedUrl) throws Exception {
		log.info("Validate user redirect to respective page");
		page.userOnRespectivePage(expectedUrl);
		helper.clickElement(driver, property.properties("loc_hotsauce_lbl", Constants.HEATCLINICLOCATOR_PATH));
		page.userOnRespectivePage(expectedUrl);
		helper.clickElement(driver, property.properties("loc_merchandise_lbl", Constants.HEATCLINICLOCATOR_PATH));
		page.userOnRespectivePage(expectedUrl);
		helper.clickElement(driver, property.properties("loc_clearance_lbl", Constants.HEATCLINICLOCATOR_PATH));
		page.userOnRespectivePage(expectedUrl);
		helper.clickElement(driver, property.properties("loc_newtohotsauce_lbl", Constants.HEATCLINICLOCATOR_PATH));
		page.userOnRespectivePage(expectedUrl);
		helper.clickElement(driver, property.properties("loc_faq_lbl", Constants.HEATCLINICLOCATOR_PATH));
		page.userOnRespectivePage(expectedUrl);
	}

	@Test(priority = 2)
	public void verifyViewingMenText() throws Exception {
		log.info("verify viewing mens");
		helper.moveToElements(driver, property.properties("loc_merchandise_lbl", Constants.HEATCLINICLOCATOR_PATH));
		helper.clickElement(driver, property.properties("loc_mens_lbl", Constants.HEATCLINICLOCATOR_PATH));
		boolean viewingMen = driver
				.findElement(
						By.cssSelector(property.properties("loc_viewingmenu_lbl", Constants.HEATCLINICLOCATOR_PATH)))
				.isDisplayed();
		log.info("viewing mens is displayed");
	}

	@Test(dataProvider = "personalizedName", priority = 3)
	public void BuyHabaneroShirt(String values) throws Exception {
		log.info("Buy Habanero shirt");
		helper.clickElement(driver, property.properties("loc_buynow_lbl", Constants.HEATCLINICLOCATOR_PATH));
		helper.clickElement(driver, property.properties("loc_redcolor_btn", Constants.HEATCLINICLOCATOR_PATH));
		helper.clickElement(driver, property.properties("loc_shirtsize_btn", Constants.HEATCLINICLOCATOR_PATH));
		helper.sendValues(driver, property.properties("loc_personalizedname_txt", Constants.HEATCLINICLOCATOR_PATH),
				values);
		helper.clickElement(driver, property.properties("loc_buynow_btn", Constants.HEATCLINICLOCATOR_PATH));
	}
	
	@Test(priority=4)
	public void validateCartItem() throws Exception {
		helper.clickElement(driver, property.properties("loc_carttotal_btn", Constants.HEATCLINICLOCATOR_PATH));
		String text=helper.getWebText(driver, property.properties("loc_buynow_btn", Constants.HEATCLINICLOCATOR_PATH));
	}

	@AfterTest
	public void endBrowser() {
		closeBrowser(driver);
	}
}
