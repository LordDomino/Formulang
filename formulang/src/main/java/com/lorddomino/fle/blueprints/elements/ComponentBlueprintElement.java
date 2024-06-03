package com.lorddomino.fle.blueprints.elements;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;

public class ComponentBlueprintElement<T> extends AbstractFormulangReference {

  private T defaultReference;

  public ComponentBlueprintElement(T defRef) {
    this.defaultReference = defRef;
  }

  @Override
  public boolean equals(Object o) {
    if (getDefaultReference().equals(o)) {
      return true;
    }
    if (o instanceof ComponentBlueprintElement) {
      if (getDefaultReference().equals(((ComponentBlueprintElement<?>) o).getDefaultReference())) {
        return true;
      }
    }
    if (o instanceof ComponentBlueprint) {
      if (((ComponentBlueprint) o).isSingletonBlueprint()
          && getDefaultReference().equals(((ComponentBlueprint) o).getFirst())) {
        return true;
      }
    }
    return false;
  }

  public T getDefaultReference() {
    return this.defaultReference;
  }

  @Override
  public String getFlePreview() {
    return "FLE preview to do";
  }

  @Override
  public boolean isCompatible(Object r) {
    /**
     * Because of the nature of ComponentBlueprintElement objects, compatibility
     * checking is always applied to its default reference rather than itself.
     * These methods are simply convenience methods to handle compatibility
     * checking when the default reference of the ComponentBlueprintElement is a
     * class and not an AbstractFormulangReference object.
     */

    // If r is also a ComponentBlueprintElement, then compatibility check should
    // take place between their class references.
    if (r instanceof ComponentBlueprintElement) {
      Object tRef = getDefaultReference();  // this' default reference
      Object rRef = ((ComponentBlueprintElement<?>) r).getDefaultReference();  // r's defaultReference

      // tRef is an instance, so it can be checked for compatibility with whatever
      // rRef is.
      if (tRef instanceof AbstractFormulangReference) {
        return (((AbstractFormulangReference) tRef).isCompatible(rRef));
      }

      // But if tRef is a class, it can only be checked for compatibility if
      // rRef is a class too.
      if (tRef instanceof Class && rRef instanceof Class) {
        return ((Class<?>) rRef).isAssignableFrom((Class<?>) tRef);
      }
    }

    // Otherwise, do generic compatibility checking through the supertype method
    if (super.isCompatible(r)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isCompatibleToClass(Class<?> cls) {

    if (getDefaultReference() instanceof Class) {
      if (cls.isAssignableFrom((Class<?>) getDefaultReference())) {
        return true;
      }
    }
    if (super.isCompatibleToClass(cls)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isCompatibleToBlueprint(ComponentBlueprint bp) {
    if (bp.size() == 1) {
      if (isCompatible(bp.getFirst())) {
        return true;
      }
    }
    return false;
  }
}
