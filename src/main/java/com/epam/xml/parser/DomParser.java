package com.epam.xml.parser;

import com.epam.xml.entity.CallTariff;
import com.epam.xml.entity.InternetTariff;
import com.epam.xml.entity.Operator;
import com.epam.xml.entity.Tariff;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    private List<Tariff> tariffs;
    private DocumentBuilder documentBuilder;

    public DomParser() {
        this.tariffs = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tariff> parse(String file) {

        Document doc;

        try {
            doc = documentBuilder.parse(file);
            Element root = doc.getDocumentElement();

            NodeList callTariffsList = root.getElementsByTagName("calltariffs");
            for (int i = 0; i < callTariffsList.getLength(); i++) {
                Element tariffElement = (Element) callTariffsList.item(i);
                Tariff tariff = buildCallTariff(tariffElement);
                tariffs.add(tariff);
            }

            NodeList internetTariffsList = root.getElementsByTagName("internettariffs");
            for (int i = 0; i < internetTariffsList.getLength(); i++) {
                Element tariffElement = (Element) internetTariffsList.item(i);
                Tariff tariff = buildInternetTariff(tariffElement);
                tariffs.add(tariff);
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return tariffs;
    }

    private CallTariff buildCallTariff(Element tariffElement) {
        CallTariff tariff = new CallTariff();
        String id = (tariffElement.getAttribute("id"));
        tariff.setId(id);
        tariff.setName(tariffElement.getAttribute("name"));
        Operator operatorName = Operator.valueOf(getElementTextContent(tariffElement, "operatorname"));
        tariff.setOperatorName(operatorName);
        double payRoll = Double.parseDouble(getElementTextContent(tariffElement, "payroll"));
        tariff.setPayRoll(payRoll);
        double smsPrice = Double.parseDouble(getElementTextContent(tariffElement, "SMSPrice"));
        tariff.setSmsPrice(smsPrice);
        return tariff;
    }

    private InternetTariff buildInternetTariff(Element tariffElement) {
        InternetTariff tariff = new InternetTariff();
        String id = (tariffElement.getAttribute("id"));
        tariff.setId(id);
        tariff.setName(tariffElement.getAttribute("name"));
        Operator operatorName = Operator.valueOf(getElementTextContent(tariffElement, "operatorname"));
        tariff.setOperatorName(operatorName);
        double payRoll = Double.parseDouble(getElementTextContent(tariffElement, "payroll"));
        tariff.setPayRoll(payRoll);
        int connectionspeed = Integer.parseInt(getElementTextContent(tariffElement, "connectionspeed"));
        tariff.setConnectionSpeed(connectionspeed);
        return tariff;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
