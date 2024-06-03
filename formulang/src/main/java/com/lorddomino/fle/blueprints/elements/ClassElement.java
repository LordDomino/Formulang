package com.lorddomino.fle.blueprints.elements;

import com.lorddomino.fle.types.AbstractComponent;

/**
 * The {@code ClassElement} class allows wrapping of class references into
 * blueprint element objects. {@code ClassElement} instances can then be used by
 * {@code ComponentBlueprint} objects to refer to actual classes or types.
 */
public class ClassElement extends ComponentBlueprintElement<Class<? extends AbstractComponent<?>>> {

  /**
   * Creates a {@code ClassElement} object which contains only a pure class
   * reference. {@code ClassElement} objects therefore contain no instance
   * references and their default reference only point to the provided type.
   * @param classRef the class reference
   */
  public ClassElement(Class<? extends AbstractComponent<?>> classRef) {
    super(classRef);
  }

  @Override
  public boolean isCompatible(Object r) {
    if (r == null) {
      return false;
    }
    if (r instanceof InstanceElement && getDefaultReference().isInstance(((InstanceElement) r).getDefaultReference())) {
      return true;
    }
    if (r instanceof ClassElement && getDefaultReference().isAssignableFrom(((ClassElement) r).getDefaultReference())) {
      return true;
    }
    if (r instanceof SubBlueprintElement) {
      return isCompatible(((SubBlueprintElement) r).getDefaultReference());
    }
    if (getDefaultReference().isInstance(r)) {
      return true;
    }
    return false;
  }
}
