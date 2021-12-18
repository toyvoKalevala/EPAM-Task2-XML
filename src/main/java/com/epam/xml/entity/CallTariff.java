package com.epam.xml.entity;

import javax.xml.bind.annotation.*;

public class CallTariff extends Tariff {

    @XmlElement(name = "SMSPrice")
    private double smsPrice;

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    @Override
    public String toString() {
        return "CallTariff{" +
                super.toString() + ", smsPrice=" + smsPrice +
                "}" + "\n";
    }
}
