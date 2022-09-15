package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//setup the path	
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
    //Click on Opportunity tab 
        WebElement op = driver.findElement(By.xpath("//span[text()='Opportunities']"));
        driver.executeScript("arguments[0].click()", op);
	//Click on New button 
	     driver.findElement(By.xpath("//div[text()='New']")).click();	
	//click opportunity name
	     driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("testleaf");
	//Enter 'your name' as account name
		 driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Viji");
		 driver.findElement(By.xpath("//strong[text()='Viji']")).click();
	//choose close date
		 driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		 driver.findElement(By.xpath("//span[text()='16']")).click();
	//click stage
		 driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();	
		 driver.findElement(By.xpath("//span[@title='Value Proposition']")).click();
		
    //click save
		 driver.findElement(By.xpath("//button[text()='Save']")).click();	
		Thread.sleep(5000);
	//verify message
		String succ = driver.findElement(By.xpath("//span[text()='Opportunity']")).getText();
		System.out.println(succ);
		if (succ.contains("testleaf"))
		{
			System.out.println("it is verified");
		}
		else
		{
			System.out.println("it is not verified");
		}
	// Close the Browser
        driver.close();
	}

}
