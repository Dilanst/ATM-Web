package com.google.search.po;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.search.util.Configuration;
import com.google.search.util.SeleniumUtils;


/**
 * <pre>
 * Fecha      Autor     
 * 06-10-2020 Dilan Steven Mejia	
 * </pre>
 * 
 * Pagina de resultados de busqueda.
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category POM
 * **/

public class ResultsPO {


	@FindAll({ @FindBy(css=".rc h3  span") })
	private List<WebElement> resultsList;

	public ResultsPO() {
		waitForLoadPage();
		PageFactory.initElements(Configuration.driver, this);
	}

	private void waitForLoadPage() {
		SeleniumUtils.waitForElement("rc","class",30);
	}

	public int getNumResults() {
		return  resultsList.size();
	}

	public String clickElementResultList(String nameLink,int position) throws NoSuchElementException {

		String elementText = "";

		if(resultsList.get(position).getText().contains(nameLink)) {
			elementText =	nameLink;
			resultsList.get(position).click();
		}else {
			elementText =	resultsList.get(position).getText();
			resultsList.get(position).click();
		}

		return  elementText;
	}


}
