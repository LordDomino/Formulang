package com.lorddomino.fle.types;

import java.util.Objects;

import com.lorddomino.fle.AbstractFLEObject;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.DefaultBlueprintConstructor;
import com.lorddomino.fle.exceptions.IncompliantException;

public abstract class AbstractComponent extends AbstractFLEObject
    implements DefaultBlueprintConstructor {

  /**
   * The string representation of the object.
   */
  private String outputStr;

  /**
   * The FLE representation of the object.
   */
  private String formulangTranscript;

  /**
   * The attached component blueprint of the object.
   */
  private ComponentBlueprint blueprint;

  public AbstractComponent(ComponentBlueprint bp) {
    try {
      this.blueprint = initializeBlueprint(bp);
    } catch (IncompliantException e) {
      e.printStackTrace();
      this.blueprint = constructDefaultBlueprint();
    }
    Objects.requireNonNull(this.blueprint);
  }

  public AbstractComponent(String outputStr, ComponentBlueprint bp, String formulangTrns) {
    this.outputStr = outputStr;
    try {
      this.blueprint = initializeBlueprint(bp);
    } catch (IncompliantException e) {
      e.printStackTrace();
      this.blueprint = constructDefaultBlueprint();
    }
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
  public String getOutputStr() {
    return outputStr;
  }

  /**
   * Sets the output string of this component.
   * @param outputStr the output string
   */
  public void setOutputStr(String outputStr) {
    this.outputStr = outputStr;
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
   * @param fmlTrns the string to set the Formulang
   * transcript to
   */
  public void setFormulangTranscript(String fmlTrns) {
    this.formulangTranscript = fmlTrns;
  }

  /**
   * Returns the default blueprint of this component.
   * @return the default blueprint
   */
  public ComponentBlueprint getDefaultBlueprint() {
    return constructDefaultBlueprint();
  }

  private ComponentBlueprint initializeBlueprint(ComponentBlueprint bp) throws IncompliantException {
    if (bp == null) {
      return constructDefaultBlueprint();
    } else if (this.isCompliantToBlueprint(bp)) {
      return bp;
    } else {
      throw new IncompliantException(this, bp);
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
   * @param bp the new component blueprint
   */
  public void setBlueprint(ComponentBlueprint bp) {
    try {
      this.blueprint = initializeBlueprint(bp);
    } catch (IncompliantException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean isCompliantToBlueprint(ComponentBlueprint bp) {
    if (bp.isSingletonBlueprint() && isCompliant(bp.getFirst())) {
      return true;
    }
    return false;
  }

}
