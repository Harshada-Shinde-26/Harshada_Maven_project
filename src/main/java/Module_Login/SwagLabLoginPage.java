package Module_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
 @FindBy(xpath = "//input[@id='user-name']")private WebElement username;
 @FindBy(xpath = "//input[@id='password']")private WebElement password;
 @FindBy(xpath = "//input[@id='login-button']")private WebElement loginbtn;

  public SwagLabLoginPage(WebDriver driver)
 {
	PageFactory.initElements(driver,this );
 }
  
  public void  inpswgalabloginpageenterusername(String usernamevalue)
  {
	 username.sendKeys(usernamevalue); 
  }
  
  public void inpswaglabloginpageenterpassword(String passwordvalue)
  {
	  password.sendKeys(passwordvalue);
  }
  
  public void clickonloginbutton()
  {
	  loginbtn.click();
  }
}
