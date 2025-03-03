package seleniumConcepts;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDatePickers2 {
	static WebDriver driver;
	
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtDate']")));
		until.click();
		
	}
	
	public void pastDate(WebDriver driver, String month, String year, String date) throws InterruptedException {
		
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				List<WebElement> dates = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
				for(WebElement dt : dates) {
					if(dt.getText().equals(date)) {
						dt.click();
					}
			}	
		}
			else {
				driver.findElement(By.xpath("//span[text() = 'Prev']")).click();
			}
		
		
		
//		Thread.sleep(5000);

	}
}
//	//User defined method for converting month from string---->string
//	public static Month convertMonths(String month) {
//		HashMap<String,java.time.Month> monthMap = new HashMap<String,Month>();
//		
//		monthMap.put("January",Month.JANUARY);
//		monthMap.put("February",Month.FEBRUARY);
//		monthMap.put("March",Month.MARCH);
//		monthMap.put("April",Month.APRIL);
//		monthMap.put("May",Month.MAY);
//		monthMap.put("June",Month.JUNE);
//		monthMap.put("July",Month.JULY);
//		monthMap.put("August",Month.AUGUST);
//		monthMap.put("September",Month.SEPTEMBER);
//		monthMap.put("October",Month.OCTOBER);
//		monthMap.put("November",Month.NOVEMBER);
//		monthMap.put("December",Month.DECEMBER);
//		
//		Month vMonth = monthMap.get(month);
//		
//		if(vMonth == null) {
//			System.out.println("Invalid Month");
//		}
//		return vMonth;
//		
//	}
	
	public void futureDate(WebDriver driver, String month, String year, String date) throws InterruptedException {
//		driver.findElement(By.xpath("")).click();
       //Select Month
		
		WebElement monthDrapDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select sct = new Select(monthDrapDown);
		sct.selectByVisibleText(month);
		
		//Select Year
				WebElement yearDrapDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				Select sc = new Select(yearDrapDown);
				sc.selectByValue(year);
		
		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
		for(WebElement dt : dates) {
			if(dt.getText().equals(date)) {
				dt.click();
			}
		}
		
		
//		driver.findElement(By.xpath("//span[text()='Next']")))
	
	}


	public static void main(String[] args) throws InterruptedException {
		HandlingDatePickers2 hdp = new HandlingDatePickers2();
		hdp.launchBrowser();
		
	    
		String month = "May";
		String year = "2024";
		String date = "20";
		hdp.pastDate(driver,month,year,date);
		
		String fmonth = "Mar";
		String fyear = "2026";
		String fdate = "20";
		
		hdp.futureDate(driver,fmonth,fyear,fdate);
		
	}

}
