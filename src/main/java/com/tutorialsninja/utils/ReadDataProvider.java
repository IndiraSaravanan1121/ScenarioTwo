package com.tutorialsninja.utils;

import org.testng.annotations.DataProvider;

import com.tutorialsninja.config.Constants;

public class ReadDataProvider {
	@DataProvider
	public Object[][] url(){
		Object[][] data=ExcelReader.readExcel("validateurl", Constants.NINJATESTDATA_PATH);
		return data;
	}
	
	@DataProvider
	public Object[][] addToCart(){
		Object[][] data=ExcelReader.readExcel("addtocart", Constants.NINJATESTDATA_PATH);
		return data;
	}
	
	@DataProvider
	public Object[][] userPage(){
		Object[][] data=ExcelReader.readExcel("validateuserpage", Constants.HEATCLINICTESTDATA_PATH);
		return data;
	}
	
	@DataProvider
	public Object[][] personalizedName(){
		Object[][] data=ExcelReader.readExcel("personalizename", Constants.HEATCLINICTESTDATA_PATH);
		return data;
	}
	
	
}
