package com.google.search.util;


import java.nio.file.Path;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * <pre>
 * Fecha      Autor     
 * 06-10-2020 Dilan Steven Mejia	
 * </pre>
 * 
 * Aqui se inicia la configuración del driver y el js como un singleton 
 * para que se pueda utilizar solo en la capa de view y no se instancie mas 
 * de una vez.
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category Utils
 * **/

public class Configuration {
	public static WebDriver driver;
	public static JavascriptExecutor js;   

	public static void initConfiguration(){

		switch (PATH.BROWSER) {
		case CHROME:
			// crea una nueva instancia
			System.setProperty("webdriver.chrome.driver", PATH.DRIVER_BROWSER);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--lang=en-GB");
			chromeOptions.addArguments("--no-sandbox");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.get(PATH.URL);
			js = (JavascriptExecutor)driver;
			
			break;
		case FIREFOX:
			// crea una nueva instancia
			driver.get(PATH.URL);
			driver.manage().window().maximize();
			break;
		case IE:
			// crea una nueva instancia
			driver.get(PATH.URL);
			break;
		default:
			// crea una nueva instancia
			driver.get(PATH.URL);
			break;
		}

	}



}
