package com.lorddomino.fle.phonology;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.types.TranscriptableComponent;

public class Allophone extends TranscriptableComponent {

  private Phone phone;

  public Allophone(Phone ph) {
    super(ph.getBlueprint());
    this.phone = ph;
  }

  @Override
  public ArrayList<AbstractFormulangReference> defineDefaultBlueprintElements() {
    ArrayList<AbstractFormulangReference> al = new ArrayList<>();
    al.add(new ClassElement(Allophone.class));
    return al;
  }

  @Override
  public void processSpecificFields() {}

  @Override
  public ComponentBlueprint processBlueprint(ComponentBlueprint bp) {
    return new ComponentBlueprint(phone);
  }

  @Override
  public String processFormulangTranscript(String fmlTrns) {
    return "";
  }

  @Override
  public String processIpaTranscript(String ipaTrns) {
    return "[" + phone.getSymbol() + "]";
  }

  @Override
  public String processRomanization(String rom) {
    return "Romanization for " + this + " is TO DO";
  }

  @Override
  public String processOutputStr(String outputStr) {
    return phone.getSymbol();
  }

  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'equals'");
  }

  @Override
  public String getFlePreview() {
    return "<Allophone " + this.getIpaTranscript() + ">";
  }

}
