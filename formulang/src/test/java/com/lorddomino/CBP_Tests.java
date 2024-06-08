package com.lorddomino;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.ipa.IpaConsonantPhones;
import com.lorddomino.fle.types.Structure;

public class CBP_Tests {

  /**
   * TEST 1 - Instance
   */
  @Test
  void Test1InstanceElements() {
    IpaConsonantPhones.load();

    Structure syllable1 = new Structure(
      IpaConsonantPhones.VOICED_BILABIAL_FRICATIVE,
      IpaConsonantPhones.VOICED_VELAR_APPROXIMANT,
      IpaConsonantPhones.VOICED_ALVEOLAR_FLAP
    );

    Structure syllable2 = new Structure(
      IpaConsonantPhones.VOICED_BILABIAL_PLOSIVE,
      syllable1
    );

    System.out.println(syllable2.getOutputStr());
    System.out.println(syllable2.getFormulangTranscript());
    System.out.println(syllable2.getIpaTranscript());
  }
}
