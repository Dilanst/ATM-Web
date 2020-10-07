package com.google.search.dal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.google.search.dal.dto.BookDTO;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 * <pre>
 * Fecha      Autor     
 * 06-10-2020 Dilan Steven Mejia	
 * </pre>
 * 
 * Obtener información de cada una de las busquedas
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category DAL
 * **/

public class SearchDAL {

	/**
	 * <pre>
	 * Fecha      Autor     
	 *  06-10-2020 Dilan Steven Mejia
	 * </pre>
	 * 
	 * Se hidrata el objeto de busquedas.
	 * 
	 * @author Dilan Steven Mejia
	 * @return Lista de busquedas
	 * 
	 * **/

	public static  ArrayList<BookDTO> getSearch(String dataPool){
		ArrayList<BookDTO> listSearchDTO = new ArrayList<BookDTO>();
		try {
			Workbook excelDataPool 		= Workbook.getWorkbook(new File(dataPool));
			Sheet sheetExcelDataPool 	= excelDataPool.getSheet(0);

			for (int fila = 1; fila < sheetExcelDataPool.getRows(); fila++) {
				BookDTO  		search 	= new BookDTO();

				search.setQuery(dataVerification(			sheetExcelDataPool	,"query"			,fila));
				search.setAuthor(dataVerification(			sheetExcelDataPool	,"author"			,fila));
				search.setTitle(dataVerification(			sheetExcelDataPool	,"title"			,fila));
				search.setExpectedAuthor(dataVerification(	sheetExcelDataPool	,"expectedAuthor"	,fila));
				search.setExpectedRecord(dataVerification(	sheetExcelDataPool	,"expectedRecord"	,fila));
				search.setTypeSearch(dataVerification(		sheetExcelDataPool	,"typeSearch"		,fila));
				listSearchDTO.add(search);
			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listSearchDTO;
	}

	/**
	 * <pre>
	 * Fecha      Autor     
	 * 06-10-2020 Dilan Steven Mejia	
	 * 
	 * </pre>
	 * 
	 * Verifica si hay un elemento en la celda, sino retorna vacio.
	 * 
	 * @author Dilan Steven Mejia
	 * @return Elemento encontrado en la celda
	 * 
	 * **/

	public static String dataVerification(Sheet sheetExcelDataPool,String field,int row){
		try {
			return sheetExcelDataPool.getCell(sheetExcelDataPool.findCell(field).getColumn(),row).getContents();

		} catch (Exception e) {

			return "";
		}


	}


}
