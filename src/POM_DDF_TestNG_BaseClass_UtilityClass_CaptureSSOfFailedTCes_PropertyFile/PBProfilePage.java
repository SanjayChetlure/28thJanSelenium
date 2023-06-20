package POM_DDF_TestNG_BaseClass_UtilityClass_CaptureSSOfFailedTCes_PropertyFile;
//pom class 6

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBProfilePage 
{
	@FindBy(xpath = "//input[@name='personName']") private WebElement fullName;
	WebDriver driver1;

	
	public  PBProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void switchToSwitchChildWindow()
	{
		Set<String> allIds = driver1.getWindowHandles();
		ArrayList<String> al=new ArrayList<>(allIds);
		driver1.switchTo().window(al.get(1));
	}
	
	
	
	public String getPBProfilePageFullName() 
	{
		String actFullName = fullName.getAttribute("value");
		return actFullName;
	}
	
	
//	public void verifyPBProfilePageFullName(String expName) 
//	{
//		String actName = fullName.getAttribute("value");
//		
//		if(actName.equals(expName))
//		{
//			System.out.println("TC Pass");
//		}
//		else
//		{
//			System.out.println("TC Fail");
//		}		
//	}
}
