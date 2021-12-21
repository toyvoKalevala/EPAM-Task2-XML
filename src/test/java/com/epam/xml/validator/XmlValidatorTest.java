package com.epam.xml.validator;

import com.epam.xml.validator.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {

    @Test
    public void testValidShouldReturnTrueIfXmlValid() {

        //given
        XmlValidator xmlValidator = new XmlValidator();
        String validXml = "src/test/resources/tariffsExt.xml";
        //when
        boolean result = xmlValidator.valid(validXml);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testValidShouldReturnFalseIfXmlInvalid() {

        //given
        XmlValidator xmlValidator = new XmlValidator();
        String invalidXml = "src/test/resources/tariffsExtInvalid.xml";
        //when
        boolean result = xmlValidator.valid(invalidXml);
        //then
        Assert.assertFalse(result);
    }

}
