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
 * Pagina de google.
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category POM
 * **/

public class HomePO {

	@FindBy(name="q")
	private WebElement searchTextBox;


	@FindBy(name="btnK")
	private WebElement searchButton;
	
	public HomePO() {
		waitForLoadPage();
		PageFactory.initElements(Configuration.driver, this);
	}

	private void waitForLoadPage() {
		SeleniumUtils.waitForElement("q","name",15);
	}
	
	public HomePO search(String nameSearch) throws NoSuchElementException{
		searchTextBox.sendKeys(nameSearch);
		return this;
	}
	
	public HomePO submitSearch() throws NoSuchElementException{
		searchButton.submit();
		return this;
	}
	
	public HomePO selectFirstElementSuggestion() throws NoSuchElementException{
		SeleniumUtils.waitAnimationElement();
		SeleniumUtils.waitForElement("sbl1","class").click();
		return this;
	}
	
	public ResultsPO getViewResult() {
		return new ResultsPO();
	}
	
}
