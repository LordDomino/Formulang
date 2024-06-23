package com.lorddomino.fle.types;

import java.util.ArrayList;

import com.lorddomino.fle.AbstractFLEObject;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.phonology.Phoneme;

public final class Structure extends AbstractStructure {

  public Structure(Phoneme ... phonemes) {
    super(phonemes);
  }

  public Structure(ArrayList<Phoneme> phonemes) {
    super(new ArrayList<>(phonemes));
  }

  @Override
  public ArrayList<AbstractFLEObject> defineDefaultBlueprintElements() {
    ArrayList<AbstractFLEObject> e = new ArrayList<>();
    e.add(new ClassElement(Structure.class));
    return e;
  }

  @Override
  public AbstractStructure getRawStructure() {
    return this;
  }

}
