package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.Objects;

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

    public Tariff() {

    }

    public Tariff(String id, String name, Operator operatorName, double payRoll) {
        this.id = id;
        this.name = name;
        this.operatorName = operatorName;
        this.payRoll = payRoll;
    }

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tariff tariff = (Tariff) obj;
        return Double.compare(tariff.payRoll, payRoll) == 0 && id.equals(tariff.id) && Objects.equals(name, tariff.name) && operatorName == tariff.operatorName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, operatorName, payRoll);
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", operatorName=" + operatorName +
                ", payRoll=" + payRoll;
    }
}
