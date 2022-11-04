package com.amazon.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLXXWriter {

	public static void main(String[] args) throws Exception {
		
		writedata();
		System.out.println("completed");
		
	}
	
	private static void writedata() throws IOException {

	File f =  new File("Datadriven\\DatadrivenReader.xlsx");
	FileInputStream fi = new FileInputStream(f);
	XSSFWorkbook w = new XSSFWorkbook(fi);
	Sheet s = w.createSheet("Test");
	Row r = s.createRow(0);
	Cell c = r.createCell(2);
	c.setCellValue("a");
	w.getSheet("Test").createRow(1).createCell(1).setCellValue("b");
	w.getSheet("Test").createRow(2).createCell(0).setCellValue("c");
	FileOutputStream fo = new FileOutputStream(f);
	w.write(fo);
	w.close();		
		
	}
}
