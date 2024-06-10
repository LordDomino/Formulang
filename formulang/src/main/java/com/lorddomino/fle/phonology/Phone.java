package com.lorddomino.fle.phonology;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.blueprints.elements.InstanceElement;
import com.lorddomino.fle.ipa.IpaRegistry;
import com.lorddomino.fle.phonology.articulatoryproperties.ArticulatoryProperty;
import com.lorddomino.fle.types.TranscriptableComponent;

public abstract class Phone extends TranscriptableComponent {

  /**
   * Returns an ArrayList of the default IPA phone objects recognized and
   * utilized by the Formulang Language Engine.
   * @return the ArrayList of all default IPA phones
   */
  public static HashSet<Phone> getIpaDefaults() {
    return IpaRegistry.getPhones();
  }

  /**
   * Adds the given phone {@code pn} to the reference of all default IPA phone
   * objects recognized and utilized by the Formulang Language Engine.
   * @param pn the phone to add
   */
  public static void addToIpaDefaults(Phone pn) {
    IpaRegistry.registerPhone(pn);
  }

  /**
   * Removes the given phone {@code pn} from the registry of all default IPA
   * phone objects recognized and utilized by the Formulang Language Engine.
   * @param pn the phone to remove
   */
  public static void removeFromIpaDefaults(Phone pn) {
    IpaRegistry.unregisterPhone(pn);
  }

  /**
   * Internal instance field for the phone's symbol representation.
   */
  private String symbol;

  /**
   * Internal instance flag of whether or not the phone is a default
   * IPA phone based on the private reference
   * {@code Phone.IPA_DEFAULTS}.
   */
  private boolean isIpaDefault;

  private LinkedHashSet<ArticulatoryProperty> articulatoryProperties;

  /**
   *
   * @param symbol
   * @param isIpaDefault
 * @throws IncompliantException
   */
  public Phone(String symbol, boolean isIpaDefault, LinkedHashSet<ArticulatoryProperty> atcProps) {
    super(symbol, null, symbol);
    this.symbol = symbol;
    if (isIpaDefault) {
      addToIpaDefaults(this);
    }
    this.isIpaDefault  = isIpaDefault;
    this.articulatoryProperties = atcProps;
    processProperties();
    Objects.requireNonNull(symbol);
    Objects.requireNonNull(isIpaDefault);
  }

  public String getSymbol() {
    return this.symbol;
  }

  /**
   *
   * @return
   */
  public boolean isIpaDefault() {
    return isIpaDefault;
  }

  /**
   *
   * @param isIpaDefault
   */
  public void setIpaDefault(boolean isIpaDefault) {
    this.isIpaDefault = isIpaDefault;
    if (!this.isIpaDefault) {
      removeFromIpaDefaults(this);
    }
  }

  public boolean containsProperty(ArticulatoryProperty prop) {
    if (this.articulatoryProperties.contains(prop)) {
      return true;
    } else {
      return false;
    }
  }

  public LinkedHashSet<ArticulatoryProperty> getArticulatoryProperties() {
    return this.articulatoryProperties;
  }

  public void removeProperty(ArticulatoryProperty prop) {
    this.articulatoryProperties.remove(prop);
  }

  public void addProperty(ArticulatoryProperty prop) {
    this.articulatoryProperties.add(prop);
  }

  public void replaceArticulatoryProperty(ArticulatoryProperty oldProp, ArticulatoryProperty newProp) {
    removeProperty(oldProp);
    addProperty(newProp);
  }

  @Override
  public String processOutputStr(String outputStr) {
    return getSymbol();
  }

  @Override
  public String processIpaTranscript(String ipaTranscript) {
    if (ipaTranscript == null) {
      return "[" + this.getSymbol() + "]";
    } else {
      return "[" + ipaTranscript + "]";
    }
  }

  public String processFormulangTranscript(String formulangTranscript) {
    if (formulangTranscript == null) {
      return "[" + this.getSymbol() + "]";
    } else {
      return formulangTranscript;
    }
  }

  @Override
  public ComponentBlueprint processBlueprint(ComponentBlueprint bp) {
    return new ComponentBlueprint(new InstanceElement(this));
  }

  @Override
  public String processRomanization(String romanization) {
    return romanization;
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> e = new ArrayList<>();
    e.add(new ClassElement(Phone.class));
    return e;
  }

  public String getFlePreview() {
    if (isIpaDefault()) {
      return "<Phone " + this.getIpaTranscript() + " (IPA default)>";
    } else {
      return "<Phone " + this.getIpaTranscript() + ">";
    }
  }

  public String getDetailedFlePreview() {
    String detailedStr = "";
    for (ArticulatoryProperty prop : getArticulatoryProperties()) {
      detailedStr += " " + prop.toString();
    }
    return getFlePreview().substring(0, getFlePreview().length()-1) + detailedStr + ">";
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
    if (obj instanceof Phone) {
      Phone object = (Phone) obj;
      if (this.symbol == object.symbol) {
        return true;
      }
    }
    return false;
  }
}
