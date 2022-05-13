package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		System.out.println("Label of frame1 is "+ driver.findElement(By.id("topic")).getText());
		
		System.out.println("...........................................");
		
		driver.findElement(By.xpath("//input")).sendKeys("Frame");
		driver.switchTo().frame("frame3");
		System.out.println("Label of frame3 is "+ driver.findElement(By.xpath("//b")).getText());
		driver.findElement(By.id("a")).click();
		if(driver.findElement(By.id("a")).isSelected()) 
		{
			System.out.println("The inner frame3 check box is selected ");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		System.out.println("...........................................");
		
		System.out.println("Label of frame2 is "+ driver.findElement(By.xpath("//b")).getText());
		System.out.println(driver.findElement(By.xpath("//select")).getText());
		driver.findElement(By.xpath("//select")).sendKeys("Big Baby Cat");
		
		//close browser
		driver.close();

	}

}
