package com.epam.xml.entity;

public class InternetTariff extends Tariff {

    private int connectionSpeed;

    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }

    @Override
    public String toString() {
        return "InternetTariff{" +
                super.toString() + ", connectionSpeed=" + connectionSpeed +
                "}";
    }
}
