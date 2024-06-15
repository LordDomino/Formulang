package com.lorddomino;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.ipa.IpaRegistryAssembler;
import com.lorddomino.fle.syllabics.Syllable;

public class CBP_Tests {

  /**
   * TEST 1 - Instance
   */
  @Test
  void Test1InstanceElements() {
    ArrayList<AbstractFormulangReference> afl1 = new ArrayList<>();
    afl1.add(IpaRegistryAssembler.VOICED_VELAR_PLOSIVE);
    afl1.add(IpaRegistryAssembler.CLOSEMID_BACK_ROUNDED);
    afl1.add(IpaRegistryAssembler.VOICED_VELAR_PLOSIVE);
    ComponentBlueprint cbp1 = new ComponentBlueprint(afl1);

    System.out.println(cbp1.isCompliantToBlueprint(
      new Syllable(
        IpaRegistryAssembler.VOICED_ALVEOLAR_FLAP,
        IpaRegistryAssembler.CLOSEMID_BACK_ROUNDED,
        IpaRegistryAssembler.VOICED_VELAR_PLOSIVE
      ).getDefaultBlueprint()
    ));
  }
}
