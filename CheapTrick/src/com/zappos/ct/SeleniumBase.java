package com.zappos.ct;

import com.opera.core.systems.OperaDriver;

import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.URL;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeleniumBase {

	public static BrowserType browserType = null;
	private final static long MULTI_THREAD_START_UP_DELAY = 5000;
	private static List<WebDriver> webDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());
//	private static ThreadLocal<WebDriver> driverForThread = new ThreadLocal<WebDriver>() {
//
//
//		@Override
//		protected WebDriver initialValue() {
//			if (webDrivers.size() > 0) {
//				try {
//					Thread.sleep(MULTI_THREAD_START_UP_DELAY);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			WebDriver driver = loadWebDriver();
//			webDrivers.add(driver);
//			return driver;
//		}
//	};
//
//	@BeforeSuite
//	public static void setUpTest() {
//		//set browser property
//		if (System.getProperty("ct.browser") == null) {
//			System.setProperty("ct.browser", "firefox");
//		}
//
//		if (System.getProperty("ct.browser").toLowerCase().equals("ie")) {
//			browserType = BrowserType.IE;
//		} else if (System.getProperty("ct.browser").toLowerCase().equals("firefox")) {
//			browserType = BrowserType.FIREFOX;
//		} else if (System.getProperty("ct.browser").toLowerCase().equals("chrome")) {
//			browserType = BrowserType.CHROME;
//		} else if (System.getProperty("ct.browser").toLowerCase().equals("opera")) {
//			browserType = BrowserType.OPERA;
//		} else if (System.getProperty("ct.browser").toLowerCase().equals("safari")) {
//			browserType = BrowserType.SAFARI;
//		} else if (System.getProperty("ct.browser").toLowerCase().equals("htmlunit")) {
//			browserType = BrowserType.HTMLUNIT;
//		}	
//
//	}
	
	 public static WebDriver driver;
	 
	 @BeforeSuite
	 public void setUp() throws Exception {
		 
		//set browser property
		 if (System.getProperty("ct.browser") == null) {
			 DesiredCapabilities abilities = DesiredCapabilities.firefox();
			 driver = new RemoteWebDriver( new URL("http://ec2-54-241-124-236.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
		 } else if (System.getProperty("ct.browser").toLowerCase().equals("ie")) {
			 DesiredCapabilities abilities = DesiredCapabilities.internetExplorer();
			 driver = new RemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
		 } else if (System.getProperty("ct.browser").toLowerCase().equals("firefox")) {
			 DesiredCapabilities abilities = DesiredCapabilities.firefox();
			 driver = new RemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
		 } else if (System.getProperty("ct.browser").toLowerCase().equals("chrome")) {
			 DesiredCapabilities abilities = DesiredCapabilities.chrome();
			 driver = new RemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
		 } else if (System.getProperty("ct.browser").toLowerCase().equals("opera")) {
			 DesiredCapabilities abilities = DesiredCapabilities.opera();
			 driver = new RemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
		 } else if (System.getProperty("ct.browser").toLowerCase().equals("safari")) {
			 DesiredCapabilities abilities = DesiredCapabilities.safari();
			 driver = new RemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
		 } else if (System.getProperty("ct.browser").toLowerCase().equals("htmlunit")) {
			 DesiredCapabilities abilities = DesiredCapabilities.firefox();
			 driver = new RemoteWebDriver( new URL("http://ec2-204-236-162-173.us-west-1.compute.amazonaws.com:4444/wd/hub"), abilities);
		 }

	 }
	 
	 protected static WebDriver getDriver() {
		return driver;
	 }

	@AfterSuite
	public static void tearDown() {
		for (WebDriver driver : webDrivers) {
			driver.quit();
		}
	}

//	private static WebDriver loadWebDriver() {
//		System.out.println("Current Operating System: " + System.getProperties().getProperty("os.name"));
//		System.out.println("Current Architecture: " + System.getProperties().getProperty("os.arch"));
//		System.out.println("Current Browser Selection: " + browserType);
//
//		//Instantiate driver object
//		switch (browserType) {
//		case FIREFOX:
//			DesiredCapabilities abilities = DesiredCapabilities.firefox();
//			return new FirefoxDriver();
//		case CHROME:
//			DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();
//			chromeCaps.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
//
//			return new ChromeDriver(chromeCaps);
//		case IE:
//
//			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
//			ieCaps.setCapability("enablePersistantHover", false);
//
//			return new InternetExplorerDriver(ieCaps);
//		case SAFARI:
//			DesiredCapabilities safariCaps = DesiredCapabilities.safari();
//			safariCaps.setCapability("safari.cleanSession", true);
//
//			return new SafariDriver(safariCaps);
//		case OPERA:
//			DesiredCapabilities operaCaps = DesiredCapabilities.opera();
//			operaCaps.setCapability("opera.arguments", "-nowin -nomail");
//
//			return new OperaDriver(operaCaps);
//		default:
//			DesiredCapabilities htmlUnitCaps = DesiredCapabilities.htmlUnit();
//			htmlUnitCaps.setCapability("javascriptEnabled", "true");
//
//			return new HtmlUnitDriver(htmlUnitCaps);
//		}
//	}


}