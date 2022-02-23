package test;


import resourses.Action;
import resourses.Keyword;
import util.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Function {

	
	WebDriverWait wait = new WebDriverWait(Action.driver,Duration.ofSeconds(30));
	public void selectBodyType() {
		try {
			System.out.println("Executing selectBodyType.....");
			String type = Driver.sData;
			String xpath = String.format(Keyword.bodyType,type);
			Action.driver.findElement(By.xpath(xpath)).click();
			Action.sleep(5000);
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
			ArrayList<String> details = new ArrayList<>(Arrays.asList(data.split(",")));
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
}
