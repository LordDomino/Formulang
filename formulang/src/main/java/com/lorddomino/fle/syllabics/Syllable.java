package com.lorddomino.fle.syllabics;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.VowelPhone;
import com.lorddomino.fle.types.AbstractComponent;
import com.lorddomino.fle.types.Structure;

public class Syllable extends Structure {

  public Syllable(AbstractComponent ... comps) {
    super(comps);
  }

  public Syllable(ArrayList<AbstractComponent> comps) {
    super(comps);
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> e = new ArrayList<>();
    e.add(new ClassElement(ConsonantPhone.class));
    e.add(new ClassElement(VowelPhone.class));
    e.add(new ClassElement(ConsonantPhone.class));
    return e;
  }

  @Override
  public Structure getRawStructure() {
    return new Syllable(new ArrayList<>(getPhonemes()));
  }

}
