package com.lorddomino.fle.phonology;

import java.util.HashSet;
import java.util.Set;

import com.lorddomino.fle.phonology.articulatoryproperties.ConsonantalArticulatoryProperty;

public class ConsonantPhone extends Phone {

  public ConsonantPhone(String symbol, boolean isIpaDefault, Set<ConsonantalArticulatoryProperty> cAtcProps) {
    super(symbol, isIpaDefault, new HashSet<>(cAtcProps));
  }

}
