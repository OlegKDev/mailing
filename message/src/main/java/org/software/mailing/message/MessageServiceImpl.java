package org.software.mailing.message;

import com.google.api.services.gmail.model.Message;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class MessageServiceImpl implements MessageService {
    private String applicationName;
    private String userId;
    private String credentialsFileAbsolutePath;

    public MessageServiceImpl(String applicationName, String userId, String credentialsFileAbsolutePath) throws
            GeneralSecurityException, IOException {
        this.applicationName = applicationName;
        this.userId = userId;
        this.credentialsFileAbsolutePath = credentialsFileAbsolutePath;
    }
    @Override
    public String sendMessage(String fromEmailAddress, String toEmailAddress, String messageSubject, String bodyText,
                              String charset, List<String> attachmentsAbsolutePaths) throws MessagingException, IOException, GeneralSecurityException {

        Email email = new Email(fromEmailAddress, toEmailAddress, messageSubject, bodyText, charset, attachmentsAbsolutePaths);
        GmailAPI gmailApi = new GmailAPI(applicationName, userId, credentialsFileAbsolutePath);
        Message message;

        if (attachmentsAbsolutePaths == null) {
            message = gmailApi.createMessage(email.getFromEmailAddress(), email.getToEmailAddress(),
                    email.getMessageSubject(), email.getBodyText());
        } else {
            message = gmailApi.createMessageWithAttachments(email.getFromEmailAddress(), email.getToEmailAddress(),
                    email.getMessageSubject(), email.getBodyText(), email.getCharset(), email.getAttachmentFilesAbsolutePaths());
        }

        Message sendMessage = gmailApi.getService().users().messages().send("me", message).execute();
        return sendMessage.getId();
    }

    @Override
    public String sendMessage(String fromEmailAddress, String toEmailAddress, String messageSubject, String bodyText,
                              String charset) throws MessagingException, IOException, GeneralSecurityException {
        return this.sendMessage(fromEmailAddress, toEmailAddress, messageSubject, bodyText, charset, null);
    }
}
