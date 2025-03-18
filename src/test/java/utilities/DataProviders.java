package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = ".\\testData\\Opencart_LoginData.xlsx"; // Path to the Excel file

        ExcelUtility xlUtil = new ExcelUtility(path); // Creating an object for Excel utility

        int totalRows = xlUtil.getRowCount("Sheet1"); // Get total rows
        int totalCols = xlUtil.getCellCount("Sheet1", 1); // Get total columns

        String loginData[][] = new String[totalRows][totalCols]; // 2D array to store data

        for (int i = 1; i <= totalRows; i++) 
        { // Loop through rows (excluding header)
            for (int j = 0; j < totalCols; j++) 
            { // Loop through columns
                loginData[i - 1][j] = xlUtil.getCellData("Sheet1", i, j); // Read and store data
            }
        }
        return loginData; // Return the 2D array
    }
}
