package com.lorddomino.fle.types;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;

public class DummyComponent extends AbstractComponent<AbstractComponent<?>> {

    public DummyComponent(ComponentBlueprint repBp) {
        super("", repBp, "$");
    }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    return null;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    if (obj instanceof AbstractComponent) {
      AbstractComponent<AbstractComponent<?>> object = (AbstractComponent<AbstractComponent<?>>) obj;
      if (this.getBlueprint().equals(object.getBlueprint())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String getFlePreview() {
    return "<DummyComponent $>";
  }
}
