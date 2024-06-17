package com.lorddomino.fle.parsing;

import com.lorddomino.fle.parsing.nodes.AbstractTreeNode;

public class ParseTree {

  private AbstractTreeNode rootNode;

  public ParseTree(AbstractTreeNode rootNode) {
    this.rootNode = rootNode;
  }

  @Override
  public String toString() {
    return rootNode.toString();
  }

  public AbstractTreeNode getRootNode() {
    return this.rootNode;
  }

}
