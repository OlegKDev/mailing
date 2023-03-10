package org.software.mailing.message;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class MessageServiceTest {
    private static String fromEmailAddress = "OlegKDeveloper@gmail.com";
    private static String toEmailAddress = "OlegKDev@outlook.com";
    private static String messageSubject = "Subject text";
    private static String bodyText = "Body text";
    private static String charset = "text/plain;charset=utf-8";
    private static List<String> attachmentsAbsolutePaths;
    private static String applicationName = "Mailing";
    private static String userId = "OlegKDeveloper";
    private static String credentialsFileAbsolutePath = "C:\\projects\\mailing\\message\\src\\main\\resources\\client_secret_750052892071-j02c7buresec6dmk5kg5s6cfpgk68jch.apps.googleusercontent.com.json";

    @BeforeAll
    static void init() {
        attachmentsAbsolutePaths = new ArrayList<>();
        attachmentsAbsolutePaths.add("C:\\projects\\mailing\\message\\src\\main\\resources\\Test1.pdf");
        attachmentsAbsolutePaths.add("C:\\projects\\mailing\\message\\src\\main\\resources\\Test2.pdf");
    }

    @Test
    void sendMessage() throws MessagingException, IOException, GeneralSecurityException {
        MessageService messageService = new MessageServiceImpl(applicationName, userId, credentialsFileAbsolutePath);
        String messageId = messageService.sendMessage(fromEmailAddress, toEmailAddress, messageSubject, bodyText, charset);
        assertInstanceOf(String.class, messageId);
    }

    @Test
    void sendMessageWithAttachments() throws MessagingException, IOException, GeneralSecurityException {
        MessageService messageService = new MessageServiceImpl(applicationName, userId, credentialsFileAbsolutePath);
        String messageId = messageService.sendMessage(fromEmailAddress, toEmailAddress, messageSubject, bodyText, charset,
                attachmentsAbsolutePaths);
        assertInstanceOf(String.class, messageId);
    }
}