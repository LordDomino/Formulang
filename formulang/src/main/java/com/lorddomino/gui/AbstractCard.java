package com.lorddomino.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.lorddomino.fle.types.AbstractComponent;

public abstract class AbstractCard<T extends AbstractComponent> extends JPanel {

  private T fleObject;
  private String cardLabel;
  private JLabel cardLabelComponent;

  private JPanel contentPane;
  private GridBagConstraints cPaneGbc = new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, getInsets(), 0, 0);

  public AbstractCard(T fleObj, String label) {
    this.fleObject = fleObj;
    this.cardLabel = label;
    this.cardLabelComponent = new JLabel(cardLabel);
    this.contentPane = new JPanel();
    prepComp();
    prepChildren();
    addComps();
  }

  public JPanel getContentPane() {
    return this.contentPane;
  }

  private void prepComp() {
    setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
    setLayout(new GridBagLayout());
  }

  private void prepChildren() {
    contentPane.setLayout(new GridBagLayout());
  }

  private void addComps() {
    final GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridheight = 1;
    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    super.add(cardLabelComponent, gbc);

    gbc.gridy++;
    super.add(contentPane, gbc);
  }

  public Component addStack(Component comp) {
    contentPane.add(comp, cPaneGbc);
    cPaneGbc.gridy++;
    return comp;
  }

}
