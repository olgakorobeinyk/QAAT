package model;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Worksheet {
    private String[] columnNames = {"Currency", "Finance", "Kurs", "Results"};
    private String[] currencyValue = {"USD", "EUR"};
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    protected String sheetName;
    protected model.File file;
    final short USD_ROW = 1;
    final short EUR_ROW = 2;
    final short FINANCE_COL = 1;
    final short KURS_COL = 2;
    final short RESULT_COL = 3;

    public Worksheet () {
        this.file = new model.File();
        this.workbook = this.file.read();
        this.sheet = this.workbook.getSheet("test");
        if (this.sheet == null) {
            this.sheet = this.workbook.createSheet("test");
            this.createTable(sheet, 3, 4);
            this.setColumnsName();
            this.setCurrencyValue();
        }
    }

    public void createTable (XSSFSheet sheet, int rowsQuantity, int cellsInTheRowQuantity) {
        for (int rowNumber = 0; rowNumber < rowsQuantity; rowNumber ++) {
            sheet.createRow(rowNumber);
            for (int cellNumber = 0; cellNumber < cellsInTheRowQuantity; cellNumber ++) {
                sheet.getRow(rowNumber).createCell(cellNumber);
            }
        }
    }

    public void setColumnsName () {
        sheet.getRow(0).getCell(0).setCellValue(this.columnNames[0]);
        sheet.getRow(0).getCell(1).setCellValue(this.columnNames[1]);
        sheet.getRow(0).getCell(2).setCellValue(this.columnNames[2]);
        sheet.getRow(0).getCell(3).setCellValue(this.columnNames[3]);
    }

    public void setCurrencyValue () {
        sheet.getRow(USD_ROW).getCell(0).setCellValue(this.currencyValue[0]);
        sheet.getRow(EUR_ROW).getCell(0).setCellValue(this.currencyValue[1]);
    }

    public void setCellStringValue (XSSFSheet sheet, int rowNumber, int cellNumber, String value) {
        sheet.getRow(rowNumber).getCell(cellNumber).setCellValue(value);
    }

    public void setCellDoubleValue (XSSFSheet sheet, int rowNumber, int cellNumber, Double value) {
        sheet.getRow(rowNumber).getCell(cellNumber).setCellValue(value);
    }

    public Worksheet fillUSDRow (double finance, double kurs, String result) {
        XSSFRow row = this.sheet.getRow(1);
        row.getCell(1).setCellValue(finance);
        row.getCell(2).setCellValue(kurs);
        row.getCell(3).setCellValue(result);
        return this;
    }

    public Worksheet fillEURRow (double finance, double kurs, String result) {
        XSSFRow row = this.sheet.getRow(2);
        row.getCell(1).setCellValue(finance);
        row.getCell(2).setCellValue(kurs);
        row.getCell(3).setCellValue(result);
        return this;
    }

    public Worksheet setFinanceEur(String eur) {
        this.sheet.getRow(EUR_ROW).getCell(FINANCE_COL).setCellValue(eur);
        return this;
    }

    public Worksheet setKursEur(String eur) {
        this.sheet.getRow(EUR_ROW).getCell(KURS_COL).setCellValue(eur);
        return this;
    }

    public Worksheet setResultEur(boolean status) {
        String cellValue = status ? "Success" : "Failed";
        this.sheet.getRow(EUR_ROW).getCell(RESULT_COL).setCellValue(cellValue);
        return this;
    }

    public Worksheet setFinanceUsd(String usd) {
        this.sheet.getRow(USD_ROW).getCell(FINANCE_COL).setCellValue(usd);
        return this;
    }

    public Worksheet setKursUsd(String usd) {
        this.sheet.getRow(USD_ROW).getCell(KURS_COL).setCellValue(usd);
        return this;
    }

    public Worksheet setResultUsd(boolean status) {
        String cellValue = status ? "Success" : "Failed";
        this.sheet.getRow(USD_ROW).getCell(RESULT_COL).setCellValue(cellValue);
        return this;
    }



    public void save() {
        this.file.write(this.workbook);
    }

}
