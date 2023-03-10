package org.software.mailing.config;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Config {
    ConfigAttributes getConfigAttributes(String configXmlFileAbsolutePath) throws ParserConfigurationException, SAXException, IOException;
}
