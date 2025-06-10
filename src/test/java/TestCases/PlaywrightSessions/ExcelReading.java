package TestCases.PlaywrightSessions;

import utilities.ExcelReader;

public class ExcelReading {
    public static void main(String[] args) {
        ExcelReader excel = new ExcelReader("src/test/resources/excel/testdata.xlsx");
        String sheetName = "Sheet1";
        System.out.println(excel.getRowCount(sheetName));
        System.out.println(excel.getColumnCount(sheetName));
        System.out.println(excel.getCellData(sheetName,1,1));



    }
}
