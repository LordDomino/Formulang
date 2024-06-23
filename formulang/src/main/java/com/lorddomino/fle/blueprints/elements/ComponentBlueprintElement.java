package com.lorddomino.fle.blueprints.elements;

import com.lorddomino.fle.AbstractFLEObject;
import com.lorddomino.fle.blueprints.ComponentBlueprint;

/**
 * A blueprint element object is a reference representing either an instance,
 * the class, or both an instance and the class of the component object it
 * points to. Thus, it is called a blueprint element because it complements a
 * component object and serves as a descriptor to the component object’s
 * internal hierarchy.
 */
public abstract class ComponentBlueprintElement<T> extends AbstractFLEObject {

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

  public String toString() {
    return getDefaultReference().toString();
  }

  public T getDefaultReference() {
    return this.defaultReference;
  }

  @Override
  public String getFlePreview() {
    return "FLE preview to do";
  }

  @Override
  public boolean isCompliant(Object r) {
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
      if (tRef instanceof AbstractFLEObject) {
        return (((AbstractFLEObject) tRef).isCompliant(rRef));
      }

      // But if tRef is a class, it can only be checked for compatibility if
      // rRef is a class too.
      if (tRef instanceof Class && rRef instanceof Class) {
        return ((Class<?>) rRef).isAssignableFrom((Class<?>) tRef);
      }
    }

    // Otherwise, do generic compatibility checking through the supertype method
    if (super.isCompliant(r)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isCompliantToClass(Class<?> cls) {

    if (getDefaultReference() instanceof Class) {
      if (cls.isAssignableFrom((Class<?>) getDefaultReference())) {
        return true;
      }
    }
    if (super.isCompliantToClass(cls)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isCompliantToBlueprint(ComponentBlueprint bp) {
    if (bp.size() == 1) {
      if (isCompliant(bp.getFirst())) {
        return true;
      }
    }
    return false;
  }
}
