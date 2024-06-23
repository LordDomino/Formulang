package com.lorddomino.fle.syllabics;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.fle.types.AbstractStructure;
import com.lorddomino.fle.types.Structure;

public class Coda extends AbstractStructure {

  public Coda(Phoneme ... ph) {
    super(ph);
  }

  public Coda(ArrayList<Phoneme> ph) {
    super(new ArrayList<>(ph));
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> e = new ArrayList<>();
    e.add(new ClassElement(Nucleus.class));
    return e;
  }

  @Override
  public AbstractStructure getRawStructure() {
    return new Structure(getPhonemes());
  }

}
