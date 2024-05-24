package helpers;

import java.io.IOException;

public class ExcelDataProvider {
	public Object[][] getTestData(String excelName, String sheetname) throws IOException{
		ExcelDataIO excel= new ExcelDataIO(excelName, sheetname);
		
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
		
		Object data[][]= new Object[rowCount-1][colCount];
		
		for(int i=1; i < rowCount; i++) {
			
			for(int j=0; j < colCount; j++) {
				String cellData= excel.getCellDataString(i, j);
				data[i-1][j]= cellData;
			}
		}
		System.out.println(data);
		return data;
	}
}
