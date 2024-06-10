package com.lorddomino;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.ipa.IpaRegistryAssembler;
import com.lorddomino.fle.types.Structure;

public class CBP_Tests {

  /**
   * TEST 1 - Instance
   */
  @Test
  void Test1InstanceElements() {
    IpaRegistryAssembler.load();

    Structure syllable1 = new Structure(
      IpaRegistryAssembler.VOICELESS_DENTAL_FRICATIVE,
      IpaRegistryAssembler.CLOSEMID_FRONT_UNROUNDED,
      IpaRegistryAssembler.VOICED_ALVEOLAR_TRILL
    );

    Structure syllable2 = new Structure(
      IpaRegistryAssembler.OPEN_FRONT_UNROUNDED,
      syllable1
    );

    System.out.println(syllable2.getOutputStr());
    System.out.println(syllable2.getFormulangTranscript());
    System.out.println(syllable2.getIpaTranscript());
  }
}
