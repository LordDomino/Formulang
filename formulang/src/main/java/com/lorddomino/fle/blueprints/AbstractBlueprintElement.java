package com.lorddomino.fle.blueprints;

/**
 * The {@code AbstractBlueprintElement} class represents all blueprint element
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
public abstract class AbstractBlueprintElement implements FlePreviewable {

  private AbstractBlueprintElement instanceReference;
  private Class<? extends AbstractBlueprintElement> classReference;
  private boolean isReferencingSubBlueprint;
  private boolean isReferencingInstance;

  public AbstractBlueprintElement(AbstractBlueprintElement object, Class<? extends AbstractBlueprintElement> classRef,
      boolean isReferencingInstance) {
    this.instanceReference = object;
    this.classReference = classRef;
    this.isReferencingInstance = isReferencingInstance;
    if (isObjNull(object)) {
      this.isReferencingInstance = false;
      this.isReferencingSubBlueprint = false;
    } else {
      if (isObjCbp(object)) {
        this.isReferencingSubBlueprint = true;
      } else {
        this.isReferencingSubBlueprint = false;
      }
    }
    if (isClsNull(classRef)) {
      this.classReference = this.getClass();
    }
  }

  /**
   * Creates an {@code AbstractBlueprintElement} object that assigns itself as
   * its instance reference by default. Since no specified class reference is
   * given, the constructor retrieves it by acquiring this instance's class.
   * <p>
   * Constructing with this unparameterized constructor is typically redundant
   * and only effectively works on default {@code super()} calls on subclasses
   * of the {@code AbstractBlueprintElement} class.
   */
  public AbstractBlueprintElement() {
    this.instanceReference = this;
    this.classReference = this.getClass();
  }

  /**
   * Creates an {@code AbstractBlueprintElement} object that accepts the
   * specified {@code object} as its instance reference and {@code object}'s
   * class as the class reference.
   * @param object an {@code AbstractBlueprintElement} instance for reference
   * @deprecated
   */
  @Deprecated
  public AbstractBlueprintElement(AbstractBlueprintElement object) {
    this.instanceReference = object;
    this.classReference = object.getClass();
    this.isReferencingSubBlueprint = isObjCbp(object);
    if (this.isReferencingSubBlueprint) {
      this.isReferencingInstance = false;
    } else {
      this.isReferencingInstance = true;
    }
  }

  /**
   * @deprecated
   */
  @Deprecated
  public AbstractBlueprintElement(Class<? extends AbstractBlueprintElement> classRef) {
    this.classReference = classRef;
    this.isReferencingSubBlueprint = false;
    this.isReferencingInstance = false;
  }

  /**
   * Returns the associated instance reference of this
   * {@code AbstractBlueprintElement} object, otherwise returns {@code null}.
   * @return the instance reference
   */
  public AbstractBlueprintElement getInstanceReference() {
    return instanceReference;
  }

  /**
   * Returns the associated class reference of this
   * {@code AbstractBlueprintElement} object.
   * @return the class reference
   */
  public Class<? extends AbstractBlueprintElement> getClassReference() {
    return classReference;
  }

  @Override
  public String getFlePreview() {
    if (instanceReference != null) {
      return "<" + getClass().getSimpleName() + " instanceReference=" + instanceReference + ">";
    } else {
      return "<" + getClass().getSimpleName() + " classReference=" + classReference.getSimpleName() + ">";
    }
  }

  /**
   * Returns {@code true} if this object is referencing an instance, otherwise
   * returns {@code false}.
   */
  public boolean isReferencingInstance() {
    return isReferencingInstance;
  }

  /**
   * Returns {@code true} if this blueprint element is referencing a class,
   * otherwise returns {@code false}.
   */
  public boolean isReferencingClass() {
    return !isReferencingInstance;
  }

  /**
   * Returns {@code true} if this blueprint element is referencing a
   * {@code ComponentBlueprint} object, otherwise returns {@code false}.
   */
  public boolean isReferencingSubBlueprint() {
    return isReferencingSubBlueprint;
  }

  @Override
  public String toString() {
    return getFlePreview();
  }

  /**
   * Returns {@code true} if {@code obj} is an instance of
   * {@code ComponentBlueprint}, otherwise returns {@code false}.
   * @param obj the {@code AbstractBlueprintElement} object to check
   */
  private boolean isObjCbp(AbstractBlueprintElement obj) {
    if (obj instanceof ComponentBlueprint) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns {@code true} if {@code obj} is null, otherwise returns
   * {@code false}.
   * @param obj the {@code AbstractBlueprintElement} object to check
   */
  private boolean isObjNull(AbstractBlueprintElement obj) {
    if (obj == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns {@code true} if {@code cls} is null, otherwise returns
   * {@code false}.
   * @param cls the class of type {@code AbstractBlueprintElement} to check
   */
  private boolean isClsNull(Class<? extends AbstractBlueprintElement> cls) {
    if (cls == null) {
      return true;
    } else {
      return false;
    }
  }
}

