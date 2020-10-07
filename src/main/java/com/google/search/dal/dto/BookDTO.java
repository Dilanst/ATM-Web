package com.google.search.dal.dto;

public class BookDTO {

	private String author;
	private String title;
	private String expectedRecord;
	private String expectedAuthor;
	private String query;
	private String typeSearch;
	
	
	public String getAuthor() {
		return author;
	}
	/**
	 * <p>Nombre del autor</p>
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * <p>Titulo del libro</p>
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * <p>Numero de resultados por titulo</p>
	 */
	public String getExpectedRecord() {
		return expectedRecord;
	}
	public void setExpectedRecord(String expectedRecord) {
		this.expectedRecord = expectedRecord;
	}
	
	/**
	 * <p>Nombre de autor esperado</p>
	 */
	public String getExpectedAuthor() {
		return expectedAuthor;
	}
	public void setExpectedAuthor(String expectedAuthor) {
		this.expectedAuthor = expectedAuthor;
	}

	/**
	 * <p>Texto a consultar en google</p>
	 */
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getTypeSearch() {
		return typeSearch;
	}
	/**
	 * <p>Tipo de busqueda en google</p>
	 */
	public void setTypeSearch(String typeSearch) {
		this.typeSearch = typeSearch;
	}


}
