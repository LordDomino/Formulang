package com.lorddomino.fle.exceptions;

public class InvalidFileException extends Exception {
  public InvalidFileException(String fname) {
    super("File located at " + fname + " is not a .fml file");
  }
}
