package com.epam.xml.entity;

public class Tariff {

    private String id;
    private String name;
    private Operator operatorName;
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
        return "Tariff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", operatorName=" + operatorName +
                ", payRoll=" + payRoll +
                '}';
    }
}
