package com.lorddomino;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.blueprints.BlueprintElement;
import com.lorddomino.fle.blueprints.ClassElement;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.InstanceElement;
import com.lorddomino.fle.phonology.ArticulatoryProperty;
import com.lorddomino.fle.phonology.Phone;
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
        Phone phone = new Phone("A", false, new HashSet<ArticulatoryProperty>());

        // Phone fields and getter methods demonstration
        System.out.println("Output string: " + phone.getOutputString());
        System.out.println("Formulang transcript: " + phone.getFormulangTranscript());
        System.out.println("Preferred blueprint: " + phone.getBlueprint().getFlePreview());
        System.out.println("IPA transcript: " + phone.getIpaTranscript());
        System.out.println("Romanization: " + phone.getRomanization());
        System.out.println("Instance reference: " + phone.getInstanceReference().getFlePreview());
        System.out.println("Default blueprint: " + phone.getDefaultBlueprint());
        System.out.println("Class reference: " + phone.getClassReference());

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
        Phone phone = new Phone("B", false, new HashSet<ArticulatoryProperty>());

        System.out.println("Phone's blueprint:             " + phone.getBlueprint());
        System.out.println("Phone's BP instance reference: " + phone.getBlueprint().getInstanceReference());
        System.out.println("Phone's BP class reference:    " + phone.getBlueprint().getClassReference());
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
        Phone phone1 = new Phone("A", false, new HashSet<ArticulatoryProperty>());
        Phone phone2 = new Phone("B", false, new HashSet<ArticulatoryProperty>());
        Phone phone3 = new Phone("C", false, new HashSet<ArticulatoryProperty>());
        Phone phone4 = new Phone("A", false, new HashSet<ArticulatoryProperty>());

        InstanceElement<Phone> ie1 = new InstanceElement<Phone>(phone1);
        InstanceElement<Phone> ie2 = new InstanceElement<Phone>(phone2);
        InstanceElement<Phone> ie3 = new InstanceElement<Phone>(phone3);
        InstanceElement<Phone> ie4 = new InstanceElement<Phone>(phone4);

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
        Phone phone = new Phone("A", false, new HashSet<ArticulatoryProperty>());
        ClassElement ce1 = new ClassElement(Phone.class);
        ClassElement ce2 = new ClassElement(phone.getClass());
        ClassElement ce3 = new ClassElement(DummyComponent.class);

        System.out.println(ce1.equals(ce1)); // Expects true
        System.out.println(ce1.equals(ce3)); // Expects false
        System.out.println(ce1.equals(ce2)); // Expects true
    }

    /**
     * Shows the instance and class references of the newest
     * AbstractBlueprintElement types: InstanceElement, ClassElement, and
     * BlueprintElement subtypes.
     */
    @Test
    void testCbpReferences() {
        InstanceElement<Phone> ie = new InstanceElement<>(new Phone("A", false, new HashSet<ArticulatoryProperty>()));
        ClassElement ce = new ClassElement(DummyComponent.class);
        BlueprintElement<ComponentBlueprint<?>> bp = new BlueprintElement<ComponentBlueprint<?>>(new ComponentBlueprint<>(ce));

        System.out.println("Instance reference of IE:     " + ie.getInstanceReference());
        System.out.println("Class reference of IE:        " + ie.getClassReference());
        System.out.println("Instance reference of CE:     " + ce.getInstanceReference());  // Class elements have no instance references
        System.out.println("Class reference of CE:        " + ce.getClassReference());
        System.out.println("Instance reference of BP:     " + bp.getInstanceReference());
        System.out.println("Class reference of BP:        " + bp.getClassReference());
    }
}
