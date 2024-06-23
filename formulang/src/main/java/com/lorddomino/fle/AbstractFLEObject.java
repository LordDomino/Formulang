package com.lorddomino.fle;

import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.FlePreviewable;
import com.lorddomino.fle.blueprints.elements.ComponentBlueprintElement;

/**
 * The {@code AbstractFormulangReference} class represents all objects that run
 * or operate with the Formulang Language Engine. This class of objects include
 * objects that contain linguistic information, such as {@code Phoneme}s,
 * {@code Phone}s, {@code Syllable}s, and other categories related to language
 * creation; objects that allow referencing to other FLE objects, such as
 * {@code ComponentBlueprint}s and {@code ComponentBlueprintElement}s; and
 * possibly containers of such FLE objects, such as phonological inventories and
 * category sets.
 * <p>
 * Specifically, all objects and subtypes belonging to this class are capable of
 * <b>compliance</b> and <b>compatibility</b> comparisons which function
 * similarly to the {@code equals()} method in Java's {@code Object} class. A
 * practical inference through this class is that this extends the functionality
 * already provided by {@code equals()}, by adding customizations to how FLE
 * objects should interact with each other. Thus, in here several methods are
 * defined to facilitate the ability of FLE objects to be compared for
 * compliance and/or compatibility.
 * @author Loui Dominic Naquita
 */
public abstract class AbstractFLEObject implements FlePreviewable {

  @Override
  public String toString() {
    return getFlePreview();
  }

  /**
   * Checks if this FLE object is compliant to the given object {@code e}, that
   * is, by satisfying any of the conditions:
   * <ul><li>If this is an identical copy of {@code e}, or</li>
   * <li>If this is an instance of {@code e} when {@code e} is a class instead.
   * </li></ul>
   * Compliance is an extended feature for Java's {@code equals()} by supporting
   * inference for three additional object types: a class, a
   * {@code ComponentBlueprint}, and a {@code ComponentBlueprintElement}. These
   * three additional type-checks ensure that Formulang's compliance rules are
   * obeyed. This is also because all FLE objects are comparable with
   * referential FLE objects.
   * @param e the object to check compliance with
   * @return {@code true} if this is compliant to {@code e}, otherwise returns
   * {@code false}
   * @see ComponentBlueprint
   * @see ComponentBlueprintElement
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
   * Checks if this FLE object is a subclass of the given class {@code cls}. If
   * so, then this returns {@code true}, asserting compliance to the type,
   * otherwise this returns {@code false}, asserting incompliance to the type.
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
   * Checks if this FLE object is compatible to the given component blueprint
   * {@code bp} and if so, this returns {@code true}, otherwise this returns
   * {@code false}.
   * @param bp the component blueprint to check compatibility with
   * @return whether or not this object is compatible to the given component
   * blueprint
   * @implNote Implementation of this method varies between different subtypes
   * of the of the {@code AbstractFLEObject} class, though all implementations
   * must conform to the rules of component blueprint compatibility. All
   * subtypes inheriting from {@code AbstractFLEObject} class is, therefore,
   * treated as comparable with component blueprints because of the ability to
   * compare them through this method.
   * <p>
   * In case of classes or subtypes which should intentionally be
   * compatibility-incomparable with component blueprints, an explicit return
   * type of {@code false} should be implemented instead.
   */
  public abstract boolean isCompliantToBlueprint(ComponentBlueprint bp);
}
