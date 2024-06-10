package com.lorddomino.fle.phonology;

import java.util.LinkedHashSet;

import com.lorddomino.fle.phonology.articulatoryproperties.ArticulatoryProperty;

public class ConsonantPhone extends Phone {

  public ConsonantPhone(String symbol, boolean isIpaDefault, LinkedHashSet<ArticulatoryProperty> cAtcProps) {
    super(symbol, isIpaDefault, new LinkedHashSet<>(cAtcProps));
  }

  @Override
  public void processSpecificFields() {}
}
