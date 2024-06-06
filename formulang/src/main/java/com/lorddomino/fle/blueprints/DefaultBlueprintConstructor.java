package com.lorddomino.fle.blueprints;

import java.util.ArrayList;

/**
 * Interface that provides helper methods essential in the default
 * initialization of component blueprints in many Formulang object types. Two
 * helper methods belong to this interface, one for the default definition of
 * FLE object types and another for the construction of the defined default
 * blueprint.
 * <p>
 * This interface provides a default constructor method
 * {@code constructDefaultBlueprint()} that simply creates and returns a new
 * {@code ComponentBlueprint} object based on the ArrayList returned by
 * {@code defineDefaultBlueprintElements()}. This interface also supports
 * singleton construction based on the ArrayList returned by the latter method.
 */
public interface DefaultBlueprintConstructor {

  /**
   * Constructs and returns a default component blueprint for this component.
   * The generated blueprint is an alternative if the provided blueprint is
   * {@code null} in the constructor.
   * @return the constructed component blueprint
   */
  default ComponentBlueprint constructDefaultBlueprint() {
    ArrayList<AbstractFormulangReference> elements = defineDefaultBlueprintElements();
    if (elements.size() == 1) {
      return new ComponentBlueprint(elements.get(0));
    } else {
      return new ComponentBlueprint(elements);
    }
  }

  /**
   * Returns an ArrayList of default blueprint elements defined in this object.
   * @return ArrayList of default blueprint elements
   */
  public abstract ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements();
}
