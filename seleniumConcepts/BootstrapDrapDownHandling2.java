package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapDrapDownHandling2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String option = "Finance Manager";
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

		WebElement pimClick = driver.findElement(By.xpath("//span[text() = 'PIM']"));
		pimClick.click();

		WebElement jobTitleDrapDowns = driver.findElement(By.xpath(
				"(//label[text() = 'Job Title']//following::div[contains(text(),'-- Select --')]//following::div[contains(@class,\"oxd-select-text--after\")])[1]"));
		jobTitleDrapDowns.click();
		// ctrl shift p uses to inspect element and select emulator focus
		Thread.sleep(5000);
		List<WebElement> jobTitleDrapDownsList = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println(jobTitleDrapDownsList.size());

		wait.until(ExpectedConditions.visibilityOfAllElements(jobTitleDrapDownsList));
		for (WebElement jobTitleDrapDown : jobTitleDrapDownsList) {
		wait.until(ExpectedConditions.visibilityOf(jobTitleDrapDown));
			if (jobTitleDrapDown.getText().contains(option)) {

				jobTitleDrapDown.click();
			}
		}
	}
}
