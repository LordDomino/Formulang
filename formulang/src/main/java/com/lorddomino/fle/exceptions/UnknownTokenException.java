package com.lorddomino.fle.exceptions;

public class UnknownTokenException extends Exception {
  public UnknownTokenException(String literal) {
    super("Literal \"" + literal + "\" does not match any token definitions");
  }
}
