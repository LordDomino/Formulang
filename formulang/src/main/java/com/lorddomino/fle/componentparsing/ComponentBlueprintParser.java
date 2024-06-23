package com.lorddomino.fle.componentparsing;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.exceptions.CbpUnparsableException;
import com.lorddomino.fle.syllabics.ONCSyllable;
import com.lorddomino.fle.syllabics.Syllable;
import com.lorddomino.fle.types.AbstractComponent;

public class ComponentBlueprintParser {

  private int seqPos;
  private ArrayList<AbstractComponent> components;
  private ArrayList<AbstractComponent> nextComps;
  private AbstractComponent currentComp;

  public ComponentBlueprintParser(ArrayList<AbstractComponent> comps) {
    this.seqPos = -1;
    this.components = comps;
    this.nextComps = getNextComps(1);
    this.currentComp = null;
  }

  /**
   * Returns the components of this parser.
   * @return
   */
  public ArrayList<AbstractComponent> getComponents() {
    return this.components;
  }

  /**
   * Retrieves components that are ahead of the current component given the
   * {@code ahead} number of components.
   * @param ahead
   * @return
   */
  private ArrayList<AbstractComponent> getNextComps(int ahead) {
    ArrayList<AbstractComponent> rl = new ArrayList<>();
    int curAhead = 0;
    try {
      while (curAhead < ahead) {
        curAhead += 1;
        rl.add(this.components.get(this.seqPos + curAhead));
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("No more components ahead due to IndexOutOfBoundsException");
    }
    return rl;
  }

  /**
   * Resets this parser to its default state as it was initialized.
   */
  private void reset() {
    this.seqPos = -1;
    this.nextComps = getNextComps(1);
    this.currentComp = null;
  }

  public ComponentBlueprint parseBlueprint() throws CbpUnparsableException, Exception {
    ComponentBlueprint cbp = rawParse();
    reset();

    return cbp;
  }

  private ComponentBlueprint rawParse() throws CbpUnparsableException, Exception {
    if (nextComps.size() == 0) {
      throw new CbpUnparsableException();
    } else {
      Syllable sigma = parseSyllable();
      if (seqPos < components.size() - 2) {
        throw new Exception("Leftover, token unknown " + nextComps.get(0));
      } else {
        return new ComponentBlueprint(sigma);
      }
    }
  }

  private Syllable parseSyllable() {
    return new ONCSyllable(null, null, null);
  }

}
