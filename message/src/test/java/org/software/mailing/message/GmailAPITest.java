package org.software.mailing.message;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.gmail.model.Message;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class GmailAPITest {
    private static Email email;
    private static String applicationName = "Mailing";
    private static String userId = "OlegKDeveloper";
    private static String credentialsFileAbsolutePath = "C:\\projects\\mailing\\message\\src\\main\\resources\\client_secret_750052892071-j02c7buresec6dmk5kg5s6cfpgk68jch.apps.googleusercontent.com.json";

    @BeforeAll
    static void init() {
        List<String> attachmentFilesAbsolutePaths = new ArrayList<>();
        attachmentFilesAbsolutePaths.add("C:\\projects\\mailing\\message\\src\\main\\resources\\Test1.pdf");
        attachmentFilesAbsolutePaths.add("C:\\projects\\mailing\\message\\src\\main\\resources\\Test2.pdf");

        email = new Email("OlegKDeveloper@gmail.com", "OlegKDev@outlook.com",
                "Subject text", "Body text", "text/plain;charset=utf-8", attachmentFilesAbsolutePaths);
    }

    @Test
    void testCreateMessage() throws IOException {
        try {
            GmailAPI gmailAPI = new GmailAPI(applicationName, userId, credentialsFileAbsolutePath);
            Message message = gmailAPI.createMessage(email.getFromEmailAddress(), email.getToEmailAddress(),
                    email.getMessageSubject(), email.getBodyText());

            Message sendMessage = gmailAPI.getService().users().messages().send("me", message).execute();

            assertInstanceOf(String.class, sendMessage.getId());

        } catch (GoogleJsonResponseException | MessagingException | GeneralSecurityException e) {
            System.err.println("Unable to send message: " + e.getMessage());
        }
    }

    @Test
    void testCreateMessageWithAttachments() throws IOException {
        try {
            GmailAPI gmailAPI = new GmailAPI(applicationName, userId, credentialsFileAbsolutePath);
            Message message = gmailAPI.createMessageWithAttachments(email.getFromEmailAddress(),
                    email.getToEmailAddress(), email.getMessageSubject(), email.getBodyText(),
                    email.getCharset(), email.getAttachmentFilesAbsolutePaths());

            Message sendMessage = gmailAPI.getService().users().messages().send("me", message).execute();

            assertInstanceOf(String.class, sendMessage.getId());

        } catch (GoogleJsonResponseException | MessagingException | GeneralSecurityException e) {
            System.err.println("Unable to send message: " + e.getMessage());
        }
    }
}