package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "tariffs", namespace = "http://www.example.com/tariffs")
public class Tariffs {

    @XmlElements
            ({
                    @XmlElement(name = "calltariffs", type = CallTariff.class),
                    @XmlElement(name = "internettariffs", type = InternetTariff.class)
            })
    private List<Tariff> tariffsList = new ArrayList<>();

    public List<Tariff> getTariffsList() {
        return tariffsList;
    }

}
