package com.lorddomino;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import static com.lorddomino.fle.ipa.IpaConsonantPhones.*;
import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.Phone;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.fle.types.Structure;

public class TypesTest {

  /**
   * Tester method for debugging object construction.
   *
   * Test case: A new Phoneme object is created with null properties
   */
  @Test
  void nullObjPropertiesConstruction(){
    Phoneme phoneme = new Phoneme(new ConsonantPhone("a", false, new HashSet<>()), null);

    System.out.println(phoneme.getBaseSymbol());
    System.out.println(phoneme.getIpaTranscript());
    System.out.println(phoneme.getBlueprint());
    System.out.println(phoneme.getFormulangTranscript());
    System.out.println(phoneme.getBaseAllophone());
    System.out.println(phoneme.getBaseAllophone().getSymbol());
  }

  @Test
  void instanceSubBpEquality() {
    ComponentBlueprint cbp = new ComponentBlueprint(new ClassElement(Phone.class));
    cbp.getLast();
  }

  @Test
  void structureTest() {
    Structure st = new Structure(VOICED_BILABIAL_PLOSIVE, VOICELESS_BILABIAL_PLOSIVE);
    System.out.println(st.getBlueprint());
  }
}
