package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() throws IOException {
		super();
		
	}
	public String verifyTittle() {
		return driver.getTitle(); 
	}
	
	public HomePage Login(String un, String pw) throws IOException {
		WebElement username =	driver.findElement(By.xpath("//input[@name='email']"));
		username.sendKeys(un);		
		WebElement password =	driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(pw);
		
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		return new HomePage();
	}
	
	

}
