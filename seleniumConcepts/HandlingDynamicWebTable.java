package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://demo.opencart.com/admin/index.php");
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.navigate().refresh();
		WebElement userName = driver.findElement(By.id("input-username"));
		userName.clear();
		userName.sendKeys("demo");
		WebElement passWord = driver.findElement(By.id("input-password"));
		passWord.clear();
		passWord.sendKeys("demo");
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		driver.findElement(By.xpath("//a[@class= 'parent collapsed'and contains(text(),' Customers') ]")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		String textArea = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
		int totalPage = Integer.parseInt(textArea.substring(textArea.indexOf("(")+1, textArea.indexOf("Pages")-1));
		System.out.println(totalPage);
		
//        driver.findElement(By.xpath("//ul[@class='pagination']//*[text() = '2']")).click();
	

		for (int p = 1; p <=5; p++) {
			if (p >1) {
				WebElement active_page = driver
						.findElement(By.xpath("//ul[@class='pagination']//li//*[text() = "+p+"]]"));
				active_page.click();
				Thread.sleep(3000);
			}
		}

	
		driver.quit();

	}

}
