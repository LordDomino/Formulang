package com.lorddomino.fle.exceptions;

public class InvalidPropertyException extends Exception {
  public InvalidPropertyException(String message, Object prop, Object owner) {
    super("Invalid property '" + prop.toString() + "' of owner " + owner.toString());
  }
}
