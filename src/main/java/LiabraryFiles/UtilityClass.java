package LiabraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	WebDriver driver;
	
	public static String testdata(int rowIndex,int CellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Rahul Shinde\\eclipse-workspace\\Harshada_Mavens_project\\TestData");
	    Sheet sheet = WorkbookFactory.create(file).getSheet("DDF");
	    String text = sheet.getRow(rowIndex).getCell(CellIndex).getStringCellValue(); 
	    return text;
	}
	
	public static void capturescreenshot(WebDriver driver, int TCIDnumber) throws IOException
	{
		
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File dest= new File("C:\\Users\\Rahul Shinde\\eclipse-workspace\\Harshada_Mavens_project\\FailedTestCasesScreenShots");
	 FileHandler.copy(src, dest);   
	}
	

}
