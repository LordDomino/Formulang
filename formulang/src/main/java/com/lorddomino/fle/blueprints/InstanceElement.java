package com.lorddomino.fle.blueprints;

import com.lorddomino.fle.types.AbstractComponent;

public class InstanceElement<E extends AbstractComponent<?>> extends AbstractBlueprintElement {

  public InstanceElement(AbstractComponent<?> instance) {
      super(instance, instance.getClass(), true);
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
    if (obj instanceof InstanceElement) {
      InstanceElement<?> object = (InstanceElement<?>) obj;
      if (this.getInstanceReference().equals(object.getInstanceReference())) {
        return true;
      }
    }
    return false;
  }
}
