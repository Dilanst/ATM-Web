package com.google.search.util;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


/**
 * <pre>
 * Fecha      Autor     
 * 06-10-2020 Dilan Steven Mejia	
 * </pre>
 * 
 * Metodos genericos reutilizables que ayuda con problemas 
 * repetitivos en la automatización.
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category Utils
 * **/

public class SeleniumUtils {

	public static WebElement waitForElement(String locator,String type) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(Configuration.driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		WebElement elementoPagina = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) {
				switch (type) {
				case "css":
					return driver.findElement(By.cssSelector(locator));
				case "xpath":
					return driver.findElement(By.xpath(locator));
				case "id":
					return driver.findElement(By.id(locator));
				case "class":
					return driver.findElement(By.className(locator));
				case "name":
					return driver.findElement(By.name(locator));
				default:
					break;
					
				}
				
				return null; 
			}
		});
		return elementoPagina;
	}

	
	public static WebElement waitForElement(String locator,String type,int tiempo) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(Configuration.driver)
				.withTimeout(Duration.ofSeconds(tiempo))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		WebElement elementoPagina = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) {
				switch (type) {
				case "css":
					return driver.findElement(By.cssSelector(locator));
				case "xpath":
					return driver.findElement(By.xpath(locator));
				case "id":
					return driver.findElement(By.id(locator));
				case "class":
					return driver.findElement(By.className(locator));
				case "name":
					return driver.findElement(By.name(locator));
				default:
					break;
					
				}
				
				return null; 
			}
		});
		return elementoPagina;
	}
	
	
	public static void scrollToElement(WebElement element) {
		Configuration.js.executeScript("arguments[0].scrollIntoView();", element);
		String scroll = "window.scroll(" + (element.getLocation().x ) + ","
				+ (element.getLocation().y -50) + ");";
		Configuration.js.executeScript(scroll, element);
	}
	
	//Se crea un metodo de espera implicita para esperar 
	//a que carguen las animaciones. 
	public static void waitAnimationElement() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
