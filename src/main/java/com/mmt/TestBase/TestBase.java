package com.mmt.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import com.mmt.utils.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static boolean initializationFlag = false;
	public static Long Element_Max_Wait_Time = null;
	public static DesiredCapabilities caps;
	public static ChromeOptions options;
	public static long TC_Step = 0;
	//public static Xls_Reader Free_Crm_Suitexls = null;
	
	
	
	
	
	
	public void initialization() {
		
		

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\mmt\\config\\mmt.config.properties");
			prop.load(ip);
			
			/*InputStream loggerStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//log4j.properties"); //src\test\resources\log4j.properties
			Properties prop = new Properties();
			prop.load(loggerStream);
			PropertyConfigurator.configure(prop);*/
			//APP_LOGS = Logger.getLogger("devpinoyLogger");
			
			//Free_Crm_Suitexls = new Xls_Reader(System.getProperty("user.dir") + "//src//test//resources//TestData.xlsx");

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//@BeforeSuite
	public static void LaunchBrowser() throws Exception {
		
		

		String Browsername = prop.getProperty("Browser");
		System.out.println(("Running Browser is: " + Browsername));

		Element_Max_Wait_Time = Long.parseLong("20");
		
		
		
		
		if (Browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
		} else {
			if (Browsername.equals("Firefox")) {
				System.setProperty("webdriver.Firefox.driver", "D:\\Selenium_Browser_Drivers\\chromedriver.exe");
				 driver = new FirefoxDriver();
				

			}

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		Thread.sleep(300);

	}
	
	
	
}
