package ModuleTest_Login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LiabraryFiles.BaseClass;
import Module_Login.SwagLabLoginPage;
import Module_Login.SwaglabHomePage;

public class SwagLabActualTestClassInTestNG extends BaseClass
{
	WebDriver driver;
	SwagLabLoginPage loginPage;
	SwaglabHomePage homepage;
	SwagLabLogOutPage logoutpage;
	
	@BeforeClass
	public void openWebpage() throws EncryptedDocumentException, IOException
	{   
		FileInputStream file = new FileInputStream("E:\\Harshada's Folder\\Study\\Salenium\\Book1.xlsx");
	     sheet = WorkbookFactory.create(file).getSheet("DDF");
	     intilisebrowser();
		 loginPage = new SwagLabLoginPage(driver);
		 homepage = new SwaglabHomePage(driver);
         logoutpage = new SwagLabLogOutPage(driver);
	}
	
	@BeforeMethod
	public void loginWebpage() throws InterruptedException 
	{
		 loginPage.inpswgalabloginpageenterusername(sheet.getRow(0).getCell(0).getStringCellValue());
		 Thread.sleep(2000);
		 
		 loginPage.inpswaglabloginpageenterpassword(sheet.getRow(0).getCell(1).getStringCellValue());
		 Thread.sleep(2000);
		 
		 loginPage.clickonloginbutton();
         Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	public void getlogoresult()
	{
		boolean Actresult = homepage.getlogoresult();
	    assertTrue(Actresult,"Failed logo is not present");
	}
	
	@Test(priority = 2)
	public void clickonaddTocartBtn() throws InterruptedException
	{
	homepage.clickonaddTocartbtn();
	Reporter.log("AddTocart Button is Clickable");
	Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void getremovebtnresult()
	{    
	     
    String actResult = homepage.getremovebtnText();
	String expResult = sheet.getRow(0).getCell(2).getStringCellValue();
	assertEquals(actResult,expResult,"Both Are Diffrent");
	}
	
	@AfterMethod
	public void logoutWebpage() throws InterruptedException
	{
		 logoutpage = new SwagLabLogOutPage(driver);
		 logoutpage.clickonmenubtn();
		 Thread.sleep(3000);
		 logoutpage.clickonlogoutbtn();
		 
	}
	
	@AfterClass
	public void closeWebapge()
	{
        driver.quit();
		 
	}

}
