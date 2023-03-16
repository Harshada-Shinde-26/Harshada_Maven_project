package Module_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabHomePage 
{
 @FindBy(xpath = "//div[@class='app_logo']")private WebElement logo;
 @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")private WebElement addTocartbtn;
 @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory']")private WebElement removebtn;
 
 public SwaglabHomePage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
 public boolean getlogoresult()
 {
	   boolean actResult = logo.isDisplayed();
	   return actResult;
 }
 
 public void clickonaddTocartbtn()
 {
	 addTocartbtn.click();
 }
 
 public String getremovebtnText()
 {
	  String actResult = removebtn.getText();
	  return actResult;
 }

}
