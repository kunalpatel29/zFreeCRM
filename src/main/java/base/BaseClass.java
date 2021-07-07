package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import eventListener.WebEventListener;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
public BaseClass() throws IOException {
	FileInputStream f = new FileInputStream("C:\\Users\\Dr. Kunal\\Desktop\\QA\\Selenium_WorkSpace"
			+ "\\ZfreeCrmTest\\src\\main\\java\\Utility\\utility.properties");
	prop = new Properties();
	prop.load(f);
	
}
	


public static void initialization() throws IOException {
	
	String browserName = prop.getProperty("browser");
	System.out.println(browserName);
	if (browserName.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dr. Kunal\\Desktop\\QA\\SeleniumJars\\geckodriver.exe");
		driver=new FirefoxDriver();	
	}else if (browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dr. Kunal\\Desktop\\QA\\SeleniumJars\\chromedriver.exe");
		driver=new ChromeDriver();	
	
}
	//driver.get(prop.getProperty("url"));
	e_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}
public void closeBrowser() {
	driver.quit();
}

}
