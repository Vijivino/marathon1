package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Load https://www.redbus.in/
		
				// Type "Chennai" in the FROM text box
			
				// Type "Bangalore" in the TO text box
				
				// Select tomorrow's date in the Date field
				
				// Click Search Buses
				
				// Print the number of buses shown as results (104 Buses found)
				
				// Close the redbus primo notification
				
				// Choose SLEEPER in the left menu
				
				//click on view seats
				
				//print the starting price
				
				//Print the available seats
		
	//driver setup with disable notifications
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
	    driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//enter text
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		Thread.sleep(2000);
	//choose date	
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[@class='current day']")).click();
	//click search
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
	//no.of buses 
		String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("No.of buses "+text);
		Thread.sleep(3000);
	//close the primo
		driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
	//choose sleeper checkbox
		WebElement ck = driver.findElement(By.xpath("(//label[@class='custom-checkbox'])[6]"));
		//driver.executeScript("arguments[0].click();", webElement);
		driver.executeScript("arguments[0].click();",ck);
		//driver.findElement(By.xpath("//input[@id='bt_SLEEPER']/following::label")).click();
	    // Choose SLEEPER in the left menu
       // WebElement sleeperCheckBox = driver.findElement(By.xpath("//ul[@class='list-chkbox']/li[2]"));
	//click viewseats
		driver.findElement(By.xpath("//div[@class='button view-seats fr']")).click();
	//print price
		String price = driver.findElement(By.xpath("//span[@class='f-19 f-bold']")).getText();
		System.out.println("price" +price);
	//print avail seats
		String seats = driver.findElement(By.xpath("//div[@class='seat-left m-top-30']")).getText();
		System.out.println(seats);
	}

}
