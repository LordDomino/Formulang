package com.lorddomino.fle.phonology;

import java.util.LinkedHashSet;

import com.lorddomino.fle.phonology.articulatoryproperties.ArticulatoryProperty;
import com.lorddomino.fle.phonology.articulatoryproperties.Voicing;

public class VowelPhone extends Phone {

  public VowelPhone(String symbol, boolean isIpaDefault, LinkedHashSet<ArticulatoryProperty> atcProps) {
    super(symbol, isIpaDefault, atcProps);
    addDefaultProperties();
  }

  @Override
  public void processSpecificFields() {}

  private void addDefaultProperties() {
    this.getArticulatoryProperties().add(Voicing.VOICED);
  }
}
