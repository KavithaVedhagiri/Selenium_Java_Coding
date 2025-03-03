package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BootstrapDrapDownHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/");
		driver.manage().window().maximize();
		String option = "Java";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement programmingDropDown = driver.findElement(By.xpath("//a[text() = 'Programming']"));
//		programmingDropDown.click();
//		WebElement selectKotlin = driver.findElement(By.xpath("//a[text() = 'Programming']//following::a[text() = 'Kotlin']"));
//		selectKotlin.click();
//        Thread.sleep(1000);
//		List<WebElement> programmingDropDownLists = driver.findElements(By.xpath("//a[text() = 'Programming']//following-sibling::div/a"));
//	    System.out.println(programmingDropDownLists.size());
//	    for (WebElement programmingDropDownList : programmingDropDownLists) {
//	    	 if(programmingDropDownList.getText().contains(option)) {
//	    		 programmingDropDownList.click();
//	    	 }
//		}

		// Using Actions Class
		Actions act = new Actions(driver);
		act.moveToElement(programmingDropDown).perform();
//		driver.findElement(By.xpath("//a[text() = 'Programming']//following::a[text() = 'Kotlin']")).click();
		List<WebElement> programmingDropDownLists = driver.findElements(By.xpath("//a[text() = 'Programming']//following-sibling::div/a"));
	    System.out.println(programmingDropDownLists.size());
	    for (WebElement programmingDropDownList : programmingDropDownLists) {
	    	 if(programmingDropDownList.getText().equals("Java")) {
	    		 programmingDropDownList.click();
	    	 }
		}
	}

}
