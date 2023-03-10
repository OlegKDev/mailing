package org.software.mailing.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigAttributesTest {
    private static String[] expectedFieldsNames = new String[]{
            "emailsFileAbsolutePath", "sheetIndex", "excelColumnIndexOfEmailAddress",
            "excelColumnIndexOfCheck", "excelColumnIndexToWrite",
            "messageSubject", "messageBody", "startRowIndex",
            "endRowIndex", "fromEmailAddress", "charset",
            "applicationName", "userId", "attachmentFileAbsolutePath", "credentialsFileAbsolutePath"
    };
    private static Class[] expectedFieldsTypes = new Class[]{
            String.class, Integer.class, Integer.class, Integer.class, Integer.class,
            String.class, String.class, Integer.class, Integer.class,
            String.class, String.class, String.class, String.class, String.class, String.class
    };
    private static String[] expectedSettersNames = new String[]{
            "setEmailsFileAbsolutePath", "setSheetIndex", "setExcelColumnIndexOfEmailAddress",
            "setExcelColumnIndexOfCheck", "setExcelColumnIndexToWrite",
            "setMessageSubject", "setMessageBody", "setStartRowIndex",
            "setEndRowIndex", "setFromEmailAddress", "setCharset",
            "setApplicationName", "setUserId", "setAttachmentFileAbsolutePath", "setCredentialsFileAbsolutePath"
    };

    @Test
    void getFieldsNames() {
        ConfigAttributes configAttributes = new ConfigAttributes();
        String[] actualFieldsNames = configAttributes.getFieldsNames();
        assertArrayEquals(expectedFieldsNames, actualFieldsNames);
    }

    @Test
    void getFieldsTypes() {
        ConfigAttributes configAttributes = new ConfigAttributes();
        Class[] actualFieldsTypes = configAttributes.getFieldsTypes();
        assertArrayEquals(expectedFieldsTypes, actualFieldsTypes);
    }

    @Test
    void getSettersNames() {
        ConfigAttributes configAttributes = new ConfigAttributes();
        String[] actualSettersNames = configAttributes.getSettersNames();
        assertArrayEquals(expectedSettersNames, actualSettersNames);
    }
}