package com.lorddomino.fle.types;

import com.lorddomino.fle.blueprints.ComponentBlueprint;

public abstract class TranscriptableComponent<E extends AbstractComponent<?>> extends AbstractComponent<E> {

  private String ipaTranscript;

  private String romanization;

  public TranscriptableComponent(String outputStr, ComponentBlueprint<E> bp, String formulangTrns) {
    super(outputStr, bp, formulangTrns);
  }

  public TranscriptableComponent(String outputStr, String formulangTrns, ComponentBlueprint<E> bp, String ipaTrns,
      String romanization) {
    super(outputStr, bp, formulangTrns);
    this.ipaTranscript = ipaTrns;
    this.romanization = romanization;
  }

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

  public void processProperties() {
    setBlueprint(processBlueprint(getBlueprint()));
    setFormulangTranscript(processFormulangTranscript(getFormulangTranscript()));
    setIpaTranscript(processIpaTranscript(ipaTranscript));
    setRomanization(processRomanization(romanization));
  }

  public abstract ComponentBlueprint<E> processBlueprint(ComponentBlueprint<E> bp);

  public abstract String processFormulangTranscript(String formulangTranscript);

  public abstract String processIpaTranscript(String ipaTranscript);

  public abstract String processRomanization(String romanization);

}
