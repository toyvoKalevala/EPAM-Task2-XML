package com.epam.xml.validator.parser;

import com.epam.xml.parser.DomParser;
import org.junit.Test;

public class DomParserTest {

    @Test
    public void TestParseShouldReturnCorrectList() {
        //given
        DomParser domParser = new DomParser();
        //when
        System.out.println(domParser.parse("src/test/resources/tariffsExt.xml"));
        //then
    }
}
