package com.lorddomino.fle.parsing;

public class Token {

  private String literal;
  private TokenDefinitions tokenType;

  public Token(String literal, TokenDefinitions tokenType) {
    this.literal = literal;
    this.tokenType = tokenType;
  }

  @Override
  public String toString() {
    return tokenType.toString() + " " + getLiteral();
  }

  public String getLiteral() {
    return this.literal;
  }

  public TokenDefinitions getTokenType() {
    return this.tokenType;
  }
}
