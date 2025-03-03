package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BootstrapDrapDownHandling1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/digital-downloads");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement topMenu = driver
				.findElement(By.xpath("(//ul[@class='top-menu notmobile']//following::a[text() = 'Electronics '])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(topMenu).perform();
		Thread.sleep(2000);
//		WebElement electonicsDrapDown = driver.findElement(By
//				.xpath("(//ul[contains(@class,'sublist first-level')]//following::a[contains(text() ,'Camera & photo ')])[1]"));
//		electonicsDrapDown.click();
//		Thread.sleep(1000);

		List<WebElement> electronicDrapdownLists = driver
				.findElements(By.xpath("//a[text() = 'Electronics ']//parent::li//li"));
		System.out.println(electronicDrapdownLists.size());
		for(WebElement electronicDrapdownList : electronicDrapdownLists ) {
			if(electronicDrapdownList.getText().contains("Camera & photo ")){
				electronicDrapdownList.click();
			}
		}
	}

}
