package com.zappos.ct.tests;

import com.zappos.ct.SeleniumBase;
import com.zappos.ct.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.*;
//@Listeners(ScreenshotListener.class)
public class Works15_Test extends SeleniumBase {
    
    @Test
    public void HomePageTest() throws Exception {
        
        WebDriver driver = getDriver();
        
        Thread.sleep(2000);
        
        driver.get("http://www.zappos.com");
        
        WebElement element = driver.findElement(By.name("term"));
        
        element.sendKeys("Green Shoes");
        
        element.submit();
        
        /*    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver d) {
         return d.getTitle().toLowerCase().startsWith("green shoes");
         }
         });*/
        
        try{
        	  FileWriter fstream = new FileWriter("../../idontcare.txt",true);
        	  BufferedWriter out = new BufferedWriter(fstream);
        	  out.write("HomePage Test" + "," + System.getProperty("ct.browser") + "," + "PASS" + "," + "No Stacktrace" + "," + " " + "\n");
        	  out.close();
        	  }catch (Exception e){//Catch exception if any
        	  System.err.println("Error: " + e.getMessage());
        	  }        
        driver.quit();
    }
}