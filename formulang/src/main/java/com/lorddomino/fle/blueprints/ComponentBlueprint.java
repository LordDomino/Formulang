package com.lorddomino.fle.blueprints;

import java.util.ArrayList;

import com.lorddomino.fle.AbstractFLEObject;

/**
 * The class for all {@code ComponentBlueprint} objects.
 * <p>
 * A {@code ComponentBlueprint} is an object that stores an array of
 * references to other FLE objects. This array is used to define the internal
 * structure of an {@code AbstractComponent} that uses it.
 */
public class ComponentBlueprint extends AbstractFLEObject {

  private ArrayList<AbstractFLEObject> elements;

  /**
   * Creates a {@code ComponentBlueprint} object containing exactly one element
   * reference. When created, this component blueprint is guaranteed to be a
   * <b>singleton</b> because it contains exactly a single FLE object reference.
   * @param element the element reference
   */
  public ComponentBlueprint(AbstractFLEObject element) {
    super();
    final ArrayList<AbstractFLEObject> al = new ArrayList<>();
    al.add(element);
    this.elements = al;
  }

  /**
   * Creates a {@code ComponentBlueprint} object containing the provided
   * ArrayList of elements as its recognized sub-components.
   * @param elements the array list of elements
   */
  public ComponentBlueprint(ArrayList<AbstractFLEObject> elements) {
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
        ArrayList<AbstractFLEObject> curList = this.getElements();
        ArrayList<AbstractFLEObject> objList = object.getElements();
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
  public ArrayList<AbstractFLEObject> getElements() {
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
  public AbstractFLEObject get(int index) throws IndexOutOfBoundsException {
    AbstractFLEObject obj;
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
  public AbstractFLEObject getFirst() {
    return getElements().get(0);
  }

  /**
   * Returns the last element of this component blueprint.
   */
  public AbstractFLEObject getLast() {
    return getElements().get(size()-1);
  }

  /**
   * Returns the number of elements of this component blueprint.
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
      if (elements.get(0) instanceof ComponentBlueprint) {
        return ((ComponentBlueprint) elements.get(0)).isSingletonBlueprint();
      } else {
        return true;
      }
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
    }
    return false;
  }
}
