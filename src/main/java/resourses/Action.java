package resourses;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Driver;
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How; 
public class Action {

	public static WebDriver driver;
	
	public static void openBrowser(String data){		
		System.out.println("Opening Browser");
		try{	
			System.out.println(data);
			if(data.equals("Firefox")){
				
				System.setProperty("webdriver.geck  o.driver", "C:\\Users\\mcman\\eclipse-workspace\\MercedesBenzProject\\WebDriver\\geckodriver.exe");
				driver=new FirefoxDriver();
				System.out.println("Mozilla Firefox browser started");				
				}
			else if(data.equals("IE")){
				driver=new InternetExplorerDriver();
				System.out.println("IE browser started");
				
				}
			else if(data.equals("Chrome")){				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\mcman\\eclipse-workspace\\MercedesBenzProject\\WebDriver\\chromedriver.exe"); 
				driver = new ChromeDriver();
				System.out.println("Chrome browser started");
				}
			
			sleep(2000);
			driver.manage().window().maximize();
		}catch (Exception e){
			System.out.println("Not able to open the Browser --- " + e.getMessage());
			Driver.result = false;
		}
	}
	
	public static void navigate(){
		try{
			System.out.println("Navigating to URL");
			driver.get(Keyword.URL);

			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("cmm-cookie-banner")));
//			WebElement shadowHost = driver.findElement(By.cssSelector("cmm-cookie-banner"));
			sleep(10000);
//			SearchContext shadowRoot = shadowHost.getShadowRoot();
//			wait.until(ExpectedConditions.elementToBeClickable(shadowRoot.findElement(By.cssSelector("div.button-wrapper>button:nth-child(2)"))));
//			WebElement shadowContent = shadowRoot.findElement(By.cssSelector("div.button-wrapper>button:nth-child(2)"));
//			shadowContent.click();
		}catch(Exception e){
			e.printStackTrace();
			Driver.result = false;
			}
		}

	public static void sleep(int data) throws Exception{
		try{
			Thread.sleep(data);
		 }catch(Exception e){
			 System.out.println("Error occured v" + e.getMessage());
			 Driver.result = false;
         	}
		}

	public static void closeBrowser(){
		try{
			System.out.println("Closing the browser");
			driver.quit();
			@FindBy(how = How.XPATH, using ="//a") WebElement ele;
		 }catch(Exception e){
			 System.out.println("Not able to Close the Browser --- " + e.getMessage());
			 Driver.result = false;
         	}
		}
}
