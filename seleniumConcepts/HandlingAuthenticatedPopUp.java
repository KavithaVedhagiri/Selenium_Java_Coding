package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticatedPopUp {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
//		driver.get("https://the-internet.herokuapp.com/basic_auth");
//		Syntax : https://username:password@the-internet.herokuapp.com/basic_auth
//		Handling Authentication Popup
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		WebElement basicAuthMessage = driver.findElement(By.xpath("//div[@id='content']//p"));
		String validationMessage = basicAuthMessage.getText();
		String actualMessage = "Congratulations! You must have the proper credentials.";
		if(validationMessage.equals(actualMessage)) {
			System.out.println("Authentication Successful");
		}
		else {
			System.out.println("Authentication Failed");
		}
	}

}
