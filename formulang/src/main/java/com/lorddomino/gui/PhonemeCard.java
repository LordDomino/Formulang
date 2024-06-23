package com.lorddomino.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lorddomino.fle.phonology.Phoneme;

public class PhonemeCard extends AbstractCard<Phoneme> {

  private Phoneme phoneme;
  private JLabel basePhGlyphComp;
  private JPanel contentPane;
  private GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, getInsets(), 0, 0);

  // These components belong to the contentPane
  private JLabel basePhComp;
  private JLabel basePhSymbolComp;


  public PhonemeCard(Phoneme ph) {
    super(ph, ph.getFlePreview());
    this.phoneme = ph;
    genComps();
    addComps();
  }

  private void genComps() {
    basePhGlyphComp = new JLabel(phoneme.getBaseSymbol());
    contentPane = new JPanel(new GridBagLayout());

    basePhComp = new JLabel("Base allophone: " + phoneme.getBaseAllophone());
    basePhSymbolComp = new JLabel("Base allophone symbol: " + phoneme.getBaseSymbol());
  }

  private void addComps() {
    gbc.weightx = 0.25;
    getContentPane().add(basePhGlyphComp, gbc);

    gbc.weightx = 0.75;
    gbc.gridx++;
    getContentPane().add(contentPane, gbc);

    {
      GridBagConstraints contentPaneGbc = new GridBagConstraints();
      contentPaneGbc.gridheight = 1;
      contentPaneGbc.gridwidth = 1;
      contentPaneGbc.gridx = 0;
      contentPaneGbc.gridy = 0;
      contentPaneGbc.weightx = 1;
      contentPaneGbc.weighty = 1;
      contentPaneGbc.fill = GridBagConstraints.HORIZONTAL;
      contentPane.add(basePhComp, contentPaneGbc);

      contentPaneGbc.gridy++;
      contentPane.add(basePhSymbolComp, contentPaneGbc);
    }
  }
}
