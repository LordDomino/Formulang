package com.lorddomino;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.blueprints.elements.ComponentBlueprintElement;
import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.Phone;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.fle.types.DummyComponent;

public class TypesTest {

  /**
   * Tester method for debugging object construction.
   *
   * Test case: A new Phoneme object is created with null properties
   */
  @Test
  void nullObjPropertiesConstruction() {
    Phoneme phoneme = new Phoneme(new ConsonantPhone("a", false, new HashSet<>()), null);

    System.out.println(phoneme.getBaseSymbol());
    System.out.println(phoneme.getIpaTranscript());
    System.out.println(phoneme.getBlueprint());
    System.out.println(phoneme.getFormulangTranscript());
    System.out.println(phoneme.getBaseAllophone());
    System.out.println(phoneme.getBaseAllophone().getSymbol());
  }

  /**
   * Tester method for demonstrating equality of two DummyComponent objects.
   */
  @Test
  void dummyComponentEquality() {
    DummyComponent dummy1 = new DummyComponent(new ComponentBlueprint(new ClassElement(ConsonantPhone.class)));
    DummyComponent dummy2 = new DummyComponent(new ComponentBlueprint(new ClassElement(Phoneme.class)));
    DummyComponent dummy3 = new DummyComponent(new ComponentBlueprint(new ClassElement(Phone.class)));

    System.out.println(dummy1.equals(dummy2));  // expects false
    System.out.println(dummy2.equals(dummy3));  // expects false
    System.out.println(dummy1.equals(dummy3));  // Subtype is equals to supertype -- expects true
    System.out.println(dummy3.equals(dummy1));  // Supertype is equals to subtype -- expects false
  }

  @Test
  void instanceSubBpEquality() {
    ComponentBlueprint cbp = new ComponentBlueprint(new ComponentBlueprintElement<>(Phone.class));
    cbp.getLast();
  }
}
