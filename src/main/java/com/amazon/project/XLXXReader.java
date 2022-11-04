package com.amazon.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class XLXXReader {
	
	static String value;

	public static void main(String[] args) throws IOException {
		
		particularData("Amazon",0,1);
		
	}
	public static  String particularData(String name,int row,int cell) throws IOException  {
		
		 File f = new File("Datadriven\\DatadrivenReader.xlsx");
		 FileInputStream fi = new FileInputStream(f);
         XSSFWorkbook w = new XSSFWorkbook(fi);
         Sheet s = w.getSheet("Project8.30am");
         Row r = s.getRow(row);
         Cell c = r.getCell(cell);
         CellType ce = c.getCellType();
         
         if(ce.equals(CellType.STRING)) {
        	 String ss = c.getStringCellValue();
        	 value =c.getStringCellValue();
        	 System.out.println(ss);
         }else if(ce.equals(CellType.NUMERIC)) {
        	 double d=c.getNumericCellValue();
        	 int a = (int)d;
        	 value = Integer.toString(a);
        	 String ss = c.getStringCellValue();
        	 System.out.println(a);
         }
       return value;
	}
}
