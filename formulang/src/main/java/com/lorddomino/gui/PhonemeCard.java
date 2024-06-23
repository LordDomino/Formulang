package com.lorddomino.gui;

import javax.swing.JLabel;

import com.lorddomino.fle.phonology.Phoneme;

public class PhonemeCard extends AbstractCard<Phoneme> {

  private Phoneme phoneme;
  private JLabel phLabel;

  public PhonemeCard(Phoneme ph) {
    super(ph, ph.getFlePreview());
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
