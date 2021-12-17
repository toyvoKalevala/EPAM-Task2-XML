package com.epam.xml.parser;

import com.epam.xml.entity.Tariff;
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
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tariff> parse(String file) {
        try {
            reader.parse(file);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return tariffHandler.getTariffs();
    }
}