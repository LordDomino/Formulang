package com.lorddomino.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lorddomino.fle.types.AbstractComponent;

public abstract class AbstractCard<T extends AbstractComponent> extends JPanel {

  private T fleObject;
  private String cardLabel;
  private JLabel cardLabelComponent;

  public AbstractCard(T fleObj, String label) {
    this.fleObject = fleObj;
    this.cardLabel = label;
    this.cardLabelComponent = new JLabel(cardLabel);
    prepLayout();
    addCardLabelComp();
  }

  private void prepLayout() {
    setLayout(new GridBagLayout());
  }

  private void addCardLabelComp() {
    final GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(cardLabelComponent, gbc);
  }

}
