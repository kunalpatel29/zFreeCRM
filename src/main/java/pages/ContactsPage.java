package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ContactsPage extends BaseClass {
	
	public ContactsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public String verifyTittle() {
		String contacts = driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")).getText();
		return contacts;
	}
	public void selectContact(String name) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//WebElement contact = driver.findElement(By.xpath("//tr[@class = 'warning']//a[contains(text(),'"+name+"')]/../../td[1]/div"));
		WebElement contact = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/../../td[1]/div[1]"));
		jse.executeScript("arguments[0].click();", contact);
	}
	public void createNewContact(String name, String surname, String status) {
		WebElement firstName = driver.findElement(By.xpath("//input[@name='first_name']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));
		firstName.sendKeys(name);
		lastName.sendKeys(surname);
		driver.findElement(By.xpath("//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/form[@class='ui form segment custom-form-container']/div[5]/div[1]/div[1]/div[1]")).click();
		WebElement st = driver.findElement(By.xpath("//div[@name='status']/span[contains(text(),'"+status+"')]"));
		st.click();
		driver.findElement(By.xpath("//i[@class='save icon']")).click();
	}
	

}
