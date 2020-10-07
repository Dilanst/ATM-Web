package com.google.search.po;

import org.openqa.selenium.NoSuchElementException;

import com.google.search.util.SeleniumUtils;

/**
 * <pre>
 * Fecha      Autor     
 * 06-10-2020 Dilan Steven Mejia	
 * </pre>
 * 
 * Pagina de libros.
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category POM
 * **/

public class BooksPO {

	public BooksPO() {
		waitForLoadPage();
	}

	private void waitForLoadPage() {
		SeleniumUtils.waitForElement("//td/a[contains(text(),'Patrick Rothfuss')]","css");
	}

	public String getAuthor(String nameAuthor) throws NoSuchElementException {

		String author = "";

		author = SeleniumUtils.waitForElement("//td/a[contains(text(),'"+nameAuthor+"')]","css").getText();
		
		return  author;
	}


}
