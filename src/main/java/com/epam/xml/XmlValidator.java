package com.epam.xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public boolean valid(String xmlName) {

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String schemaName = "src/test/resources/tariffsExt.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        boolean isValid;

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlName);
            validator.validate(source);
            isValid = true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            isValid = false;
        }

        return isValid;
    }
}
