package com.epam.xml.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

public class CallTariff extends Tariff {

    @XmlElement(name = "SMSPrice")
    private double smsPrice;

    public CallTariff(){

    }

    public CallTariff(String id, String name, Operator operatorName, double payRoll, double smsPrice) {
        super(id, name, operatorName, payRoll);
        this.smsPrice = smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        CallTariff that = (CallTariff) obj;
        return Double.compare(that.smsPrice, smsPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), smsPrice);
    }

    @Override
    public String toString() {
        return "CallTariff{" +
                super.toString() + ", smsPrice=" + smsPrice +
                "}" + "\n";
    }
}
