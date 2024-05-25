package com.lorddomino.fle.phonology;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractBlueprintElement;
import com.lorddomino.fle.blueprints.ClassElement;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.InstanceElement;
import com.lorddomino.fle.types.TranscriptableComponent;

public class Phoneme extends TranscriptableComponent<Phoneme> {

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
  private ArrayList<Phone> allophones = new ArrayList<>();

  public Phoneme(Phone baseAllophone, String romanization) {
    super(baseAllophone.getOutputString(), null, null);
    this.baseAllophone = baseAllophone;
    this.baseSymbol = baseAllophone.getSymbol();
    this.allophones.add(baseAllophone);
    processProperties();
  }

  @Override
  public ArrayList<AbstractBlueprintElement> defineDefaultBlueprintElements() {
    ArrayList<AbstractBlueprintElement> e = new ArrayList<>();
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'equals'");

    /**
     * Method requirements for equality.
     *
     * Phoneme#equals() should be able to facilitate equality among same
     * phonemes that satisfy the following conditions:
     * a) Two identical phonemes which both contain the same identical values in
     *  their fields.
     * b) A phoneme compared against one of its allophones.
     *
     */
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
  public ComponentBlueprint<Phoneme> processBlueprint(ComponentBlueprint<Phoneme> bp) {
    return new ComponentBlueprint<>(new InstanceElement<Phoneme>(this));
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
}
