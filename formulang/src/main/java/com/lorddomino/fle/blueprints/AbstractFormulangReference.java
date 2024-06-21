package com.lorddomino.fle.blueprints;

import com.lorddomino.fle.blueprints.elements.ComponentBlueprintElement;

/**
 * The {@code AbstractFormulangReference} class represents all blueprint element
 * objects essential to the Formulang Language Engine. This is also a wrapper
 * class to encapsulate component instances, class references, and other
 * component blueprint objects which are essential for the creation of
 * {@code ComponentBlueprint} objects.
 * <p>
 * A blueprint element object is a reference representing either an instance,
 * the class, or both an instance and the class of the component object it
 * points to. Thus, it is called a blueprint element because it complements a
 * component object and serves as a descriptor to the component object’s
 * internal hierarchy.
 * <p>
 * Constructors of the {@code AbstractBlueprintElement} class always eventually
 * initialize a class reference value in its {@code classReference} field. By
 * default, only a class reference is given as the blueprint object’s reference.
 * @author Loui Dominic Naquita
 */
public abstract class AbstractFormulangReference implements FlePreviewable {

  /**
   * Creates an {@code AbstractBlueprintElement} object that assigns itself as
   * its instance reference by default. Since no specified class reference is
   * given, the constructor retrieves it by acquiring this instance's class.
   * <p>
   * Constructing with this unparameterized constructor is typically redundant
   * and only effectively works on default {@code super()} calls on subclasses
   * of the {@code AbstractBlueprintElement} class.
   */
  public AbstractFormulangReference() {}

  @Override
  public String toString() {
    return getFlePreview();
  }

  /**
   * Returns {@code true} if this object is equivalent to or is compliant to the
   * given object {@code e}, otherwise returns {@code false}.
   * @param e the object to compare compliance
   */
  public boolean isInstanceCompliant(AbstractFormulangReference e) {
    if (this == e) {
      return true;
    }
    if (e == null) {
      return false;
    }
    return false;
  }

  /**
   * Checks if this Formulang reference is compliant to the given object
   * {@code e}, that is if this is an identical copy of {@code e} or if this is
   * an instance of {@code e} if it is a class instead.
   * @param e the object to check compliance with
   * @return {@code true} if this is compliant to {@code e}, otherwise returns
   * {@code false}
   */
  public boolean isCompliant(Object e) {
    if (this.equals(e)) {
      return true;
    }
    if (e instanceof Class && isCompliantToClass((Class<?>) e)) {
      return true;
    }
    if (e instanceof ComponentBlueprint && isCompliantToBlueprint((ComponentBlueprint) e)) {
      return true;
    }
    if (e instanceof ComponentBlueprintElement && isCompliant(((ComponentBlueprintElement<?>) e).getDefaultReference())) {
      return true;
    }
    return false;
  }

  /**
   * Checks if this Formulang reference is a subclass of the given class
   * {@code cls}. If so, then this returns {@code true}, asserting compliance,
   * otherwise this returns {@code false}, asserting incompliance with the given
   * type.
   * @param cls the class to check compatibility with
   * @return whether or not this object is an instance of the given class
   */
  public boolean isCompliantToClass(Class<?> cls) {
    if (cls.isInstance(this)) {
      return true;
    }
    return false;
  }

  /**
   * Checks if this Formulang reference is compatible to the given component
   * blueprint {@code bp} and if so, this returns {@code true}, otherwise this
   * returns {@code false}.
   * @param bp the component blueprint to check compatibility with
   * @return whether or not this object is compatible to the given component
   * blueprint
   * @implNote Implementation of this method varies between different subclasses
   * of the AbstractFormulangReference class, though all implementations must
   * conform to the rules of component blueprint compatibility. All subclasses
   * inheriting from AbstractFormulangReference class is, therefore, treated as
   * comparable with component blueprints because of the ability to compare them
   * through this method. In case of classes or Formulang object types which
   * should intentionally be compatibility-incomparable with component
   * blueprints, an explicit return type of false should be implemented instead.
   */
  public abstract boolean isCompliantToBlueprint(ComponentBlueprint bp);
}
