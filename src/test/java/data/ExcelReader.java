package data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/Registration.xlsx";
		File srcFile = new File(filePath);

		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. terminating Process!! : Check file path of TestData");
			System.exit(0);
		}
		return fis;
	}

	public Object[][] getExcelData() throws IOException {
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int TotalNumberOfRows = (sheet.getLastRowNum() + 1);
		int TotalNumberOfCols = 5;

		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

		for (int i = 0; i < TotalNumberOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				for (int j = 0; j < TotalNumberOfCols; j++) {
					Cell cell = row.getCell(j, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

					if (cell.getCellType() == CellType.NUMERIC) {
						arrayExcelData[i][j] = String.valueOf((int)cell.getNumericCellValue());
					} else {
						arrayExcelData[i][j] = cell.toString();
					}
				}
			}
		}

		wb.close();
		return arrayExcelData;
	}
}