package com.lorddomino.fle.parsing;

public enum GrammarDefinitions {
  IPA_ID("SLASH LITERAL SLASH");

  private String[] definitions;

  private GrammarDefinitions(String ... definitions) {
    this.definitions = definitions;
  }

  public String[] getDefinitions() {
    return this.definitions;
  }

}
