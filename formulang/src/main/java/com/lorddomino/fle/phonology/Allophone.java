package com.lorddomino.fle.phonology;

import java.util.ArrayList;

import com.lorddomino.fle.AbstractFLEObject;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.types.TranscriptableComponent;

public class Allophone extends TranscriptableComponent {

  private Phone phone;

  public Allophone(Phone ph) {
    this.phone = ph;
  }

  @Override
  public ArrayList<AbstractFLEObject> defineDefaultBlueprintElements() {
    ArrayList<AbstractFLEObject> al = new ArrayList<>();
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
    return phone.getFormulangTranscript();
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
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj instanceof Allophone) {
      if (((Allophone) obj).getPhone() == getPhone()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String getFlePreview() {
    return "<" + this.getClass().getSimpleName() + this.getIpaTranscript() + ">";
  }

  public Phone getPhone() {
    return this.phone;
  }

}
