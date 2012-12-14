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

//@Listeners(ScreenshotListener.class)
public class Works1_Test extends SeleniumBase {

	@Test
	public void HomePageTest() throws Exception {

		WebDriver driver = getDriver();

		Thread.sleep(2000);

		driver.get("http://www.zappos.com");

		WebElement element = driver.findElement(By.name("term"));

		element.sendKeys("Green Shoes");

		element.submit();

		System.out.println("Product Page Test" + "," + System.getProperty("ct.browser") + "," + "PASS" + "," + "No Stacktrace");

		driver.quit();
	}
}