package com.lorddomino.fle.blueprints.elements;

import com.lorddomino.fle.blueprints.ComponentBlueprint;

/**
 * Class for the {@code BlueprintElement} wrapper class.
 * <p>
 * A {@code BlueprintElement} object essentially wraps a
 * {@code ComponentBlueprint} object so it can be used for referencing when
 * finally operating on blueprint comparison and equality.
 * <p>
 * A {@code ComponentBlueprint} object can be wrapped around
 * {@code BlueprintElement} object through the following initialization:
 * <pre>{@code
 * BlueprintElement bpe = new BlueprintElement(new ComponentBlueprint(...));
 * }</pre>
 * {@code BlueprintElement} objects always reference {@code ComponentBlueprint}
 * instances and, thus, calling {@code isReferencingInstance()} always returns
 * {@code true}.
 */
public class SubBlueprintElement extends ComponentBlueprintElement<ComponentBlueprint> {
  public SubBlueprintElement(ComponentBlueprint cbp) {
    super(cbp);
  }
}
