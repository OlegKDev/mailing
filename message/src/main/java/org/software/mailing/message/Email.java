package org.software.mailing.message;

import java.util.List;

public class Email {
    private String messageSubject;
    private String bodyText;
    private String charset;
    private String fromEmailAddress;
    private String toEmailAddress;
    private List<String> attachmentFilesAbsolutePaths;

    public Email(String fromAddress, String toAddress, String messageSubject, String bodyText) {
        this.messageSubject = messageSubject;
        this.bodyText = bodyText;
        this.fromEmailAddress = fromAddress;
        this.toEmailAddress = toAddress;
    }

    public Email(String fromAddress, String toAddress, String messageSubject, String bodyText, String charset,
                 List<String> attachmentFilesAbsolutePaths) {
        this.messageSubject = messageSubject;
        this.bodyText = bodyText;
        this.charset = charset;
        this.fromEmailAddress = fromAddress;
        this.toEmailAddress = toAddress;
        this.attachmentFilesAbsolutePaths = attachmentFilesAbsolutePaths;
    }

    public String getMessageSubject() {
        return this.messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getBodyText() {
        return this.bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFromEmailAddress() {
        return this.fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getToEmailAddress() {
        return this.toEmailAddress;
    }

    public void setToEmailAddress(String toEmailAddress) {
        this.toEmailAddress = toEmailAddress;
    }

    public List<String> getAttachmentFilesAbsolutePaths() {
        return this.attachmentFilesAbsolutePaths;
    }

    public void setAttachmentFilesAbsolutePaths(List<String> attachmentFilesAbsolutePaths) {
        this.attachmentFilesAbsolutePaths = attachmentFilesAbsolutePaths;
    }
}
