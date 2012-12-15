package com.zappos.ct;



import com.opera.core.systems.OperaDriver;

import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.io.StringWriter;

public class SeleniumBase {

	public static BrowserType browserType = null;
	private final static long MULTI_THREAD_START_UP_DELAY = 5000;
	private static List<RemoteWebDriver> RemoteWebDrivers = Collections.synchronizedList(new ArrayList<RemoteWebDriver>());
	private static ThreadLocal<RemoteWebDriver> driverForThread = new ThreadLocal<RemoteWebDriver>() {


		@Override
		protected RemoteWebDriver initialValue() {
			if (RemoteWebDrivers.size() > 0) {
				try {
					Thread.sleep(MULTI_THREAD_START_UP_DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			RemoteWebDriver driver = null;
			try {
				driver = loadRemoteWebDriver();
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
			RemoteWebDrivers.add(driver);
			return driver;
		}
	};

	@BeforeSuite
	public static void setUpTest() {
		//set browser property
		if (System.getProperty("ct.browser") == null) {
			System.setProperty("ct.browser", "chrome");
		}

		if (System.getProperty("ct.browser").toLowerCase().equals("ie")) {
			browserType = BrowserType.IE;
		} else if (System.getProperty("ct.browser").toLowerCase().equals("firefox")) {
			browserType = BrowserType.FIREFOX;
		} else if (System.getProperty("ct.browser").toLowerCase().equals("chrome")) {
			browserType = BrowserType.CHROME;
		} else if (System.getProperty("ct.browser").toLowerCase().equals("opera")) {
			browserType = BrowserType.OPERA;
		} else if (System.getProperty("ct.browser").toLowerCase().equals("safari")) {
			browserType = BrowserType.SAFARI;
		} else if (System.getProperty("ct.browser").toLowerCase().equals("htmlunit")) {
			browserType = BrowserType.HTMLUNIT;
		}	

	}
	
//	 public static RemoteWebDriver driver;
//	 
//	 @BeforeSuite
//	 public void setUp() throws Exception {
//		 
//		//set browser property
//		 if (System.getProperty("ct.browser") == null) {
//			 DesiredCapabilities abilities = DesiredCapabilities.firefox();
//			 driver = new RemoteRemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		 } else if (System.getProperty("ct.browser").toLowerCase().equals("ie")) {
//			 DesiredCapabilities abilities = DesiredCapabilities.internetExplorer();
//			 driver = new RemoteRemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		 } else if (System.getProperty("ct.browser").toLowerCase().equals("firefox")) {
//			 DesiredCapabilities abilities = DesiredCapabilities.firefox();
//			 driver = new RemoteRemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		 } else if (System.getProperty("ct.browser").toLowerCase().equals("chrome")) {
//			 DesiredCapabilities abilities = DesiredCapabilities.chrome();
//			 driver = new RemoteRemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		 } else if (System.getProperty("ct.browser").toLowerCase().equals("opera")) {
//			 DesiredCapabilities abilities = DesiredCapabilities.opera();
//			 driver = new RemoteRemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		 } else if (System.getProperty("ct.browser").toLowerCase().equals("safari")) {
//			 DesiredCapabilities abilities = DesiredCapabilities.safari();
//			 driver = new RemoteRemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		 } else if (System.getProperty("ct.browser").toLowerCase().equals("htmlunit")) {
//			 DesiredCapabilities abilities = DesiredCapabilities.firefox();
//			 driver = new RemoteRemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		 }
//
//	 }



	@AfterSuite
	public static void tearDown() {
		for (RemoteWebDriver driver : RemoteWebDrivers) {
			driver.quit();
		}
	}

	private static RemoteWebDriver loadRemoteWebDriver() throws MalformedURLException{
		System.out.println("Current Operating System: " + System.getProperties().getProperty("os.name"));
		System.out.println("Current Architecture: " + System.getProperties().getProperty("os.arch"));
		System.out.println("Current Browser Selection: " + browserType);
		
		DesiredCapabilities abilities = DesiredCapabilities.firefox();
		//Instantiate driver object
		
		if (System.getProperty("ct.browser").toLowerCase().equals("ie")) {
			abilities = DesiredCapabilities.internetExplorer();
		} else if (System.getProperty("ct.browser").toLowerCase().equals("firefox")) {
			abilities = DesiredCapabilities.firefox();
		} else if (System.getProperty("ct.browser").toLowerCase().equals("chrome")) {
			abilities = DesiredCapabilities.chrome();
		} else if (System.getProperty("ct.browser").toLowerCase().equals("opera")) {
			abilities = DesiredCapabilities.opera();
		} else if (System.getProperty("ct.browser").toLowerCase().equals("safari")) {
			abilities = DesiredCapabilities.safari();
		}	
//		
//		switch (browserType) {
//		case FIREFOX:
//			abilities = DesiredCapabilities.firefox();
//		case CHROME:
//			abilities = DesiredCapabilities.chrome();
//		case IE:
//			abilities = DesiredCapabilities.internetExplorer();
//		case SAFARI:
//			abilities = DesiredCapabilities.safari();
//		case OPERA:
//			abilities = DesiredCapabilities.opera();
//		default:
//			abilities = DesiredCapabilities.chrome();
//		}
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://ec2-54-241-80-250.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
//		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), abilities);

		return driver;
	}
	 protected static RemoteWebDriver getDriver() {
		 return driverForThread.get();
	 }

}