package com.lorddomino.fle.syllabics;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.types.AbstractComponent;
import com.lorddomino.fle.types.AbstractStructure;

public abstract class Syllable extends AbstractStructure {

  public Syllable(AbstractComponent ... comps) {
    super(comps);
  }

  public Syllable(ArrayList<AbstractComponent> comps) {
    super(comps);
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> e = new ArrayList<>();
    e.add(new ClassElement(Syllable.class));
    return e;
  }

}
