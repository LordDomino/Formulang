package com.lorddomino.fle.syllabics;

import java.util.ArrayList;

import com.lorddomino.fle.AbstractFLEObject;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.fle.types.AbstractStructure;
import com.lorddomino.fle.types.Structure;

public class Nucleus extends AbstractStructure {

  public Nucleus(Phoneme ... ph) {
    super(ph);
  }

  public Nucleus(ArrayList<Phoneme> ph) {
    super(new ArrayList<>(ph));
  }

  @Override
  public ArrayList<AbstractFLEObject> defineDefaultBlueprintElements() {
    ArrayList<AbstractFLEObject> e = new ArrayList<>();
    e.add(new ClassElement(Nucleus.class));
    return e;
  }

  @Override
  public AbstractStructure getRawStructure() {
    return new Structure(getPhonemes());
  }

}
