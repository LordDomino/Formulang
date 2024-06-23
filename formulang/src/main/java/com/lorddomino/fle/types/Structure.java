package com.lorddomino.fle.types;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
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
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> e = new ArrayList<>();
    e.add(new ClassElement(Structure.class));
    return e;
  }

  @Override
  public AbstractStructure getRawStructure() {
    return this;
  }

}
