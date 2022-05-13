package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("http://www.leafground.com/pages/Window.html");
		
		driver.findElement(By.id("home")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		
		//draw a line in between 2 windows
		System.out.println("...........................................");
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list = new ArrayList<String>(windowHandles);
		String newWindowHandle = list.get(1);
		
		System.out.println("...........................................");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		System.out.println("...........................................");
		
		driver.switchTo().window(newWindowHandle);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		System.out.println("...........................................");
		
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());

	
		
	}

}
