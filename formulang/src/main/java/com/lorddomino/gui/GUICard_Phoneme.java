package com.lorddomino.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lorddomino.fle.phonology.Phoneme;

public class GUICard_Phoneme extends JPanel {

  private Phoneme phoneme;
  private JLabel phLabel;

  public GUICard_Phoneme(Phoneme ph) {
    super();
    this.phoneme = ph;
    genComps();
    bindComps();
    prepare();
  }

  private void genComps() {
    phLabel = new JLabel(phoneme.getBaseSymbol());
  }

  private void bindComps() {
    add(phLabel);
  }

  private void prepare() {

  }
}
