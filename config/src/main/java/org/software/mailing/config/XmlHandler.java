package org.software.mailing.config;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class XmlHandler extends DefaultHandler {
    private ConfigAttributes configAttributes;
    private StringBuilder elementValue;

    @Override
    public void startDocument() {
        configAttributes = new ConfigAttributes();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String[] configAttributesFieldsNames = configAttributes.getFieldsNames();
        if (Arrays.asList(configAttributesFieldsNames).contains(qName)) {
            elementValue = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String[] configAttributesFieldsNames = configAttributes.getFieldsNames();
        Class[] configAttributesFieldsTypes = configAttributes.getFieldsTypes();
        String[] configAttributesSettersNames = configAttributes.getSettersNames();

        for (int i = 0; i < configAttributesFieldsNames.length; i++) {
            if (qName.equals(configAttributesFieldsNames[i])) {
                try {
                    Method setter = configAttributes.getClass()
                            .getDeclaredMethod(configAttributesSettersNames[i], configAttributesFieldsTypes[i]);

                    if (configAttributesFieldsTypes[i].getName().equals(String.class.getName())) {
                        setter.invoke(configAttributes, elementValue.toString());
                    }
                    if (configAttributesFieldsTypes[i].getName().equals(Integer.class.getName())) {
                        setter.invoke(configAttributes, Integer.parseInt(elementValue.toString()));
                    }

                    break;

                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    public ConfigAttributes getConfigAttributes() {
        return configAttributes;
    }
}
