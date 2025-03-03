package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAutoSuggestDrapDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchBox = driver
				.findElement(By.xpath("//input[contains(@id,'Wikipedia1_wikipedia-search-input')]"));
		searchBox.sendKeys("Selenium");
		WebElement clickBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		clickBtn.click();
		List<WebElement> listOfSearchValues = driver.findElements(
				By.xpath("//form[@name='wikipedia']//following::div[@id='wikipedia-search-result-link']"));
		System.out.println(listOfSearchValues.size());
		for(WebElement listOfSearchValue : listOfSearchValues) {
			System.out.println(listOfSearchValue.getText());
		}

	}

}
