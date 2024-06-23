package com.lorddomino.fle.syllabics;

import java.util.ArrayList;

import com.lorddomino.fle.AbstractFLEObject;
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
  public ArrayList<AbstractFLEObject> defineDefaultBlueprintElements() {
    ArrayList<AbstractFLEObject> e = new ArrayList<>();
    e.add(new ClassElement(Syllable.class));
    return e;
  }

}
