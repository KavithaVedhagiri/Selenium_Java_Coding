package seleniumConcepts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionHandling2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement register = driver.findElement(By.xpath("//a[text() = 'Register']"));
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform();
		String url = driver.getCurrentUrl();
		System.out.println(url);
//		Set<String> windowID =  driver.getWindowHandles();
		List<String> listOFWindowID = new ArrayList(driver.getWindowHandles());
//		List<String> listOFWindowID = new ArrayList(windowID);
        String secondWindowFocus = listOFWindowID.get(1);
        driver.switchTo().window(secondWindowFocus);
        String url1 = driver.getCurrentUrl();
        System.out.println(url1);
        driver.switchTo().window(listOFWindowID.get(0));
        driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Tshirts");
        driver.findElement(By.xpath("(//button[text() = 'Search'])[1]")).click();
		
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		
		
		
		
	}

}
