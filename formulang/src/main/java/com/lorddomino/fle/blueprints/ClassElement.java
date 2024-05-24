package com.lorddomino.fle.blueprints;

import com.lorddomino.fle.types.AbstractComponent;

public class ClassElement extends AbstractBlueprintElement {

  public ClassElement(Class<? extends AbstractComponent<?>> classRef) {
    super(null, classRef, false);
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
    if (obj instanceof ClassElement) {
      ClassElement object = (ClassElement) obj;
      if (this.getClassReference().equals(object.getClassReference())) {
        return true;
      }
    }
    return false;
  }
}
