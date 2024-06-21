package com.lorddomino.fle.syllabics;

import com.lorddomino.fle.types.AbstractStructure;
import com.lorddomino.fle.types.Structure;

public final class ONCSyllable extends Syllable {

  public ONCSyllable(Onset onset, Nucleus nucleus, Coda coda) {
    super(onset, nucleus, coda);
  }

  @Override
  public AbstractStructure getRawStructure() {
    return new Structure(getPhonemes());
  }

}
