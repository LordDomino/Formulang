package com.lorddomino.fle.types;

import java.util.ArrayList;
import java.util.Arrays;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.InstanceElement;

public abstract class Structure extends TranscriptableComponent {

  private ArrayList<AbstractComponent> components = new ArrayList<>();

  public Structure(String outStr, ComponentBlueprint bp, String fmlTrns, String ipaTrns, String rom) {
    super(outStr, bp, fmlTrns, ipaTrns, rom);
    processProperties();
  }

  public Structure(ArrayList<AbstractComponent> comps) {
    super(null);
    this.components = comps;
    processProperties();
  }

  public Structure(AbstractComponent ... comps) {
    super(null);
    this.components = new ArrayList<>(Arrays.asList(comps));
    processProperties();
  }

  @Override
  public String processOutputStr(String outputStr) {
    String o = "";
    for (AbstractComponent comp : getComponents()) {
      o += comp.getOutputStr();
    }
    return o;
  }

  @Override
  public ComponentBlueprint processBlueprint(ComponentBlueprint bp) {
    if (getComponents().size() == 0) {
      return getDefaultBlueprint();
    }
    ArrayList<AbstractFormulangReference> ae = new ArrayList<>();
    for (AbstractComponent absComp : getComponents()) {
      ae.add(new InstanceElement(absComp));
    }
    return new ComponentBlueprint(ae);
}

  @Override
  public String processFormulangTranscript(String formulangTranscript) {
    String fmlTrns = "";
    for (AbstractComponent comp : getComponents()) {
      fmlTrns = fmlTrns + comp.getFormulangTranscript() + ".";
    }
    fmlTrns = fmlTrns.substring(0, fmlTrns.length() - 1);
    return "{" + fmlTrns + "}";
  }

  @Override
  public String processIpaTranscript(String ipaTranscript) {
    return "TO DO";
  }

  @Override
  public String processRomanization(String romanization) {
    return "TO DO";
  }

  @Override
  public void processSpecificFields() {}

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof AbstractComponent && isCompliant(obj)) {
      return true;
    }
    return false;
  }

  @Override
  public String getFlePreview() {
    return "TO DO";
  }

  public ArrayList<AbstractComponent> getComponents() {
    return this.components;
  }

  @Override
  public boolean isCompliantToBlueprint(ComponentBlueprint bp) {
    if (getComponents().size() != bp.size()) {
      return false;
    }
    for (int i = 0; i < getComponents().size(); i++) {
      AbstractComponent comp = getComponents().get(i);
      AbstractFormulangReference sbp = bp.getElements().get(i);
      if (!comp.isCompliant(sbp)) {
        return false;
      }
    }
    return true;
  }

}
