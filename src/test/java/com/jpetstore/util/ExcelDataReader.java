package com.jpetstore.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelDataReader {

    private static XSSFWorkbook readExcelFile(String filename) {
        try {
            XSSFWorkbook wb = new XSSFWorkbook(filename);
            return wb;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns test data as 2d array object
     *
     * @param filename
     * @param sheetName
     * @return
     */
    public static Object[][] getData(String filename, String sheetName) {

        XSSFSheet sheet;
        XSSFRow singleRow;

        //Get sheet
        sheet = readExcelFile(filename).getSheet(sheetName);

        //Needed to get cell count
        singleRow = sheet.getRow(0);

        //Initialize a 2D array object
        Object[][] testData = new Object[sheet.getLastRowNum()][singleRow.getLastCellNum()];

        for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {
            singleRow = sheet.getRow(rowCount);
            for(int cell = 0; cell < singleRow.getLastCellNum(); cell++){
                testData[rowCount -1 ][cell] = singleRow.getCell(cell).toString();
            }
        }
        return testData;
    }
}
