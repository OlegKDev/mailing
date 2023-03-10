package org.software.mailing.message;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface MessageService {
    String sendMessage(String fromEmailAddress, String toEmailAddress, String messageSubject, String bodyText, String charset,
                       List<String> attachmentsAbsolutePaths) throws MessagingException, IOException, GeneralSecurityException;

    String sendMessage(String fromEmailAddress, String toEmailAddress, String messageSubject, String bodyText, String charset) throws MessagingException, IOException, GeneralSecurityException;
}
