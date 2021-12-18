package com.epam.xml.entity;

import javax.xml.bind.annotation.*;

public class InternetTariff extends Tariff {

    @XmlElement(name = "connectionspeed")
    private int connectionSpeed;

    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }

    @Override
    public String toString() {
        return "InternetTariff{" +
                super.toString() + ", connectionSpeed=" + connectionSpeed +
                "}" + "\n";
    }
}
