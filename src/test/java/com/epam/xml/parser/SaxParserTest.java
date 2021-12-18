package com.epam.xml.parser;

import org.junit.Test;

public class SaxParserTest {

    @Test
    public void TestParseShouldReturnCorrectList() {
        //given
        SaxParser saxParser = new SaxParser();
        //when
        System.out.println(saxParser.parse("src/test/resources/tariffsExt.xml"));
        //then
    }
}
