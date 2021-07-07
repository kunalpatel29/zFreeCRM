package initialTest;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.FreeAc;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	pages.ContactsPage cp;
	FreeAc fa;
  public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@Test
  public void LoginPageTest() throws IOException {
	
	Assert.assertEquals(lp.verifyTittle(), "Cogmento CRM");
  }

@Test
public void HomePageTest() throws IOException {
	
	
	Assert.assertEquals(hp.verifyTittle(), "Cogmento CRM");
	Assert.assertEquals(hp.verifyUser(),"Kunal Patel");
	System.out.println(hp.verifyUser());
}
@Test
public void ContactsPageTest() throws IOException {
	cp = hp.clickOnContacts();
	Assert.assertEquals(cp.verifyTittle(), "Contacts");
	
}
@Test
public void FreeAcTest() throws IOException {
	fa = hp.clickOnFreeAccount();
	fa.verifyImage();
	
	
	
	
}


	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  initialization();
	  lp = new LoginPage();
	  hp = lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	  
  }

  @AfterMethod
  public void afterMethod() {
	  closeBrowser();
  }

}
