package com.lorddomino;

import javax.swing.JFrame;

import com.lorddomino.fle.ipa.IpaRegistry;
import com.lorddomino.fle.ipa.IpaRegistryAssembler;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.gui.PhonemeCard;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
      JFrame f = new JFrame();
      PhonemeCard phGui = new PhonemeCard(new Phoneme(IpaRegistryAssembler.VOICED_BILABIAL_PLOSIVE, "o"));
      f.add(phGui);
      f.setSize(200, 200);
      f.setVisible(true);
    }
}
