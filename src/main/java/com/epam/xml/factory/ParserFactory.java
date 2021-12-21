package com.epam.xml.factory;

import com.epam.xml.parser.*;

public class ParserFactory {

    Parser create(ParserType parserType) throws ParserFactoryExeption {
        switch (parserType) {
            case DOM:
                return new DomParser();
            case SAX:
                return new SaxParser();
            case JAX:
                return new JaxbParser();
            default:
                throw new ParserFactoryExeption("Wrong type of parser!");
        }
    }
}
