package com.lorddomino;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.Phoneme;

public class TypesTest {

    /**
     * Tester method for debugging object construction.
     *
     * Test case: A new Phoneme object is created with null properties
     */
    @Test
    void nullObjPropertiesConstruction() {
        Phoneme phoneme = new Phoneme(new ConsonantPhone("a", false, null), null);

        System.out.println(phoneme.getBaseSymbol());
        System.out.println(phoneme.getIpaTranscript());
        System.out.println(phoneme.getBlueprint());
        System.out.println(phoneme.getFormulangTranscript());
        System.out.println(phoneme.getBaseAllophone());
        System.out.println(phoneme.getBaseAllophone().getSymbol());
    }
}
