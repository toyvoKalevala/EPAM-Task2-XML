package com.epam.xml.entity;

public class CallTariff extends Tariff {

    private double smsPrice;

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    @Override
    public String toString() {
        return "CallTariff{" +
                super.toString() + ", smsPrice=" + smsPrice +
                "}";
    }
}
