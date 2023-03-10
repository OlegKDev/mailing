package org.software.mailing.excel;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface WriteExcel {
    void write(String excelFileAbsolutePath, int sheetIndex, int columnIndex, int startRowIndex, int endRowIndex) throws IOException;
    void write(String excelFileAbsolutePath, int sheetIndex, int columnIndex) throws IOException;
}
