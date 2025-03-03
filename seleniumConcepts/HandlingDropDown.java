package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
//		WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='country']"));
//		Select se = new Select(countryDropDown);
//		//select by using value attribute
//		se.selectByValue("canada");
//		//select by using visibleText attribute
//		se.selectByVisibleText("Australia");
//		//select by using index based
//		se.selectByIndex(3);
		
		WebElement colorsDrapDown = driver.findElement(By.xpath("//select[@id='colors']"));
		Select sc = new Select(colorsDrapDown);
		sc.selectByIndex(1);
		sc.selectByValue("white");
		sc.selectByVisibleText("Yellow");
		

	}

}
