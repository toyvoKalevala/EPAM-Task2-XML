package com.epam.xml.parser;

import org.junit.Test;

public class JaxbParserTest {

    @Test
    public void testParseShouldReturnCorrectLost() {
        //given
        JaxbParser jaxbParser = new JaxbParser();
        //when
        System.out.println(jaxbParser.parse("src/test/resources/tariffsExt.xml"));
    }
}
