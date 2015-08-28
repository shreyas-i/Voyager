package com.voyager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.CommonConstants;

public class Tester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			File excelFile = new File("E:\\shreyas\\JunkField\\sample.xlsx");
			fis = new FileInputStream(excelFile);
			XSSFWorkbook sampleExcel = new XSSFWorkbook(fis);

			XSSFSheet sheet = sampleExcel.createSheet("sheet1");

			for (int i = 0; i < CommonConstants.MAXROW; i++) {
				XSSFRow row = sheet.createRow(i);

				for (int j = 0; j < CommonConstants.MAXROW; j++) {
					XSSFCell cell = row.createCell(j);
					cell.setCellValue(j);
				}
			}

			fos = new FileOutputStream(new File(
					"E:\\shreyas\\JunkField\\sample.xlsx"));
			sampleExcel.write(fos);
			
			System.out.println("DONE");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
			if (fis != null)
				fos.close();
		}

	}
}
