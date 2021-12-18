package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({CallTariff.class, InternetTariff.class})
public class Tariff {

    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlElement(name = "operatorname")
    private Operator operatorName;
    @XmlElement(name = "payroll")
    private double payRoll;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperatorName(Operator operatorName) {
        this.operatorName = operatorName;
    }

    public void setPayRoll(double payRoll) {
        this.payRoll = payRoll;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", operatorName=" + operatorName +
                ", payRoll=" + payRoll;
    }
}
