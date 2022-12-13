package tests;

import org.testng.annotations.Test;

import pages.AmazonPage;
import utils.Driver;
import utils.ExcelUtils;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class AmazonSearchWithExcel {
	
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void quitDriver() {
		Driver.quitDriver();
	}
	
	
	@Test (dataProvider = "searchItems",enabled = true)
	  public void AmazonSearchTest(String item) {
		  AmazonPage amazonpage = new AmazonPage();
		  Driver.getDriver().get("https://amazon.com");
		  amazonpage.searchBox.sendKeys(item);
		  amazonpage.searchBtn.click();
		  String actualText = amazonpage.searchedItemText.getText().substring(1, item.length()+1);
		  System.out.println(actualText + "  " + item.length());
		  Assert.assertEquals(actualText, item);
}
 @DataProvider
 public String[] searchItems() {
	  String[] items = ExcelUtils.getExcelDataInAColumn
			  ("./src/test/resources/Testdata/searchItems.xlsx", "Items");
	return items;
 }
 @DataProvider
 public String[] searchItems1() {
	  String[] items =  new String[6];
	  items[0] = "coffee mug";
	  items[1] = "pretty coffee mug";
	  items[2] = "ugly coffee mug";
	  items[3] = "funny coffee mug";
	  items[4] = "gold coffee mug";
	  items[5] = "argentina coffee mug";
	  return items;
			              
	  
 }
}
