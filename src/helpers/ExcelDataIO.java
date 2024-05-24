package helpers;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataIO {

	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ExcelDataIO(String excelName, String sheetName) throws IOException {
		workbook = new XSSFWorkbook(System.getProperty("user.dir") + "/dataFiles/" + excelName);
		sheet = workbook.getSheet(sheetName);
	}

	public int getRowCount() throws IOException {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public int getColCount() throws IOException {
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}

	public String getCellDataString(int rowNum, int colNum) throws IOException {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == CellType.BLANK) {
			return "";
		} else {
			throw new IllegalArgumentException("The cell type is not supported");
		}
	}

	public double getCellDataNumeric(int rowNum, int colNum) throws IOException {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if (cell.getCellType() == CellType.NUMERIC) {
			return cell.getNumericCellValue();
		} else if (cell.getCellType() == CellType.STRING) {
			try {
				return Double.parseDouble(cell.getStringCellValue());
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("The cell contains a string that cannot be parsed as a number");
			}
		} else {
			throw new IllegalArgumentException("The cell type is not numeric or cannot be converted to a number");
		}
	}
}
