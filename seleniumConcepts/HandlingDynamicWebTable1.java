package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicWebTable1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space(text()=' Login ')]")).click();
		driver.findElement(By.xpath("//span[text() = 'Admin']")).click();
		String text = driver.findElement(By.xpath("(//button[@type='button' and normalize-space(text()=' Add ')])[6]"))
				.getText();
		System.out.println(text);
		Thread.sleep(3000);

		List<WebElement> totalRow = driver.findElements(By.xpath("//div[@role='table']//div[@role='row']"));
		System.out.println(totalRow.size());

		List<WebElement> totalCol = driver.findElements(By.xpath("//div[@role='table']//div[@role=\"columnheader\"]"));
		System.out.println(totalCol.size());

//		String data = driver.findElement(By.xpath("//div[@role='table']//div[@role='row'][1]//div[@role='cell'] [2]")).getText();
//		System.out.println(data);

//		int totalData = driver.findElements(By.xpath("//div[@role='table']//div[@role='cell']")).size();
//		System.out.println(totalData);

//		List<WebElement> firstRowDatas = driver.findElements(By.xpath("//div[@role='table']//div[@role='row']//div[@role='cell'][2]"));
//		for(WebElement firstRowData : firstRowDatas ) {
//			System.out.println(firstRowData.getText());
//		}

//		List<WebElement> firstRowDatas1 = driver.findElements(By.xpath("(//div[@role='table']//div[@role='row'])[2]//div[@role='cell']"));
//		for(WebElement firstRowData1 : firstRowDatas1 ) {
//			System.out.println(firstRowData1.getText());
//		}

		for (int row = 2; row <= totalRow.size(); row++) {
			String dataList = driver
					.findElement(
							By.xpath("(//div[@role='table']//div[@role='row'])[" + row + "]//div[@role='cell'][4]"))
					.getText();
			if (dataList.equals("Peter Anderson")) {
				WebElement clickAction = driver.findElement(
						By.xpath("(//div[@role='table']//div[@role='row'])[" + row + "]//div[@role='cell'][1]"));
				clickAction.click();
			}
		}
		Thread.sleep(3000);
		driver.quit();

	}

}
