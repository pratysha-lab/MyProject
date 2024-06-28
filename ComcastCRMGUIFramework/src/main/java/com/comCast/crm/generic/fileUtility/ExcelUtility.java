package com.comCast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Pratyusha
 * Utility library for excel
 */
public class ExcelUtility {
	/**
	 * get the data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String data=book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		book.close();
		fis.close();
		return data;
	}
	
	/**
	 * get the  row count on particular sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		int rowCount=book.getSheet(sheetName).getLastRowNum();
		book.close();
		fis.close();
		return rowCount;
	}
	/**
	 * get the cell count on particular row
	 * @param sheetName
	 * @param rowNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getCellCount(String sheetName,int rowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		int cellCount=book.getSheet(sheetName).getRow(rowNum).getLastCellNum();
		book.close();
		fis.close();
		return cellCount;
	}
	/**
	 * to set the data to excel
	 * @param sheetName
	 * @param row
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void setDataBackToExcel(String sheetName,int row,int cellNum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(row).createCell(cellNum).setCellValue(data);
		
		
		
		FileOutputStream fos=new FileOutputStream("./testData/TestScriptData.xlsx");
		book.write(fos);
		book.close();
		fos.close();
		fis.close();
		
		
	}
	/**
	 * get the data from excel based on condition given by user
	 * @param expectedData
	 * @param sheetname
	 * @throws Throwable
	 */
	
	public static void ReadDataBasedOnConditionTes(String expectedData,String sheetname ) throws Throwable {
		boolean flag=true;
		
		FileInputStream fis=new FileInputStream("./testData/TestScriptData.xlsx");
		Sheet sh=WorkbookFactory.create(fis).getSheet(sheetname);
		System.out.println(sh.getLastRowNum());
		for(int i=0;i<=sh.getLastRowNum();i++) {
			String data="";
			try {
			data=sh.getRow(i).getCell(0).getStringCellValue();
			if(data.equals(expectedData)) {
				flag=true;
				for(int j=1;j<=sh.getRow(j).getLastCellNum();j++) {
				data=sh.getRow(i).getCell(j).toString();
				}
			}
			}catch (Exception e) {}
		}
		if(flag) {
				System.out.println(expectedData+" data is not available");
		}
	}


	
}
