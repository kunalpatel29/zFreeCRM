package pages;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() throws IOException {
		super();
		
	}
	public String verifyTittle() {
		return driver.getTitle();
	}
	public String verifyUser() {
		String user = driver.findElement(By.xpath("//span[@class='user-display']")).getText();
		
		return user;
	}
	public ContactsPage clickOnContacts() throws IOException {
		Actions pointer = new Actions(driver);
		
		WebElement contacts = driver.findElement(By.xpath("//i[@class='users icon']"));
		
		pointer.moveToElement(contacts).build().perform();
		
		driver.findElement(By.xpath("//i[@class='users icon']")).click();
		
		return new ContactsPage();
	}
	
	public FreeAc clickOnFreeAccount() throws IOException {
		
		
		
		
		WebElement free = driver.findElement(By.linkText("Free account"));
		
		free.click();
		return new FreeAc();
	}
	public ContactsPage clickOnNewContact() throws IOException {
		Actions pointer = new Actions(driver);
		WebElement contacts = driver.findElement(By.xpath("//i[@class='users icon']"));
		pointer.moveToElement(contacts).build().perform();
		driver.findElement(By.xpath("//i[@class='users icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		
		return new ContactsPage();
		
	}
	
	
}
