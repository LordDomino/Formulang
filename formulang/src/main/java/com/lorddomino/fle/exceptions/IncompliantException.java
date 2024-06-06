package com.lorddomino.fle.exceptions;

import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.types.AbstractComponent;

public class IncompliantException extends Exception {
  public IncompliantException(AbstractComponent comp, ComponentBlueprint bp) {
    super("Component " + comp.getFlePreview() + " is incompliant to the blueprint " + bp.getFlePreview());
  }
}
