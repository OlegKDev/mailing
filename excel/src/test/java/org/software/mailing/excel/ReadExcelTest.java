package org.software.mailing.excel;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadExcelTest {
    private static final String excelFileAbsolutePath = "C:\\projects\\mailing\\excel\\src\\test\\java\\org\\software\\mailing\\excel\\Emails.xlsx";

    @Test
    void readAllRows() throws IOException {
        ReadExcel readExcel = new ReadExcelImpl();
        EmailRowData[] emailRowData = readExcel.read(excelFileAbsolutePath, 0, 1);

        // Expected
        int totalRows = 20;
        String startRowEmail = "Company1@email.com";
        int startRowIndex = 1; // 2 in excel, excel counts from 1
        int startRowIndexInArray = 0;

        String endRowEmail = "Company20@email.com";
        int endRowIndex = 20; // 21 in excel, excel counts from 1
        int endRowIndexInArray = 19;

        String randomRowEmail = "Company13@email.com";
        int randomRowIndex = 13; // 14 in excel, excel counts from 1
        int randomRowIndexInArray = 12;

        // Actual
        EmailRowData firstRowData = emailRowData[startRowIndexInArray];
        EmailRowData lastRowData = emailRowData[endRowIndexInArray];
        EmailRowData randomRowData = emailRowData[randomRowIndexInArray];

        assertEquals(totalRows, emailRowData.length);
        assertEquals(startRowEmail, firstRowData.getEmail());
        assertEquals(startRowIndex, firstRowData.getRowIndex());

        assertEquals(endRowEmail, lastRowData.getEmail());
        assertEquals(endRowIndex, lastRowData.getRowIndex());

        assertEquals(randomRowEmail, randomRowData.getEmail());
        assertEquals(randomRowIndex, randomRowData.getRowIndex());
    }

    @Test
    void readRange() throws IOException {
        int startRowIndex = 5; // 6 in excel, excel counts from 1
        int endRowIndex = 10; // 11 in excel, excel counts from 1
        int totalRows = endRowIndex - startRowIndex + 1;

        ReadExcel readExcel = new ReadExcelImpl();
        EmailRowData[] emailRowData = readExcel.read(excelFileAbsolutePath, 0, 1, startRowIndex, endRowIndex);

        // Expected
        String startRowEmail = "Company5@email.com";
        int startRowIndexInArray = 0;

        String endRowEmail = "Company10@email.com";
        int endRowIndexInArray = 5;

        String randomRowEmail = "Company7@email.com";
        int randomRowIndex = 7; // 8 in excel, excel counts from 1
        int randomRowIndexInArray = 2;

        // Actual
        EmailRowData firstRowData = emailRowData[startRowIndexInArray];
        EmailRowData lastRowData = emailRowData[endRowIndexInArray];
        EmailRowData randomRowData = emailRowData[randomRowIndexInArray];

        assertEquals(totalRows, emailRowData.length);
        assertEquals(startRowEmail, firstRowData.getEmail());
        assertEquals(startRowIndex, firstRowData.getRowIndex());

        assertEquals(endRowEmail, lastRowData.getEmail());
        assertEquals(endRowIndex, lastRowData.getRowIndex());

        assertEquals(randomRowEmail, randomRowData.getEmail());
        assertEquals(randomRowIndex, randomRowData.getRowIndex());
    }
}