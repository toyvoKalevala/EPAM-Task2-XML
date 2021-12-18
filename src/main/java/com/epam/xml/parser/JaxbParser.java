package com.epam.xml.parser;

import com.epam.xml.entity.Tariff;
import com.epam.xml.entity.Tariffs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JaxbParser {

    public List<Tariff> parse(String file) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tariffs.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader(file);
            Tariffs tariffsList = (Tariffs) unmarshaller.unmarshal(reader);
            return tariffsList.getTariffsList();
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
