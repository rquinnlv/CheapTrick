package com.zappos.ct.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.zappos.ct.ScreenshotListener;
import com.zappos.ct.SeleniumBase;

@Listeners(ScreenshotListener.class)
public class Fail5_Test extends SeleniumBase {
	
	@Test
    public static void HomePageFail() {
		
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = getDriver();
        
        // And now use this to visit Zappos homepage
        driver.get("http://www.zappos.com");
        
        // Check the title of the page
        String helpLinks = new String();
        try {
            driver.findElement(By.id("helpLinks")).getText();// element fails to match foo
            driver.findElement(By.name("helpLinks")).getText();// fails to find element
            if (!helpLinks.equals("foo"))
                System.out.println("Failure5");   
        } 
        catch (NoSuchElementException e) {
            System.out.println("couldnt find element-t5!");
        }
        
    }
    
}