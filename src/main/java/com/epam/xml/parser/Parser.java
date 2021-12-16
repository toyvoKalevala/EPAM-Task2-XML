package com.epam.xml.parser;

import com.epam.xml.entity.Tariff;

import java.util.List;

public interface Parser {

    List<Tariff> parse(String file);
}
