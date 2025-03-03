package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDrapdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchBox.sendKeys("selenium");
		List<WebElement> drapDownLists = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li//div[@role='option']"));
        System.out.println(drapDownLists.size());
        for (WebElement drapDownList : drapDownLists) {
			if(drapDownList.getText().equals("selenium")) {
				drapDownList.click();
			}
		}
        driver.quit();
	}

}
