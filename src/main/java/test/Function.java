package test;


import resourses.Action;
import resourses.Keyword;
import util.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Function {

	
	WebDriverWait wait = new WebDriverWait(Action.driver,Duration.ofSeconds(30));
	public void selectBodyType() {
		try {
			System.out.println("Executing selectBodyType.....");
			String type = Driver.sData;
			String xpath = String.format(Keyword.bodyType,type);
			Action.driver.findElement(By.xpath(xpath)).click();
			
			Driver.result = true;

		}
		catch (Exception e){
			System.out.println("Error Occured "+ e.getMessage());
			Driver.result = false;
		}
	}
	
	public void selectFirstVehicle() {
		try {
			System.out.println("Executing selectFirstVehicle.....");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.firstVehicle)));
			Action.driver.findElement(By.xpath(Keyword.firstVehicle)).click();
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured"+e.getMessage());
			Driver.result = false;
		}
	}
	
	public void selectContactMe() {
		try {
			System.out.println("Executing selectContactMe...");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.contactMeBtn)));
			Action.driver.findElement(By.xpath(Keyword.contactMeBtn)).click();		
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured"+e.getMessage());
			Driver.result = false;
		}
	}

	public void enterContactDetails() {
		try {
			System.out.println("Executing enterContactDetails...");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Keyword.contactDetailsText)));
			String data = Driver.sData;
			//ArrayList<String> details = new ArrayList<String>(5);
			List<String> details = new ArrayList<>(Arrays.asList(data.split(",")));
			if(details.get(0) != null)
				Action.driver.findElement(By.xpath(Keyword.firstNameTextbox)).sendKeys(details.get(0));
			if(details.get(1) != null)
				Action.driver.findElement(By.xpath(Keyword.lastNameTextbox)).sendKeys(details.get(1));
			if(details.get(2) != null)
				Action.driver.findElement(By.xpath(Keyword.emailTextbox)).sendKeys(details.get(2));
			if(details.get(3) != null)
				Action.driver.findElement(By.xpath(Keyword.mobileNumberTextbox)).sendKeys(details.get(3));
			if(details.get(4) != null)
				Action.driver.findElement(By.xpath(Keyword.commentsTextbox)).sendKeys(details.get(4));
		
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured"+e.getMessage());
			Driver.result = false;
		}
	}
	public void verifyProccedBtnDisabled() {
		try {
			System.out.println("Executing verifyProccedBtnDisabled...");
			WebElement proceedElement = Action.driver.findElement(By.xpath(Keyword.proceedBtn));
			String bool = proceedElement.getAttribute("disabled");
			if(bool.equals("true"))
				Driver.result = true;
			else
				Driver.result = false;
		}
		catch (Exception e){
			System.out.println("Error Occured");
			Driver.result = false;
		}
	}
	public void selectCategoryMobile() {
		try {
			System.out.println("Executing selectCategoryMobile...");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.categoryMobile)));

			Action.driver.findElement(By.xpath(Keyword.categoryMobile)).click();
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured");
			Driver.result = false;
		}
	}
	public void clicks() {
		try {
			System.out.println("Executing selectCategoryMobile...");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.categoryMobile)));
			Actions act =new Actions(Action.driver);
			WebElement element = Action.driver.findElement(By.xpath(Keyword.categoryMobile));
			act.contextClick(element).build().perform();
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured");
			Driver.result = false;
		}
	}

	
	public void selectCategoryMobileAccessories() {
		try {
			System.out.println("Executing categoryMobileAccessories...");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.categoryMobileAcc)));
			Action.driver.findElement(By.xpath(Keyword.categoryMobileAcc)).click();
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured");
			Driver.result = false;
		}
	}
	
	public void selectPtronPride() {
		try {
			System.out.println("Executing selectPtronPride...");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.pTronPride)));
			Action.driver.findElement(By.xpath(Keyword.pTronPride)).click();
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured");
			Driver.result = false;
		}
	}
	public void selectcolorGray() {
		try {
			System.out.println("Executing selectcolorGray...");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.colorGray)));
			Action.driver.findElement(By.xpath(Keyword.colorGray)).click();
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured");
			Driver.result = false;
		}
	}
	
	public void selectAddToCart() {
		try {
			System.out.println("Executing selectcolorGray...");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Keyword.AddToCartBtn)));
			Action.driver.findElement(By.xpath(Keyword.AddToCartBtn)).click();
			Driver.result = true;
		}
		catch (Exception e){
			System.out.println("Error Occured");
			Driver.result = false;
		}
	}
	
	public void takeScreenshot() throws IOException {
		TakesScreenshot scr = (TakesScreenshot)Action.driver;
		File f = scr.getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(f,new File("C:\\Users\\mcman\\eclipse-workspace\\MercedesBenzProject\\WebDriver\\pic.png"));
		
		File source = ((FirefoxDriver)Action.driver).getFullPageScreenshotAs(OutputType.FILE);
	     FileHandler.copy(source, new File("QED_Full_Page_Screenshot.png"));
	}
	
	public void scrolldown() {
		
	}
}
