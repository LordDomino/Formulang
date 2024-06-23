package com.lorddomino.gui;

import javax.swing.JPanel;

import com.lorddomino.fle.types.AbstractComponent;

public abstract class AbstractCard<T extends AbstractComponent> extends JPanel {

  private T fleObject;
  private String cardLabel;

  public AbstractCard(T fleObj, String cardLabel) {
    this.fleObject = fleObj;
    this.cardLabel = cardLabel;
  }

}
