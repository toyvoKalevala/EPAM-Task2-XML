package com.epam.xml.factory;

import com.epam.xml.parser.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParserFactory {

    private static final Logger logger = LogManager.getLogger();

    Parser create(ParserType parserType) throws ParserFactoryExeption {
        switch (parserType) {
            case DOM:
                logger.info("DOM parser was chosen.");
                return new DomParser();
            case SAX:
                logger.info("SAX parser was chosen.");
                return new SaxParser();
            case JAX:
                logger.info("JAX parser was chosen.");
                return new JaxbParser();
            default:
                throw new ParserFactoryExeption("Wrong type of parser was chosen!");
        }
    }
}
