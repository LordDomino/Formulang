package com.lorddomino;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.ipa.IpaRegistryAssembler;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.gui.PhonemeCard;

public class GuiTest1 {

  public static void main(String[] args) {
    PhonemeCard phCard = new PhonemeCard(
      new Phoneme(IpaRegistryAssembler.CLOSEMID_BACK_ROUNDED, IpaRegistryAssembler.CLOSEMID_BACK_ROUNDED.getSymbol())
    );

    JFrame f = new JFrame("GUI card test");
    f.add(phCard);
    f.pack();
    f.setVisible(true);
  }
}
