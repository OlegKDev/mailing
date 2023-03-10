package org.software.mailing.config;

import java.lang.reflect.Field;

public class ConfigAttributes {
    private String emailsFileAbsolutePath; // Excel file with emails
    private Integer sheetIndex;
    private Integer excelColumnIndexOfEmailAddress; // Column with emails
    private Integer excelColumnIndexOfCheck; // Column with check data
    private Integer excelColumnIndexToWrite; // Column to write result data
    private String messageSubject;
    private String messageBody;
    private Integer startRowIndex;
    private Integer endRowIndex;
    private String fromEmailAddress;
    private String charset;
    private String applicationName;
    private String userId;
    private String attachmentFileAbsolutePath;
    private String credentialsFileAbsolutePath;

    public String[] getFieldsNames() {
        Field[] fields = this.getClass().getDeclaredFields();
        String[] fieldsNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldsNames[i] = fields[i].getName();
        }
        return fieldsNames;
    }

    public Class[] getFieldsTypes() {
        Field[] fields = this.getClass().getDeclaredFields();
        Class[] fieldsTypes = new Class[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldsTypes[i] = fields[i].getType();
        }
        return fieldsTypes;
    }

    public String[] getSettersNames() {
        Field[] fields = this.getClass().getDeclaredFields();
        String[] settersNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            StringBuilder setterName = new StringBuilder();
            char firstCharacter = Character.toUpperCase(fieldName.charAt(0));
            setterName.append("set").append(firstCharacter).append(fieldName.substring(1));
            settersNames[i] = setterName.toString();
        }
        return settersNames;
    }

    public String getEmailsFileAbsolutePath() {
        return emailsFileAbsolutePath;
    }

    public void setEmailsFileAbsolutePath(String emailsFileAbsolutePath) {
        this.emailsFileAbsolutePath = emailsFileAbsolutePath;
    }

    public Integer getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(Integer sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public Integer getExcelColumnIndexOfEmailAddress() {
        return excelColumnIndexOfEmailAddress;
    }

    public void setExcelColumnIndexOfEmailAddress(Integer excelColumnIndexOfEmailAddress) {
        this.excelColumnIndexOfEmailAddress = excelColumnIndexOfEmailAddress;
    }

    public Integer getExcelColumnIndexOfCheck() {
        return excelColumnIndexOfCheck;
    }

    public void setExcelColumnIndexOfCheck(Integer excelColumnIndexOfCheck) {
        this.excelColumnIndexOfCheck = excelColumnIndexOfCheck;
    }

    public Integer getExcelColumnIndexToWrite() {
        return excelColumnIndexToWrite;
    }

    public void setExcelColumnIndexToWrite(Integer excelColumnIndexToWrite) {
        this.excelColumnIndexToWrite = excelColumnIndexToWrite;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Integer getStartRowIndex() {
        return startRowIndex;
    }

    public void setStartRowIndex(Integer startRowIndex) {
        this.startRowIndex = startRowIndex;
    }

    public Integer getEndRowIndex() {
        return endRowIndex;
    }

    public void setEndRowIndex(Integer endRowIndex) {
        this.endRowIndex = endRowIndex;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAttachmentFileAbsolutePath() {
        return attachmentFileAbsolutePath;
    }

    public void setAttachmentFileAbsolutePath(String attachmentFileAbsolutePath) {
        this.attachmentFileAbsolutePath = attachmentFileAbsolutePath;
    }

    public String getCredentialsFileAbsolutePath() {
        return credentialsFileAbsolutePath;
    }

    public void setCredentialsFileAbsolutePath(String credentialsFileAbsolutePath) {
        this.credentialsFileAbsolutePath = credentialsFileAbsolutePath;
    }
}
