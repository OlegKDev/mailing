package org.software.mailing.assembly;

import org.software.mailing.config.Config;
import org.software.mailing.config.ConfigAttributes;
import org.software.mailing.config.ConfigImpl;
import org.software.mailing.console.Console;
import org.software.mailing.console.ConsoleImpl;
import org.software.mailing.console.Event;
import org.software.mailing.excel.*;
import org.software.mailing.message.MessageService;
import org.software.mailing.message.MessageServiceImpl;
import org.xml.sax.SAXException;

import javax.mail.MessagingException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class Main {
    private static final String configXmlFileAbsolutePath = "C:\\projects\\mailing\\config.xml";
    private static final Console console = new ConsoleImpl();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException,
            GeneralSecurityException, MessagingException {
        // Read configuration file
        console.update(new Event("Reading configuration file...", Event.EventType.START));
        Config config = new ConfigImpl();
        ConfigAttributes configAttributes = config.getConfigAttributes(configXmlFileAbsolutePath);
        console.update(new Event("Done", Event.EventType.DONE));

        // Read emails from Excel file
        console.update(new Event("Reading emails from file...", Event.EventType.START));
        ReadExcel readExcel = new ReadExcelImpl();
        EmailRowData[] emailRowData = readExcel.read(configAttributes.getEmailsFileAbsolutePath(),
                configAttributes.getSheetIndex(), configAttributes.getExcelColumnIndexOfEmailAddress());
        console.update(new Event("Done", Event.EventType.DONE));

        // Send messages
        console.update(new Event("Sending messages...", Event.EventType.START));
        MessageService messageService = new MessageServiceImpl(configAttributes.getApplicationName(),
                configAttributes.getUserId(), configAttributes.getCredentialsFileAbsolutePath());

        for (EmailRowData emailData : emailRowData) {
            messageService.sendMessage(
                    configAttributes.getFromEmailAddress(),
                    emailData.getEmail(),
                    configAttributes.getMessageSubject(),
                    configAttributes.getMessageBody(),
                    configAttributes.getCharset(),
                    Collections.singletonList(configAttributes.getAttachmentFileAbsolutePath())
            );
        }
        console.update(new Event("Done", Event.EventType.DONE));

        // Write sent data to the Excel file
        console.update(new Event("Writing data to the file...", Event.EventType.START));
        WriteExcel writeExcel = new WriteExcelImpl();
        writeExcel.write(configAttributes.getEmailsFileAbsolutePath(), configAttributes.getSheetIndex(),
                configAttributes.getExcelColumnIndexToWrite());
        console.update(new Event("Done", Event.EventType.DONE));
    }
}