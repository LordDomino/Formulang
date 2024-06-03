package com.lorddomino.fle.types;

import java.util.Objects;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.DefaultBlueprintConstructor;

public abstract class AbstractComponent<E extends AbstractComponent<?>> extends AbstractFormulangReference
    implements DefaultBlueprintConstructor {

  /**
   * The string representation of the object.
   */
  private String outputString;

  /**
   * The FLE representation of the object.
   */
  private String formulangTranscript;

  /**
   * The attached component blueprint of the object.
   */
  private ComponentBlueprint blueprint;

  public AbstractComponent(String outputStr, ComponentBlueprint bp, String formulangTrns) {
    this.outputString = outputStr;
    this.blueprint = initializeBlueprint(bp);
    this.formulangTranscript = formulangTrns;
    Objects.requireNonNull(this.blueprint);
  }

  @Override
  public abstract boolean equals(Object obj);

  @Override
  public abstract String getFlePreview();

  /**
   * Returns the output string of this component.
   * @return the output string
   */
  public String getOutputString() {
    return outputString;
  }

  /**
   * Sets the output string of this component.
   * @param outputString the output string
   */
  public void setOutputString(String outputString) {
    this.outputString = outputString;
  }

  /**
   * Returns the Formulang transcript of this component.
   * @return the Formulang transcript
   */
  public String getFormulangTranscript() {
    return formulangTranscript;
  }

  /**
   * Sets the Formulang transcript of this component to the given
   * string.
   * @param formulangTranscript the string to set the Formulang
   * transcript to
   */
  public void setFormulangTranscript(String formulangTranscript) {
    this.formulangTranscript = formulangTranscript;
  }

  /**
   * Returns the default blueprint of this component.
   * @return the default blueprint
   */
  public ComponentBlueprint getDefaultBlueprint() {
    return constructDefaultBlueprint();
  }

  private ComponentBlueprint initializeBlueprint(ComponentBlueprint blueprint) {
    if (blueprint == null) {
      return constructDefaultBlueprint();
    } else {
      return blueprint;
    }
  }

  /**
   * Returns the associated component blueprint of this component.
   * @return the component blueprint
   */
  public ComponentBlueprint getBlueprint() {
    return blueprint;
  }

  /**
   * Explicitly sets the component blueprint for this component. It is
   * allowed to override or modify the existing blueprint of a
   * component but it must conform to the default blueprint of the
   * component's class.
   * @param blueprint the new component blueprint
   */
  public void setBlueprint(ComponentBlueprint blueprint) {
    this.blueprint = initializeBlueprint(blueprint);
  }

  @Override
  public boolean isCompatibleToBlueprint(ComponentBlueprint bp) {
    if (bp.isSingletonBlueprint() && isCompatible(bp.getFirst())) {
      return true;
    }
    return false;
  }

}
