package com.lorddomino.fle.types;

import java.util.ArrayList;
import java.util.Arrays;

import com.lorddomino.fle.blueprints.AbstractFormulangReference;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.elements.InstanceElement;
import com.lorddomino.fle.phonology.Phoneme;

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

  /**
   * Returns the components of this structure.
   * @return the arraylist of this structure's components
   */
  public ArrayList<AbstractComponent> getComponents() {
    return this.components;
  }

  public ArrayList<Phoneme> getPhonemes() {
    ArrayList<Phoneme> rl = new ArrayList<>();
    for (AbstractComponent comp : components) {
      if (comp instanceof Phoneme) {
        rl.add((Phoneme) comp);
      } else if (comp instanceof Structure ) {
        rl.addAll(((Structure) comp).getPhonemes());
      }
    }
    return rl;
  }

  /**
   * Returns the version of this object without the hierarchal preservation in
   * its structure.
   * @return a structure object with no nested substructures
   */
  public abstract Structure getRawStructure();

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
