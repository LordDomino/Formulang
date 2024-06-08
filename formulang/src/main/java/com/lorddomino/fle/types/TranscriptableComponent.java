package com.lorddomino.fle.types;

import com.lorddomino.fle.blueprints.ComponentBlueprint;

public abstract class TranscriptableComponent extends AbstractComponent {

  /**
   * The IPA transcription of this object based on the transcription rules of
   * the International Phonetic Alphabet.
   */
  private String ipaTranscript;

  /**
   * The romanized version of this component (if applicable).
   */
  private String romanization;

  public TranscriptableComponent() {
    super(null);
  }

  public TranscriptableComponent(ComponentBlueprint bp) {
    super(bp);
  }

  public TranscriptableComponent(String outputStr, ComponentBlueprint bp, String fmlTrns) {
    super(outputStr, bp, fmlTrns);
  }

  public TranscriptableComponent(String outputStr, ComponentBlueprint bp, String formulangTrns, String ipaTrns,
      String romanization) {
    super(bp);
    this.ipaTranscript = ipaTrns;
    this.romanization = romanization;
  }

  public void processProperties() {
    processSpecificFields();
    processCommonFields();
  }

  private void processCommonFields() {
    setOutputStr(processOutputStr(getOutputStr()));
    setBlueprint(processBlueprint(getBlueprint()));
    setFormulangTranscript(processFormulangTranscript(getFormulangTranscript()));
    setIpaTranscript(processIpaTranscript(ipaTranscript));
    setRomanization(processRomanization(romanization));
  }

  /**
   * Interface method where subclass-specific processor methods are called. This
   * abstract method is explicitly invoked along with the
   * {@code processCommonFields()} method when {@code processProperties()} is
   * called.
   */
  public abstract void processSpecificFields();

  /**
   * Returns the actual blueprint of this component given the initial ingredient
   * blueprint {@code bp}.
   * @param bp the initial blueprint supplied during object instantiation
   * @return the actual blueprint of this component
   */
  public abstract ComponentBlueprint processBlueprint(ComponentBlueprint bp);

  /**
   * Returns the actual Formulang transcript of this component given the initial
   * ingredient Formulang transcript {@code fmlTrns}.
   * @param fmlTrns the initial Formulang transcript supplied during object
   * instantiation
   * @return the actual Formulang transcript of this component
   */
  public abstract String processFormulangTranscript(String fmlTrns);

  /**
   * Returns the actual IPA transcription of this component given the initial
   * ingredient IPA transcript {@code ipaTrns}.
   * @param ipaTrns the initial IPA transcription supplied during object
   * instantiation
   * @return the actual IPA transcription of this component
   */
  public abstract String processIpaTranscript(String ipaTrns);

  /**
   * Returns the actual Romanization of this component given the initial
   * ingredient Romanization {@code rom}.
   * @param rom the initial Romanization supplied during object instantiation
   * @return the actual Romanization of this component
   */
  public abstract String processRomanization(String rom);

  public abstract String processOutputStr(String outputStr);

  public String getIpaTranscript() {
    return ipaTranscript;
  }

  public void setIpaTranscript(String ipaTranscript) {
    this.ipaTranscript = ipaTranscript;
  }

  public String getRomanization() {
    return romanization;
  }

  public void setRomanization(String romanization) {
    this.romanization = romanization;
  }
}
