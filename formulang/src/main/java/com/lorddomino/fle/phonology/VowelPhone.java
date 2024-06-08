package com.lorddomino.fle.phonology;

import java.util.LinkedHashSet;

import com.lorddomino.fle.phonology.articulatoryproperties.VocalicArticulatoryProperty;

public class VowelPhone extends Phone {

  public VowelPhone(String symbol, boolean isIpaDefault, LinkedHashSet<VocalicArticulatoryProperty> atcProps) {
    super(symbol, isIpaDefault, new LinkedHashSet<>(atcProps));
  }

  @Override
  public void processSpecificFields() {}
}
