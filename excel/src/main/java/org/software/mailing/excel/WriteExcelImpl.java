package org.software.mailing.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class WriteExcelImpl implements WriteExcel {
    @Override
    public void write(String excelFileAbsolutePath, int sheetIndex, int columnIndex, int startRowIndex, int endRowIndex) throws IOException {
        File file = new File(excelFileAbsolutePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        if (startRowIndex == -1 & endRowIndex == -1) {
            startRowIndex = 1; // Because 0-row is a header
            endRowIndex = sheet.getLastRowNum();
        }

        // Set date as a String
//        for (int i = startRowIndex; i <= endRowIndex; i++) {
//            Row row = sheet.getRow(i);
//            Cell cell = row.createCell(columnIndex, CellType.STRING);
//            LocalDate localDate = LocalDate.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
//            String localDateText = localDate.format(formatter);
//            cell.setCellValue(localDateText);
//        }

        // Set date as a Date
        for (int i = startRowIndex; i <= endRowIndex; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.createCell(columnIndex, CellType.STRING);

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));

            LocalDate localDate = LocalDate.now();
            cell.setCellStyle(cellStyle);
            cell.setCellValue(localDate);
        }

        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }

    @Override
    public void write(String excelFileAbsolutePath, int sheetIndex, int columnIndex) throws IOException {
        this.write(excelFileAbsolutePath, sheetIndex, columnIndex, -1, -1);
    }
}
