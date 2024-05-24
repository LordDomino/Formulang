package com.lorddomino.fle.blueprints;

/**
 * Class for the {@code BlueprintElement} wrapper class.
 * <p>
 * A {@code BlueprintElement} object essentially wraps a
 * {@code ComponentBlueprint} object so it can be used for referencing when
 * finally operating on blueprint comparison and equality.
 * <p>
 * A {@code ComponentBlueprint} object can be wrapped around
 * {@code BlueprintElement} object through the following construction:
 * <pre>{@code
 * BlueprintElement bpe = new BlueprintElement(new ComponentBlueprint(...));
 * }</pre>
 * {@code BlueprintElement} objects always reference {@code ComponentBlueprint}
 * instances and, thus, calling {@code isReferencingInstance()} always returns
 * {@code true}.
 */
public class BlueprintElement<E extends ComponentBlueprint<?>> extends AbstractBlueprintElement {
  public BlueprintElement(E cbp) {
    super(cbp, cbp.getClassReference(), true);
  }
}
