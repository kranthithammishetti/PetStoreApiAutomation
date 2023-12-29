package api.petstore.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path =System.getProperty("user.dir")+"//testData//PetStoreUserData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowNum = xl.getRowCount("Sheet1");
		int colCount = xl.getCellCount("Sheet1", 1);
		
		String apidata[][] = new String[rowNum][colCount];
		for (int i = 1; i <=rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
				
			}
			
		}
		return apidata;
		
	}
	@DataProvider(name="UserNamesData")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir")+"//testData//PetStoreUserData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		int rowNum=xl.getRowCount("Sheet1");
		String apiData[]=new String[rowNum];
		
		for (int i = 1; i <= rowNum; i++) {
			apiData[i-1]=xl.getCellData("Sheet1", i, 1);
			
		}
		
		return apiData;
	}
}
