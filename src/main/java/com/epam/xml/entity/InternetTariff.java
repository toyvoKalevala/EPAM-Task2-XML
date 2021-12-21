package com.epam.xml.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

public class InternetTariff extends Tariff {

    @XmlElement(name = "connectionspeed")
    private int connectionSpeed;

    public InternetTariff() {

    }

    public InternetTariff(String id, String name, Operator operatorName, double payRoll, int connectionSpeed) {
        super(id, name, operatorName, payRoll);
        this.connectionSpeed = connectionSpeed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        InternetTariff that = (InternetTariff) obj;
        return connectionSpeed == that.connectionSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), connectionSpeed);
    }

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
