package com.lorddomino.fle.parsing.nodes;

import java.util.ArrayList;

public abstract class AbstractTreeNode {

  private ArrayList<AbstractTreeNode> subnodes;

  public AbstractTreeNode(ArrayList<AbstractTreeNode> subnodes) {
    this.subnodes = subnodes;
  }

  public ArrayList<AbstractTreeNode> getSubnodes() {
    return this.subnodes;
  }

}
