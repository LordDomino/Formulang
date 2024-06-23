package com.lorddomino;

import javax.swing.JFrame;

import com.lorddomino.fle.ipa.IpaRegistry;
import com.lorddomino.fle.ipa.IpaRegistryAssembler;
import com.lorddomino.fle.phonology.Phoneme;
import com.lorddomino.gui.GUICard_Phoneme;

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
      GUICard_Phoneme phGui = new GUICard_Phoneme(new Phoneme(IpaRegistryAssembler.VOICED_BILABIAL_PLOSIVE, "o"));
      f.add(phGui);
      f.setSize(200, 200);
      f.setVisible(true);
    }
}
