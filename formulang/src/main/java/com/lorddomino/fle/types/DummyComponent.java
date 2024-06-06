package com.lorddomino.fle.types;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;

public class DummyComponent extends AbstractComponent {

  public DummyComponent(ComponentBlueprint repBp) {
    super("", repBp, "$");
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    return null;
  }

  @Override
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
      AbstractComponent object = (AbstractComponent) obj;
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

@Override
public boolean isCompliant(Object e) {
  return true;
}
}
