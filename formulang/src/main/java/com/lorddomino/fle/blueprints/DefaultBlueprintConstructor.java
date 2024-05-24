package com.lorddomino.fle.blueprints;

import java.util.ArrayList;

import com.lorddomino.fle.types.AbstractComponent;

public interface DefaultBlueprintConstructor<E extends AbstractComponent<?>> {

  /**
   * Constructs and returns a default component blueprint for this
   * component. The generated blueprint is an alternative if the
   * provided blueprint is {@code null} in the constructor.
   * @return the constructed component blueprint
   */
  default ComponentBlueprint<E> constructDefaultBlueprint() {
    return new ComponentBlueprint<>(defineDefaultBlueprintElements());
  }

  /**
   * Returns an ArrayList of default blueprint elements defined in
   * this object.
   * @return ArrayList of default blueprint elements
   */
  public abstract ArrayList<AbstractBlueprintElement> defineDefaultBlueprintElements();
}
