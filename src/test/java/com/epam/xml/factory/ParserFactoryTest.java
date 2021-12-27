package com.epam.xml.factory;

import com.epam.xml.parser.*;
import org.junit.Assert;
import org.junit.Test;

public class ParserFactoryTest {

    @Test
    public void TestCreateShouldReturnDomParser() throws ParserFactoryExeption {
        //given
        ParserFactory parserFactory = new ParserFactory();
        Parser expectedParser = new DomParser();
        //when
        Parser actualParser = parserFactory.create(ParserType.DOM);
        //then
        Assert.assertEquals(expectedParser.getClass(), actualParser.getClass());
    }

    @Test
    public void TestCreateShouldReturnSaxParser() throws ParserFactoryExeption {
        //given
        ParserFactory parserFactory = new ParserFactory();
        Parser expectedParser = new SaxParser();
        //when
        Parser actualParser = parserFactory.create(ParserType.SAX);
        //then
        Assert.assertEquals(expectedParser.getClass(), actualParser.getClass());
    }

    @Test
    public void TestCreateShouldReturnJaxParser() throws ParserFactoryExeption {
        //given
        ParserFactory parserFactory = new ParserFactory();
        Parser expectedParser = new JaxbParser();
        //when
        Parser actualParser = parserFactory.create(ParserType.JAX);
        //then
        Assert.assertEquals(expectedParser.getClass(), actualParser.getClass());
    }

    @Test(expected = ParserFactoryExeption.class)
    public void testReadShouldThrowDataException() throws ParserFactoryExeption {
        //given
        ParserFactory parserFactory = new ParserFactory();
        //when
        parserFactory.create(ParserType.STAX);
        //then
    }
}
