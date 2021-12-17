package com.epam.xml.parser;

import com.epam.xml.entity.CallTariff;
import com.epam.xml.entity.InternetTariff;
import com.epam.xml.entity.Operator;
import com.epam.xml.entity.Tariff;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TariffHandler extends DefaultHandler {

    private List<Tariff> tariffs;
    private Tariff current;
    private CallTariff currentCallTariff;
    private InternetTariff currentInternetTariff;
    private String elementName;

    public TariffHandler() {
        tariffs = new ArrayList<>();
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("calltariffs".equals(localName) || "internettariffs".equals(localName)) {
            switch (localName) {
                case "calltariffs":
                    current = new CallTariff();
                    break;
                case "internettariffs":
                    current = new InternetTariff();
                    break;
            }
            current.setId(attrs.getValue(0));
            current.setName(attrs.getValue(1));
        } else {
            elementName = localName;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("calltariffs".equals(localName) || "internettariffs".equals(localName)) {
            tariffs.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String textValue = new String(ch, start, length).trim();
        if (elementName != null) {
            switch (elementName) {
                case "operatorname":
                    Operator operator = Operator.valueOf(textValue);
                    current.setOperatorName(operator);
                    break;
                case "payroll":
                    current.setPayRoll(Double.parseDouble(textValue));
                    break;
                case "SMSPrice":
                    currentCallTariff = (CallTariff) current;
                    currentCallTariff.setSmsPrice(Double.parseDouble(textValue));
                    break;
                case "connectionspeed":
                    currentInternetTariff = (InternetTariff) current;
                    currentInternetTariff.setConnectionSpeed(Integer.parseInt(textValue));
                    break;
            }
        }
        elementName = null;
    }
}
