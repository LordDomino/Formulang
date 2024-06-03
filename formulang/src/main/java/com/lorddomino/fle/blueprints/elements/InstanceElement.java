package com.lorddomino.fle.blueprints.elements;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.types.AbstractComponent;

public class InstanceElement extends ComponentBlueprintElement<AbstractComponent<?>> {

  public InstanceElement(AbstractComponent<?> instance) {
    super(instance);
  }

  @Override
  public boolean isCompatible(Object r) {
    if (this.equals(r)) {  // r may be an identical copy of this cbp element
      return true;
    }
    if (r.equals(getDefaultReference())) {  // r may be an actual component, not just a cbp element
      return true;
    }
    if (r instanceof ComponentBlueprintElement) {
      return getDefaultReference().isCompatible(((ComponentBlueprintElement<?>) r).getDefaultReference());
    }
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof InstanceElement) {
      if (this.getDefaultReference().equals(((InstanceElement) obj).getDefaultReference())) {
        return true;
      }
    }
    if (obj instanceof AbstractFormulangReference) {
      if (this.getDefaultReference() == obj) {
        return true;
      }
    }
    return false;
  }
}
