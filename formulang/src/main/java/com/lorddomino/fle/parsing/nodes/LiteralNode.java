package com.lorddomino.fle.parsing.nodes;

import java.util.ArrayList;

public abstract class LiteralNode extends AbstractTreeNode {

  private String literal;

  public LiteralNode(String literal) {
    super(new ArrayList<>());
    this.literal = literal;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + literal;
  }

  public String getLiteral() {
    return this.literal;
  }

}
