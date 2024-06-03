package com.lorddomino.fle.ipa;

import java.util.HashSet;

import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.articulatoryproperties.ConsonantalArticulatoryProperty;
import com.lorddomino.fle.phonology.articulatoryproperties.MannerOfArticulation;
import com.lorddomino.fle.phonology.articulatoryproperties.PlaceOfArticulation;
import com.lorddomino.fle.phonology.articulatoryproperties.Voicing;

public final class IpaConsonantPhones {

  private static final HashSet<ConsonantalArticulatoryProperty> voicedBilabialPlosive = new HashSet<>();
  static {
    voicedBilabialPlosive.add(Voicing.VOICED);
    voicedBilabialPlosive.add(PlaceOfArticulation.BILABIAL);
    voicedBilabialPlosive.add(MannerOfArticulation.PLOSIVE);
  }
  public static final ConsonantPhone VOICED_BILABIAL_PLOSIVE = new ConsonantPhone("\\u0062", true, voicedBilabialPlosive);

  private static final HashSet<ConsonantalArticulatoryProperty> voicelessBilabialPlosive = new HashSet<>();
  static {
    voicelessBilabialPlosive.add(Voicing.VOICELESS);
    voicelessBilabialPlosive.add(PlaceOfArticulation.BILABIAL);
    voicelessBilabialPlosive.add(MannerOfArticulation.PLOSIVE);
  }
  public static final ConsonantPhone VOICELESS_BILABIAL_PLOSIVE = new ConsonantPhone("\\u0070", true, voicelessBilabialPlosive);

  static {
    IpaRegistry.registerPhone(VOICED_BILABIAL_PLOSIVE);
    IpaRegistry.registerPhone(VOICELESS_BILABIAL_PLOSIVE);
  }
}
