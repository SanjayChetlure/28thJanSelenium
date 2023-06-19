package POM_DDF_TestNG_BaseClass_UtilityClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PBLoginTest1 extends BaseClass
{
	PBLoginPage login;
	PBMobNumPage mobNum;
	PBPwdPage pwd;
	PBHomePage home;
	PBMyAccPage myAcc;
	PBProfilePage profile;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		initializeBrowser();
		 login=new PBLoginPage(driver);
		 mobNum=new PBMobNumPage(driver);
		 pwd=new PBPwdPage(driver);
		 home=new PBHomePage(driver);
		 myAcc=new PBMyAccPage(driver);
		 profile=new PBProfilePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		login.clickPBLoginPageSignIN();
		mobNum.inpPBMobNumPageMobNum(UtilityClass.getTestData(0, 0));
		mobNum.clickPBMobNumPageSignInWithPwd();
		pwd.inpPBPwdPagePWD(UtilityClass.getTestData(0, 1));
		pwd.clickPBPwdPageSignIn();
		Thread.sleep(3000);
	}
	
	
	@Test
	public void verifyFullName() throws InterruptedException, EncryptedDocumentException, IOException
	{
		home.openDDOptionPBHomePageMyAcc();
		Thread.sleep(2000);
		myAcc.clickPBMyAccPageMyProfile();
		profile.switchToSwitchChildWindow();
		//profile.verifyPBProfilePageFullName(sh.getRow(0).getCell(2).getStringCellValue());
		
		String actResult=profile.getPBProfilePageFullName();
		String expResult=UtilityClass.getTestData(0, 2);
		Assert.assertEquals(actResult, expResult,"Failed: both results are diff-: ");
	}
	
	@AfterMethod
	public void logoutFromApp() 
	{
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();		
	}

}
