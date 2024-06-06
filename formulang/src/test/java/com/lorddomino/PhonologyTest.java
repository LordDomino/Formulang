package com.lorddomino;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.blueprints.elements.InstanceElement;
import com.lorddomino.fle.blueprints.elements.SubBlueprintElement;
import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.Phone;
import com.lorddomino.fle.phonology.articulatoryproperties.ConsonantalArticulatoryProperty;
import com.lorddomino.fle.types.DummyComponent;

/**
 * Unit test for simple App.
 */
class PhonologyTest {
  /**
   * Rigorous Test.
   */
  @Test
  void testPhoneInstance() {
    // Phone component object demonstration
    Phone phone = new ConsonantPhone("A", false, new HashSet<ConsonantalArticulatoryProperty>());

    // Phone fields and getter methods demonstration
    System.out.println("Output string: " + phone.getOutputStr());
    System.out.println("Formulang transcript: " + phone.getFormulangTranscript());
    System.out.println("Preferred blueprint: " + phone.getBlueprint().getFlePreview());
    System.out.println("IPA transcript: " + phone.getIpaTranscript());
    System.out.println("Romanization: " + phone.getRomanization());
    System.out.println("Instance reference: " + phone.getFlePreview());
    System.out.println("Default blueprint: " + phone.getDefaultBlueprint());
    System.out.println("Class reference: " + phone);

    // IPA defaults demonstration
    System.out.println(Phone.getIpaDefaults());
  }

  /**
   * Demonstration for Phone instance's blueprint instance and class
   * references.
   *
   * The following code prints to console Phone's blueprint references
   * (instance and class) in their custom Formulang Language Engine object
   * preview.
   */
  @Test
  void testPhoneBlueprintReferences() {
    Phone phone = new ConsonantPhone("B", false, new HashSet<ConsonantalArticulatoryProperty>());

    System.out.println("Phone's blueprint:             " + phone.getBlueprint());
    System.out.println("Phone's BP instance reference: " + phone.getBlueprint());
    System.out.println("Phone's BP class reference:    " + phone.getBlueprint());
  }

  /**
   * Demonstrates the equality of the different blueprints.
   *
   * An object Phone("A", ...) should be only matched to an object of the same
   * elements/sub-components. An object Phone("B", ...) should therefore never
   * be matched to an object Phone("C", ...).
   */
  @Test
  void testInstanceElementEquality() {
    Phone phone1 = new ConsonantPhone("A", false, new HashSet<ConsonantalArticulatoryProperty>());
    Phone phone2 = new ConsonantPhone("B", false, new HashSet<ConsonantalArticulatoryProperty>());
    Phone phone3 = new ConsonantPhone("C", false, new HashSet<ConsonantalArticulatoryProperty>());
    Phone phone4 = new ConsonantPhone("A", false, new HashSet<ConsonantalArticulatoryProperty>());

    InstanceElement ie1 = new InstanceElement(phone1);
    InstanceElement ie2 = new InstanceElement(phone2);
    InstanceElement ie3 = new InstanceElement(phone3);
    InstanceElement ie4 = new InstanceElement(phone4);

    System.out.println(ie1.equals(ie2)); // Expects false
    System.out.println(ie2.equals(ie3)); // Expects false
    System.out.println(ie1.equals(ie4)); // Expects true
  }

  /**
   * Demonstrates blueprints' reflexive properties, as well as equality
   * matching with the getClass() method and references to its subclasses.
   */
  @Test
  void testClassElementEquality() {
    Phone phone = new ConsonantPhone("A", false, new HashSet<ConsonantalArticulatoryProperty>());
    ClassElement ce1 = new ClassElement(Phone.class);
    ClassElement ce2 = new ClassElement(phone.getClass());
    ClassElement ce3 = new ClassElement(DummyComponent.class);

    System.out.println(ce1.isCompliant(ce1)); // Expects true
    System.out.println(ce1.isCompliant(ce3)); // Expects false
    System.out.println(ce2.isCompliant(ce1)); // Expects true
  }

  /**
   * Shows the instance and class references of the newest
   * AbstractBlueprintElement types: InstanceElement, ClassElement, and
   * BlueprintElement subtypes.
   */
  @Test
  void testCbpReferences() {
    InstanceElement ie = new InstanceElement(new ConsonantPhone("A", false, new HashSet<ConsonantalArticulatoryProperty>()));
    ClassElement ce = new ClassElement(DummyComponent.class);
    SubBlueprintElement bp = new SubBlueprintElement(new ComponentBlueprint(ce));

    System.out.println("Instance reference of IE:     " + ie);
    System.out.println("Class reference of CE:        " + ce);
    System.out.println("Instance reference of BP:     " + bp);
  }
}
