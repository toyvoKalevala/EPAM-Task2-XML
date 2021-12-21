package com.epam.xml.parser;

import com.epam.xml.entity.Tariff;
import com.epam.xml.handler.TariffHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    private TariffHandler tariffHandler;
    private XMLReader reader;

    public SaxParser() {
        tariffHandler = new TariffHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(tariffHandler);
        } catch (SAXException exception) {
            System.out.println("Handler creation error: " + exception.getMessage());
        }
    }

    @Override
    public List<Tariff> parse(String file) {
        try {
            reader.parse(file);
        } catch (IOException | SAXException exception) {
            System.out.println("Parsing error: " + exception.getMessage());
        }
        return tariffHandler.getTariffs();
    }
}