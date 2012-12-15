package com.zappos.ct.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.*;

import com.zappos.ct.ScreenshotListener;
import com.zappos.ct.SeleniumBase;

//@Listeners(ScreenshotListener.class)
public class Fail_Test extends SeleniumBase {
	
	@Test
    public static void HomePageFail() {
		
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        WebDriver driver = getDriver();

        // And now use this to visit Zappos homepage
        driver.get("http://www.zappos.com");

        String stackTrace = "com.thoughtworks.selenium.SeleniumException: ERROR: Element //*[@id='searchResults']/a[1]/span[3]/span[@class='price'] not found at com.thoughtworks.selenium.HttpCommandProcessor.throwAssertionFailureExceptionOrError(HttpCommandProcessor.java:112) at com.thoughtworks.selenium.HttpCommandProcessor.doCommand(HttpCommandProcessor.java:106) at com.thoughtworks.selenium.HttpCommandProcessor.getString(HttpCommandProcessor.java:275) at com.thoughtworks.selenium.DefaultSeleniumZappos.getText(DefaultSeleniumZappos.java:634) at com.zappos.ztaf.module.navigation.search.SearchResultTest.verifySalePriceOnProductPage(SearchResultTest.java:78) at java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886) at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908) at java.lang.Thread.run(Thread.java:619) ... Removed 17 stack frames";
        
        // Check the title of the page
        String helpLinks = new String();
        try {
            driver.findElement(By.id("helpLinks")).getText();// element fails to match foo
            driver.findElement(By.name("helpLinks")).getText();// fails to find element
            if (!helpLinks.equals("foo"))
            	System.out.println("HomePage Test" + "," + System.getProperty("ct.browser") + "," + "FAIL" + "," + stackTrace + "," + "/screenshots/1355361154529_HomePageTest.png");
        } 
        catch (NoSuchElementException e) {
        	System.out.println("HomePage Test" + "," + System.getProperty("ct.browser") + "," + "FAIL" + "," + stackTrace + "," + "/screenshots/1355361154529_HomePageTest.png");
        }
        
        try{
        	  FileWriter fstream = new FileWriter("idontcare.txt",true);
        	  BufferedWriter out = new BufferedWriter(fstream);
        	  out.write("HomePage Test" + "," + System.getProperty("ct.browser") + "," + "FAIL" + "," + stackTrace + "," + "/screenshots/1355361154529_HomePageTest.png"+"\n");
        	  out.close();
        	  }catch (Exception e){//Catch exception if any
        	  System.err.println("Error: " + e.getMessage());
        	  }
    }

}