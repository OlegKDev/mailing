package org.software.mailing.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelImpl implements ReadExcel {
    private EmailRowData[] emailRowData;

    // Indexes of sheets, rows, columns start from 0
    @Override
    public EmailRowData[] read(String excelFileAbsolutePath, int sheetIndex, int columnIndex, int startRowIndex, int endRowIndex) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelFileAbsolutePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        if (startRowIndex == -1 & endRowIndex == -1) {
            startRowIndex = 1; // Because 0-row is a header
            endRowIndex = sheet.getLastRowNum();
        }

        // startRowIndex=1, endRowIndex=173, arrayLength=173, array indexes 0..172, delta=1
        // startRowIndex=10, endRowIndex=13, arrayLength=4, array indexes 0..3, delta=10
        // delta is a distance between 0 and startRowIndex, delta is needed to organize a for-loop
        int arrayLength = endRowIndex - startRowIndex + 1;
        emailRowData = new EmailRowData[arrayLength];
        int delta = startRowIndex;

        for (int i = 0; i < arrayLength; i++) {
            int rowIndex = i + delta;
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(columnIndex);
            EmailRowData emailRowDataObj = new EmailRowData();
            emailRowDataObj.setEmail(cell.getStringCellValue());
            emailRowDataObj.setRowIndex(rowIndex);
            this.emailRowData[i] = emailRowDataObj;
        }

        workbook.close();
        file.close();

        return emailRowData;
    }

    @Override
    public EmailRowData[] read(String excelFileAbsolutePath, int sheetIndex, int columnIndex) throws IOException {
        return this.read(excelFileAbsolutePath, sheetIndex, columnIndex, -1, -1);
    }
}