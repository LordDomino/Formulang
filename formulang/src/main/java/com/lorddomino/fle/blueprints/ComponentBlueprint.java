package com.lorddomino.fle.blueprints;

import java.util.ArrayList;

public class ComponentBlueprint extends AbstractFormulangReference {

  private ArrayList<AbstractFormulangReference> elements;

  /**
   * Creates a {@code ComponentBlueprint} object containing exactly one element
   * reference as its recognized sub-components.
   * @param element the element reference
   */
  public ComponentBlueprint(AbstractFormulangReference element) {
    super();
    final ArrayList<AbstractFormulangReference> al = new ArrayList<>();
    al.add(element);
    this.elements = al;
  }

  /**
   * Creates a {@code ComponentBlueprint} object containing the provided
   * ArrayList of elements as its recognized sub-components.
   * @param elements the array list of elements
   */
  public ComponentBlueprint(ArrayList<AbstractFormulangReference> elements) {
    super();
    this.elements = elements;
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
    if (obj instanceof ComponentBlueprint) {
      ComponentBlueprint object = (ComponentBlueprint) obj;
      if (this.size() != object.size()) {
        return false;
      } else {
        ArrayList<AbstractFormulangReference> curList = this.getElements();
        ArrayList<AbstractFormulangReference> objList = object.getElements();
        for (int i = 0; i < this.size(); i++) {
          if (!curList.get(i).equals(objList.get(i))) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the elements of this component blueprint.
   * @return the elements of this component blueprint.
   */
  public ArrayList<AbstractFormulangReference> getElements() {
    return elements;
  }

  @Override
  public String getFlePreview() {
    return "<ComponentBlueprint " + elements + ">";
  }

  /**
   * Returns the element at given index {@code index}.
   * @param index the index of the element
   */
  public AbstractFormulangReference get(int index) throws IndexOutOfBoundsException {
    AbstractFormulangReference obj;
    try {
      obj = getElements().get(index);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for this component blueprint");
    }
    return obj;
  }

  /**
   * Returns the first element of this component blueprint.
   */
  public AbstractFormulangReference getFirst() {
    return getElements().get(0);
  }

  /**
   * Returns the last element of this component blueprint.
   */
  public AbstractFormulangReference getLast() {
    return getElements().get(size()-1);
  }

  /**
   * Returns the number of elements this component blueprint has.
   */
  public int size() {
    return getElements().size();
  }

  /**
   * Returns true if this {@code ComponentBlueprint} object contains exactly one
   * element reference as its sub-component.
   * @return whether or not this object contains exactly one element reference
   */
  public boolean isSingletonBlueprint() {
    if (elements.size() == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isCompliantToBlueprint(ComponentBlueprint bp) {
    if (bp.size() != this.size()) {
      return false;
    }
    for (int i = 0; i < this.size(); i++) {
      if (!elements.get(i).isCompliant(bp.elements.get(i))) {
        return false;
      }
      return true;
    }
    return false;
  }
}
