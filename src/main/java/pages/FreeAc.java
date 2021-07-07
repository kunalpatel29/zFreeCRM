package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class FreeAc extends BaseClass {

	public FreeAc() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean verifyImage() {
		WebElement image = driver.findElement(By.xpath("//div[contains(text(),'Your Current Plan')]/.."));
		return image.isDisplayed();
	}

}
