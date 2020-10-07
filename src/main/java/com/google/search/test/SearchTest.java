package com.google.search.test;


import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.google.search.bc.SearchBC;
import com.google.search.dal.SearchDAL;
import com.google.search.dal.dto.BookDTO;
import com.google.search.util.Configuration;
import com.google.search.util.PATH;


/**
 * <pre>
 * Fecha      Autor     
 * 06-10-2020 Dilan Steven Mejia	
 * </pre>
 * 
 * Busqueda en la pagina de google. (Pasos de pruebas)
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category Test
 * **/

public class SearchTest {
	
	
    private BookDTO book;

	@DataProvider(name = "books")
    public static Iterator<BookDTO> getData() {
        return SearchDAL.getSearch(PATH.DATA_POOL).iterator();
    }
    
    @Factory(dataProvider = "books")
    public SearchTest(BookDTO book) {
        this.book = book;
    }


    /**
	 * <pre>
	 * Fecha      Autor     
	 *	06-10-2020 Dilan Steven Mejia
	 * </pre>
	 * 
	 * Ingresa la configuracion del navegador,la url, y la ruta del archivo de la data.
	 * 
	 * @author Dilan Steven Mejia
	 * 
	 * **/
	@Test
	public void setup(){
		Configuration.initConfiguration();
	}

    /**
	 * <pre>
	 * Fecha      Autor     
	 *	06-10-2020 Dilan Steven Mejia
	 * </pre>
	 * 
	 * Realizar una busqueda.
	 * 
	 * @author Dilan Steven Mejia
	 * 
	 * **/
	@Test 
	public void search() {
 			Assert.assertEquals(book.getExpectedRecord(), SearchBC.search(book.getQuery(),book.getTypeSearch()),"No found records ");

	}
	
	/**
	 * <pre>
	 * Fecha      Autor     
	 *	06-10-2020 Dilan Steven Mejia
	 * </pre>
	 * 
	 * Realiza click en una lista de busqueda.
	 * 
	 * @author Dilan Steven Mejia
	 * 
	 * **/
	@Test
	public void clickElementSearched() {
			Assert.assertEquals(book.getTitle(),SearchBC.clickElementSearched(book.getTitle(), 0),"First element  " );
	}
	
	
	/**
	 * <pre>
	 * Fecha      Autor     
	 *	06-10-2020 Dilan Steven Mejia
	 * </pre>
	 * 
	 * Realiza click en el autor.
	 * 
	 * @author Dilan Steven Mejia
	 * 
	 * **/
	@Test 
	public void clickAuthor() {
			Assert.assertEquals(book.getAuthor(),SearchBC.getAuthor(book.getAuthor()),"No is the page, expected the author ");

	}

	//Se cierran las sesiones del driver.
	@Test 
	public void stopAllDrivers() {
		Configuration.driver.quit();
	}  
}