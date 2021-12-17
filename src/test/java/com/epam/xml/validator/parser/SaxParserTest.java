package com.epam.xml.validator.parser;

import com.epam.xml.parser.SaxParser;
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
