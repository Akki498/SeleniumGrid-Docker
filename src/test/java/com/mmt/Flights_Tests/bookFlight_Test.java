package com.mmt.Flights_Tests;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.mmt.TestBase.TestBase;
import com.mmt.utils.TestUtil;

public class bookFlight_Test extends TestBase {
	
	
	
	@Test(priority=0)
	   public static void LaunchBrowser() throws Exception {
			
			
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		
		URL url = new URL("http://13.233.86.244:4444/wd/hub");
		
		RemoteWebDriver driver =new RemoteWebDriver(url, dc);
		
		/*driver.manage().window().maximize();
		driver.manage().deleteAllCookies();*/
		
		/*driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		*/
		driver.get("https://www.facebook.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		try{
		assert (title.equalsIgnoreCase("Google")):"Tite is not matched";
		}catch(Throwable t){
			fnsTake_Screen_Shot("Title Screenshot");
			
		}
		
		driver.quit();

		}
	
	
	//Function to Take Screen Shot.
	public static void fnsTake_Screen_Shot(String message) throws Exception {
		//String MessageAfterFormat=fnsRemoveFormatting_for_FileName(message);
			try{
			   FileUtils.forceMkdir(new File((System.getProperty("user.dir") + "//screenshots//")));
			   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			   Rectangle screenRectangle = new Rectangle(screenSize);
			   Robot robot = new Robot();
			   BufferedImage image = robot.createScreenCapture(screenRectangle);
			   ImageIO.write(image, "png", new File((System.getProperty("user.dir") + "//screenshots//" +".PNG")));
			}catch(java.lang.NullPointerException n){
				//fnsApps_Report_Logs("ScreenShotNullPointerException >> "+n.getMessage());
				throw new Exception("NullPointerException Unable To take Screen Shots.");}
			 catch(java.io.IOException e){
				//fnsApps_Report_Logs("ScreenShotIOException >> "+e.getMessage());
				throw new Exception("IOException Unable To take Screen Shots.");}
	}

	
	
	
	

}
