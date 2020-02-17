package com.mmt.utils;

import java.util.Date;

import org.openqa.selenium.WebElement;

import com.mmt.TestBase.TestBase;

public class TestUtil extends TestBase {
	
	
	public static long PAGE_LOAD_TIMEOUT = 120;

	public static long IMPLICIT_WAIT = 60;
	
	
	// common methods

	public void SwitchToFrame(String framename) {

		driver.switchTo().frame(framename);
	}
	
	public void fnaclickOnMenu(WebElement element, int maxTimeAllotedTimeInSec) {

		  long startTime = new Date().getTime();

		  try {
		   element.click();
		  } catch (Exception e) {
		   long currentTime = new Date().getTime();
		   int diffInSec = (int) ((currentTime - startTime) / 1000);
		   int timeLeft = maxTimeAllotedTimeInSec - diffInSec;

		   if (timeLeft > 0)
			   fnaclickOnMenu(element, timeLeft);
		  }
		 }

}

	
	
	


