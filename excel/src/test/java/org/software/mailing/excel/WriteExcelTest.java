package org.software.mailing.excel;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class WriteExcelTest {
    private static final String excelFileAbsolutePath = "C:\\projects\\mailing\\excel\\src\\test\\java\\org\\software\\mailing\\excel\\Emails2.xlsx";
    @Test
    void writeAllRows() throws IOException {
        WriteExcel writeExcel = new WriteExcelImpl();
        writeExcel.write(excelFileAbsolutePath, 0, 2);
    }

    @Test
    void writeRange() throws IOException {
        WriteExcel writeExcel = new WriteExcelImpl();
        writeExcel.write(excelFileAbsolutePath, 0, 3, 5, 10);
    }
}