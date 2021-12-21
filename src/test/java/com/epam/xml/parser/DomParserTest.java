package com.epam.xml.parser;

import com.epam.xml.entity.CallTariff;
import com.epam.xml.entity.InternetTariff;
import com.epam.xml.entity.Operator;
import com.epam.xml.entity.Tariff;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomParserTest {

    CallTariff callTariffOne = new CallTariff("ID-011", "Light", Operator.A1, 10.00, 0.05);
    CallTariff callTariffOTwo = new CallTariff("ID-012", "Medium", Operator.A1, 15.00, 0.05);
    InternetTariff internetTariffOne = new InternetTariff("ID-021", "Home", Operator.A1, 10.00, 50);
    InternetTariff internetTariffTwo = new InternetTariff("ID-022", "Home+", Operator.A1, 15.00, 100);

    List<Tariff> expectedTariffsList = new ArrayList<>(Arrays.asList(callTariffOne, callTariffOTwo, internetTariffOne, internetTariffTwo));

    String xmlPath = "src/test/resources/tariffsExt.xml";

    @Test
    public void TestParseShouldReturnCorrectList() {
        //given
        DomParser domParser = new DomParser();
        //when
        List<Tariff> actualTariffsList = domParser.parse(xmlPath);
        //then
        Assert.assertEquals(expectedTariffsList, actualTariffsList);
    }
}
