package dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import pojo.Category;
import pojo.RootBody;
import pojo.Tags;


public class DataProviderJsonBody {

		//public static void main(String[] args) throws Exception {
		
	
		public static Object[][] getexceldata() throws Exception{
		
		
		String path="C:/Users/AshwiniPimple/Desktop/SDET Testing Program/RestAssuredAssignment/restTestData.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int totalrows=sheet.getLastRowNum();
		Row row=sheet.getRow(1);
		
		int totalcol=row.getLastCellNum();
		totalrows=totalrows+1;
		System.out.println("Total Rows ->"+totalrows);
		System.out.println("Total Columns ->"+totalcol);
		
		
		Object[][] data=new Object[totalrows][totalcol];
		
		for(int i=0;i<totalrows;i++){
			for(int j=0;j<totalcol;j++){
				
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		
		workbook.close();
		return data;
		
	}
	}

