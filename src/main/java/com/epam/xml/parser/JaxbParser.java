package com.epam.xml.parser;

import com.epam.xml.entity.Tariff;
import com.epam.xml.entity.Tariffs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {

    private static final Logger logger = LogManager.getLogger();

    public List<Tariff> parse(String file) {

        List<Tariff> tariffList = new ArrayList<>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tariffs.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader(file);
            Tariffs tariffs = (Tariffs) unmarshaller.unmarshal(reader);
            tariffList = tariffs.getTariffsList();
        } catch (JAXBException | FileNotFoundException exception) {
            logger.error("Parsing error: " + exception.getMessage());
        }
        return tariffList;
    }
}
