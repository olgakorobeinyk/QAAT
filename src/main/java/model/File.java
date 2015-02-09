package model;



import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class File {
    protected final String mainPath = "src/main/java/";
    protected final String fileName = this.mainPath + "RegressionData.xlsx";
    protected java.io.File xlsFile = null;

    public File() {
        this.xlsFile = new java.io.File(this.fileName);
    }


    public void create() {
        java.io.File newFile = new java.io.File(this.fileName);

        try {
            FileOutputStream stream = new FileOutputStream(newFile);
            new XSSFWorkbook().write(stream);
            stream.close();
            //newFile.createNewFile();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean remove() {
        return this.xlsFile.delete();
    }


    public File write(XSSFWorkbook workbook) {

        try {
            FileOutputStream stream = new FileOutputStream(this.xlsFile);
            workbook.write(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public XSSFWorkbook read() {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new FileInputStream(this.xlsFile));
        }catch (IOException e ) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return (XSSFWorkbook)workbook;
    }
}