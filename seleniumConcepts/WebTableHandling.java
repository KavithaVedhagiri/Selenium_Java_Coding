package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println(totalRows.size());

		List<WebElement> totalColm = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println(totalColm.size());

		WebElement masterInselenium = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]"));
		System.out.println(masterInselenium.getText());

		List<WebElement> headerDatas = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println(headerDatas.size());
		for (WebElement headerData : headerDatas) {
			System.out.print(headerData.getText() + "\t");
		}
		System.out.println();

		for (int row = 2; row <= totalRows.size(); row++) {
			for (int col = 1; col <= totalColm.size(); col++) {
				String value = driver
						.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[" + col + "]"))
						.getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}

		for (int row = 2; row <= totalRows.size(); row++) {
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[2]"))
					.getText();
			if (authorName.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[1]"))
						.getText();
				System.out.println(bookName);
			}

		}
		int total = 0;
		for (int row = 2; row <= totalRows.size(); row++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[4]")).getText();
			total = total + Integer.parseInt(price);
		}
		System.out.println(total);

	}

}
