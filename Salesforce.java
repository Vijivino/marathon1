package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// setup the path

//disable notifications

//create instance

//manage ur window

//add wait

		// Login to https://login.salesforce.com

//enter usernamerl: https://login.salesforce.com/
		// Username : ramkumar.ramaiah@testleaf.com
		// Password: Password#123

//enter password

//click login button

		// Click on toggle menu button from the left corner

		// Click view All and click Sales from App Launcher

		// Click on Opportunity tab

//Click on Accounts tab

//Click on New button

//Enter 'your name' as account name

//Select Ownership as Public

		// click save

//verify message
		
	//driver and browser setup	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
        driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//enter login	
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys("Password#123");
		driver.findElement(By.xpath("//input[@class='button r4 wide primary']")).click();
	//toggle menu
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	//navigation to sales to accounts	
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	//using javascript for accounts click	
		WebElement js = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click()", js);
	//create new account	
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input")).sendKeys("Viji");
		Thread.sleep(3000);
		WebElement d = driver.findElement(By.xpath("//label[text()='Ownership']/following::button"));
	    driver.executeScript("arguments[0].click()", d);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    Thread.sleep(5000);
	 //get success msg
	    String success = driver.findElement(By.xpath("//span[text()='Account']")).getText();
	    System.out.println(success);
	    if (success.contains("Viji"))
	    	{
	    	System.out.println("it is verified");
	    	}
	    else
	    {
	    	System.out.println("it is not verified");
	    }
	}

}
