package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		//first dropdown using index
		WebElement findElement1 = driver.findElement(By.id("dropdown1"));
		Select Dropdown1 = new Select(findElement1);
		Dropdown1.selectByIndex(1);
		
		//second dropdown using text
		WebElement findElement2 = driver.findElement(By.name("dropdown2"));
		Select Dropdown2 = new Select(findElement2);
		Dropdown2.selectByVisibleText("Selenium");
		
		//third dropdown using value
		WebElement findElement3 = driver.findElement(By.id("dropdown3"));
		Select Dropdown3 = new Select(findElement3);
		Dropdown3.selectByValue("4");
		
		//fourth dropdown by number of dropdown options
		WebElement findElement4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select Dropdown4 = new Select(findElement4);
		List<WebElement> Dropdown4options = Dropdown4.getOptions();
		System.out.println("number of dropdown options are "+ Dropdown4options );
		for(WebElement eachOptions : Dropdown4options)
		{
			System.out.println(eachOptions.getText());
		}
		
		//select values from dropdown using sendkeys
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("Selenium");
		
		//sixth dropdown check multiple values selected
		WebElement findElement6 = driver.findElement(By.xpath("(//select)[6]"));
		Select Dropdown6 = new Select(findElement6);
		Dropdown6.selectByValue("3");
		Dropdown6.selectByValue("4");
		
		List<WebElement> selectedvalues = Dropdown6.getAllSelectedOptions();
		for(WebElement values : selectedvalues) 
		{
			System.out.println(values.getText());
		}
		
		//close browser
		driver.close();
			












		
		
		
		
	}

}
