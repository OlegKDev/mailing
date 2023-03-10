package org.software.mailing.config;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ConfigImpl implements Config {
    @Override
    public ConfigAttributes getConfigAttributes(String configXmlFileAbsolutePath) throws ParserConfigurationException,
            SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XmlHandler handler = new XmlHandler();
        parser.parse(configXmlFileAbsolutePath, handler);
        return handler.getConfigAttributes();
    }
}
