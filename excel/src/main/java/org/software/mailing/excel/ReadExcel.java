package org.software.mailing.excel;

import java.io.IOException;

public interface ReadExcel {
    EmailRowData[] read(String excelFileAbsolutePath, int sheetIndex, int columnIndex, int startRowIndex, int endRowIndex) throws IOException;
    EmailRowData[] read(String excelFileAbsolutePath, int sheetIndex, int columnIndex) throws IOException;
}
