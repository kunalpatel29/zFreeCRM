package initialTest;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import testData.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class ContactsTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	ContactsPage cp;
	String sheetName = "Data";
	
  public ContactsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
//@Test
  public void f() throws IOException {
	cp = new ContactsPage();
	cp.selectContact("kavita");
  }

@Test(dataProvider = "getCRMTestData")
public void createContactTest(String firstname, String lastname, String status) throws IOException {
	hp.clickOnNewContact();
	 cp = new ContactsPage();
	//cp.createNewContact("pankil", "shah", "New");
	cp.createNewContact(firstname, lastname, status);
	
}

@DataProvider
public Object[][] getCRMTestData(){
	
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}

  @BeforeMethod
  public void beforeMethod() throws IOException {
	  initialization();
	  lp = new LoginPage();
	  hp = lp.Login(prop.getProperty("username"), prop.getProperty("password"));
//	  hp.clickOnContacts();
	 
//	  
  }

  @AfterMethod
  public void afterMethod() {
	 closeBrowser();
	  
  }

}
