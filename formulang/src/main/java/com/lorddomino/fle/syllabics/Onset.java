package com.lorddomino.fle.syllabics;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.fle.types.AbstractStructure;

public class Onset extends AbstractStructure {

  public Onset(Phoneme ... ph) {
    super(ph);
  }

  public Onset(ArrayList<Phoneme> ph) {
    super(new ArrayList<>(ph));
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> e = new ArrayList<>();
    e.add(new ClassElement(Onset.class));
    return e;
  }

  @Override
  public AbstractStructure getRawStructure() {
    return new Onset(new ArrayList<>(getPhonemes()));
  }

}
