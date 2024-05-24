package com.lorddomino.fle.blueprints;

import java.util.ArrayList;

public class ComponentBlueprint<E extends AbstractBlueprintElement> extends AbstractBlueprintElement {

  private ArrayList<AbstractBlueprintElement> elements;

  /**
   * Creates a {@code ComponentBlueprint} object containing exactly
   * one element reference as its recognized sub-components.
   * @param element the element reference
   */
  public ComponentBlueprint(AbstractBlueprintElement element) {
    super(element, element.getClassReference(), true);
    final ArrayList<AbstractBlueprintElement> al = new ArrayList<>();
    al.add(element);
    this.elements = al;
  }

  /**
   * Creates a {@code ComponentBlueprint} object containing the
   * provided elements as its recognized sub-components. Its
   * sub-components must be an instance of the superclass
   * AbstractComponent.
   * @param instanceElements the array list of elements
   */
  public ComponentBlueprint(ArrayList<AbstractBlueprintElement> elements) {
    super(null, null, false);
    this.elements = elements;
  }

  /**
   * Returns the elements of this component blueprint.
   * @return the elements of this component blueprint.
   */
  public ArrayList<AbstractBlueprintElement> getElements() {
    return elements;
  }

  @Override
  public String getFlePreview() {
    return "<ComponentBlueprint [elements=" + elements + ">";
  }

  @Override
  public Class<? extends AbstractBlueprintElement> getClassReference() {
    if (isSingletonBlueprint()) {
      return elements.get(0).getClassReference();
    } else {
      return super.getClassReference();
    }
  }

  @Override
  public AbstractBlueprintElement getInstanceReference() {
    if (isSingletonBlueprint()) {
      return elements.get(0).getInstanceReference();
    } else {
      return super.getInstanceReference();
    }
  }

  /**
   * Returns true if this {@code ComponentBlueprint} object contains
   * exactly one element reference as its sub-component.
   * @return whether or not this object contains exactly one element
   * reference
   */
  private boolean isSingletonBlueprint() {
    if (elements.size() == 1) {
      return true;
    } else {
      return false;
    }
  }

}
