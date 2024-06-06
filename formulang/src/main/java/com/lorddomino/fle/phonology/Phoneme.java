package com.lorddomino.fle.phonology;

import java.util.ArrayList;
import java.util.HashSet;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.blueprints.elements.InstanceElement;
import com.lorddomino.fle.phonology.articulatoryproperties.ArticulatoryProperty;
import com.lorddomino.fle.types.TranscriptableComponent;

public class Phoneme extends TranscriptableComponent {

  private static final ArrayList<Phoneme> IPA_DEFAULTS = new ArrayList<>();

  public static ArrayList<Phoneme> getIpaDefaults() {
    return IPA_DEFAULTS;
  }

  public static void addToIpaDefaults(Phoneme pm) {
    IPA_DEFAULTS.add(pm);
  }

  public static void removeFromIpaDefaults(Phoneme pm) {
    IPA_DEFAULTS.remove(pm);
  }

  private Phone baseAllophone;
  private String baseSymbol;
  private HashSet<Phone> allophones = new HashSet<>();

  public Phoneme(Phone baseAllophone, String romanization) {
    super(baseAllophone.getOutputStr(), null, null);
    this.baseAllophone = baseAllophone;
    this.baseSymbol = baseAllophone.getSymbol();
    this.allophones.add(baseAllophone);
    processProperties();
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> e = new ArrayList<>();
    e.add(new ClassElement(Phoneme.class));
    return e;
  }

  @Override
  public String processIpaTranscript(String ipaTranscript) {
    if (ipaTranscript == null) {
      return "/" + this.getBaseSymbol() + "/";
    } else {
      return "/" + ipaTranscript + "/";
    }
  }

  @Override
  public String processRomanization(String romanization) {
    return romanization;
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
    if (obj instanceof Phoneme) {
      Phoneme object = (Phoneme) obj;
      if (this.getBaseSymbol() == object.getBaseSymbol()) {
        return true;
      }
    } else if (obj instanceof Phone) {
      Phone object = (Phone) obj;
      for (Phone allophone : this.getAllophones()) {
        if (object.equals(allophone)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public String processFormulangTranscript(String formulangTranscript) {
    if (formulangTranscript == null) {
      return "/" + this.getBaseSymbol() + "/";
    } else {
      return formulangTranscript;
    }
  }

  @Override
  public ComponentBlueprint processBlueprint(ComponentBlueprint bp) {
    return new ComponentBlueprint(new InstanceElement(this));
  }

  public HashSet<Phone> getAllophones() {
    return allophones;
  }

  public Phone getBaseAllophone() {
    return baseAllophone;
  }

  public String getBaseSymbol() {
    return baseSymbol;
  }

  @Override
  public String getFlePreview() {
    return "<Phoneme " + this.getIpaTranscript() + ">";
  }

  /**
   * Returns {@code true} if this phoneme's base allophone is a consonant,
   * otherwise returns {@code false}.
   * @return
   */
  public boolean isConsonant() {
    if (getBaseAllophone() instanceof ConsonantPhone) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns {@code true} if this phoneme's base allophone is a vowel, otherwise
   * returns {@code false}.
   * @return
   */
  public boolean isVowel() {
    if (getBaseAllophone() instanceof VowelPhone) {
      return true;
    } else {
      return false;
    }
  }

  public boolean containsProperty(ArticulatoryProperty prop) {
    if (getBaseAllophone().containsProperty(prop)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void processSpecificFields() {}
}
