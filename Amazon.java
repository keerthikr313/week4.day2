package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("https://www.amazon.in/");
		
		//search oneplus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//Get the price of the first product
		String priceoffirstproduct = driver.findElement(By.xpath("(//div[@class='a-section'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println("Price of first product is " + priceoffirstproduct);
		
		//Print the number of customer ratings for the first displayed product
		System.out.println(driver.findElement(By.xpath("(//div//span[text()='RESULTS']//following::span[contains(text(),'stars')][1]")).getText());
		
		//Click the first text link of the first image
		driver.findElement(By.xpath("(//div//span[@text()='RESULTS']//following::h2[1]//a")).click();
		List<String> windowHandlesList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandlesList.get(1));
		
		//Take a screen shot of the product displayed
		File screenshotfile = driver.getScreenshotAs(OutputType.FILE);
		File snapshotfile = new File("./snaps/Amazon.png");
		FileUtils.copyFile(screenshotfile, snapshotfile);
		if(FileUtils.getFile(snapshotfile).exists()) 
		{
			System.out.println("The screenshot is taken ");
		}
		
		//Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		//Get the cart subtotal and verify if it is correct
		String carttotal = driver.findElement(By.xpath("//span//b[contains(text(),'Cart subtotal')]//following::span//span")).getText();
		if(carttotal.replaceAll("\\D", " ").contains(priceoffirstproduct.replaceAll("\\D", " ")) )
		{
			System.out.println("The cart price is same as phone price");
		}
		
		//close browser
		driver.close();
		
		

		

		
		
	}

}
