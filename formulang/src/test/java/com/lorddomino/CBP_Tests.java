package com.lorddomino;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.fle.ipa.IpaRegistryAssembler;
import com.lorddomino.fle.syllabics.Coda;
import com.lorddomino.fle.syllabics.Nucleus;
import com.lorddomino.fle.syllabics.ONCSyllable;
import com.lorddomino.fle.syllabics.Onset;
import com.lorddomino.fle.syllabics.Syllable;

public class CBP_Tests {

  /**
   * TEST 1 - Instance
   */
  @Test
  void Test1InstanceElements() {
    Phoneme ph1 = new Phoneme(IpaRegistryAssembler.VOICED_ALVEOLAR_FLAP, "a");
    Phoneme ph2 = new Phoneme(IpaRegistryAssembler.CLOSEMID_BACK_ROUNDED, "b");
    Phoneme ph3 = new Phoneme(IpaRegistryAssembler.VOICED_VELAR_PLOSIVE, "c");
    Syllable syl = new ONCSyllable(new Onset(ph1), new Nucleus(ph2), new Coda(ph3));

    System.out.println(syl);
  }
}
