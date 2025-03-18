package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
    
    private String filePath; // Excel file path
    FileInputStream fi;
    XSSFWorkbook workbook;
    FileOutputStream fo;
    // Constructor
    public ExcelUtility(String path) {
        this.filePath = path;
    }

    // Method to get row count
    public int getRowCount(String sheetName) throws IOException {
         fi = new FileInputStream(filePath);
         workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        
        int rowCount = sheet.getLastRowNum();
        
        workbook.close();
        fi.close();
        
        return rowCount;
    }

    // Method to get cell count in a row
    public int getCellCount(String sheetName, int rowNum) throws IOException {
         fi = new FileInputStream(filePath);
         workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        
        int cellCount = (row != null) ? row.getLastCellNum() : 0;
        
        workbook.close();
        fi.close();
        
        return cellCount;
    }

    // Method to read data from a cell
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
         fi = new FileInputStream(filePath);
         workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        
        String data = "";
        try {
            XSSFRow row = sheet.getRow(rowNum);
            if (row != null) {
                XSSFCell cell = row.getCell(colNum);
                if (cell != null) {
                    data = formatter.formatCellValue(cell);
                }
            }
        } catch (Exception e) {
            data = "";
        }

        workbook.close();
        fi.close();
        return data;
    }

    // Method to write data into a cell
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        File xlFile = new File(filePath);

        // If file doesn't exist, create a new one
        if (!xlFile.exists()) {
             workbook = new XSSFWorkbook();
             fo = new FileOutputStream(filePath);
            workbook.write(fo);
            workbook.close();
            fo.close();
        }

         fi = new FileInputStream(filePath);
         workbook = new XSSFWorkbook(fi);
        fi.close();

        // Check if sheet exists, if not create it
        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }

        // Check if row exists, if not create it
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        // Check if cell exists, if not create it
        XSSFCell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }

        cell.setCellValue(data); // Set data in cell

        // Write changes back to file
         fo = new FileOutputStream(filePath);
        workbook.write(fo);
        workbook.close();
        fo.close();
    }
}
