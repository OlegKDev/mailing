package org.software.mailing.config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigTest {
    private static final String configXmlFileAbsolutePath = "C:\\projects\\mailing\\config\\src\\test\\java\\org\\software\\mailing\\config\\config.xml";
    private static final ConfigAttributes expectedConfigAttributes = new ConfigAttributes();

    @BeforeAll
    static void beforeAll() {
        expectedConfigAttributes.setEmailsFileAbsolutePath("c:/path/to/file.excel");
        expectedConfigAttributes.setSheetIndex(1);
        expectedConfigAttributes.setExcelColumnIndexOfEmailAddress(1);
        expectedConfigAttributes.setExcelColumnIndexOfCheck(2);
        expectedConfigAttributes.setExcelColumnIndexToWrite(3);
        expectedConfigAttributes.setMessageSubject("This is a message subject");
        expectedConfigAttributes.setMessageBody("This is a message body");
        expectedConfigAttributes.setStartRowIndex(2);
        expectedConfigAttributes.setEndRowIndex(9);
        expectedConfigAttributes.setFromEmailAddress("from@email.com");
        expectedConfigAttributes.setCharset("text/plain;charset=utf-8");
        expectedConfigAttributes.setApplicationName("Mailing");
        expectedConfigAttributes.setUserId("userId");
        expectedConfigAttributes.setAttachmentFileAbsolutePath("c:/path/to/attachment");
        expectedConfigAttributes.setCredentialsFileAbsolutePath("c:/path/to/credentials");
    }
    @Test
    void getConfigAttributes() throws ParserConfigurationException, IOException, SAXException, IllegalAccessException {
        Config config = new ConfigImpl();
        ConfigAttributes actualConfigAttributes = config.getConfigAttributes(configXmlFileAbsolutePath);

        Field[] fields = expectedConfigAttributes.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object expectedValue = field.get(expectedConfigAttributes);
            Object actualValue = field.get(actualConfigAttributes);
            field.setAccessible(false);
            assertEquals(expectedValue.toString(), actualValue.toString());
        }
    }
}