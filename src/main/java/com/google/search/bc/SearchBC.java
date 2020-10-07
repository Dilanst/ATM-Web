package com.google.search.bc;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

import com.google.search.po.BooksPO;
import com.google.search.po.HomePO;
import com.google.search.po.ResultsPO;


/**
 * <pre>
 * Fecha      Autor     
 * 06-10-2020 Dilan Steven Mejia	
 * </pre>
 * 
 * Busqueda en la pagina de google. (Logica de negocio)
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category BC
 * **/

public class SearchBC {

	final static Logger log = Logger.getLogger(SearchBC.class.getName());

	public static  String search(String nameSearch,String typeSearch) {

		int search = 0;

		try {
			if(typeSearch.equalsIgnoreCase("ButtonGoogleSearch")) {
				search = 
						new HomePO().
						search(nameSearch).
						submitSearch().
						getViewResult().
						getNumResults();
			}

			if(typeSearch.equalsIgnoreCase("SelectSuggestion")) {
				search = 
						new HomePO().
						search(nameSearch).
						selectFirstElementSuggestion().
						getViewResult().
						getNumResults();
			}
		} catch (NoSuchElementException e) {

			log.error(e.getMessage());
		}

		catch (Exception e) {

			log.error(e.getMessage());
		}



		return search>0?"YES":"NO";

	}


	public static  String clickElementSearched(String nameLink,int position)  {
		String elementText = "";
		try {
			elementText = 
					new ResultsPO().
					clickElementResultList(nameLink, position);


		} catch (NoSuchElementException e) {

			log.error(e.getMessage());
		}

		catch (Exception e) {

			log.error(e.getMessage());
		}


		return elementText;		
	}


	public static String getAuthor(String authorName) {
		String author = "";
		try {
			author = new BooksPO().
					getAuthor(authorName);
			
		} catch (NoSuchElementException e) {

			log.error(e.getMessage());
		}

		catch (Exception e) {

			log.error(e.getMessage());
		}


		return author;
	}



}
